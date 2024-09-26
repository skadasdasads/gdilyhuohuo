package com.ohgiraffers.restapi.responseentity.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@ToString
//@Entity JPA에서 엔티티란, DB테이블에 대응하는 하나의 클래스라 생각@Entity가 붙은 클래스는 JPA가 관리해주며, JPA를 사용해서 DB테이블과 매핑할 클래스는 @Entity를 꼭 붙여야만 매핑가능
//@Table 엔티티와 매핑할 테이블 지정
//@NoArgsConstructor : 파라미터(매개변수)가 없는 생성자를 생성한다.
//@AllArgsConstructor 모든 필드를 파라미터(매개변수)로 갖는 생성자를 생성한다.
//@Getter code가 컴파일 될 때 getter 메서드들을 생성한다.
//@ToString toString() 메서드를 생성한다.
//@Setter code가 컴파일 될 때 setter 메서드들을 생성한다.
public class PokemonEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "pokemon_name")
    private String name;


    @Column(name = "pokemon_no")
    private int type;

    @Column(name = "pokemon_property")
    private String property;


    public PokemonEntity() {
    }

    public PokemonEntity(int no, String name, int type, String property) {
        this.no = no;
        this.name = name;
        this.type = type;
        this.property = property;
    }
}