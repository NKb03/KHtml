/**
 *@author Nikolaus Knop
 */

package khtml.impl

import khtml.api.*

import khtml.impl.Constants.OPENING_BRACKET
import khtml.impl.Constants.CLOSING_BRACKET
import khtml.impl.Constants.SLASH
import khtml.impl.Constants.NEW_LINE

abstract class AbstractHtmlBuilder(private val out: Appendable): HtmlBuilder {
    override fun String.invoke(
        attributes: AttributeBuilder.() -> Unit,
        block: TagBuilder.() -> Unit
    ) {
        //open tag
        out.append(OPENING_BRACKET)
        out.append(this)
        AttributeBuilderImpl(out).attributes()
        out.append(CLOSING_BRACKET)
        out.append(NEW_LINE)
        //contents
        TagBuilderImpl(out).block()
        //close tag
        out.append(OPENING_BRACKET)
        out.append(SLASH)
        out.append(this)
        out.append(CLOSING_BRACKET)
        out.append(NEW_LINE)
    }

    override fun String.invoke(attributes: List<Attribute>, block: TagBuilder.() -> Unit) {
        this(attributes.toAttributeBuilder(), block)
    }

    override fun String.invoke(vararg attributes: Attribute, block: TagBuilder.() -> Unit) {
        this.invoke(attributes.asList(), block)
    }

    override fun String.minus(attributes: AttributeBuilder.() -> Unit) {
        out.append(OPENING_BRACKET)
        out.append(this)
        out.append(" ")
        AttributeBuilderImpl(out).attributes()
        out.append(CLOSING_BRACKET)
    }

    override fun String.invoke(attributes: List<Attribute>) {
        this.minus(attributes.toAttributeBuilder())
    }

    override fun String.invoke(vararg attributes: Attribute) {
        this.invoke(attributes.asList())
    }

    companion object {
        private fun List<Attribute>.toAttributeBuilder(): AttributeBuilder.() -> Unit {
            return {
                with(this as AttributeBuilderImpl) {
                    forEach(this::addAttribute)
                }
            }
        }
    }
}