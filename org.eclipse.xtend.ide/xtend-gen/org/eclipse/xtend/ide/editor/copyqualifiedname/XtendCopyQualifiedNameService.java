/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.editor.copyqualifiedname;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.ui.editor.copyqualifiedname.XbaseCopyQualifiedNameService;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
@SuppressWarnings("all")
public class XtendCopyQualifiedNameService extends XbaseCopyQualifiedNameService {
  protected String _getQualifiedName(final XtendFunction it, final EObject context) {
    return this.toQualifiedName(it);
  }

  protected String _getQualifiedName(final XtendFunction it, final Void context) {
    return this.toQualifiedName(it);
  }

  protected String toQualifiedName(final XtendFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    String _fullyQualifiedName = this.toFullyQualifiedName(it);
    _builder.append(_fullyQualifiedName);
    _builder.append("(");
    final Function1<XtendParameter, String> _function = (XtendParameter it_1) -> {
      return it_1.getParameterType().getSimpleName();
    };
    CharSequence _qualifiedNames = this.<XtendParameter>toQualifiedNames(it.getParameters(), _function);
    _builder.append(_qualifiedNames);
    _builder.append(")");
    return _builder.toString();
  }

  protected String _getQualifiedName(final XtendConstructor it, final EObject context) {
    return this.toQualifiedName(it);
  }

  protected String _getQualifiedName(final XtendConstructor it, final Void context) {
    return this.toQualifiedName(it);
  }

  protected String toQualifiedName(final XtendConstructor it) {
    StringConcatenation _builder = new StringConcatenation();
    String _fullyQualifiedName = this.toFullyQualifiedName(it);
    _builder.append(_fullyQualifiedName);
    _builder.append("(");
    final Function1<XtendParameter, String> _function = (XtendParameter it_1) -> {
      return it_1.getParameterType().getSimpleName();
    };
    CharSequence _qualifiedNames = this.<XtendParameter>toQualifiedNames(it.getParameters(), _function);
    _builder.append(_qualifiedNames);
    _builder.append(")");
    return _builder.toString();
  }

  public String getQualifiedName(final EObject it, final EObject context) {
    if (it instanceof JvmConstructor
         && context instanceof XConstructorCall) {
      return _getQualifiedName((JvmConstructor)it, (XConstructorCall)context);
    } else if (it instanceof JvmExecutable
         && context instanceof XAbstractFeatureCall) {
      return _getQualifiedName((JvmExecutable)it, (XAbstractFeatureCall)context);
    } else if (it instanceof JvmExecutable
         && context != null) {
      return _getQualifiedName((JvmExecutable)it, context);
    } else if (it instanceof JvmExecutable
         && context == null) {
      return _getQualifiedName((JvmExecutable)it, (Void)null);
    } else if (it instanceof XtendConstructor
         && context != null) {
      return _getQualifiedName((XtendConstructor)it, context);
    } else if (it instanceof XtendFunction
         && context != null) {
      return _getQualifiedName((XtendFunction)it, context);
    } else if (it instanceof XtendConstructor
         && context == null) {
      return _getQualifiedName((XtendConstructor)it, (Void)null);
    } else if (it instanceof XtendFunction
         && context == null) {
      return _getQualifiedName((XtendFunction)it, (Void)null);
    } else if (it != null
         && context != null) {
      return _getQualifiedName(it, context);
    } else if (it != null
         && context == null) {
      return _getQualifiedName(it, (Void)null);
    } else if (it == null
         && context != null) {
      return _getQualifiedName((Void)null, context);
    } else {
      return _getQualifiedName((Void)null, (Void)null);
    }
  }
}
