/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.resource;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.resource.XbaseResource;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;
import org.eclipse.xtext.xtend2.dispatch.DispatchingSupport;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.typing.XtendOverridesService;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2Resource extends XbaseResource {

	public static final String FRAGMENT_PREFIX = "§lazyType$";
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private IXtend2JvmAssociations associations;
	
	@Inject
	private XbaseTypeConformanceComputer typeConformanceComputer;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private DispatchingSupport dispatchingSupport;
	
	@Inject
	private XtendOverridesService overridesService;
	
	private Set<String> computingFragments = newLinkedHashSet();

	@Override
	public synchronized EObject getEObject(String uriFragment) {
		if (!uriFragment.startsWith(FRAGMENT_PREFIX)) 
			return super.getEObject(uriFragment);
		if (!computingFragments.add(uriFragment)) 
			return null;
		try {
			final String fragmentToJvmOperation = uriFragment.substring(FRAGMENT_PREFIX.length());
			final EObject eObject = super.getEObject(fragmentToJvmOperation);
			if (eObject instanceof JvmOperation) {
				JvmOperation op  = (JvmOperation) eObject;
				JvmTypeReference typeReference = inferReturnType(op);
				if (typeReference==null || typeReference.getType() == null)
					return typeReferences.getTypeForName(Object.class, getContents().get(0));
				if (typeReference.eContainer()!=null && typeReference.eContainer()!=op) {
					typeReference = EcoreUtil2.cloneWithProxies(typeReference);
				}
				return typeReference;
			} else if (eObject instanceof JvmFormalParameter) {
				JvmFormalParameter param = (JvmFormalParameter) eObject;
				JvmOperation op = (JvmOperation) param.eContainer();
				Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods = dispatchingSupport.getDispatchMethods((JvmGenericType) op.getDeclaringType());
				Collection<JvmOperation> dispatchOperations = dispatchMethods.get(Tuples.pair(op.getSimpleName(), op.getParameters().size()));
				final int index = op.getParameters().indexOf(param);
				JvmTypeReference commonType = commonType(dispatchOperations, new Function<JvmOperation, JvmTypeReference>() {
					public JvmTypeReference apply(JvmOperation from) {
						return from.getParameters().get(index).getParameterType();
					}
				});
				if (commonType != null && commonType.eContainer()!=null) {
					commonType = EcoreUtil2.cloneWithProxies(commonType);
				}
				return commonType;
			} else {
				throw new IllegalStateException("couldn't resolve type proxy in "+eObject);
			}
		} finally {
			computingFragments.remove(uriFragment);
		}
	}
	
	protected JvmTypeReference inferReturnType(JvmOperation jvmOperation) {
		List<JvmTypeReference> associatedReturnTypes = newArrayList();
		final Iterable<XtendFunction> associatedElements = filter(associations.getSourceElements(jvmOperation), XtendFunction.class);
		boolean wasDispatch = false;
		for (XtendFunction func : associatedElements) {
			JvmTypeReference type = typeProvider.getTypeForIdentifiable(func);
			if (type != null && !(type instanceof JvmAnyTypeReference))
				associatedReturnTypes.add(type);
			wasDispatch |= func.isDispatch();
		}
		if (wasDispatch) {
			if (jvmOperation.getSimpleName().startsWith("_")) {
				for(XtendFunction func: associatedElements) {
					if (func.getReturnType() != null) {
						return EcoreUtil2.cloneWithProxies(func.getReturnType());	
					}
					JvmOperation overriddenOperation = overridesService.findOverriddenOperation(jvmOperation);
					if (overriddenOperation != null) {
						JvmTypeReference result = overriddenOperation.getReturnType();
						return EcoreUtil2.cloneWithProxies(result);
					}
					JvmOperation dispatchOperation = associations.getDispatchOperation(func);
					JvmTypeReference result = dispatchOperation.getReturnType();
					return EcoreUtil2.cloneWithProxies(result);
				}
			} else {
				JvmOperation overriddenOperation = overridesService.findOverriddenOperation(jvmOperation);
				if (overriddenOperation != null) {
					JvmTypeReference result = overriddenOperation.getReturnType();
					return EcoreUtil2.cloneWithProxies(result);
				}
			}
		}
		if (!associatedReturnTypes.isEmpty()) {
			JvmTypeReference commonSuperType = typeConformanceComputer.getCommonSuperType(associatedReturnTypes);
			return commonSuperType;
		}
		return null;
	}
	
	protected <T> JvmTypeReference commonType(Iterable<? extends T> iterable, Function<T, JvmTypeReference> mapping) {
		List<JvmTypeReference> references = newArrayList();
		for (T element : iterable) {
			JvmTypeReference apply = mapping.apply(element);
			if (!typeReferences.isNullOrProxy(apply)) {
				apply = primitives.asWrapperTypeIfPrimitive(apply); 
				references.add(apply);
			}
		}
		JvmTypeReference result = typeConformanceComputer.getCommonSuperType(references);
		while(result instanceof JvmMultiTypeReference) {
			result = typeConformanceComputer.getCommonSuperType(((JvmMultiTypeReference) result).getReferences());
		}
		return result;
	}
	
}
