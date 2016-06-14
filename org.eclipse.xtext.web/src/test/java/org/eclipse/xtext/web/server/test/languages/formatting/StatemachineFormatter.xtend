/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test.languages.formatting

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import com.google.inject.Inject;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess

/**
 * This class contains custom formatting declarations.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class StatemachineFormatter extends AbstractDeclarativeFormatter {

	@Inject extension StatemachineGrammarAccess
	
	override protected void configureFormatting(FormattingConfig c) {
		c.setLinewrap(0, 1, 2).before(getSL_COMMENTRule)
		c.setLinewrap(0, 1, 2).before(getML_COMMENTRule)
		c.setLinewrap(0, 1, 1).after(getML_COMMENTRule)
		
		c.setLinewrap.before(inputSignalAccess.inputKeyword_1)
		c.setLinewrap.before(outputSignalAccess.outputKeyword_1)
		c.setLinewrap(1, 1, 2).before(stateAccess.stateKeyword_0)
		c.setIndentationIncrement.after(stateAccess.nameAssignment_1)
		c.setLinewrap.before(commandAccess.setKeyword_0)
		c.setLinewrap.before(transitionAccess.ifKeyword_0)
		c.setLinewrap.before(stateAccess.endKeyword_5)
		c.setIndentationDecrement.before(stateAccess.endKeyword_5)
	}
}
