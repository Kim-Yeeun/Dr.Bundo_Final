package org.techtown.drbundo;

public class QuestionItem {
    String question;
    String answer;

    public QuestionItem() {}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionItem{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

