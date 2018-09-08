/**
 * @author Nikolaus Knop
 */

package khtml.api

interface BodyBuilder: HtmlBuilder {
    operator fun String.invoke(content: String)
}