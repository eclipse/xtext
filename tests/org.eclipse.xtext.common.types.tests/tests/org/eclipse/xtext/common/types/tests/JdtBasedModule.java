/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.tests;

import static java.util.Collections.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider.Factory;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.IWorkingCopyOwnerProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.xtext.ui.XtextResourceSetBasedProjectProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JdtBasedModule extends ClasspathBasedModule {

	@Override
	public Class<? extends Factory> bindIJvmTypeProvider$Factory() {
		return JdtTypeProviderFactory.class;
	}

	public Class<? extends IJavaProjectProvider> bindIJavaProjectProvider() {
		return XtextResourceSetBasedProjectProvider.class;
	}
	
	public IWorkingCopyOwnerProvider bindIWorkingCopyOwnerProvider() {
		return IWorkingCopyOwnerProvider.DEFAULT;
	}
	
	public static class Storage2UriDummy implements IStorage2UriMapper {

		public Iterable<Pair<IStorage, IProject>> getStorages(URI uri) {
			return emptyList();
		}

		public URI getUri(IStorage storage) {
			return null;
		}
		
	}
}


