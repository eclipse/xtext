/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StringLiteralTest extends AbstractXbaseTestCase {
	@Inject
	private IBatchTypeResolver typeResolver;

	public void resolvesStringLiteralsTo(String expression, String... types) throws Exception {
		String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
		List<XStringLiteral> featureCalls = findLiterals(expressionWithQualifiedNames);
		Assert.assertFalse(featureCalls.isEmpty());
		Assert.assertEquals(types.length, featureCalls.size());
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(Iterables.getFirst(featureCalls, null));
		IterableExtensions.forEach(featureCalls, (XStringLiteral featureCall, Integer index) -> {
			LightweightTypeReference type = resolvedTypes.getActualType(featureCall);
			Assert.assertEquals("failed for literal at " + index, types[index], type.getSimpleName());
		});
	}

	protected List<XStringLiteral> findLiterals(CharSequence expression) throws Exception {
		XExpression xExpression = expression(expression, false);
		List<XStringLiteral> featureCalls = Lists
				.newArrayList(Iterators.filter(EcoreUtil2.eAll(xExpression), XStringLiteral.class));
		return IterableExtensions.sortBy(featureCalls, (XStringLiteral it) -> {
			return NodeModelUtils.findActualNodeFor(it).getOffset();
		});
	}

	@Test
	public void testNoExpectation_01() throws Exception {
		resolvesStringLiteralsTo("''", "String");
	}

	@Test
	public void testNoExpectation_02() throws Exception {
		resolvesStringLiteralsTo("'1'", "String");
	}

	@Test
	public void testNoExpectation_03() throws Exception {
		resolvesStringLiteralsTo("'11'", "String");
	}

	@Test
	public void testMemberCall_01() throws Exception {
		resolvesStringLiteralsTo("'1'.toString", "String");
	}

	@Test
	@Ignore("Improve typing according to expectation")
	public void testMemberCall_02() throws Exception {
		resolvesStringLiteralsTo("'1'.charValue", "char");
	}

	@Test
	@Ignore("Improve typing according to expectation")
	public void testMemberCall_03() throws Exception {
		resolvesStringLiteralsTo("'1'.compareTo(null as Character)", "char");
	}

	@Test
	@Ignore("Improve typing according to expectation")
	public void testBinaryOperation_01() throws Exception {
		resolvesStringLiteralsTo("{ var char c = '1' '1' == c", "char", "char");
	}

	@Test
	public void testBinaryOperation_02() throws Exception {
		resolvesStringLiteralsTo("{ var c = '1' '1' == c", "String", "String");
	}

	@Test
	public void testBinaryOperation_03() throws Exception {
		resolvesStringLiteralsTo("{ var String c = '1' '1' == c", "String", "String");
	}

	@Test
	public void testCharExpectation_01() throws Exception {
		resolvesStringLiteralsTo("{ var char c = '' }", "String");
	}

	@Test
	public void testCharExpectation_02() throws Exception {
		resolvesStringLiteralsTo("{ var char c = '1' }", "char");
	}

	@Test
	public void testCharExpectation_03() throws Exception {
		resolvesStringLiteralsTo("{ var char c = '11' }", "String");
	}

	@Test
	public void testCharExpectation_04() throws Exception {
		resolvesStringLiteralsTo("Character::valueOf('')", "String");
	}

	@Test
	public void testCharExpectation_05() throws Exception {
		resolvesStringLiteralsTo("Character::valueOf('1')", "char");
	}

	@Test
	public void testCharExpectation_06() throws Exception {
		resolvesStringLiteralsTo("Character::valueOf('11')", "String");
	}

	@Test
	public void testCharacterExpectation_01() throws Exception {
		resolvesStringLiteralsTo("{ var Character c = '' }", "String");
	}

	@Test
	public void testCharacterExpectation_02() throws Exception {
		resolvesStringLiteralsTo("{ var Character c = '1' }", "Character");
	}

	@Test
	public void testCharacterExpectation_03() throws Exception {
		resolvesStringLiteralsTo("{ var Character c = '11' }", "String");
	}

	@Test
	public void testAmbiguousExpectation_01() throws Exception {
		resolvesStringLiteralsTo("String::valueOf('')", "String");
	}

	@Test
	public void testAmbiguousExpectation_02() throws Exception {
		resolvesStringLiteralsTo("String::valueOf('1')", "String");
	}

	@Test
	public void testAmbiguousExpectation_03() throws Exception {
		resolvesStringLiteralsTo("String::valueOf('11')", "String");
	}

	@Test
	public void testCastToChar_01() throws Exception {
		resolvesStringLiteralsTo("'a' as Character", "String");
	}
}
