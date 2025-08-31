package com.example.quiz.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // ensure this matches your column name; default we expect 'text'
    @Column(name = "text", nullable = false, length = 500)
    private String text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OptionChoice> options;

    public Question() {}
    public Question(Long id, String text, List<OptionChoice> options) {
        this.id = id; this.text = text; this.options = options;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public List<OptionChoice> getOptions() { return options; }
    public void setOptions(List<OptionChoice> options) { this.options = options; }
}
