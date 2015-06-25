/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.syntaxcoloring

import com.google.inject.Inject
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor

/** 
 * Switches between legacy and new ISemanticHighlightingCalculator
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 * @noextend
 * @noimplement
 * @noreference
 */
class SemanticHighlightingCalculatorDelegate implements ISemanticHighlightingCalculator {
	
	@Inject(optional=true) org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator legacyDelegate
	@Inject(optional=true) ISemanticHighlightingCalculator newDelegate
	
	override provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if(newDelegate != null)
			newDelegate.provideHighlightingFor(resource, acceptor)
		else if(legacyDelegate != null)
			legacyDelegate.provideHighlightingFor(resource, [offset, length, id |acceptor.addPosition(offset, length, id)])
	}
}
