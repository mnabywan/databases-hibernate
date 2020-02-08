import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Consumer;

public class Menu {

    private String info;
    private Map<Integer, MenuOption> menuOptions = new HashMap<>();
    private boolean oneshot = true;

    public void setOneshot(boolean oneshot){
        this.oneshot = oneshot;
    }

    public Menu(String info){
        this.info = info;
    }

    public void addMenuOption(int index, String text, Consumer<Scanner> handler){
        this.menuOptions.put(index, new MenuOption(text, handler));
    }

    public void printOptions(){
        Scanner inputScanner = new Scanner(System.in);
        Set<Integer> keySet = menuOptions.keySet();
        do {
            menuOptions.forEach((idx, opt) -> System.out.println(String.format("%d %s", idx, opt.getText())));
            Integer choice = null;
            do {
                choice = inputScanner.nextInt();
            } while (!menuOptions.containsKey(choice));

            this.menuOptions.get(choice).getHandler().accept(inputScanner);

            System.out.println();
        }while(!oneshot);
        //System.out.println(getText());
    }
}
