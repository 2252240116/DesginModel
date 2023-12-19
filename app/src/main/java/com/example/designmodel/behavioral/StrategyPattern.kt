package com.example.designmodel.behavioral


/**
 * todo 策略设计模式：解决if else 过多问题
 *
 */

//排列的方式
interface Layout {
    fun doLayout()
}

//竖着排列
class LinearLayout : Layout {
    override fun doLayout() {
        println("LinearLayout")
    }
}

//网格排列
class GridLayout : Layout {
    override fun doLayout() {
        println("GridLayout")
    }
}

class RecyclerView {
    private var layout: Layout? = null
    fun setLayout(layout: Layout?) {
        this.layout = layout
        this.layout?.doLayout()
    }
}

//假如RecyclerView 这样写 //这样写if就很多了
//class RecyclerView {
//    private var layout: Layout? = null
//    fun setLayout(layout: Layout) {
//        this.layout = layout
//        if (layout === "横着") {
//        } else if (layout === "竖着") {
//        } else if (layout === "格子") {
//        } else {
//        }
//        this.layout!!.doLayout()
//    }
//}