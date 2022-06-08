package com.academy.edu.springboot.student;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@EqualsAndHashCode
/**
 * equals :  두 객체의 내용이 같은지, 동등성(equality) 를 비교하는 연산자
 * hashCode : 두 객체가 같은 객체인지, 동일성(identity) 를 비교하는 연산자
 */
@AllArgsConstructor
//setter로 계속 넣기 싫어서 올아규먼트 추가
@NoArgsConstructor
// 엔티티로 만들때는 불변상태 만들수없다.
public class Student {

    @Id
    private Long id;
    private String name;
    private int score;

}
