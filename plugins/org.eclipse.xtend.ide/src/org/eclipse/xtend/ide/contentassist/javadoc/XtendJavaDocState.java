/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
