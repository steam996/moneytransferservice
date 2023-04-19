package ru.netology.moneytransferservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Code {
    @NotBlank
    @Min(1)
    private final String operationId;
    @NotBlank
    @Pattern(regexp = "[0-9]{4}", message = "Код должен содержать 4 цифры")
    private final String code;

    public Code(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public int getOperationId() {
        return Integer.parseInt(operationId);
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Операция Id= " +
                 operationId + " - успешно произведена.";
    }
}
