/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example;

import org.eclipse.xtext.example.contentassist.EcoreDslTemplateProposalProvider;
import org.eclipse.xtext.example.editor.outline.EcoreSemanticModelTransformer;
import org.eclipse.xtext.ui.core.editor.contentassist.ITemplateProposalProvider;

/**
 * used to manually extend and modify configuration for components used within
 * the IDE.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslUiModule extends AbstractEcoreDslUiModule {

	@Override
	public Class<? extends org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer> bindISemanticModelTransformer() {
		return EcoreSemanticModelTransformer.class;
	}
	
	@Override
	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		return EcoreDslTemplateProposalProvider.class;
	}
}
