/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import static org.eclipse.xtext.junit.validation.AssertableDiagnostics.*;
import static org.eclipse.xtext.validation.ConcreteSyntaxValidator.*;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit.validation.AssertableDiagnostics.DiagnosticPredicate;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.validation.ConcreteSyntaxValidator.ConcreteSyntaxFeatureDiagnostic;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.DiagnosticChainAcceptor;
import org.eclipse.xtext.validation.csvalidationtest.AlternativeMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.AssignedAction;
import org.eclipse.xtext.validation.csvalidationtest.Combination1;
import org.eclipse.xtext.validation.csvalidationtest.Combination2;
import org.eclipse.xtext.validation.csvalidationtest.Combination3;
import org.eclipse.xtext.validation.csvalidationtest.Combination4;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestFactory;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage;
import org.eclipse.xtext.validation.csvalidationtest.GroupMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.List1;
import org.eclipse.xtext.validation.csvalidationtest.List2;
import org.eclipse.xtext.validation.csvalidationtest.List3;
import org.eclipse.xtext.validation.csvalidationtest.SimpleAlternative;
import org.eclipse.xtext.validation.csvalidationtest.SimpleGroup;
import org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction3;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2SubAction;

/**
 * @author meysholdt - Initial contribution and API
 */
public class ConcreteSyntaxValidationTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ConcreteSyntaxValidationTestLanguageStandaloneSetup.class);
		validator = getInjector().getInstance(ConcreteSyntaxValidator.class);
	}

	private static class DiagPred implements DiagnosticPredicate {

		private EStructuralFeature feat;
		private Integer min;
		private Integer max;
		private int code;
		private String constraint;

		public DiagPred(EStructuralFeature feat, int code, Integer min, Integer max, String constraint) {
			super();
			this.feat = feat;
			this.min = min;
			this.max = max;
			this.code = code;
			this.constraint = constraint;
		}

		@Override
		public String toString() {
			String f = feat == null ? "null" : feat.getEContainingClass().getName() + "." + feat.getName();
			return "DiagPred [feat= " + f + " code=" + code + ", min=" + min + ", max=" + max + ", constraint="
					+ constraint + "]";
		}

		public boolean apply(Diagnostic input) {
			if (input instanceof ConcreteSyntaxFeatureDiagnostic) {
				ConcreteSyntaxFeatureDiagnostic s = (ConcreteSyntaxFeatureDiagnostic) input;
				if (min != null && min != s.getMin())
					return false;
				if (max != null && max != s.getMax())
					return false;
				return s.getFeature() == feat && s.getCode() == code && constraint.equals(s.getConstraint());
			}
			return false;
		}
	}

	private DiagnosticPredicate err(EStructuralFeature feat, int code, Integer min, Integer max, String constraint) {
		return new DiagPred(feat, code, min, max, constraint);
	}

	private IConcreteSyntaxValidator validator;

	private static CsvalidationtestPackage p = CsvalidationtestPackage.eINSTANCE;
	private static CsvalidationtestFactory f = CsvalidationtestFactory.eINSTANCE;

	private EObject getModel2(String model) throws Exception {
		return getModel(model).eContents().get(0);
	}

	private AssertableDiagnostics validate(EObject obj) {
		final BasicDiagnostic dc = new BasicDiagnostic();
		validator.validateObject(obj, new DiagnosticChainAcceptor(dc), new HashMap<Object, Object>());
		return new AssertableDiagnostics(dc);
	}

	public void testSimpleGroup1() throws Exception {
		SimpleGroup m = (SimpleGroup) getModel2("#1 abc def");
		validate(m).assertOK();
		m.setVal2(null);
		validate(m).assertAll(err(p.getSimpleGroup_Val2(), ERROR_VALUE_REQUIRED, 1, 1, ""));
	}

	public void testSimpleAlternative1() throws Exception {
		SimpleAlternative m = (SimpleAlternative) getModel2("#2 kw1 abc");
		validate(m).assertOK();
		m.setVal2("def2");
		validate(m).assertAll(err(p.getSimpleAlternative_Val1(), ERROR_VALUE_PROHIBITED, null, 0, "(val1|val2)"),
				err(p.getSimpleAlternative_Val2(), ERROR_VALUE_PROHIBITED, null, 0, "(val1|val2)"));
	}

	public void testSimpleMultiplicities1() throws Exception {
		SimpleMultiplicities m = (SimpleMultiplicities) getModel2("#3 abc kw1 def kw2 fgh ijk kw3 lmn opq");
		validate(m).assertOK();
		m.setVal2(null);
		m.getVal3().remove(0);
		m.getVal4().clear();
		validate(m).assertOK();

		SimpleMultiplicities copy = (SimpleMultiplicities) EcoreUtil.copy(m);
		copy.setVal1(null);
		validate(copy).assertAll(err(p.getSimpleMultiplicities_Val1(), ERROR_VALUE_REQUIRED, 1, null, ""));

		copy = (SimpleMultiplicities) EcoreUtil.copy(m);
		copy.getVal3().clear();
		validate(copy).assertAll(err(p.getSimpleMultiplicities_Val3(), ERROR_LIST_TOO_FEW, 1, null, ""));
	}

	public void testGroupMultiplicities1() throws Exception {
		GroupMultiplicities m = (GroupMultiplicities) getModel2("#4 abc kw1 def def kw2 fgh ijk kw3 lmn opq");
		validate(m).assertOK();

		GroupMultiplicities copy = (GroupMultiplicities) EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal3(null);
		copy.getVal6().clear();
		copy.getVal7().clear();
		validate(copy).assertOK();

		copy = (GroupMultiplicities) EcoreUtil.copy(m);
		copy.setVal2(null);
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val2(), ERROR_VALUE_REQUIRED, 1, null, "(val2 val3)?"),
				err(p.getGroupMultiplicities_Val3(), ERROR_VALUE_PROHIBITED, null, 0, "(val2 val3)?"));

		copy = (GroupMultiplicities) EcoreUtil.copy(m);
		copy.getVal5().clear();
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val4(), ERROR_LIST_TOO_MANY, null, 0, "(val4 val5)+"),
				err(p.getGroupMultiplicities_Val5(), ERROR_LIST_TOO_FEW, 1, null, "(val4 val5)+"));

		copy = (GroupMultiplicities) EcoreUtil.copy(m);
		copy.getVal4().clear();
		copy.getVal5().clear();
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val4(), ERROR_LIST_TOO_FEW, 1, null, "(val4 val5)+"),
				err(p.getGroupMultiplicities_Val5(), ERROR_LIST_TOO_FEW, 1, null, "(val4 val5)+"));

		copy = (GroupMultiplicities) EcoreUtil.copy(m);
		copy.getVal5().add("sdlasjdk");
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val4(), ERROR_LIST_TOO_FEW, 2, null, "(val4 val5)+"),
				err(p.getGroupMultiplicities_Val5(), ERROR_LIST_TOO_MANY, null, 1, "(val4 val5)+"));

		copy = (GroupMultiplicities) EcoreUtil.copy(m);
		copy.getVal6().clear();
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val6(), ERROR_LIST_TOO_FEW, 1, 1, "(val6 val7)*"),
				err(p.getGroupMultiplicities_Val7(), ERROR_LIST_TOO_MANY, 0, 0, "(val6 val7)*"));

		copy = (GroupMultiplicities) EcoreUtil.copy(m);
		copy.getVal7().add("test");
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val6(), ERROR_LIST_TOO_FEW, 2, null, "(val6 val7)*"),
				err(p.getGroupMultiplicities_Val7(), ERROR_LIST_TOO_MANY, 1, 1, "(val6 val7)*"));

	}

	public void testAlternativeMultiplicities1() throws Exception {
		AlternativeMultiplicities m = (AlternativeMultiplicities) getModel2("#5 abc kw2 kw3 fgh kw3 xxx kw4 ijk lmn opq");
		validate(m).assertOK();

		AlternativeMultiplicities copy = (AlternativeMultiplicities) EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal3(null);
		copy.getVal6().clear();
		copy.getVal7().clear();
		validate(copy).assertOK();

		copy = (AlternativeMultiplicities) EcoreUtil.copy(m);
		copy.setVal2(null);
		validate(copy).assertOK();

		copy = (AlternativeMultiplicities) EcoreUtil.copy(m);
		copy.setVal3("lalal");
		validate(copy).assertAll(
				err(p.getAlternativeMultiplicities_Val2(), ERROR_VALUE_PROHIBITED, null, 0, "(val2|val3)?"),
				err(p.getAlternativeMultiplicities_Val3(), ERROR_VALUE_PROHIBITED, null, 0, "(val2|val3)?"));

		copy = (AlternativeMultiplicities) EcoreUtil.copy(m);
		copy.getVal5().clear();
		validate(copy).assertAll(
				err(p.getAlternativeMultiplicities_Val4(), ERROR_LIST_TOO_FEW, 1, null, "(val4|val5)+"),
				err(p.getAlternativeMultiplicities_Val5(), ERROR_LIST_TOO_FEW, 1, null, "(val4|val5)+"));

		copy = (AlternativeMultiplicities) EcoreUtil.copy(m);
		copy.getVal4().add("sdfg");
		copy.getVal4().add("dfdf");
		validate(copy).assertOK();
	}

	public void testAssignedAction1() throws Exception {
		AssignedAction m = (AssignedAction) getModel2("#6 id1 id2 id3");
		validate(m).assertOK();
		m.setVal1(null);

		// The validator is expected to ignore rules containing assigned Actions.
		validate(m).assertOK();
	}

	public void testAssignedAction2() throws Exception {
		AssignedAction m = (AssignedAction) getModel2("#7 id1 kw1 id3");
		validate(m).assertOK();
		m.setVal1(null);

		// The validator is expected to ignore rules if there is a rule with the same return type which contains assigned actions
		validate(m).assertOK();
	}

	public void testUnassignedAction1() throws Exception {
		UnassignedAction1 m = (UnassignedAction1) getModel2("#8 id1");
		validate(m).assertOK();
		m.setVal1(null);
		validate(m).assertAll(err(p.getUnassignedAction1_Val1(), ERROR_VALUE_REQUIRED, 1, null, ""));
	}

	public void testUnassignedAction2() throws Exception {
		UnassignedAction2Sub m = (UnassignedAction2Sub) getModel2("#9 id1");
		validate(m).assertOK();
		m.setVal1(null);
		validate(m).assertAll(err(p.getUnassignedAction2Sub_Val1(), ERROR_VALUE_REQUIRED, 1, 1, ""));
	}

	public void testUnassignedAction3() throws Exception {
		UnassignedAction3 m = (UnassignedAction3) getModel2("#10 kw1 id1 id2");
		validate(m).assertOK();
		m.setVal1(null);
		validate(m).assertAll(err(p.getUnassignedAction3_Val1(), ERROR_VALUE_REQUIRED, 1, 1, ""));

		UnassignedAction3 ua = f.createUnassignedAction3();
		ua.setVal1("xx");
		validate(ua).assertAll(errorCode(ERROR_WRONG_TYPE));
	}

	public void testUnassignedRuleCall1() throws Exception {
		UnassignedRuleCall1Sub m = (UnassignedRuleCall1Sub) getModel2("#11 id1 id2");
		validate(m).assertOK();

		m.setVal1(null);
		validate(m).assertAll(err(p.getUnassignedRuleCall1Sub_Val1(), ERROR_VALUE_REQUIRED, 1, 1, ""));

		UnassignedRuleCall1 m1 = f.createUnassignedRuleCall1();
		validate(m1).assertAll(errorCode(ERROR_FEATURE_MISSING), errorCode(ERROR_WRONG_TYPE));
	}

	public void testUnassignedRuleCall2() throws Exception {
		UnassignedRuleCall2SubAction a = f.createUnassignedRuleCall2SubAction();
		a.setVal2("foo");
		validate(a).assertOK();

		UnassignedRuleCall2Sub s = f.createUnassignedRuleCall2Sub();
		s.setVal2("foo");
		validate(s).assertAll(errorCode(ERROR_WRONG_TYPE));

		UnassignedRuleCall2 c = f.createUnassignedRuleCall2();
		validate(c).assertAll(errorCode(ERROR_WRONG_TYPE), errorCode(ERROR_FEATURE_MISSING));
	}

	public void testCombination1() throws Exception {
		Combination1 copy, m = (Combination1) getModel2("#13 id1 kw1 id2 kw2 id3");
		validate(m).assertOK();

		copy = (Combination1) EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal3(null);
		validate(m).assertOK();

		copy = (Combination1) EcoreUtil.copy(m);
		copy.setVal2(null);
		validate(copy).assertAll(err(p.getCombination1_Val2(), ERROR_VALUE_REQUIRED, 1, null, "(val2 (val3|val4))?"),
				err(p.getCombination1_Val3(), ERROR_VALUE_PROHIBITED, null, 0, "(val2 (val3|val4))?"));

		copy = (Combination1) EcoreUtil.copy(m);
		copy.setVal3(null);
		validate(copy).assertAll(err(p.getCombination1_Val3(), ERROR_VALUE_REQUIRED, 1, null, "(val2 (val3|val4))?"),
				err(p.getCombination1_Val4(), ERROR_VALUE_REQUIRED, 1, null, "(val2 (val3|val4))?"));
	}

	public void testCombination2() throws Exception {
		Combination2 copy, m = (Combination2) getModel2("#14 id1 id31 id41 id32 id42");
		validate(m).assertOK();

		copy = (Combination2) EcoreUtil.copy(m);
		copy.getVal3().add("foo");
		validate(copy).assertAll(err(p.getCombination2_Val3(), ERROR_LIST_TOO_MANY, 2, 2, "(val2|(val3 val4)*)"),
				err(p.getCombination2_Val4(), ERROR_LIST_TOO_FEW, 3, 3, "(val2|(val3 val4)*)"));

		copy = (Combination2) EcoreUtil.copy(m);
		copy.setVal2("foo");
		validate(copy).assertAll(err(p.getCombination2_Val2(), ERROR_VALUE_PROHIBITED, null, 0, "(val2|(val3 val4)*)"),
				err(p.getCombination2_Val3(), ERROR_LIST_TOO_MANY, null, 0, "(val2|(val3 val4)*)"),
				err(p.getCombination2_Val4(), ERROR_LIST_TOO_MANY, null, 0, "(val2|(val3 val4)*)"));
	}

	public void testCombination3() throws Exception {
		Combination3 copy, m = (Combination3) getModel2("#15 'string' id1 1234");
		validate(m).assertOK();

		copy = (Combination3) EcoreUtil.copy(m);
		copy.setVal1(null);
		validate(copy).assertOK();

		copy = (Combination3) EcoreUtil.copy(m);
		copy.setVal1(null);
		copy.setVal2(0);
		validate(copy).assertOK();
	}

	public void testCombination4() throws Exception {
		Combination4 copy, m = (Combination4) getModel2("#16 group id11 id12 id13 group id21 id22 id23");
		validate(m).assertOK();

		copy = (Combination4) EcoreUtil.copy(m);
		copy.getVal1().add("xxx");
		validate(copy).assertAll(err(p.getCombination4_Val1(), ERROR_LIST_TOO_MANY, 2, 2, "(val1 val2 val3)+"),
				err(p.getCombination4_Val2(), ERROR_LIST_TOO_FEW, 3, null, "(val1 val2 val3)+"),
				err(p.getCombination4_Val3(), ERROR_LIST_TOO_FEW, 3, null, "(val1 val2 val3)+"));

		copy = (Combination4) EcoreUtil.copy(m);
		copy.getVal1().remove(0);
		validate(copy).assertAll(err(p.getCombination4_Val1(), ERROR_LIST_TOO_FEW, 2, 2, "(val1 val2 val3)+"),
				err(p.getCombination4_Val2(), ERROR_LIST_TOO_MANY, 1, 1, "(val1 val2 val3)+"),
				err(p.getCombination4_Val3(), ERROR_LIST_TOO_MANY, 1, 1, "(val1 val2 val3)+"));
	}

	public void testList1() throws Exception {
		List1 copy, m = (List1) getModel2("#17 id1, id2, id2");
		validate(m).assertOK();

		copy = (List1) EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.getVal1().add("xxx");
		validate(copy).assertOK();

		copy = (List1) EcoreUtil.copy(m);
		copy.getVal1().clear();
		validate(copy).assertAll(err(p.getList1_Val1(), ERROR_LIST_TOO_FEW, 1, null, "(val1 val1*)"));
	}

	public void testList2() throws Exception {
		List2 copy, m = (List2) getModel2("#18 id1, id2, id2");
		validate(m).assertOK();

		copy = (List2) EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.getVal1().add("xxx");
		validate(copy).assertOK();

		copy = (List2) EcoreUtil.copy(m);
		copy.getVal1().clear();
		validate(copy).assertOK();
	}

	public void testList3() throws Exception {
		List3 copy, m = (List3) getModel2("#19 id1, id2, id2");
		//		validate(m).assertOK();

		copy = (List3) EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.getVal1().add("xxx");
		//		validate(copy).assertOK();

		copy = (List3) EcoreUtil.copy(m);
		copy.getVal1().clear();
		//		validate(copy).assertAll(err(p.getList3_Val1(), ERROR_LIST_TOO_FEW, 1, null, "((val1 val1*)|val2)"),
		//				err(p.getList3_Val2(), ERROR_VALUE_REQUIRED, 1, null, "((val1 val1*)|val2)"));

		copy = (List3) EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.setVal2("lala");
		validate(copy).assertOK();
	}

}
