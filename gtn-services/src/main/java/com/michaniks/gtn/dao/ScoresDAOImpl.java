package com.michaniks.gtn.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.michaniks.gtn.entities.Score;

@Stateless
public class ScoresDAOImpl implements ScoresDAO {
	
	@PersistenceContext(name = "gtn-pu")
	private EntityManager em;
	
	@Override
	public void save(Score s) {
		em.persist(s);
	}
	
	@Override
	public List<Score> getAll() {
		String sql = "select s from Score s";
		TypedQuery<Score> query = em.createQuery(sql, Score.class);
		return query.getResultList();
	}
}
