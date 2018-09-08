/**
 * @author Nikolaus Knop
 */

package khtml.api

interface TableBuilder {
    fun tr(block: TableRowBuilder.() -> Unit)
}