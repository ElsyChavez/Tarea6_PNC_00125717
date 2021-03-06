package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Contribuyente;

@Component
public class ContribuyenteDAOImpl implements ContribuyenteDAO{
	
	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(),Contribuyente.class);
		List<Contribuyente> resulset = query.getResultList();
		
		return resulset;
	}

	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		entityManager.persist(contribuyente);
	}
	

}
