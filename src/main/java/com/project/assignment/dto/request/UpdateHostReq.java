package com.project.assignment.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateHostReq {
    private String name;
    private String ip;
}
