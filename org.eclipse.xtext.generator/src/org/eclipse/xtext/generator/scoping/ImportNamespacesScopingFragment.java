/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.scoping;

import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class ImportNamespacesScopingFragment extends AbstractScopingFragment {

	@Override
	protected Class<? extends IScopeProvider> getLocalScopeProvider() {
		return ImportedNamespaceAwareLocalScopeProvider.class;
	}

	@Override
	protected Class<? extends IGlobalScopeProvider> getGlobalScopeProvider() {
		return DefaultGlobalScopeProvider.class;
	}
}
