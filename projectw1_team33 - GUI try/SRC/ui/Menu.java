package ui;

public class Menu {
    public static void MenuTitle(String Title) {
        System.out.println(Title);
        System.out.println("---------------------------------------");
    }
    public static String MenuOption(Integer optionNumber, String optionDescription ){
        return ("["+optionNumber+"] "+ optionDescription);
    }


}
