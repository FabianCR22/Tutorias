/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.service;

import com.tutorias.entity.Pais;
import com.tutorias.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.tutorias.service.IPaisService;

/**
 *
 * @author fabia
 */
@Service
public class PaisService implements IPaisService{
    
    @Autowired
    private PaisRepository paisRepository;
    
    @Override
    public List<Pais> listCountry(){

        return (List<Pais>) paisRepository.findAll();
    
    }
    
}
