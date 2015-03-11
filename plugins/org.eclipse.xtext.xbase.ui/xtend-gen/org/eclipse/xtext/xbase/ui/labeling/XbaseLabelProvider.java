package org.eclipse.xtext.xbase.ui.labeling;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedField;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
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
  private CommonTypeComputationServices services;
  
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
  
  protected ImageDescriptor _imageDescriptor(final IResolvedOperation operation) {
    JvmOperation _declaration = operation.getDeclaration();
    return this.imageDescriptor(_declaration);
  }
  
  protected Object text(final JvmOperation element) {
    String _simpleName = element.getSimpleName();
    return this.signature(_simpleName, element);
  }
  
  protected Object text(final IResolvedOperation element) {
    LightweightTypeReference _resolvedReturnType = element.getResolvedReturnType();
    final String returnTypeString = _resolvedReturnType.getSimpleName();
    String decoratedPart = (" : " + returnTypeString);
    List<JvmTypeParameter> _typeParameters = element.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List<JvmTypeParameter> _typeParameters_1 = element.getTypeParameters();
      String _string = this.uiStrings.toString(_typeParameters_1);
      String _plus = (" <" + _string);
      String _plus_1 = (_plus + "> : ");
      String _plus_2 = (_plus_1 + returnTypeString);
      decoratedPart = _plus_2;
    }
    JvmOperation _declaration = element.getDeclaration();
    String _simpleName = _declaration.getSimpleName();
    String _plus_3 = (_simpleName + "(");
    List<LightweightTypeReference> _resolvedParameterTypes = element.getResolvedParameterTypes();
    final Function1<LightweightTypeReference, String> _function = new Function1<LightweightTypeReference, String>() {
      @Override
      public String apply(final LightweightTypeReference it) {
        return it.getHumanReadableName();
      }
    };
    List<String> _map = ListExtensions.<LightweightTypeReference, String>map(_resolvedParameterTypes, _function);
    String _join = IterableExtensions.join(_map, ", ");
    String _plus_4 = (_plus_3 + _join);
    String _plus_5 = (_plus_4 + ")");
    StyledString _styledString = new StyledString(_plus_5);
    StyledString _styledString_1 = new StyledString(decoratedPart, StyledString.DECORATIONS_STYLER);
    return _styledString.append(_styledString_1);
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
  
  protected ImageDescriptor _imageDescriptor(final IResolvedConstructor constructor) {
    JvmConstructor _declaration = constructor.getDeclaration();
    return this._imageDescriptor(_declaration);
  }
  
  protected Object text(final IResolvedConstructor constructor) {
    List<LightweightTypeReference> _resolvedParameterTypes = constructor.getResolvedParameterTypes();
    final Function1<LightweightTypeReference, String> _function = new Function1<LightweightTypeReference, String>() {
      @Override
      public String apply(final LightweightTypeReference it) {
        return it.getHumanReadableName();
      }
    };
    List<String> _map = ListExtensions.<LightweightTypeReference, String>map(_resolvedParameterTypes, _function);
    String _join = IterableExtensions.join(_map, ", ");
    String _plus = ("new(" + _join);
    String _plus_1 = (_plus + ")");
    return new StyledString(_plus_1);
  }
  
  protected ImageDescriptor _imageDescriptor(final IResolvedField field) {
    JvmField _declaration = field.getDeclaration();
    return this._imageDescriptor(_declaration);
  }
  
  protected Object text(final IResolvedField field) {
    String _simpleSignature = field.getSimpleSignature();
    String _plus = (_simpleSignature + " : ");
    LightweightTypeReference _resolvedType = field.getResolvedType();
    String _humanReadableName = _resolvedType.getHumanReadableName();
    String _plus_1 = (_plus + _humanReadableName);
    return new StyledString(_plus_1);
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
    JvmTypeReference _xifexpression = null;
    if ((element instanceof JvmOperation)) {
      _xifexpression = ((JvmOperation)element).getReturnType();
    } else {
      JvmTypeReference _xifexpression_1 = null;
      if ((element instanceof JvmField)) {
        _xifexpression_1 = ((JvmField)element).getType();
      } else {
        _xifexpression_1 = null;
      }
      _xifexpression = _xifexpression_1;
    }
    final JvmTypeReference returnType = _xifexpression;
    final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, element);
    String _xifexpression_2 = null;
    boolean _equals = Objects.equal(returnType, null);
    if (_equals) {
      _xifexpression_2 = "void";
    } else {
      LightweightTypeReference _lightweightTypeReference = owner.toLightweightTypeReference(returnType);
      _xifexpression_2 = _lightweightTypeReference.getHumanReadableName();
    }
    final String returnTypeString = _xifexpression_2;
    String decoratedPart = (" : " + returnTypeString);
    String _elvis = null;
    String _typeParameters = this.uiStrings.typeParameters(element);
    if (_typeParameters != null) {
      _elvis = _typeParameters;
    } else {
      _elvis = "";
    }
    final String typeParam = _elvis;
    boolean _notEquals = (!Objects.equal(typeParam, ""));
    if (_notEquals) {
      decoratedPart = (((" " + typeParam) + " : ") + returnTypeString);
    }
    String _parameters = this.uiStrings.parameters(element);
    String _plus = (simpleName + _parameters);
    StyledString _styledString = new StyledString(_plus);
    StyledString _styledString_1 = new StyledString(decoratedPart, StyledString.DECORATIONS_STYLER);
    return _styledString.append(_styledString_1);
  }
  
  protected ImageDescriptor _imageDescriptor(final Object element) {
    return null;
  }
  
  @Override
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
    } else if (constructor instanceof IResolvedConstructor) {
      return _imageDescriptor((IResolvedConstructor)constructor);
    } else if (constructor instanceof IResolvedOperation) {
      return _imageDescriptor((IResolvedOperation)constructor);
    } else if (constructor instanceof XImportDeclaration) {
      return _imageDescriptor((XImportDeclaration)constructor);
    } else if (constructor instanceof XImportSection) {
      return _imageDescriptor((XImportSection)constructor);
    } else if (constructor instanceof IResolvedField) {
      return _imageDescriptor((IResolvedField)constructor);
    } else if (constructor != null) {
      return _imageDescriptor(constructor);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(constructor).toString());
    }
  }
}
