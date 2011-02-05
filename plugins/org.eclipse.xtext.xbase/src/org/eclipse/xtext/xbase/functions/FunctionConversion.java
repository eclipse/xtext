/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.functions;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.JvmFeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FunctionConversion {

	@Inject
	private XbaseTypeConformanceComputer conformanceComputer;

	@Inject
	private TypeArgumentContextProvider contextProvider;

	@Inject
	private TypesFactory factory = TypesFactory.eINSTANCE;

	private interface FuncDesc {
		JvmTypeReference getReturnType();

		Iterable<? extends JvmTypeReference> getParamTypes();
	}

	private static class FunctionRefFuncDef implements FuncDesc {
		private List<? extends JvmTypeReference> arguments;

		public JvmTypeReference getReturnType() {
			return arguments.get(arguments.size() - 1);
		}

		public Iterable<? extends JvmTypeReference> getParamTypes() {
			if (arguments.size() == 1) {
				return emptyList();
			} else {
				return arguments.subList(0, arguments.size() - 1);
			}
		}
	}

	private static class JvmOperationFuncDef implements FuncDesc {
		private JvmOperation delegate;

		public JvmTypeReference getReturnType() {
			return delegate.getReturnType();
		}

		public Iterable<JvmTypeReference> getParamTypes() {
			return transform(delegate.getParameters(), new Function<JvmFormalParameter, JvmTypeReference>() {
				public JvmTypeReference apply(JvmFormalParameter from) {
					return from.getParameterType();
				}
			});
		}
	}

	public boolean isConformant(JvmTypeReference left, JvmTypeReference right) {
		FuncDesc leftDesc = toFuncDesc(left);
		FuncDesc rightDesc = toFuncDesc(right);
		if (leftDesc == null || rightDesc == null)
			return false;
		TypeArgumentContext leftCtx = contextProvider.getReceiverContext(left);
		TypeArgumentContext rightCtx = contextProvider.getReceiverContext(right);
		return isConformant(leftDesc, leftCtx, rightDesc, rightCtx);
	}

	protected FuncDesc toFuncDesc(JvmTypeReference left) {
		if (isFunction(left)) {
			FunctionRefFuncDef result = new FunctionRefFuncDef();
			result.arguments = ((JvmParameterizedTypeReference) left).getArguments();
			return result;
		}
		JvmOperation operation = findSingleMethod(left);
		if (operation == null)
			return null;
		JvmOperationFuncDef result = new JvmOperationFuncDef();
		result.delegate = operation;
		return result;
	}

	protected boolean isConformant(FuncDesc left, TypeArgumentContext leftCtx, FuncDesc right,
			TypeArgumentContext rightCtx) {
		final Iterable<? extends JvmTypeReference> paramTypes = left.getParamTypes();
		Iterator<? extends JvmTypeReference> leftIter = paramTypes.iterator();
		final Iterable<? extends JvmTypeReference> paramTypes2 = right.getParamTypes();
		Iterator<? extends JvmTypeReference> rightIter = paramTypes2.iterator();
		while (leftIter.hasNext() && rightIter.hasNext()) {
			JvmTypeReference leftType = leftIter.next();
			JvmTypeReference rightType = rightIter.next();
			final JvmTypeReference convertedLeftParam = leftCtx.resolve(leftType);
			final JvmTypeReference convertedRightParam = rightCtx.resolve(rightType);
			if (!conformanceComputer.isConformant(convertedLeftParam, convertedRightParam))
				return false;
		}
		if (leftIter.hasNext() || rightIter.hasNext()) // params left?
			return false;
		return conformanceComputer.isConformant(leftCtx.resolve(left.getReturnType()),
				rightCtx.resolve(right.getReturnType()));
	}

	@Inject
	private JvmFeatureOverridesService overridesService;

	public JvmOperation findSingleMethod(JvmTypeReference type) {
		Iterable<JvmOperation> features = filter(overridesService.getAllJvmFeatures(type), JvmOperation.class);
		JvmOperation operation = null;
		for (JvmOperation op : features) {
			if (isValidFunction(op)) {
				if (operation == null)
					operation = op;
				else
					return null;
			}
		}
		return operation;
	}

	protected boolean isValidFunction(JvmOperation op) {
		if (op.getVisibility() == JvmVisibility.PUBLIC) {
			if (Object.class.getName().equals(op.getDeclaringType().getCanonicalName()))
				return false;
			final String name = op.getSimpleName();
			if (name.equals("toString") && op.getParameters().isEmpty())
				return false;
			if (name.equals("equals") && op.getParameters().size() == 1)
				return false;
			if (name.equals("hashCode") && op.getParameters().isEmpty())
				return false;
			return true;
		}
		return false;
	}

	public boolean isFunction(JvmTypeReference right) {
		return right != null && right.getCanonicalName().startsWith(Functions.class.getCanonicalName());
	}

	/**
	 * parameterizes the expected type with the type arguments from the actualType
	 */
	public JvmTypeReference getResolvedExpectedType(JvmTypeReference expectedType, JvmTypeReference actualType) {
		if (expectedType == null) {
			return actualType;
		}
		if (!(expectedType instanceof JvmParameterizedTypeReference)) {
			return actualType;
		}
		JvmGenericType expectedTypeDeclaration = (JvmGenericType) expectedType.getType();
		TypeArgumentContext context = contextProvider.getReceiverContext(actualType);
		JvmOperation from = findSingleMethod(actualType);
		JvmOperation to = findSingleMethod(expectedType);
		Map<JvmTypeParameter, JvmTypeReference> resolutions = newHashMap();
		EList<JvmTypeParameter> list = expectedTypeDeclaration.getTypeParameters();
		JvmParameterizedTypeReference resultType = factory.createJvmParameterizedTypeReference();
		resultType.setType(expectedTypeDeclaration);
		for (JvmTypeParameter jvmTypeParameter : list) {
			// put a reference into the result type
			JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
			reference.setType(jvmTypeParameter);
			resultType.getArguments().add(reference);
			// fill with default values (wildcards)
			resolutions.put(jvmTypeParameter, factory.createJvmWildcardTypeReference());
			JvmTypeReference result = findMatch(jvmTypeParameter, to.getReturnType(),
					context.resolve(from.getReturnType()));
			if (result != null)
				resolutions.put(jvmTypeParameter, result);
			final EList<JvmFormalParameter> fromParams = from.getParameters();
			final EList<JvmFormalParameter> toParams = to.getParameters();
			for (int i = 0; i < fromParams.size(); i++) {
				final JvmTypeReference toParamType = toParams.get(i).getParameterType();
				final JvmTypeReference fromParamType = fromParams.get(i).getParameterType();
				result = findMatch(jvmTypeParameter, toParamType, context.resolve(fromParamType));
				if (result != null)
					resolutions.put(jvmTypeParameter, result);
			}
		}
		TypeArgumentContext typeArgContext = contextProvider.get(resolutions);
		return typeArgContext.resolve(resultType);
	}
	
	/**
	 * finds the JvmTypeReference in information according to the position declaration refers to {@link JvmTypeParameter}.
	 * For Example:
	 * 
	 * given a method
	 *   <T> List<T> foo();
	 *   
	 *  where <T> is the passed {@link JvmTypeParameter} and 'List<T>' is the passed declaration {@link JvmTypeReference},
	 *  if another List<String> is passed as information, the method returns a {@link JvmTypeReference} pointing to 'String'.
	 */
	public JvmTypeReference findMatch(JvmTypeParameter jvmTypeParameter, JvmTypeReference declaration,
			JvmTypeReference information) {
		if (isTypeParamReference(jvmTypeParameter, declaration)) {
			return information;
		}
		if (declaration instanceof JvmParameterizedTypeReference
				&& information instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference declaration2 = (JvmParameterizedTypeReference) declaration;
			JvmParameterizedTypeReference information2 = (JvmParameterizedTypeReference) information;
			EList<JvmTypeReference> declArgs = declaration2.getArguments();
			EList<JvmTypeReference> infoArgs = information2.getArguments();
			for (int i = 0; i < declArgs.size() && i < infoArgs.size(); i++) {
				JvmTypeReference match = findMatch(jvmTypeParameter, declArgs.get(i), infoArgs.get(i));
				if (match != null)
					return match;
			}
		}
		return null;
	}
	
	private boolean isTypeParamReference(JvmTypeParameter jvmTypeParameter, JvmTypeReference declaration) {
		if (declaration.getType() == jvmTypeParameter) {
			return true;
		}
		if (declaration instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wc = (JvmWildcardTypeReference) declaration;
			EList<JvmTypeConstraint> list = wc.getConstraints();
			for (JvmTypeConstraint constraint : list) {
				if (constraint.getTypeReference().getType() == jvmTypeParameter)
					return true;
			}
		}
		return false;
	}
	
}
