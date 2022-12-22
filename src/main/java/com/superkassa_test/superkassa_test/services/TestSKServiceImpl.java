package com.superkassa_test.superkassa_test.services;

import com.superkassa_test.superkassa_test.dto.CommonResponseDto;
import com.superkassa_test.superkassa_test.dto.SKRequestDto;
import com.superkassa_test.superkassa_test.dto.SKResponseDto;
import com.superkassa_test.superkassa_test.repository.SKExampleRepository;
import com.superkassa_test.superkassa_test.services.interfaces.TestSKService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class TestSKServiceImpl implements TestSKService {

    private final SKExampleRepository repository;

    @Override
    public CommonResponseDto<SKResponseDto> incrementById(SKRequestDto request) {
        try {
            AtomicLong atomicLong = new AtomicLong(request.getAdd());
            var entity = repository.findById(request.getId()).orElseThrow(EntityNotFoundException::new);
            var current = atomicLong.addAndGet(entity.getObj().getCurrent());
            entity.getObj().setCurrent(current);

            repository.save(entity);

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
