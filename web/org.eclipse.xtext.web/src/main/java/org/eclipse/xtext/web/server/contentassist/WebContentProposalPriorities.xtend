/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.contentassist

import com.google.inject.Singleton
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.IEObjectDescription

@Singleton
@Accessors(PROTECTED_GETTER, PROTECTED_SETTER)
class WebContentProposalPriorities {
	
	int crossRefPriority = 500
	
	int defaultPriority = 400
	
	int keywordPriority = 300
	
	protected def adjustPriority(ContentAssistResult.Entry entry, int priority) {
		var adjustedPriority = priority
		if (!Character.isLetter(entry.proposal.charAt(0)))
			adjustedPriority -= 30
		if (entry.proposal == entry.prefix)
			adjustedPriority -= 20
		return adjustedPriority
	}
	
	def int getCrossRefPriority(IEObjectDescription objectDesc, ContentAssistResult.Entry entry) {
		adjustPriority(entry, crossRefPriority)
	}
	
	def int getDefaultPriority(ContentAssistResult.Entry entry) {
		adjustPriority(entry, defaultPriority)
	}
	
	def int getKeywordPriority(String keyword, ContentAssistResult.Entry entry) {
		adjustPriority(entry, keywordPriority)
	}
	
}