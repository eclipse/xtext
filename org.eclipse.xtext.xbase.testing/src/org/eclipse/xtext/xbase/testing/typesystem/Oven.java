/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testing.typesystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
 * Utility to check a given expression for exceptions and integrity after it was
 * processed by the {@link IBatchTypeResolver}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
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
			if (file != null) {
				TreeIterator<EObject> allContents = file.eAllContents();
				while (allContents.hasNext()) {
					EObject content = allContents.next();
					if (content instanceof XAbstractFeatureCall) {
						assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
						XAbstractFeatureCall abstractFeatureCall = (XAbstractFeatureCall) content;
						if (abstractFeatureCall.getImplicitReceiver() != null) {
							assertExpressionTypeIsResolved(abstractFeatureCall.getImplicitReceiver(),
									resolvedTypes);
						}
						if (abstractFeatureCall.getImplicitFirstArgument() != null) {
							assertExpressionTypeIsResolved(abstractFeatureCall.getImplicitFirstArgument(),
									resolvedTypes);
						}
					} else if (content instanceof XClosure) {
						assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
						for (JvmFormalParameter it : ((XClosure) content).getImplicitFormalParameters()) {
							assertIdentifiableTypeIsResolved(it, resolvedTypes);
						}
					} else if (content instanceof XExpression) {
						assertExpressionTypeIsResolved(((XExpression) content), resolvedTypes);
					} else if (content instanceof JvmIdentifiableElement) {
						assertIdentifiableTypeIsResolved(((JvmIdentifiableElement) content), resolvedTypes);
					}
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
			boolean result = false;
			if (expression instanceof XAbstractFeatureCall) {
				result = ((XAbstractFeatureCall) expression).isPackageFragment() || type != null;
			} else {
				result = type != null;
			}
			Assert.assertTrue("Type is not resolved. Expression: " + expression.toString(), result);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
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
