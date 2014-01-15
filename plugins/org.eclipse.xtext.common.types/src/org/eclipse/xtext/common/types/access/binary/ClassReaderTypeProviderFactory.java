/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassReaderTypeProviderFactory extends AbstractTypeProviderFactory {

	private final ClassLoader classLoader;
	
	@Inject
	public ClassReaderTypeProviderFactory(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	public ClassReaderTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		ClassReaderTypeProvider result = createClassReaderBasedTypeProvider(resourceSet);
		return result;
	}

	protected ClassReaderTypeProvider createClassReaderBasedTypeProvider(ResourceSet resourceSet) {
		return new ClassReaderTypeProvider(getClassLoader(resourceSet), resourceSet, getIndexedJvmTypeAccess());
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
	
	protected boolean isDefaultClassLoader(ClassLoader loader) {
		return classLoader == loader;
	}
	
	@Override
	public ClassReaderTypeProvider createTypeProvider() {
		return (ClassReaderTypeProvider) super.createTypeProvider();
	}
	
	@Override
	public ClassReaderTypeProvider findTypeProvider(ResourceSet resourceSet) {
		return (ClassReaderTypeProvider) super.findTypeProvider(resourceSet);
	}
	
}
