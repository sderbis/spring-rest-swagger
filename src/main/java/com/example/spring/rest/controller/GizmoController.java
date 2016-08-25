package com.example.spring.rest.controller;

import com.example.spring.rest.exception.GizmoNotFoundException;
import com.example.spring.rest.exception.ServiceException;
import com.example.spring.rest.model.CreateResult;
import com.example.spring.rest.model.Gizmo;
import com.example.spring.rest.service.GizmoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.spring.rest.controller.ApiController.RESOURCE_GIZMO;

@Api(value = "Gizmos", description = "The Gizmo API")
@RestController
@RequestMapping(value = RESOURCE_GIZMO)
public class GizmoController extends ApiController {

    @Autowired
    GizmoService gizmoService;

    @ApiOperation(httpMethod = "GET", value = "Find a gizmo by id", response = Gizmo.class,
            notes = "finds a gizmo by supplying an identifier")
    @RequestMapping(value = PATH_VAR_ID, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Gizmo findGizmoById(@PathVariable("id") String id) throws ServiceException {
        Gizmo gizmo = gizmoService.findById(id);
        if (gizmo != null) {
            return gizmo;
        } else {
            throw new GizmoNotFoundException(id);
        }
    }

    @ApiOperation(httpMethod = "GET", value = "Find a gizmo by name", response = Gizmo.class,
            notes = "finds a gizmo by supplying a name (this may return more than one gizmo)")
    @RequestMapping(value = SEARCH, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Gizmo> findGizmoByName(@RequestParam(value = PARAM_NAME) String name) throws ServiceException {
        List<Gizmo> gizmos = gizmoService.findByName(name);
        if (gizmos.isEmpty()) {
            throw new GizmoNotFoundException(name);
        } else {
            return gizmos;
        }
    }

    @ApiOperation(httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, response = CreateResult.class, value = "Create a gizmo",
            notes = "Creates a gizmo using the identifier and name in the Gizmo entity")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResult create(@RequestBody Gizmo gizmo) throws ServiceException {
        requestValidator.validateCreateRequest(gizmo);
        gizmoService.create(gizmo);
        return new CreateResult(1);
    }

    @ApiOperation(httpMethod = "PUT", consumes = MediaType.APPLICATION_JSON_VALUE, value = "Update the gizmo",
            notes = "Updates a gizmo based on the id in the Gizmo entity")
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CreateResult update(@RequestBody Gizmo gizmo) throws ServiceException {
        requestValidator.validateCreateRequest(gizmo);
        gizmoService.update(gizmo);
        return new CreateResult(1);
    }

    @ApiOperation(httpMethod = "DELETE", value = "Delete a gizmo",
            notes = "deletes a gizmo using the supplied identifier")
    @RequestMapping(value = PATH_VAR_ID, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) throws ServiceException {
        gizmoService.deleteById(id);
    }
}
