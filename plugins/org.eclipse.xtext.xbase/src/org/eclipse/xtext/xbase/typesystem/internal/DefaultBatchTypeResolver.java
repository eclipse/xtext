/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.ITypeResolution;

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
	
	public static class TypeResolutionStateAdapter extends AdapterImpl implements IReentrantTypeResolver {
		
		private final IReentrantTypeResolver context;

		public TypeResolutionStateAdapter(EObject associatedWith, IReentrantTypeResolver context) {
			this.context = context;
			associatedWith.eAdapters().add(this);
		}
		
		@Override
		public boolean isAdapterForType(@Nullable Object type) {
			return TypeResolutionStateAdapter.class.equals(type);
		}
		
		public IReentrantTypeResolver getContext() {
			return context;
		}

		public void initializeFrom(EObject root) {
			throw new IllegalStateException("Attempt to reinitialize the root resolver");
		}

		public ITypeResolution reentrantResolve() {
			return context.reentrantResolve();
		}
	}
	
	@Inject
	private Provider<IReentrantTypeResolver> typeResolverProvider;
	
	public ITypeResolution resolveTypes(@Nullable XExpression expression) {
		if (expression == null || expression.eIsProxy())
			return ITypeResolution.NULL;
		IReentrantTypeResolver resolutionState = getTypeResolver(expression);
		return resolutionState.reentrantResolve();
	}

	protected IReentrantTypeResolver getTypeResolver(XExpression expression) {
		EObject root = EcoreUtil.getRootContainer(expression);
		IReentrantTypeResolver result = getOrCreateResolver(root);
		return result;
	}

	protected IReentrantTypeResolver getOrCreateResolver(EObject root) {
		final List<Adapter> adapters = root.eAdapters();
		final TypeResolutionStateAdapter currentAdapter = (TypeResolutionStateAdapter) EcoreUtil.getAdapter(adapters, TypeResolutionStateAdapter.class);
		if (currentAdapter == null) {
			final IReentrantTypeResolver newResolver = typeResolverProvider.get();
			final TypeResolutionStateAdapter newAdapter = new TypeResolutionStateAdapter(root, newResolver);
			adapters.add(newAdapter);
			IReentrantTypeResolver result = new IReentrantTypeResolver() {
				public ITypeResolution reentrantResolve() {
					ITypeResolution result = newResolver.reentrantResolve();
					if (!adapters.remove(newAdapter)) {
						throw new IllegalStateException("The TypeResolutionStateAdapter was removed while resolving");
					}
					return result;
				}
				
				public void initializeFrom(EObject root) {
					newResolver.initializeFrom(root);
				}
			};
			result.initializeFrom(root);
			return result;
		} else {
			return currentAdapter;	
		}
	}

}
