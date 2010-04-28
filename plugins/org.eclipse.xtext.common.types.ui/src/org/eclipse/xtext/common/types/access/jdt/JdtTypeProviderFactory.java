/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtTypeProviderFactory extends AbstractTypeProviderFactory {

	private final IJavaProjectProvider javaProjectProvider;

	@Inject
	public JdtTypeProviderFactory(IJavaProjectProvider javaProjectProvider) {
		this.javaProjectProvider = javaProjectProvider;
	}
	
	public IJdtTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		IJavaProject javaProject = javaProjectProvider.getJavaProject(resourceSet);
		IJdtTypeProvider result = createJdtTypeProvider(javaProject, resourceSet);
		return result;
	}

	protected IJdtTypeProvider createJdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet) {
		if (javaProject == null)
			return new NullJdtTypeProvider(resourceSet);
		return new JdtTypeProvider(javaProject, resourceSet);
	}

	@Override
	public IJdtTypeProvider createTypeProvider() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
}
