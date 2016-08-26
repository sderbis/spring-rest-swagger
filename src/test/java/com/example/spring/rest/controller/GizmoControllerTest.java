package com.example.spring.rest.controller;

import com.example.spring.rest.config.BaseControllerTest;
import com.example.spring.rest.model.Gizmo;
import org.junit.Test;

import static com.example.spring.rest.controller.ApiController.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GizmoControllerTest extends BaseControllerTest {
    private static final String gizmoId = "1";
    private static final String gizmoName = "some-name";

    @Test
    public void testFindGizmoById() throws Exception {
        mockMvc.perform(get(RESOURCE_GIZMO + "/" + gizmoId))
               .andExpect(status().isOk())
               .andExpect(content().contentType(jsonContentType))
               .andExpect(jsonPath("$.id", is(gizmoId)));
    }

    @Test
    public void testFindGizmoByName() throws Exception {
        mockMvc.perform(get(RESOURCE_GIZMO + SEARCH).param(PARAM_NAME, gizmoName))
               .andExpect(status().isOk())
               .andExpect(content().contentType(jsonContentType))
               .andExpect(jsonPath("$[0].id", is(gizmoId)))
               .andExpect(jsonPath("$[0].name", is(gizmoName)));
    }

    @Test
    public void testCreate() throws Exception {
        Gizmo gizmo = new Gizmo(gizmoId, gizmoName);
        mockMvc.perform(post(RESOURCE_GIZMO).content(json(gizmo))
                                            .contentType(jsonContentType))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.totalCreated", is(1)));
    }

    @Test
    public void testUpdate() throws Exception {
        Gizmo gizmo = new Gizmo(gizmoId, gizmoName);

        mockMvc.perform(put(RESOURCE_GIZMO).content(json(gizmo))
                                           .contentType(jsonContentType))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.totalCreated", is(1)));
    }

    @Test
    public void testCreateValidation() throws Exception {
        mockMvc.perform(post(RESOURCE_GIZMO).content(json(new Gizmo()))
                                            .contentType(jsonContentType))
               .andExpect(status().is5xxServerError())
               .andExpect(jsonPath("$.errors[0]", containsString("id: may not be empty")));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(RESOURCE_GIZMO + "/" + gizmoId))
               .andExpect(status().isNoContent());
    }
}