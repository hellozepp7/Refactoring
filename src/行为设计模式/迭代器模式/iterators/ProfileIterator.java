package 行为设计模式.迭代器模式.iterators;

import 行为设计模式.迭代器模式.profile.Profile;

/**
 * <pre>
 * Description:
 *          定义档案接口，所有迭代器的通用接口
 * @author Zepp Deng
 * @date 2021/1/18
 * </pre>
 */
public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();

}
