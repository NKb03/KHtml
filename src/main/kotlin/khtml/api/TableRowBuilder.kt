package khtml.api

interface TableRowBuilder: BodyBuilder {
    fun th(content: TagBuilder.() -> Unit)
}
