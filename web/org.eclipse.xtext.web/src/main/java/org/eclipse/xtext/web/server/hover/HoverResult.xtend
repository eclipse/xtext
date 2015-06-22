package org.eclipse.xtext.web.server.hover

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.web.server.IServiceResult

@Data
@ToString(skipNulls = true)
class HoverResult implements IServiceResult {
	
	String title
	String content
}