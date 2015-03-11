/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.core.linking.XtendLinkingDiagnosticMessageProvider;
import org.eclipse.xtext.util.Arrays;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.ui.quickfix.JavaTypeQuickfixes;

/**
 * Registers {@link JavaTypeQuickfixes Java type fixes} for feature calls that appear
 * to be type literals. The information is deduced from the issue user data key 
 * {@link XtendLinkingDiagnosticMessageProvider#TYPE_LITERAL key:TypeLiteral}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeLiteralAwareJavaTypeQuickfixes extends JavaTypeQuickfixes {

	@Override
	protected boolean isUseJavaSearch(EReference unresolvedReference, Issue issue) {
		if (!super.isUseJavaSearch(unresolvedReference, issue)) {
			boolean result = Arrays.contains(issue.getData(), XtendLinkingDiagnosticMessageProvider.TYPE_LITERAL);
			return result;
		}
		return true;
	}
	
}
