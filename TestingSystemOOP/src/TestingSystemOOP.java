import java.util.Scanner;

public class TestingSystemOOP {
    public static void main(String[] args) {
        // объявление переменных
        double KOEF_PASS_TEST = 0.6; // коэффициент успешного прохождения
        Scanner consol = new Scanner(System.in);
        boolean getNumber = false; // флаг того, что введено число: true - введено число, false - введено не число
        boolean answerInPossible = false; // флаг того, что ответ - один из вариантов ответа: true - корректный, false - некорректный
        boolean answerCorrect = false; // флаг корректного ответа участника: true - корректный, false - некорректный
        int possibleAnswerCount = 0; // кол-во вариантов ответов
        int answer = 0; // ответ участника
        int answerRightCount = 0; // количество правильных ответов участника

        Question[] questions = new Question[3];

        questions[0] = new Question(1, "Солнечная система – это");
        questions[1] = new Question(2, "Солнечная система входит в состав");
        questions[2] = new Question(3, "Возраст Солнечной системы");

        PossibleAnswer[][] possibleAnswer = new PossibleAnswer[][]{
                {
                    new PossibleAnswer(1,
                            "планетная система со звездой в центре и природными космическими объектами, которые вращаются вокруг Солнца",
                            true, questions[0]),
                    new PossibleAnswer(2,
                            "звездная система с планетами",
                            false, questions[0]),
                    new PossibleAnswer(3,
                            "система из Солнца и планет",
                            false, questions[0])
                },
                {
                    new PossibleAnswer(1,
                            "рукав Ориона",
                            false, questions[1]),
                    new PossibleAnswer(2,
                            "Млечного Пути",
                            true,
                            questions[1]),
                    new PossibleAnswer(3,
                            "местную группу галактик",
                            false,
                            questions[1])
                },
                {
                    new PossibleAnswer(1,
                            "1 млрд лет",
                            false, questions[2]),
                    new PossibleAnswer(2,
                            "4,57 млрд лет",
                            true, questions[2]),
                    new PossibleAnswer(3,
                            "3 млрд лет",
                            false, questions[2]),
                    new PossibleAnswer(4,
                            "7 млрд лет",
                            false, questions[2]),
                }
        };

        int questionsCount = questions.length;
        for (int i = 0; i < questionsCount; i++) questions[i].setPossibleAnswers(possibleAnswer[i]);

        //-------------------------------------------

        int answerPass = (int) Math.ceil(questionsCount * KOEF_PASS_TEST);

        System.out.println("Добрый день! Добро пожаловать на тест по теме: \"Солнечная система\"!" +
                "\nДля успешного прохождения теста необходимо ответить на " + answerPass + " из " + questionsCount + " вопрос(а/ов).\nЖелаю удачи!");

        for (int i = 0; i < questionsCount; i++) {
            questions[i].printQuestion();
            possibleAnswerCount = possibleAnswer[i].length;
            do {
                System.out.println("Пожалуйста, введите номер вашего ответа:");
                if (consol.hasNextInt()) {
                    answer = consol.nextInt();
                    getNumber = true;
                } else {
                    System.out.println("Ответ некорректен. Ответом должно являться число.");
                    getNumber = false;
                    consol.nextLine();
                }

                //Проверка на то, что ответ - один из вариантов ответа
                if (getNumber) {
                    if (answer > 0 && answer <= possibleAnswerCount) {
                        answerInPossible = true;
                    } else {
                        answerInPossible = false;
                        System.out.println("Ответ некорректен. Ваш ответ не является одним из вариантов ответа.");
                    }
                }
                answerCorrect = getNumber && answerInPossible;
            } while (!answerCorrect);
            //если ответ дан правильный, то прибавляем счетчик правильных ответов
            if (questions[i].getRightAnswer(answer)) answerRightCount++;
        }

        // подведение итогов
        int answerWrongCount = questionsCount - answerRightCount;
        int koefPassCur = (int) Math.round(answerRightCount / (double) questionsCount * 100);
        System.out.println("\nВаши результаты:");
        System.out.println("Количество правильных ответов: " + answerRightCount + " из " + questionsCount);
        System.out.println("Количество не правильных ответов: " + answerWrongCount + " из " + questionsCount);
        System.out.println("Процент прохождения: " + koefPassCur + "%");
        if (koefPassCur == 100) {
            System.out.println("Поздравляю! Вы прошли тест без ошибок!");
        } else if (koefPassCur >= (KOEF_PASS_TEST * 100)){
            System.out.println("Вы прошли тест.");
        } else if (koefPassCur == 0){
            System.out.println("Вы не дали ни одного верного ответа. Кажется, надо еще раз пройти тему.");
        } else {
            System.out.println("К сожалению, вы не прошли тест.");
        }

    }
}