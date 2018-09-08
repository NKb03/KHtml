package khtml.impl

import khtml.api.BodyBuilder
import khtml.api.TableBuilder
import khtml.api.TableRowBuilder

internal class TableBuilderImpl(parent: BodyBuilder) : BodyBuilder by parent, TableBuilder {
    override fun tr(block: TableRowBuilder.() -> Unit) {
        fun buildRow() {
            TableRowBuilderImpl(this).block()
        }
        "tr" { buildRow() }
    }
}