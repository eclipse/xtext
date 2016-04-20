/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.presentation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.psi.PsiElement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Icon;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.idea.presentation.XtendJvmItemPresentationProvider;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
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
public class XtendItemPresentationProvider extends XtendJvmItemPresentationProvider {
  @Inject
  private UIStrings uiStrings;
  
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private OperatorMapping operatorMapping;
  
  protected Icon _image(final XtendTypeDeclaration element) {
    JvmDeclaredType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    return this.image(_inferredType);
  }
  
  protected Icon _image(final XtendFunction element) {
    JvmOperation _directlyInferredOperation = this._iXtendJvmAssociations.getDirectlyInferredOperation(element);
    return this.image(_directlyInferredOperation);
  }
  
  protected Icon _image(final XtendConstructor element) {
    JvmConstructor _inferredConstructor = this._iXtendJvmAssociations.getInferredConstructor(element);
    return this.image(_inferredConstructor);
  }
  
  protected Icon _image(final XtendField element) {
    JvmField _jvmField = this._iXtendJvmAssociations.getJvmField(element);
    return this.image(_jvmField);
  }
  
  protected Icon _image(final XtendEnumLiteral element) {
    JvmField _jvmField = this._iXtendJvmAssociations.getJvmField(element);
    return this.image(_jvmField);
  }
  
  protected String _text(final XtendFile element) {
    Resource _eResource = element.eResource();
    URI _uRI = _eResource.getURI();
    URI _trimFileExtension = _uRI.trimFileExtension();
    return _trimFileExtension.lastSegment();
  }
  
