abstract class Animal {
    public abstract void checkup();
}

class Dog extends Animal {
    public void checkup() {
        System.out.println("Dog checkup");
    }
}

class Cat extends Animal implements LivingThing {
    public void checkup() {
        System.out.println("Cat checkup");
    }

    public void walk() {
        System.out.println("Cat walk");
    }

    public void eat() {
        System.out.println("Cat eat");
    }
}

class Bird extends Animal {
    public void checkup() {
        System.out.println("Bird checkup");
    }
}

interface LivingThing {
    void walk();
    void eat();
}

public class soal1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.checkup();

        Cat cat = new Cat();
        cat.checkup();
        cat.walk();
        cat.eat();
        
        Bird bird = new Bird();
        bird.checkup();
    }
}
