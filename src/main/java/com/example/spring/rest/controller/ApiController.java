package com.example.spring.rest.controller;

import com.example.spring.rest.web.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ApiController {
    public static final String RESOURCE_ABOUT = "/about";
    public static final String RESOURCE_GIZMO = "/gizmo";

    public static final String PATH_VAR_ID = "/{id}";
    public static final String SEARCH = "/search";

    public static final String PARAM_NAME = "name";

    @Autowired
    RequestValidator requestValidator;
}
