/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.presentation;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.idea.presentation.XbaseItemPresentationProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedField;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendJvmItemPresentationProvider extends XbaseItemPresentationProvider {
  @Inject
  private UIStrings uiStrings;
  
  @Override
  protected String _text(final JvmGenericType genericType) {
    String _xblockexpression = null;
    {
      final boolean local = genericType.isLocal();
      if (local) {
        EList<JvmTypeReference> _superTypes = genericType.getSuperTypes();
        final JvmTypeReference supertype = IterableExtensions.<JvmTypeReference>last(_superTypes);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new ");
        String _simpleName = supertype.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append("() {...}");
        return _builder.toString();
      }
      String _simpleName_1 = genericType.getSimpleName();
      String _xifexpression = null;
      EList<JvmTypeParameter> _typeParameters = genericType.getTypeParameters();
      boolean _isEmpty = _typeParameters.isEmpty();
      if (_isEmpty) {
        _xifexpression = "";
      } else {
        EList<JvmTypeParameter> _typeParameters_1 = genericType.getTypeParameters();
        _xifexpression = this.uiStrings.typeParameters(_typeParameters_1);
      }
      _xblockexpression = (_simpleName_1 + _xifexpression);
    }
    return _xblockexpression;
  }
  
  protected String _text(final JvmEnumerationLiteral element) {
    return element.getSimpleName();
  }
  
  public String text(final Object element) {
    if (element instanceof JvmConstructor) {
      return _text((JvmConstructor)element);
    } else if (element instanceof JvmEnumerationLiteral) {
      return _text((JvmEnumerationLiteral)element);
    } else if (element instanceof JvmOperation) {
      return _text((JvmOperation)element);
    } else if (element instanceof JvmField) {
      return _text((JvmField)element);
    } else if (element instanceof JvmGenericType) {
      return _text((JvmGenericType)element);
    } else if (element instanceof JvmFormalParameter) {
      return _text((JvmFormalParameter)element);
    } else if (element instanceof XVariableDeclaration) {
      return _text((XVariableDeclaration)element);
    } else if (element instanceof IResolvedConstructor) {
      return _text((IResolvedConstructor)element);
    } else if (element instanceof IResolvedOperation) {
      return _text((IResolvedOperation)element);
    } else if (element instanceof XImportDeclaration) {
      return _text((XImportDeclaration)element);
    } else if (element instanceof XImportSection) {
      return _text((XImportSection)element);
    } else if (element instanceof EObject) {
      return _text((EObject)element);
    } else if (element instanceof IResolvedField) {
      return _text((IResolvedField)element);
    } else if (element == null) {
      return _text((Void)null);
    } else if (element != null) {
      return _text(element);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
}
