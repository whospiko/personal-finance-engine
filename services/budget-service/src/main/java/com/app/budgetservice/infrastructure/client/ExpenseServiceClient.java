package com.app.budgetservice.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
    name = "expense-service",
    url = "${application.clients.expense-service.internal-url}"
)
public interface ExpenseServiceClient {
    @GetMapping("/api/v1/categories/{id}/exists")
    Boolean checkCategoryExists(@PathVariable("id") UUID id);
}
