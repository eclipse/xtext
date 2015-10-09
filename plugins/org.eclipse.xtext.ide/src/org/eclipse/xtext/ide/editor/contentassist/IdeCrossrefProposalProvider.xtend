/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import com.google.common.base.Predicate
import com.google.inject.Inject
import org.apache.log4j.Logger
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope

/**
 * Special content assist proposal provider for cross-references.
 * @noreference
 */
class IdeCrossrefProposalProvider {
	
	static val LOG = Logger.getLogger(IdeCrossrefProposalProvider)
	
	@Accessors(PROTECTED_GETTER)
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	@Inject IdeContentProposalPriorities proposalPriorities
	
	def void lookupCrossReference(IScope scope, CrossReference crossReference, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor, Predicate<IEObjectDescription> filter) {
		try {
			for (candidate : queryScope(scope, crossReference, context)) {
				if (filter.apply(candidate)) {
					val entry = createProposal(candidate, crossReference, context)
					acceptor.accept(entry, proposalPriorities.getCrossRefPriority(candidate, entry))
				}
			}
		} catch (UnsupportedOperationException uoe) {
			LOG.error('Failed to create content assist proposals for cross-reference.', uoe)
		}
	}
	
	protected def queryScope(IScope scope, CrossReference crossReference, ContentAssistContext context) {
		if (context.prefix.empty) {
			return scope.allElements
		}
		val prefix = qualifiedNameConverter.toQualifiedName(context.prefix)
		scope.allElements.filter[matchesPrefix(prefix)]
	}
	
	protected def matchesPrefix(IEObjectDescription candidate, QualifiedName prefix) {
		val name = candidate.name
		val count = prefix.segmentCount
		if (count > name.segmentCount)
			return false
		for (var i = 0; i < count; i++) {
			val nameSegment = name.getSegment(i)
			val prefixSegment = prefix.getSegment(i)
			if (i < count - 1 && nameSegment != prefixSegment
				 	||	i == count - 1 && !nameSegment.regionMatches(true, 0, prefixSegment, 0, prefixSegment.length)) {
				return false
			}
		}
		return true
	}
	
	protected def ContentAssistEntry createProposal(IEObjectDescription candidate, CrossReference crossRef, ContentAssistContext context) {
		return new ContentAssistEntry => [
			prefix = context.prefix
			proposal = qualifiedNameConverter.toString(candidate.name)
			description = candidate.getEClass?.name
		]
	}
	
}
