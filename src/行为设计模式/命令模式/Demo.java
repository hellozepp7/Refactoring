package 行为设计模式.命令模式;

import 行为设计模式.命令模式.editor.Editor;

/**
 * <pre>
 * Description:
 *      命令是一种行为设计模式,它可将请求或简单操作转换为一个对象
 *      文字编辑器在每次用户与其互动时， 都会创建一个新的命令对象。 命令执行其行为后会被压入历史堆栈。
 *      当程序执行撤销操作时， 它就需要从历史记录中取出最近执行的命令， 然后执行反向操作或者恢复由该命令保存的编辑器历史状态。
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class Demo {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }

}
