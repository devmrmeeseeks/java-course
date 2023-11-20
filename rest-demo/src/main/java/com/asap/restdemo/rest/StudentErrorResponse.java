package com.asap.restdemo.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
