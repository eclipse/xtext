/**
 * Copyright (c) 2016, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.server.ILanguageServerExtension;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.ide.server.codelens.ICodeLensResolver;
import org.eclipse.xtext.ide.server.codelens.ICodeLensService;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.ide.tests.testlanguage.ide.AbstractTestLanguageIdeModule;
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension;
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLanguageExecutableCommandService;
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLanguageIdeContentProposalProvider;
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLanguageProposalCreator;
import org.eclipse.xtext.ide.tests.testlanguage.ide.server.CodeActionService;
import org.eclipse.xtext.ide.tests.testlanguage.ide.server.CodeLensService;

/**
 * Use this class to register ide components.
 */
@SuppressWarnings("all")
public class TestLanguageIdeModule extends AbstractTestLanguageIdeModule {
  public Class<? extends ILanguageServerExtension> bindLanguageServerExtension() {
    return TestLangLSPExtension.class;
  }
  
  public Class<? extends ICodeLensResolver> bindICodeLensResolver() {
    return CodeLensService.class;
  }
  
  public Class<? extends ICodeLensService> bindICodeLensService() {
    return CodeLensService.class;
  }
  
  public Class<? extends ICodeActionService2> bindICodeActionService2() {
    return CodeActionService.class;
  }
  
  public Class<? extends IExecutableCommandService> bindIExecutableCommandService() {
    return TestLanguageExecutableCommandService.class;
  }
  
  public Class<? extends IdeContentProposalCreator> bindIdeContentProposalCreator() {
    return TestLanguageProposalCreator.class;
  }
  
  public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
    return TestLanguageIdeContentProposalProvider.class;
  }
}
