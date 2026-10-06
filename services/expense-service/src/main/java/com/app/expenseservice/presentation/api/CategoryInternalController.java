package com.app.expenseservice.presentation.api;

import com.app.expenseservice.application.query.CategoryResult;
import com.app.expenseservice.application.usecase.ExistCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/internals/categories")
@RequiredArgsConstructor
public class CategoryInternalController {

    private final ExistCategoryUseCase existCategoryUseCase;

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> existsById(@PathVariable UUID id) {
        boolean exists = existCategoryUseCase.execute(new CategoryResult(id));
        return ResponseEntity.ok(exists);
    }
}
