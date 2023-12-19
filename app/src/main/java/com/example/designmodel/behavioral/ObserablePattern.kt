package com.example.designmodel.behavioral

import java.util.*

/**
 * todo 观察者设计模式 目的：一个对象改变通知其他对象，保证协作
                     优点：观察者和被观察者是  抽象耦合的，也就是说通过抽象方法，给具体的类通知
 */

//抽象类 做作业
abstract class DoWork {
    protected open var teacher: Teacher? = null
    abstract fun doHomeWork(someThing: String)
}

//老师
class Teacher {
    private val students: MutableList<Student> = ArrayList()
    private var someThing = "语文"
    fun attach(student: Student) {
        students.add(student)
    }

    ///改变index
    fun dispatchHomeWork(someThing: String) {
        this.someThing = someThing
        notifyAllStudent()
    }

    fun notifyAllStudent() {
        for (stu in students) {
            stu.doHomeWork(someThing)
        }
    }
}

//学生类  持有老师 并且继承基础事务doWork
class Student(teacher: Teacher) : DoWork() {
    override fun doHomeWork(someThing: String) {
        println("学生${this}:做作业$someThing")
    }

    //使用
    override var teacher: Teacher? = Teacher()

    init {
        this.teacher = teacher
        this.teacher?.attach(this)
    }
}