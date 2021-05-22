package iv.inventory;

import iv.utils.VFlowLayout;

import javax.swing.*;

public class FrameInventory extends JFrame {
    private String title;
    public FrameInventory(String title){
        this.title = title;
    }
    public JPanel getRightPanel(){
        return new JPanel();
    }
    public void initInventory(){
        this.setTitle(this.title);
        this.setSize(800 , 500);
        this.setLayout(new VFlowLayout());
        this.setVisible(true);
    }
}
