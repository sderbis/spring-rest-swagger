package com.example.spring.rest.service;

import com.example.spring.rest.exception.ServiceException;
import com.example.spring.rest.model.Gizmo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GizmoServiceImpl implements GizmoService {
    @Override
    public void create(Gizmo gizmo) throws ServiceException {

    }

    @Override
    public void update(Gizmo gizmo) throws ServiceException {

    }

    @Override
    public Gizmo findById(String id) throws ServiceException {
        return new Gizmo(id, "Test Gizmo");
    }

    @Override
    public List<Gizmo> findByName(String name) throws ServiceException {
        return Collections.singletonList(new Gizmo("1", name));
    }

    @Override
    public void deleteById(String id) throws ServiceException {

    }
}
