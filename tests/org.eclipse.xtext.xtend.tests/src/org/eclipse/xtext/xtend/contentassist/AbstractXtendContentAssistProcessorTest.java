/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.common.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.common.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistProcessorTestSetup;
import org.eclipse.xtext.ui.core.editor.contentassist.IContentProposalProvider;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractXtendContentAssistProcessorTest extends AbstractContentAssistProcessorTest {

	@Override
	protected ContentAssistProcessorTestBuilder newBuilder(ISetup setup) throws Exception {
		ContentAssistProcessorTestBuilder newBuilder = super.newBuilder(setup);
		IContentProposalProvider proposalProvider = newBuilder.get(IContentProposalProvider.class);
		assertTrue(proposalProvider.toString(), proposalProvider instanceof AbstractXtendProposalProvider);
		return newBuilder;
	}

	@Override
	protected IContentAssistProcessorTestSetup createSetup() {
		return new XtendContentAssistProcessorTestSetup();
	}

}

