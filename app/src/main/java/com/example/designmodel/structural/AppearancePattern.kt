package com.example.designmodel.structural

/**
 * todo 外观模式：降低系统复杂度，灵活，安全。但违反了开闭原则和迪特米原则。
 *   开闭原则：对类的扩展是开放，对修改关闭。在程序需要扩展的时候，对于一个类，不要去修改原来的代码，而是通过继承的方式去扩展这个类。降低维护风险
 *   迪特米原则：一个对象应当对 其他 对象尽可能少的了解。 目的：自己做自己的事情
 *   核心：将功能聚合到一个类中，Android中Context就是外观模式，比如context可以启动activity,广播，service
 */

//接口  有个打开的动作
interface Action {
    fun open()
}

//灯 实现了  开灯
class Lamp : Action {
    override fun open() {
        println("开灯")
    }
}

//电视 实现了 打开电视
class TV : Action {
    override fun open() {
        println("开电视")
    }
}

//遥控器  可以控制灯 和电视
class RemoteControl {
    var lamp: Action
    var tv: Action
    init {
        lamp = Lamp()
        tv = TV()
    }

    fun openLamp() {
        lamp.open()
    }

    fun openTv() {
        tv.open()
    }
}