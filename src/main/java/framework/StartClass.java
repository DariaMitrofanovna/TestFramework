package framework;

import java.nio.file.Path;

public class StartClass {
    public static void start(String  path) throws Exception{
        new TestFramework().start(path);
    }
}
