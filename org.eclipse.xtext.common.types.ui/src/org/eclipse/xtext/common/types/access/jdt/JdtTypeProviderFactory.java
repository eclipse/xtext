/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;

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
		return new JdtTypeProvider(javaProject, resourceSet, getIndexedJvmTypeAccess(), copyOwnerProvider==null? DefaultWorkingCopyOwner.PRIMARY : copyOwnerProvider.getWorkingCopyOwner(javaProject, resourceSet), typeResourceServices);
	}

	@Override
	public IJdtTypeProvider createTypeProvider() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
}
