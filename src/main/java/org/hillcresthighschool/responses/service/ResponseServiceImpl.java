package org.hillcresthighschool.responses.service;

import org.hillcresthighschool.responses.dto.ResponsesDTO;
import org.hillcresthighschool.responses.entity.Response;
import org.hillcresthighschool.responses.repository.ResponseRepository;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService{
    private final ResponseRepository responseRepository;

    public ResponseServiceImpl (ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public Response createResponse(ResponsesDTO dto) {
        var response = Response.builder()
                .text(dto.getText())
                .date(dto.getDate())
                .anonymous(dto.isAnonymous())
                .approvedBy(dto.getApprovedBy())
                .build();

        return responseRepository.save(response);
    }
}
