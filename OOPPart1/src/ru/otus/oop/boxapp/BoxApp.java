package ru.otus.oop.boxapp;

public class BoxApp {
    public static void main(String[] args) {

        Box smallBox = new Box(0.1f,0.2f, 0.05f, "белый");
        smallBox.printInfo();
        //Нельзя изменять размеры коробки - нет сеттеров для длины, ширины и высоты
        //Изменяем цвет коробки
        smallBox.setColor("красный");
        smallBox.printInfo();
        //Закрываем коробку
        smallBox.setOpenFlg(false);
        smallBox.printInfo();
        //Открываем коробку
        smallBox.setOpenFlg(true);
        smallBox.printInfo();
        //Пробуем выбросить из пустой коробки
        smallBox.deleteThing("Что-то");

        System.out.println("-------------------------------");

        Box fridge = new Box(201f,59.5f,65,"серебряный", false);
        fridge.printInfo();
        //Пробуем засунуть жирафа в закрытый холодильник
        fridge.putThing("Жираф");
        //Открыли, засунули жирафа, закрыли холодильник
        fridge.setOpenFlg(true);
        fridge.putThing("Жираф");
        fridge.setOpenFlg(false);
        fridge.printInfo();

        //Пробуем засунуть слона в закрытый холодильник с жирафом
        fridge.putThing("Слон");
        //Пробуем засунуть слона в открытый холодильник с жирафом
        fridge.setOpenFlg(true);
        fridge.putThing("Слон");
        //Пробуем засунуть слона в открытый холодильник, предварительно вынув жирафом
        fridge.deleteThing("Жираф");
        fridge.putThing("Слон");
        fridge.printInfo();
        //Пока пытались впихнуть слона в холодильник, узнали, что слона зовут Дамбо
        //Пробуем достать Дамбо из холодильника
        fridge.deleteThing("Дамбо");
        //Пробуем достать слона из холодильника и закрываем его
        fridge.deleteThing("Слон");
        fridge.setOpenFlg(false);
        fridge.printInfo();
        //Полетели вместе с замерзшим Дамбо слушать следующую лекцию
    }
}
