package 行为设计模式.命令模式.commands;


import 行为设计模式.命令模式.editor.Editor;

/**
 * <pre>
 * Description:
 *          抽象基础命令
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public abstract class Command {

    public Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();

}
