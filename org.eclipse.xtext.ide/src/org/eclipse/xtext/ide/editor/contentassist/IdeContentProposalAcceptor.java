/*******************************************************************************
 * Copyright (c) 2016, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.11
 */
public class IdeContentProposalAcceptor
		implements IIdeContentProposalAcceptor, Comparator<Pair<Integer, ContentAssistEntry>> {

	@Inject
	private OperationCanceledManager operationCanceledManager;

	private boolean didAcceptAllProposals = true;
	
	protected CancelIndicator cancelIndicator;


	protected final Set<Pair<Integer, ContentAssistEntry>> entries = new TreeSet<Pair<Integer, ContentAssistEntry>>(
			this);

	/**
	 * @since 2.28
	 */
	public void setCancelIndicator(CancelIndicator cancelIndicator) {
		this.cancelIndicator = cancelIndicator;
	}

	@Override
	public void accept(ContentAssistEntry entry, int priority) {
		operationCanceledManager.checkCanceled(cancelIndicator);
		if (entry != null) {
			if (entry.getProposal() == null)
				throw new IllegalArgumentException("Proposal must not be null.");
			entries.add(Pair.of(priority, entry));
		}
	}

	@Override
	public boolean canAcceptMoreProposals() {
		return didAcceptAllProposals = entries.size() < 100;
	}

	@Override
	public boolean didAcceptAllProposals() {
		return didAcceptAllProposals;
	}

	@Override
	public int compare(Pair<Integer, ContentAssistEntry> p1, Pair<Integer, ContentAssistEntry> p2) {
		int prioResult = p2.getKey().compareTo(p1.getKey());
		if (prioResult != 0)
			return prioResult;
		String s1 = p1.getValue().getLabel() != null ? p1.getValue().getLabel() : p1.getValue().getProposal();
		String s2 = p2.getValue().getLabel() != null ? p2.getValue().getLabel() : p2.getValue().getProposal();
		int ignoreCase = s1.compareToIgnoreCase(s2);
		if (ignoreCase == 0) {
			return s1.compareTo(s2);
		}
		return ignoreCase;
	}

	public Iterable<ContentAssistEntry> getEntries() {
		return Iterables.transform(entries, e -> e.getValue());
	}

}
