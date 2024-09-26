package com.ohgiraffers.restapi.responseentity.repository;

import com.ohgiraffers.restapi.responseentity.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
