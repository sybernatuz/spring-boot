package com.syb.spring.entities;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ResponseHolder{


    private HashMap<String, Object> response;

    public ResponseHolder(HttpServletRequest request) {
        this.response = new HashMap<String, Object>();
        addHttpGetParameters(request);
    }

    public void setResponse(String key, Object value){
        this.response.put(key, value);
    }

    public Object getResponse(String key){
        return this.response.get(key);
    }
    
    private void addHttpGetParameters(HttpServletRequest request) {
    	List<String> parameters = Collections.list(request.getParameterNames());
    	for (String parameter : parameters) {
			setResponse(parameter, request.getParameter(parameter));
		}
    }



}
