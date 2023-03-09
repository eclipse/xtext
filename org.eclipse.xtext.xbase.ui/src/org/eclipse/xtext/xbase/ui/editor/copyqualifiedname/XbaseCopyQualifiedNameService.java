/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.editor.copyqualifiedname;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.ui.editor.copyqualifiedname.DefaultCopyQualifiedNameService;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
public class XbaseCopyQualifiedNameService extends DefaultCopyQualifiedNameService {

	@Inject
	private OverrideHelper overrideHelper;

	@Inject
	private IBatchTypeResolver typeResolver;

	protected String toQualifiedName(JvmExecutable jvmExecutable) {
		return toFullyQualifiedName(jvmExecutable) //
				+ "(" + toQualifiedNames(jvmExecutable.getParameters(), (parameter) -> parameter.getParameterType().getSimpleName()) + ")";
	}

	protected String toQualifiedName(XExpression expression, IResolvedExecutable resolvedExecutable, JvmExecutable executable,
			IResolvedTypes resolvedTypes, List<XExpression> arguments) {
		LightweightTypeReference actualType = resolvedTypes.getActualType(expression);
		if (actualType != null && !actualType.isAny() && !actualType.isUnknown()) {
			return actualType.getHumanReadableName();
		}

		int index = arguments.indexOf(expression);
		if (resolvedExecutable == null) {
			return executable.getParameters().get(index).getParameterType().getSimpleName();
		}
		return resolvedExecutable.getResolvedParameterTypes().get(index).getSimpleName();
	}

	@Override
	public String getQualifiedName(EObject constructor, EObject constructorCall) {
		if (constructor instanceof JvmConstructor && constructorCall instanceof XConstructorCall) {
			return _getQualifiedName((JvmConstructor) constructor, (XConstructorCall) constructorCall);
		} else if (constructor instanceof JvmExecutable && constructorCall instanceof XAbstractFeatureCall) {
			return _getQualifiedName((JvmExecutable) constructor, (XAbstractFeatureCall) constructorCall);
		} else if (constructor instanceof JvmExecutable && constructorCall != null) {
			return _getQualifiedName((JvmExecutable) constructor, constructorCall);
		} else if (constructor instanceof JvmExecutable && constructorCall == null) {
			return _getQualifiedName((JvmExecutable) constructor, (Void) null);
		} else if (constructor != null && constructorCall != null) {
			return _getQualifiedName(constructor, constructorCall);
		} else if (constructor != null && constructorCall == null) {
			return _getQualifiedName(constructor, (Void) null);
		} else if (constructor == null && constructorCall != null) {
			return _getQualifiedName((Void) null, constructorCall);
		} else {
			return _getQualifiedName((Void) null, (Void) null);
		}
	}

	protected String _getQualifiedName(JvmExecutable jvmExecutable, EObject context) {
		return toQualifiedName(jvmExecutable);
	}

	protected String _getQualifiedName(JvmExecutable jvmExecutable, Void context) {
		return toQualifiedName(jvmExecutable);
	}

	protected String _getQualifiedName(JvmExecutable executable, XAbstractFeatureCall featureCall) {
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(featureCall);
		IResolvedExecutable resolvedExecutable = resolveExecutable(executable, featureCall, resolvedTypes);
		return toFullyQualifiedName(executable) //
				+ "(" + toQualifiedNames(featureCall.getActualArguments(), //
						(argument) -> toQualifiedName(argument, resolvedExecutable, executable, resolvedTypes,
								featureCall.getActualArguments()))
				+ ")";
	}

	protected String _getQualifiedName(JvmConstructor constructor, XConstructorCall constructorCall) {
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(constructorCall);
		IResolvedExecutable resolvedExecutable = resolveExecutable(constructor, constructorCall, resolvedTypes);
		return toFullyQualifiedName(constructor) //
				+ "(" + toQualifiedNames(constructorCall.getArguments(), //
						(argument) -> toQualifiedName(argument, resolvedExecutable, constructor, resolvedTypes,
								constructorCall.getArguments()))
				+ ")";
	}

	protected IResolvedExecutable resolveExecutable(JvmExecutable consturctor, XExpression expression, IResolvedTypes resolvedTypes) {
		if (consturctor instanceof JvmConstructor && expression instanceof XAbstractFeatureCall) {
			return _resolveExecutable((JvmConstructor) consturctor, (XAbstractFeatureCall) expression, resolvedTypes);
		} else if (consturctor instanceof JvmConstructor && expression instanceof XConstructorCall) {
			return _resolveExecutable((JvmConstructor) consturctor, (XConstructorCall) expression, resolvedTypes);
		} else if (consturctor instanceof JvmOperation && expression instanceof XAbstractFeatureCall) {
			return _resolveExecutable((JvmOperation) consturctor, (XAbstractFeatureCall) expression, resolvedTypes);
		} else {
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.asList(consturctor, expression, resolvedTypes).toString());
		}
	}

	private IResolvedExecutable findDeclaredConstructor(JvmConstructor constructor, LightweightTypeReference actualType) {
		ResolvedFeatures resolvedFeatures = overrideHelper.getResolvedFeatures(actualType);
		for (IResolvedConstructor declaredConstructor : resolvedFeatures.getDeclaredConstructors()) {
			if (declaredConstructor.getDeclaration().equals(constructor)) {
				return declaredConstructor;
			}
		}
		return null;
	}

	protected IResolvedExecutable _resolveExecutable(JvmConstructor constructor, XAbstractFeatureCall featureCall,
			IResolvedTypes resolvedTypes) {
		XExpression actualReceiver = featureCall.getActualReceiver();
		if (actualReceiver != null) {
			LightweightTypeReference actualType = resolvedTypes.getActualType(actualReceiver);
			return findDeclaredConstructor(constructor, actualType);
		}
		return null;
	}

	protected IResolvedExecutable _resolveExecutable(JvmConstructor constructor, XConstructorCall constructorCall,
			IResolvedTypes resolvedTypes) {
		LightweightTypeReference actualType = resolvedTypes.getActualType(constructorCall);
		if (actualType != null) {
			return findDeclaredConstructor(constructor, actualType);
		}
		return null;
	}

	protected IResolvedExecutable _resolveExecutable(JvmOperation operation, XAbstractFeatureCall featureCall,
			IResolvedTypes resolvedTypes) {
		XExpression actualReceiver = featureCall.getActualReceiver();
		if (actualReceiver != null) {
			LightweightTypeReference actualType = resolvedTypes.getActualType(actualReceiver);
			ResolvedFeatures resolvedFeatures = overrideHelper.getResolvedFeatures(actualType);
			for (IResolvedOperation resolvedOperation : resolvedFeatures.getAllOperations()) {
				if (resolvedOperation.getDeclaration().equals(operation)) {
					return resolvedOperation;
				}
			}
		}
		return null;
	}

}
