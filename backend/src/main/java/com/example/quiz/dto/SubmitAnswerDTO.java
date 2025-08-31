
package com.example.quiz.dto;

public class SubmitAnswerDTO {
    private Long questionId;
    private Long optionId;

    public SubmitAnswerDTO() {}

    public SubmitAnswerDTO(Long questionId, Long optionId) {
        this.questionId = questionId;
        this.optionId = optionId;
    }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public Long getOptionId() { return optionId; }
    public void setOptionId(Long optionId) { this.optionId = optionId; }
}
