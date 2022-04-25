/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tutorias.service;

/**
 *
 * @author fabia
 */

import com.tutorias.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> getAllPerson();
    public void savePerson(Persona persona);
    public Persona getPersonById(long id);
    public void delete(long id);
    public Persona findByNombre (String nombre);
    
}
