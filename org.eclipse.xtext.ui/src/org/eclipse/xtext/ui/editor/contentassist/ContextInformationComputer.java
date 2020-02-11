/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class ContextInformationComputer implements IUnitOfWork<IContextInformation[], XtextResource>, IContextInformationAcceptor {

	public interface State {
		ContentAssistContext.Factory getContextFactory();
		IContextInformationProvider getContextInformationProvider();
		IContextInformationAcceptor decorateAcceptor(IContextInformationAcceptor delegate);
	}

	private final int offset;
	private final ITextViewer viewer;
	private final State state;
	private final Collection<IContextInformation> information;

	public ContextInformationComputer(State state, ITextViewer viewer, int offset) {
		super();
		this.information = new LinkedHashSet<IContextInformation>();
		this.state = state;
		this.offset = offset;
		this.viewer = viewer;
	}

	@Override
	public IContextInformation[] exec(XtextResource resource) throws Exception {
		IContextInformationAcceptor acceptor = state.decorateAcceptor(this);
		ContentAssistContext[] contexts = state.getContextFactory().create(viewer, offset, resource);
		for (ContentAssistContext context: contexts) {
			if (acceptor.canAcceptMoreInformation())
				state.getContextInformationProvider().getContextInformation(context, acceptor);
		}
		if (information.isEmpty())
			return null;
		return information.toArray(new IContextInformation[information.size()]);
	}

	@Override
	public void accept(IContextInformation information) {
		this.information.add(information);
	}

	@Override
	public boolean canAcceptMoreInformation() {
		return true;
	}
}