package com.superkassa_test.superkassa_test.controllers;

import com.superkassa_test.superkassa_test.dto.CommonResponseDto;
import com.superkassa_test.superkassa_test.dto.SKRequestDto;
import com.superkassa_test.superkassa_test.dto.SKResponseDto;
import com.superkassa_test.superkassa_test.services.interfaces.TestSKService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final TestSKService service;

    @PostMapping("/modify")
    public CommonResponseDto<SKResponseDto> increment(@RequestBody SKRequestDto request) {
        return service.incrementById(request);
    }
}
