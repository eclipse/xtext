/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
public abstract class AbstractBatchTypeResolverTest extends AbstractTypeResolverTest<LightweightTypeReference> {
	@Override
	public LightweightTypeReference resolvesTo(String expression, String type) {
		try {
			XExpression xExpression = expression(expression, false);
			Assert.assertTrue(xExpression.eResource().getErrors().toString(), xExpression.eResource().getErrors().isEmpty());
			Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
			IResolvedTypes resolvedTypes = getTypeResolver().resolveTypes(xExpression);
			LightweightTypeReference resolvedType = resolvedTypes.getActualType(xExpression);
			Assert.assertEquals(type, resolvedType.getSimpleName());
			TreeIterator<EObject> allContents = xExpression.eAllContents();
			while (allContents.hasNext()) {
				EObject content = allContents.next();
				if (content instanceof XAbstractFeatureCall) {
					assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
					if (((XAbstractFeatureCall) content).getImplicitReceiver() != null) {
						assertExpressionTypeIsResolved(((XAbstractFeatureCall) content).getImplicitReceiver(), resolvedTypes);
					}
				} else if (content instanceof XExpression) {
					assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
				} else if (content instanceof JvmIdentifiableElement) {
					assertIdentifiableTypeIsResolved(((JvmIdentifiableElement) content), resolvedTypes);
				}
			}
			allContents = xExpression.eAllContents();
			while (allContents.hasNext()) {
				EObject content = allContents.next();
				if (content instanceof XConstructorCall) {
					InternalEObject constructor = (InternalEObject) ((XConstructorCall) content)
							.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
					Assert.assertNotNull(((XConstructorCall) content).toString(), constructor);
					Assert.assertFalse(((XConstructorCall) content).toString(), constructor.eIsProxy());
				} else if (content instanceof XAbstractFeatureCall) {
					InternalEObject feature = (InternalEObject) ((XAbstractFeatureCall) content)
							.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
					Assert.assertNotNull(((XAbstractFeatureCall) content).toString(), feature);
					Assert.assertFalse(((XAbstractFeatureCall) content).toString(), feature.eIsProxy());
					if (((XAbstractFeatureCall) content).getImplicitReceiver() != null) {
						InternalEObject implicitFeature = (InternalEObject) ((XAbstractFeatureCall) content).getImplicitReceiver()
								.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
						Assert.assertNotNull(implicitFeature.toString(), feature);
						Assert.assertFalse(implicitFeature.toString(), feature.eIsProxy());
					}
				}
			}
			Assert.assertTrue(getLinkingAndSyntaxErrors(xExpression.eResource()).toString(),
					Iterables.isEmpty(getLinkingAndSyntaxErrors(xExpression.eResource())));
			Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
			return resolvedType;
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Override
	public void isFunctionAndEquivalentTo(LightweightTypeReference reference, String type) {
		Assert.assertTrue(reference instanceof FunctionTypeReference);
		Assert.assertEquals(type, getEquivalent((FunctionTypeReference) reference));
	}

	public String getEquivalent(ParameterizedTypeReference type) {
		return type.getType().getSimpleName() + IterableExtensions.join(type.getTypeArguments(), "<", ", ", ">", it -> it.getSimpleName());
	}

	public void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		LightweightTypeReference type = types.getActualType(expression);
		Assert.assertNotNull("Type is not resolved. Expression: " + expression.toString(), type);
		Assert.assertNotNull(expression.toString() + " / " + type, type.getIdentifier());
		LightweightTypeReference expectedType = types.getExpectedType(expression);
		Assert.assertNotNull(expression.toString(), String.valueOf(expectedType));
	}

	public void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		LightweightTypeReference type = types.getActualType(identifiable);
		Assert.assertNotNull(identifiable.toString(), type);
		Assert.assertNotNull(identifiable.toString() + " / " + type, type.getIdentifier());
	}

	public abstract IBatchTypeResolver getTypeResolver();

	@Test
	public void testNull() throws Exception {
		IResolvedTypes typeResolution = getTypeResolver().resolveTypes(((EObject) null));
		Assert.assertNotNull(typeResolution);
		Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
	}

	@Test
	public void testProxy() throws Exception {
		XFeatureCall proxy = XbaseFactory.eINSTANCE.createXFeatureCall();
		((InternalEObject) proxy).eSetProxyURI(URI.createURI("path#fragment"));
		IResolvedTypes typeResolution = getTypeResolver().resolveTypes(proxy);
		Assert.assertNotNull(typeResolution);
		Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
	}
}
