/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.labeling;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Iterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtend.core.jvmmodel.DispatchHelper;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationType;
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
import org.eclipse.xtext.xbase.ui.labeling.XbaseImageAdornments;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * Provides labels for Xtend elements.
 * 
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class XtendLabelProvider extends XtendJvmLabelProvider {
  @Inject
  private UIStrings uiStrings;

  @Inject
  private XtendImages images;

  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;

  @Inject
  private XbaseImageAdornments adornments;

  @Inject
  @Extension
  private DispatchHelper _dispatchHelper;

  @Inject
  private OperatorMapping operatorMapping;

  @Inject
  public XtendLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }

  protected ImageDescriptor _imageDescriptor(final XtendFile element) {
    return this.images.forFile();
  }

  protected ImageDescriptor _imageDescriptor(final XtendClass element) {
    return this.images.forClass(element.getVisibility(), this.adornments.get(this._iXtendJvmAssociations.getInferredType(element)));
  }

  protected ImageDescriptor _imageDescriptor(final XtendInterface element) {
    return this.images.forInterface(element.getVisibility(), this.adornments.get(this._iXtendJvmAssociations.getInferredType(element)));
  }

  protected ImageDescriptor _imageDescriptor(final XtendEnum element) {
    return this.images.forEnum(element.getVisibility(), this.adornments.get(this._iXtendJvmAssociations.getInferredType(element)));
  }

  protected ImageDescriptor _imageDescriptor(final XtendAnnotationType element) {
    return this.images.forAnnotation(element.getVisibility(), this.adornments.get(this._iXtendJvmAssociations.getInferredType(element)));
  }

  protected ImageDescriptor _imageDescriptor(final XtendFunction element) {
    ImageDescriptor _xblockexpression = null;
    {
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(element);
      ImageDescriptor _xifexpression = null;
      if ((operation != null)) {
        _xifexpression = this.images.forOperation(element.getVisibility(), this.adornments.get(operation));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  protected ImageDescriptor _imageDescriptor(final AnonymousClass element) {
    return this.images.forClass(this._iXtendJvmAssociations.getInferredType(element).getVisibility(), this.adornments.get(this._iXtendJvmAssociations.getInferredType(element)));
  }

  @Override
  protected ImageDescriptor _imageDescriptor(final JvmOperation operation) {
    ImageDescriptor _xifexpression = null;
    boolean _isDispatcherFunction = this._dispatchHelper.isDispatcherFunction(operation);
    if (_isDispatcherFunction) {
      _xifexpression = this.images.forDispatcherFunction(operation.getVisibility(), this.adornments.get(operation));
    } else {
      _xifexpression = this.images.forOperation(operation.getVisibility(), this.adornments.get(operation));
    }
    return _xifexpression;
  }

  protected ImageDescriptor _imageDescriptor(final XtendConstructor element) {
    return this.images.forConstructor(element.getVisibility(), this.adornments.get(this._iXtendJvmAssociations.getInferredConstructor(element)));
  }

  protected ImageDescriptor _imageDescriptor(final XtendField element) {
    return this.images.forField(element.getVisibility(), this.adornments.get(this._iXtendJvmAssociations.getJvmField(element)));
  }

  protected ImageDescriptor _imageDescriptor(final XtendEnumLiteral element) {
    return this.images.forField(element.getVisibility(), this.adornments.get(this._iXtendJvmAssociations.getJvmField(element)));
  }

  protected String text(final XtendFile element) {
    return element.eResource().getURI().trimFileExtension().lastSegment();
  }

  protected String text(final XtendClass element) {
    String _name = element.getName();
    String _xifexpression = null;
    boolean _isEmpty = element.getTypeParameters().isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      _xifexpression = this.uiStrings.typeParameters(element.getTypeParameters());
    }
    return (_name + _xifexpression);
  }

  protected String text(final XtendInterface element) {
    String _name = element.getName();
    String _xifexpression = null;
    boolean _isEmpty = element.getTypeParameters().isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      _xifexpression = this.uiStrings.typeParameters(element.getTypeParameters());
    }
    return (_name + _xifexpression);
  }

  protected String text(final AnonymousClass element) {
    return this.text(this._iXtendJvmAssociations.getInferredType(element));
  }

  protected String text(final XtendConstructor element) {
    String _parameters = this.uiStrings.parameters(this._iXtendJvmAssociations.getInferredConstructor(element));
    return ("new" + _parameters);
  }

  protected StyledString text(final XtendFunction element) {
    final String simpleName = element.getName();
    if ((simpleName != null)) {
      final QualifiedName qnName = QualifiedName.create(simpleName);
      final QualifiedName operator = this.operatorMapping.getOperator(qnName);
      if ((operator != null)) {
        final StyledString result = this.signature(operator.getFirstSegment(), this._iXtendJvmAssociations.getDirectlyInferredOperation(element));
        result.append(((" (" + simpleName) + ")"), StyledString.COUNTER_STYLER);
        return result;
      }
    }
    return this.signature(element.getName(), this._iXtendJvmAssociations.getDirectlyInferredOperation(element));
  }

  protected StyledString text(final XtendField element) {
    StyledString _xblockexpression = null;
    {
      if (((element.getName() == null) && element.isExtension())) {
        String _referenceToString = this.uiStrings.referenceToString(element.getType(), "extension");
        return new StyledString(_referenceToString, 
          StyledString.DECORATIONS_STYLER);
      }
      final JvmTypeReference fieldType = this.getDisplayedType(element);
      if ((fieldType != null)) {
        final String type = this.uiStrings.referenceToString(fieldType, "");
        int _length = type.length();
        boolean _notEquals = (_length != 0);
        if (_notEquals) {
          String _name = element.getName();
          StyledString _styledString = new StyledString(_name);
          StyledString _styledString_1 = new StyledString((" : " + type), StyledString.DECORATIONS_STYLER);
          return _styledString.append(_styledString_1);
        }
      }
      String _name_1 = element.getName();
      _xblockexpression = new StyledString(_name_1);
    }
    return _xblockexpression;
  }

  protected String text(final XtendEnumLiteral element) {
    return element.getName();
  }

  protected String text(final XtendParameter element) {
    String _simpleName = element.getParameterType().getSimpleName();
    String _plus = (_simpleName + " ");
    String _name = element.getName();
    return (_plus + _name);
  }

  protected JvmTypeReference getDisplayedType(final XtendField field) {
    Object _xblockexpression = null;
    {
      final JvmField jvmField = this._iXtendJvmAssociations.getJvmField(field);
      if ((jvmField != null)) {
        return jvmField.getType();
      } else {
        final Iterator<EObject> i = this._iXtendJvmAssociations.getJvmElements(field).iterator();
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

  @Override
  protected ImageDescriptor imageDescriptor(final Object operation) {
    if (operation instanceof JvmConstructor) {
      return _imageDescriptor((JvmConstructor)operation);
    } else if (operation instanceof JvmOperation) {
      return _imageDescriptor((JvmOperation)operation);
    } else if (operation instanceof JvmAnnotationType) {
      return _imageDescriptor((JvmAnnotationType)operation);
    } else if (operation instanceof JvmEnumerationType) {
      return _imageDescriptor((JvmEnumerationType)operation);
    } else if (operation instanceof JvmField) {
      return _imageDescriptor((JvmField)operation);
    } else if (operation instanceof JvmGenericType) {
      return _imageDescriptor((JvmGenericType)operation);
    } else if (operation instanceof AnonymousClass) {
      return _imageDescriptor((AnonymousClass)operation);
    } else if (operation instanceof XtendAnnotationType) {
      return _imageDescriptor((XtendAnnotationType)operation);
    } else if (operation instanceof XtendClass) {
      return _imageDescriptor((XtendClass)operation);
    } else if (operation instanceof XtendConstructor) {
      return _imageDescriptor((XtendConstructor)operation);
    } else if (operation instanceof XtendEnum) {
      return _imageDescriptor((XtendEnum)operation);
    } else if (operation instanceof XtendFunction) {
      return _imageDescriptor((XtendFunction)operation);
    } else if (operation instanceof XtendInterface) {
      return _imageDescriptor((XtendInterface)operation);
    } else if (operation instanceof JvmTypeParameter) {
      return _imageDescriptor((JvmTypeParameter)operation);
    } else if (operation instanceof XtendEnumLiteral) {
      return _imageDescriptor((XtendEnumLiteral)operation);
    } else if (operation instanceof XtendField) {
      return _imageDescriptor((XtendField)operation);
    } else if (operation instanceof JvmFormalParameter) {
      return _imageDescriptor((JvmFormalParameter)operation);
    } else if (operation instanceof XVariableDeclaration) {
      return _imageDescriptor((XVariableDeclaration)operation);
    } else if (operation instanceof XtendFile) {
      return _imageDescriptor((XtendFile)operation);
    } else if (operation instanceof IResolvedConstructor) {
      return _imageDescriptor((IResolvedConstructor)operation);
    } else if (operation instanceof IResolvedOperation) {
      return _imageDescriptor((IResolvedOperation)operation);
    } else if (operation instanceof XImportDeclaration) {
      return _imageDescriptor((XImportDeclaration)operation);
    } else if (operation instanceof XImportSection) {
      return _imageDescriptor((XImportSection)operation);
    } else if (operation instanceof IResolvedField) {
      return _imageDescriptor((IResolvedField)operation);
    } else if (operation != null) {
      return _imageDescriptor(operation);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(operation).toString());
    }
  }
}
