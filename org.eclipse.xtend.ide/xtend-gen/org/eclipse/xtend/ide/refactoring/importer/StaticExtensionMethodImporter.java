/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.refactoring.importer;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter;

/**
 * Computes changes necessary on a method call to use with a static extension import.
 * 
 * e.g.:<br>
 * <pre>
 * // before
 * import test.other.Other
 * 
 * Other.doSomething('test')
 * 
 * // after
 * import static extension test.other.Other.doSomething
 * 
 * 'test'.doSomething()
 * </pre>
 * 
 * @author vivien.jovet - Initial contribution and API
 */
@SuppressWarnings("all")
public class StaticExtensionMethodImporter extends StaticMethodImporter {
  @Override
  protected boolean useExtension() {
    return true;
  }

  @Override
  protected void computeChange(final XMemberFeatureCall call, final DocumentRewriter rewriter) {
    try {
      boolean _isEmpty = call.getMemberCallArguments().isEmpty();
      if (_isEmpty) {
        super.computeChange(call, rewriter);
      } else {
        final XExpression firstArg = IterableExtensions.<XExpression>head(call.getMemberCallArguments());
        final ICompositeNode firstArgNode = NodeModelUtils.findActualNodeFor(firstArg);
        final String firstArgText = rewriter.getDocument().get(firstArgNode.getOffset(), firstArgNode.getLength());
        int _xifexpression = (int) 0;
        int _size = call.getMemberCallArguments().size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          int _xblockexpression = (int) 0;
          {
            final ICompositeNode secondArgNode = NodeModelUtils.findActualNodeFor(call.getMemberCallArguments().get(1));
            int _offset = secondArgNode.getOffset();
            int _offset_1 = firstArgNode.getOffset();
            _xblockexpression = (_offset - _offset_1);
          }
          _xifexpression = _xblockexpression;
        } else {
          _xifexpression = firstArgNode.getLength();
        }
        final int replaceLength = _xifexpression;
        final ICompositeNode memberNode = NodeModelUtils.findActualNodeFor(call.getMemberCallTarget());
        String _xifexpression_1 = null;
        boolean _shouldWrap = this.shouldWrap(firstArg);
        if (_shouldWrap) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("(");
          _builder.append(firstArgText);
          _builder.append(")");
          _xifexpression_1 = _builder.toString();
        } else {
          _xifexpression_1 = firstArgText;
        }
        final String replaceText = _xifexpression_1;
        try {
          rewriter.newSection(firstArgNode.getOffset(), replaceLength);
          rewriter.newSection(memberNode.getOffset(), memberNode.getLength()).append(replaceText);
        } catch (final Throwable _t) {
          if (_t instanceof IllegalArgumentException) {
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Returns true if the expression should be wrapped in ( )
   * in order to accept a static extension call.
   */
  private boolean shouldWrap(final XExpression expression) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (expression instanceof XMemberFeatureCall) {
      _matched=true;
    }
    if (!_matched) {
      if (expression instanceof XFeatureCall) {
        _matched=true;
      }
    }
    if (_matched) {
      _switchResult = false;
    }
    if (!_matched) {
      if (expression instanceof XAbstractFeatureCall) {
        _matched=true;
      }
      if (!_matched) {
        if (expression instanceof XSwitchExpression) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (expression instanceof XTryCatchFinallyExpression) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (expression instanceof XSynchronizedExpression) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (expression instanceof XIfExpression) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = true;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
