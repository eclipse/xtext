/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Objects;
import com.google.inject.Singleton;

/**
 * Determines priorities for content assist proposal entries. The priorities can be used to sort the list of proposals.
 * 
 * @noreference
 */
@Singleton
public class IdeContentProposalPriorities {
	private int crossRefPriority = 500;

	private int defaultPriority = 400;

	private int keywordPriority = 300;

	protected int adjustPriority(ContentAssistEntry entry, int priority) {
		if (entry == null) {
			return priority;
		}
		int adjustedPriority = priority;
		if (!Character.isLetter(entry.getProposal().charAt(0))) {
			adjustedPriority = adjustedPriority - 30;
		}
		if (Objects.equal(entry.getProposal(), entry.getPrefix())) {
			adjustedPriority = adjustedPriority - 20;
		}
		return adjustedPriority;
	}

	public int getCrossRefPriority(IEObjectDescription objectDesc, ContentAssistEntry entry) {
		return adjustPriority(entry, this.crossRefPriority);
	}

	public int getDefaultPriority(ContentAssistEntry entry) {
		return adjustPriority(entry, this.defaultPriority);
	}

	public int getKeywordPriority(String keyword, ContentAssistEntry entry) {
		return adjustPriority(entry, this.keywordPriority);
	}

	protected int getCrossRefPriority() {
		return crossRefPriority;
	}

	protected void setCrossRefPriority(int crossRefPriority) {
		this.crossRefPriority = crossRefPriority;
	}

	protected int getDefaultPriority() {
		return defaultPriority;
	}

	protected void setDefaultPriority(int defaultPriority) {
		this.defaultPriority = defaultPriority;
	}

	protected int getKeywordPriority() {
		return keywordPriority;
	}

	protected void setKeywordPriority(int keywordPriority) {
		this.keywordPriority = keywordPriority;
	}
}
