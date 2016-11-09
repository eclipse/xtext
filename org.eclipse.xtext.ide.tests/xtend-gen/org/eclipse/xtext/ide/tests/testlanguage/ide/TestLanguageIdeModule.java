/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import org.eclipse.xtext.ide.server.ILanguageServerExtension;
import org.eclipse.xtext.ide.tests.testlanguage.ide.AbstractTestLanguageIdeModule;
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension;

/**
 * Use this class to register ide components.
 */
@SuppressWarnings("all")
public class TestLanguageIdeModule extends AbstractTestLanguageIdeModule {
  public Class<? extends ILanguageServerExtension> bindLanguageServerExtension() {
    return TestLangLSPExtension.class;
  }
}
