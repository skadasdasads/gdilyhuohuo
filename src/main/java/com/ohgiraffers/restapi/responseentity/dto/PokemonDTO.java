package com.ohgiraffers.restapi.responseentity.dto;

import java.time.LocalDate;

public class PokemonDTO {

    private int no;
    private String name;
    private int type;
    private int property;

    public PokemonDTO() {

    }

    public PokemonDTO(int no, String name, int type, int property) {
        this.no = no;
        this.name = name;
        this.type = type;
        this.property = property;
    }

    public PokemonDTO(int i, String pokemon01, String test03, String 피카츄, LocalDate now) {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "PokemonDTO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", property=" + property +
                '}';
    }
}


//Entity
//Entity란 DB에 영구적으로 저장된 데이터(record)를 자바 객체로 매핑하여 인스턴스 형태로
//존재하는 데이터를 의미합니다. Entity는 실제 DB의 테이블과 매핑되는 클래스이므로 자주 변경되면 여러 클래스에 영향을 미칠 수 있습니다. 따라서 View와 통신하는 DTO 클래스와
//구분하여 구현함으로써 View와 DB를 Layer를 분리할 수 있습니다.