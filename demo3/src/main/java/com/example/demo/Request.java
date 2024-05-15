package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Schema(required = true, description = "Name của sinh viên")
    @NotEmpty(message = "Name is not null")
    private String name;

    private int score;
}
