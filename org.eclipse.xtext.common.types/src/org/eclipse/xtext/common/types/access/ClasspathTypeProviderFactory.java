/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProviderFactory extends AbstractTypeProviderFactory {

	private final ClassLoader classLoader;
	protected final TypeResourceServices services;
	
	@Inject
	public ClasspathTypeProviderFactory(ClassLoader classLoader, TypeResourceServices services) {
		this.classLoader = classLoader;
		this.services = services;
	}
	
	@Override
	public ClasspathTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		ClasspathTypeProvider result = createClasspathTypeProvider(resourceSet);
		return result;
	}

	protected ClasspathTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return new ClasspathTypeProvider(getClassLoader(resourceSet), resourceSet, getIndexedJvmTypeAccess(), services);
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
	
	boolean isDefaultClassLoader(ClassLoader loader) {
		return classLoader == loader;
	}
	
	@Override
	public ClasspathTypeProvider createTypeProvider() {
		return (ClasspathTypeProvider) super.createTypeProvider();
	}
	
	@Override
	public IJvmTypeProvider findTypeProvider(ResourceSet resourceSet) {
		return super.findTypeProvider(resourceSet);
	}
	
}
