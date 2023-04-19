package ru.netology.moneytransferservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Transaction {

    @JsonProperty("operationId")
    private int id;
    @JsonIgnore
    private final String cardFromNumber;
    @JsonIgnore
    private final String cardFromValidTill;
    @JsonIgnore
    private final String cardFromCVV;
    @JsonIgnore
    private final String cardToNumber;
    @JsonIgnore
    private final long value;
    @JsonIgnore
    private final String currency;
    @JsonIgnore
    private String code;

    @JsonIgnore
    BigDecimal commission;

    public Transaction(String cardFromNumber,
                       String cardFromValidTill, String cardFromCVV,
                       String cardToNumber, long value, String currency) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.value = value;
        this.currency = currency;
        commission = new BigDecimal(value).divide(BigDecimal.valueOf(100));
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
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

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Создана заявка на операцию: \n" +
                "   id:  " + id + ";\n" +
                "   карта списания:   " + cardFromNumber  + ";\n" +
                "   карта зачисления:  " + cardToNumber  + ";\n" +
                "   сумма перевода:  " + value + " " + currency + ";\n" +
                "   комиссия:  " + commission + " " + currency + ".\n";
    }
}
