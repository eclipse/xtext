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
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Michael Clay
 * @author Sebastian Zarnekow
 */
public class ContentAssistHelper {

	public static ICompletionProposal newProposal(AbstractElement element, String text, ContentAssistContext context) {
		if (text.regionMatches(true, 0, context.getPrefix(), 0,context.getPrefix().length())) {
			int replacementOffset = context.getReplaceRegion().getOffset();
			int replacementLength = context.getReplaceRegion().getLength();
			return new CompletionProposal(text, replacementOffset, replacementLength, text.length());
		}
		return null;
	}

	public static IScope getScope(IScopeProvider scopeProvider, Object context, Object reference) {
		if (reference == null)
			return null;
		IScope scope = scopeProvider.getScope((EObject) context, (EReference) reference);
		return scope;
	}
}
