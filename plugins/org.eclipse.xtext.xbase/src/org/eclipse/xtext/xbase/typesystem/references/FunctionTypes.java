/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
public class FunctionTypes {
	
	@Inject
	private TypeReferences typeReferences;

//	/**
//	 * @return a compatible function type reference or <code>null</code>.
//	 */
//	public LightweightTypeReference getCompatibleFunctionType(LightweightTypeReference original) {
//		if (original == null)
//			return null;
//		LightweightTypeReference result = new AbstractTypeReferenceVisitor.InheritanceAware<LightweightTypeReference>() {
//			@Override
//			public LightweightTypeReference doVisitTypeReference(LightweightTypeReference reference) {
//				return null;
//			}
//			@Override
//			protected LightweightTypeReference handleNullReference() {
//				return null;
//			}
//			@Override
//			public LightweightTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
//				JvmType type = reference.getType();
//				if (type instanceof JvmGenericType && !type.eIsProxy() && ((JvmGenericType)type).isInterface()) {
//					JvmOperation operation = findImplementingOperation(reference, type.eResource());
//					if (operation != null) {
//						LightweightTypeReference result = null;
//						boolean procedure = typeRefs.is(operation.getReturnType(), Void.TYPE);
//						if (rawType) {
//							result = createRawFunctionTypeRef(operation, operation.getParameters().size(), procedure);
//						} else {
//							if (type instanceof JvmTypeParameterDeclarator) {
//								if (!((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty() && reference.getArguments().isEmpty())
//									return createRawFunctionTypeRef(operation, operation.getParameters().size(), procedure); 
//							}
//							final ITypeArgumentContext argumentContext = typeArgumentContextProvider.getTypeArgumentContext(
//									new TypeArgumentContextProvider.ReceiverRequest(reference));
//							List<LightweightTypeReference> parameterTypes = Lists.transform(operation.getParameters(), new Function<JvmFormalParameter, LightweightTypeReference>() {
//								public LightweightTypeReference apply(JvmFormalParameter from) {
//									if (from != null) {
//										LightweightTypeReference result = argumentContext.getLowerBound(from.getParameterType());
//										return result;
//									}
//									return null;
//								}
//							});
//							LightweightTypeReference returnType = argumentContext.getUpperBound(operation.getReturnType(), operation);
//							result = createFunctionTypeRef(type, parameterTypes, returnType, instanceContext);
//						}
//						return result;
//					}
//				}
//				return null;
//			}
//			
//			@Override
//			public LightweightTypeReference doVisitDelegateTypeReference(JvmDelegateTypeReference reference) {
//				LightweightTypeReference result = super.doVisitDelegateTypeReference(reference);
//				if (result != reference.getDelegate()) {
//					return result;
//				}
//				return reference;
//			}
//			
//			@Override
//			public LightweightTypeReference doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
//				JvmCompoundTypeReference result = null;
//				List<LightweightTypeReference> components = reference.getReferences();
//				int recent = -1;
//				boolean wasEquivalent = false;
//				for(int i = 0; i < components.size(); i++) {
//					LightweightTypeReference component = components.get(i);
//					LightweightTypeReference equivalent = getCompatibleFunctionType(component, instanceContext, rawType);
//					wasEquivalent |= equivalent != null;
//					if (equivalent != null && component != equivalent) {
//						if (result == null) {
//							result = (JvmCompoundTypeReference) EcoreUtil.create(reference.eClass());
//						}
//						for(int j = recent + 1; j < i; j++) {
//							JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
//							delegate.setDelegate(components.get(j));
//							result.getReferences().add(delegate);
//						}
//						result.getReferences().add(equivalent);
//						recent = i;
//					}
//				}
//				if (wasEquivalent) {
//					if (result != null)
//						return result;
//					return reference;
//				}
//				return null;
//			}
//			
//			@Override
//			public LightweightTypeReference doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference) {
//				if (reference instanceof XFunctionTypeRef) {
//					return reference;
//				}
//				LightweightTypeReference result = super.doVisitSpecializedTypeReference(reference);
//				if (result != reference.getEquivalent()) {
//					return result;
//				}
//				return reference;
//			}
//		}.visit(original);
//		return result;
//	}
	
	public JvmOperation findImplementingOperation(LightweightTypeReference closureType) {
		List<JvmType> rawTypes = closureType.getRawTypes();
		for(JvmType rawType: rawTypes) {
			if (rawType instanceof JvmDeclaredType) {
				Iterable<JvmOperation> features = filter(((JvmDeclaredType)rawType).getAllFeatures(), JvmOperation.class);
				JvmOperation result = null;
				for (JvmOperation op : features) {
					if (isValidFunction(op)) {
						if (result == null)
							result = op;
						else {
							result = null;
							break;
						}
					}
				}
				if (result != null)
					return result;
			}
		}
		return null;
	}

	private boolean isValidFunction(JvmOperation op) {
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

	public FunctionTypeReference createRawFunctionTypeRef(TypeReferenceOwner owner, EObject context, int parameterCount, boolean procedure) {
		String simpleClassName = (procedure ? "Procedure" : "Function") + Math.min(6, parameterCount);
		final Class<?> loadFunctionClass = loadFunctionClass(simpleClassName, procedure);
		JvmType declaredType = typeReferences.findDeclaredType(loadFunctionClass, context);
		if (declaredType == null)
			return null;
		return new FunctionTypeReference(owner, declaredType);
	}
	
	public LightweightTypeReference createFunctionTypeRef(
			TypeReferenceOwner owner,
			LightweightTypeReference closureType, 
			List<LightweightTypeReference> parameterTypes,
			LightweightTypeReference returnType) {
		JvmType type = closureType.getType();
		if (type == null)
			throw new IllegalArgumentException("type may not be null");
		FunctionTypeReference result = new FunctionTypeReference(owner, type);
		if (closureType instanceof ParameterizedTypeReference) {
			for(LightweightTypeReference typeArgument: ((ParameterizedTypeReference) closureType).getTypeArguments()) {
				result.addTypeArgument(typeArgument.copyInto(owner));
			}
		}
		for(LightweightTypeReference parameterType: parameterTypes) {
			result.addParameterType(parameterType.copyInto(owner));
		}
		if (returnType != null) {
			result.setReturnType(returnType.copyInto(owner));
		}
		return result;
	}
	
	private Class<?> loadFunctionClass(String simpleFunctionName, boolean procedure) {
		try {
			if (!procedure) {
				return Functions.class.getClassLoader().loadClass(
						Functions.class.getCanonicalName() + "$" + simpleFunctionName);
			} else {
				return Procedures.class.getClassLoader().loadClass(
						Procedures.class.getCanonicalName() + "$" + simpleFunctionName);
			}
		} catch (ClassNotFoundException e) {
			throw new WrappedException(e);
		}
	}

}
