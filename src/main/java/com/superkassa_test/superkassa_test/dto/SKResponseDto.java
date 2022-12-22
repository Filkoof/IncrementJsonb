package com.superkassa_test.superkassa_test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SKResponseDto {

    @JsonProperty("current")
    private long current;
}
