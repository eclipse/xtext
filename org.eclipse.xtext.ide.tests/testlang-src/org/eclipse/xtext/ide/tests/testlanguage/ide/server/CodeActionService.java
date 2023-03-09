/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.server;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.ide.server.codeActions.QuickFixCodeActionService;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Member;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Model;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.validation.TestLanguageValidator;
import org.eclipse.xtext.util.CollectionBasedAcceptor;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CodeActionService extends QuickFixCodeActionService {
	@Inject
	private IChangeSerializer serializer;

	@Override
	protected List<Either<Command, CodeAction>> getCodeActions(Options options, Diagnostic diagnostic) {
		Object code = diagnostic.getCode().get();
		List<Either<Command, CodeAction>> codeActions = super.getCodeActions(options, diagnostic);
		if (TestLanguageValidator.INVALID_NAME.equals(code)) {
			codeActions.add(Either.forLeft(fixInvalidName(diagnostic, options)));
		} else if (TestLanguageValidator.UNSORTED_MEMBERS.equals(code)) {
			codeActions.add(Either.forRight(fixUnsortedMembers(diagnostic, options)));
		}
		return codeActions;
	}

	@Override
	protected boolean handlesDiagnostic(Diagnostic diagnostic) {
		return true;
	}

	private Command fixInvalidName(Diagnostic d, ICodeActionService2.Options options) {
		String string = options.getDocument().getSubstring(d.getRange());
		Command command = new Command();
		command.setCommand("my.textedit.command");
		command.setTitle("Make '" + string + "' upper case (Command)");
		WorkspaceEdit workspaceEdit = new WorkspaceEdit();
		TextEdit textEdit = new TextEdit();
		textEdit.setNewText(StringExtensions.toFirstUpper(string));
		textEdit.setRange(d.getRange());
		workspaceEdit.getChanges().put(options.getCodeActionParams().getTextDocument().getUri(),
				Lists.newArrayList(textEdit));
		command.setArguments(Lists.newArrayList(workspaceEdit));
		return command;
	}

	private CodeAction fixUnsortedMembers(Diagnostic d, ICodeActionService2.Options options) {
		WorkspaceEdit wsEdit = recordWorkspaceEdit(options, (Resource copiedResource) -> {
			Model model = Iterables.getFirst(Iterables.filter(copiedResource.getContents(), Model.class), null);
			if (model != null) {
				for (TypeDeclaration type : Iterables.filter(model.getElements(), TypeDeclaration.class)) {
					ECollections.sort(type.getMembers(), (Member a, Member b) -> a.getName().compareTo(b.getName()));
				}
			}
		});
		CodeAction codeAction = new CodeAction();
		codeAction.setTitle("Sort Members");
		codeAction.setDiagnostics(Lists.newArrayList(d));
		codeAction.setEdit(wsEdit);
		return codeAction;
	}

	private WorkspaceEdit recordWorkspaceEdit(ICodeActionService2.Options options,
			IChangeSerializer.IModification<Resource> mod) {
		ResourceSet rs = options.getLanguageServerAccess().newLiveScopeResourceSet(options.getResource().getURI());
		Resource copy = rs.getResource(options.getResource().getURI(), true);
		serializer.addModification(copy, mod);
		List<IEmfResourceChange> documentchanges = new ArrayList<>();
		serializer.applyModifications(CollectionBasedAcceptor.of(documentchanges));
		WorkspaceEdit workspaceEdit = new WorkspaceEdit();
		for (ITextDocumentChange documentchange : Iterables.filter(documentchanges, ITextDocumentChange.class)) {
			List<TextEdit> edits = Lists.transform(documentchange.getReplacements(),
					(ITextReplacement replacement) -> {
						TextEdit textEdit = new TextEdit();
						textEdit.setNewText(replacement.getReplacementText());
						textEdit.setRange(new Range(options.getDocument().getPosition(replacement.getOffset()),
								options.getDocument().getPosition(replacement.getEndOffset())));
						return textEdit;
					});
			workspaceEdit.getChanges().put(documentchange.getNewURI().toString(), edits);
		}
		return workspaceEdit;
	}
}
