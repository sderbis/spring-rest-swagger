package com.example.spring.rest.service;

import com.example.spring.rest.exception.ServiceException;
import com.example.spring.rest.model.Gizmo;

import java.util.List;

public interface GizmoService {
    void create(Gizmo gizmo) throws ServiceException;

    void update(Gizmo gizmo) throws ServiceException;

    Gizmo findById(String id) throws ServiceException;

    List<Gizmo> findByName(String name) throws ServiceException;

    void deleteById(String id) throws ServiceException;
}
