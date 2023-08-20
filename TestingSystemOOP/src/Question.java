// класс вопросов к тесту
public class Question {
    private int number; // номер вопроса
    private String textQuestion; // текст вопроса
    private PossibleAnswer[] possibleAnswers;

    public Question(){

    }

    public Question(int number, String textQuestion){
        this.number = number;
        this.textQuestion = textQuestion;
    }

    public void printQuestion(){
        System.out.println("\nВопрос " + number + ". " + textQuestion);
        int possibleAnswerCount = possibleAnswers.length;
        for (int i = 0; i < possibleAnswerCount; i++) {
            possibleAnswers[i].printPossibleAnswer();// Вывод вариантов ответов
        }
    }

    public void setPossibleAnswers(PossibleAnswer[] possibleAnswers){
        this.possibleAnswers = possibleAnswers;
    }

    public boolean getRightAnswer(int answer){
        boolean result = possibleAnswers[answer-1].isRightAnswer();
        return result;
    }
}
