/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider.ResolveInfo;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.Functions;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
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
	
	@Inject
	private TypeReferences typeRefs;

	@Inject
	private Primitives primitives;

	private interface FuncDesc {
		JvmTypeReference getReturnType();

		List<? extends JvmTypeReference> getParameterTypes();
		
		int getArgumentSize();
	}

	private static class FunctionRefFuncDef implements FuncDesc {
		private List<? extends JvmTypeReference> arguments;
		public int argumentSize = -1;

		public JvmTypeReference getReturnType() {
			return arguments.get(arguments.size() - 1);
		}
		
		public List<? extends JvmTypeReference> getParameterTypes() {
			if (arguments == null || arguments.size() <= 1) {
				return emptyList();
			} else {
				return arguments.subList(0, arguments.size() - 1);
			}
		}
		
		public int getArgumentSize() {
			if (argumentSize != -1)
				return argumentSize;
			return getParameterTypes().size();
		}
		
		@Override
		public String toString() {
			if (argumentSize != -1) {
				return "FunctionRef: [" + argumentSize + "]"; 
			}
			return "FunctionRef: " + arguments;
		}
	}

	private static class JvmOperationFuncDef implements FuncDesc {
		private JvmOperation delegate;

		public JvmTypeReference getReturnType() {
			return delegate.getReturnType();
		}

		public List<JvmTypeReference> getParameterTypes() {
			return Lists.transform(delegate.getParameters(), new Function<JvmFormalParameter, JvmTypeReference>() {
				public JvmTypeReference apply(JvmFormalParameter from) {
					return from.getParameterType();
				}
			});
		}
		
		public int getArgumentSize() {
			return delegate.getParameters().size();
		}
		
		@Override
		public String toString() {
			return "OperationRef: " + delegate.getIdentifier();
		}
	}

	public boolean isConformant(JvmTypeReference left, JvmTypeReference right, boolean ignoreGenerics) {
		FuncDesc leftDesc = toFuncDesc(left);
		FuncDesc rightDesc = toFuncDesc(right);
		if (leftDesc == null || rightDesc == null)
			return false;
		if (ignoreGenerics) {
			return leftDesc.getArgumentSize() == rightDesc.getArgumentSize();
		}
		TypeArgumentContext leftCtx = contextProvider.getReceiverContext(left);
		TypeArgumentContext rightCtx = contextProvider.getReceiverContext(right);
		boolean result = isConformant(leftDesc, leftCtx, rightDesc, rightCtx);
		return result;
	}

	protected FuncDesc toFuncDesc(JvmTypeReference typeReference) {
		if (isFunction(typeReference)) {
			FunctionRefFuncDef result = new FunctionRefFuncDef();
			JvmParameterizedTypeReference parameterizedTypeRef = (JvmParameterizedTypeReference) typeReference;
			if (parameterizedTypeRef.getArguments().isEmpty()) {
				// TODO: find a better way to decide whether the return type is a parameter
				// see trailing -1
				result.argumentSize = ((JvmTypeParameterDeclarator) parameterizedTypeRef.getType()).getTypeParameters().size() - 1;
			} else {
				result.arguments = ((JvmParameterizedTypeReference) typeReference).getArguments();
			}
			return result;
		}
		JvmOperation operation = findSingleMethod(typeReference);
		if (operation == null)
			return null;
		JvmOperationFuncDef result = new JvmOperationFuncDef();
		result.delegate = operation;
		return result;
	}

	protected boolean isConformant(FuncDesc left, TypeArgumentContext leftCtx, FuncDesc right,
			TypeArgumentContext rightCtx) {
		final Iterable<? extends JvmTypeReference> paramTypes = left.getParameterTypes();
		Iterator<? extends JvmTypeReference> leftIter = paramTypes.iterator();
		final Iterable<? extends JvmTypeReference> paramTypes2 = right.getParameterTypes();
		Iterator<? extends JvmTypeReference> rightIter = paramTypes2.iterator();
		while (leftIter.hasNext() && rightIter.hasNext()) {
			JvmTypeReference leftType = leftIter.next();
			JvmTypeReference rightType = rightIter.next();
			JvmTypeReference convertedLeftParam = leftCtx.resolve(leftType);
			// we don't expect something specific - allow anything
			if (!(convertedLeftParam instanceof JvmAnyTypeReference)) {
				JvmTypeReference convertedRightParam = rightCtx.resolve(rightType);
				if (!conformanceComputer.isConformant(convertedLeftParam, convertedRightParam))
					return false;
			}
		}
		if (leftIter.hasNext() || rightIter.hasNext()) // params left?
			return false;
		JvmTypeReference leftResult = leftCtx.resolve(left.getReturnType());
		JvmTypeReference rightResult = rightCtx.resolve(right.getReturnType());
		return conformanceComputer.isConformant(leftResult, rightResult);
	}

	@Inject
	private FeatureOverridesService overridesService;

	public JvmOperation findSingleMethod(JvmTypeReference type) {
		if (primitives.isPrimitive(type))
			return null;
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
			if (Object.class.getName().equals(op.getDeclaringType().getIdentifier()))
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

	public boolean isFunction(JvmTypeReference type) {
		if (type instanceof JvmAnyTypeReference)
			return false;
		if (type instanceof JvmMultiTypeReference) {
			for(JvmTypeReference reference: ((JvmMultiTypeReference) type).getReferences()) {
				if (!isFunction(reference))
					return false;
			}
			return true;
		}
		return type != null && type.getType()!=null && !type.getType().eIsProxy() && type.getType().getIdentifier().startsWith(Functions.class.getCanonicalName());
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
		Map<JvmTypeParameter, ResolveInfo> resolutions = newHashMap();
		EList<JvmTypeParameter> list = expectedTypeDeclaration.getTypeParameters();
		JvmParameterizedTypeReference resultType = factory.createJvmParameterizedTypeReference();
		resultType.setType(expectedTypeDeclaration);
		for (JvmTypeParameter jvmTypeParameter : list) {
			// put a reference into the result type
			JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
			reference.setType(jvmTypeParameter);
			resultType.getArguments().add(reference);
			// fill with default values (wildcards)
			resolutions.put(jvmTypeParameter, new ResolveInfo(factory.createJvmWildcardTypeReference()));
			JvmTypeReference result = findMatch(jvmTypeParameter, to.getReturnType(),
					context.resolve(from.getReturnType()));
			if (result != null)
				resolutions.put(jvmTypeParameter, new ResolveInfo(result));
			final EList<JvmFormalParameter> fromParams = from.getParameters();
			final EList<JvmFormalParameter> toParams = to.getParameters();
			for (int i = 0; i < fromParams.size(); i++) {
				final JvmTypeReference toParamType = toParams.get(i).getParameterType();
				final JvmTypeReference fromParamType = fromParams.get(i).getParameterType();
				result = findMatch(jvmTypeParameter, toParamType, context.resolve(fromParamType));
				if (result != null)
					resolutions.put(jvmTypeParameter, new ResolveInfo(result));
			}
		}
		TypeArgumentContext typeArgContext = contextProvider.get(resolutions);
		return typeArgContext.resolve(resultType);
	}
	
	public JvmTypeReference getReturnType(JvmTypeReference functionType) {
		JvmOperation operation = findSingleMethod(functionType);
		if (operation == null)
			return null;
		TypeArgumentContext context = contextProvider.getReceiverContext(functionType);
		JvmTypeReference result = context.getUpperBound(operation.getReturnType(), operation);
		return result;
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
	
	public JvmParameterizedTypeReference createRawFunctionTypeRef(EObject context, int parameterCount) {
		JvmParameterizedTypeReference ref = factory.createJvmParameterizedTypeReference();
		final Class<?> loadFunctionClass = loadFunctionClass("Function" + (parameterCount>6?6:parameterCount));
		JvmGenericType declaredType = (JvmGenericType) typeRefs.findDeclaredType(loadFunctionClass, context);
		ref.setType(declaredType);
		return ref;
	}
	
	public JvmParameterizedTypeReference createFunctionTypeRef(EObject context, List<JvmTypeReference> parameterTypes,
			JvmTypeReference returnType) {
		JvmParameterizedTypeReference result = createRawFunctionTypeRef(context, parameterTypes.size());
		JvmGenericType functionType = (JvmGenericType) result.getType();
		if (functionType==null)
			return result;
		for (int i = 0; i < parameterTypes.size(); i++) {
			JvmTypeReference parameterType = parameterTypes.get(i);
			if (parameterType == null) {
				JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
				JvmTypeParameter typeParameter = functionType.getTypeParameters().get(i);
				reference.setType(typeParameter);
				result.getArguments().add(reference);
			} else {
				parameterType = primitives.asWrapperTypeIfPrimitive(parameterType);
				result.getArguments().add(EcoreUtil2.cloneIfContained(parameterType));
			}
		}
		if (returnType != null) {
			returnType = primitives.asWrapperTypeIfPrimitive(returnType);
			if (returnType != null && returnType.getType() instanceof JvmVoid && !returnType.getType().eIsProxy()) {
				returnType = typeRefs.getTypeForName(Void.class, context);
			}
			result.getArguments().add(EcoreUtil2.cloneIfContained(returnType));
		} else {
			JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
			JvmTypeParameter typeParameter = getLast(functionType.getTypeParameters());
			reference.setType(typeParameter);
			result.getArguments().add(reference);
		}
		return result;
	}
	
	protected Class<?> loadFunctionClass(String simpleFunctionName) {
		try {
			return Functions.class.getClassLoader().loadClass(
					Functions.class.getCanonicalName() + "$" + simpleFunctionName);
		} catch (ClassNotFoundException e) {
			throw new WrappedException(e);
		}
	}

}
