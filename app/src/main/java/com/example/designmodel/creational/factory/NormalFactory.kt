package com.example.designmodel.creational.factory

interface Clothes {
    val clothes: String
}

class Jacket : Clothes {
    override val clothes: String
        get() {
            return "夹克衫"
        }
}

class Sweater : Clothes {
    override val clothes: String
        get() {
            return "毛衣"
        }
}

/**
 * 工厂模式: 假设他是衣柜
 *  todo 解决接口选择问题
 * 安卓应用：比如获根据名字取闹钟服务
 * context.getSystemService(Service.ALARM_SERVICE)
 * String ALARM_SERVICE = "alarm"
 */
class WardrobeFactory {

    fun getShape(shape: String?): Clothes? {
        when (shape) {
            "Jacket" -> return Jacket()
            "Sweater" -> return Sweater()
        }
        return null
    }
}