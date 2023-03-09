/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow
 */
public class PermutingBatchReturnTypeResolverTest extends BatchReturnTypeResolverTest {
	@Override
	public LightweightTypeReference resolvesTo(String expression, String type) {
		try {
			String replacedExpressionText = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
			XExpression xExpression = expression(replacedExpressionText, false);
			Assert.assertTrue(xExpression.eResource().getErrors().toString(), xExpression.eResource().getErrors().isEmpty());
			Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
			if (!hasReturnExpression(xExpression)) {
				doResolvesTo("return (" + replacedExpressionText + ")", type);
				doResolvesTo("{ { return (" + replacedExpressionText + ") } }", type);
				doResolvesTo("return {" + replacedExpressionText + "}", type);
				doResolvesTo("{ { return { ( if (true) " + replacedExpressionText + " ) {" + replacedExpressionText + "} }", type);
			} else {
				doResolvesTo("{ " + replacedExpressionText + " }", type);
				doResolvesTo("{ ( if (true) " + replacedExpressionText + " ) {" + replacedExpressionText + "} }", type);
			}
			IResolvedTypes resolvedTypes = getTypeResolver().resolveTypes(xExpression);
			LightweightTypeReference resolvedType = resolvedTypes.getReturnType(xExpression);
			Assert.assertEquals(replacedExpressionText, type, resolvedType.getSimpleName());
			Assert.assertTrue(getLinkingAndSyntaxErrors(xExpression.eResource()).toString(),
					Iterables.isEmpty(getLinkingAndSyntaxErrors(xExpression.eResource())));
			Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
			return resolvedType;
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Test
	@Override
	public void testIfExpression_27() throws Exception {
		resolvesTo("return if (true) while(false) (\'a\'+\'b\').length", "null");
	}

	@Test
	@Override
	public void testSwitchExpression_11() throws Exception {
		resolvesTo("return switch null {\n\t\t  Object : return \n\t\t}", "void");
	}
}
