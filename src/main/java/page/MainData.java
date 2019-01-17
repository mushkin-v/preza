package page;

import utils.Properties;

public class MainData {
    public static String trello = (String) new Properties().readProperties("URLTRELLO", "/src/main/java/resources/project.properties");
    public static String loginTrello = (String) new Properties().readProperties("login", "/src/main/java/resources/project.properties");
    public static String boardTrello = (String) new Properties().readProperties("board", "/src/main/java/resources/project.properties");
    public static String cardTrello = (String) new Properties().readProperties("card", "/src/main/java/resources/project.properties");
}