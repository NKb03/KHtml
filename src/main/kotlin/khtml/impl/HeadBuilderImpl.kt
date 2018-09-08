/**
 *@author Nikolaus Knop
 */

package khtml.impl

import khtml.api.HeadBuilder
import khtml.api.HtmlBuilder
import khtml.api.TopLevelBuilder

internal class HeadBuilderImpl(parent: TopLevelBuilder): HeadBuilder, HtmlBuilder by parent