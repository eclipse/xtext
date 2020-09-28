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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractClosureTypeTest2 extends AbstractXbaseTestCase {
	@Inject
	private IBatchTypeResolver typeResolver;

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	public List<Object> resolvesClosuresTo(CharSequence expression, String... types) throws Exception {
		List<XClosure> closures = findClosures(expression);
		Assert.assertFalse(closures.isEmpty());
		Assert.assertEquals(types.length, closures.size());
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(IterableExtensions.<XClosure>head(closures));
		List<Object> result = new ArrayList<>();
		IterableExtensions.forEach(closures, (XClosure closure, Integer index) -> {
			LightweightTypeReference closureType = resolvedTypes.getActualType(closure);
			collector.checkSucceeds(() -> {
				Assert.assertTrue("failed for closure at " + index + ": " + closureType,
						closureType instanceof FunctionTypeReference);
				return null;
			});
			collector.checkSucceeds(() -> {
				Assert.assertEquals("failed for closure at " + index, types[index], closureType.getSimpleName());
				return null;
			});
			result.add(closureType);
		});
		return result;
	}

	public void withEquivalents(List<Object> references, String... types) {
		IterableExtensions.forEach(references, (Object reference, Integer index) -> {
			collector.checkSucceeds(() -> {
				Assert.assertTrue(reference instanceof FunctionTypeReference);
				return null;
			});
			collector.checkSucceeds(() -> {
				Assert.assertEquals(types[index], getEquivalent((FunctionTypeReference) reference));
				return null;
			});
		});
	}

	public String getEquivalent(ParameterizedTypeReference type) {
		if (type.getTypeArguments().isEmpty()) {
			return type.getType().getSimpleName();
		}
		return type.getType().getSimpleName() + "<"
				+ IterableExtensions.join(type.getTypeArguments(), ", ", LightweightTypeReference::getSimpleName) + ">";
	}

	private static Set<String> seenExpressions;

	@BeforeClass
	public static void createSeenExpressionsSet() {
		seenExpressions = new HashSet<>();
	}

	@AfterClass
	public static void discardSeenExpressions() {
		seenExpressions = null;
	}

	protected List<XClosure> findClosures(CharSequence expression) throws Exception {
		String expressionAsString = expression.toString()
				.replace("ClosureTypeResolutionTestData",
						"org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeResolutionTestData")
				.replace("$$", "org::eclipse::xtext::xbase::lib::");
		XExpression xExpression = expression(expressionAsString, false);
		List<XClosure> Closures = Lists.newArrayList(Iterators.filter(EcoreUtil2.eAll(xExpression), XClosure.class));
		return IterableExtensions.sortBy(Closures, (XClosure it) -> NodeModelUtils.findActualNodeFor(it).getOffset());
	}

	@Override
	protected XExpression expression(CharSequence expression, boolean resolve) throws Exception {
		String string = expression.toString();
		if (!seenExpressions.add(string)) {
			Assert.fail("Duplicate expression under test: " + expression);
		}
		return super.expression(expression, resolve);
	}
}
