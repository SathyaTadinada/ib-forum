package org.hillcresthighschool.responses.service;

import org.hillcresthighschool.responses.dto.ResponsesDTO;
import org.hillcresthighschool.responses.entity.Response;

public interface ResponseService {
    Response createResponse(ResponsesDTO dto);
}
