/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.xbase.typing.ExpressionsTypeResolver;

/**
 * Use this class to register components to be used within the IDE.
 */
public class XbaseRuntimeModule extends AbstractXbaseRuntimeModule {
	public Class<? extends org.eclipse.xtext.typing.ITypeConformanceComputer<JvmTypeReference>> bindITypeService() {
		return IJvmTypeConformanceComputer.class;
	}
	
	public Class<? extends org.eclipse.xtext.typing.ITypeProvider<JvmTypeReference>> bindITypeProvider() {
		return ExpressionsTypeResolver.class;
	}
}
