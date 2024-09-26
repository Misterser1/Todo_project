package classes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonP extends JPanel{

    private JButton addTask;
    private JButton clear;
    private ButtonP btnPanel;

    Border emptyBorder = BorderFactory.createEmptyBorder();
    //Кнопки
    ButtonP() {
        this.setPreferredSize(new Dimension(400, 60));


        addTask = new JButton("Добавить задание");
        addTask.setBorder(emptyBorder);
        addTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        this.add(addTask);

        this.add(Box.createHorizontalStrut(20));//Space between buttons
        clear = new JButton("Удалить задания");
        clear.setFont(new Font("Sans-serif",Font.PLAIN, 20));
        clear.setBorder(emptyBorder);
        //clear.setBackground();
        this.add(clear);
    }

    public JButton getNewTask()
    {
        return addTask;
    }

    public  JButton getClear() {
        return clear;
    }
}
