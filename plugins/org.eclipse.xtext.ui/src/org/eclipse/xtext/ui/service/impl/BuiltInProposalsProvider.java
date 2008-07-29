/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.xtext.ui.editor.model.IEditorModel;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class BuiltInProposalsProvider extends AbstractProposalsProvider {

	@Override
	public ICompletionContext computeContext(IEditorModel model, ITextViewer viewer, int offset) {
		return null;
	}

	@Override
	public List<ICompletionProposal> getProposals(ICompletionContext context) {
		return null;
	}

	@Override
	protected void registerContextTypes(ContributionContextTypeRegistry registry) {
	}
	
}
