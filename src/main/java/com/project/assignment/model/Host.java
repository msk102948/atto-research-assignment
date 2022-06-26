package com.project.assignment.model;

import com.project.assignment.dto.request.MakeHostReq;
import com.project.assignment.dto.request.UpdateHostReq;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Entity
@Table(name = "host")
@NoArgsConstructor
public class Host  extends Timestamped{
    @Id
    @Column(name = "host_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostId;

    @Column(name = "name", unique = true)
    @NotNull
    private String name;

    @Column(name = "ip", unique = true)
    @NotNull
    private String ip;

    @Setter
    @Column(name = "recent_alive")
    private String recentAlive;

    public Host(MakeHostReq makeHostReq) {
        this.name = makeHostReq.getName();
        this.ip = makeHostReq.getIp();
    }

    public void updateHost(UpdateHostReq updateHostReq) {
        if(updateHostReq.getName()!=null && !updateHostReq.getName().equals("")){
            this.name = updateHostReq.getName();
        }
        if(updateHostReq.getIp()!=null && !updateHostReq.getIp().equals("")){
            this.ip = updateHostReq.getIp();
        }
    }
}
