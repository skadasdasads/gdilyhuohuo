package com.ohgiraffers.restapi.responseentity.controller;

import com.ohgiraffers.restapi.responseentity.dto.PokemonDTO;
import com.ohgiraffers.restapi.responseentity.service.PokemonService;
import lombok.extern.flogger.Flogger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PokemonController {

    /*          http 요청메서드
     * C create Post
     * R read   Get
     * U update Put
     * D delete Delete
     * */

    // Post Mapping 포켓몬 등록
    @PostMapping("/api/v1/pokemon")
    public String registNewPokemon(@RequestBody PokemonDTO pokemonDTO) {

        PokemonService.registNewPokemon(newPokemon);

        return "redireect:/pokemon/list";
    }
}