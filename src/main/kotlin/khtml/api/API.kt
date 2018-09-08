/**
 * @author Nikolaus Knop
 */

package khtml.api

import khtml.impl.BodyBuilderImpl
import khtml.impl.HeadBuilderImpl
import khtml.impl.TableBuilderImpl
import khtml.impl.TopLevelBuilderImpl
import java.nio.file.Files
import java.nio.file.Files.*
import java.nio.file.Paths

fun html(out: Appendable, block: TopLevelBuilder.() -> Unit) {
    with(TopLevelBuilderImpl(out)) {
        "html" {
            this@with.block()
        }
    }
}

fun TopLevelBuilder.body(block: BodyBuilder.() -> Unit) {
    "body" {
        BodyBuilderImpl(this@body).block()
    }
}

fun TopLevelBuilder.head(block: HeadBuilder.() -> Unit) {
    "head" {
        HeadBuilderImpl(this@head).block()
    }
}

fun HeadBuilder.stylesheet(src: String) {
    "link" - {
        "rel" - "stylesheet"
        "type" - "text/css"
        "href" - src
    }
}

fun HeadBuilder.script(src: String) {
    "script" ({
        "src" - src
    }) {}
}

fun HeadBuilder.title(title: String) {
    "title" {
        content(title)
    }
}

fun BodyBuilder.p(block: Appendable.() -> Unit) {
    "p" {
        content(block)
    }
}

fun BodyBuilder.p(text: String) {
    p { append(text) }
}

fun BodyBuilder.h(n: Int, text: String) {
    require(n in 1..6) { "N must be in range 1..6" }
    "h$n"(text)
}

fun BodyBuilder.h1(text: String) {
    "h1"(text)
}

fun BodyBuilder.h2(text: String) {
    "h2"(text)
}

fun BodyBuilder.h3(text: String) {
    "h3"(text)
}

fun BodyBuilder.h4(text: String) {
    "h4"(text)
}

fun BodyBuilder.h5(text: String) {
    "h5"(text)
}

fun BodyBuilder.h6(text: String) {
    "h6"(text)
}

fun BodyBuilder.quote(block: TagBuilder.() -> Unit) {
    "quote" { block() }
}

fun BodyBuilder.quote(text: String) {
    quote {
        p(text)
    }
}

fun BodyBuilder.code(block: Appendable.() -> Unit) {
    "code" {
        content(block)
    }
}

fun BodyBuilder.code(text: String) {
    code { append(text) }
}

fun BodyBuilder.img(alt: String, src: String, attributes: AttributeBuilder.() -> Unit = {  }) {
    "img" - {
        "alt" - alt
        "src" - src
        attributes()
    }
}

fun BodyBuilder.ul(items: TagBuilder.() -> Unit) {
    "ul" { items() }
}

fun BodyBuilder.ol(items: TagBuilder.() -> Unit) {
    "ol" { items() }
}

fun BodyBuilder.table(block: TableBuilder.() -> Unit) {
    TableBuilderImpl(this).block()
}

fun BodyBuilder.em(text: String) {
    "em"(text)
}

fun BodyBuilder.strong(text: String) {
    "strong"(text)
}

val BodyBuilder.br: Unit
    get() {
    "br"()
}

fun BodyBuilder.div(cls: String, block: TagBuilder.() -> Unit) {
    "div"({"class" - cls}, block)
}

fun BodyBuilder.div(cls: String) {
    "div" - {
        "class" - cls
    }
}

fun BodyBuilder.span(cls: String, block: TagBuilder.() -> Unit) {
    "div"({"class" - cls}, block)
}

fun BodyBuilder.span(cls: String) {
    "div" - {
        "class" - cls
    }
}

fun BodyBuilder.label(text: String, attributes: AttributeBuilder.() -> Unit = {  }) {
    "label"(attributes) { content(text) }
}

fun BodyBuilder.button(text: String, attributes: AttributeBuilder.() -> Unit = {  }) {
    "button"(attributes) {
        content(text)
    }
}

val BodyBuilder.hr: Unit
    get() {
        div("hr")
    }

fun main(args: Array<String>) {
    val path = Paths.get("out.html")
    if (!exists(path)) createFile(path)
    val os = newOutputStream(path)
    val out = os.writer()
    html(out) {
        head {
            title("title")
            script("script.js")
            stylesheet("theme.css")
        }
        body {
            p("hello")
            "tag" {
                "another"("text")
            }
        }
    }
    out.close()
    os.close()
}