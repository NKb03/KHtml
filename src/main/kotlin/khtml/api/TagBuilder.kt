/**
 * @author Nikolaus Knop
 */

package khtml.api

interface TagBuilder : BodyBuilder {
    fun content(block: Appendable.() -> Unit)

    fun content(str: String)
}