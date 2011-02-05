/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.impl.DebugSequenceAcceptor;
import org.eclipse.xtext.serializer.impl.NodeModelSyntacticSequencer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SyntacticSequencerTestLanguageStandaloneSetup.class);
	}

	private void testSequence(String stringModel) throws Exception {
		EObject model = getModel(stringModel);
		NodeModelSyntacticSequencer nmSequencer = new NodeModelSyntacticSequencer();
		EObject context = nmSequencer.findContexts(model, null).iterator().next();
		ISemanticSequencer semSequencer = get(ISemanticSequencer.class);
		IRecursiveSyntacticSequencer recSequencer = get(IRecursiveSyntacticSequencer.class);
		DebugSequenceAcceptor actual = new DebugSequenceAcceptor(true);
		DebugSequenceAcceptor expected = new DebugSequenceAcceptor();
		ISyntacticSequencer syn = get(ISyntacticSequencer.class);
		//		ISemanticSequenceAcceptor synac = syn.createAcceptor(context, model, actual,
		//				ISerializationDiagnostic.EXCEPTION_ACCEPTOR);
		nmSequencer.createSequence(context, model, expected, ISerializationDiagnostic.EXCEPTION_ACCEPTOR);
		recSequencer.createSequence(syn, semSequencer, context, model, actual,
				ISerializationDiagnostic.EXCEPTION_ACCEPTOR);
		//		recSequencer.createSequence(nmSequencer, context, model, expected, ISerializationDiagnostic.EXCEPTION_ACCEPTOR);
		System.out.println(actual.toString());
		assertEquals(expected.toString(), actual.toString());
	}

	public void testFoo() {

	}

	//	public void testXtext() throws Exception {
	//		with(XtextStandaloneSetup.class);
	//		Grammar model = getGrammarAccess().getGrammar();
	//		//		System.out.println(EmfFormatter.objToStr(model));
	//		ISemanticSequencer semSequencer = get(ISemanticSequencer.class);
	//		//		EObject ctx = semSequencer.findContexts(model, null).iterator().next();
	//		IRecursiveSyntacticSequencer recSequencer = get(IRecursiveSyntacticSequencer.class);
	//		DebugSequenceAcceptor actual = new DebugSequenceAcceptor(false);
	//		//		IRecursiveSyntacticSequenceAcceptor synac = get(ISyntacticSequencer.class).createAcceptor(ctx, model, actual,
	//		//				ISerializationDiagnostic.EXCEPTION_ACCEPTOR);
	//		ISyntacticSequencer syn = get(ISyntacticSequencer.class);
	//		recSequencer.createSequence(syn, semSequencer, model.getRules().get(0), model, actual,
	//				ISerializationDiagnostic.EXCEPTION_ACCEPTOR);
	//		//		String actual = sequenceRecursively(semSequencer, ctx, model, true);
	//		System.out.println(actual);
	//		assertNotNull(actual);
	//	}
	//
	//	public void testMandatoryKeywords() throws Exception {
	//		List<IConstraintContext> ctxts = get(IGrammarConstraintProvider.class).getConstraints(
	//				getGrammarAccess().getGrammar());
	//		List<String> result = Lists.newArrayList();
	//		Set<IConstraint> visited = Sets.newHashSet();
	//		for (IConstraintContext ctx : ctxts) {
	//			result.add(ctx.toString());
	//			for (IConstraint c : ctx.getConstraints())
	//				if (visited.add(c))
	//					result.add("  " + c.toString());
	//		}
	//		System.out.println(Join.join("\n", result));
	//
	//		SequenceParserPDA2Dot.drawGrammar(get(ISyntacticSequencerPDAProvider.class),
	//				"pdf/syntacticSequencerTest-PDA.pdf", get(IGrammarAccess.class).getGrammar());
	//		//		new SequenceParserPDA2Dot(get(ISyntacticSequencerPDAProvider.class)).draw(get(IGrammarAccess.class)
	//		//				.getGrammar(), "pdf/syntacticSequencerTest-PDA.pdf", "-T pdf");
	//
	//		testSequence("#1 a kw1 b kw2 kw3 c kw4");
	//	}
	//
	//	public void testExp0_a() throws Exception {
	//		testSequence("#2 a + b + c + d");
	//	}
	//
	//	public void testExp1_a() throws Exception {
	//		testSequence("#3 a + b + c + d");
	//	}
	//
	//	public void testExp2_a() throws Exception {
	//		testSequence("#4 a * (b + c)");
	//	}
}