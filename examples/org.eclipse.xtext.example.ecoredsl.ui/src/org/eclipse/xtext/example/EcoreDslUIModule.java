/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example;

import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.example.editor.outline.EcoreDslOutlinePage;


/**
 * used to manually extend and modify configuration for components used within the IDE.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslUIModule extends AbstractEcoreDslUiModule {

	public Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> bindIProposalProvider() {
		return org.eclipse.xtext.example.EcoreDslProposalProvider.class;
	}
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return EcoreDslOutlinePage.class;
	}
	public Class<? extends org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer> bindISemanticModelTransformer() {
		return EcoreDslOutlinePage.EcoreSemanticModelTransformer.class;
	}
}
