package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Task extends JPanel {
    private JLabel index;
    private JTextField taskName;
    private JButton done;

    private boolean checked;
    private boolean isPlaceholderVisible; // Для отслеживания состояния плейсхолдера

    // Задания
    Task() {
        this.setPreferredSize(new Dimension(40, 20));
        this.setBackground(Color.black);

        this.setLayout(new BorderLayout());

        checked = false;

        index = new JLabel("");
        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        taskName = new JTextField("Твое задание здесь");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(Color.gray);

        isPlaceholderVisible = true;

        // Добавление FocusListener для JTextField
        taskName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isPlaceholderVisible) {
                    taskName.setText("");
                    isPlaceholderVisible = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (taskName.getText().isEmpty()) {
                    taskName.setText("Твое задание здесь");
                    isPlaceholderVisible = true;
                }
            }
        });

        this.add(taskName, BorderLayout.CENTER);

        done = new JButton("Готово");
        done.setPreferredSize(new Dimension(40, 20));
        done.setBorder(BorderFactory.createEmptyBorder());

        this.add(done, BorderLayout.EAST);
    }

    public JButton getDone() {
        return done;
    }

    public boolean getState() {
        return checked;
    }

    public void changeIndex(int num) {
        this.index.setText(num + "");
        this.revalidate();
    }

    public void changeState() {
        this.setBackground(Color.green);
        taskName.setBackground(Color.green);
        checked = true;
    }
}
