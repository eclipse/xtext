/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.scoping;

import org.eclipse.xtext.resource.ignorecase.IgnoreCaseImportUriGlobalScopeProvider;
import org.eclipse.xtext.resource.ignorecase.IgnoreCaseSimpleLocalScopeProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleLocalScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImportURIScopingFragment extends AbstractScopingFragment {

	@Override
	protected Class<? extends IScopeProvider> getLocalScopeProvider() {
		return isIgnoreCase() 
			? IgnoreCaseSimpleLocalScopeProvider.class
			: SimpleLocalScopeProvider.class;
	}
	
	@Override
	protected Class<? extends IGlobalScopeProvider> getGlobalScopeProvider() {
		return isIgnoreCase() 
			? IgnoreCaseImportUriGlobalScopeProvider.class
			: ImportUriGlobalScopeProvider.class;
	}
}
