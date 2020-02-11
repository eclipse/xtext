/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.server;

import java.util.Collections;
import java.util.List;
import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.CodeLensParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codelens.ICodeLensResolver;
import org.eclipse.xtext.ide.server.codelens.ICodeLensService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodeLensService implements ICodeLensService, ICodeLensResolver {
  @Override
  public List<? extends CodeLens> computeCodeLenses(final Document document, final XtextResource resource, final CodeLensParams params, final CancelIndicator indicator) {
    CodeLens _codeLens = new CodeLens();
    final Procedure1<CodeLens> _function = (CodeLens it) -> {
      Command _command = new Command();
      final Procedure1<Command> _function_1 = (Command it_1) -> {
        it_1.setCommand("do.this");
        it_1.setTitle("Do Awesome Stuff");
        it_1.setArguments(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("foo", Integer.valueOf(1), Boolean.valueOf(true))));
      };
      Command _doubleArrow = ObjectExtensions.<Command>operator_doubleArrow(_command, _function_1);
      it.setCommand(_doubleArrow);
      Position _position = new Position(1, 2);
      it.setData(_position);
    };
    CodeLens _doubleArrow = ObjectExtensions.<CodeLens>operator_doubleArrow(_codeLens, _function);
    return Collections.<CodeLens>unmodifiableList(CollectionLiterals.<CodeLens>newArrayList(_doubleArrow));
  }
  
  @Override
  public CodeLens resolveCodeLens(final Document document, final XtextResource resource, final CodeLens codeLens, final CancelIndicator indicator) {
    Command _command = codeLens.getCommand();
    String _title = codeLens.getCommand().getTitle();
    String _plus = (_title + "(RESOLVED)");
    _command.setTitle(_plus);
    return codeLens;
  }
}
