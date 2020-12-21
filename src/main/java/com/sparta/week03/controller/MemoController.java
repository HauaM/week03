package com.sparta.week03.controller;

import com.sparta.week03.Service.MemoService;
import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    private final MemoRepository repository;

    @PostMapping("/api/memos")
    public Memo post(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return repository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> get(){
        return repository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long delete(@PathVariable Long id){
        repository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long put(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id,requestDto);
    }
}
