/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.junit.serializer.DebugSequenceAcceptor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.EmitterNodeIterator;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.sequencer.NodeModelSemanticSequencer;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SyntacticSequencerTestLanguageStandaloneSetup.class);
		getInjector().injectMembers(this);
	}

	private static class NoEnterNodesDebugSequenceAcceptor extends DebugSequenceAcceptor {

		public NoEnterNodesDebugSequenceAcceptor(boolean printInstantly) {
			super(printInstantly);
		}

		@Override
		public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
			return super.enterAssignedAction(action, semanticChild, NO_NODE);
		}

		@Override
		public boolean enterAssignedParserRuleCall(RuleCall rc, EObject newCurrent, ICompositeNode node) {
			return super.enterAssignedParserRuleCall(rc, newCurrent, NO_NODE);
		}
	}

	@Inject
	private Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	private Provider<ISyntacticSequencer> syntacticSequencerProvider;

	private void testSequence(String stringModel) throws Exception {
		EObject model = getModel(stringModel);
		NodeModelSemanticSequencer nmSequencer = new NodeModelSemanticSequencer();
		EObject context = nmSequencer.findContexts(model, true, null).iterator().next();
		DebugSequenceAcceptor actual = new NoEnterNodesDebugSequenceAcceptor(false);
		ISemanticSequencer semanticSequencer = semanticSequencerProvider.get();
		ISyntacticSequencer syntacticSequencer = syntacticSequencerProvider.get();
		semanticSequencer
				.init((ISemanticSequenceAcceptor) syntacticSequencer, ISerializationDiagnostic.STDERR_ACCEPTOR);
		syntacticSequencer.init(context, model, actual, ISerializationDiagnostic.STDERR_ACCEPTOR);
		semanticSequencer.createSequence(context, model);

		//		((IHiddenTokenSequencerOwner) recSequencer).setHiddenTokenSequencer(get(PassThroughHiddenTokenSequencer.class));
		//		recSequencer.createSequence(context, model, actual, ISerializationDiagnostic.STDERR_ACCEPTOR);
		//		System.out.println(actual);
		//		System.out.println(NodeModelUtils.compactDump(NodeModelUtils.findActualNodeFor(model), false));
		assertEquals(Joiner.on("\n").join(getNodeSequence(model)), Joiner.on("\n").join(actual.getColumn(4)));
	}

	//	public void testXtext() throws Exception {
	//		with(XtextStandaloneSetup.class);
	//		Grammar model = (Grammar) new XtextResourceSet()
	//				.getResource(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"), true).getContents().get(0);
	//		IRecursiveSequencer recSequencer = get(IRecursiveSequencer.class);
	//		DebugSequenceAcceptor actual = new NoEnterNodesDebugSequenceAcceptor(false);
	//		((IHiddenTokenSequencerOwner) recSequencer).setHiddenTokenSequencer(get(PassThroughHiddenTokenSequencer.class));
	//		recSequencer.createSequence(/*syn, semSequencer,*/getGrammarAccess().getGrammar().getRules().get(0), model,
	//				actual, ISerializationDiagnostic.STDERR_ACCEPTOR);
	//		//		System.out.println(actual);
	//		//		System.out.println(NodeModelUtils.compactDump(NodeModelUtils.getNode(model), false));
	//		assertEquals(Join.join("\n", getNodeSequence(model)), Join.join("\n", actual.getColumn(4)));
	//	}

	public void testMandatoryKeywords() throws Exception {
		List<IConstraintContext> ctxts = get(IGrammarConstraintProvider.class).getConstraints(
				getGrammarAccess().getGrammar());
		List<String> result = Lists.newArrayList();
		Set<IConstraint> visited = Sets.newHashSet();
		for (IConstraintContext ctx : ctxts) {
			result.add(ctx.toString());
			for (IConstraint c : ctx.getConstraints())
				if (visited.add(c))
					result.add("  " + c.toString());
		}
		//		System.out.println(Joiner.on("\n").join(result));

		//		SyntacticSequencerPDA2ExtendedDot.drawGrammar(get(ISyntacticSequencerPDAProvider.class),
		//				"pdf/syntacticSequencerTest-PDA.pdf", get(IGrammarAccess.class).getGrammar());
		//		new SequenceParserPDA2Dot(get(ISyntacticSequencerPDAProvider.class)).draw(get(IGrammarAccess.class)
		//				.getGrammar(), "pdf/syntacticSequencerTest-PDA.pdf", "-T pdf");

		testSequence("#1 a kw1 b kw2 kw3 c kw4");
	}

	private List<String> getNodeSequence(EObject model) {
		List<String> result = Lists.newArrayList();
		GrammarElementTitleSwitch titleSwitch = new GrammarElementTitleSwitch().showAssignments();
		EmitterNodeIterator ni = new EmitterNodeIterator(NodeModelUtils.findActualNodeFor(model));
		while (ni.hasNext()) {
			INode next = ni.next();
			if (next instanceof ILeafNode)
				result.add(titleSwitch.doSwitch(next.getGrammarElement()) + " -> " + next.getText());
			if (next instanceof ICompositeNode)
				result.add(titleSwitch.doSwitch(next.getGrammarElement()));
		}
		return result;
	}

	public void testExp0_a() throws Exception {
		testSequence("#2 a + b + c + d");
	}

	public void testExp1_a() throws Exception {
		testSequence("#3 a + b + c + d");
	}

	public void testExp1_b() throws Exception {
		testSequence("#3 a + b");
	}

	public void testExp1_c() throws Exception {
		testSequence("#3 (a + b)");
	}

	public void testExp2_a() throws Exception {
		testSequence("#4 a * (b + c)");
	}

	public void testExp2_b() throws Exception {
		testSequence("#4 a * (((b + c)))");
	}

	public void testExp2_c() throws Exception {
		testSequence("#4 (a * (((b + c))))");
	}

	public void testExp2_d() throws Exception {
		testSequence("#4 (b + c) * d");
	}

	public void testExp2_e() throws Exception {
		testSequence("#4 ((a * (((b + c)) * d) + e)) + f");
	}

	public void testCrossRef1_a() throws Exception {
		testSequence("#5 $1terminal kw1 $1terminal");
	}

	public void testCrossRef1_b() throws Exception {
		testSequence("#5 datatype kw2 datatype");
	}

	public void testCrossRef1_c() throws Exception {
		testSequence("#5 someid kw3 someid");
	}

	public void testCrossRef1_d() throws Exception {
		testSequence("#5 someid kw4 someid");
	}

	public void testBooleanAlternative_a() throws Exception {
		testSequence("#6 kw1");
	}

	public void testBooleanAlternative_b() throws Exception {
		testSequence("#6 kw2");
	}
}
