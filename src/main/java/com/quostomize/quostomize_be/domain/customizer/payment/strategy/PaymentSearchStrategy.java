package com.quostomize.quostomize_be.domain.customizer.payment.strategy;

import com.quostomize.quostomize_be.domain.customizer.payment.entity.PaymentRecord;
import com.quostomize.quostomize_be.domain.customizer.payment.service.PaymentRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentSearchStrategy {
    Page<PaymentRecord> search(PaymentRecordService service, Pageable pageable, Long searchAmount);
}
