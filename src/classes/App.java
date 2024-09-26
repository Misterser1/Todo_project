package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App extends JFrame {
    private TitleBar title;
    private List list;
    private ButtonP btnPanel;

    private JButton addTask;
    private JButton clear;
    //Приложение
    App(){
        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title = new TitleBar();
        list = new List();
        btnPanel = new ButtonP();
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        addTask = btnPanel.getNewTask();
        clear = btnPanel.getClear();

        addListen();

        this.setVisible(true);
    }

    public  void addListen() {
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Task task = new Task();
                list.add(task);
                list.updateNumbers();

                task.getDone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        task.changeState();
                        revalidate();
                    }
                });
                revalidate();
            }
        });

        clear.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                list.removeCompletedTasks();
                repaint();
            }
        });
    }
}
