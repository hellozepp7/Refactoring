package 行为设计模式.命令模式.commands;

import 行为设计模式.命令模式.editor.Editor;

/**
 * <pre>
 * Description:
 *          将所选文字复制到剪贴板
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
