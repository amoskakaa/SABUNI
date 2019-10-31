package com.example.soap;

import localhost.university.GetUniversityRequest;
import localhost.university.GetUniversityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class UniversityEndpoint {
    private static final String NAMESPACE_URI = "http://localhost/university";

    private final UniversityRepository universityRepository;


    @Autowired
    public UniversityEndpoint(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityRequest")
    @ResponsePayload
    public GetUniversityResponse getUniversity(@RequestPayload GetUniversityRequest request) {
        GetUniversityResponse response = new GetUniversityResponse();
        response.setUniversity(universityRepository.findUniversity(request.getName()));
        return response;
    }

}
