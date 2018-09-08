package khtml.impl

import khtml.api.BodyBuilder
import khtml.api.TableRowBuilder
import khtml.api.TagBuilder

internal class TableRowBuilderImpl(parent: BodyBuilder) : TableRowBuilder, BodyBuilder by parent  {
    override fun th(content: TagBuilder.() -> Unit) {
        "th" { content() }
    }
}