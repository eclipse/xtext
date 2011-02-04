/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.tests;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider.Factory;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.xtext.ui.XtextResourceSetBasedProjectProvider;

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
	
}
