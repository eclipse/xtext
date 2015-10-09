/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import com.google.inject.Singleton
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.resource.IEObjectDescription

/**
 * Determines priorities for content assist proposal entries. The priorities can be used
 * to sort the list of proposals.
 * @noreference
 */
@Singleton
@Accessors(PROTECTED_GETTER, PROTECTED_SETTER)
class IdeContentProposalPriorities {
	
	int crossRefPriority = 500
	
	int defaultPriority = 400
	
	int keywordPriority = 300
	
	protected def adjustPriority(ContentAssistEntry entry, int priority) {
		var adjustedPriority = priority
		if (!Character.isLetter(entry.proposal.charAt(0)))
			adjustedPriority -= 30
		if (entry.proposal == entry.prefix)
			adjustedPriority -= 20
		return adjustedPriority
	}
	
	def int getCrossRefPriority(IEObjectDescription objectDesc, ContentAssistEntry entry) {
		adjustPriority(entry, crossRefPriority)
	}
	
	def int getDefaultPriority(ContentAssistEntry entry) {
		adjustPriority(entry, defaultPriority)
	}
	
	def int getKeywordPriority(String keyword, ContentAssistEntry entry) {
		adjustPriority(entry, keywordPriority)
	}
	
}
