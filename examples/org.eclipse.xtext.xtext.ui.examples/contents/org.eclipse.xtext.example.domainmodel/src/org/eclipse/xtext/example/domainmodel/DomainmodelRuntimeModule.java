/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.example.domainmodel.jvmmodel.DomainmodelIdentifiableSimpleNameProvider;
import org.eclipse.xtext.example.domainmodel.naming.DomainmodelQualifiedNameProvider;
import org.eclipse.xtext.example.domainmodel.typing.DomainmodelTypeProvider;
import org.eclipse.xtext.example.domainmodel.valueconverter.DomainmodelValueConverterService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return DomainmodelValueConverterService.class;
	}
	
	@Override
	public Class<? extends IdentifiableSimpleNameProvider> bindIdentifiableSimpleNameProvider() {
		return DomainmodelIdentifiableSimpleNameProvider.class;
	}
	
	@Override
	public Class<? extends ITypeProvider> bindITypeProvider() {
		return DomainmodelTypeProvider.class;
	}
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DomainmodelQualifiedNameProvider.class;
	}
}
