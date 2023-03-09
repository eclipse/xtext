/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.ICaseInsensitivityHelper;

/**
 * Use this class to register components to be used within the IDE.
 */
public class IgnoreCaseNamespacesTestLanguageRuntimeModule extends org.eclipse.xtext.linking.AbstractIgnoreCaseNamespacesTestLanguageRuntimeModule {

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DefaultDeclarativeQualifiedNameProvider.class;
	}
	
	public ICaseInsensitivityHelper bindCaseInsensitivityHelper() {
		return new ICaseInsensitivityHelper() {
			@Override
			public boolean isIgnoreCase(EReference reference) {
				return true;
			}
		};
	}
	
}
