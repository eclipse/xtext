/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.acceptor.DebugSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.impl.NodeModelSemanticSequencer;
import org.eclipse.xtext.serializer.impl.RecursiveSemanticSequencer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SemanticSequencerTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SequencerTestLanguageStandaloneSetup.class);
	}

	private void testSequence(String stringModel) throws Exception {
		EObject model = getModel(stringModel).eContents().get(0);
		NodeModelSemanticSequencer nmSequencer = new NodeModelSemanticSequencer();
		EObject context = nmSequencer.findContexts(model, null).iterator().next();
		//		ISemanticSequencer semSequencer = get(ISemanticSequencer.class);
		IRecursiveSemanitcSequencer recSequencer = get(IRecursiveSemanitcSequencer.class);
		//		String actual = sequenceRecursively(sequencer, context, model, true);
		//		String expected = sequenceRecursively(nmsequencer, context, model, true);
		DebugSequenceAcceptor actual = new DebugSequenceAcceptor();
		DebugSequenceAcceptor expected = new DebugSequenceAcceptor();
		recSequencer
				.createSequence( /*semSequencer,*/context, model, actual, ISerializationDiagnostic.STDERR_ACCEPTOR);
		((RecursiveSemanticSequencer) recSequencer).setSemanticSequencer(nmSequencer);
		recSequencer.createSequence( /*nmSequencer,*/context, model, expected,
				ISerializationDiagnostic.STDERR_ACCEPTOR);
		//		String expected = sequenceRecursively(nmsequencer, context, model, true);
		assertEquals(expected.toString(), actual.toString());
	}

	public void testXtext() throws Exception {
		with(XtextStandaloneSetup.class);
		EObject model = getGrammarAccess().getGrammar();
		//		System.out.println(EmfFormatter.objToStr(model));
		EObject ctx = GrammarUtil.findRuleForName(getGrammarAccess().getGrammar(), "AbstractToken");
		//		ISemanticSequencer semSequencer = get(ISemanticSequencer.class);
		//		EObject ctx = semSequencer.findContexts(model, null).iterator().next();
		IRecursiveSemanitcSequencer recSequencer = get(IRecursiveSemanitcSequencer.class);
		DebugSequenceAcceptor actual = new DebugSequenceAcceptor();
		recSequencer.createSequence( /* semSequencer, */ctx, model, actual, ISerializationDiagnostic.STDERR_ACCEPTOR);
		//		String actual = sequenceRecursively(semSequencer, ctx, model, true);
		//		System.out.println(actual);
		assertNotNull(actual);
	}

	public void testSimpleGroup() throws Exception {
		testSequence("#1 a b");
	}

	public void testSimpleAlternative1() throws Exception {
		testSequence("#2 kw2 a");
	}

	public void testSimpleAlternative2() throws Exception {
		testSequence("#2 kw2 a");
	}

	public void testSimpleMultiplicities1() throws Exception {
		testSequence("#3 a kw1 b kw2 c d kw3 e f");
	}

	public void testSimpleMultiplicities2() throws Exception {
		testSequence("#3 a kw1 kw2 c kw3 e");
	}

	public void testSimpleMultiplicities3() throws Exception {
		testSequence("#3 a kw1 kw2 c kw3");
	}

	public void testGroupMultiplicities1() throws Exception {
		testSequence("#4 a kw1 b c kw2 d e f g kw3 h i j k");
	}

	public void testGroupMultiplicities2() throws Exception {
		testSequence("#4 a kw1 b c kw2 d e kw3 h i");
	}

	public void testGroupMultiplicities3() throws Exception {
		testSequence("#4 a kw1 b c kw2 d e kw3");
	}

	public void testAlternativeMultiplicities1() throws Exception {
		testSequence("#5 a kw2 b c kw3 d kw3 e kw4 g h kw5 i kw5 j");
	}

	public void testAlternativeMultiplicities2() throws Exception {
		testSequence("#5 kw1 a kw2 b kw4 g");
	}

	public void testAlternativeMultiplicities3() throws Exception {
		testSequence("#5 kw1 a kw2 kw3 b kw4 kw5 g");
	}

	public void testAlternativeMultiplicities4() throws Exception {
		testSequence("#5 kw1 a kw2 kw3 b kw4");
	}

	public void testList1a() throws Exception {
		testSequence("#6 a, b, c, d, e");
	}

	public void testList1b() throws Exception {
		testSequence("#6 a, b");
	}

	public void testList1c() throws Exception {
		testSequence("#6 a");
	}

	public void testList2a() throws Exception {
		testSequence("#7 a, b, c");
	}

	public void testList2b() throws Exception {
		testSequence("#7 a, b");
	}

	public void testList2c() throws Exception {
		testSequence("#7 a");
	}

	public void testList2d() throws Exception {
		testSequence("#7");
	}

	public void testSingleKeyword1() throws Exception {
		testSequence("#10 kw1");
	}

	public void testSingleKeyword2() throws Exception {
		testSequence("#10 kw2");
	}

	public void testSingleKeyword3() throws Exception {
		testSequence("#10 kw3");
	}

	public void testSingleKeyword1OrID() throws Exception {
		testSequence("#11 kw1");
	}

	public void testSingleKeywordOrID2() throws Exception {
		testSequence("#11 kw2");
	}

	public void testSingleKeywordOrID3() throws Exception {
		testSequence("#11 kw3");
	}

	public void testSingleKeywordOrID4() throws Exception {
		testSequence("#11 foo");
	}

	public void testSingleTerminals1() throws Exception {
		testSequence("#12 $1foo");
	}

	public void testSingleTerminals2() throws Exception {
		testSequence("#12 $2foo");
	}

	public void testSingleEnum1() throws Exception {
		testSequence("#13 kw1");
	}

	public void testSingleEnum2() throws Exception {
		testSequence("#13 kw1");
	}

	public void testSingleEnum3() throws Exception {
		testSequence("#13 kw1");
	}

	public void testSingleCrossReference1() throws Exception {
		testSequence("#14 $1foo $1foo");
	}

	public void testSingleCrossReference2() throws Exception {
		testSequence("#14 $2foo $2foo");
	}

	public void testSingleCrossReference3() throws Exception {
		testSequence("#14 $3foo $3foo");
	}

	public void testSingleContainmentReference1() throws Exception {
		testSequence("#15 kw1");
	}

	public void testSingleContainmentReference2() throws Exception {
		testSequence("#15 kw2");
	}

	public void testSingleContainmentReference3() throws Exception {
		testSequence("#15 kw3");
	}

	// TODO: test multiple keywords

	//	public void testList3a() throws Exception {
	//		testSequence("#8 a, b, c");
	//	}
	//
	//	public void testList3b() throws Exception {
	//		testSequence("#8 a");
	//	}
	//
	//	public void testList3c() throws Exception {
	//		testSequence("#8 kw3 a");
	//	}

	public void testDependentAlternative1_a() throws Exception {
		testSequence("#19 foo1");
	}

	public void testDependentAlternative1_b() throws Exception {
		testSequence("#19 foo kw1");
	}

	public void testDependentAlternative2_a() throws Exception {
		testSequence("#20 foo bar");
	}

	public void testDependentAlternative2_b() throws Exception {
		testSequence("#20 foo bar baz");
	}

	public void testDependentAlternative2_c() throws Exception {
		testSequence("#20 foo bar kw1");
	}

	public void testDependentAlternative2_d() throws Exception {
		testSequence("#20 foo kw1");
	}

	public void testOptional1_a() throws Exception {
		testSequence("#21 1 2 3");
	}

	public void testOptional1_b() throws Exception {
		testSequence("#21 0 0 1");
	}

	public void testOptional1_c() throws Exception {
		testSequence("#21 0 0 0");
	}

	public void testOptional1_d() throws Exception {
		testSequence("#21 0");
	}

	public void testOptional1_e() throws Exception {
		testSequence("#21 1");
	}

}