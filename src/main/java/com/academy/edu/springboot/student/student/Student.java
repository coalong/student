package com.academy.edu.springboot.student.student;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@EqualsAndHashCode
// ? 이게 뭐지?
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
