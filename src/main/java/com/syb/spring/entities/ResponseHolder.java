package com.syb.spring.entities;

import java.util.HashMap;
import java.util.Map;

public class ResponseHolder{


    private HashMap<String, Object> response;

    public ResponseHolder(Map<String,String> pathVariables) {
        this();
        addPathVariables(pathVariables);
    }
    
    public ResponseHolder() {
    	this.response = new HashMap<String, Object>();
	}

    public void setResponse(String key, Object value){
        this.response.put(key, value);
    }

    public Object getResponse(String key){
        return this.response.get(key);
    }
    
    private void addPathVariables(Map<String,String> pathVariables) {
    	if (pathVariables != null)
    		pathVariables.forEach((key, value) -> setResponse(key, value));
    }
}
