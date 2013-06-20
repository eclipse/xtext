/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.IRawTypeHelper;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Deprecated
@Singleton
public class Closures {

	@Inject
	private XtypeFactory xtypeFactory = XtypeFactory.eINSTANCE;
	
	@Inject
	private TypesFactory typesFactory = TypesFactory.eINSTANCE;
	
	@Inject
	private TypeReferences typeRefs;

	@Inject
	private IRawTypeHelper rawTypeHelper;
	
	@Inject
	private XbaseTypeArgumentContextProvider typeArgumentContextProvider;

	/**
	 * @return a compatible function type reference or <code>null</code>.
	 */
	public JvmTypeReference getCompatibleFunctionType(JvmTypeReference original, final boolean instanceContext, final boolean rawType) {
		if (original == null)
			return null;
		JvmTypeReference result = new AbstractTypeReferenceVisitor.InheritanceAware<JvmTypeReference>() {
			@Override
			public JvmTypeReference doVisitTypeReference(JvmTypeReference reference) {
				return null;
			}
			@Override
			protected JvmTypeReference handleNullReference() {
				return null;
			}
			@Override
			public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
				JvmType type = reference.getType();
				if (type instanceof JvmGenericType && !type.eIsProxy() && ((JvmGenericType)type).isInterface()) {
					JvmOperation operation = findImplementingOperation(reference, type.eResource());
					if (operation != null) {
						JvmTypeReference result = null;
						boolean procedure = typeRefs.is(operation.getReturnType(), Void.TYPE);
						if (rawType) {
							result = createRawFunctionTypeRef(operation, operation.getParameters().size(), procedure);
						} else {
							if (type instanceof JvmTypeParameterDeclarator) {
								if (!((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty() && reference.getArguments().isEmpty())
									return createRawFunctionTypeRef(operation, operation.getParameters().size(), procedure); 
							}
							final ITypeArgumentContext argumentContext = typeArgumentContextProvider.getTypeArgumentContext(
									new TypeArgumentContextProvider.ReceiverRequest(reference));
							List<JvmTypeReference> parameterTypes = Lists.transform(operation.getParameters(), new Function<JvmFormalParameter, JvmTypeReference>() {
								public JvmTypeReference apply(JvmFormalParameter from) {
									if (from != null) {
										JvmTypeReference result = argumentContext.getLowerBound(from.getParameterType());
										return result;
									}
									return null;
								}
							});
							JvmTypeReference returnType = argumentContext.getUpperBound(operation.getReturnType(), operation);
							result = createFunctionTypeRef(type, parameterTypes, returnType, instanceContext);
						}
						return result;
					}
				}
				return null;
			}
			
			@Override
			public JvmTypeReference doVisitDelegateTypeReference(JvmDelegateTypeReference reference) {
				JvmTypeReference result = super.doVisitDelegateTypeReference(reference);
				if (result != reference.getDelegate()) {
					return result;
				}
				return reference;
			}
			
			@Override
			public JvmTypeReference doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
				JvmCompoundTypeReference result = null;
				List<JvmTypeReference> components = reference.getReferences();
				int recent = -1;
				boolean wasEquivalent = false;
				for(int i = 0; i < components.size(); i++) {
					JvmTypeReference component = components.get(i);
					JvmTypeReference equivalent = getCompatibleFunctionType(component, instanceContext, rawType);
					wasEquivalent |= equivalent != null;
					if (equivalent != null && component != equivalent) {
						if (result == null) {
							result = (JvmCompoundTypeReference) EcoreUtil.create(reference.eClass());
						}
						for(int j = recent + 1; j < i; j++) {
							JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
							delegate.setDelegate(components.get(j));
							result.getReferences().add(delegate);
						}
						result.getReferences().add(equivalent);
						recent = i;
					}
				}
				if (wasEquivalent) {
					if (result != null)
						return result;
					return reference;
				}
				return null;
			}
			
			@Override
			public JvmTypeReference doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference) {
				if (reference instanceof XFunctionTypeRef) {
					return reference;
				}
				JvmTypeReference result = super.doVisitSpecializedTypeReference(reference);
				if (result != reference.getEquivalent()) {
					return result;
				}
				return reference;
			}
		}.visit(original);
		return result;
	}
	
	public JvmOperation findImplementingOperation(JvmTypeReference closureType, Resource resource) {
		List<JvmType> rawTypes = rawTypeHelper.getAllRawTypes(closureType, resource);
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

	public JvmParameterizedTypeReference createRawFunctionTypeRef(EObject context, int parameterCount, boolean procedure) {
		JvmParameterizedTypeReference result = typesFactory.createJvmParameterizedTypeReference();
		String simpleClassName = (procedure ? "Procedure" : "Function") + Math.min(6, parameterCount);
		final Class<?> loadFunctionClass = loadFunctionClass(simpleClassName, procedure);
		JvmType declaredType = typeRefs.findDeclaredType(loadFunctionClass, context);
		if (declaredType == null)
			return null;
		result.setType(declaredType);
		return result;
	}
	
	public JvmTypeReference createFunctionTypeRef(
			EObject context, 
			List<JvmTypeReference> parameterTypes,
			JvmTypeReference returnType,
			boolean instanceContext) {
		XFunctionTypeRef result = xtypeFactory.createXFunctionTypeRef();
		result.setInstanceContext(instanceContext);
		for(JvmTypeReference parameterType: parameterTypes) {
			if (parameterType != null && parameterType.eContainer() == null) {
				result.getParamTypes().add(parameterType);
			} else {
				JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
				delegate.setDelegate(parameterType);
				result.getParamTypes().add(delegate);
			}
		}
		if (returnType != null && returnType.eContainer() == null) {
			result.setReturnType(returnType);
		} else {
			JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
			delegate.setDelegate(returnType);
			result.setReturnType(delegate);
		}
		JvmType type = result.getType();
		JvmType resolved = (JvmType) EcoreUtil.resolve(type, context);
		if (type != resolved) {
			result.setType(resolved);
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
