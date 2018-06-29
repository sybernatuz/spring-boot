package com.syb.spring.entities;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.ModelMap;

public class ResponseHolder{


    private HashMap<String, Object> response;
    
    public ResponseHolder(Map<String,String> requestVariables, ModelMap model) {
        this();
        addPathVariables(requestVariables);
        model.addAllAttributes(response);
    }
    
    public ResponseHolder(Map<String,String> requestVariables) {
        this();
        addPathVariables(requestVariables);
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
    
    private void addPathVariables(Map<String,String> requestVariables) {
    	if (requestVariables != null)
    		requestVariables.forEach((key, value) -> setResponse(key, value));
    }
}
