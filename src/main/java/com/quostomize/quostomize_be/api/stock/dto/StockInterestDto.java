package com.quostomize.quostomize_be.api.stock.dto;

public record StockInterestDto (
        Integer priority,
        String stockName,
        Integer stockPresentPrice,
        String stockImage
) {
    public StockInterestDto withStockImage(String newStockImage) {
        return new StockInterestDto(priority, stockName, stockPresentPrice, newStockImage);
    }
}