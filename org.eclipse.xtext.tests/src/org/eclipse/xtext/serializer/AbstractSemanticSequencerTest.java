/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.NodeModelSemanticSequencer;
import org.eclipse.xtext.serializer.sequencertest.NullCrossRef;
import org.eclipse.xtext.serializer.sequencertest.NullValue;
import org.eclipse.xtext.serializer.serializer.SequencerTestLanguageSemanticSequencer;
import org.eclipse.xtext.testing.serializer.DebugSequenceAcceptor;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSemanticSequencerTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SequencerTestLanguageStandaloneSetup.class);
		getInjector().injectMembers(this);
	}

	@Inject
	private Provider<ISemanticSequencer> generatedSequencerProvider;

	@Inject
	private NodeModelSemanticSequencer nmSequencer;

	protected abstract ISemanticSequencer getGenericSemanticSequencer();

	private EObject testSequence(String stringModel) throws Exception {
		DebugSequenceAcceptor genericActual = new DebugSequenceAcceptor();
		DebugSequenceAcceptor generatedActual = new DebugSequenceAcceptor();
		DebugSequenceAcceptor expected = new DebugSequenceAcceptor();

		ISemanticSequencer generatedSequencer = generatedSequencerProvider.get();
		ISemanticSequencer genericSequencer = getGenericSemanticSequencer();

		assertTrue(generatedSequencer instanceof SequencerTestLanguageSemanticSequencer);

		generatedSequencer.init(generatedActual, ISerializationDiagnostic.STDERR_ACCEPTOR);
		genericSequencer.init(genericActual, ISerializationDiagnostic.STDERR_ACCEPTOR);
		nmSequencer.init(expected, ISerializationDiagnostic.STDERR_ACCEPTOR);

		EObject model = getModel(stringModel).eContents().get(0);
		ISerializationContext context = nmSequencer.findContexts(model, true, null).iterator().next();

		generatedSequencer.createSequence(context, model);
		genericSequencer.createSequence(context, model);
		nmSequencer.createSequence(context, model);

		assertEquals(expected.toString(), genericActual.toString());
		assertEquals(expected.toString(), generatedActual.toString());
		return model;
	}

	@Test
	@Ignore
	public void testXtext() throws Exception {
		//		with(XtextStandaloneSetup.class);
		//		EObject model = getGrammarAccess().getGrammar();
		//		//		System.out.println(EmfFormatter.objToStr(model));
		//		EObject ctx = GrammarUtil.findRuleForName(getGrammarAccess().getGrammar(), "AbstractToken");
		//		//		ISemanticSequencer semSequencer = get(ISemanticSequencer.class);
		//		//		EObject ctx = semSequencer.findContexts(model, null).iterator().next();
		//		ISyntacticSequencer synSeq = get(PassThroughSyntacticSequencer.class);
		//		IHiddenTokenSequencer hiddenSeq = get(PassThroughHiddenTokenSequencer.class);
		//		IRecursiveSequencer recSequencer = get(IRecursiveSequencer.class);
		//		((IHiddenTokenSequencerOwner) recSequencer).setHiddenTokenSequencer(hiddenSeq);
		//		((ISyntacticSequencerOwner) hiddenSeq).setSyntacticSequencer(synSeq);
		//		DebugSequenceAcceptor actual = new DebugSequenceAcceptor();
		//		recSequencer.createSequence( /* semSequencer, */ctx, model, actual, ISerializationDiagnostic.STDERR_ACCEPTOR);
		//		//		String actual = sequenceRecursively(semSequencer, ctx, model, true);
		//		//		System.out.println(actual);
		//		assertNotNull(actual);
	}

	@Test
	public void testSimpleGroup() throws Exception {
		testSequence("#1 a b");
	}

	@Test
	public void testSimpleAlternative1() throws Exception {
		testSequence("#2 kw2 a");
	}

	@Test
	public void testSimpleAlternative2() throws Exception {
		testSequence("#2 kw2 a");
	}

	@Test
	public void testSimpleMultiplicities1() throws Exception {
		testSequence("#3 a kw1 b kw2 c d kw3 e f");
	}

	@Test
	public void testSimpleMultiplicities2() throws Exception {
		testSequence("#3 a kw1 kw2 c kw3 e");
	}

	@Test
	public void testSimpleMultiplicities3() throws Exception {
		testSequence("#3 a kw1 kw2 c kw3");
	}

	@Test
	public void testGroupMultiplicities1() throws Exception {
		testSequence("#4 a kw1 b c kw2 d e f g kw3 h i j k");
	}

	@Test
	public void testGroupMultiplicities2() throws Exception {
		testSequence("#4 a kw1 b c kw2 d e kw3 h i");
	}

	@Test
	public void testGroupMultiplicities3() throws Exception {
		testSequence("#4 a kw1 b c kw2 d e kw3");
	}

	@Test
	public void testAlternativeMultiplicities1() throws Exception {
		testSequence("#5 a kw2 b c kw3 d kw3 e kw4 g h kw5 i kw5 j");
	}

	@Test
	public void testAlternativeMultiplicities2() throws Exception {
		testSequence("#5 kw1 a kw2 b kw4 g");
	}

	@Test
	public void testAlternativeMultiplicities3() throws Exception {
		testSequence("#5 kw1 a kw2 kw3 b kw4 kw5 g");
	}

	@Test
	public void testAlternativeMultiplicities4() throws Exception {
		testSequence("#5 kw1 a kw2 kw3 b kw4");
	}

	@Test
	public void testList1a() throws Exception {
		testSequence("#6 a, b, c, d, e");
	}

	@Test
	public void testList1b() throws Exception {
		testSequence("#6 a, b");
	}

	@Test
	public void testList1c() throws Exception {
		testSequence("#6 a");
	}

	@Test
	public void testList2a() throws Exception {
		testSequence("#7 a, b, c");
	}

	@Test
	public void testList2b() throws Exception {
		testSequence("#7 a, b");
	}

	@Test
	public void testList2c() throws Exception {
		testSequence("#7 a");
	}

	@Test
	public void testList2d() throws Exception {
		testSequence("#7");
	}

	@Test
	public void testSingleKeyword1() throws Exception {
		testSequence("#10 kw1");
	}

	@Test
	public void testSingleKeyword2() throws Exception {
		testSequence("#10 kw2");
	}

	@Test
	public void testSingleKeyword3() throws Exception {
		testSequence("#10 kw3");
	}

	@Test
	public void testSingleKeyword1OrID() throws Exception {
		testSequence("#11 kw1");
	}

	@Test
	public void testSingleKeywordOrID2() throws Exception {
		testSequence("#11 kw2");
	}

	@Test
	public void testSingleKeywordOrID3() throws Exception {
		testSequence("#11 kw3");
	}

	@Test
	public void testSingleKeywordOrID4() throws Exception {
		testSequence("#11 foo");
	}

	@Test
	public void testSingleTerminals1() throws Exception {
		testSequence("#12 $1foo");
	}

	@Test
	public void testSingleTerminals2() throws Exception {
		testSequence("#12 $2foo");
	}

	@Test
	public void testSingleEnum1() throws Exception {
		testSequence("#13 kw1");
	}

	@Test
	public void testSingleEnum2() throws Exception {
		testSequence("#13 kw1");
	}

	@Test
	public void testSingleEnum3() throws Exception {
		testSequence("#13 kw1");
	}

	@Test
	public void testSingleCrossReference1() throws Exception {
		testSequence("#14 $1foo $1foo");
	}

	@Test
	public void testSingleCrossReference2() throws Exception {
		testSequence("#14 $2foo $2foo");
	}

	@Test
	public void testSingleCrossReference3() throws Exception {
		testSequence("#14 $3foo $3foo");
	}

	@Test
	public void testSingleContainmentReference1() throws Exception {
		testSequence("#15 kw1");
	}

	@Test
	public void testSingleContainmentReference2() throws Exception {
		testSequence("#15 kw2");
	}

	@Test
	public void testSingleContainmentReference3() throws Exception {
		testSequence("#15 kw3");
	}

	@Test
	@Ignore("TODO: test multiple keywords")
	public void testList3a() throws Exception {
		testSequence("#8 a, b, c");
	}

	@Test
	@Ignore("TODO: test multiple keywords")
	public void testList3b() throws Exception {
		testSequence("#8 a");
	}

	@Test
	@Ignore("TODO: test multiple keywords")
	public void testList3c() throws Exception {
		testSequence("#8 kw3 a");
	}

	@Test
	public void testDependentAlternative1_a() throws Exception {
		testSequence("#19 foo1");
	}

	@Test
	public void testDependentAlternative1_b() throws Exception {
		testSequence("#19 foo kw1");
	}

	@Test
	public void testDependentAlternative2_a() throws Exception {
		testSequence("#20 foo bar");
	}

	@Test
	public void testDependentAlternative2_b() throws Exception {
		testSequence("#20 foo bar baz");
	}

	@Test
	public void testDependentAlternative2_c() throws Exception {
		testSequence("#20 foo bar kw1");
	}

	@Test
	public void testDependentAlternative2_d() throws Exception {
		testSequence("#20 foo kw1");
	}

	@Test
	public void testOptional1_a() throws Exception {
		testSequence("#21 1 2 3");
	}

	@Test
	public void testOptional1_b() throws Exception {
		testSequence("#21 0 0 1");
	}

	@Test
	public void testOptional1_c() throws Exception {
		testSequence("#21 0 0 0");
	}

	@Test
	public void testOptional1_d() throws Exception {
		testSequence("#21 0");
	}

	@Test
	public void testOptional1_e() throws Exception {
		testSequence("#21 1");
	}

	@Test
	public void testUnorderedAlternative1() throws Exception {
		testSequence("#23 1 a");
	}

	@Test
	public void testUnorderedAlternative2() throws Exception {
		testSequence("#23 a 1");
	}

	@Test
	public void testUnorderedAlternative3() throws Exception {
		testSequence("#23 kw1 a kw2 b");
	}

	@Test
	public void testUnorderedAlternative4() throws Exception {
		testSequence("#23 kw2 b kw1 a");
	}

	@Test
	public void testUnorderedAlternative5() throws Exception {
		testSequence("#23 1 a kw1 a kw2 b");
	}

	@Test
	public void testUnorderedAlternative6() throws Exception {
		testSequence("#23 kw2 b kw1 a a 1");
	}

	@Test
	public void testUnorderedAlternative7() throws Exception {
		testSequence("#23 kw2 b kw1 a a 1 c d 2 i 7 kw2 x kw1 x 8 g");
	}

	@Test
	public void testUnorderedGroup1() throws Exception {
		testSequence("#24 1 a kw1 a kw2 b");
	}

	@Test
	public void testUnorderedGroup2() throws Exception {
		testSequence("#24 1 a kw2 b kw1 a");
	}

	@Test
	public void testUnorderedGroup3() throws Exception {
		testSequence("#24 a 1 kw1 a kw2 b");
	}

	@Test
	public void testUnorderedGroup4() throws Exception {
		testSequence("#24 a 1 kw2 b kw1 a");
	}

	@Test
	public void testUnorderedGroup5() throws Exception {
		testSequence("#24 kw1 a kw2 b 1 a ");
	}

	@Test
	public void testUnorderedGroup6() throws Exception {
		testSequence("#24 kw2 b kw1 a 1 a");
	}

	@Test
	public void testUnorderedGroup7() throws Exception {
		testSequence("#24 kw1 a kw2 b a 1");
	}

	@Test
	public void testUnorderedGroup8() throws Exception {
		testSequence("#24 kw2 b kw1 a a 1");
	}

	@Test
	public void testUnorderedGroupOptional1() throws Exception {
		testSequence("#25 kw1 a kw2 b kw3 c");
	}

	@Test
	public void testUnorderedGroupOptional2() throws Exception {
		testSequence("#25 kw1 a kw2 b");
	}

	@Test
	public void testUnorderedGroupOptional3() throws Exception {
		testSequence("#25 kw1 a kw3 c");
	}

	@Test
	public void testUnorderedGroupOptional4() throws Exception {
		testSequence("#25 kw2 b kw3 c");
	}

	@Test
	public void testUnorderedGroupOptional5() throws Exception {
		testSequence("#25 kw2 b kw1 a");
	}

	@Test
	public void testUnorderedGroupOptional6() throws Exception {
		testSequence("#25 kw3 c kw1 a");
	}

	@Test
	public void testUnorderedGroupOptional7() throws Exception {
		testSequence("#25 kw3 c kw2 b");
	}

	@Test
	public void testUnorderedGroupBoolean1() throws Exception {
		testSequence("#26 kw1 kw2");
	}

	@Test
	public void testUnorderedGroupBoolean2() throws Exception {
		testSequence("#26 kw2 kw1");
	}

	@Test
	public void testUnorderedGroupBoolean3() throws Exception {
		testSequence("#26 kw2 kw3");
	}

	@Test
	public void testUnorderedGroupBoolean4() throws Exception {
		testSequence("#26 kw3 kw2");
	}

	@Test
	public void testUnorderedGroupBoolean5() throws Exception {
		testSequence("#26 kw1 kw3");
	}

	@Test
	public void testUnorderedGroupBoolean6() throws Exception {
		testSequence("#26 kw3 kw1");
	}

	@Test
	public void testUnorderedGroupBoolean7() throws Exception {
		testSequence("#26 kw1 kw2 kw3");
	}

	@Test
	public void testUnorderedGroupBoolean8() throws Exception {
		testSequence("#26 kw3 kw2 kw1");
	}

	@Test
	public void testComplex1a() throws Exception {
		testSequence("#27 kw1 v1 kw2 v2 kw3 v3 kw4 v4 kw5 v5 kw6 v6");
	}

	@Test
	public void testComplex1b() throws Exception {
		testSequence("#27 kw6 v6");
	}

	@Test
	public void testComplex1c() throws Exception {
		testSequence("#27 kw3 v3 kw4 v4 kw5 v5 kw6 v6");
	}

	@Test
	public void testOptionalDouble1_a() throws Exception {
		testSequence("#28 1 2 3");
	}

	@Test
	public void testOptionalDouble1_b() throws Exception {
		testSequence("#28 0 0 1");
	}

	@Test
	public void testOptionalDouble1_c() throws Exception {
		testSequence("#28 0 0 0");
	}

	@Test
	public void testOptionalDouble1_d() throws Exception {
		testSequence("#28 0");
	}

	@Test
	public void testNullValueInterpreted() throws Exception {
		EObject model = testSequence("#29 ''");
		Assert.assertNull(((NullValue) model).getValue());
	}

	@Test
	public void testNullValueGenerated() throws Exception {
		EObject model = testSequence("#30 ''");
		Assert.assertNull(((NullValue) model).getValue());
	}

	@Test
	public void testNullCrossReferenceGenerated() throws Exception {
		EObject model = testSequence("#31 null");
		Assert.assertNull(((NullCrossRef) model).getRef());
	}

	@Test
	public void testNullCrossReferenceInterpreted() throws Exception {
		EObject model = testSequence("#32 null");
		Assert.assertNull(((NullCrossRef) model).getRef());
	}

	@Test
	public void testFragment() throws Exception {
		testSequence("#33 foo bar baz");
	}

	@Test
	public void testParameterized1() throws Exception {
		testSequence("#34 kw1 kwp1 foo");
	}

	@Test
	public void testParameterized2() throws Exception {
		testSequence("#34 kw2 kwp1 foo");
	}

	@Test
	public void testParameterized3() throws Exception {
		testSequence("#34 kw3 kwp2 foo kwp3 bar");
	}

	@Test
	public void testParameterized4() throws Exception {
		testSequence("#34 kw4 kwp2 foo");
	}
	
	@Test
	public void testParameterDelegation1a() throws Exception {
		testSequence("#35 kw1 kwd foo");
	}
	
	@Test @Ignore
	public void testParameterDelegation1b() throws Exception {
		testSequence("#35 kw1 kwd foo bar");
	}
	
	@Test
	public void testParameterDelegation2a() throws Exception {
		testSequence("#35 kw2 kwd 1");
	}
	
	@Test @Ignore
	public void testParameterDelegation2b() throws Exception {
		testSequence("#35 kw2 kwd 1 2");
	}

}
