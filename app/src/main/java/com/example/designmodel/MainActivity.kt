package com.example.designmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.designmodel.behavioral.*
import com.example.designmodel.creational.BuilderPattern
import com.example.designmodel.structural.DataBase
import com.example.designmodel.structural.ProxyDB
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BuilderPattern.Builder().setCancelable(false).setTitle("对话框").build().show()

        //使用
        var proxyDb: DataBase = ProxyDB()
        btn_show.text = proxyDb.select()

        //策略模式：选择LinearLayout策略
        RecyclerView().setLayout(LinearLayout())

        //使用
        var realInterceptor = RealInterceptor()
        btn_show.text = realInterceptor.request("请求->")

        ///观察者模式
        btn_obserable.setOnClickListener {
            var teacher = Teacher()
            var studentA = Student(teacher)
            var studentB = Student(teacher)
            var studentC = Student(teacher)
//            teacher.notifyAllStudent()
            teacher.dispatchHomeWork("English")
        }
    }
}