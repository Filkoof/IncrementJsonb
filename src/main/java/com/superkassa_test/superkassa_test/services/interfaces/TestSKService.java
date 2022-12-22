package com.superkassa_test.superkassa_test.services.interfaces;

import com.superkassa_test.superkassa_test.dto.CommonResponseDto;
import com.superkassa_test.superkassa_test.dto.SKRequestDto;
import com.superkassa_test.superkassa_test.dto.SKResponseDto;

public interface TestSKService {

    CommonResponseDto<SKResponseDto> incrementById(SKRequestDto request);
}
