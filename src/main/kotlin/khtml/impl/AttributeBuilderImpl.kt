package khtml.impl

import khtml.api.Attribute
import khtml.api.AttributeBuilder
import khtml.api.Percent
import khtml.api.Pixel

internal class AttributeBuilderImpl(private val out: Appendable) : AttributeBuilder {
    private fun addAttribute(name: String, value: Any) {
        out.append(" ")
        out.append(name)
        out.append("=")
        out.append(value.toString())
    }

    internal fun addAttribute(attribute: Attribute) {
        addAttribute(attribute.name, attribute.value)
    }

    override fun String.minus(value: Int) {
        addAttribute(this, value)
    }

    override fun String.minus(value: Double) {
        addAttribute(this, value)
    }

    override fun String.minus(value: String) {
        addAttribute(this, "\"value\"")
    }

    override fun String.minus(value: Pixel) {
        addAttribute(this, value)
    }

    override fun String.minus(value: Percent) {
        addAttribute(this, value)
    }
}
