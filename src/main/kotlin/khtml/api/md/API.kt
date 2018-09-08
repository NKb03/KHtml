/**
 * @author Nikolaus Knop
 */

package khtml.api.md

import khtml.api.*

fun markdown(out: Appendable, theme: MarkdownTheme = Darkula, block: BodyBuilder.() -> Unit) {
    html(out) {
        head {
            stylesheet(theme.url)
        }
        body(block)
    }
}