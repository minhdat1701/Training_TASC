package com.example.demo;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@Validated
@Tag(name = "Demo", description = "Test Controller")
@RestController
public class Demo3Controller {
    @Operation(
            summary = "Thêm mới Student",
            description = "Add student")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema, mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/student")
    public String getStudent(@RequestParam String name) {
        return name;
    }
    @PostMapping("/student")
    public String postStudent(@RequestBody String age ) {
        return age;
    }
    @GetMapping("/student/{stt}")
    public String sttStudent(@PathVariable("stt") String stt) {
        return stt;
    }
    @PostMapping("/request")
    public String getNameRequest(@Valid @RequestBody Request request) {
        int a = 10/request.getScore(); //score = 0 --> exception
        request.setName("Đạt");
        return request.getName();
    }
}
