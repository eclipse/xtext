/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class GrammarConstraintProviderFeatureTest {
	@Inject
	private ValidationTestHelper validator;

	@Inject
	private ParseHelper<Grammar> parser;

	@Inject
	private IGrammarConstraintProvider constraintProvider;

	@Test
	public void simple() throws Exception {
		String actual = toFeatureInfo("Rule: val=ID; \n");
		String expected =
				"Rule_Rule{\n" +
				"  val[1,1]\n" +
				"}\n";
		assertEquals(expected, actual);
	}

	@Test
	public void optional() throws Exception {
		String actual = toFeatureInfo("Rule: {Rule} val=ID?; \n");
		String expected =
				"Rule_Rule{\n" +
				"  val[0,1]\n" +
				"}\n";
		assertEquals(expected, actual);
	}

	@Test
	public void multi() throws Exception {
		String actual = toFeatureInfo("Rule: val=ID+; \n");
		String expected =
				"Rule_Rule{\n" +
				"  val[1,*]\n" +
				"}\n";
		assertEquals(expected, actual);
	}

	@Test
	public void optionalMulti() throws Exception {
		String actual = toFeatureInfo("Rule: {Rule} val=ID*; \n");
		String expected =
				"Rule_Rule{\n" +
				"  val[0,*]\n" +
				"}\n";
		assertEquals(expected, actual);
	}

	@Test
	public void twoToThree() throws Exception {
		String actual = toFeatureInfo("Rule: val+=ID val+=ID val+=ID?; \n");
		String expected =
				"Rule_Rule{\n" +
				"  val[2,3]\n" +
				"}\n";
		assertEquals(expected, actual);
	}

	@Test
	public void twoDoubleLoop() throws Exception {
		String actual = toFeatureInfo("Rule: {Rule} (val1+=ID val2+=ID)*; \n");
		String expected =
				"Rule_Rule{\n" +
				"  val1[0,*]\n" +
				"  val2[0,*]\n" +
				"}\n";
		assertEquals(expected, actual);
	}

	@Test
	public void zeroToThree() throws Exception {
		String actual = this.toFeatureInfo("Rule: (val1+=ID | val2+=ID | val3+=ID) (val1+=ID | val2+=ID) val1+=ID; \n");
		String expected =
				"Rule_Rule{\n" +
				"  val1[1,3]\n" +
				"  val2[0,2]\n" +
				"  val3[0,1]\n" +
				"}\n";
		assertEquals(expected, actual);
	}

	@Test
	public void unordered() throws Exception {
		String actual = toFeatureInfo("Rule: val1+=ID & val2+=ID; \n");
		String expected =
				"Rule_Rule{\n" +
				"  val1[0,*]\n" +
				"  val2[0,*]\n}\n";
		assertEquals(expected, actual);
	}

	@Test
	public void complex1() throws Exception {
		String actual = toFeatureInfo(
				"Rule: 'a' val1+=ID 'b'\n" +
				"  (\n" +
				"    ('c' val2+=ID)?\n" +
				"    & ('d' val3+=ID)?\n" +
				"    & ('e' val4+=ID)?\n" +
				"  )\n" +
				"  ('f' val5+=ID*)?\n" +
				"  ('g' val6+=ID*)?\n" +
				"  'h';\n");
		String expected =
				"Rule_Rule{\n" +
				"  val1[1,1]\n" +
				"  val2[0,*]\n" +
				"  val3[0,*]\n" +
				"  val4[0,*]\n" +
				"  val5[0,*]\n" +
				"  val6[0,*]\n" +
				"}\n";
		assertEquals(expected, actual);
	}

	@Test
	public void complex2() throws Exception {
		String actual = this
				.toFeatureInfo(
				"Rule: {Rule} (val1+=ID | 'a')\n" +
				"  (val2+=ID & 'b')\n" +
				"  ('c' | val1+=ID);\n");
		String expected =
				"Rule_Rule{\n" +
				"  val1[0,2]\n" +
				"  val2[0,*]\n" +
				"}\n";
		assertEquals(expected, actual);
	}

	public void assertEquals(String expected, String actual) {
		if (expected != null) {
			expected = expected.replaceAll(System.lineSeparator(), "\n");
		}
		if (actual != null) {
			actual = actual.replaceAll(System.lineSeparator(), "\n");
		}
		Assert.assertEquals(expected, actual);
	}

	public String toFeatureInfo(CharSequence grammarString) throws Exception {
		Grammar grammar = parser.parse(
				"grammar org.eclipse.xtext.serializer.GrammarConstraintProviderFeatureTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate GrammarConstraintProviderFeatureTest 'http://www.eclipse.org/2010/tmf/xtext/GrammarConstraintProviderFeatureTestLanguage'\n" +
				"\n" +
				grammarString);
		validator.assertNoErrors(grammar);
		List<IConstraint> constraints = Lists.transform(constraintProvider.getConstraints(grammar).values(),
				it -> it.getValue());
		return Joiner.on("\n").join(Lists.transform(constraints, (IConstraint c) -> {
			return c.getName() + "{\n  "
					+ Joiner.on("\n  ").join(Lists.transform(Arrays.asList(c.getFeatures()), f -> asString(f))) + "\n}";
		})) + "\n";
	}

	public String asString(IGrammarConstraintProvider.IFeatureInfo it) {
		String upper = null;
		if (it.getUpperBound() == IGrammarConstraintProvider.MAX) {
			upper = "*";
		} else {
			upper = Integer.toString(it.getUpperBound());
		}
		return it.getFeature().getName() + "[" + it.getLowerBound() + "," + upper + "]";
	}
}
