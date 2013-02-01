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
		IReentrantTypeResolver reentrantResolver = getTypeResolver(object);
		return reentrantResolver.reentrantResolve();
	}

	protected IReentrantTypeResolver getTypeResolver(EObject object) {
		List<EObject> roots = getEntryPoints(object);
		if (roots.size() == 1) {
			IReentrantTypeResolver result = getOrCreateResolver(roots.get(0));
			return result;
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
			adapters.add(newAdapter);
			AbstractRootedReentrantTypeResolver result = new AbstractRootedReentrantTypeResolver() {
				public IResolvedTypes reentrantResolve() {
					IResolvedTypes result = newResolver.reentrantResolve();
					if (!adapters.remove(newAdapter)) {
						throw new IllegalStateException("The TypeResolutionStateAdapter was removed while resolving");
					}
					return result;
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
				protected boolean isHandled(XExpression expression) {
					return newResolver.isHandled(expression);
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
