package 行为设计模式.命令模式.commands;

import 行为设计模式.命令模式.editor.Editor;

/**
 * <pre>
 * Description:
 *          将文字剪切到剪贴板
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class CutCommand extends Command{

    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.textField.getSelectedText() == null || editor.textField.getSelectedText().isEmpty()) return false;
        backup();
        String source = editor.textField.getText();
        editor.clipboard = editor.textField.getSelectedText();
        editor.textField.setText(cutString(source));
        return true;
    }

    private String cutString(String source) {
        String start = source.substring(0, editor.textField.getSelectionStart());
        String end = source.substring(editor.textField.getSelectionEnd());
        return start + end;
    }
}
