/*
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.server.ILanguageServerExtension;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.ide.server.codelens.ICodeLensResolver;
import org.eclipse.xtext.ide.server.codelens.ICodeLensService;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.ide.server.rename.IRenameService2;
import org.eclipse.xtext.ide.tests.testlanguage.ide.server.CodeActionService;
import org.eclipse.xtext.ide.tests.testlanguage.ide.server.CodeLensService;
import org.eclipse.xtext.ide.tests.testlanguage.rename.TestLanguageRenameService;

/**
 * Use this class to register ide components.
 */
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

	@Override
	public Class<? extends IRenameService2> bindIRenameService2() {
		return TestLanguageRenameService.class;
	}
}
