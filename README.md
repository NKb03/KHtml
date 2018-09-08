**This README is work in progress**

# KHtml - A Html Dsl for Kotlin

KHtml is a Kotlin Dsl library that makes it incredibly easy to generate
Html files with Kotlin.

## Getting started

To write a Html file with KHtml just use the `html` fun from the
`khtml.api` package. The first parameter specifies the output.
It is of type `Appendable` so there could be a `StringWriter`,
a `OutputStreamWriter` or even the console.
```
val sw = StringWriter()
html(sw) {

}
```
This example just opens and closes a html tag.

## Head

In the html tag there can be a head tag which is specified like that:
```
html(output) {
    head {

    }
}
```
In the head tag you can specify stylesheets, scripts and the title:

```
html(output) {
    head {
        stylesheet("theme.css")
        script("script.js")
        title("title")
    }
}
```

## Body

The content of an html file belongs in the body tag.
This could be a paragraph or any other possibly nested tags.
An example

```
html(output) {
    //head
    body {
        //content
    }
}
```

## Literal tags

Inside the body tags can specified using the following style

```
html(output) {
    //head
    body {
        "tag" {
            "nestedTag" {
                content("content")
            }
        }
    }
}
```

You can see that we just use a string literal and then put the content
inside the braces. The content between the tags is specified using
`content`.

## Different build-in tags

### Paragraphs `p`

You can add a paragraph of text with the function `p`.
You can step for step append text inside the paragraph
```
//inside body
p {
    append("this ")
    append("is ")
    append("a paragraph")
}
```

Or just pass a hole string:

```
//inside body
p("this is a paragraph")
```

### Headings `h`

Headings can be specified by using the `h` fun and passing an integer parameter
or just using one of the `h[1-6]` functions.
Note that when passing an integer parameter it must be greater than 0 and
less than or equal to 6

```
//inside body
h(3, "this is a heading")
//or
h3("this is a heading")
```