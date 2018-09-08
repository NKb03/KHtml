/**
 *@author Nikolaus Knop
 */

package khtml.impl

import khtml.api.TopLevelBuilder

internal class TopLevelBuilderImpl(out: Appendable) : TopLevelBuilder, AbstractHtmlBuilder(out)