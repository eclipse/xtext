/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tests

import com.google.inject.Inject
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider
import org.eclipse.xtext.scoping.impl.SimpleLocalScopeProvider
import org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

class ImportURIScopingFragment2 extends ImportNamespacesScopingFragment2 {
	
	@Inject extension XbaseUsageDetector

	override getDelegateScopeProvider() {
		if (language.grammar.inheritsXbase)
			'org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider'.typeRef
		else
			SimpleLocalScopeProvider.typeRef
	}
	
	override protected getGlobalScopeProvider() {
		ImportUriGlobalScopeProvider.typeRef
	}
	
}
	