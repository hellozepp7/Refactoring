package 行为设计模式.命令模式.editor;

import sun.plugin.dom.html.HTMLBodyElement;
import 行为设计模式.命令模式.commands.Command;
import 行为设计模式.命令模式.commands.CommandHistory;
import 行为设计模式.命令模式.commands.CopyCommand;
import 行为设计模式.命令模式.commands.CutCommand;
import 行为设计模式.命令模式.commands.PasteCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <pre>
 * Description:
 *           文字编辑器的 GUI
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class Editor {

    public JTextArea textField;
    public String clipboard;
    private final CommandHistory history = new CommandHistory();

    public void init(){
        //初始化图形面板
        JFrame frame = new JFrame("文本编辑器（键入和使用按钮)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        Editor editor = this;
        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(editor)));
        ctrlX.addActionListener(e -> executeCommand(new CutCommand(editor)));
        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(editor)));
        ctrlZ.addActionListener(e -> undo());
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void executeCommand(Command command) {
        if (command.execute())  history.push(command);
    }


    private void  undo() {
        if (history.isEmpty()) return;
        Command command = history.pop();
        if (command != null) command.undo();
    }

}
