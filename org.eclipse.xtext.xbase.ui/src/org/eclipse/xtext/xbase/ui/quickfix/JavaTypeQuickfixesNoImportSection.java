/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.quickfix;

import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * Quickfixes for misspelled Java types. For languages that don't use an {@link org.eclipse.xtext.xtype.XImportSection}.
 * All others should use {@link JavaTypeQuickfixes} to get quickfixes for imports.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaTypeQuickfixesNoImportSection extends JavaTypeQuickfixes {
	
	@Override
	protected void createImportProposals(JvmDeclaredType contextType, Issue issue, String typeSimpleName,
			IJavaSearchScope searchScope, IssueResolutionAcceptor acceptor) throws JavaModelException {
	}

	@Override
	protected void parseImportSection(XImportSection importSection, IAcceptor<String> visiblePackages,
			IAcceptor<String> importedTypes) {
	}
}
