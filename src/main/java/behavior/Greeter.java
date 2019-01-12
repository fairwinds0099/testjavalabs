package behavior;

public class Greeter {

    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
        GoodByeWorldGreeting goodByeWorldGreeting = new GoodByeWorldGreeting();
        greeter.greet(helloWorldGreeting);
        greeter.greet(goodByeWorldGreeting);
    }
}
