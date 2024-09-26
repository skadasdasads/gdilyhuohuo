package com.ohgiraffers.restapi.responseentity;

import com.ohgiraffers.restapi.responseentity.dto.PokemonDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;

@RestController
@RequestMapping("/entity")
public class ResponseEntityTestController {

    // ResponseEntity : 결과 데이터 HTTP 상태 코드를 직접 제어 할 수 있는 클래스, HttpStatus, HttpHeaders, HttpBody를 포함하고 있다. => 우리가 응답의 상태코드, 헤더, 바디를 작성할때 좀 더 다양한 상황에 적절시 대응 할 수 있게 해준다.

    // JPA
    // spirng MVC 모델에서

    // Entity
    // -> 컨트롤러와 데이터베이스가 데이터를 주고받을때 사용

    // Controller
    // ->사용자 요청을 처리하고, 모델과 뷰 사이를 연결

    // Service
    // ->비즈니스 로직을 처리하고, 데이터를 가공

    // Repository
    // ->데이터베이스에서 데이터를 가져오거나 저장한다.

    // HTTP 메서드
    // CRUD
    // C : Create 데이터베이스에 추가하는 기능으로 데이터베이스에 새로운 데이터를 생성합니다. SQL 관계형 데이터베이스에서 사용되는 경우 Create를 INSERT라고 합니다 .
    // 최종 사용자에게 새로운 데이터 행을 생성하고 이전에 저장된 데이터가 새 데이터베이스 와 쉽게 상호작용할수 있는 권한을 부여합니다.
    // R : Read 데이터베이스에서 데이터를 조회하는 기능입니다. 데이터베이스에서 데이터를 읽어오는 작업으로, 특정 조건을 만족하는 데이터를 조회하거나, 전체 데이터를 가져오는 작업입니다.
    // SELECT 쿼리를 사용하여 데이터를 읽어옵니다.
    // U : Update 데이터베이스에서 기존 데이터를 수정하는 기능입니다. HTTP 메서드로는 PUT 또는 PATCH 입니다. 특정 사용자의 정보를 업데이트 하는 경우 업데이트
    // D : Delete 데이터베이스에서 데이터를 삭제하는 작업입니다. 특정 레코드를 삭제하거나, 테이블에서 전체 데이터를 삭제할 수 있습니다. DELETE 쿼리를 사용하여 데이터를 삭제합니다.
    // 어떤것들이 있고, 각각이 어떤 요청들을 수행하는지


    // pokemon 정보를 전체 조회 합니다.
    @GetMapping("/pokemons")
    public ResponseEntity<ResponseMessage> findAllPokemons() {

        // 헤더 부분을 말합니다.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                new MediaType("application", "json",
                        Charset.forName("UTF-8")
                )
        );

        // 서비스 메소드 호출해 pokemon 조회하기

        // 바디 부분을 말합니다.
        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("pokemons", pokemons);

        ResponseMessage responseMessage = new ResponseMessage(

                200, "조회성공!", responseMap);


        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);

    }

    @GetMapping("/pokemons/{pokemonNo}")
    public ResponseEntity<ResponseMessage> findPokemonByNo(@PathVariable int pokemonNo) {

        // 헤더 부분을 말합니다.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));


        // 바디부분을 말합니다. PathVar
//        PokemonDTO foundPokemon = pokemons.stream().filter(pokemon -> pokemon.getNo() == pokemonNo).toList().get(0);

        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("pokemon", foundPokemon);

        // 메소드 체이닝
        return ResponseEntity.ok().headers(headers).body(new ResponseMessage(200, "조회성공", responseMap));
    }

    // 포켓몬을 추가한다.
    @PostMapping("/pokemons")
    public ResponseEntity<?> regist(@RequestBody PokemonDTO newPokemon) {

        System.out.println("newPokemon = " + newPokemon);


        // 마지막에 위치한 포켓몬 번호를 말합니다.
//        int latPokemonNo = pokemons.get(pokemons.size() - 1).getNo();


        // 마지막에 위치한 포켓몬 정보 +1를 말한다.
//        newPokemon.setNo(latPokemonNo + 1);


        // 포켓몬 추가
//        pokemons.add(newPokemon);



        return ResponseEntity.ok().build();
        // restfull
        // 201 상태코드 -> 등록 관련(생성)






    }




    // 포켓몬 수정
    @PutMapping("/pokemons/{pokemonNo}")
    public ResponseEntity<?> modifyPokemon(@PathVariable int pokemonNo, @RequestBody PokemonDTO modifyInfo) {


        // 수정할 포켓몬 정보 찾아오기
        PokemonDTO foundPokemon = pokemons.stream().filter(pokemon -> pokemon.getNo() == pokemonNo).toList().get(0);



        // 수정할 정보를 ReqeustBody로 받아서 Name, Type, Name 수정
        foundPokemon.setName(modifyInfo.getName());
        foundPokemon.setType(modifyInfo.getType());
        foundPokemon.setName(modifyInfo.getName());

        return ResponseEntity.created(URI.create("/entity/pokemons/" + pokemons)).build();
    }


    // 포켓몬 삭제
    @DeleteMapping("/pokemons/{pokemonNo}")
    public ResponseEntity<?> removePokemon(@PathVariable int pokemonNo) {

        PokemonDTO foundPokemon = pokemons.stream().filter(pokemon -> pokemon.getNo() == pokemonNo).toList().get(0);
        pokemons.remove(foundPokemon);

        return ResponseEntity.noContent().build();
    }

}
