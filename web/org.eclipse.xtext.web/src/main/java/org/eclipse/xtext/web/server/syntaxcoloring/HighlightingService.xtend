package org.eclipse.xtext.web.server.syntaxcoloring

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.web.server.model.AbstractPreComputedService
import org.eclipse.xtext.web.server.model.IXtextWebDocument

class HighlightingService extends AbstractPreComputedService<HighlightingResult> {
	
	@Inject extension ISemanticHighlightingCalculator
	
	protected def IHighlightedPositionAcceptor createHighlightedPositionAcceptor(List<HighlightRegion> positions) {
		[
			positions += new HighlightRegion($0, $1, $2)			
		]
	}
	
	override compute(IXtextWebDocument it, CancelIndicator cancelIndicator) {
		val regions = <HighlightRegion>newArrayList
		val IHighlightedPositionAcceptor acceptor = createHighlightedPositionAcceptor(regions)
		resource.provideHighlightingFor(acceptor)
		new HighlightingResult(stateId, regions)
	}
}