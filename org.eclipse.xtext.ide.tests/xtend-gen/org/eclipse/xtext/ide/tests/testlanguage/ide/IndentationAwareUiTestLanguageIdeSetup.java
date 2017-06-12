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
import org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguageRuntimeModule;
import org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguageStandaloneSetup;
import org.eclipse.xtext.ide.tests.testlanguage.ide.IndentationAwareUiTestLanguageIdeModule;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class IndentationAwareUiTestLanguageIdeSetup extends IndentationAwareUiTestLanguageStandaloneSetup {
  @Override
  public Injector createInjector() {
    IndentationAwareUiTestLanguageRuntimeModule _indentationAwareUiTestLanguageRuntimeModule = new IndentationAwareUiTestLanguageRuntimeModule();
    IndentationAwareUiTestLanguageIdeModule _indentationAwareUiTestLanguageIdeModule = new IndentationAwareUiTestLanguageIdeModule();
    return Guice.createInjector(Modules2.mixin(_indentationAwareUiTestLanguageRuntimeModule, _indentationAwareUiTestLanguageIdeModule));
  }
}
