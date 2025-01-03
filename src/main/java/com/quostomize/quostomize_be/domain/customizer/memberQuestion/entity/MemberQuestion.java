package com.quostomize.quostomize_be.domain.customizer.memberQuestion.entity;

import com.quostomize.quostomize_be.common.entity.BaseTimeEntity;
import com.quostomize.quostomize_be.domain.auth.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "member_questions")
public class MemberQuestion extends BaseTimeEntity {

    public MemberQuestion() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questions_sequence_id")
    private Long questionsSequenceId;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;

    @Column(name = "is_answered", nullable = false)
    private Boolean isAnswered;

    @Column(name = "category_code", nullable = false)
    private Long categoryCode;

    @Column(name = "question_title", nullable = false, length = 30)
    private String questionTitle;

    @Lob
    @Column(name = "question_content", columnDefinition = "TEXT", nullable = false)
    private String questionContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public MemberQuestion(Long questionsSequenceId, Boolean isPrivate, Boolean isAnswered, Long categoryCode, String questionTitle, String questionContent, Member member) {
        this.questionsSequenceId = questionsSequenceId;
        this.isPrivate = isPrivate;
        this.isAnswered = isAnswered;
        this.categoryCode = categoryCode;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.member = member;
    }

    public void markAsAnswered() {
        this.isAnswered = true;
    }
}
