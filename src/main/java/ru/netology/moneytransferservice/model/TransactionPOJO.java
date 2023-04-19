package ru.netology.moneytransferservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Map;

public class TransactionPOJO {

    @NotBlank
    @Pattern(regexp = "[0-9]{16}", message = "Номер карты должен содержать 16 цифр")
    private final String cardFromNumber;

    @NotBlank
    @Pattern(regexp = "^(0{1}[1-9]{1}|1[0-2]{1})/[0-9]{2}$",
            message = "Срок действия карты должен иметь следущий вид мм/гг и содержать 4 цифры, " +
                    "разделенные знаком /")
    private final String cardFromValidTill;
    @NotBlank
    @Pattern(regexp = "[0-9]{3}", message = "CVV должен содержать 3 цифры")
    private final String cardFromCVV;
    @NotBlank
    @Pattern(regexp = "[0-9]{16}", message = "Номер карты должен содержать 16 цифр")
    private final String cardToNumber;
    private final Map<String, Object> amount;

    @Min(1)
    private long value;
    @NotBlank(message = "Укажите валюту перевода")
    private String currency;


    public TransactionPOJO(String cardFromNumber,
                           String cardFromValidTill, String cardFromCVV,
                           String cardToNumber, Map<String, Object> amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
        value =  Long.valueOf(String.valueOf(amount.get("value"))) ;
        currency = String.valueOf(amount.get("currency"));
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }


    public long getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}
