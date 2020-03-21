/*******************************************************************************
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class TestLanguageProposalCreator extends IdeContentProposalCreator {

	@Override
	public ContentAssistEntry createProposal(String proposal, String prefix, ContentAssistContext context, String kind,
		Procedure1<? super ContentAssistEntry> init) {
		ContentAssistEntry entry = super.createProposal(proposal, prefix, context, kind, init);
		if (entry != null && kind == ContentAssistEntry.KIND_KEYWORD && "{".equals(proposal)) {
			// just for testing purposes
			entry.getTextReplacements().add(new ReplaceRegion(context.getOffset() + 1, 0, "}"));
		}
		return entry;
	}

}
