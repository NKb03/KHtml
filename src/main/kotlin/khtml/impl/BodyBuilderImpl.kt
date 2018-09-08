/**
 *@author Nikolaus Knop
 */

package khtml.impl

import khtml.api.BodyBuilder
import khtml.api.HtmlBuilder
import khtml.api.TopLevelBuilder

internal class BodyBuilderImpl(parent: TopLevelBuilder) : BodyBuilder, HtmlBuilder by parent {
    override fun String.invoke(content: String) {
        this {
            content(content)
        }
    }
}