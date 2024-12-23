package com.quostomize.quostomize_be.api.pointUsageMethod.dto;

import com.quostomize.quostomize_be.api.lotto.dto.LottoParticipantRequestDto;
import com.quostomize.quostomize_be.domain.customizer.card.entity.CardDetail;
import com.quostomize.quostomize_be.domain.customizer.pointUsageMethod.entity.PointUsageMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PointUsageMethodRequest(
        @Positive Long pointUsageTypeId,
        @NotNull CardDetail cardDetail,
        @NotNull Boolean isLotto,
        @NotNull Boolean isPayback,
        @NotNull Boolean isPieceStock
) {
    public static PointUsageMethodRequest from(PointUsageMethod pointUsageMethod, LottoParticipantRequestDto request) {
        return new PointUsageMethodRequest(
                pointUsageMethod.getPointUsageTypeId(),
                pointUsageMethod.getCardDetail(),
                request.isLottoOn(),
                pointUsageMethod.getIsPayback(),
                pointUsageMethod.getIsPieceStock()
        );
    }

    public PointUsageMethod toEntity() {
        return PointUsageMethod.builder()
                .pointUsageTypeId(this.pointUsageTypeId())
                .cardDetail(this.cardDetail())
                .isLotto(this.isLotto())
                .isPayback(this.isPayback())
                .isPieceStock(this.isPieceStock())
                .build();
    }
}
