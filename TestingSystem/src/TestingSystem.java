import java.util.Scanner;

public class TestingSystem {

    public static void main(String[] args) {
        // объявление переменных
        double KOEF_PASS_TEST = 0.6; // коэффициент успешного прохождения

        Scanner consol = new Scanner(System.in);
        String[] questionArr; // массив с вопросами
        int[] answerArr; // массив с ответами на тест
        String[][] possibleAnswerArr; // массив с вариантами ответов
        int numberQuestion = 0; // номер вопроса
        int numberPossibleAnswer = 0; // номер варианта ответа
        int answer = 0; // ответ участника
        String answerStr; // ответ участника типа String
        int questionCount = 0; // кол-во вопросов
        int possibleAnswerCount = 0; // кол-во вариантов ответов
        int answerRightCount = 0; // количество правильных ответов участника
        int answerWrongCount = 0; // количество неправильных ответов участника
        int answerPass; // кол-во ответов для успешного прохождения
        int koefPassCur; // процент прохождения участника
        boolean notEmtyStr = false; //флаг введенной пустой строки: true - строка не пустая, false - строка пустая
        boolean getNumber = false; // флаг того, что введено число: true - введено число, false - введено не число
        boolean answerInPossible = false; // флаг того, что ответ - один из вариантов ответа: true - корректный, false - некорректный
        boolean answerCorrect = false; // флаг корректного ответа участника: true - корректный, false - некорректный

        // инициализация переменных
        questionArr = new String[]{
                "Солнечная система – это",
                "Солнечная система входит в состав",
                "Возраст Солнечной системы"
        };

        answerArr = new int[]{
                1,
                2,
                2
        };

        possibleAnswerArr = new String[][]{
                {
                        "планетная система со звездой в центре и природными космическими объектами, которые вращаются вокруг Солнца",
                        "звездная система с планетами",
                        "система из Солнца и планет"
                },
                {
                        "рукав Ориона",
                        "Млечного Пути",
                        "местную группу галактик"
                },
                {
                        "1 млрд лет",
                        "4,57 млрд лет",
                        "3 млрд лет",
                        "7 млрд лет"
                }
        };

        //-------------------------------------------

        questionCount = questionArr.length;
        answerPass = (int) Math.ceil(questionCount * KOEF_PASS_TEST);

        System.out.println("Добрый день! Добро пожаловать на тест по теме: \"Солнечная система\"!" +
                "\nДля успешного прохождения теста необходимо ответить на " + answerPass + " вопрос(а/ов).\nЖелаю удачи!");
        for (int i = 0; i < questionCount; i++) {
            numberQuestion = i + 1;
            System.out.println("\nВопрос " + numberQuestion + " из " + questionCount + ". " + questionArr[i]); // Вывод вопросов
            possibleAnswerCount = possibleAnswerArr[i].length;
            for (int j = 0; j < possibleAnswerCount; j++) {
                numberPossibleAnswer = j + 1;
                System.out.println(numberPossibleAnswer + ". " + possibleAnswerArr[i][j]); // Вывод вариантов ответов
            }

            do {
                System.out.println("Пожалуйста, введите номер вашего ответа:");
                answerStr = consol.nextLine();

                //Проверка на пустую строку

                if (answerStr == "") {
                    notEmtyStr = false;
                    System.out.println("Ответ некорректен. Вы не дали ответ.");
                } else {
                    notEmtyStr = true;
                }

                //Проверка на буквы
                //разбиваю стрингу на чары, прохожусь по каждому и смотрю принадлежит ли он от 0 до 9
                getNumber = true;
                for (int j = 0; j < answerStr.length() && getNumber; j++) {
                    getNumber = false;
                    if (j == 0){
                        if (49<=(int)answerStr.toCharArray()[j] && (int)answerStr.toCharArray()[j] <= 57) { //Проверка,что первая цифра - не ноль
                            getNumber = true;
                        }
                    } else {
                        if (48 <= (int) answerStr.toCharArray()[j] && (int) answerStr.toCharArray()[j] <= 57) { //аля множество целых чисел в чаровском представлении '0'-k=48,'9'-k=57
                            getNumber = true;
                        }
                    }
                }
                if (!getNumber) {
                    System.out.println("Ответ некорректен. Ответом должно являться число.");
                }

                //Проверка на то, что ответ - один из вариантов ответа
                if (getNumber&&notEmtyStr) {
                    answer = Integer.parseInt (answerStr);
                    if (answer > 0 && answer <= possibleAnswerCount) {
                        answerInPossible = true;
                    } else {
                        answerInPossible = false;
                        System.out.println("Ответ некорректен. Ваш ответ не является одним из вариантов ответа.");
                    }
                }
                answerCorrect = notEmtyStr && getNumber && answerInPossible;
            } while (!answerCorrect);

            //если ответ дан правильный, то прибавляем счетчик правильных ответов
            if (answer == answerArr[i]){
                answerRightCount ++;
            }
        }

        // подведение итогов
        answerWrongCount = questionCount - answerRightCount;
        koefPassCur = (int) Math.round(answerRightCount / (double) questionCount * 100);

        System.out.println("\nВаши результаты:");
        System.out.println("Количество правильных ответов: " + answerRightCount + " из " + questionCount);
        System.out.println("Количество не правильных ответов: " + answerWrongCount + " из " + questionCount);
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