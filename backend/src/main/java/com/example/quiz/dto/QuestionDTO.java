
package com.example.quiz.dto;

import java.util.List;

public class QuestionDTO {
    private Long id;
    private String text;
    private List<OptionDTO> options;

    public QuestionDTO() {}

    public QuestionDTO(Long id, String text, List<OptionDTO> options) {
        this.id = id;
        this.text = text;
        this.options = options;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public List<OptionDTO> getOptions() { return options; }
    public void setOptions(List<OptionDTO> options) { this.options = options; }
}
