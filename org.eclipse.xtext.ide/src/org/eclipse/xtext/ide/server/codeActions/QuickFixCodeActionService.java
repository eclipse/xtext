/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.codeActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionKind;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.editor.quickfix.AbstractDeclarativeIdeQuickfixProvider;
import org.eclipse.xtext.ide.editor.quickfix.DiagnosticResolution;
import org.eclipse.xtext.ide.editor.quickfix.IQuickFixProvider;
import org.eclipse.xtext.ide.editor.quickfix.QuickFix;

import com.google.common.annotations.Beta;

/**
 * {@link ICodeActionService2} handling quick-fixes annoted with {@link CodeActionKind#QuickFix}.
 * 
 * @author Heinrich Weichert
 * 
 * @see AbstractDeclarativeIdeQuickfixProvider
 * @see QuickFix
 * 
 * @since 2.24
 */
@Beta
public class QuickFixCodeActionService implements ICodeActionService2 {

	@Inject
	private IQuickFixProvider quickfixes;

	@Override
	public List<Either<Command, CodeAction>> getCodeActions(Options options) {
		List<Either<Command, CodeAction>> result = new ArrayList<>();

		boolean handleQuickfixes = options.getCodeActionParams().getContext().getOnly() == null
				|| options.getCodeActionParams().getContext().getOnly().isEmpty()
				|| options.getCodeActionParams().getContext().getOnly().contains(CodeActionKind.QuickFix);

		if (handleQuickfixes) {
			for (Diagnostic error : options.getCodeActionParams().getContext().getDiagnostics()) {
				List<DiagnosticResolution> resolutions = quickfixes.getResolutions(options, error);
				for (DiagnosticResolution resolution : resolutions) {
					result.add(Either.forRight(createFix(resolution, error)));
				}
			}
		}
		return result;
	}

	private CodeAction createFix(DiagnosticResolution resolution, Diagnostic error) {
		CodeAction codeAction = new CodeAction();
		codeAction.setDiagnostics(Collections.singletonList(error));
		codeAction.setTitle(resolution.getLabel());
		codeAction.setEdit(resolution.apply());
		codeAction.setKind(CodeActionKind.QuickFix);

		return codeAction;
	}

}
