package org.eclipse.xtext.web.server.syntaxcoloring

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

class HighlightingService {
	
	@Inject extension ISemanticHighlightingCalculator
	
	def HighlightingResult calculateHighlighting(XtextWebDocumentAccess document) {
		document.readOnly[ it, cancelIndicator |
			val regions = <HighlightRegion>newArrayList
			val IHighlightedPositionAcceptor acceptor = createHighlightedPositionAcceptor(regions)
			resource.provideHighlightingFor(acceptor)
			new HighlightingResult(stateId, regions)
		]
	}
	
	protected def IHighlightedPositionAcceptor createHighlightedPositionAcceptor(List<HighlightRegion> positions) {
		[
			positions += new HighlightRegion($0, $1, $2)			
		]
	} 
}