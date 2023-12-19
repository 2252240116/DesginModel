package com.example.designmodel.behavioral

import java.util.*


/**
 *  todo: 责任链设计模式：主要用于解耦
 *          无需关心细节，把消息传递给责任链
 *          事件分发，okhttp
 */

//责任链接口
interface Interceptor {
    fun chain(inData: String?): String?
}

//缓存
class CacheInterceptor : Interceptor {
    override fun chain(inData: String?): String? {
        var inData = inData
        return "加了缓存".let { inData += it; inData }
    }
}

//呼叫服务器
class CallServerInterceptor : Interceptor {
    override fun chain(inData: String?): String? {
        var inData = inData
        return "呼叫了服务器".let { inData += it; inData }
    }
}

//把责任 集合起来
class RealInterceptor {
    var list: MutableList<Interceptor> =
        ArrayList()

    init {
        list.add(CacheInterceptor())
        list.add(CallServerInterceptor())
    }

    fun request(st: String?): String? {
        var result: String? = ""
        for (i in list.indices) {
            result += list[i].chain(st)
        }
        return result
    }

//    //使用
//    var realInterceptor = RealInterceptor()
//    var result = realInterceptor.request("请求->")

}