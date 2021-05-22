package iv.main;

import iv.inventory.FrameInventory;
import iv.utils.JarLoader;

import java.io.IOException;

public class StartMain {
    public static void main(String[] args) {
        JarLoader loader = new JarLoader("/resources/config.yml");
        try {
            loader.copyToOut();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FrameInventory inventory = new FrameInventory("Lustful");
        inventory.initInventory();
    }
}
