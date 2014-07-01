package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public class AccessorsProcessor implements TransformationParticipant<MutableMemberDeclaration> {
  /**
   * @since 2.7
   */
  @Beta
  @GwtCompatible
  public static class Util {
    @Extension
    private TransformationContext context;
    
    public Util(final TransformationContext context) {
      this.context = context;
    }
    
    public Visibility toVisibility(final AccessorType type) {
      Visibility _switchResult = null;
      if (type != null) {
        switch (type) {
          case PUBLIC_GETTER:
            _switchResult = Visibility.PUBLIC;
            break;
          case PROTECTED_GETTER:
            _switchResult = Visibility.PROTECTED;
            break;
          case PACKAGE_GETTER:
            _switchResult = Visibility.DEFAULT;
            break;
          case PRIVATE_GETTER:
            _switchResult = Visibility.PRIVATE;
            break;
          case PUBLIC_SETTER:
            _switchResult = Visibility.PUBLIC;
            break;
          case PROTECTED_SETTER:
            _switchResult = Visibility.PROTECTED;
            break;
          case PACKAGE_SETTER:
            _switchResult = Visibility.DEFAULT;
            break;
          case PRIVATE_SETTER:
            _switchResult = Visibility.PRIVATE;
            break;
          default:
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Cannot convert ");
            _builder.append(type, "");
            throw new IllegalArgumentException(_builder.toString());
        }
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cannot convert ");
        _builder.append(type, "");
        throw new IllegalArgumentException(_builder.toString());
      }
      return _switchResult;
    }
    
    public boolean hasGetter(final FieldDeclaration it) {
      TypeDeclaration _declaringType = it.getDeclaringType();
      String _getterName = this.getGetterName(it);
      MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_getterName);
      return (_findDeclaredMethod != null);
    }
    
    public boolean shouldAddGetter(final FieldDeclaration it) {
      boolean _and = false;
      boolean _hasGetter = this.hasGetter(it);
      boolean _not = (!_hasGetter);
      if (!_not) {
        _and = false;
      } else {
        AccessorType _getterType = this.getGetterType(it);
        boolean _tripleNotEquals = (_getterType != AccessorType.NONE);
        _and = _tripleNotEquals;
      }
      return _and;
    }
    
    public AccessorType getGetterType(final FieldDeclaration it) {
      AnnotationReference _elvis = null;
      AnnotationReference _accessorsAnnotation = this.getAccessorsAnnotation(it);
      if (_accessorsAnnotation != null) {
        _elvis = _accessorsAnnotation;
      } else {
        TypeDeclaration _declaringType = it.getDeclaringType();
        AnnotationReference _accessorsAnnotation_1 = this.getAccessorsAnnotation(_declaringType);
        _elvis = _accessorsAnnotation_1;
      }
      final AnnotationReference annotation = _elvis;
      boolean _tripleNotEquals = (annotation != null);
      if (_tripleNotEquals) {
        EnumerationValueDeclaration[] _enumArrayValue = annotation.getEnumArrayValue("value");
        final Function1<EnumerationValueDeclaration, AccessorType> _function = new Function1<EnumerationValueDeclaration, AccessorType>() {
          public AccessorType apply(final EnumerationValueDeclaration it) {
            String _simpleName = it.getSimpleName();
            return AccessorType.valueOf(_simpleName);
          }
        };
        final List<AccessorType> types = ListExtensions.<EnumerationValueDeclaration, AccessorType>map(((List<EnumerationValueDeclaration>)Conversions.doWrapArray(_enumArrayValue)), _function);
        AccessorType _elvis_1 = null;
        final Function1<AccessorType, Boolean> _function_1 = new Function1<AccessorType, Boolean>() {
          public Boolean apply(final AccessorType it) {
            String _name = it.name();
            return Boolean.valueOf(_name.endsWith("GETTER"));
          }
        };
        AccessorType _findFirst = IterableExtensions.<AccessorType>findFirst(types, _function_1);
        if (_findFirst != null) {
          _elvis_1 = _findFirst;
        } else {
          _elvis_1 = AccessorType.NONE;
        }
        return _elvis_1;
      }
      return null;
    }
    
    public AnnotationReference getAccessorsAnnotation(final AnnotationTarget it) {
      Type _findTypeGlobally = this.context.findTypeGlobally(Accessors.class);
      return it.findAnnotation(_findTypeGlobally);
    }
    
    public boolean canAddGetter(final MutableFieldDeclaration field) {
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      TypeReference _newSelfTypeReference = this.context.newSelfTypeReference(_declaringType);
      Iterable<? extends ResolvedMethod> _allResolvedMethods = _newSelfTypeReference.getAllResolvedMethods();
      final Function1<ResolvedMethod, Boolean> _function = new Function1<ResolvedMethod, Boolean>() {
        public Boolean apply(final ResolvedMethod it) {
          boolean _and = false;
          MethodDeclaration _declaration = it.getDeclaration();
          String _simpleName = _declaration.getSimpleName();
          String _getterName = Util.this.getGetterName(field);
          boolean _equals = Objects.equal(_simpleName, _getterName);
          if (!_equals) {
            _and = false;
          } else {
            Iterable<? extends ResolvedParameter> _resolvedParameters = it.getResolvedParameters();
            boolean _isEmpty = IterableExtensions.isEmpty(_resolvedParameters);
            _and = _isEmpty;
          }
          return Boolean.valueOf(_and);
        }
      };
      final ResolvedMethod overriddenGetter = IterableExtensions.findFirst(_allResolvedMethods, _function);
      boolean _equals = Objects.equal(overriddenGetter, null);
      if (_equals) {
        return true;
      }
      final MethodDeclaration overriddenDeclaration = overriddenGetter.getDeclaration();
      boolean _isFinal = overriddenDeclaration.isFinal();
      if (_isFinal) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cannot override the final method ");
        String _simpleSignature = overriddenGetter.getSimpleSignature();
        _builder.append(_simpleSignature, "");
        _builder.append(" in ");
        TypeDeclaration _declaringType_1 = overriddenDeclaration.getDeclaringType();
        String _simpleName = _declaringType_1.getSimpleName();
        _builder.append(_simpleName, "");
        this.context.addError(field, _builder.toString());
        return false;
      }
      TypeReference _resolvedReturnType = overriddenGetter.getResolvedReturnType();
      TypeReference _type = field.getType();
      boolean _isAssignableFrom = _resolvedReturnType.isAssignableFrom(_type);
      boolean _not = (!_isAssignableFrom);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Cannot override the method ");
        String _simpleSignature_1 = overriddenGetter.getSimpleSignature();
        _builder_1.append(_simpleSignature_1, "");
        _builder_1.append(" in ");
        TypeDeclaration _declaringType_2 = overriddenDeclaration.getDeclaringType();
        String _simpleName_1 = _declaringType_2.getSimpleName();
        _builder_1.append(_simpleName_1, "");
        _builder_1.append(", ");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("because its return type is incompatible with ");
        TypeReference _type_1 = field.getType();
        String _simpleName_2 = _type_1.getSimpleName();
        _builder_1.append(_simpleName_2, "");
        _builder_1.newLineIfNotEmpty();
        this.context.addError(field, _builder_1.toString());
        return false;
      }
      return true;
    }
    
    public String getGetterName(final FieldDeclaration it) {
      String _xifexpression = null;
      TypeReference _type = it.getType();
      boolean _isBooleanType = this.isBooleanType(_type);
      if (_isBooleanType) {
        _xifexpression = "is";
      } else {
        _xifexpression = "get";
      }
      String _simpleName = it.getSimpleName();
      String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
      return (_xifexpression + _firstUpper);
    }
    
    public boolean isBooleanType(final TypeReference it) {
      boolean _and = false;
      boolean _isInferred = it.isInferred();
      boolean _not = (!_isInferred);
      if (!_not) {
        _and = false;
      } else {
        boolean _or = false;
        String _name = it.getName();
        String _name_1 = Boolean.class.getName();
        boolean _equals = Objects.equal(_name, _name_1);
        if (_equals) {
          _or = true;
        } else {
          String _name_2 = it.getName();
          String _name_3 = Boolean.TYPE.getName();
          boolean _equals_1 = Objects.equal(_name_2, _name_3);
          _or = _equals_1;
        }
        _and = _or;
      }
      return _and;
    }
    
    public void addGetter(final MutableFieldDeclaration field, final Visibility visibility) {
      field.markAsRead();
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      String _getterName = this.getGetterName(field);
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          NamedElement _primarySourceElement = Util.this.context.getPrimarySourceElement(field);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Pure.class);
          it.addAnnotation(_newAnnotationReference);
          TypeReference _type = field.getType();
          it.setReturnType(_type);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("return ");
              Object _fieldOwner = Util.this.fieldOwner(field);
              _builder.append(_fieldOwner, "");
              _builder.append(".");
              String _simpleName = field.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(";");
            }
          };
          it.setBody(_client);
          boolean _isStatic = field.isStatic();
          it.setStatic(_isStatic);
          it.setVisibility(visibility);
        }
      };
      _declaringType.addMethod(_getterName, _function);
    }
    
    public AccessorType getSetterType(final FieldDeclaration it) {
      AnnotationReference _elvis = null;
      AnnotationReference _accessorsAnnotation = this.getAccessorsAnnotation(it);
      if (_accessorsAnnotation != null) {
        _elvis = _accessorsAnnotation;
      } else {
        TypeDeclaration _declaringType = it.getDeclaringType();
        AnnotationReference _accessorsAnnotation_1 = this.getAccessorsAnnotation(_declaringType);
        _elvis = _accessorsAnnotation_1;
      }
      final AnnotationReference annotation = _elvis;
      boolean _tripleNotEquals = (annotation != null);
      if (_tripleNotEquals) {
        EnumerationValueDeclaration[] _enumArrayValue = annotation.getEnumArrayValue("value");
        final Function1<EnumerationValueDeclaration, AccessorType> _function = new Function1<EnumerationValueDeclaration, AccessorType>() {
          public AccessorType apply(final EnumerationValueDeclaration it) {
            String _simpleName = it.getSimpleName();
            return AccessorType.valueOf(_simpleName);
          }
        };
        final List<AccessorType> types = ListExtensions.<EnumerationValueDeclaration, AccessorType>map(((List<EnumerationValueDeclaration>)Conversions.doWrapArray(_enumArrayValue)), _function);
        AccessorType _elvis_1 = null;
        final Function1<AccessorType, Boolean> _function_1 = new Function1<AccessorType, Boolean>() {
          public Boolean apply(final AccessorType it) {
            String _name = it.name();
            return Boolean.valueOf(_name.endsWith("SETTER"));
          }
        };
        AccessorType _findFirst = IterableExtensions.<AccessorType>findFirst(types, _function_1);
        if (_findFirst != null) {
          _elvis_1 = _findFirst;
        } else {
          _elvis_1 = AccessorType.NONE;
        }
        return _elvis_1;
      }
      return null;
    }
    
    private Object fieldOwner(final MutableFieldDeclaration it) {
      Object _xifexpression = null;
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        MutableTypeDeclaration _declaringType = it.getDeclaringType();
        _xifexpression = this.context.newTypeReference(_declaringType);
      } else {
        _xifexpression = "this";
      }
      return _xifexpression;
    }
    
    public boolean hasSetter(final FieldDeclaration it) {
      TypeDeclaration _declaringType = it.getDeclaringType();
      String _setterName = this.getSetterName(it);
      TypeReference _type = it.getType();
      MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_setterName, _type);
      return (_findDeclaredMethod != null);
    }
    
    public String getSetterName(final FieldDeclaration it) {
      String _simpleName = it.getSimpleName();
      String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
      return ("set" + _firstUpper);
    }
    
    public boolean shouldAddSetter(final FieldDeclaration it) {
      boolean _and = false;
      boolean _and_1 = false;
      boolean _isFinal = it.isFinal();
      boolean _not = (!_isFinal);
      if (!_not) {
        _and_1 = false;
      } else {
        boolean _hasSetter = this.hasSetter(it);
        boolean _not_1 = (!_hasSetter);
        _and_1 = _not_1;
      }
      if (!_and_1) {
        _and = false;
      } else {
        AccessorType _setterType = this.getSetterType(it);
        boolean _tripleNotEquals = (_setterType != AccessorType.NONE);
        _and = _tripleNotEquals;
      }
      return _and;
    }
    
    public boolean canAddSetter(final MutableFieldDeclaration field) {
      boolean _isFinal = field.isFinal();
      if (_isFinal) {
        this.context.addError(field, "Cannot set a final field");
        return false;
      }
      TypeReference _type = field.getType();
      boolean _isInferred = _type.isInferred();
      if (_isInferred) {
        this.context.addError(field, "Type cannot be inferred.");
        return false;
      }
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      TypeReference _newSelfTypeReference = this.context.newSelfTypeReference(_declaringType);
      Iterable<? extends ResolvedMethod> _allResolvedMethods = _newSelfTypeReference.getAllResolvedMethods();
      final Function1<ResolvedMethod, Boolean> _function = new Function1<ResolvedMethod, Boolean>() {
        public Boolean apply(final ResolvedMethod it) {
          boolean _and = false;
          boolean _and_1 = false;
          MethodDeclaration _declaration = it.getDeclaration();
          String _simpleName = _declaration.getSimpleName();
          String _setterName = Util.this.getSetterName(field);
          boolean _equals = Objects.equal(_simpleName, _setterName);
          if (!_equals) {
            _and_1 = false;
          } else {
            Iterable<? extends ResolvedParameter> _resolvedParameters = it.getResolvedParameters();
            int _size = IterableExtensions.size(_resolvedParameters);
            boolean _equals_1 = (_size == 1);
            _and_1 = _equals_1;
          }
          if (!_and_1) {
            _and = false;
          } else {
            TypeReference _type = field.getType();
            Iterable<? extends ResolvedParameter> _resolvedParameters_1 = it.getResolvedParameters();
            ResolvedParameter _head = IterableExtensions.head(_resolvedParameters_1);
            TypeReference _resolvedType = _head.getResolvedType();
            boolean _isAssignableFrom = _type.isAssignableFrom(_resolvedType);
            _and = _isAssignableFrom;
          }
          return Boolean.valueOf(_and);
        }
      };
      final ResolvedMethod overriddenSetter = IterableExtensions.findFirst(_allResolvedMethods, _function);
      boolean _equals = Objects.equal(overriddenSetter, null);
      if (_equals) {
        return true;
      }
      final MethodDeclaration overriddenDeclaration = overriddenSetter.getDeclaration();
      boolean _isFinal_1 = overriddenDeclaration.isFinal();
      if (_isFinal_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cannot override the final method ");
        String _simpleSignature = overriddenSetter.getSimpleSignature();
        _builder.append(_simpleSignature, "");
        _builder.append(" in ");
        TypeDeclaration _declaringType_1 = overriddenDeclaration.getDeclaringType();
        String _simpleName = _declaringType_1.getSimpleName();
        _builder.append(_simpleName, "");
        this.context.addError(field, _builder.toString());
        return false;
      }
      TypeReference _resolvedReturnType = overriddenSetter.getResolvedReturnType();
      boolean _isVoid = _resolvedReturnType.isVoid();
      boolean _not = (!_isVoid);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Cannot override the method ");
        String _simpleSignature_1 = overriddenSetter.getSimpleSignature();
        _builder_1.append(_simpleSignature_1, "");
        _builder_1.append(" in ");
        TypeDeclaration _declaringType_2 = overriddenDeclaration.getDeclaringType();
        String _simpleName_1 = _declaringType_2.getSimpleName();
        _builder_1.append(_simpleName_1, "");
        _builder_1.append(", because its return type is not void»");
        _builder_1.newLineIfNotEmpty();
        this.context.addError(field, _builder_1.toString());
        return false;
      }
      return true;
    }
    
    public void addSetter(final MutableFieldDeclaration field, final Visibility visibility) {
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      String _setterName = this.getSetterName(field);
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          NamedElement _primarySourceElement = Util.this.context.getPrimarySourceElement(field);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          TypeReference _primitiveVoid = Util.this.context.getPrimitiveVoid();
          it.setReturnType(_primitiveVoid);
          String _simpleName = field.getSimpleName();
          TypeReference _type = field.getType();
          final MutableParameterDeclaration param = it.addParameter(_simpleName, _type);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              Object _fieldOwner = Util.this.fieldOwner(field);
              _builder.append(_fieldOwner, "");
              _builder.append(".");
              String _simpleName = field.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" = ");
              String _simpleName_1 = param.getSimpleName();
              _builder.append(_simpleName_1, "");
              _builder.append(";");
            }
          };
          it.setBody(_client);
          boolean _isStatic = field.isStatic();
          it.setStatic(_isStatic);
          it.setVisibility(visibility);
        }
      };
      _declaringType.addMethod(_setterName, _function);
    }
  }
  
  public void doTransform(final List<? extends MutableMemberDeclaration> elements, @Extension final TransformationContext context) {
    final Procedure1<MutableMemberDeclaration> _function = new Procedure1<MutableMemberDeclaration>() {
      public void apply(final MutableMemberDeclaration it) {
        AccessorsProcessor.this.transform(it, context);
      }
    };
    IterableExtensions.forEach(elements, _function);
  }
  
  protected void _transform(final MutableFieldDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final AccessorsProcessor.Util util = new AccessorsProcessor.Util(context);
    boolean _and = false;
    boolean _shouldAddGetter = util.shouldAddGetter(it);
    if (!_shouldAddGetter) {
      _and = false;
    } else {
      boolean _canAddGetter = util.canAddGetter(it);
      _and = _canAddGetter;
    }
    if (_and) {
      AccessorType _getterType = util.getGetterType(it);
      Visibility _visibility = util.toVisibility(_getterType);
      util.addGetter(it, _visibility);
    }
    boolean _and_1 = false;
    boolean _shouldAddSetter = util.shouldAddSetter(it);
    if (!_shouldAddSetter) {
      _and_1 = false;
    } else {
      boolean _canAddSetter = util.canAddSetter(it);
      _and_1 = _canAddSetter;
    }
    if (_and_1) {
      AccessorType _setterType = util.getSetterType(it);
      Visibility _visibility_1 = util.toVisibility(_setterType);
      util.addSetter(it, _visibility_1);
    }
  }
  
  protected void _transform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    Type _findTypeGlobally = context.findTypeGlobally(Data.class);
    AnnotationReference _findAnnotation = it.findAnnotation(_findTypeGlobally);
    boolean _tripleNotEquals = (_findAnnotation != null);
    if (_tripleNotEquals) {
      return;
    }
    @Extension
    final FinalFieldsConstructorProcessor.Util requiredArgsUtil = new FinalFieldsConstructorProcessor.Util(context);
    boolean _and = false;
    boolean _hasUserDefinedConstructor = requiredArgsUtil.hasUserDefinedConstructor(it);
    boolean _not = (!_hasUserDefinedConstructor);
    if (!_not) {
      _and = false;
    } else {
      boolean _hasFinalFieldsConstructor = requiredArgsUtil.hasFinalFieldsConstructor(it);
      boolean _not_1 = (!_hasFinalFieldsConstructor);
      _and = _not_1;
    }
    if (_and) {
      requiredArgsUtil.addFinalFieldsConstructor(it);
    }
    Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
    final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
      public Boolean apply(final MutableFieldDeclaration it) {
        boolean _and = false;
        boolean _isStatic = it.isStatic();
        boolean _not = (!_isStatic);
        if (!_not) {
          _and = false;
        } else {
          boolean _isThePrimaryGeneratedJavaElement = context.isThePrimaryGeneratedJavaElement(it);
          _and = _isThePrimaryGeneratedJavaElement;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<? extends MutableFieldDeclaration> _filter = IterableExtensions.filter(_declaredFields, _function);
    final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration it) {
        AccessorsProcessor.this._transform(it, context);
      }
    };
    IterableExtensions.forEach(_filter, _function_1);
  }
  
  public void transform(final MutableMemberDeclaration it, final TransformationContext context) {
    if (it instanceof MutableClassDeclaration) {
      _transform((MutableClassDeclaration)it, context);
      return;
    } else if (it instanceof MutableFieldDeclaration) {
      _transform((MutableFieldDeclaration)it, context);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, context).toString());
    }
  }
}
