/**
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.junit.typesystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.CompoundReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.ComparisonFailure;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Utility to check a given expression for exceptions and integrity after it was processed by the {@link IBatchTypeResolver}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated Use org.eclipse.xtext.xbase.testing.typesystem.Oven instead
 */
@Deprecated(forRemoval = true)
@Beta
@Singleton
public class Oven extends Assert {
	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private ReflectExtensions reflectExtensions;

	@Inject
	private ParseHelper<EObject> parseHelper;

	public void fireproof(CharSequence input) throws Exception {
		fireproof(input.toString());
	}

	public void fireproof(String input) throws Exception {
		try {
			EObject file = parseHelper.parse(input);
			IResolvedTypes resolvedTypes = typeResolver.resolveTypes(file);
			Assert.assertNotNull(resolvedTypes);
			if (file == null) {
				return;
			}
			for (EObject content : IteratorExtensions.toIterable(file.eAllContents())) {
				if (content instanceof XAbstractFeatureCall) {
					assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
					XAbstractFeatureCall abstractFeatureCall = (XAbstractFeatureCall) content;
					if (abstractFeatureCall.getImplicitReceiver() != null) {
						assertExpressionTypeIsResolved(abstractFeatureCall.getImplicitReceiver(), resolvedTypes);
					}
					if (abstractFeatureCall.getImplicitFirstArgument() != null) {
						assertExpressionTypeIsResolved(abstractFeatureCall.getImplicitFirstArgument(), resolvedTypes);
					}
				} else if (content instanceof XClosure) {
					assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
					((XClosure) content).getImplicitFormalParameters()
							.forEach((JvmFormalParameter it) -> assertIdentifiableTypeIsResolved(it, resolvedTypes));
				} else if (content instanceof XExpression) {
					assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
				} else if (content instanceof JvmIdentifiableElement) {
					assertIdentifiableTypeIsResolved(((JvmIdentifiableElement) content), resolvedTypes);
				}
			}
		} catch (Throwable e) {
			ComparisonFailure error = new ComparisonFailure(e.getMessage(), input, "");
			error.setStackTrace(e.getStackTrace());
			throw error;
		}
	}

	public void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		try {
			Object internalTypes = reflectExtensions.invoke(types, "delegate");
			final TypeData type;
			if (internalTypes instanceof CompoundReentrantTypeResolver) {
				Method method = CompoundReentrantTypeResolver.class.getDeclaredMethod("getDelegate", XExpression.class);
				method.setAccessible(true);
				Object delegate = method.invoke(internalTypes, expression);
				if (delegate instanceof RootResolvedTypes) {
					type = (TypeData) reflectExtensions.invoke(delegate, "getTypeData", expression, Boolean.FALSE);
				} else {
					type = null;
				}
			} else {
				type = (TypeData) reflectExtensions.invoke(internalTypes, "getTypeData", expression, Boolean.FALSE);
			}
			boolean assertion = false;
			if (expression instanceof XAbstractFeatureCall) {
				assertion = ((XAbstractFeatureCall) expression).isPackageFragment() || type != null;
			} else {
				assertion = type != null;
			}
			Assert.assertTrue("Type is not resolved. Expression: " + expression.toString(), assertion);
		} catch (NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException
				| InvocationTargetException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	public void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		if (identifiable.getSimpleName() == null) {
			return;
		}
		LightweightTypeReference type = types.getActualType(identifiable);
		Assert.assertNotNull(identifiable.toString(), type);
		Assert.assertNotNull(identifiable.toString() + " / " + type, type.getIdentifier());
	}
}
