/**
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author miklossy - Convert the class from Java to Xtend
 */
@SuppressWarnings("all")
public class FantasticEditStrategyProvider extends DefaultAutoEditStrategyProvider {
  private static final class Surprise implements IAutoEditStrategy {
    private String contents;
    
    @Override
    public void customizeDocumentCommand(final IDocument document, final DocumentCommand command) {
      try {
        if ((command.text.equals("t") && document.get((command.offset - 4), 4).equals("Xtex"))) {
          this.contents = document.get();
          document.set(this.getText());
          command.text = "";
          int _lastIndexOf = this.getText().lastIndexOf("M");
          int _plus = (_lastIndexOf + 1);
          command.offset = _plus;
        } else {
          if ((this.contents != null)) {
            document.set(this.contents);
            this.contents = null;
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof BadLocationException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    
    private String getText() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM      MMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM     MMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMM       MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMM          MMMMMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("M              MMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MM                MMMMMMMMMMMMMMMMMMMMM   MMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMM                 MMMMMMMMMMMMMMMM   MMMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMM                   MMMMMMMMM     MMMMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMM                             MMMMMMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMM                        MMMMMMMMMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMMMMMM                MMMMMMMMMMMMMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMMMMMMMMMMMM            MMMMMMMMMMMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMMMMMMMMM                     MMMMMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMMMMMM                           MMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMMMM       MMM                      MMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMM    MMMMMMMMMMMMMMM                 MMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMM   MMMMMMMMMMMMMMMMMMMM                MMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMM  MMMMMMMMMMMMMMMMMMMMMMMMM               MM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMM            MMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMM        MMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
      _builder.newLine();
      return _builder.toString();
    }
  }
  
  @Override
  protected void configure(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
    super.configure(acceptor);
    FantasticEditStrategyProvider.Surprise _surprise = new FantasticEditStrategyProvider.Surprise();
    acceptor.accept(_surprise, IDocument.DEFAULT_CONTENT_TYPE);
  }
}
