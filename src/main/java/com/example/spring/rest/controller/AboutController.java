package com.example.spring.rest.controller;

import com.example.spring.rest.model.AboutInfo;
import com.example.spring.rest.service.AboutService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "About", description = "Information about the Gizmo API")
@RestController
public class AboutController extends ApiController {

    @Autowired
    AboutService aboutService;

    @ApiOperation(httpMethod = "GET", value = "About", response = AboutInfo.class,
            notes = "Provides basic version info about the Gizmo REST API.  " +
                    "Can be used to verify that the API is up and running as it does not require any authorization.")
    @RequestMapping(value = RESOURCE_ABOUT, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public AboutInfo about() {
        AboutInfo aboutInfo = new AboutInfo();
        aboutInfo.setBuildTimestamp(aboutService.getBuildTimestamp());
        aboutInfo.setVersion(aboutService.getVersion());

        return aboutInfo;
    }
}
