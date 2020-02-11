/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.tests;

import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.service.AbstractGenericModule;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ClasspathBasedModule extends AbstractGenericModule {
	
	public ClassLoader bindClassloader() {
		return getClass().getClassLoader();
	}
	
	public TypesFactory bindTypesFactory() {
		return TypesFactory.eINSTANCE;
	}
	
	public Class<? extends IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
		return ClasspathTypeProviderFactory.class;
	}
	
}
