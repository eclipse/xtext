/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.util.IInvocationHandler;

/**
 * Service interface for the {@link AbstractProposalProvider} to call either
 * Java methods or Xtend extensions to perform content assist for assignments.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IContentAssistInvocationHandler extends IInvocationHandler<List<? extends ICompletionProposal>> {
}
