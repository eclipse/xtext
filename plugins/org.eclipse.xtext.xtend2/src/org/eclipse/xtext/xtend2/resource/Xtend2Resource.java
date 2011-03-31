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
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.resource.XbaseResource;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;
import org.eclipse.xtext.xtend2.dispatch.DispatchingSupport;
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
	private IJvmModelAssociations associations;
	
	@Inject
	private XbaseTypeConformanceComputer typeConformanceComputer;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private DispatchingSupport dispatchingSupport;
	
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
				if (typeReference==null)
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
				if (commonType.eContainer()!=null) {
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
	
	// TODO typeConformanceComputer.getCommonSuperType may return null - this case needs to be addressed
	protected JvmTypeReference inferReturnType(JvmOperation jvmOperation) {
		List<JvmTypeReference> associatedReturnTypes = newArrayList();
		final Iterable<XtendFunction> associatedElements = filter(associations.getSourceElements(jvmOperation), XtendFunction.class);
		for (XtendFunction func : associatedElements) {
			JvmTypeReference type = typeProvider.getTypeForIdentifiable(func);
			if (type != null)
				associatedReturnTypes.add(type);
		}
		if (!associatedReturnTypes.isEmpty()) {
			JvmTypeReference commonSuperType = typeConformanceComputer.getCommonSuperType(associatedReturnTypes);
			return commonSuperType;
		}
		return null;
	}
	
	// TODO typeConformanceComputer.getCommonSuperType may return null - this case needs to be addressed
	protected <T> JvmTypeReference commonType(Iterable<? extends T> iterable, Function<T, JvmTypeReference> mapping) {
		List<JvmTypeReference> references = newArrayList();
		for (T element : iterable) {
			JvmTypeReference apply = mapping.apply(element);
			if (!typeReferences.isNullOrProxy(apply)) {
				apply = primitives.asWrapperTypeIfPrimitive(apply); 
				references.add(apply);
			}
		}
		return typeConformanceComputer.getCommonSuperType(references);
	}
	
}
