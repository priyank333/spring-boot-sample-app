/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.controller;

import com.app.model.RequestInfo;
import com.app.service.PingService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author z0043uwn
 */
@RestController
public class PingController {

    @Autowired
    private PingService pingService;

    @GetMapping("/ping")
    public ResponseEntity<RequestInfo> ping(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(
                pingService.getRequestInfo(request));
    }

}
