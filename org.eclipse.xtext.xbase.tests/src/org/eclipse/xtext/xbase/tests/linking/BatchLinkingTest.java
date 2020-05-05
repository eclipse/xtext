/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BatchLinkingTest extends AbstractXbaseLinkingTest {
	@Inject
	private IBatchTypeResolver typeResolver;

	private boolean failOnUnresolvedProxy = true;

	@Before
	public void init() {
		failOnUnresolvedProxy = true;
	}

	@Override
	public XExpression expression(CharSequence string, boolean resolve) throws Exception {
		failOnUnresolvedProxy = resolve;
		XExpression result = super.expression(string, false);
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(result);
		TreeIterator<EObject> allContents = result.eAllContents();
		while (allContents.hasNext()) {
			EObject content = allContents.next();
			if (content instanceof XAbstractFeatureCall) {
				assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
				XAbstractFeatureCall abstractFeatureCall = (XAbstractFeatureCall) content;
				if (abstractFeatureCall.getImplicitReceiver() != null) {
					assertExpressionTypeIsResolved(abstractFeatureCall.getImplicitReceiver(), resolvedTypes);
				}
			} else if (content instanceof XExpression) {
				assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
			} else if (content instanceof JvmIdentifiableElement) {
				assertIdentifiableTypeIsResolved(((JvmIdentifiableElement) content), resolvedTypes);
			}
		}
		if (failOnUnresolvedProxy) {
			allContents = result.eAllContents();
			while (allContents.hasNext()) {
				EObject content = allContents.next();
				if (content instanceof XConstructorCall) {
					XConstructorCall constructorCall = (XConstructorCall) content;
					InternalEObject constructor = (InternalEObject) constructorCall
							.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
					Assert.assertNotNull(constructorCall.toString(), constructor);
					Assert.assertFalse(constructorCall.toString(), constructor.eIsProxy());
				} else if (content instanceof XAbstractFeatureCall) {
					XAbstractFeatureCall abstractFeatureCall = (XAbstractFeatureCall) content;
					InternalEObject feature = (InternalEObject) abstractFeatureCall
							.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
					Assert.assertNotNull(abstractFeatureCall.toString(), feature);
					Assert.assertFalse(abstractFeatureCall.toString(), feature.eIsProxy());
				}
			}
		}
		return result;
	}

	public void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		LightweightTypeReference type = types.getActualType(expression);
		Assert.assertNotNull(expression.toString(), type);
		Assert.assertNotNull(expression.toString() + " / " + type, type.getIdentifier());
	}

	public void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		LightweightTypeReference type = types.getActualType(identifiable);
		Assert.assertNotNull(identifiable.toString(), type);
		Assert.assertNotNull(identifiable.toString() + " / " + type, type.getIdentifier());
	}

	@Test
	@Override
	public void testMemberCallOnMultiTypeWithUnresolvableArgument_01() throws Exception {
		try {
			failOnUnresolvedProxy = false;
			super.testMemberCallOnMultiTypeWithUnresolvableArgument_01();
		} finally {
			failOnUnresolvedProxy = true;
		}
	}
}
