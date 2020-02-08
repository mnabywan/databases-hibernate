import java.util.Scanner;
import java.util.function.Consumer;

public class MenuOption {
    private final String text;
    private final Consumer<Scanner> handler;

    public MenuOption(String text, Consumer<Scanner> handler){
        this.text = text;
        this.handler = handler;
    }

    public String getText() {
        return text;
    }

    public Consumer<Scanner> getHandler() {
        return handler;
    }
}
