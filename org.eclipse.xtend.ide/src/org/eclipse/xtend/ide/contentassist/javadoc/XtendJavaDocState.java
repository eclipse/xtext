/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.javadoc;

import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

/**
 * @author Holger Schill - Initial contribution and API
 */
public interface XtendJavaDocState {

	public IScopeProvider getScopeProvider();

	public ContentAssistContext.Factory getContextFactory();

	public ITypesProposalProvider getTypesProposalProvider();

	public XtendJavaDocProposalFactory getProposalFactory();

}
