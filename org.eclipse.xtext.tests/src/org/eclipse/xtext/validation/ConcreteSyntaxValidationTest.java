/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import static org.eclipse.xtext.validation.AssertableDiagnostics.*;
import static org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider.*;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.csvalidationtest.AltList1;
import org.eclipse.xtext.validation.csvalidationtest.AltList2;
import org.eclipse.xtext.validation.csvalidationtest.AlternativeMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.AssignedAction;
import org.eclipse.xtext.validation.csvalidationtest.Combination1;
import org.eclipse.xtext.validation.csvalidationtest.Combination2;
import org.eclipse.xtext.validation.csvalidationtest.Combination3;
import org.eclipse.xtext.validation.csvalidationtest.Combination4;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestFactory;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage;
import org.eclipse.xtext.validation.csvalidationtest.GroupMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.Heuristic1;
import org.eclipse.xtext.validation.csvalidationtest.List1;
import org.eclipse.xtext.validation.csvalidationtest.List2;
import org.eclipse.xtext.validation.csvalidationtest.List3;
import org.eclipse.xtext.validation.csvalidationtest.List4;
import org.eclipse.xtext.validation.csvalidationtest.List5;
import org.eclipse.xtext.validation.csvalidationtest.SimpleAlternative;
import org.eclipse.xtext.validation.csvalidationtest.SimpleGroup;
import org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.StaticSimplification;
import org.eclipse.xtext.validation.csvalidationtest.TransientObject;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1Enum;
import org.eclipse.xtext.validation.csvalidationtest.TwoVersion;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction3;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2SubAction;
import org.eclipse.xtext.validation.csvalidationtest.impl.TransientObjectImpl;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxValidator;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author meysholdt - Initial contribution and API
 */
