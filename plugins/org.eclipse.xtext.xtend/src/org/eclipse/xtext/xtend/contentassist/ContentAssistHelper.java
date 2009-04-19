/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.XtextCompletionProposal;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Michael Clay
 */
public class ContentAssistHelper {

	public static ICompletionProposal newProposal(AbstractElement element, String text,
			IContentAssistContext contentAssistContext) {
		return new XtextCompletionProposal(element, text, contentAssistContext,null);
	}

	public static IScope getScope(IScopeProvider scopeProvider, Object context, Object reference) {
		if (reference == null)
			return null;
		EObject eContext = (EObject) context;
		IScope scope = scopeProvider.getScope(EcoreUtil.getRootContainer(eContext), eContext, (EReference) reference);
		return scope;
	}
}
