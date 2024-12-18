package com.quostomize.quostomize_be.api.auth.dto;

import com.quostomize.quostomize_be.domain.auth.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public record MemberRequestDto(
        @NotBlank(message = "이름은 필수 입력 값입니다.")
        String memberName,

        @NotBlank(message = "이메일은 필수 입력 값입니다.")
        @Email(message = "이메일 형식으로 입력해주세요.")
        String memberEmail,

        @NotBlank(message = "아이디를 입력해주세요")
        String memberLoginId,

        @NotBlank
        @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
        String memberPassword,

        @NotBlank
        @Length(min=13, max=13)
        String residenceNumber,

        @NotBlank(message = "우편번호를 입력해주세요")
        String zipCode,

        @NotBlank(message = "주소를 입력해주세요")
        String memberAddress,

        @NotBlank(message = "상세주소를 입력하세요.")
        String memberDetailAddress,

        @NotBlank
        @Size(min = 11, max = 11, message = "'-'없이 11자리의 전화번호를 입력해주세요.")
        String memberPhoneNumber,

        @NotBlank
        @Length(min = 6, max = 6, message = "2차 인증번호 6자리를 입력해주세요.")
        String secondaryAuthCode

) {
    public static MemberRequestDto from(Member member) {
        return new MemberRequestDto(
                member.getMemberName(),
                member.getMemberEmail(),
                member.getMemberLoginId(),
                member.getMemberPassword(),
                member.getResidenceNumber(),
                member.getZipCode(),
                member.getMemberAddress(),
                member.getMemberDetailAddress(),
                member.getMemberPhoneNumber(),
                member.getSecondaryAuthCode()
        );
    }

    public Member toEntity() {
        return Member.builder()
                .memberName(this.memberName())
                .memberEmail(this.memberEmail())
                .memberLoginId(this.memberLoginId())
                .memberPassword(this.memberPassword())
                .residenceNumber(this.residenceNumber())
                .zipCode(this.zipCode())
                .memberAddress(this.memberAddress())
                .memberDetailAddress(this.memberDetailAddress())
                .memberPhoneNumber(this.memberPhoneNumber())
                .secondaryAuthCode(this.secondaryAuthCode())
                .build();
    }

}