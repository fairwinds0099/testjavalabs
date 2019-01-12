package behavior;

public class GoodByeWorldGreeting implements Greeting {
    @Override
    public void perform() {
        System.out.println("Goodbye World");
    }
}
