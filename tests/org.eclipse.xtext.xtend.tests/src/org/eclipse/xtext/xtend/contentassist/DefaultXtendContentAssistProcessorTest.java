/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class DefaultXtendContentAssistProcessorTest extends DefaultContentAssistProcessorTest {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessorTest#newBuilder(java.lang.String)
	 */
	@Override
	protected ContentAssistProcessorTestBuilder newBuilder(ISetup setup) throws Exception {
		ContentAssistProcessorTestBuilder newBuilder = super.newBuilder(setup);
		assertTrue(newBuilder.get(IProposalProvider.class) instanceof AbstractXtendProposalProvider);
		return newBuilder;
	}

}

