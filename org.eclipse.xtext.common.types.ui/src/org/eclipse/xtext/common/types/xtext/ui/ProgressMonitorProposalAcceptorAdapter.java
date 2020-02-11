/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

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
