/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage;

import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.ide.server.signatureHelp.SignatureHelpService;
import org.eclipse.xtext.ide.tests.testlanguage.AbstractTestLanguageRuntimeModule;
import org.eclipse.xtext.ide.tests.testlanguage.formatting2.TestLanguageFormatter;
import org.eclipse.xtext.ide.tests.testlanguage.signatureHelp.SignatureHelpServiceImpl;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class TestLanguageRuntimeModule extends AbstractTestLanguageRuntimeModule {
  public Class<? extends IFormatter2> bindIFormatter2() {
    return TestLanguageFormatter.class;
  }
  
  public Class<? extends SignatureHelpService> bindSignatureHelpService() {
    return SignatureHelpServiceImpl.class;
  }
}
