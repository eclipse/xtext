package org.eclipse.xtext.web.server.syntaxcoloring

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.web.server.IServiceResult

@Data
class HighlightingResult implements IServiceResult {
	
	val String stateId
	val regions = <HighlightRegion>newArrayList
	
	new(String stateId, Iterable<HighlightRegion> regions) {
		this.stateId = stateId
		this.regions += regions
	}
}