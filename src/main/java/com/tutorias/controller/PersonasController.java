/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.controller;

/**
 *
 * @author fabia
 */

import com.tutorias.entity.Pais;
import com.tutorias.entity.Persona;
import com.tutorias.service.IPaisService;
import com.tutorias.service.IPersonaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class PersonasController {
    
    @Autowired
    private IPersonaService personaService;
    
    @Autowired
    private IPaisService paisService;
    
    @GetMapping("/personas")
    public String index(Model model){
    
        List<Persona> listaPersonas=personaService.getAllPerson();
        model.addAttribute("titulo","Personas");
        model.addAttribute("personas", listaPersonas);
        return "personas";
    
    }
    
    @GetMapping("/personasN")
    public String crearPersona(Model model){
    
        List<Pais> listaPais = paisService.listCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPais);
        
        return "crear";
    
    }
    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona){
    
        personaService.savePerson(persona);
        return "redirect:/personas";
        
    }
    
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model){
    
        Persona persona = personaService.getPersonById(idPersona);
        List<Pais> listaPais = paisService.listCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPais);
        
        return "crear";
    
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long id){
    
        personaService.delete(id);
        return "redirect:/personas";
    
    }
    
    @RequestMapping("/stats")
    public ModelAndView statsADMIN() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("estadisticas");
        return modelAndView;
    }
    
    @RequestMapping("/homePROF")
    public ModelAndView homePROF() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homePROF");
        return modelAndView;
    }
    
    @RequestMapping("/homeSTUD")
    public ModelAndView homeSTUD() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homeSTUD");
        return modelAndView;
    }
    
    @RequestMapping("/reservaSTUD")
    public ModelAndView reservaSTUD() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reservaSTUD");
        return modelAndView;
    }
    
    @RequestMapping("/bibliotecaSTUD")
    public ModelAndView bibliotecaSTUD() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bibliotecaSTUD");
        return modelAndView;
    }
    
    @RequestMapping("/calendarioPROF")
    public ModelAndView calendarioPROF() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calendarioPROF");
        return modelAndView;
    }
    
    @RequestMapping("/horarioPROF")
    public ModelAndView horarioPROF() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("horarioPROF");
        return modelAndView;
    }
    
}
