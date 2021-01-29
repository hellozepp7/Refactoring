package 行为设计模式.命令模式.commands;

import 行为设计模式.命令模式.editor.Editor;

/**
 * <pre>
 * Description:
 *          从剪贴板粘贴文字
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class PasteCommand extends Command{

    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;
        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}
