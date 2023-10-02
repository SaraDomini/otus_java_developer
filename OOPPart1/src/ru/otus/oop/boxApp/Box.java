package ru.otus.oop.boxApp;

public class Box {
    private float length;
    private float width;
    private float height;
    private String color;

    private boolean openFlg; // true - коробка открыта, false - коробка закрыта. При создании коробка openFlg = true.

    private String thing;

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public boolean isOpenFlg() {
        return openFlg;
    }

    public void setColor(String color) {
        if (color != null) {
            this.color = color;
        }
    }

    public void setOpenFlg(boolean openFlg) {
        this.openFlg = openFlg;
    }

    public Box(float length, float width, float height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.openFlg = true;
    }

    public Box(float length, float width, float height, String color, boolean openFlg) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.openFlg = openFlg;
    }

    public String getOpenStatus() {
        if (openFlg) {
            return "Коробка открыта";
        } else {
            return "Коробка закрыта";
        }
    }

    public String getThingStatus() {
        if (thing != null) {
            return ("Предмет в коробке: " + thing);
        } else {
            return "Коробка пуста";
        }
    }

    public void printInfo() {
        System.out.println("Размеры коробки: " + length + " x " + width + " x " + height);
        System.out.println("Цвет коробки: " + color);
        System.out.println(getOpenStatus());
        System.out.println(getThingStatus());
        System.out.println();
    }

    public void putThing(String thing) {
        if (!openFlg) {
            System.out.println("Коробка закрыта. " +
                    "Чтобы попробовать положить в нее предмет, нужно ее открыть.");
        } else if (this.thing != null) {
            System.out.println("Коробка заполнена. Выбросите предмет: " + this.thing);
        } else {
            this.thing = thing;
            System.out.println("В коробку положили предмет: " + thing);
        }
        System.out.println();
    }

    public void deleteThing(String thing) {
        if (!openFlg) {
            System.out.println("Коробка закрыта. " +
                    "Чтобы попробовать выложить из нее предмет, нужно ее открыть.");
        } else if (this.thing == null) {
            System.out.println("Коробка пуста. Выбрасывать нечего");
        } else if (this.thing != thing) {
            System.out.println("Такого предмета в коробке нет.");
        } else {
            this.thing = null;
            System.out.println("Из коробки выложили предмет: " + thing);
        }
        System.out.println();
    }
}
