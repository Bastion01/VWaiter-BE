package com.vwaiter.processor;

import com.vwaiter.OrderPayment;
import com.vwaiter.print.ReceiptPrintingService;
import com.vwaiter.receipt.ReceiptGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderPaymentProcessor {
    private final ReceiptGenerationService receiptGenerationService;
    private final ReceiptPrintingService receiptPrintingService;


    public void process(OrderPayment orderPayment) {
        String pdfPath = receiptGenerationService.generateReceiptPdf(orderPayment);
        receiptPrintingService.print(pdfPath);
    }
}
