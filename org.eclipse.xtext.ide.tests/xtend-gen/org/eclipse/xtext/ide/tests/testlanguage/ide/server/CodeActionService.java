/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.server;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService;
import org.eclipse.xtext.ide.tests.testlanguage.validation.TestLanguageValidator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodeActionService implements ICodeActionService {
  @Override
  public List<? extends Command> getCodeActions(final Document document, final XtextResource resource, final CodeActionParams params, final CancelIndicator indicator) {
    final ArrayList<Command> commands = CollectionLiterals.<Command>newArrayList();
    List<Diagnostic> _diagnostics = params.getContext().getDiagnostics();
    for (final Diagnostic d : _diagnostics) {
      String _code = d.getCode();
      boolean _equals = Objects.equal(_code, TestLanguageValidator.INVALID_NAME);
      if (_equals) {
        final String string = document.getSubstring(d.getRange());
        Command _command = new Command();
        final Procedure1<Command> _function = (Command it) -> {
          it.setCommand("my.textedit.command");
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Make \'");
          _builder.append(string);
          _builder.append("\' upper case");
          it.setTitle(_builder.toString());
          WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
          final Procedure1<WorkspaceEdit> _function_1 = (WorkspaceEdit it_1) -> {
            TextEdit _textEdit = new TextEdit();
            final Procedure1<TextEdit> _function_2 = (TextEdit it_2) -> {
              it_2.setNewText(StringExtensions.toFirstUpper(string));
              it_2.setRange(d.getRange());
            };
            TextEdit _doubleArrow = ObjectExtensions.<TextEdit>operator_doubleArrow(_textEdit, _function_2);
            it_1.getChanges().put(params.getTextDocument().getUri(), Collections.<TextEdit>unmodifiableList(CollectionLiterals.<TextEdit>newArrayList(_doubleArrow)));
          };
          WorkspaceEdit _doubleArrow = ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function_1);
          it.setArguments(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(_doubleArrow)));
        };
        Command _doubleArrow = ObjectExtensions.<Command>operator_doubleArrow(_command, _function);
        commands.add(_doubleArrow);
      }
    }
    return commands;
  }
}
