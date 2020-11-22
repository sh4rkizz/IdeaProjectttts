package sh4rkizz.Lab_I_21_22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminTable extends JFrame {
    private boolean isActiveSettingHttp = false;
    private final JMenuBar menu = new JMenuBar();

    private final JMenu execute = new JMenu("Execute");
    private final JMenu settings = new JMenu("Settings");

    private final JMenuItem useJson = new JMenuItem("Use .json File ✓");
    private final JMenuItem useHttp = new JMenuItem("Use Http Client ");

    private final JMenuItem getAll = new JMenuItem("Вывести на экран все записи");
    private final JMenuItem getById = new JMenuItem("Вывести элемент по 'id'");
    private final JMenuItem editById = new JMenuItem("Редактировать элемент по 'id'");
    private final JMenuItem deleteById = new JMenuItem("Удалить элемент по 'id'");
    private final JMenuItem addElement = new JMenuItem("Добавить новый элемент");

    private final JTextField id = new JTextField("id");
    private final JTextArea data = new JTextArea("data");
    private final JTextField isGood = new JTextField("isGood");
    private final JTextArea description = new JTextArea("description");

    private final ArrayList<JMenuItem> itemsMenu = new ArrayList<>();
    private final ArrayList<JTextField> textFields = new ArrayList<>();
    private String message;

    public static void main(String[] args) {
        new AdminTable("Warehouse").setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public AdminTable(String title) {
        final long start = System.currentTimeMillis();
        final JFrame container = new JFrame(title);

        fontMagic(container);
        listenerBuilder();
        focusListenerBuilder();

        container.setLayout(null);
        container.setResizable(false);
        container.setBounds(770, 170, 550, 400);
        container.setVisible(true);

        System.out.println(System.currentTimeMillis() - start);
    }

    public void fontMagic(Container container) {
        id.setBounds(40, 40, 60, 40);
        data.setBounds(40, 105, 230, 220);
        isGood.setBounds(130, 40, 140, 40);
        description.setBounds(300, 25, 200, 300);

        data.setLineWrap(true);
        data.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        textFields.add(id);
        container.add(data).setFont(new Font("Serif", Font.ITALIC, 18));
        textFields.add(isGood);
        container.add(description).setFont(new Font("Serif", Font.ITALIC, 18));

        itemsMenu.add(addElement);
        itemsMenu.add(getById);
        itemsMenu.add(getAll);
        itemsMenu.add(editById);
        itemsMenu.add(deleteById);

        menu.add(settings);
        menu.add(execute);
        container.add(menu).setBounds(0, 0, 155, 25);

        for (JTextField jTextField : textFields) {
            jTextField.setFont(new Font("Serif", Font.ITALIC, 18));
            jTextField.setHorizontalAlignment(JTextField.CENTER);

            container.add(jTextField);
        }

        for (JMenuItem jMenuItem : itemsMenu) {
            jMenuItem.setFont(new Font("Serif", Font.ITALIC, 18));
            execute.add(jMenuItem);
        }

        settings.setFont(new Font("Serif", Font.ITALIC, 20));
        execute.setFont(new Font("Serif", Font.ITALIC, 20));
        settings.add(useJson).setFont(new Font("Serif", Font.ITALIC, 18));
        settings.add(useHttp).setFont(new Font("Serif", Font.ITALIC, 18));
    }

    public void listenerBuilder() {
        useJson.addActionListener(event -> {
            isActiveSettingHttp = false;
            if (!useJson.getText().contains("✓")) {
                useJson.setText(useJson.getText() + " ✓");
                useHttp.setText(useHttp.getText().replace("✓", ""));
            }
        });

        useHttp.addActionListener(event -> {
            isActiveSettingHttp = true;
            if (!useHttp.getText().contains("✓")) {
                useHttp.setText(useHttp.getText() + " ✓");
                useJson.setText(useJson.getText().replace("✓", ""));
            }
        });

        getAll.addActionListener(event -> {
            try {
                if (!isActiveSettingHttp) message = new Impostor().getAll().toString();
                else message = new Client().getAll().toString();

                JOptionPane.showMessageDialog(null, message, "Item List", JOptionPane.PLAIN_MESSAGE);
            } catch (NullPointerException nullPtr) {
                JOptionPane.showMessageDialog(null,
                        "Item list is empty",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        getById.addActionListener(event -> {
            try {
                int currId = Integer.parseInt(id.getText());

                if (!isActiveSettingHttp) message = new Impostor().get(currId).toString().substring(0, new Impostor().get(currId).toString().length() - 1)
                            + ", \"description\": " + new Impostor().get(currId).getDescription() + "}";
                else message = new Client().get(currId).toString().substring(0, new Client().get(currId).toString().length() - 1)
                            + ", \"description\": " + new Client().get(currId).getDescription() + "}";

                JOptionPane.showMessageDialog(null, message, "Item by id", JOptionPane.PLAIN_MESSAGE);
            } catch (NumberFormatException nFe) {
                JOptionPane.showMessageDialog(null,
                        "Id is incorrect",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException nPtr) {
                JOptionPane.showMessageDialog(null,
                        "Item with such id was not found",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        editById.addActionListener(event -> {
            try {
                if (!isActiveSettingHttp) message = new Impostor().editItem(Integer.parseInt(id.getText()), new Item(Integer.parseInt(id.getText()),
                            data.getText(), Boolean.parseBoolean(isGood.getText()), description.getText())).toString();
                else message = new Client().editItem(Integer.parseInt(id.getText()), new Item(Integer.parseInt(id.getText()),
                            data.getText(), Boolean.parseBoolean(isGood.getText()), description.getText())).toString();

                JOptionPane.showMessageDialog(null, message, "New Edited Item", JOptionPane.PLAIN_MESSAGE);
            } catch (NumberFormatException nFe) {
                JOptionPane.showMessageDialog(null, "Some of inputs are incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException nPtr) {
                JOptionPane.showMessageDialog(null, "Item with such id was not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteById.addActionListener(event -> {
            try {
                boolean isExisting = false;
                if (!isActiveSettingHttp) {
                    List<Item> items = new Impostor().getAll();
                    for (Item item : items)
                        if (item.getId() == Integer.parseInt(id.getText())) {
                            isExisting = true;
                            break;
                        }
                    if (!isExisting) throw new NullPointerException();

                    new Impostor().deleteItem(Integer.parseInt(id.getText()));
                } else {
                    List<Item> items = new Client().getAll();

                    for (Item item : items)
                        if (item.getId() == Integer.parseInt(id.getText())) {
                            isExisting = true;
                            break;
                        }
                    if (!isExisting) throw new NullPointerException();
                    new Client().deleteItem(Integer.parseInt(id.getText()));
                }
                JOptionPane.showMessageDialog(null, "Item deleted", "Report", JOptionPane.PLAIN_MESSAGE);
            } catch (NullPointerException nPtr) {
                JOptionPane.showMessageDialog(null, "Item with such id was not found", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException nFe) {
                JOptionPane.showMessageDialog(null, "Id is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        addElement.addActionListener(event -> {
            try {
                Item item = new Item(Integer.parseInt(id.getText()), data.getText(),
                        Boolean.parseBoolean(isGood.getText()), description.getText());
                if (!isActiveSettingHttp) message = new Impostor().addItem(item).toString();
                else message = new Client().addItem(item).toString();

                JOptionPane.showMessageDialog(null, message, "New added Item", JOptionPane.PLAIN_MESSAGE);
            } catch (NullPointerException mPtr) {
                JOptionPane.showMessageDialog(null, "This id is already used", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException nFe) {
                JOptionPane.showMessageDialog(null, "Incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void focusListenerBuilder() {
        id.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (id.getText().equals("id")) id.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Objects.equals(id.getText(), ""))
                    id.setText("id");
            }
        });

        data.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (data.getText().equals("data")) data.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Objects.equals(data.getText(), ""))
                    data.setText("data");
            }
        });

        isGood.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isGood.getText().equals("isGood")) isGood.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Objects.equals(isGood.getText(), ""))
                    isGood.setText("isGood");
            }
        });

        description.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (description.getText().equals("description")) description.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Objects.equals(description.getText(), ""))
                    description.setText("description");
            }
        });
    }
}