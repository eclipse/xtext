/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;
import org.eclipse.xtext.xbase.ui.hover.XbaseInformationControlInput;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XtendHoverProvider extends XbaseHoverProvider {

	@Inject
	private XtendHoverSerializer xtendHoverSerializer;

	@Override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject element, IRegion hoverRegion,
			XtextBrowserInformationControlInput previous) {
		XtextBrowserInformationControlInput hoverInfo = super.getHoverInfo(element, hoverRegion, previous);
		if(hoverInfo instanceof XbaseInformationControlInput){
			XbaseInformationControlInput xbaseHoverInfo = (XbaseInformationControlInput) hoverInfo;
			Pair<String, String> prefixAndSuffixPair = xtendHoverSerializer.computePreAndSuffix(element);
			String unsugaredExpression = xtendHoverSerializer.computeUnsugaredExpression(element);
			return new XbaseInformationControlInput(previous, xbaseHoverInfo, prefixAndSuffixPair.getFirst(), unsugaredExpression, prefixAndSuffixPair.getSecond());
		}
		return hoverInfo;
	}
	
	@Override
	protected boolean hasHover(EObject o) {
		return super.hasHover(o) || o instanceof XtendParameter || isMemberOfAnonymousClass(o);
	}

	protected boolean isMemberOfAnonymousClass(EObject o) {
		return o instanceof XtendMember 
				&& o.eContainer() instanceof AnonymousClass;
	}
}
