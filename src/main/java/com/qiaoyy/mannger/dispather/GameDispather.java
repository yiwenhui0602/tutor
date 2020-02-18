package com.qiaoyy.mannger.dispather;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * The type GameDispather.
 *
 * @author 何金成
 * @ClassName: GameDispather
 * @Description: 消息路由分发
 * @date 2015年12月14日 下午7:12:57
 */
@Component
public class GameDispather {

    /**
     * Init mgr.
     */
    public void initMgr() {
    }
    
 
    /**
     * 消息路由分发
     *
     * @param api
     * @param data
     */
    public  void dispatch(Api api, JSONObject data, ChannelHandlerContext ctx) {
        switch (api) {
            case TEST:
                // TEST CODE
                break;
            case STONE:
                break;
        }
    }
}
