package com.example.designmodel.structural

/**
 * todo 装饰者模式：解决子类膨胀问题，在创建这个对象的时候还希望做一些其他的事情，
 *      例如 context启动startActivity时做一点其他业务
 *
 */

//一个煎饼接口
interface Pancake {
    fun pancake()
}

//牛肉煎饼
class BeefPancake : Pancake {
    override fun pancake() {
        println("牛肉煎饼")
    }
}

//工作人员
class Worker {
    var pancake: Pancake
    init {
        pancake = BeefPancake()
    }

    fun makePancake() {
        println("煎鸡蛋")
        pancake.pancake()
        println("撒酱")
    }

    //使用
//    var worker = Worker().makePancake()
}