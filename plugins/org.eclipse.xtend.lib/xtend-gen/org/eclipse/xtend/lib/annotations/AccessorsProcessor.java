package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
 * @noextend
 * @noreference
 */
@Beta
@SuppressWarnings("all")
public class AccessorsProcessor implements TransformationParticipant<MutableMemberDeclaration> {
  /**
   * @since 2.7
   * @noextend
   * @noreference
   */
  @Beta
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
      List<String> _possibleGetterNames = this.getPossibleGetterNames(it);
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String name) {
          TypeDeclaration _declaringType = it.getDeclaringType();
          MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(name);
          return Boolean.valueOf((_findDeclaredMethod != null));
        }
      };
      return IterableExtensions.<String>exists(_possibleGetterNames, _function);
    }
    
    public boolean shouldAddGetter(final FieldDeclaration it) {
      return ((!this.hasGetter(it)) && (this.getGetterType(it) != AccessorType.NONE));
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
      if ((annotation != null)) {
        EnumerationValueDeclaration[] _enumArrayValue = annotation.getEnumArrayValue("value");
        final Function1<EnumerationValueDeclaration, AccessorType> _function = new Function1<EnumerationValueDeclaration, AccessorType>() {
          @Override
          public AccessorType apply(final EnumerationValueDeclaration it) {
            String _simpleName = it.getSimpleName();
            return AccessorType.valueOf(_simpleName);
          }
        };
        final List<AccessorType> types = ListExtensions.<EnumerationValueDeclaration, AccessorType>map(((List<EnumerationValueDeclaration>)Conversions.doWrapArray(_enumArrayValue)), _function);
        AccessorType _elvis_1 = null;
        final Function1<AccessorType, Boolean> _function_1 = new Function1<AccessorType, Boolean>() {
          @Override
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
    
    public Object validateGetter(final MutableFieldDeclaration field) {
      return null;
    }
    
    public String getGetterName(final FieldDeclaration it) {
      List<String> _possibleGetterNames = this.getPossibleGetterNames(it);
      return IterableExtensions.<String>head(_possibleGetterNames);
    }
    
    public List<String> getPossibleGetterNames(final FieldDeclaration it) {
      final ArrayList<String> names = CollectionLiterals.<String>newArrayList();
      if ((((this.isBooleanType(this.orObject(it.getType())) && it.getSimpleName().startsWith("is")) && (it.getSimpleName().length() > 2)) && Character.isUpperCase(it.getSimpleName().charAt(2)))) {
        String _simpleName = it.getSimpleName();
        names.add(_simpleName);
      }
      List<String> _xifexpression = null;
      TypeReference _type = it.getType();
      TypeReference _orObject = this.orObject(_type);
      boolean _isBooleanType = this.isBooleanType(_orObject);
      if (_isBooleanType) {
        _xifexpression = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("is", "get"));
      } else {
        _xifexpression = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("get"));
      }
      final Function1<String, String> _function = new Function1<String, String>() {
        @Override
        public String apply(final String prefix) {
          String _simpleName = it.getSimpleName();
          String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
          return (prefix + _firstUpper);
        }
      };
      List<String> _map = ListExtensions.<String, String>map(_xifexpression, _function);
      names.addAll(_map);
      return names;
    }
    
    public boolean isBooleanType(final TypeReference it) {
      return ((!it.isInferred()) && Objects.equal(it, this.context.getPrimitiveBoolean()));
    }
    
    public void addGetter(final MutableFieldDeclaration field, final Visibility visibility) {
      this.validateGetter(field);
      field.markAsRead();
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      String _getterName = this.getGetterName(field);
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        @Override
        public void apply(final MutableMethodDeclaration it) {
          Element _primarySourceElement = Util.this.context.getPrimarySourceElement(field);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Pure.class);
          it.addAnnotation(_newAnnotationReference);
          TypeReference _type = field.getType();
          TypeReference _orObject = Util.this.orObject(_type);
          it.setReturnType(_orObject);
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
      if ((annotation != null)) {
        EnumerationValueDeclaration[] _enumArrayValue = annotation.getEnumArrayValue("value");
        final Function1<EnumerationValueDeclaration, AccessorType> _function = new Function1<EnumerationValueDeclaration, AccessorType>() {
          @Override
          public AccessorType apply(final EnumerationValueDeclaration it) {
            String _simpleName = it.getSimpleName();
            return AccessorType.valueOf(_simpleName);
          }
        };
        final List<AccessorType> types = ListExtensions.<EnumerationValueDeclaration, AccessorType>map(((List<EnumerationValueDeclaration>)Conversions.doWrapArray(_enumArrayValue)), _function);
        AccessorType _elvis_1 = null;
        final Function1<AccessorType, Boolean> _function_1 = new Function1<AccessorType, Boolean>() {
          @Override
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
      TypeReference _orObject = this.orObject(_type);
      MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_setterName, _orObject);
      return (_findDeclaredMethod != null);
    }
    
    public String getSetterName(final FieldDeclaration it) {
      String _simpleName = it.getSimpleName();
      String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
      return ("set" + _firstUpper);
    }
    
    public boolean shouldAddSetter(final FieldDeclaration it) {
      return (((!it.isFinal()) && (!this.hasSetter(it))) && (this.getSetterType(it) != AccessorType.NONE));
    }
    
    public void validateSetter(final MutableFieldDeclaration field) {
      boolean _isFinal = field.isFinal();
      if (_isFinal) {
        this.context.addError(field, "Cannot set a final field");
      }
      if (((field.getType() == null) || field.getType().isInferred())) {
        this.context.addError(field, "Type cannot be inferred.");
        return;
      }
    }
    
    public void addSetter(final MutableFieldDeclaration field, final Visibility visibility) {
      this.validateSetter(field);
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      String _setterName = this.getSetterName(field);
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        @Override
        public void apply(final MutableMethodDeclaration it) {
          Element _primarySourceElement = Util.this.context.getPrimarySourceElement(field);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          TypeReference _primitiveVoid = Util.this.context.getPrimitiveVoid();
          it.setReturnType(_primitiveVoid);
          String _simpleName = field.getSimpleName();
          TypeReference _type = field.getType();
          TypeReference _orObject = Util.this.orObject(_type);
          final MutableParameterDeclaration param = it.addParameter(_simpleName, _orObject);
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
    
    private TypeReference orObject(final TypeReference ref) {
      TypeReference _xifexpression = null;
      if ((ref == null)) {
        _xifexpression = this.context.getObject();
      } else {
        _xifexpression = ref;
      }
      return _xifexpression;
    }
  }
  
  @Override
  public void doTransform(final List<? extends MutableMemberDeclaration> elements, @Extension final TransformationContext context) {
    final Procedure1<MutableMemberDeclaration> _function = new Procedure1<MutableMemberDeclaration>() {
      @Override
      public void apply(final MutableMemberDeclaration it) {
        AccessorsProcessor.this.transform(it, context);
      }
    };
    IterableExtensions.forEach(elements, _function);
  }
  
  protected void _transform(final MutableFieldDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final AccessorsProcessor.Util util = new AccessorsProcessor.Util(context);
    boolean _shouldAddGetter = util.shouldAddGetter(it);
    if (_shouldAddGetter) {
      AccessorType _getterType = util.getGetterType(it);
      Visibility _visibility = util.toVisibility(_getterType);
      util.addGetter(it, _visibility);
    }
    boolean _shouldAddSetter = util.shouldAddSetter(it);
    if (_shouldAddSetter) {
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
    if ((requiredArgsUtil.needsFinalFieldConstructor(it) || (it.findAnnotation(context.findTypeGlobally(FinalFieldsConstructor.class)) != null))) {
      requiredArgsUtil.addFinalFieldsConstructor(it);
    }
    Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
    final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
      @Override
      public Boolean apply(final MutableFieldDeclaration it) {
        return Boolean.valueOf(((!it.isStatic()) && context.isThePrimaryGeneratedJavaElement(it)));
      }
    };
    Iterable<? extends MutableFieldDeclaration> _filter = IterableExtensions.filter(_declaredFields, _function);
    final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
      @Override
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
