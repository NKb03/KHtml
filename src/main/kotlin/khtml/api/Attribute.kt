package khtml.api

class Attribute internal constructor(val name: String, val value: String) {
    override fun toString(): String {
        return "$name = $value "
    }
}

operator fun String.minus(value: Int) = Attribute(this, value.toString())

operator fun String.minus(value: Double) = Attribute(this, value.toString())

operator fun String.minus(value: String) = Attribute(this, value)

operator fun String.minus(value: Pixel) = Attribute(this, value.toString())

operator fun String.minus(value: Percent) = Attribute(this, value.toString())

class Pixel internal constructor(private val value: Int) {
    override fun toString(): String = "${value}px"
}

val Int.px get() = Pixel(this)

class Percent internal constructor(private val value: Int) {
    override fun toString(): String = "$value%"
}

val Int.percent get() = Percent(this)



