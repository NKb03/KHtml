/**
 * @author Nikolaus Knop
 */

package khtml.api

import java.nio.file.Paths

private fun createMarkdownStylesheets() {
    val appData = Paths.get(System.getProperty("LOCALAPPDATA")!!)
    val khtml = appData.resolve("khtml")
    val markdown = khtml.resolve("markdown-darkula.css")
}

fun markdown(out: Appendable, block: TagBuilder) {
    html(out) {
        head {
            stylesheet("")
        }
    }
}