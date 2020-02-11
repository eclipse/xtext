/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide

import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator
import org.eclipse.xtext.util.ReplaceRegion

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class TestLanguageProposalCreator extends IdeContentProposalCreator {

	override createProposal(String proposal, String prefix, ContentAssistContext context, String kind,
		(ContentAssistEntry)=>void init) {
		val entry = super.createProposal(proposal, prefix, context, kind, init)
		if (entry !== null && kind == ContentAssistEntry.KIND_KEYWORD && proposal == '{') {
			// just for testing purposes
			entry.textReplacements += new ReplaceRegion(context.offset + 1, 0, '}')
		}
		entry
	}

}
