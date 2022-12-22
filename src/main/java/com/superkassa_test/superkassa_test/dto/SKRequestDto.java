package com.superkassa_test.superkassa_test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SKRequestDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("add")
    private int add;
}
