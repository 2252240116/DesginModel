package com.example.designmodel.creational

/**
 * todo 原型模式 ： 快速高效创建对象  需要考虑深拷贝和浅拷贝问题
 *
    public class Intent implements Parcelable, Cloneable {
        @Override
        public Object clone() {
            return new Intent(this);
        }
    }

    //okhttp中 也用到了
    @Override public RealCall clone() {
        return RealCall.newRealCall(client, originalRequest, forWebSocket); }

 */
class PrototypePattern(var name: String) : Cloneable {

    public override fun clone(): Any {
        var obj: Any? = null
        try {
            obj = super.clone()
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return obj!!
    }

}