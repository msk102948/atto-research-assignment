package com.project.assignment.controller;

import com.project.assignment.dto.request.MakeHostReq;
import com.project.assignment.dto.request.UpdateHostReq;
import com.project.assignment.dto.response.GetHostRes;
import com.project.assignment.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class MainController {
    private final MainService mainService;

    // 한 호스트 조회
    @GetMapping("/host/{name}")
    public ResponseEntity<GetHostRes> getHost(@PathVariable String name) throws IOException {
        return mainService.getHost(name);
    }

    // 전체 호스트 조회
    @GetMapping("/hosts")
    public ResponseEntity<List<GetHostRes>> getAllHosts() throws IOException {
        return mainService.getAllHost();
    }

    // 새로운 호스트 생성
    @PostMapping("/host")
    public ResponseEntity makeHost(@RequestBody MakeHostReq makeHostReq){
        return mainService.makeHost(makeHostReq);
    }

    // 호스트 수정
    @PutMapping("/host/{name}")
    public ResponseEntity updateHost(@PathVariable String name, @RequestBody UpdateHostReq updateHostReq){
        return mainService.updateHost(name, updateHostReq);
    }

    // 호스트 삭제
    @DeleteMapping("/host/{name}")
    public ResponseEntity deleteHost(@PathVariable String name){
        return mainService.deleteHost(name);
    }

}
