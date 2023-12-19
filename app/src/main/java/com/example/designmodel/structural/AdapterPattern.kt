package com.example.designmodel.structural

/**
 * todo 适配器设计模式：Adapter只管展示，不管具体如何展示。让两个没有关联的类一起使用，提高复用
 *      ListView Rv GridView
 */

//定义适配器类
open class Adapter {
    fun getView(i: Int) {
        println("给出View$i")
    }
}

//ListView 继承了Adapter
class ListView : Adapter() {
    fun show() {
        print("循环显示View")
        for (i in 0..2) {
            getView(i)
        }
    }
}

//GridView继承了Adapter
class GridView : Adapter() {
    fun show() {
        getView(0)
    }
}