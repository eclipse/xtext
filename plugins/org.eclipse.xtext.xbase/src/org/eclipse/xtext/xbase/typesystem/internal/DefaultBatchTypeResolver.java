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
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * TODO JavaDoc, toString
 */
public class DefaultBatchTypeResolver extends AbstractBatchTypeResolver {
	
	@Inject
	private Provider<AbstractRootedReentrantTypeResolver> typeResolverProvider;
	
	@Inject
	private OperationCanceledManager operationCanceledManager; 
	
	@Override
	protected IResolvedTypes doResolveTypes(/* @Nullable */ EObject object,  /* @Nullable */ CancelIndicator monitor) {
		// TODO: remove when we switch to an Xtend scope provider without artificial feature calls  
		EObject nonArtificialObject = getNonArtificialObject(object);
		// TODO end
		IReentrantTypeResolver reentrantResolver = getTypeResolver(nonArtificialObject);
		return reentrantResolver.reentrantResolve(monitor == null ? CancelIndicator.NullImpl : monitor);
	}

	private EObject getNonArtificialObject(EObject object) {
		EObject nonArtificialObject = object;
		if(object.eResource() == null && object instanceof XAbstractFeatureCall) {
			nonArtificialObject = ((XAbstractFeatureCall) object).getFeature();
		}
		return nonArtificialObject;
	}
	
	protected IReentrantTypeResolver getTypeResolver(EObject object) {
		Set<EObject> allRootedExpressions = Sets.newHashSet();
		List<EObject> roots = getEntryPoints(object);
		if (roots.size() == 1) {
			AbstractRootedReentrantTypeResolver result = getOrCreateResolver(roots.get(0));
			result.setAllRootedExpressions(allRootedExpressions);
			return result;
		}
		if (roots.isEmpty()) {
			return IReentrantTypeResolver.NULL;
		}
		CompoundReentrantTypeResolver result = new CompoundReentrantTypeResolver(allRootedExpressions);
		for(EObject root: roots) {
			AbstractRootedReentrantTypeResolver resolver = getOrCreateResolver(root);
			result.addResolver(resolver);
		}
		return result;
	}
	
	protected List<EObject> getEntryPoints(EObject object) {
		EObject rootContainer = EcoreUtil.getRootContainer(object);
		if (rootContainer instanceof XExpression) {
			return Collections.singletonList(rootContainer);	
		}
		return Collections.emptyList();
	}
	
	protected AbstractRootedReentrantTypeResolver getOrCreateResolver(EObject root) {
		final List<Adapter> adapters = root.eAdapters();
		final TypeResolutionStateAdapter currentAdapter = (TypeResolutionStateAdapter) EcoreUtil.getAdapter(adapters, TypeResolutionStateAdapter.class);
		if (currentAdapter == null) {
			final AbstractRootedReentrantTypeResolver newResolver = createResolver();
			final TypeResolutionStateAdapter newAdapter = new TypeResolutionStateAdapter(root, newResolver);
			AbstractRootedReentrantTypeResolver result = new AbstractRootedReentrantTypeResolver() {
				
				private int reentrance = 0;
				
				public IResolvedTypes reentrantResolve(CancelIndicator monitor) {
					Throwable e = null;
					try {
						reentrance++;
						IResolvedTypes result = newResolver.reentrantResolve(monitor);
						return result;
					} catch(Throwable caught) {
						e = caught;
						throw Exceptions.sneakyThrow(caught);
					} finally {
						reentrance--;
						if (reentrance == 0 && !adapters.remove(newAdapter)) {
							if (e != null) {
								operationCanceledManager.propagateAsErrorIfCancelException(e);
								throw new IllegalStateException("The TypeResolutionStateAdapter was removed while resolving", e);
							}
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
				protected void setAllRootedExpressions(Set<EObject> allRootedExpressions) {
					newResolver.setAllRootedExpressions(allRootedExpressions);
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
