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
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.labeling.XtendImages;
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
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImageAdornments;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * Provides labels for Xtend elements.
 * 
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class XtendLabelProvider extends XbaseLabelProvider {
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
  public XtendLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendFile element) {
    ImageDescriptor _forFile = this.images.forFile();
    return _forFile;
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendClass element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmGenericType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    int _get = this.adornments.get(_inferredType);
    ImageDescriptor _forClass = this.images.forClass(_visibility, _get);
    return _forClass;
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendInterface element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmGenericType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    int _get = this.adornments.get(_inferredType);
    ImageDescriptor _forInterface = this.images.forInterface(_visibility, _get);
    return _forInterface;
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendEnum element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmDeclaredType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    int _get = this.adornments.get(_inferredType);
    ImageDescriptor _forEnum = this.images.forEnum(_visibility, _get);
    return _forEnum;
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendAnnotationType element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmDeclaredType _inferredType = this._iXtendJvmAssociations.getInferredType(element);
    int _get = this.adornments.get(_inferredType);
    ImageDescriptor _forAnnotation = this.images.forAnnotation(_visibility, _get);
    return _forAnnotation;
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendFunction element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmOperation _directlyInferredOperation = this._iXtendJvmAssociations.getDirectlyInferredOperation(element);
    int _get = this.adornments.get(_directlyInferredOperation);
    ImageDescriptor _forOperation = this.images.forOperation(_visibility, _get);
    return _forOperation;
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmOperation operation) {
    ImageDescriptor _xifexpression = null;
    boolean _isDispatcherFunction = this._dispatchHelper.isDispatcherFunction(operation);
    if (_isDispatcherFunction) {
      JvmVisibility _visibility = operation.getVisibility();
      int _get = this.adornments.get(operation);
      ImageDescriptor _forDispatcherFunction = this.images.forDispatcherFunction(_visibility, _get);
      _xifexpression = _forDispatcherFunction;
    } else {
      JvmVisibility _visibility_1 = operation.getVisibility();
      int _get_1 = this.adornments.get(operation);
      ImageDescriptor _forOperation = this.images.forOperation(_visibility_1, _get_1);
      _xifexpression = _forOperation;
    }
    return _xifexpression;
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendConstructor element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmConstructor _inferredConstructor = this._iXtendJvmAssociations.getInferredConstructor(element);
    int _get = this.adornments.get(_inferredConstructor);
    ImageDescriptor _forConstructor = this.images.forConstructor(_visibility, _get);
    return _forConstructor;
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendField element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmField _jvmField = this._iXtendJvmAssociations.getJvmField(element);
    int _get = this.adornments.get(_jvmField);
    ImageDescriptor _forField = this.images.forField(_visibility, _get);
    return _forField;
  }
  
  protected ImageDescriptor _imageDescriptor(final XtendEnumLiteral element) {
    JvmVisibility _visibility = element.getVisibility();
    JvmField _jvmField = this._iXtendJvmAssociations.getJvmField(element);
    int _get = this.adornments.get(_jvmField);
    ImageDescriptor _forField = this.images.forField(_visibility, _get);
    return _forField;
  }
  
  protected String text(final XtendFile element) {
    Resource _eResource = element.eResource();
    URI _uRI = _eResource.getURI();
    URI _trimFileExtension = _uRI.trimFileExtension();
    String _lastSegment = _trimFileExtension.lastSegment();
    return _lastSegment;
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
      String _typeParameters_2 = this.uiStrings.typeParameters(_typeParameters_1);
      _xifexpression = _typeParameters_2;
    }
    String _plus = (_name + _xifexpression);
    return _plus;
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
      String _typeParameters_2 = this.uiStrings.typeParameters(_typeParameters_1);
      _xifexpression = _typeParameters_2;
    }
    String _plus = (_name + _xifexpression);
    return _plus;
  }
  
  protected String text(final XtendTypeDeclaration element) {
    String _name = element.getName();
    return _name;
  }
  
  protected String text(final XtendConstructor element) {
    JvmConstructor _inferredConstructor = this._iXtendJvmAssociations.getInferredConstructor(element);
    String _parameters = this.uiStrings.parameters(_inferredConstructor);
    String _plus = ("new" + _parameters);
    return _plus;
  }
  
  protected StyledString text(final XtendFunction element) {
    String _name = element.getName();
    JvmOperation _directlyInferredOperation = this._iXtendJvmAssociations.getDirectlyInferredOperation(element);
    StyledString _signature = this.signature(_name, _directlyInferredOperation);
    return _signature;
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
        _and = (_equals && _isExtension);
      }
      if (_and) {
        JvmTypeReference _type = element.getType();
        String _referenceToString = this.uiStrings.referenceToString(_type, "extension");
        StyledString _styledString = new StyledString(_referenceToString, StyledString.DECORATIONS_STYLER);
        return _styledString;
      }
      final JvmTypeReference fieldType = this.getDisplayedType(element);
      boolean _notEquals = (!Objects.equal(fieldType, null));
      if (_notEquals) {
        final String type = this.uiStrings.referenceToString(fieldType, "");
        int _length = type.length();
        boolean _notEquals_1 = (_length != 0);
        if (_notEquals_1) {
          String _name_1 = element.getName();
          StyledString _styledString_1 = new StyledString(_name_1);
          String _plus = (" : " + type);
          StyledString _styledString_2 = new StyledString(_plus, StyledString.DECORATIONS_STYLER);
          return _styledString_1.append(_styledString_2);
        }
      }
      String _name_2 = element.getName();
      StyledString _styledString_3 = new StyledString(_name_2);
      _xblockexpression = (_styledString_3);
    }
    return _xblockexpression;
  }
  
  protected String text(final XtendEnumLiteral element) {
    String _name = element.getName();
    return _name;
  }
  
  protected JvmTypeReference getDisplayedType(final XtendField field) {
    JvmTypeReference _xblockexpression = null;
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
            return ((JvmOperation) next).getReturnType();
          }
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected ImageDescriptor imageDescriptor(final Object constructor) {
    if (constructor instanceof JvmConstructor) {
      return _imageDescriptor((JvmConstructor)constructor);
    } else if (constructor instanceof JvmOperation) {
      return _imageDescriptor((JvmOperation)constructor);
    } else if (constructor instanceof JvmAnnotationType) {
      return _imageDescriptor((JvmAnnotationType)constructor);
    } else if (constructor instanceof JvmEnumerationType) {
      return _imageDescriptor((JvmEnumerationType)constructor);
    } else if (constructor instanceof JvmField) {
      return _imageDescriptor((JvmField)constructor);
    } else if (constructor instanceof JvmGenericType) {
      return _imageDescriptor((JvmGenericType)constructor);
    } else if (constructor instanceof XtendAnnotationType) {
      return _imageDescriptor((XtendAnnotationType)constructor);
    } else if (constructor instanceof XtendClass) {
      return _imageDescriptor((XtendClass)constructor);
    } else if (constructor instanceof XtendEnum) {
      return _imageDescriptor((XtendEnum)constructor);
    } else if (constructor instanceof XtendInterface) {
      return _imageDescriptor((XtendInterface)constructor);
    } else if (constructor instanceof JvmTypeParameter) {
      return _imageDescriptor((JvmTypeParameter)constructor);
    } else if (constructor instanceof XtendConstructor) {
      return _imageDescriptor((XtendConstructor)constructor);
    } else if (constructor instanceof XtendEnumLiteral) {
      return _imageDescriptor((XtendEnumLiteral)constructor);
    } else if (constructor instanceof XtendField) {
      return _imageDescriptor((XtendField)constructor);
    } else if (constructor instanceof XtendFunction) {
      return _imageDescriptor((XtendFunction)constructor);
    } else if (constructor instanceof JvmFormalParameter) {
      return _imageDescriptor((JvmFormalParameter)constructor);
    } else if (constructor instanceof XVariableDeclaration) {
      return _imageDescriptor((XVariableDeclaration)constructor);
    } else if (constructor instanceof XtendFile) {
      return _imageDescriptor((XtendFile)constructor);
    } else if (constructor instanceof XImportDeclaration) {
      return _imageDescriptor((XImportDeclaration)constructor);
    } else if (constructor instanceof XImportSection) {
      return _imageDescriptor((XImportSection)constructor);
    } else if (constructor != null) {
      return _imageDescriptor(constructor);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(constructor).toString());
    }
  }
}
