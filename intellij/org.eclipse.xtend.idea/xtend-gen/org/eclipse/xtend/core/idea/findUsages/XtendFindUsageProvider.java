/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.findUsages;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.core.xtend.XtendVariableDeclaration;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.idea.findusages.BaseXtextFindUsageProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFindUsageProvider extends BaseXtextFindUsageProvider {
  @Override
  protected String getType(final EObject object) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (object instanceof XtendEnum) {
        _matched=true;
        _switchResult = "enum";
      }
    }
    if (!_matched) {
      if (object instanceof XtendInterface) {
        _matched=true;
        _switchResult = "interface";
      }
    }
    if (!_matched) {
      if (object instanceof XtendAnnotationType) {
        _matched=true;
        _switchResult = "@interface";
      }
    }
    if (!_matched) {
      if (object instanceof XtendTypeDeclaration) {
        _matched=true;
        _switchResult = "class";
      }
    }
    if (!_matched) {
      if (object instanceof JvmTypeParameter) {
        _matched=true;
        _switchResult = "type parameter";
      }
    }
    if (!_matched) {
      if (object instanceof XtendField) {
        _matched=true;
      }
      if (!_matched) {
        if (object instanceof XtendEnumLiteral) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = "field";
      }
    }
    if (!_matched) {
      if (object instanceof XtendFunction) {
        _matched=true;
        _switchResult = "method";
      }
    }
    if (!_matched) {
      if (object instanceof XtendConstructor) {
        _matched=true;
        _switchResult = "constructor";
      }
    }
    if (!_matched) {
      if (object instanceof XtendParameter) {
        _matched=true;
        _switchResult = "parameter";
      }
    }
    if (!_matched) {
      if (object instanceof XtendVariableDeclaration) {
        _matched=true;
        _switchResult = "variable";
      }
    }
    if (!_matched) {
      _switchResult = super.getType(object);
    }
    return _switchResult;
  }
}
