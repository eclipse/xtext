/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.ITypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;

import com.google.inject.Inject;

/**
 * A local scope provider for Java types on the classpath.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathBasedTypeScopeProvider extends AbstractTypeScopeProvider {
	
	@Inject
	private ClasspathTypeProviderFactory typeProviderFactory;

	@Override
	public ClasspathBasedTypeScope createTypeScope(ITypeProvider typeProvider) {
		return new ClasspathBasedTypeScope((ClasspathTypeProvider) typeProvider);
	}

	public void setTypeProviderFactory(ClasspathTypeProviderFactory typeProviderFactory) {
		this.typeProviderFactory = typeProviderFactory;
	}

	@Override
	public ClasspathTypeProviderFactory getTypeProviderFactory() {
		return typeProviderFactory;
	}
	
}
