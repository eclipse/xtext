/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class ReflectionTypeProviderFactory extends AbstractTypeProviderFactory {

	private final ClassLoader classLoader;
	
	@Inject
	public ReflectionTypeProviderFactory(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	public ReflectionTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		ReflectionTypeProvider result = createClasspathTypeProvider(resourceSet);
		return result;
	}

	protected ReflectionTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return new ReflectionTypeProvider(getClassLoader(resourceSet), resourceSet, getIndexedJvmTypeAccess());
	}
	
	public ClassLoader getClassLoader(ResourceSet resourceSet) {
		if (resourceSet instanceof XtextResourceSet) {
			XtextResourceSet xtextResourceSet = (XtextResourceSet) resourceSet;
			Object ctx = xtextResourceSet.getClasspathURIContext();
			if (ctx != null) {
		        if (ctx instanceof Class<?>) {
		            return ((Class<?>)ctx).getClassLoader();
		        }
		        if (!(ctx instanceof ClassLoader)) {
		        	return ctx.getClass().getClassLoader();
		        }
		        return (ClassLoader) ctx;
			}
		}
		return classLoader;
	}
	
	@Override
	public ReflectionTypeProvider createTypeProvider() {
		return (ReflectionTypeProvider) super.createTypeProvider();
	}
	
	@Override
	public ReflectionTypeProvider findTypeProvider(ResourceSet resourceSet) {
		return (ReflectionTypeProvider) super.findTypeProvider(resourceSet);
	}
	
}
