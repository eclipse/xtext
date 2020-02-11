/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

import com.google.common.base.Function;

public class ContentProposalProvider extends AbstractJavaBasedContentProposalProvider {
	public Function<IEObjectDescription, ICompletionProposal> getProposalFactory(ContentAssistContext contentAssistContext) {
		return super.getProposalFactory("", contentAssistContext);
	}


}