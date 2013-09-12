/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class DefaultBatchTypeResolver implements IBatchTypeResolver {
	
	@Inject
	private Provider<AbstractRootedReentrantTypeResolver> typeResolverProvider;
	
	public IResolvedTypes resolveTypes(@Nullable EObject object) {
		if (object == null || object.eIsProxy())
			return IResolvedTypes.NULL;
		// TODO: remove when we switch to an Xtend scope provider without artificial feature calls  
		EObject nonArtificialObject = getNonArtificialObject(object);
		// TODO end
		IReentrantTypeResolver reentrantResolver = getTypeResolver(nonArtificialObject);
		return reentrantResolver.reentrantResolve();
	}

	private EObject getNonArtificialObject(EObject object) {
		EObject nonArtificialObject = object;
		if(object.eResource() == null && object instanceof XAbstractFeatureCall) {
			nonArtificialObject = ((XAbstractFeatureCall) object).getFeature();
		}
		return nonArtificialObject;
	}
	
	public IScope getFeatureScope(@Nullable XAbstractFeatureCall featureCall) {
		if (featureCall == null || featureCall.eIsProxy()) {
			return IScope.NULLSCOPE;
		}
		List<EObject> roots = getEntryPoints(featureCall);
		for(EObject root: roots) {
			AbstractRootedReentrantTypeResolver resolver = getOrCreateResolver(root);
			if (resolver.isHandled(featureCall)) {
				return resolver.getFeatureScope(featureCall);
			}
		}
		return IScope.NULLSCOPE;
	}
	
	public IResolvedTypes getResolvedTypesInContextOf(@Nullable EObject context) {
		if (context == null || context.eIsProxy())
			return IResolvedTypes.NULL;
		// TODO: remove when we switch to an Xtend scope provider without artificial feature calls  
		EObject nonArtificialObject = getNonArtificialObject(context);
		// TODO end
		List<EObject> roots = getEntryPoints(nonArtificialObject);
		for(EObject root: roots) {
			AbstractRootedReentrantTypeResolver resolver = getOrCreateResolver(root);
			if (resolver.isHandled(context)) {
				return resolver.getResolvedTypesInContextOf(context);
			}
		}
		return IResolvedTypes.NULL;
	}

	protected IReentrantTypeResolver getTypeResolver(EObject object) {
		List<EObject> roots = getEntryPoints(object);
		if (roots.size() == 1) {
			IReentrantTypeResolver result = getOrCreateResolver(roots.get(0));
			return result;
		}
		if (roots.isEmpty()) {
			return IReentrantTypeResolver.NULL;
		}
		CompoundReentrantTypeResolver result = new CompoundReentrantTypeResolver();
		for(EObject root: roots) {
			result.addResolver(getOrCreateResolver(root));
		}
		return result;
	}
	
	protected List<EObject> getEntryPoints(EObject object) {
		return Collections.singletonList(EcoreUtil.getRootContainer(object));
	}
	
	protected AbstractRootedReentrantTypeResolver getOrCreateResolver(EObject root) {
		final List<Adapter> adapters = root.eAdapters();
		final TypeResolutionStateAdapter currentAdapter = (TypeResolutionStateAdapter) EcoreUtil.getAdapter(adapters, TypeResolutionStateAdapter.class);
		if (currentAdapter == null) {
			final AbstractRootedReentrantTypeResolver newResolver = createResolver();
			final TypeResolutionStateAdapter newAdapter = new TypeResolutionStateAdapter(root, newResolver);
			AbstractRootedReentrantTypeResolver result = new AbstractRootedReentrantTypeResolver() {
				
				private int reentrance = 0;
				
				public IResolvedTypes reentrantResolve() {
					try {
						reentrance++;
						IResolvedTypes result = newResolver.reentrantResolve();
						return result;
					} finally {
						reentrance--;
						if (reentrance == 0 && !adapters.remove(newAdapter)) {
							throw new IllegalStateException("The TypeResolutionStateAdapter was removed while resolving");
						}
					}
				}
				
				public void initializeFrom(EObject root) {
					newResolver.initializeFrom(root);
				}

				@Override
				protected EObject getRoot() {
					return newResolver.getRoot();
				}
				
				@Override
				protected boolean isHandled(JvmIdentifiableElement identifiableElement) {
					return newResolver.isHandled(identifiableElement);
				}
				
				@Override
				protected boolean isHandled(EObject context) {
					return newResolver.isHandled(context);
				}
				
				@Override
				protected boolean isHandled(XExpression expression) {
					return newResolver.isHandled(expression);
				}

				@Override
				protected IScope getFeatureScope(XAbstractFeatureCall featureCall) {
					return newResolver.getFeatureScope(featureCall);
				}
				
				@Override
				protected IResolvedTypes getResolvedTypesInContextOf(EObject context) {
					return newResolver.getResolvedTypesInContextOf(context);
				}
			};
			result.initializeFrom(root);
			return result;
		} else {
			return currentAdapter;	
		}
	}

	protected AbstractRootedReentrantTypeResolver createResolver() {
		return typeResolverProvider.get();
	}

}
