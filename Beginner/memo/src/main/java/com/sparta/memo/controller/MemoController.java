package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.service.MemoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RESTful 웹 서비스를 처리하는 컨트롤러 명시
// API 만들때 사용
@RestController

// 기본 URL 경로 지정
// 클래스 선언 -> 모든 메소드가 /api 경로로 시작하는 요청을 처리
@RequestMapping("/api")
public class MemoController {

    private final JdbcTemplate jdbcTemplate;

    public MemoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // HTTP POST 요청을 처리하는 메소드
    // 주로 데이터를 서버에 생성, 전송할 때 사용
    // 새로운 메모를 생성하는 역할
    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.createMemo(requestDto);
    }

    // HTTP Get 요청 처리하는 메소드
    // /api/memos 경로로 오는 GET 요청 처리
    // 주로 데이터 조화할 때 사용. 모든 메모를 리스트로 반환하는 역할
    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.getMemos();
    }

    // HTTP PUT 메소드 정의
    // 기존 메모를 수정하는데 사용
    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.updateMemo(id, requestDto);
    }

    // HTTP DELETE 요청 처리하는 메소드
    // 특정 ID의 메모를 삭제하는데 사용
    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.deleteMemo(id);
    }

}