/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.service;

import com.app.model.RequestInfo;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author z0043uwn
 */
@Service
public class PingService {

    public RequestInfo getRequestInfo(HttpServletRequest request) {
        RequestInfo requestInfo = new RequestInfo();
        setValues(requestInfo, request);
        return requestInfo;
    }

    private void setValues(RequestInfo requestInfo, HttpServletRequest request) {
        requestInfo.setLocalCountry(request.getLocale().getCountry());
        requestInfo.setLocalName(request.getLocalName());
        requestInfo.setLocalPort(request.getLocalPort());
        requestInfo.setRemoteAddress(request.getRemoteAddr());
        requestInfo.setRemoteHost(request.getRemoteAddr());
        requestInfo.setRemoteUser(request.getRemoteUser());
        requestInfo.setRequestURI(request.getRequestURI());
        requestInfo.setRequestedSessionId(request.getRequestedSessionId());
        requestInfo.setScheme(request.getScheme());
        requestInfo.setServerName(request.getServerName());
        requestInfo.setServletPath(request.getServletPath());
        requestInfo.setContextPath(request.getContextPath());
        requestInfo.setHeaders(iterateHeader(request.getHeaderNames(), request));
        requestInfo.setParameters(iterateParameter(request.getParameterNames(), request));
        requestInfo.setAttributes(iterateAttribute(request.getAttributeNames(), request));
        
    }

    private Map<String, String> iterateHeader(Enumeration<String> enu, HttpServletRequest request) {
        Map<String, String> keyValuMap = new HashMap<>();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            keyValuMap.put(key, request.getHeader(key));
        }
        return keyValuMap;
    }

    private Map<String, String> iterateAttribute(Enumeration<String> enu, HttpServletRequest request) {
        Map<String, String> keyValuMap = new HashMap<>();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            keyValuMap.put(key, String.valueOf(request.getAttribute(key)));
        }
        return keyValuMap;
    }

    private Map<String, String[]> iterateParameter(Enumeration<String> enu, HttpServletRequest request) {
        Map<String, String[]> keyValuMap = new HashMap<>();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            keyValuMap.put(key, request.getParameterValues(key));
        }
        return keyValuMap;
    }
}
