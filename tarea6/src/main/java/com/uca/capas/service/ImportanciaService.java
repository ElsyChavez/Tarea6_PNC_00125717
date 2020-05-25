package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Importancia;

@Service
public interface ImportanciaService {

	public List<Importancia> findAll() throws DataAccessException;
	
	public Importancia findOne(Integer code) throws DataAccessException;
	
}
