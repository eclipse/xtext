package org.eclipse.xtend.ide.labeling;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.xtend.ide.labeling.XtendImages;
import org.eclipse.xtend.ide.labeling.XtendJvmLabelProvider;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
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
    JvmVisibility _visibility = element.getVisibility();
    JvmGenericType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    int _get = this.adornments.get(_inferredType);
    return this.images.forClass(_visibility, _get);
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendInterface element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmGenericType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    int _get = this.adornments.get(_inferredType);
    return this.images.forInterface(_visibility, _get);
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendEnum element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmDeclaredType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    int _get = this.adornments.get(_inferredType);
    return this.images.forEnum(_visibility, _get);
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendAnnotationType element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmDeclaredType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    int _get = this.adornments.get(_inferredType);
    return this.images.forAnnotation(_visibility, _get);
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendFunction element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmOperation _directlyInferredOperation = this._iXtendJvmAssociations.getDirectlyInferredOperation(element);
    int _get = this.adornments.get(_directlyInferredOperation);
    return this.images.forOperation(_visibility, _get);
  }
  
  protected ImageDescriptor _imageDescriptor(final AnonymousClass element) {
    JvmGenericType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    JvmVisibility _visibility = _inferredType.getVisibility();
    JvmGenericType _inferredType_1 = this._iXtendJvmAssociations.getInferredType(element);
    int _get = this.adornments.get(_inferredType_1);
    return this.images.forClass(_visibility, _get);
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmOperation operation) {
    ImageDescriptor _xifexpression = null;
    boolean _isDispatcherFunction = this._dispatchHelper.isDispatcherFunction(operation);
    if (_isDispatcherFunction) {
      JvmVisibility _visibility = operation.getVisibility();
      int _get = this.adornments.get(operation);
      _xifexpression = this.images.forDispatcherFunction(_visibility, _get);
    } else {
      JvmVisibility _visibility_1 = operation.getVisibility();
      int _get_1 = this.adornments.get(operation);
      _xifexpression = this.images.forOperation(_visibility_1, _get_1);
    }
    return _xifexpression;
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendConstructor element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmConstructor _inferredConstructor = this._iXtendJvmAssociations.getInferredConstructor(element);
    int _get = this.adornments.get(_inferredConstructor);
    return this.images.forConstructor(_visibility, _get);
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendField element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmField _jvmField = this._iXtendJvmAssociations.getJvmField(element);
    int _get = this.adornments.get(_jvmField);
    return this.images.forField(_visibility, _get);
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendEnumLiteral element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmField _jvmField = this._iXtendJvmAssociations.getJvmField(element);
    int _get = this.adornments.get(_jvmField);
    return this.images.forField(_visibility, _get);
  }
  
  protected String text(final XtendFile element) {
    Resource _eResource = element.eResource();
    URI _uRI = _eResource.getURI();
    URI _trimFileExtension = _uRI.trimFileExtension();
    return _trimFileExtension.lastSegment();
  }
  
  protected String text(final XtendClass element) {
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
  
  protected String text(final XtendInterface element) {
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
  
  protected String text(final AnonymousClass element) {
    JvmGenericType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    return this.text(_inferredType);
  }
  
  protected String text(final XtendConstructor element) {
    JvmConstructor _inferredConstructor = this._iXtendJvmAssociations.getInferredConstructor(element);
    String _parameters = this.uiStrings.parameters(_inferredConstructor);
    return ("new" + _parameters);
  }
  
  protected StyledString text(final XtendFunction element) {
    final String simpleName = element.getName();
    boolean _notEquals = (!Objects.equal(simpleName, null));
    if (_notEquals) {
      final QualifiedName qnName = QualifiedName.create(simpleName);
      final QualifiedName operator = this.operatorMapping.getOperator(qnName);
      boolean _notEquals_1 = (!Objects.equal(operator, null));
      if (_notEquals_1) {
        String _firstSegment = operator.getFirstSegment();
        JvmOperation _directlyInferredOperation = this._iXtendJvmAssociations.getDirectlyInferredOperation(element);
        final StyledString result = this.signature(_firstSegment, _directlyInferredOperation);
        result.append(((" (" + simpleName) + ")"), StyledString.COUNTER_STYLER);
        return result;
      }
    }
    String _name = element.getName();
    JvmOperation _directlyInferredOperation_1 = this._iXtendJvmAssociations.getDirectlyInferredOperation(element);
    return this.signature(_name, _directlyInferredOperation_1);
  }
  
  protected StyledString text(final XtendField element) {
    StyledString _xblockexpression = null;
    {
      boolean _and = false;
      String _name = element.getName();
      boolean _equals = Objects.equal(_name, null);
      if (!_equals) {
        _and = false;
      } else {
        boolean _isExtension = element.isExtension();
        _and = _isExtension;
      }
      if (_and) {
        JvmTypeReference _type = element.getType();
        String _referenceToString = this.uiStrings.referenceToString(_type, "extension");
        return new StyledString(_referenceToString, 
          StyledString.DECORATIONS_STYLER);
      }
      final JvmTypeReference fieldType = this.getDisplayedType(element);
      boolean _notEquals = (!Objects.equal(fieldType, null));
      if (_notEquals) {
        final String type = this.uiStrings.referenceToString(fieldType, "");
        int _length = type.length();
        boolean _notEquals_1 = (_length != 0);
        if (_notEquals_1) {
          String _name_1 = element.getName();
          StyledString _styledString = new StyledString(_name_1);
          StyledString _styledString_1 = new StyledString((" : " + type), StyledString.DECORATIONS_STYLER);
          return _styledString.append(_styledString_1);
        }
      }
      String _name_2 = element.getName();
      _xblockexpression = new StyledString(_name_2);
    }
    return _xblockexpression;
  }
  
  protected String text(final XtendEnumLiteral element) {
    return element.getName();
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
    } else if (operation instanceof XImportDeclaration) {
      return _imageDescriptor((XImportDeclaration)operation);
    } else if (operation instanceof XImportSection) {
      return _imageDescriptor((XImportSection)operation);
    } else if (operation != null) {
      return _imageDescriptor(operation);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(operation).toString());
    }
  }
}
