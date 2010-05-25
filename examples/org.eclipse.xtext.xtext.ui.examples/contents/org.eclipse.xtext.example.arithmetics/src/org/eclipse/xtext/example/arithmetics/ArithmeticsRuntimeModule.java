/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics;

import org.eclipse.xtext.example.arithmetics.scoping.NameProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;


public class ArithmeticsRuntimeModule extends AbstractArithmeticsRuntimeModule {

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return NameProvider.class;
	}
	
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return org.eclipse.xtext.example.arithmetics.scoping.LinkingService.class;
	}
	
}
