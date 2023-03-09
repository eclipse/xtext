/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow
 */
public abstract class AbstractBatchReturnTypeTest extends AbstractReturnTypeTest<LightweightTypeReference> {
	@Override
	public LightweightTypeReference resolvesTo(String expression, String type) throws Exception {
		String replacedExpressionText = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
		XExpression xExpression = expression(replacedExpressionText, false);
		Assert.assertTrue(xExpression.eResource().getErrors().toString(), xExpression.eResource().getErrors().isEmpty());
		Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
		IResolvedTypes resolvedTypes = getTypeResolver().resolveTypes(xExpression);
		LightweightTypeReference resolvedType = resolvedTypes.getReturnType(xExpression);
		Assert.assertEquals(replacedExpressionText, type, resolvedType.getSimpleName());
		Assert.assertTrue(getLinkingAndSyntaxErrors(xExpression.eResource()).toString(),
				Iterables.isEmpty(getLinkingAndSyntaxErrors(xExpression.eResource())));
		Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
		return resolvedType;
	}

	public void doResolvesTo(String expression, String type) throws Exception {
		XExpression parsedExpression = expression(expression, false);
		IResolvedTypes resolvedTypes = getTypeResolver().resolveTypes(parsedExpression);
		LightweightTypeReference resolvedType = resolvedTypes.getReturnType(parsedExpression);
		Assert.assertEquals(expression, type, resolvedType.getSimpleName());
	}

	public boolean hasReturnExpression(XExpression expression) {
		if (expression instanceof XReturnExpression) {
			return true;
		} else if (expression instanceof XThrowExpression) {
			return true;
		} else if (expression instanceof XClosure) {
			return false;
		} else {
			return Iterables.any(expression.eContents(), (EObject content) -> {
				if (content instanceof XExpression) {
					return hasReturnExpression((XExpression) content);
				} else {
					return false;
				}
			});
		}
	}

	@Override
	public void isFunctionAndEquivalentTo(LightweightTypeReference reference, String type) {
		Assert.assertTrue((reference instanceof FunctionTypeReference));
		Assert.assertEquals(type, this.getEquivalent(((FunctionTypeReference) reference)));
	}

	public String getEquivalent(ParameterizedTypeReference type) {
		StringBuilder builder = new StringBuilder();
		builder.append(type.getType().getSimpleName());
		builder.append(IterableExtensions.join(type.getTypeArguments(), "<", ", ", ">", LightweightTypeReference::getSimpleName));
		return builder.toString();
	}

	public void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		LightweightTypeReference type = types.getActualType(expression);
		Assert.assertNotNull("Type is not resolved. Expression: " + expression.toString(), type);
		Assert.assertNotNull(expression.toString() + " / " + type, type.getIdentifier());
	}

	public void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		LightweightTypeReference type = types.getActualType(identifiable);
		Assert.assertNotNull(identifiable.toString(), type);
		Assert.assertNotNull(identifiable.toString() + " / " + type, type.getIdentifier());
	}

	public abstract IBatchTypeResolver getTypeResolver();

	@Test
	public void testNull() throws Exception {
		IResolvedTypes typeResolution = this.getTypeResolver().resolveTypes(((EObject) null));
		Assert.assertNotNull(typeResolution);
		Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
	}

	@Test
	public void testProxy() throws Exception {
		XFeatureCall proxy = XbaseFactory.eINSTANCE.createXFeatureCall();
		((InternalEObject) proxy).eSetProxyURI(URI.createURI("path#fragment"));
		IResolvedTypes typeResolution = this.getTypeResolver().resolveTypes(proxy);
		Assert.assertNotNull(typeResolution);
		Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
	}
}
