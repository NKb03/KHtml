/**
 * @author Nikolaus Knop
 */

package khtml.api

import khtml.impl.HtmlDsl

@HtmlDsl
interface HtmlBuilder {
    operator fun String.invoke(attributes: AttributeBuilder.() -> Unit, block: TagBuilder.() -> Unit)

    operator fun String.invoke(attributes: List<Attribute>, block: TagBuilder.() -> Unit)

    operator fun String.invoke(vararg attributes: Attribute, block: TagBuilder.() -> Unit)

    operator fun String.minus(attributes: AttributeBuilder.() -> Unit)

    operator fun String.invoke(attributes: List<Attribute>)

    operator fun String.invoke(vararg attributes: Attribute)
}