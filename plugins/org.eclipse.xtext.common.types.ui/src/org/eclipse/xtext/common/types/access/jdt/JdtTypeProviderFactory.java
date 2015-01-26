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
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.common.types.access.jdt.internal.JavaProjectAccessTypeProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@Singleton
public class JdtTypeProviderFactory extends AbstractTypeProviderFactory {

	@Inject
	private IJavaProjectProvider javaProjectProvider;
	
	@Inject
	private IWorkingCopyOwnerProvider copyOwnerProvider;
	
	@Inject
	private TypeResourceServices typeResourceServices;

	/**
	 * @since 2.4
	 */
	public JdtTypeProviderFactory() {}
	
	public JdtTypeProviderFactory(IJavaProjectProvider javaProjectProvider) {
		this.javaProjectProvider = javaProjectProvider;
	}
	
	@Override
	public IJdtTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		IJavaProject javaProject = javaProjectProvider.getJavaProject(resourceSet);
		IJdtTypeProvider result = createJdtTypeProvider(javaProject, resourceSet);
		return result;
	}

	protected IJdtTypeProvider createJdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet) {
		if (javaProject == null)
			//TODO throw a serious exception instead of returning a non working implementation
			return new NullJdtTypeProvider(resourceSet);
		if (javaProject instanceof JavaProject) {
			return new JavaProjectAccessTypeProvider((JavaProject) javaProject, resourceSet, getIndexedJvmTypeAccess(), copyOwnerProvider==null? DefaultWorkingCopyOwner.PRIMARY : copyOwnerProvider.getWorkingCopyOwner(javaProject, resourceSet), typeResourceServices);
		}
		return new JdtTypeProvider(javaProject, resourceSet, getIndexedJvmTypeAccess(), copyOwnerProvider==null? DefaultWorkingCopyOwner.PRIMARY : copyOwnerProvider.getWorkingCopyOwner(javaProject, resourceSet), typeResourceServices);
	}

	@Override
	public IJdtTypeProvider createTypeProvider() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
}
