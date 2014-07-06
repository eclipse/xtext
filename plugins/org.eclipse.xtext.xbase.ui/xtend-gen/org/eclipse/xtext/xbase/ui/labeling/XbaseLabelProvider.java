package org.eclipse.xtext.xbase.ui.labeling;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImageAdornments;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages2;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

@SuppressWarnings("all")
public class XbaseLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  private XbaseImages2 images;
  
  @Inject
  private UIStrings uiStrings;
  
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private XbaseImageAdornments adornments;
  
  @Inject
  public XbaseLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  protected ImageDescriptor _imageDescriptor(final XImportSection importSection) {
    return this.images.forImportContainer();
  }
  
  protected ImageDescriptor _imageDescriptor(final XImportDeclaration importDeclaration) {
    return this.images.forImport();
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmGenericType genericType) {
    ImageDescriptor _xifexpression = null;
    boolean _isInterface = genericType.isInterface();
    if (_isInterface) {
      JvmVisibility _visibility = genericType.getVisibility();
      int _get = this.adornments.get(genericType);
      _xifexpression = this.images.forInterface(_visibility, _get);
    } else {
      JvmVisibility _visibility_1 = genericType.getVisibility();
      int _get_1 = this.adornments.get(genericType);
      _xifexpression = this.images.forClass(_visibility_1, _get_1);
    }
    return _xifexpression;
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmEnumerationType enumerationType) {
    JvmVisibility _visibility = enumerationType.getVisibility();
    int _get = this.adornments.get(enumerationType);
    return this.images.forEnum(_visibility, _get);
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmAnnotationType annotationType) {
    JvmVisibility _visibility = annotationType.getVisibility();
    int _get = this.adornments.get(annotationType);
    return this.images.forAnnotation(_visibility, _get);
  }
  
  protected String text(final JvmGenericType genericType) {
    return genericType.getSimpleName();
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmOperation operation) {
    JvmVisibility _visibility = operation.getVisibility();
    int _get = this.adornments.get(operation);
    return this.images.forOperation(_visibility, _get);
  }
  
  protected Object text(final JvmOperation element) {
    String _simpleName = element.getSimpleName();
    return this.signature(_simpleName, element);
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmConstructor constructor) {
    JvmVisibility _visibility = constructor.getVisibility();
    int _get = this.adornments.get(constructor);
    return this.images.forConstructor(_visibility, _get);
  }
  
  protected String text(final JvmConstructor constructor) {
    String _parameters = this.uiStrings.parameters(constructor);
    return ("new" + _parameters);
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmField field) {
    JvmVisibility _visibility = field.getVisibility();
    int _get = this.adornments.get(field);
    return this.images.forField(_visibility, _get);
  }
  
  protected Object text(final JvmField field) {
    String _simpleName = field.getSimpleName();
    String _plus = (_simpleName + " : ");
    JvmTypeReference _type = field.getType();
    String _simpleName_1 = _type.getSimpleName();
    return (_plus + _simpleName_1);
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmFormalParameter parameter) {
    int _get = this.adornments.get(parameter);
    return this.images.forLocalVariable(_get);
  }
  
  protected String text(final JvmFormalParameter parameter) {
    String _xblockexpression = null;
    {
      final JvmTypeReference parameterType = parameter.getParameterType();
      String _xifexpression = null;
      boolean _equals = Objects.equal(parameterType, null);
      if (_equals) {
        _xifexpression = parameter.getName();
      } else {
        String _simpleName = parameterType.getSimpleName();
        String _plus = (_simpleName + " ");
        String _name = parameter.getName();
        _xifexpression = (_plus + _name);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected ImageDescriptor _imageDescriptor(final XVariableDeclaration variableDeclaration) {
    int _get = this.adornments.get(variableDeclaration);
    return this.images.forLocalVariable(_get);
  }
  
  protected String text(final XImportDeclaration it) {
    StringConcatenation _builder = new StringConcatenation();
    String _importedTypeName = it.getImportedTypeName();
    _builder.append(_importedTypeName, "");
    {
      boolean _isWildcard = it.isWildcard();
      if (_isWildcard) {
        _builder.append(".*");
      } else {
        String _memberName = it.getMemberName();
        boolean _notEquals = (!Objects.equal(_memberName, null));
        if (_notEquals) {
          _builder.append(".");
          String _memberName_1 = it.getMemberName();
          _builder.append(_memberName_1, "");
        }
      }
    }
    return _builder.toString();
  }
  
  protected String text(final XImportSection importSection) {
    return "import declarations";
  }
  
  protected String text(final XVariableDeclaration variableDeclaration) {
    String _xblockexpression = null;
    {
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(variableDeclaration);
      final LightweightTypeReference type = resolvedTypes.getActualType(((JvmIdentifiableElement) variableDeclaration));
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(type, null));
      if (_notEquals) {
        String _humanReadableName = type.getHumanReadableName();
        String _plus = (_humanReadableName + " ");
        String _name = variableDeclaration.getName();
        _xifexpression = (_plus + _name);
      } else {
        _xifexpression = variableDeclaration.getName();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected ImageDescriptor _imageDescriptor(final JvmTypeParameter parameter) {
    int _get = this.adornments.get(parameter);
    return this.images.forTypeParameter(_get);
  }
  
  protected StyledString signature(final String simpleName, final JvmIdentifiableElement element) {
    StyledString _xblockexpression = null;
    {
      IResolvedTypes _resolveTypes = this.typeResolver.resolveTypes(element);
      final LightweightTypeReference returnType = _resolveTypes.getActualType(element);
      String _xifexpression = null;
      boolean _equals = Objects.equal(returnType, null);
      if (_equals) {
        _xifexpression = "void";
      } else {
        _xifexpression = returnType.getHumanReadableName();
      }
      final String returnTypeString = _xifexpression;
      final String typeParam = this.uiStrings.typeParameters(element);
      String _xifexpression_1 = null;
      boolean _isEmpty = typeParam.isEmpty();
      if (_isEmpty) {
        _xifexpression_1 = (" : " + returnTypeString);
      } else {
        _xifexpression_1 = (((" " + typeParam) + " : ") + returnTypeString);
      }
      final String decoratedPart = _xifexpression_1;
      String _parameters = this.uiStrings.parameters(element);
      String _plus = (simpleName + _parameters);
      StyledString _styledString = new StyledString(_plus);
      StyledString _styledString_1 = new StyledString(decoratedPart, StyledString.DECORATIONS_STYLER);
      _xblockexpression = _styledString.append(_styledString_1);
    }
    return _xblockexpression;
  }
  
  protected ImageDescriptor _imageDescriptor(final Object element) {
    return null;
  }
  
  protected Object doGetImage(final Object element) {
    Object _elvis = null;
    ImageDescriptor _imageDescriptor = null;
    if (element!=null) {
      _imageDescriptor=this.imageDescriptor(element);
    }
    if (_imageDescriptor != null) {
      _elvis = _imageDescriptor;
    } else {
      Object _doGetImage = super.doGetImage(element);
      _elvis = _doGetImage;
    }
    return _elvis;
  }
  
  protected IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
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
    } else if (constructor instanceof JvmTypeParameter) {
      return _imageDescriptor((JvmTypeParameter)constructor);
    } else if (constructor instanceof JvmFormalParameter) {
      return _imageDescriptor((JvmFormalParameter)constructor);
    } else if (constructor instanceof XVariableDeclaration) {
      return _imageDescriptor((XVariableDeclaration)constructor);
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
