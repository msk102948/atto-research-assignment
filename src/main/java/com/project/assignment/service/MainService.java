package com.project.assignment.service;

import com.project.assignment.dto.request.MakeHostReq;
import com.project.assignment.dto.request.UpdateHostReq;
import com.project.assignment.dto.response.GetHostRes;
import com.project.assignment.model.Host;
import com.project.assignment.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final HostRepository hostRepository;

    // 한 호스트 조회
    @Transactional
    public ResponseEntity<GetHostRes> getHost(String name) throws IOException {
        return ResponseEntity.ok(checkHost(name));
    }

    // 전체 호스트 조회
    @Transactional
    public ResponseEntity<List<GetHostRes>> getAllHost() throws IOException {
        List<GetHostRes> getHostResList = new ArrayList<>();
        List<Host> allHosts = hostRepository.findAll();
        for (Host host : allHosts) {
            getHostResList.add(checkHost(host.getName()));
        }

        return ResponseEntity.ok(getHostResList);
    }

    // Response Dto 생성용 method
    private GetHostRes checkHost(String name) throws IOException {
        Host host = hostRepository.findByName(name);
        InetAddress pingCheck = InetAddress.getByName(host.getIp());
        boolean isAlive = pingCheck.isReachable(1000);

        if(host.getRecentAlive() == null){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String recentAliveAt = now.format(formatter);
            host.setRecentAlive(recentAliveAt);
        }

        GetHostRes getHostRes = new GetHostRes(host, isAlive);

        return getHostRes;
    }

    // 새로운 호스트 생성
    public ResponseEntity makeHost(MakeHostReq makeHostReq) {
        Host host = new Host(makeHostReq);
        if(hostRepository.countAllBy()>99){
            throw new InternalError();
        }
        hostRepository.save(host);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 호스트 수정
    @Transactional
    public ResponseEntity updateHost(String name, UpdateHostReq updateHostReq) {
        Host host = hostRepository.findByName(name);
        host.updateHost(updateHostReq);
        System.out.println("확인"+ updateHostReq.getIp().equals(""));
//        hostRepository.save(host);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 호스트 삭제
    public ResponseEntity deleteHost(String name) {
        Host host = hostRepository.findByName(name);
        hostRepository.delete(host);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
