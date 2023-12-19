package com.example.designmodel.creational

import android.util.Log

/**
 * todo 建造者模式：配置复杂对象 (核心使用内部类方式）
 *
 * Dialog.Builder().setCancelable(false).setTitle("对话框").build().show()
 */
class BuilderPattern internal constructor(var title: String?, mCanclable: Boolean) {
    var mCancelable = false

    init {
        mCancelable = mCanclable
    }

    fun show() {
        Log.e("日志", "show")
    }

    internal class Builder {
        var title: String? = null
        var mCancelable = false

        fun setCancelable(flag: Boolean): Builder {
            mCancelable = flag
            return this
        }

        fun setTitle(title: String?): Builder {
            this.title = title
            return this
        }

        fun build(): BuilderPattern {
            return BuilderPattern(
                title,
                mCancelable
            )
        }
    }
}