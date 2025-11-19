package com.vwaiter.receipt;

import com.vwaiter.OrderPayment;
import org.springframework.stereotype.Service;

@Service
public class ReceiptGenerationService {

    public String generateReceiptPdf(OrderPayment orderPayment) {
        // try to use Open PDF with HTML to PDF generation approach in order to make
        // this functionality more flexible
        // https://www.baeldung.com/java-html-to-pdf
        // if not applicable - use iText as we need tables https://www.baeldung.com/java-pdf-creation
        return "pathToGeneratedFile/file.pdf";
    }
}