  protected String _text(final XtendClass element) {
    String _name = element.getName();
    String _xifexpression = null;
    EList<JvmTypeParameter> _typeParameters = element.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      EList<JvmTypeParameter> _typeParameters_1 = element.getTypeParameters();
      _xifexpression = this.uiStrings.typeParameters(_typeParameters_1);
    }
    return (_name + _xifexpression);
  }
  
  protected String _text(final XtendInterface element) {
    String _name = element.getName();
    String _xifexpression = null;
    EList<JvmTypeParameter> _typeParameters = element.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      EList<JvmTypeParameter> _typeParameters_1 = element.getTypeParameters();
      _xifexpression = this.uiStrings.typeParameters(_typeParameters_1);
    }
    return (_name + _xifexpression);
  }
  
  protected String _text(final AnonymousClass element) {
    JvmGenericType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    return this.text(_inferredType);
  }
  
  protected String _text(final XtendConstructor element) {
    JvmConstructor _inferredConstructor = this._iXtendJvmAssociations.getInferredConstructor(element);
    String _parameters = this.uiStrings.parameters(_inferredConstructor);
    return ("new" + _parameters);
  }
  
  protected String _text(final XtendFunction element) {
    final String simpleName = element.getName();
    boolean _notEquals = (!Objects.equal(simpleName, null));
    if (_notEquals) {
      final QualifiedName qnName = QualifiedName.create(simpleName);
      final QualifiedName operator = this.operatorMapping.getOperator(qnName);
      boolean _notEquals_1 = (!Objects.equal(operator, null));
      if (_notEquals_1) {
        String _firstSegment = operator.getFirstSegment();
        JvmOperation _directlyInferredOperation = this._iXtendJvmAssociations.getDirectlyInferredOperation(element);
        String _signature = this.signature(_firstSegment, _directlyInferredOperation);
        String _plus = (_signature + " (");
        String _plus_1 = (_plus + simpleName);
        return (_plus_1 + ")");
      }
    }
    String _name = element.getName();
    JvmOperation _directlyInferredOperation_1 = this._iXtendJvmAssociations.getDirectlyInferredOperation(element);
    return this.signature(_name, _directlyInferredOperation_1);
  }
  
  protected String _text(final XtendField element) {
    String _xblockexpression = null;
    {
      if ((Objects.equal(element.getName(), null) && element.isExtension())) {
        JvmTypeReference _type = element.getType();
        return this.uiStrings.referenceToString(_type, "extension");
      }
      final JvmTypeReference fieldType = this.getDisplayedType(element);
      boolean _notEquals = (!Objects.equal(fieldType, null));
      if (_notEquals) {
        final String type = this.uiStrings.referenceToString(fieldType, "");
        int _length = type.length();
        boolean _notEquals_1 = (_length != 0);
        if (_notEquals_1) {
          String _name = element.getName();
          String _plus = (_name + " : ");
          return (_plus + type);
        }
      }
      _xblockexpression = element.getName();
    }
    return _xblockexpression;
  }
  
  protected String _text(final XtendEnumLiteral element) {
    return element.getName();
  }
  
  protected String _text(final XtendParameter element) {
    JvmTypeReference _parameterType = element.getParameterType();
    String _simpleName = _parameterType.getSimpleName();
    String _plus = (_simpleName + " ");
    String _name = element.getName();
    return (_plus + _name);
  }
  
  protected JvmTypeReference getDisplayedType(final XtendField field) {
    Object _xblockexpression = null;
    {
      final JvmField jvmField = this._iXtendJvmAssociations.getJvmField(field);
      boolean _notEquals = (!Objects.equal(jvmField, null));
      if (_notEquals) {
        return jvmField.getType();
      } else {
        Set<EObject> _jvmElements = this._iXtendJvmAssociations.getJvmElements(field);
        final Iterator<EObject> i = _jvmElements.iterator();
        boolean _hasNext = i.hasNext();
        if (_hasNext) {
          final EObject next = i.next();
          if ((next instanceof JvmOperation)) {
            return ((JvmOperation)next).getReturnType();
          }
        }
      }
      _xblockexpression = null;
    }
    return ((JvmTypeReference)_xblockexpression);
  }
  
  public Icon image(final Object element) {
    if (element instanceof XtendConstructor) {
      return _image((XtendConstructor)element);
    } else if (element instanceof XtendFunction) {
      return _image((XtendFunction)element);
    } else if (element instanceof XtendEnumLiteral) {
      return _image((XtendEnumLiteral)element);
    } else if (element instanceof XtendField) {
      return _image((XtendField)element);
    } else if (element instanceof XtendTypeDeclaration) {
      return _image((XtendTypeDeclaration)element);
    } else if (element instanceof IResolvedConstructor) {
      return _image((IResolvedConstructor)element);
    } else if (element instanceof IResolvedOperation) {
      return _image((IResolvedOperation)element);
    } else if (element instanceof PsiElement) {
      return _image((PsiElement)element);
    } else if (element instanceof EObject) {
      return _image((EObject)element);
    } else if (element instanceof IResolvedField) {
      return _image((IResolvedField)element);
    } else if (element == null) {
      return _image((Void)null);
    } else if (element != null) {
      return _image(element);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
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
    } else if (element instanceof AnonymousClass) {
      return _text((AnonymousClass)element);
    } else if (element instanceof XtendClass) {
      return _text((XtendClass)element);
    } else if (element instanceof XtendConstructor) {
      return _text((XtendConstructor)element);
    } else if (element instanceof XtendFunction) {
      return _text((XtendFunction)element);
    } else if (element instanceof XtendInterface) {
      return _text((XtendInterface)element);
    } else if (element instanceof XtendEnumLiteral) {
      return _text((XtendEnumLiteral)element);
    } else if (element instanceof XtendField) {
      return _text((XtendField)element);
    } else if (element instanceof JvmFormalParameter) {
      return _text((JvmFormalParameter)element);
    } else if (element instanceof XtendParameter) {
      return _text((XtendParameter)element);
    } else if (element instanceof XVariableDeclaration) {
      return _text((XVariableDeclaration)element);
    } else if (element instanceof XtendFile) {
      return _text((XtendFile)element);
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
