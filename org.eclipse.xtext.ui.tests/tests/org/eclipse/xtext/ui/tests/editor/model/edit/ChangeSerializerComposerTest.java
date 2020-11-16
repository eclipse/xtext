/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model.edit;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ui.editor.model.edit.ChangeSerializerTextEditComposer;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ChangeSerializerComposerTest extends AbstractTextEditComposerTest {

	@Override
	protected ITextEditComposer createComposer() {
		return get(ChangeSerializerTextEditComposer.class);
	}

	@Override
	@Test
	@Ignore
	public void testRemoveRootObject() throws Exception {
		super.testRemoveRootObject();
	}

	@Override
	@Test
	@Ignore
	public void testReplaceRootObject() throws Exception {
		super.testReplaceRootObject();
	}

	@Override
	@Ignore
	@Test
	public void testObjectReplacement() throws Exception {
		// doesn't work because of xtext.xtext still uses old formatter.
		super.testObjectReplacement();
	}

	@Override
	@Test public void testMultiEdit() throws Exception {
		Resource res = getResource(newTestGrammar());

		composer.beginRecording(res);
		Grammar grammar = (Grammar) res.getContents().get(0);
		ParserRule fooRule = (ParserRule) grammar.getRules().get(0);
		ParserRule barRule = (ParserRule) grammar.getRules().get(1);
		Alternatives fooAlternatives = (Alternatives) fooRule.getAlternatives();
		barRule.setAlternatives(fooAlternatives.getElements().remove(0));
		TextEdit edit = composer.endRecording();

		assertTrue(edit instanceof MultiTextEdit);
		TextEdit[] children = ((MultiTextEdit) edit).getChildren();
		assertEquals(2, children.length);
		assertMatches("'bar' | 'baz'", children[0]);
		assertMatches("Bar: 'foo';", children[1]);
	}
}
