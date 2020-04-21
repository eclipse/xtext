/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist;

import org.apache.log4j.Logger;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * Special content assist proposal provider for cross-references.
 * 
 * @noreference
 */
public class IdeCrossrefProposalProvider {

	private static final Logger LOG = Logger.getLogger(IdeCrossrefProposalProvider.class);

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private IdeContentProposalCreator proposalCreator;

	@Inject
	private IdeContentProposalPriorities proposalPriorities;

	public void lookupCrossReference(IScope scope, CrossReference crossReference, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor, Predicate<IEObjectDescription> filter) {
		try {
			for (IEObjectDescription candidate : queryScope(scope, crossReference, context)) {
				if (!acceptor.canAcceptMoreProposals()) {
					return;
				}
				if (filter.apply(candidate)) {
					ContentAssistEntry entry = createProposal(candidate, crossReference, context);
					acceptor.accept(entry, proposalPriorities.getCrossRefPriority(candidate, entry));
				}
			}
		} catch (UnsupportedOperationException uoe) {
			LOG.error("Failed to create content assist proposals for cross-reference.", uoe);
		}
	}

	protected Iterable<IEObjectDescription> queryScope(IScope scope, CrossReference crossReference,
			ContentAssistContext context) {
		return scope.getAllElements();
	}

	protected ContentAssistEntry createProposal(IEObjectDescription candidate, CrossReference crossRef,
			ContentAssistContext context) {
		return proposalCreator.createProposal(qualifiedNameConverter.toString(candidate.getName()), context, (e) -> {
			e.setSource(candidate);
			e.setDescription(candidate.getEClass() != null ? candidate.getEClass().getName() : null);
			e.setKind(ContentAssistEntry.KIND_REFERENCE);
		});
	}

	protected IQualifiedNameConverter getQualifiedNameConverter() {
		return qualifiedNameConverter;
	}

	protected IdeContentProposalCreator getProposalCreator() {
		return proposalCreator;
	}

}
