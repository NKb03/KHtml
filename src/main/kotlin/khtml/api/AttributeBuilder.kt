/**
 * @author Nikolaus Knop
 */

package khtml.api

import khtml.impl.HtmlDsl

@HtmlDsl
interface AttributeBuilder {
    operator fun String.minus(value: Int)

    operator fun String.minus(value: Double)

    operator fun String.minus(value: String)

    operator fun String.minus(value: Pixel)

    operator fun String.minus(value: Percent)
}