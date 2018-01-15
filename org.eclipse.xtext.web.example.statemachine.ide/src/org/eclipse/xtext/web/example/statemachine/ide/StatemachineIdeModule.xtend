/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.ide

import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider

/**
 * Use this class to register ide components.
 */
class StatemachineIdeModule extends AbstractStatemachineIdeModule {
	
	def Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		return StatemachineWebContentProposalProvider
	}

	def Class<? extends IImageDescriptionProvider> bindIImageDescriptionProvider() {
		return StatemachineImageDescriptionProvider
	}

	def Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return StatemachineSemanticHighlightingCalculator
	}
	
}
