package ui.controller;

import java.util.Properties;
import java.util.Properties;

public abstract class Credentials {
    static public void setPass(Properties dbProperties) {
        dbProperties.setProperty("user", "local_r123456");
        dbProperties.setProperty("password", "dagadegijniebepalen!");
    }
}
