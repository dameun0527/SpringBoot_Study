package com.sparta.springprepare;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
// 기본 생성자
@NoArgsConstructor
public class Memo {
    private String username;
    private String contents;

}

class Main {
    public static void main(String[] args) {
        Memo memo = new Memo("Robbert","내용");
        memo.setUsername("Jack");
        System.out.println(memo.getUsername());
    }
}