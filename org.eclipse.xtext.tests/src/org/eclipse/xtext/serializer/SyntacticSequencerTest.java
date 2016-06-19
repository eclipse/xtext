/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.EmitterNodeIterator;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.sequencer.NodeModelSemanticSequencer;
import org.eclipse.xtext.serializer.syntacticsequencertest.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerTest extends AbstractXtextTests {

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SyntacticSequencerTestLanguageStandaloneSetup.class);
		getInjector().injectMembers(this);
	}

	private static class Acceptor implements ISequenceAcceptor {

		public List<String> getResult() {
			return result;
		}

		private List<String> result = Lists.newArrayList();

		protected GrammarElementTitleSwitch titles = new GrammarElementTitleSwitch().showAssignments();

		private void add(AbstractElement ele, String token) {
			result.add(titles.doSwitch(ele) + " -> " + token.trim());
		}

		@Override
		public void enterUnassignedParserRuleCall(RuleCall rc) {
		}

		@Override
		public void leaveUnssignedParserRuleCall(RuleCall rc) {
		}

		@Override
		public void acceptUnassignedAction(Action action) {
		}

		@Override
		public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
			add(datatypeRC, token);
		}

		@Override
		public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
			add(enumRC, token);
		}

		@Override
		public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
			add(keyword, token);
		}

		@Override
		public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
			add(terminalRC, token);
		}

		@Override
		public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index,
				ICompositeNode node) {
			add(datatypeRC, token);
		}

		@Override
		public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index,
				ICompositeNode node) {
			add(enumRC, token);
		}

		@Override
		public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
				ILeafNode node) {
			add(terminalRC, token);
		}

		@Override
		public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index,
				ICompositeNode node) {
			add(datatypeRC, token);
		}

		@Override
		public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
			add(enumRC, token);
		}

		@Override
		public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
			add(keyword, token);
		}

		@Override
		public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
			add(terminalRC, token);
		}

		@Override
		public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
			return true;
		}

		@Override
		public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
			return true;
		}

		@Override
		public void finish() {

		}

		@Override
		public void leaveAssignedAction(Action action, EObject semanticChild) {
		}

		@Override
		public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		}

		@Override
		public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		}

		@Override
		public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
		}

		@Override
		public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
			add(kw, token);
		}
	}

	@Inject
	private Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	private Provider<ISyntacticSequencer> syntacticSequencerProvider;

	@Inject
	private NodeModelSemanticSequencer nmSequencer;

	private void testSequence(String stringModel) throws Exception {
		EObject model = getModel(stringModel);
		ISerializationContext context = nmSequencer.findContexts(model, true, null).iterator().next();
		Acceptor actual = new Acceptor();
		ISemanticSequencer semanticSeq = semanticSequencerProvider.get();
		ISyntacticSequencer syntacticSeq = syntacticSequencerProvider.get();
		semanticSeq.init((ISemanticSequenceAcceptor) syntacticSeq, ISerializationDiagnostic.STDERR_ACCEPTOR);
		syntacticSeq.init(context, model, actual, ISerializationDiagnostic.STDERR_ACCEPTOR);
		semanticSeq.createSequence(context, model);
		assertEquals(Joiner.on("\n").join(getNodeSequence(model)), Joiner.on("\n").join(actual.getResult()));
	}

	private void testSequence(String inModel, String outModel) throws Exception {
		EObject inObj = getModel(inModel);
		testSequence(inObj, outModel);
	}

	private void testSequence(EObject inObj, String outModel) throws Exception {
		EObject outObj = getModel(outModel);
		ISerializationContext context = nmSequencer.findContexts(inObj, true, null).iterator().next();
		Acceptor actual = new Acceptor();
		ISemanticSequencer semanticSeq = semanticSequencerProvider.get();
		ISyntacticSequencer syntacticSeq = syntacticSequencerProvider.get();
		semanticSeq.init((ISemanticSequenceAcceptor) syntacticSeq, ISerializationDiagnostic.STDERR_ACCEPTOR);
		syntacticSeq.init(context, inObj, actual, ISerializationDiagnostic.STDERR_ACCEPTOR);
		semanticSeq.createSequence(context, inObj);
		assertEquals(Joiner.on("\n").join(getNodeSequence(outObj)), Joiner.on("\n").join(actual.getResult()));
	}

	private List<String> getNodeSequence(EObject model) {
		List<String> result = Lists.newArrayList();
		GrammarElementTitleSwitch titleSwitch = new GrammarElementTitleSwitch().showAssignments();
		EmitterNodeIterator ni = new EmitterNodeIterator(NodeModelUtils.findActualNodeFor(model));
		while (ni.hasNext()) {
			INode next = ni.next();
			EObject ele = next.getGrammarElement() instanceof CrossReference ? ((CrossReference) next
					.getGrammarElement()).getTerminal() : next.getGrammarElement();
			if (next instanceof ILeafNode || GrammarUtil.isDatatypeRuleCall(ele))
				result.add(titleSwitch.doSwitch(ele) + " -> " + next.getText().trim());
			else if (next instanceof ICompositeNode)
				result.add(titleSwitch.doSwitch(ele));
		}
		return result;
	}

	@Test
	public void testMandatoryKeywords() throws Exception {
		testSequence("#1 a kw1 b kw2 kw3 c kw4");
	}

	@Test
	public void testExp0_a() throws Exception {
		testSequence("#2 a + b + c + d");
	}

	@Test
	public void testExp1_a() throws Exception {
		testSequence("#3 a + b + c + d");
	}

	@Test
	public void testExp1_b() throws Exception {
		testSequence("#3 a + b");
	}

	@Test
	public void testExp1_c() throws Exception {
		testSequence("#3 (a + b)");
	}

	@Test
	public void testExp2_a() throws Exception {
		testSequence("#4 a * (b + c)");
	}

	@Test
	public void testExp2_b() throws Exception {
		testSequence("#4 a * (((b + c)))");
	}

	@Test
	public void testExp2_c() throws Exception {
		testSequence("#4 (a * (((b + c))))");
	}

	@Test
	public void testExp2_d() throws Exception {
		testSequence("#4 (b + c) * d");
	}

	@Test
	public void testExp2_e() throws Exception {
		testSequence("#4 ((a * (((b + c)) * d) + e)) + f");
	}

	@Test
	public void testCrossRef1_a() throws Exception {
		testSequence("#5 $1terminal kw1 $1terminal");
	}

	@Test
	public void testCrossRef1_b() throws Exception {
		testSequence("#5 datatype kw2 datatype");
	}

	@Test
	public void testCrossRef1_c() throws Exception {
		testSequence("#5 someid kw3 someid");
	}

	@Test
	public void testCrossRef1_d() throws Exception {
		testSequence("#5 someid kw4 someid");
	}

	@Test
	public void testBooleanAlternative_a() throws Exception {
		testSequence("#6 kw1");
	}

	@Test
	public void testBooleanAlternative_b() throws Exception {
		testSequence("#6 kw2");
	}

	@Test
	public void testBooleanAlternative_c() throws Exception {
		Model model = (Model) getModel("#6 kw2");
		model.getX6().getBool().setIsTrue(false);
		testSequence(model, "#6 kw1");
	}

	@Test
	public void testBooleanAlternative_d() throws Exception {
		Model model = (Model) getModel("#6 kw1");
		model.getX6().getBool().setIsTrue(true);
		testSequence(model, "#6 kw2");
	}

	@Test
	public void testUnassignedDatatype() throws Exception {
		testSequence("#7 foo kw1", "#7 foo matched 1");
	}

	@Test
	public void testOpionalSingleTransition() throws Exception {
		testSequence("#8 kw1 foo", "#8 matched 2 foo");
	}

	@Test
	public void testOpionalManyTransition() throws Exception {
		testSequence("#9 kw1 foo", "#9 matched 3 foo");
	}

	@Test
	public void testMandatoryManyTransition() throws Exception {
		testSequence("#10 kw1 foo", "#10 matched 4 foo");
	}

	@Test
	public void testAlternativeTransition() throws Exception {
		testSequence("#11 kw1 foo", "#11 matched 5 foo");
	}

	@Test
	public void testBooleanKeyword() throws Exception {
		testSequence("#12 kw1", "#12 kw1");
	}

	@Test
	public void testBooleanTerminal() throws Exception {
		testSequence("#12 %1foo", "#12 %1matched");
	}

	@Test
	public void testBooleanDatatype() throws Exception {
		testSequence("#12 foo", "#12 foomatched");
	}

	@Test
	public void testLongAlternative1() throws Exception {
		testSequence("#13 x0 kw1 x1a kw1 x1b!");
	}

	@Test
	public void testLongAlternative2() throws Exception {
		testSequence("#13 x0 kw8 x8a kw8 x8b!");
	}

	@Test
	public void testLongAlternative3() throws Exception {
		testSequence("#13 x0 kw1 x1 kw2 x2 kw3 x3 kw4 x4 kw5 x5 kw6 x6 kw7 x7 kw8 x8!");
	}

	@Test
	public void testLongAlternative4() throws Exception {
		testSequence("#13 x0 kw8 x8 kw7 x7 kw6 x6 kw5 x5 kw4 x4 kw3 x3 kw2 x2 kw1 x1!");
	}

	@Test
	public void testLongAlternative5() throws Exception {
		testSequence("#13 x0 kw1 kw2 kw3 kw4 kw5 kw6 kw7 kw8!");
	}

	@Test
	public void testLongAlternative6() throws Exception {
		testSequence("#13 x0 kw8 kw7 kw6 kw5 kw4 kw3 kw2 kw1!");
	}
	
	@Test
	public void testActionOnlyWithOptionals() throws Exception {
		testSequence("#14 kw1 foo kw2 bar");
	}
	
	@Test
	public void testFragment() throws Exception {
		testSequence("#15 foo bar baz");
	}
}