public class ConcreteSyntaxValidationTest extends AbstractConcreteSyntaxValidationTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ConcreteSyntaxValidationTestLanguageStandaloneSetup.class);
		validator = getInjector().getInstance(ConcreteSyntaxValidator.class);
	}

	private IConcreteSyntaxValidator validator;

	@Override
	protected IConcreteSyntaxValidator getValidator() {
		return validator;
	}

	private static CsvalidationtestPackage p = CsvalidationtestPackage.eINSTANCE;
	private static CsvalidationtestFactory f = CsvalidationtestFactory.eINSTANCE;

	private EObject getModel2(String model) throws Exception {
		return getModel(model).eContents().get(0);
	}

	@Test public void testSimpleGroup1() throws Exception {
		SimpleGroup m = (SimpleGroup) getModel2("#1 abc def");
		validate(m).assertOK();
		m.setVal2(null);
		validate(m).assertAll(err(p.getSimpleGroup_Val2(), ERROR_VALUE_REQUIRED, 1, 1, ""));
	}

	@Test public void testSimpleAlternative1() throws Exception {
		SimpleAlternative m = (SimpleAlternative) getModel2("#2 kw1 abc");
		validate(m).assertOK();
		m.setVal2("def2");
		validate(m).assertAll(err(p.getSimpleAlternative_Val1(), ERROR_VALUE_PROHIBITED, null, 0, "(val1|val2)"),
				err(p.getSimpleAlternative_Val2(), ERROR_VALUE_PROHIBITED, null, 0, "(val1|val2)"));
	}

	@Test public void testSimpleMultiplicities1() throws Exception {
		SimpleMultiplicities m = (SimpleMultiplicities) getModel2("#3 abc kw1 def kw2 fgh ijk kw3 lmn opq");
		validate(m).assertOK();
		m.setVal2(null);
		m.getVal3().remove(0);
		m.getVal4().clear();
		validate(m).assertOK();

		SimpleMultiplicities copy = EcoreUtil.copy(m);
		copy.setVal1(null);
		validate(copy).assertAll(err(p.getSimpleMultiplicities_Val1(), ERROR_VALUE_REQUIRED, 1, null, ""));

		copy = EcoreUtil.copy(m);
		copy.getVal3().clear();
		validate(copy).assertAll(err(p.getSimpleMultiplicities_Val3(), ERROR_LIST_TOO_FEW, 1, null, ""));
	}

	@Test public void testGroupMultiplicities1() throws Exception {
		GroupMultiplicities m = (GroupMultiplicities) getModel2("#4 abc kw1 def def kw2 fgh ijk kw3 lmn opq");
		validate(m).assertOK();

		GroupMultiplicities copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal3(null);
		copy.getVal6().clear();
		copy.getVal7().clear();
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val2(), ERROR_VALUE_REQUIRED, 1, null, "(val2 val3)?"),
				err(p.getGroupMultiplicities_Val3(), ERROR_VALUE_PROHIBITED, null, 0, "(val2 val3)?"));

		copy = EcoreUtil.copy(m);
		copy.getVal5().clear();
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val5(), ERROR_LIST_TOO_FEW, 1, null, "(val4 val5)+"));

		copy = EcoreUtil.copy(m);
		copy.getVal4().clear();
		copy.getVal5().clear();
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val4(), ERROR_LIST_TOO_FEW, 1, null, "(val4 val5)+"),
				err(p.getGroupMultiplicities_Val5(), ERROR_LIST_TOO_FEW, 1, null, "(val4 val5)+"));

		copy = EcoreUtil.copy(m);
		copy.getVal5().add("sdlasjdk");
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val4(), ERROR_LIST_TOO_FEW, 2, null, "(val4 val5)+"),
				err(p.getGroupMultiplicities_Val5(), ERROR_LIST_TOO_MANY, null, 1, "(val4 val5)+"));

		copy = EcoreUtil.copy(m);
		copy.getVal6().clear();
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val6(), ERROR_LIST_TOO_FEW, 1, 1, "(val6 val7)*"),
				err(p.getGroupMultiplicities_Val7(), ERROR_LIST_TOO_MANY, 0, 0, "(val6 val7)*"));

		copy = EcoreUtil.copy(m);
		copy.getVal7().add("test");
		validate(copy).assertAll(err(p.getGroupMultiplicities_Val6(), ERROR_LIST_TOO_FEW, 2, null, "(val6 val7)*"),
				err(p.getGroupMultiplicities_Val7(), ERROR_LIST_TOO_MANY, 1, 1, "(val6 val7)*"));

	}

	@Test public void testAlternativeMultiplicities1() throws Exception {
		AlternativeMultiplicities m = (AlternativeMultiplicities) getModel2("#5 abc kw2 kw3 fgh kw3 xxx kw4 ijk lmn opq");
		validate(m).assertOK();

		AlternativeMultiplicities copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal3(null);
		copy.getVal6().clear();
		copy.getVal7().clear();
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal3("lalal");
		validate(copy).assertAll(
				err(p.getAlternativeMultiplicities_Val2(), ERROR_VALUE_PROHIBITED, null, 0, "(val2|val3)?"),
				err(p.getAlternativeMultiplicities_Val3(), ERROR_VALUE_PROHIBITED, null, 0, "(val2|val3)?"));

		copy = EcoreUtil.copy(m);
		copy.getVal5().clear();
		validate(copy).assertAll(
				err(p.getAlternativeMultiplicities_Val4(), ERROR_LIST_TOO_FEW, 1, null, "(val4|val5)+"),
				err(p.getAlternativeMultiplicities_Val5(), ERROR_LIST_TOO_FEW, 1, null, "(val4|val5)+"));

		copy = EcoreUtil.copy(m);
		copy.getVal4().add("sdfg");
		copy.getVal4().add("dfdf");
		validate(copy).assertOK();
	}

	@Test public void testAssignedAction1() throws Exception {
		AssignedAction m = (AssignedAction) getModel2("#6 id1 id2 id3");
		validate(m).assertOK();
		m.setVal1(null);

		// The validator is expected to ignore rules containing assigned Actions.
		validate(m).assertOK();
	}

	@Test public void testAssignedAction2() throws Exception {
		AssignedAction m = (AssignedAction) getModel2("#7 id1 kw1 id3");
		validate(m).assertOK();
		m.setVal1(null);

		// The validator is expected to ignore rules if there is a rule with the same return type which contains assigned actions
		validate(m).assertOK();
	}

	@Test public void testUnassignedAction1() throws Exception {
		UnassignedAction1 m = (UnassignedAction1) getModel2("#8 id1");
		validate(m).assertOK();
		m.setVal1(null);
		validate(m).assertAll(err(p.getUnassignedAction1_Val1(), ERROR_VALUE_REQUIRED, 1, null, ""));
	}

	@Test public void testUnassignedAction2() throws Exception {
		UnassignedAction2Sub m = (UnassignedAction2Sub) getModel2("#9 id1");
		validate(m).assertOK();
		m.setVal1(null);
		validate(m).assertAll(err(p.getUnassignedAction2Sub_Val1(), ERROR_VALUE_REQUIRED, 1, 1, ""));
	}

	@Test public void testUnassignedAction3() throws Exception {
		UnassignedAction3 m = (UnassignedAction3) getModel2("#10 kw1 id1 id2");
		validate(m).assertOK();
		m.setVal1(null);
		validate(m).assertAll(err(p.getUnassignedAction3_Val1(), ERROR_VALUE_REQUIRED, 1, 1, ""));

		UnassignedAction3 ua = f.createUnassignedAction3();
		ua.setVal1("xx");
		validate(ua).assertAll(errorCode(ERROR_WRONG_TYPE));
	}

	@Test public void testUnassignedRuleCall1() throws Exception {
		UnassignedRuleCall1Sub m = (UnassignedRuleCall1Sub) getModel2("#11 id1 id2");
		validate(m).assertOK();

		m.setVal1(null);
		validate(m).assertAll(err(p.getUnassignedRuleCall1Sub_Val1(), ERROR_VALUE_REQUIRED, 1, 1, ""));

		UnassignedRuleCall1 m1 = f.createUnassignedRuleCall1();
		validate(m1).assertAll(errorCode(ERROR_WRONG_TYPE));
	}

	@Test public void testUnassignedRuleCall2() throws Exception {
		UnassignedRuleCall2SubAction a = f.createUnassignedRuleCall2SubAction();
		a.setVal2("foo");
		validate(a).assertOK();

		UnassignedRuleCall2Sub s = f.createUnassignedRuleCall2Sub();
		s.setVal2("foo");
		validate(s).assertAll(errorCode(ERROR_WRONG_TYPE));

		UnassignedRuleCall2 c = f.createUnassignedRuleCall2();
		validate(c).assertAll(errorCode(ERROR_WRONG_TYPE));
	}

	@Test public void testCombination1() throws Exception {
		Combination1 copy, m = (Combination1) getModel2("#13 id1 kw1 id2 kw2 id3");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal3(null);
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		validate(copy).assertAll(err(p.getCombination1_Val2(), ERROR_VALUE_REQUIRED, 1, null, "(val2 (val3|val4))?"),
				err(p.getCombination1_Val3(), ERROR_VALUE_PROHIBITED, null, 0, "(val2 (val3|val4))?"));

		copy = EcoreUtil.copy(m);
		copy.setVal3(null);
		validate(copy).assertAll(err(p.getCombination1_Val2(), ERROR_VALUE_PROHIBITED, null, 0, "(val2 (val3|val4))?"),
				err(p.getCombination1_Val3(), ERROR_VALUE_REQUIRED, 1, null, "(val2 (val3|val4))?"),
				err(p.getCombination1_Val4(), ERROR_VALUE_REQUIRED, 1, null, "(val2 (val3|val4))?"));
	}

	@Test public void testCombination2() throws Exception {
		Combination2 copy, m = (Combination2) getModel2("#14 id1 id31 id41 id32 id42");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal3().add("foo");
		validate(copy).assertAll(err(p.getCombination2_Val3(), ERROR_LIST_TOO_MANY, 2, 2, "(val2|(val3 val4)*)"),
				err(p.getCombination2_Val4(), ERROR_LIST_TOO_FEW, 3, 3, "(val2|(val3 val4)*)"));

		copy = EcoreUtil.copy(m);
		copy.setVal2("foo");
		validate(copy).assertAll(err(p.getCombination2_Val2(), ERROR_VALUE_PROHIBITED, null, 0, "(val2|(val3 val4)*)"),
				err(p.getCombination2_Val3(), ERROR_LIST_TOO_MANY, null, 0, "(val2|(val3 val4)*)"),
				err(p.getCombination2_Val4(), ERROR_LIST_TOO_MANY, null, 0, "(val2|(val3 val4)*)"));
	}

	@Test public void testCombination3() throws Exception {
		Combination3 copy, m = (Combination3) getModel2("#15 'string' id1 1234");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal1(null);
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal1(null);
		copy.setVal2(0);
		validate(copy).assertOK();
	}

	@Test public void testCombination4() throws Exception {
		Combination4 copy, m = (Combination4) getModel2("#16 group id11 id12 id13 group id21 id22 id23");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().add("xxx");
		validate(copy).assertAll(err(p.getCombination4_Val1(), ERROR_LIST_TOO_MANY, null, 2, "(val1 val2 val3)+"));

		copy = EcoreUtil.copy(m);
		copy.getVal1().remove(0);
		validate(copy).assertAll(err(p.getCombination4_Val2(), ERROR_LIST_TOO_MANY, null, 1, "(val1 val2 val3)+"),
				err(p.getCombination4_Val3(), ERROR_LIST_TOO_MANY, null, 1, "(val1 val2 val3)+"));
	}

	@Test public void testList1() throws Exception {
		List1 copy, m = (List1) getModel2("#17 id1, id2, id2");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.getVal1().add("xxx");
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		validate(copy).assertAll(err(p.getList1_Val1(), ERROR_LIST_TOO_FEW, 1, null, ""));
	}

	@Test public void testList2() throws Exception {
		List2 copy, m = (List2) getModel2("#18 id1, id2, id2");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.getVal1().add("xxx");
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		validate(copy).assertOK();
	}

	@Test public void testList3() throws Exception {
		List3 copy, m = (List3) getModel2("#19 id1, id2, id2");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.getVal1().add("xxx");
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		validate(copy).assertAll(err(p.getList3_Val1(), ERROR_LIST_TOO_FEW, 1, null, "(val1+|val2)"),
				err(p.getList3_Val2(), ERROR_VALUE_REQUIRED, 1, null, "(val1+|val2)"));

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.setVal2("lala");
		validate(copy).assertOK();
	}

	@Test public void testList4() throws Exception {
		List4 copy, m = (List4) getModel2("#20 id11, id12, id13 kw3 id2");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.getVal1().add("xxx");
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		validate(copy).assertAll(err(p.getList4_Val1(), ERROR_LIST_TOO_FEW, 1, null, ""));

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		validate(copy).assertAll(err(p.getList4_Val2(), ERROR_VALUE_REQUIRED, 1, null, ""));
	}

	@Test public void testList5() throws Exception {
		List5 copy, m = (List5) getModel2("#21 id11, id12, id13 kw3 id2");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.getVal1().add("xxx");
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		copy.setVal2(null);
		copy.setVal3("foo");
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.getVal1().clear();
		validate(copy).assertAll(err(p.getList5_Val1(), ERROR_LIST_TOO_FEW, 1, null, "((val1+ val2)|val3)"));

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		validate(copy).assertAll(err(p.getList5_Val2(), ERROR_VALUE_REQUIRED, 1, null, "((val1+ val2)|val3)"));

		copy = EcoreUtil.copy(m);
		copy.setVal3("foo");
		validate(copy).assertAll(err(p.getList5_Val1(), ERROR_LIST_TOO_MANY, null, 0, "((val1+ val2)|val3)"),
				err(p.getList5_Val2(), ERROR_VALUE_PROHIBITED, null, 0, "((val1+ val2)|val3)"),
				err(p.getList5_Val3(), ERROR_VALUE_PROHIBITED, null, 0, "((val1+ val2)|val3)"));
	}

	@Test public void testAltList1() throws Exception {
		AltList1 copy, m = (AltList1) getModel2("#22 id1 id2");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal3("foo");
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal4("foo");
		validate(copy).assertOK();
	}

	@Test public void testAltList2() throws Exception {
		AltList2 copy, m = (AltList2) getModel2("#23 id1 id2");
		validate(m).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal3("foo");
		validate(copy).assertOK();

		copy = EcoreUtil.copy(m);
		copy.setVal2(null);
		copy.setVal3("foo");
		copy.getVal1().add("foo");
		copy.getVal1().add("foo");
		validate(copy).assertOK();
	}

	@Test public void testTransientObject() {
		TransientObject to = new TransientObjectImpl() {
			@Override
			public boolean eIsSet(int featureID) {
				switch (featureID) {
					case CsvalidationtestPackage.TRANSIENT_OBJECT__NESTED:
						return nested != null && !"default".equals(nested.getVal2());
				}
				return super.eIsSet(featureID);
			}

			@Override
			public EList<EObject> eContents() {
				EList<EObject> r = new BasicEList<EObject>();
				if (nested != null)
					r.add(nested);
				return r;
			}
		};
		to.setNested(f.createTransientObjectSub());
		to.getNested().setVal2("default");
		validate(to).assertOK();

		to.setVal1("xxx");
		to.getNested().setVal2("something");
		to.getNested().setVal3("something");
		validate(to).assertOK();
	}

	@Test public void testTransientSerializeables1() throws Exception {
		TransientSerializeables1 m = f.createTransientSerializeables1();
		validate(m).assertOK();

		m = f.createTransientSerializeables1();
		m.setVal1("foo");
		m.setEnum1(TransientSerializeables1Enum.LIT2);
		validate(m).assertOK();

		m = f.createTransientSerializeables1();
		m.setVal2("foo");
		m.setInt1(5);
		validate(m).assertOK();

		m = f.createTransientSerializeables1();
		m.setVal1("foo");
		validate(m).assertOK();

		m = f.createTransientSerializeables1();
		m.setVal2("foo");
		validate(m).assertOK();

		m = f.createTransientSerializeables1();
		m.setEnum1(TransientSerializeables1Enum.LIT2);
		validate(m).assertAll(
				err(p.getTransientSerializeables1_Enum1(), ERROR_VALUE_PROHIBITED, null, 0, "(val1 enum1)?"),
				err(p.getTransientSerializeables1_Val1(), ERROR_VALUE_REQUIRED, 1, null, "(val1 enum1)?"));

		m = f.createTransientSerializeables1();
		m.setInt1(5);
		validate(m).assertAll(
				err(p.getTransientSerializeables1_Int1(), ERROR_VALUE_PROHIBITED, null, 0, "(val2 int1)?"),
				err(p.getTransientSerializeables1_Val2(), ERROR_VALUE_REQUIRED, 1, null, "(val2 int1)?"));
	}

	@Test public void testStaticSimplification() {
		StaticSimplification m = f.createStaticSimplification();
		validate(m).assertOK();

		m = f.createStaticSimplification();
		m.setVal1("foo");
		validate(m).assertOK();

		m = f.createStaticSimplification();
		m.setVal2("foo");
		validate(m).assertOK();

		m = f.createStaticSimplification();
		m.setVal3("foo");
		validate(m).assertOK();

		m = f.createStaticSimplification();
		m.setVal1("foo");
		m.setVal2("foo");
		m.setVal3("foo");
		validate(m).assertOK();

		m = f.createEmptyAlternativeSub();
		m.setVal1("foo");
		validate(m).assertAll(errorCode(ERROR_ASSIGNMENT_PROHIBITED));

		m = f.createEmptyAlternativeSub();
		m.setVal2("foo");
		validate(m).assertOK();

		m = f.createEmptyAlternativeSub();
		m.setVal3("foo");
		validate(m).assertOK();

		m = f.createEmptyAlternativeSub();
		m.setVal2("foo");
		m.setVal3("foo");
		validate(m).assertOK();
	}

	@Test public void testTwoVersion() {
		TwoVersion m = f.createTwoVersion();
		validate(m).assertAll(
				err(p.getTwoVersion_Shared2(), ERROR_VALUE_REQUIRED, null, null,
						"((shared1? shared2 shared3* version1?)|(shared1? shared2"
								+ " shared3* extra1? ((extra2 extra3)|extra4)?))"));
		m = f.createTwoVersion();
		m.setShared2("foo");
		validate(m).assertOK();

		m = f.createTwoVersion();
		m.setShared2("foo");
		m.setShared1("bar");
		validate(m).assertOK();

		m = f.createTwoVersion();
		m.setShared2("foo");
		m.setShared1("bar");
		m.getShared3().add("no1");
		m.getShared3().add("no2");
		m.getShared3().add("no3");
		validate(m).assertOK();

		m = f.createTwoVersion();
		m.setShared2("foo");
		m.setShared1("bar");
		m.setVersion1("xxx");
		validate(m).assertOK();

		m = f.createTwoVersion();
		m.setShared2("foo");
		m.setShared1("bar");
		m.setExtra1("lala");
		validate(m).assertOK();

		m = f.createTwoVersion();
		m.setShared2("foo");
		m.setShared1("bar");
		m.getShared3().add("no1");
		m.getShared3().add("no2");
		m.getShared3().add("no3");
		m.setExtra4("fooo");
		validate(m).assertOK();

		m = f.createTwoVersion();
		m.setShared2("foo");
		m.setShared1("bar");
		m.getShared3().add("no1");
		m.getShared3().add("no2");
		m.getShared3().add("no3");
		m.setExtra2("fooo");
		m.setExtra3("fooo");
		validate(m).assertOK();

		m = f.createTwoVersion();
		m.setShared2("foo");
		m.setShared1("bar");
		m.getShared3().add("no1");
		m.getShared3().add("no2");
		m.getShared3().add("no3");
		m.setExtra1("fooo");
		m.setExtra2("fooo");
		m.setExtra3("fooo");
		validate(m).assertOK();

		m = f.createTwoVersion();
		m.setVersion1("foo");
		validate(m).assertAll(
				err(p.getTwoVersion_Shared2(), ERROR_VALUE_REQUIRED, null, null,
						"((shared1? shared2 shared3* version1?)|(shared1? shared2"
								+ " shared3* extra1? ((extra2 extra3)|extra4)?))"));

		m = f.createTwoVersion();
		m.setExtra4("foo");
		validate(m).assertAll(
				err(p.getTwoVersion_Shared2(), ERROR_VALUE_REQUIRED, null, null,
						"((shared1? shared2 shared3* version1?)|(shared1? shared2"
								+ " shared3* extra1? ((extra2 extra3)|extra4)?))"));

		m = f.createTwoVersion();
		m.setExtra3("foo");
		validate(m).assertAll(
				err(p.getTwoVersion_Shared2(), ERROR_VALUE_REQUIRED, null, null,
						"((shared1? shared2 shared3* version1?)|(shared1? shared2"
								+ " shared3* extra1? ((extra2 extra3)|extra4)?))"),
				err(p.getTwoVersion_Extra2(), ERROR_VALUE_REQUIRED, null, null,
						"((shared1? shared2 shared3* version1?)|((extra2 extra3)|extra4)?)"));
	}
	
	private List<String> strings(int count) {
		List<String> result = Lists.newArrayList();
		for (int i = 0; i < count; i++)
			result.add("foo" + i);
		return result;
	}

	@Test
	public void testHeuristic1() {
		Heuristic1 m = f.createHeuristic1();
		m.getA().addAll(Lists.newArrayList("foo", "foo", "foo"));
		m.getB().addAll(Lists.newArrayList("foo", "foo", "foo"));
		validate(m).assertOK();

		m = f.createHeuristic1();
		m.getA().addAll(Lists.newArrayList("foo", "foo", "foo"));
		m.getC().addAll(Lists.newArrayList("foo", "foo", "foo"));
		validate(m).assertOK();

		m = f.createHeuristic1();
		m.getB().addAll(Lists.newArrayList("foo", "foo", "foo"));
		m.getC().addAll(Lists.newArrayList("foo", "foo", "foo"));
		validate(m).assertOK();

		m = f.createHeuristic1();
		m.getA().addAll(Lists.newArrayList("foo", "foo", "foo"));
		m.getB().addAll(Lists.newArrayList("foo", "foo", "foo"));
		m.getB().addAll(Lists.newArrayList("foo", "foo"));
		m.getC().addAll(Lists.newArrayList("foo", "foo"));
		validate(m).assertOK();

		m = f.createHeuristic1();
		m.getA().addAll(Lists.newArrayList("foo", "foo", "foo"));
		m.getB().addAll(Lists.newArrayList("foo", "foo", "foo"));
		m.getB().addAll(Lists.newArrayList("foo", "foo"));
		m.getC().addAll(Lists.newArrayList("foo", "foo"));
		m.getA().addAll(Lists.newArrayList("foo"));
		m.getC().addAll(Lists.newArrayList("foo"));
		validate(m).assertOK();
	}

	@Test
	public void testHeuristic1Large1() {
		Heuristic1 m = f.createHeuristic1();
		m.getA().addAll(strings(42));
		m.getB().addAll(strings(42));
		m.getB().addAll(strings(37));
		m.getC().addAll(strings(37));
		m.getA().addAll(strings(111));
		m.getC().addAll(strings(111));
		validate(m).assertOK();
	}

	@Test
	@Ignore("see https://bugs.eclipse.org/bugs/show_bug.cgi?id=310454")
	public void testHeuristic1Large2() {
		Heuristic1 m = f.createHeuristic1();
		m.getA().addAll(strings(42));
		m.getB().addAll(strings(42));
		m.getB().addAll(strings(37));
		m.getC().addAll(strings(37));
		m.getA().addAll(strings(111));
		m.getC().addAll(strings(111));
		m.getC().addAll(Lists.newArrayList("foo"));
		validate(m).assertAll(errorCode(ERROR_LIST_TOO_MANY), errorCode(ERROR_LIST_TOO_FEW));
	}
}
