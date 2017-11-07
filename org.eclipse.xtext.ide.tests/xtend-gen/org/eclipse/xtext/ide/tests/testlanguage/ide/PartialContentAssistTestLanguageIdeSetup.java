/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.ide.tests.testlanguage.PartialContentAssistTestLanguageRuntimeModule;
import org.eclipse.xtext.ide.tests.testlanguage.PartialContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.ide.tests.testlanguage.ide.PartialContentAssistTestLanguageIdeModule;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class PartialContentAssistTestLanguageIdeSetup extends PartialContentAssistTestLanguageStandaloneSetup {
  @Override
  public Injector createInjector() {
    PartialContentAssistTestLanguageRuntimeModule _partialContentAssistTestLanguageRuntimeModule = new PartialContentAssistTestLanguageRuntimeModule();
    PartialContentAssistTestLanguageIdeModule _partialContentAssistTestLanguageIdeModule = new PartialContentAssistTestLanguageIdeModule();
    return Guice.createInjector(Modules2.mixin(_partialContentAssistTestLanguageRuntimeModule, _partialContentAssistTestLanguageIdeModule));
  }
}
