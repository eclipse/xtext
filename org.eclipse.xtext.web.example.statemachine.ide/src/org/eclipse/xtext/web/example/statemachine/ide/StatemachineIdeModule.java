/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.ide;

import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider;

/**
 * Use this class to register ide components.
 */
public class StatemachineIdeModule extends AbstractStatemachineIdeModule {
	public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		return StatemachineWebContentProposalProvider.class;
	}

	public Class<? extends IImageDescriptionProvider> bindIImageDescriptionProvider() {
		return StatemachineImageDescriptionProvider.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return StatemachineSemanticHighlightingCalculator.class;
	}
}
