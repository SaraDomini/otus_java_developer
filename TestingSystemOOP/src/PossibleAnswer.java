// класс ответов на вопросы
public class PossibleAnswer {
    private int number; // номер ответа
    private String textAnswer; // варианты ответов
    private boolean rightAnswer; // правильный ответ или нет: true - правильный, false - неправильный
    private final Question question; // связанный вопрос

    public PossibleAnswer(Question question){
        if (question == null)
            throw new IllegalArgumentException("Question");
        this.question = question;
    }

    public PossibleAnswer(int number, String textAnswer, boolean rightAnswer, Question question){
        if (question == null)
            throw new IllegalArgumentException("Question");
        this.number = number;
        this.textAnswer = textAnswer;
        this.rightAnswer = rightAnswer;
        this.question = question;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void printPossibleAnswer(){
        System.out.println(number + ". " + textAnswer);
    }
}
