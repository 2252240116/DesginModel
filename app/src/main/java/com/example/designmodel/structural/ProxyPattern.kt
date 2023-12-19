package com.example.designmodel.structural

/**
 * todo 代理模式：增强类的职责 有时候直接访问一个类可能会出现问题 可以间接的访问一个代理类
 *      优点：职责清晰，易扩展 缺点：代理类可能会比较复杂，导致访问速度比较慢
 *
 *  系统中， AIDL就是代理模式
 */


//访问数据库接口
interface DataBase {
    fun select(): String
}

//真正 做查询操作
class RealImage : DataBase {
    override fun select(): String {
        return "查询"
    }
}

//代理类
class ProxyDB : DataBase {
    var realImage: RealImage? = null

    init {
        if (realImage == null) {
            realImage = RealImage()
        }
    }

    override fun select(): String {
        return realImage?.select() ?: ""
    }

    //使用
//    var proxyDb: DataBase = ProxyDB()
}