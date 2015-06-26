package org.eclipse.xtext.web.server.syntaxcoloring

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.ToString

@Data
@ToString(singleLine=true)
class HighlightRegion {
	
	int offset
	int length
	String[] styleClasses
}