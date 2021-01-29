package 行为设计模式.命令模式.commands;

import java.util.Stack;

/**
 * <pre>
 * Description:
 *          命令历史
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class CommandHistory {

    //堆栈保存命令历史记录
    private final Stack<Command> history = new Stack<>();

    //进栈
    public void push(Command c) {
        history.push(c);
    }

    //出栈
    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}
