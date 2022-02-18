/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.server;

import java.util.List;

import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.CodeLensParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codelens.ICodeLensResolver;
import org.eclipse.xtext.ide.server.codelens.ICodeLensService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CodeLensService implements ICodeLensService, ICodeLensResolver {
	@Override
	public List<? extends CodeLens> computeCodeLenses(Document document, XtextResource resource, CodeLensParams params,
			CancelIndicator indicator) {
		CodeLens codeLens = new CodeLens();
		Command command = new Command();
		command.setCommand("do.this");
		command.setTitle("Do Awesome Stuff");
		command.setArguments(Lists.newArrayList("foo", Integer.valueOf(1), Boolean.valueOf(true)));
		codeLens.setCommand(command);
		codeLens.setData(new Position(1, 2));
		codeLens.setRange(new Range(new Position(1,1), new Position(1,2)));
		return Lists.newArrayList(codeLens);
	}

	@Override
	public CodeLens resolveCodeLens(Document document, XtextResource resource, CodeLens codeLens,
			CancelIndicator indicator) {
		codeLens.getCommand().setTitle(codeLens.getCommand().getTitle() + "(RESOLVED)");
		return codeLens;
	}
}
