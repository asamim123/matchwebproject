package com.sport.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sport.entities.PlayerEntity;


@Repository
@Transactional
public class PlayerRepository {
	private EntityManager entityManager;
	
	public PlayerEntity save(PlayerEntity player) {
		return entityManager.merge(player);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
