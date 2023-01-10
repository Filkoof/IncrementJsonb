package com.superkassa_test.superkassa_test.services;

import com.superkassa_test.superkassa_test.dto.CommonResponseDto;
import com.superkassa_test.superkassa_test.dto.SKRequestDto;
import com.superkassa_test.superkassa_test.dto.SKResponseDto;
import com.superkassa_test.superkassa_test.repository.SKExampleRepository;
import com.superkassa_test.superkassa_test.services.interfaces.TestSKService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TestSKServiceImpl implements TestSKService {

    private final SKExampleRepository repository;

    @Override
    public CommonResponseDto<SKResponseDto> incrementById(SKRequestDto request) {
        try {

            int current = repository.incrementCurrent(request.getAdd());

            return CommonResponseDto.<SKResponseDto>builder()
                    .data(new SKResponseDto().setCurrent(current))
                    .error("")
                    .errorDescription("")
                    .timeStamp(LocalDateTime.now())
                    .build();

        } catch (Exception exception) {
            return CommonResponseDto.<SKResponseDto>builder()
                    .error("418")
                    .errorDescription("I'm a teapot")
                    .timeStamp(LocalDateTime.now())
                    .build();
        }
    }
}
