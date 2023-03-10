/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.testlanguages.ui.tests.ReferenceGrammarUiTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(ReferenceGrammarUiTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class ReferenceGrammarUiContentAssistTest extends AbstractContentAssistTest {
	
	@Test public void testComputePrefix() throws Exception {
		String model = "spielplatz 1 \"SpielplatzBeschreibung\" { kind(k1 0) kind(k2 0) erwachsener(e1 0) erwachsener(e2 0) ";
		newBuilder()
		.append(model+" familie( dfv(").assertMatchString("(").reset()
		.append(model+" familie( dfv").assertMatchString("dfv").reset()
		.append(model+" familie( dfv_").assertMatchString("dfv_").reset()
		.append(model+" familie( dfv_ ").assertMatchString("").reset()
		.append("").assertMatchString("");
	}

	@Test public void testComputeCompletionProposalsCount() throws Exception {
		newBuilder().assertCount(1)
			.append("spielplatz ").assertCount(1)
			.append("1 ").assertCount(2)
			.append("\"JUNIT\" ").assertCount(1)
			.append("{ ").assertCount(5)
			.append("kind ").assertCount(1)
			.append("(k1 0) erwachsener(e1 0) erwachsener(e2 0) familie( f1 ").assertCount(2)
			.append("e1 ").assertCount(2)
			.append("e2").assertCount(1);
	}

	@Test public void testComputeCompletionProposalsText() throws Exception {
		newBuilder().assertText("spielplatz")
			.applyProposal().append(" ").assertText("1")
			.append("1 ").assertText("\"Beschreibung\"", "{")
			.append("\"Beschreibung\" ").assertText("{")
			.applyProposal().append(" ").assertText("erwachsener", "familie", "spielzeug", "kind", "}")
			.append("erwachsener ").assertText("(")
			.applyProposal().append(" ").assertText("Name")
			.append("e1 ").assertText("1")
			.append("1 ").assertText(")")
			.applyProposal().append(" ").append("erwachsener (e2 0) kind ").assertText("(")
			.applyProposal().append(" ").assertText("Name")
			.append("k1 ").assertText("1")
			.append("1 ").assertText(")")
			.applyProposal().append(" ").append("kind (k2 0) familie ").assertText("(")
			.applyProposal().append(" ").assertText("keyword", "\"Name\"", "Name")
			.append("keyword ").assertText("e1","e2")
			.applyProposal().append(" ").assertText("e1","e2")
			.append("e2 ").assertText("k1","k2")
			.append("k").assertText("k1","k2",",",")")
			.append("1 ").assertText(",",")")
			.append(",k2 ").assertText(",",")")
		;
	}
	
	@Test public void testComputeCompletionProposalsText_02() throws Exception {
		newBuilder().
			append("spielplatz 1 \"Beschreibung\" { " +
					"erwachsener ( e1 1 ) " +
					"erwachsener (e2 0) " +
					"kind ( k1 1 ) " +
					"kind (k2 0) " +
					"familie ( keyword e1 e2 k1, k2 ").assertText(",",")")
		;
	}
	
	@Test public void testComputeCompletionProposalsText_03() throws Exception {
		newBuilder().
			append("spielplatz 1 \"Beschreibung\" { " +
					"erwachsener ( e1 1 ) " +
					"erwachsener (e2 0) " +
					"kind ( k1 1 ) " +
					"kind (k2 0) " +
					"familie ( keyword e1 e2 k1 k2 ").assertText() // parse error, cannot propose something
		;
	}
	
	@Test public void testBetweenContext() throws Exception {
		newBuilder()
		.append("spielplatz 1 \"1\" {kind")
		.assertTextAtCursorPosition(18,"kind","erwachsener","spielzeug","familie","{", "}");
	}

	@Test public void testComputeCompletionProposalsIgnoreCase() throws Exception {
		ContentAssistProcessorTestBuilder builder = newBuilder();
		builder = builder.append("spielplatz 1 \"SpielplatzBeschreibung\" { kind(k1 0) kind(k2 0) erwachsener(e1 0) erwachsener(e2 0) ");
		builder.append(" KI").assertText("kind");
		builder.append(" ER").assertText("erwachsener");
		builder.append(" SP").assertText("spielzeug");
		builder.append(" FA").assertText("familie");
		builder.append(" familie ( KEY").assertText("keyword");
		builder.append(" familie ( K").assertText("keyword");
		builder.append(" familie ( keyword E").assertText("e1", "e2");
		builder.append(" familie ( keyword e1 E").assertText("e1", "e2");
		builder.append(" familie ( keyword e1 e2 K").assertText("k1", "k2", ",", ")");
		builder.append(" familie ( keyword e1 e2 k1,K").assertText("k1", "k2",",", ")");
		builder.append(" familie ( keyword e1 e2 k1,k2").assertText("k2", ",", ")");
	}
	
	@Test public void testDefaultRule() throws Exception {
		ContentAssistProcessorTestBuilder builder = newBuilder();
		builder.assertText("spielplatz");
		builder.append(" spielplatz 1 \"SpielplatzBeschreibung\" { } ")
			.assertTextAtCursorPosition(1, "spielplatz");
	}

}
