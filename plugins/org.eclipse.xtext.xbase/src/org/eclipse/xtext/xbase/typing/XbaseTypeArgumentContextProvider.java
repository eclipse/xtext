/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseTypeArgumentContextProvider extends TypeArgumentContext.Provider {
	
	@Inject
	private IXExpressionTypeProvider typeProvider;
	
	public TypeArgumentContext getContext(final XExpression obj) {
		Provider<TypeArgumentContext> provider = new Provider<TypeArgumentContext>() {
			public TypeArgumentContext get() {
				JvmTypeReference type = typeProvider.getConvertedType(obj);
				return XbaseTypeArgumentContextProvider.this.get(type);
			}
		};
		IResourceScopeCache cache = getCache(obj);
		if (cache==null)
			return provider.get();
		else
			return cache.get(Tuples.pair("typeContext", obj), obj.eResource(), provider);
	}
	
	protected IResourceScopeCache getCache(EObject obj) {
		if (obj.eResource() instanceof XtextResource) 
			return ((XtextResource)obj.eResource()).getCache();
		return null;
	}
}
