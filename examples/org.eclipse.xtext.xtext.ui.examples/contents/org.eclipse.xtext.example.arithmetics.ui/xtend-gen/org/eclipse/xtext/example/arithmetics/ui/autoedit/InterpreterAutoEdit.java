/**
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.autoedit;

import java.math.BigDecimal;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;
import org.eclipse.xtext.example.arithmetics.arithmetics.Expression;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.example.arithmetics.arithmetics.Statement;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sven Efftinge - initial contribution and API
 * an interactive interpreter as an {@link IAutoEditStrategy}
 */
@SuppressWarnings("all")
public class InterpreterAutoEdit implements IAutoEditStrategy {
  @Override
  public void customizeDocumentCommand(final IDocument document, final DocumentCommand command) {
    String[] _legalLineDelimiters = document.getLegalLineDelimiters();
    for (final String lineDelimiter : _legalLineDelimiters) {
      boolean _equals = command.text.equals(lineDelimiter);
      if (_equals) {
        int line = 0;
        int lineStart = 0;
        try {
          int _lineOfOffset = document.getLineOfOffset(command.offset);
          line = _lineOfOffset;
          int _lineOffset = document.getLineOffset(line);
          lineStart = _lineOffset;
          String _get = document.get(lineStart, 3);
          boolean _equals_1 = _get.equals("def");
          boolean _not = (!_equals_1);
          if (_not) {
            BigDecimal computedResult = this.computeResult(document, command);
            if ((computedResult != null)) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append(lineDelimiter, "");
              _builder.append("// = ");
              _builder.append(computedResult, "");
              _builder.append(lineDelimiter, "");
              command.text = _builder.toString();
            }
          }
        } catch (final Throwable _t) {
          if (_t instanceof BadLocationException) {
            final BadLocationException e = (BadLocationException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
  }
  
  private BigDecimal computeResult(final IDocument document, final DocumentCommand command) {
    final IUnitOfWork<BigDecimal, XtextResource> _function = (XtextResource state) -> {
      Evaluation stmt = this.findEvaluation(command, state);
      if ((stmt == null)) {
        return null;
      }
      return this.evaluate(stmt);
    };
    return ((IXtextDocument) document).<BigDecimal>readOnly(_function);
  }
  
  protected BigDecimal evaluate(final Evaluation stmt) {
    Calculator _calculator = new Calculator();
    Expression _expression = stmt.getExpression();
    return _calculator.evaluate(_expression);
  }
  
  protected Evaluation findEvaluation(final DocumentCommand command, final XtextResource state) {
    EList<EObject> _contents = state.getContents();
    boolean _isEmpty = _contents.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<EObject> _contents_1 = state.getContents();
      EObject _get = _contents_1.get(0);
      Module m = ((Module) _get);
      EList<Statement> _statements = m.getStatements();
      for (final Statement stmt : _statements) {
        if ((stmt instanceof Evaluation)) {
          ICompositeNode node = NodeModelUtils.getNode(stmt);
          boolean _and = false;
          int _offset = node.getOffset();
          boolean _lessEqualsThan = (_offset <= command.offset);
          if (!_lessEqualsThan) {
            _and = false;
          } else {
            int _offset_1 = node.getOffset();
            int _length = node.getLength();
            int _plus = (_offset_1 + _length);
            boolean _greaterEqualsThan = (_plus >= command.offset);
            _and = _greaterEqualsThan;
          }
          if (_and) {
            return ((Evaluation) stmt);
          }
        }
      }
    }
    return null;
  }
}
