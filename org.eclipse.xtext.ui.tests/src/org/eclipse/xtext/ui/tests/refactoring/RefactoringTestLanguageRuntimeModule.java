/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.ui.tests.refactoring.resource.RefactoringTestLanguageFragmentProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class RefactoringTestLanguageRuntimeModule extends org.eclipse.xtext.ui.tests.refactoring.AbstractRefactoringTestLanguageRuntimeModule {

	@Override
	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return RefactoringTestLanguageFragmentProvider.class;
	}

}
