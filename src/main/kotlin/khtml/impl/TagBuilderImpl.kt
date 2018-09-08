package khtml.impl

import khtml.api.TagBuilder

internal class TagBuilderImpl(private val out: Appendable) : TagBuilder, AbstractHtmlBuilder(out) {
    override fun String.invoke(content: String) {
        this {
            content(content)
        }
    }

    override fun content(block: Appendable.() -> Unit) {
        out.block()
    }

    override fun content(str: String) {
        out.appendln(str)
    }
}
