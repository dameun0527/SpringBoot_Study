package com.thesun4sky.querymapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thesun4sky.querymapping.mapper.UserMapper;

@SpringBootApplication
public class QueryMappingApplication {
	public static void main(String[] args) {
		// 어플리케이션 실행 컨텍스트 생성
		var context = SpringApplication.run(QueryMappingApplication.class, args);
		// 데이터 조회 클래스 빈 조회
		var mapper = context.getBean(UserMapper.class);

		// 유저정보 조회
		mapper.add("Teasun Kim");
		// 유저정보 조회
		System.out.println("User : " + mapper.findById(2L)); // data.sql 에서 미리 저장된것이 하나 있어서 2번
	}

}
