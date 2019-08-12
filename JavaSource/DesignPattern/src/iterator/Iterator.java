package DesignPattern.src.iterator;

/**
 * 数え上げ、走査（スキャン）を行うインターフェース
 */
public interface Iterator{
    /**
     * 次要素があるかどうかの条件判断
     */
    public abstract boolean hasNext();
    /**
     * 実際に要素をreturnさせ、状態を次に進める（for文でいうところのi++）
     */
    public abstract Object next();
}