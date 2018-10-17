/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.autoedit;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.math.BigDecimal;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * An interactive interpreter as an {@link IAutoEditStrategy}
 */
@SuppressWarnings("all")
public class InterpreterAutoEdit implements IAutoEditStrategy {
  @Override
  public void customizeDocumentCommand(final IDocument document, final DocumentCommand command) {
    String[] _legalLineDelimiters = document.getLegalLineDelimiters();
    for (final String lineDelimiter : _legalLineDelimiters) {
      boolean _equals = Objects.equal(command.text, lineDelimiter);
      if (_equals) {
        try {
          final int line = document.getLineOfOffset(command.offset);
          final int lineStart = document.getLineOffset(line);
          String _get = document.get(lineStart, 3);
          boolean _notEquals = (!Objects.equal(_get, "def"));
          if (_notEquals) {
            BigDecimal computedResult = this.computeResult(document, command);
            if ((computedResult != null)) {
              command.text = (((lineDelimiter + "// = ") + computedResult) + lineDelimiter);
            }
          }
        } catch (final Throwable _t) {
          if (_t instanceof BadLocationException) {
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
  }
  
  private BigDecimal computeResult(final IDocument document, final DocumentCommand command) {
    final IUnitOfWork<BigDecimal, XtextResource> _function = (XtextResource resource) -> {
      final Evaluation stmt = this.findEvaluation(command, resource);
      if ((stmt == null)) {
        return null;
      }
      return this.evaluate(stmt);
    };
    return ((IXtextDocument) document).<BigDecimal>tryReadOnly(_function);
  }
  
  protected BigDecimal evaluate(final Evaluation stmt) {
    return new Calculator().evaluate(stmt.getExpression());
  }
  
  protected Evaluation findEvaluation(final DocumentCommand command, final XtextResource state) {
    boolean _isEmpty = state.getContents().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      org.eclipse.xtext.example.arithmetics.arithmetics.Module m = IterableExtensions.<org.eclipse.xtext.example.arithmetics.arithmetics.Module>head(Iterables.<org.eclipse.xtext.example.arithmetics.arithmetics.Module>filter(state.getContents(), org.eclipse.xtext.example.arithmetics.arithmetics.Module.class));
      Iterable<Evaluation> _filter = Iterables.<Evaluation>filter(m.getStatements(), Evaluation.class);
      for (final Evaluation evaluation : _filter) {
        {
          ICompositeNode node = NodeModelUtils.getNode(evaluation);
          if (((node.getOffset() <= command.offset) && ((node.getOffset() + node.getLength()) >= command.offset))) {
            return evaluation;
          }
        }
      }
    }
    return null;
  }
}
