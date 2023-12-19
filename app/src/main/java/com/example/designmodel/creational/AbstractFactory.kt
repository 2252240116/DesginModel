package com.example.designmodel.creational

//裤子
interface Trousers {
    val trousers: Unit
}
//牛仔裤
class Jeans : Trousers {
    override val trousers: Unit
        get() {
            println("牛仔裤")
        }
}
//短裤
class Shorts : Trousers {
    override val trousers: Unit
        get() {
            println("短裤")
        }
}

//衣服
interface Clothes {
    val clothes: Unit
}
//毛衣
class Sweater : Clothes {
    override val clothes: Unit
        get() {
            println("毛衣")
        }
}
//夹克衫
class Jacket : Clothes {
    override val clothes: Unit
        get() {
            println("夹克衫")
        }
}

//抽象工厂
//衣服和裤子都有了，抽象工厂
//抽象工厂，这个工厂需要完成 那衣服 和 裤子
abstract class AbsFactory {
    abstract fun getTrousers(trousers: String?): Trousers?
    abstract fun getClothes(clothes: String?): Clothes?
}

//生产衣服
class ClothesFactory : AbsFactory() {
    override fun getTrousers(trousers: String?): Trousers? {
        return null
    }

    override fun getClothes(clothes: String?): Clothes? {
        when (clothes) {
            "Jacket" -> return Jacket()
            "Sweater" -> return Sweater()
        }
        return null
    }
}

//生产裤子
class TrousersFactory : AbsFactory() {
    override fun getTrousers(trousers: String?): Trousers? {
        when (trousers) {
            "Shorts" -> return Shorts()
            "Jeans" -> return Jeans()
        }
        return null
    }

    override fun getClothes(shape: String?): Clothes? {
        return null
    }
}

//衣橱类
/**
 * todo 解决接口选择问题 当产品种类很多的时候 根据名字去拿到种类对象 再去获取具体实例对象
 */
class WardrobeFactory {
    //使用

    //拿裤子
    var absFactory =
        getFactory("Trousers")
    //具体拿什么裤子
    var shorts = absFactory?.getTrousers("Shorts")

    companion object {
        fun getFactory(choice: String?): AbsFactory? {
            when (choice) {
                "Clothes" -> return ClothesFactory()
                "Trousers" -> return TrousersFactory()
            }
            return null
        }
    }
}