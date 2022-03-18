/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.fileAware.ide.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.testlanguages.fileAware.ide.FileAwareTestLanguageIdeSetup;
import org.eclipse.xtext.testlanguages.fileAware.tests.FileAwareTestLanguageInjectorProvider;

public class FileAwareTestLanguageIdeInjectorProvider extends FileAwareTestLanguageInjectorProvider {

	public Injector internalCreateInjector() {
		return new FileAwareTestLanguageIdeSetup().createInjectorAndDoEMFRegistration();
	}
}