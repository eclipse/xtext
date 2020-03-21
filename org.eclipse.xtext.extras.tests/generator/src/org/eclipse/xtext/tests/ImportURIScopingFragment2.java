/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.tests;

import com.google.inject.Inject;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleLocalScopeProvider;
import org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

import static org.eclipse.xtext.xtext.generator.model.TypeReference.*;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

public class ImportURIScopingFragment2 extends ImportNamespacesScopingFragment2 {

	@Inject
	private XbaseUsageDetector xbaseUsageDetector;

	@Override
	protected TypeReference getDelegateScopeProvider() {
		if (xbaseUsageDetector.inheritsXbase(getLanguage().getGrammar()))
			return typeRef("org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider");
		else
			return typeRef(SimpleLocalScopeProvider.class);
	}

	@Override
	protected TypeReference getGlobalScopeProvider() {
		return typeRef(ImportUriGlobalScopeProvider.class);
	}

}
