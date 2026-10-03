package com.app.expenseservice.presentation.api;

import com.app.common.dto.ApiResponse;
import com.app.expenseservice.application.dto.CategoryExpenseRequestDto;
import com.app.expenseservice.application.dto.CategoryExpenseResponseDto;
import com.app.expenseservice.application.service.CategoryExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final CategoryExpenseService categoryExpenseService;


    @PostMapping()
    public ApiResponse<CategoryExpenseResponseDto> create(@Valid @RequestBody CategoryExpenseRequestDto dto) {

        CategoryExpenseResponseDto response = this.categoryExpenseService.create(dto);

        return ApiResponse.success(response);
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryExpenseResponseDto> updateUser(
            @PathVariable UUID id,
            @Valid @RequestBody CategoryExpenseRequestDto request) {
        return ApiResponse.success("Sda");
    }

}
