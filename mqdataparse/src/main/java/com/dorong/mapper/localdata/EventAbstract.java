package com.dorong.mapper.localdata;

/**
 * Event 事件处理抽象接口类
 * Created by xueping.you on 15-5-5.
 */
public interface EventAbstract<E,T>{

    /**
     * 插入开始日志
     * @param log  插入的日志
     * @return 插入的日志，方便之后更新
     */
    T logStart(T log);

    /** event Handler处理接口 **/
    void handle(E request) throws Exception;

    /**
     * 分析结束日志
     * @param log   插入的日志
     */
    void logEnd(T log);
}
