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
import org.eclipse.xtext.junit.AbstractXtextTests;
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
	protected void setUp() throws Exception {
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

		public void enterUnassignedParserRuleCall(RuleCall rc) {
		}

		public void leaveUnssignedParserRuleCall(RuleCall rc) {
		}

		public void acceptUnassignedAction(Action action) {
		}

		public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
			add(datatypeRC, token);
		}

		public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
			add(enumRC, token);
		}

		public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
			add(keyword, token);
		}

		public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
			add(terminalRC, token);
		}

		public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index,
				ICompositeNode node) {
			add(datatypeRC, token);
		}

		public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index,
				ICompositeNode node) {
			add(enumRC, token);
		}

		public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
				ILeafNode node) {
			add(terminalRC, token);
		}

		public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index,
				ICompositeNode node) {
			add(datatypeRC, token);
		}

		public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
			add(enumRC, token);
		}

		public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
			add(keyword, token);
		}

		public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
			add(keyword, token);
		}

		public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
			add(terminalRC, token);
		}

		public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
			return true;
		}

		public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
			return true;
		}

		public void finish() {

		}

		public void leaveAssignedAction(Action action, EObject semanticChild) {
		}

		public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		}

		public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		}

		public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
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
		EObject context = nmSequencer.findContexts(model, true, null).iterator().next();
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
		EObject outObj = getModel(outModel);
		EObject context = nmSequencer.findContexts(inObj, true, null).iterator().next();
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

	public void testMandatoryKeywords() throws Exception {
		testSequence("#1 a kw1 b kw2 kw3 c kw4");
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

	public void testUnassignedDatatype() throws Exception {
		testSequence("#7 foo kw1", "#7 foo matched 1");
	}

	public void testOpionalSingleTransition() throws Exception {
		testSequence("#8 kw1 foo", "#8 matched 2 foo");
	}

	public void testOpionalManyTransition() throws Exception {
		testSequence("#9 kw1 foo", "#9 matched 3 foo");
	}

	public void testMandatoryManyTransition() throws Exception {
		testSequence("#10 kw1 foo", "#10 matched 4 foo");
	}

	public void testAlternativeTransition() throws Exception {
		testSequence("#11 kw1 foo", "#11 matched 5 foo");
	}
}
