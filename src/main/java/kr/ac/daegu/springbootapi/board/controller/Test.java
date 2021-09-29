package kr.ac.daegu.springbootapi.board.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Test<T> {
    private String status;
    private T data; // wild card : 어떤 클래스던 받을 수 있는 제네릭

    public Test(String status, T data) {
        this.status = status;
        this.data = data;
    }
}
