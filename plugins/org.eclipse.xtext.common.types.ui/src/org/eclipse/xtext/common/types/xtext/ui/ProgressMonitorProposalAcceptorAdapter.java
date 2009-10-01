/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ProgressMonitorProposalAcceptorAdapter extends NullProgressMonitor {

	private final ICompletionProposalAcceptor delegate;

	public ProgressMonitorProposalAcceptorAdapter(ICompletionProposalAcceptor delegate) {
		if (delegate == null)
			throw new IllegalArgumentException("delegate may not be null");
		this.delegate = delegate;
	}
	
	@Override
	public boolean isCanceled() {
		return !delegate.canAcceptMoreProposals();
	}
	
}
