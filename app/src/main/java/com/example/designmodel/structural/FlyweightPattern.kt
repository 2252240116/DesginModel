package com.example.designmodel.structural

import java.util.*


/**
 * todo 享元设计模式： 避免重复创建相同对象
 *          比如Java对象池的设计，Message.obtain获取message
 */

//假设有个请求的类
class Request

//通过一个地方 去拿请求
class HttpFactory {
    companion object {
        val requestMap = HashMap<String, Request>()
    }

    fun getRequestList(name: String): Request {
        var request = requestMap[name]
        if (request == null) {
            request = Request()
            requestMap[name] = request
        }
        return request
    }

    //使用
//    var factory = HttpFactory()
//    var request1 = factory.getRequestList("baidu")
//    //假设过了一会
//    var request2 = factory.getRequestList("baidu")

}