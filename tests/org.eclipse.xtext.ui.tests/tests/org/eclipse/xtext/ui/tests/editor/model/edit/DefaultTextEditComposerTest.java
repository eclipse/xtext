/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model.edit;

import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.SerializerUtil;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DefaultTextEditComposerTest extends AbstractXtextTests {

	private ITextEditComposer composer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
		composer = get(ITextEditComposer.class);
	}

	private InputStream newTestGrammar() {
		return new StringInputStream("grammar foo.Foo " + "generate foo 'foo://foo/42' "
				+ "Foo: 'foo' | 'bar' | 'baz'; " + "Bar: foo=Foo; ");
	}

	public void testProtocol() throws Exception {
		Resource res = getResource(newTestGrammar());
		assertNull(composer.endRecording());
		composer.beginRecording(res);
		assertNull(composer.endRecording());
		assertNull(composer.endRecording());
		composer.beginRecording(res);
		Grammar grammar = (Grammar) res.getContents().get(0);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		rule.setName("Bar");
		assertNotNull(composer.endRecording());
		assertNull(composer.endRecording());
	}

	public void testRemoveRootObject() throws Exception {
		Resource res = getResource(newTestGrammar());

		composer.beginRecording(res);
		res.getContents().clear();
		TextEdit edit = composer.endRecording();

		assertEquals("", ((ReplaceEdit) edit).getText());
	}

	public void testReplaceRootObject() throws Exception {
		Resource res = getResource(newTestGrammar());

		composer.beginRecording(res);
		Grammar grammar = (Grammar) getResource(
				new StringInputStream("grammar bar.Bar " + "generate bar 'bar://bar/43' " + "Bar: 'bar'; "))
				.getContents().get(0);
		res.getContents().set(0, grammar);
		TextEdit edit = composer.endRecording();

		assertMatches(grammar, edit);
	}

	public void testObjectAddition() throws Exception {
		Resource res = getResource(newTestGrammar());

		composer.beginRecording(res);
		Grammar grammar = (Grammar) res.getContents().get(0);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		Alternatives alternatives = (Alternatives) rule.getAlternatives();
		Keyword keyword = XtextFactory.eINSTANCE.createKeyword();
		keyword.setValue("qux");
		alternatives.getGroups().add(keyword);
		TextEdit edit = composer.endRecording();

		assertMatches(alternatives, edit);
	}

	public void testObjectRemoval() throws Exception {
		Resource res = getResource(newTestGrammar());

		composer.beginRecording(res);
		Grammar grammar = (Grammar) res.getContents().get(0);
		AbstractRule rule = grammar.getRules().get(0);
		Alternatives alternatives = (Alternatives) rule.getAlternatives();
		alternatives.getGroups().remove(2);
		TextEdit edit = composer.endRecording();

		assertMatches(alternatives, edit);
	}

	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=292349 */
	public void testObjectModificationAndRemoval() throws Exception {
		Resource res = getResource(newTestGrammar());

		composer.beginRecording(res);
		Grammar grammar = (Grammar) res.getContents().get(0);
		AbstractRule rule = grammar.getRules().get(0);
		Alternatives alternatives = (Alternatives) rule.getAlternatives();
		Keyword bazKeyword = (Keyword) alternatives.getGroups().get(2);
		bazKeyword.setValue("BAZ");
		alternatives.getGroups().remove(bazKeyword);
		TextEdit edit = composer.endRecording();

		assertMatches(alternatives, edit);
	}

	public void testObjectReplacement() throws Exception {
		Resource res = getResource(newTestGrammar());

		composer.beginRecording(res);
		Grammar grammar = (Grammar) res.getContents().get(0);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		Keyword keyword = XtextFactory.eINSTANCE.createKeyword();
		keyword.setValue("baz");
		rule.setAlternatives(keyword);
		TextEdit edit = composer.endRecording();

		assertMatches(rule, edit);
	}

	public void testMultiEdit() throws Exception {
		Resource res = getResource(newTestGrammar());

		composer.beginRecording(res);
		Grammar grammar = (Grammar) res.getContents().get(0);
		ParserRule fooRule = (ParserRule) grammar.getRules().get(0);
		ParserRule barRule = (ParserRule) grammar.getRules().get(1);
		Alternatives fooAlternatives = (Alternatives) fooRule.getAlternatives();
		barRule.setAlternatives(fooAlternatives.getGroups().remove(0));
		TextEdit edit = composer.endRecording();

		assertTrue(edit instanceof MultiTextEdit);
		TextEdit[] children = ((MultiTextEdit) edit).getChildren();
		assertEquals(2, children.length);
		assertMatches(fooAlternatives, children[0]);
		assertMatches(barRule, children[1]);
	}

	private void assertMatches(EObject obj, TextEdit edit) {
		assertTrue(edit instanceof ReplaceEdit);
		AbstractNode node = NodeUtil.getNodeAdapter(obj).getParserNode();
		assertEquals(node.getTotalOffset(), ((ReplaceEdit) edit).getOffset());
		SerializerUtil.SerializationOptions serializationOptions = new SerializerUtil.SerializationOptions();
		serializationOptions.setFormat(false);
		assertEqualsIgnoringWhitespace(getSerializer().serialize(obj, serializationOptions), ((ReplaceEdit) edit).getText());
	}

	private void assertEqualsIgnoringWhitespace(String expected, String actual) {
		assertEquals(expected.replaceAll("\\s+", " "), actual.replaceAll("\\s+", " "));
	}

}
