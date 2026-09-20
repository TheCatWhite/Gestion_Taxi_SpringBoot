package com.example.demo.Service;

import java.util.List;

import com.example.demo.dto.Driver.DriverRequest;
import com.example.demo.dto.Driver.DriverResponse;

public interface DriverService {

    DriverResponse create(DriverRequest request);

    DriverResponse findById(Long id);

    List<DriverResponse> findAll();

    DriverResponse update(Long id, DriverRequest request);

    void delete(Long id);
}