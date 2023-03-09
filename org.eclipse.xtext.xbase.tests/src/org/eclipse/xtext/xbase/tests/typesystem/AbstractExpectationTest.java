/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractExpectationTest extends AbstractXbaseTestCase {
	private List<String> expectations;

	private List<ITypeExpectation> finalExpectations;

	private List<XExpression> expressions;

	private IResolvedTypes resolvedTypes;

	private XExpression rootExpression;

	private boolean pendingAssert = false;

	public abstract ExpectationTestingTypeComputer getTypeComputer();

	public abstract PublicReentrantTypeResolver getResolver();

	public AbstractExpectationTest expects(String input) throws Exception {
		rootExpression = expression(input, false);
		getResolver().initializeFrom(rootExpression);
		resolvedTypes = getResolver().reentrantResolve(CancelIndicator.NullImpl);
		pendingAssert = true;
		return this;
	}

	public void clearData() {
		resolvedTypes = null;
		expectations = new ArrayList<>();
		finalExpectations = new ArrayList<>();
		expressions = new ArrayList<>();
	}

	public AbstractExpectationTest types(String... names) {
		Assert.assertTrue(pendingAssert);
		pendingAssert = false;
		Assert.assertEquals(expectations.toString(), names.length, expectations.size());
		Assert.assertEquals(Sets.newLinkedHashSet(Arrays.asList(names)), Sets.newLinkedHashSet(expectations));
		return this;
	}

	public AbstractExpectationTest finalizedAs(String... names) {
		Assert.assertFalse(pendingAssert);
		Assert.assertEquals(Lists.transform(finalExpectations, (ITypeExpectation it) -> {
			LightweightTypeReference expectedType = it.getExpectedType();
			if (expectedType != null) {
				return expectedType.getSimpleName();
			}
			return null;
		}).toString(), names.length, expectations.size());
		Assert.assertEquals(Sets.newLinkedHashSet(Arrays.asList(names)),
				Sets.newLinkedHashSet(Lists.transform(finalExpectations, (ITypeExpectation it) -> {
					LightweightTypeReference expectedType = it.getExpectedType();
					if (expectedType != null) {
						return expectedType.getSimpleName();
					}
					return null;
				})));
		return this;
	}

	public AbstractExpectationTest queriedAs(String... names) {
		pendingAssert = false;
		List<LightweightTypeReference> expectedTypes = Lists.transform(expressions, (XExpression it) -> {
			return resolvedTypes.getExpectedType(it);
		});
		Assert.assertEquals(Lists.transform(expectedTypes, (LightweightTypeReference it) -> {
			return it.getSimpleName();
		}).toString(), names.length, expectedTypes.size());
		Assert.assertEquals(Sets.newLinkedHashSet(Arrays.asList(names)),
				Sets.newLinkedHashSet(Lists.transform(expectedTypes, (LightweightTypeReference it) -> {
					return it.getSimpleName();
				})));
		return this;
	}

	public AbstractExpectationTest nothing() {
		Assert.assertTrue(pendingAssert);
		pendingAssert = false;
		Assert.assertEquals(1, finalExpectations.size());
		ITypeExpectation expectation = Iterables.getFirst(finalExpectations, null);
		Assert.assertNotNull(expectation);
		Assert.assertTrue(expectation.isNoTypeExpectation());
		Assert.assertTrue(expectation.isVoidTypeAllowed());
		Assert.assertNull(expectation.getExpectedType());
		return this;
	}

	public AbstractExpectationTest notVoid() {
		Assert.assertTrue(pendingAssert);
		pendingAssert = false;
		Assert.assertEquals(1, finalExpectations.size());
		ITypeExpectation expectation = Iterables.getFirst(finalExpectations, null);
		Assert.assertNotNull(expectation);
		Assert.assertFalse(expectation.isNoTypeExpectation());
		Assert.assertFalse(expectation.isVoidTypeAllowed());
		Assert.assertNull(expectation.getExpectedType());
		return this;
	}

	@Before
	public void setUp() throws Exception {
		getTypeComputer().setTest(this);
		pendingAssert = false;
		getResolver().setTypeComputer(getTypeComputer());
		clearData();
	}

	@After
	public void tearDown() throws Exception {
		Assert.assertFalse(pendingAssert);
		pendingAssert = false;
		expectations = null;
		finalExpectations = null;
		expressions = null;
		resolvedTypes = null;
		rootExpression = null;
		getTypeComputer().setTest(null);
		getResolver().setTypeComputer(null);
	}

	public void recordExpectation(XExpression expression, ITypeComputationState state) {
		Iterables.addAll(finalExpectations, state.getExpectations());
		Iterables.addAll(expectations, Lists.transform(state.getExpectations(), (ITypeExpectation it) -> {
			LightweightTypeReference expectedType = it.getExpectedType();
			if (expectedType != null) {
				return expectedType.getSimpleName();
			}
			return null;
		}));
		expressions.add(expression);
	}

	@Test
	public void testIfCondition() throws Exception {
		expects("if (null) true").types("boolean");
	}

	@Test
	public void testNotLastExpressionInBlock() throws Exception {
		expects("{ null true }").nothing();
	}

	@Test
	public void testSwitchValue() throws Exception {
		expects("switch null case true: true").notVoid();
	}

	@Test
	public void testAssignment_01() throws Exception {
		expects("{ val String s = null }").types("String");
	}

	@Test
	public void testAssignment_02() throws Exception {
		expects("{ val String s; s = null }").types("String");
	}

	@Test
	public void testTransitiveAssignment() throws Exception {
		expects("{ val StringBuilder s = if (true) null }").types("StringBuilder");
	}

	@Test
	public void testFeatureCallArgument_01() throws Exception {
		expects("''.substring(null)").types("int");
	}

	@Test
	public void testFeatureCallArgument_02() throws Exception {
		expects("newArrayList.<String>findFirst(null)").types("Function1<? super String, Boolean>")
				.finalizedAs("Function1<? super String, Boolean>");
	}

	@Test
	public void testFeatureCallArgument_03() throws Exception {
		expects("newArrayList.findFirst(null)").types("Function1<? super Unbound[T], Boolean>")
				.finalizedAs("Function1<? super Object, Boolean>");
	}

	@Test
	public void testFeatureCallArgument_04() throws Exception {
		expects("<String>newArrayList.findFirst(null)").types("Function1<? super Unbound[T], Boolean>")
				.finalizedAs("Function1<? super String, Boolean>");
	}

	@Test
	public void testFeatureCallArgument_05() throws Exception {
		expects("newArrayList('').findFirst(null)").types("Function1<? super Unbound[T], Boolean>")
				.finalizedAs("Function1<? super String, Boolean>");
	}

	@Test
	public void testFeatureCallArgument_06() throws Exception {
		expects("{\n\t\t\tval (Iterable<CharSequence>)=>void f\n\t\t\tf.apply(null)\n\t\t}").types("Iterable<CharSequence>")
				.finalizedAs("Iterable<CharSequence>");
	}

	@Test
	@Ignore("TODO null type is bound differently")
	public void testExtensionReceiver_01() throws Exception {
		expects("null.isNullOrEmpty()").types("String", "Iterable<Unbound[T]>");
	}

	@Test
	public void testFeatureCallVarArgument_01() throws Exception {
		expects("newArrayList(null)").types("Unbound[T]", "Unbound[T][]").finalizedAs("Object", "Object[]");
	}

	@Test
	public void testFeatureCallVarArgument_02() throws Exception {
		expects("newArrayList(null, '')").types("Unbound[T]").finalizedAs("String");
	}

	@Test
	public void testFeatureCallVarArgument_03() throws Exception {
		expects("{ val Iterable<String> iterable = newArrayList(null) }").types("Unbound[T][]", "Unbound[T]").finalizedAs("String[]",
				"String");
	}

	@Test
	public void testFeatureCallVarArgument_04() throws Exception {
		getTypeComputer().setPredicate((XExpression it) -> it instanceof XReturnExpression);
		expects("new foo.ClassWithGenericMethod().genericMethod(return null)").types("Unbound[T]").finalizedAs("Object");
	}

	@Test
	public void testForLoop_01() throws Exception {
		expects("for(int x: null) {}").types("int[] | Iterable<? extends Integer> | Integer[]")
				.finalizedAs("int[] | Iterable<? extends Integer> | Integer[]");
	}

	@Test
	public void testForLoop_02() throws Exception {
		expects("for(String x: null) {}").types("Iterable<? extends String> | String[]")
				.finalizedAs("Iterable<? extends String> | String[]");
	}

	@Test
	public void testForLoop_03() throws Exception {
		expects("for(Integer x: null) {}").types("Iterable<? extends Integer> | int[] | Integer[]")
				.finalizedAs("Iterable<? extends Integer> | int[] | Integer[]");
	}

	@Test
	public void testUpperBound_01() throws Exception {
		expects("(1 as Comparable<?>).compareTo(null)").types("null").finalizedAs("null");
	}

	@Test
	public void testLowerBound_01() throws Exception {
		expects("(1 as Comparable<? super CharSequence>).compareTo(null)").types("CharSequence").finalizedAs("CharSequence");
	}

	@Test
	public void testReturn_01() throws Exception {
		expects("return null").notVoid();
	}

	@Test
	public void testReturn_02() throws Exception {
		expects("return { { null } }").notVoid();
	}

	@Test
	public void testReturn_03() throws Exception {
		expects("return if (true) { { null } }").notVoid();
	}

	@Test
	public void testReturn_04() throws Exception {
		expects("return if (true) { null '' }").nothing();
	}

	@Test
	public void testRawType_01() throws Exception {
		expects("('' as Comparable).compareTo(null)").types("Object");
	}

	@Test
	public void testInvocationOnPrimitive() throws Exception {
		getTypeComputer().setPredicate((XExpression it) -> it instanceof XNumberLiteral);
		expects("1L.intValue").types(((String) null)).finalizedAs(((String) null)).queriedAs("Long");
	}

	@Test
	public void testImplicitReceiver() throws Exception {
		getTypeComputer().setPredicate((XExpression it) -> false);
		expects("{val it = 1L intValue}");
		XFeatureCall intValue = IteratorExtensions.head(Iterators.filter(rootExpression.eAllContents(), XFeatureCall.class));
		expressions.add(intValue.getImplicitReceiver());
		queriedAs("Long");
	}

	@Test
	public void testExtension() throws Exception {
		getTypeComputer().setPredicate((XExpression it) -> it instanceof XCastedExpression);
		expects("(null as String[]).size").types(((String) null)).finalizedAs(((String) null)).queriedAs("List<String>");
	}

	@Test
	public void testImplicitFirstArgument() throws Exception {
		getTypeComputer().setPredicate((XExpression it) -> false);
		expects("{val it = null as String[] head}");
		XFeatureCall size = IteratorExtensions.head(Iterators.filter(rootExpression.eAllContents(), XFeatureCall.class));
		expressions.add(size.getImplicitFirstArgument());
		queriedAs("Iterable<String>");
	}

	@Test
	public void testBug379531_01() throws Exception {
		getTypeComputer().setPredicate((XExpression it) -> it instanceof XCastedExpression);
		expects("newArrayList('', '', null as String)").types("Unbound[T]").finalizedAs("String");
	}

	@Test
	public void testBug379531_02() throws Exception {
		getTypeComputer().setPredicate((XExpression it) -> it instanceof XCastedExpression);
		expects("newArrayList('', '', null as CharSequence)").types("Unbound[T]").finalizedAs("CharSequence");
	}

	@Test
	public void testBug379531_03() throws Exception {
		expects("newArrayList('', '', null)").types("Unbound[T]").finalizedAs("String");
	}

	@Test
	public void testExpectationFromTypeParameter_01() throws Exception {
		expects("{ val Iterable<Number> iterable = newArrayList(null) }").types("Unbound[T]", "Unbound[T][]").finalizedAs("Number",
				"Number[]");
	}

	@Test
	public void testExpectationFromTypeParameter_02() throws Exception {
		expects("{ val Iterable<Iterable<Number>> iterable = newArrayList(newArrayList(null)) }")
				.types("Unbound[T]", "Unbound[T][]", "Unbound[T]", "Unbound[T][]")
				.finalizedAs("Number", "Number[]", "Iterable<Number>", "Iterable<Number>[]");
	}
}
