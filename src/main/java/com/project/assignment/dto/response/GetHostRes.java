package com.project.assignment.dto.response;

import com.project.assignment.model.Host;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetHostRes {
    private String hostName; // 호스트 이름
    private String hostIp; // 호스트 ip
    private boolean isAlive; // Alive 상태 여부
    private String recentAliveAt; // 마지막 Alive 시간

    public GetHostRes(Host host, boolean isAlive) {
        this.hostName = host.getName();
        this.hostIp = host.getIp();
        this.isAlive = isAlive;
        this.recentAliveAt = host.getRecentAlive();
    }
}
