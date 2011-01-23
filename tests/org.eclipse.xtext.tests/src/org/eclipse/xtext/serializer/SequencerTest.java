/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.ISequencer.IGrammarValuePair;
import org.eclipse.xtext.serializer.impl.NodeModelSequencer;
import org.eclipse.xtext.serializer.impl.PairFormatter;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SequencerTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SequencerTestLanguageStandaloneSetup.class);
	}

	private void testSequence(String stringModel) throws Exception {
		EObject model = getModel(stringModel).eContents().get(0);
		NodeModelSequencer nmsequencer = new NodeModelSequencer();
		EObject context = nmsequencer.findContexts(model, null).iterator().next();
		ISequencer sequencer = get(ISequencer.class);
		String actual = sequenceRecursively(sequencer, context, model, true);
		String expected = sequenceRecursively(nmsequencer, context, model, true);
		assertEquals(expected, actual);
	}

	public void testXtext() throws Exception {
		with(XtextStandaloneSetup.class);
		EObject model = getGrammarAccess().getGrammar();
		ISequencer sequencer = get(ISequencer.class);
		EObject ctx = sequencer.findContexts(model, null).iterator().next();
		String actual = sequenceRecursively(sequencer, ctx, model, true);
//		System.out.println(actual);
		assertNotNull(actual);
	}

	private EObject getContext(IGrammarValuePair pair) {
		if (pair.getGrammarElement() instanceof Action)
			return pair.getGrammarElement();
		if (pair.getGrammarElement() instanceof RuleCall) {
			RuleCall rc = (RuleCall) pair.getGrammarElement();
			if (rc.getRule() instanceof ParserRule && rc.getRule().getType().getClassifier() instanceof EClass)
				return rc.getRule();
		}
		return null;
	}

	private String sequenceRecursively(ISequencer sequencer, EObject context, EObject model, boolean recursive) {
		StringBuilder result = new StringBuilder();
		result.append(new GrammarElementTitleSwitch().doSwitch(context));
		result.append(" {\n");
		sequenceRecursively(sequencer, context, model, "  ", result, recursive);
		result.append("}");
		return result.toString();
	}

	private void sequenceRecursively(ISequencer sequencer, EObject context, EObject model, String prefix,
			StringBuilder result, boolean recursive) {
		Iterable<IGrammarValuePair> seq = sequencer.createSequence(context, model, null);
		for (IGrammarValuePair p : seq) {
			EObject ctx = getContext(p);
			if (ctx != null) {
				result.append(prefix);
				result.append(PairFormatter.toStr(p.getGrammarElement()));
				result.append(" => ");
				result.append(((EObject) p.getValue()).eClass().getName());
				if (recursive) {
					result.append(" {\n");
					sequenceRecursively(sequencer, ctx, (EObject) p.getValue(), prefix + "  ", result, recursive);
					result.append(prefix);
				} else {
					result.append(" {");
					result.append("...");
				}
				result.append("}\n");
			} else {
				String pre = prefix + PairFormatter.toStr(p.getGrammarElement());
				pre += PREF.substring(Math.min(pre.length(), PREF.length()));
				result.append(pre);
				result.append(PairFormatter.toStr(p.getValue()));
				result.append("\n");
			}
		}
	}

	private final static String PREF = "                                                                 ";

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

}