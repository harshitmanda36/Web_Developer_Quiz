
package com.example.quiz.dto;

import java.util.List;

public class SubmitRequestDTO {
    private List<SubmitAnswerDTO> answers;

    public SubmitRequestDTO() {}

    public SubmitRequestDTO(List<SubmitAnswerDTO> answers) {
        this.answers = answers;
    }

    public List<SubmitAnswerDTO> getAnswers() { return answers; }
    public void setAnswers(List<SubmitAnswerDTO> answers) { this.answers = answers; }
}
