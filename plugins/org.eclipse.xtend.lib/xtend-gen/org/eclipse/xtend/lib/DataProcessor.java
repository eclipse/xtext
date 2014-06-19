package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.PropertyProcessor;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Declaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

/**
 * @since 2.7
 */
@Beta
@SuppressWarnings("all")
public class DataProcessor extends AbstractClassProcessor {
  @Extension
  private PropertyProcessor _propertyProcessor = new PropertyProcessor();
  
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    boolean _hasDataConstructor = this.hasDataConstructor(it);
    boolean _not = (!_hasDataConstructor);
    if (_not) {
      this.addDataConstructor(it, context);
    }
    boolean _hasHashCode = this.hasHashCode(it);
    boolean _not_1 = (!_hasHashCode);
    if (_not_1) {
      Iterable<? extends MutableFieldDeclaration> _instanceFields = this.getInstanceFields(it);
      ConstructorDeclaration _superConstructor = this.getSuperConstructor(it);
      boolean _tripleNotEquals = (_superConstructor != null);
      this.addHashCode(it, _instanceFields, _tripleNotEquals, context);
    }
    boolean _hasEquals = this.hasEquals(it);
    boolean _not_2 = (!_hasEquals);
    if (_not_2) {
      Iterable<? extends MutableFieldDeclaration> _instanceFields_1 = this.getInstanceFields(it);
      ConstructorDeclaration _superConstructor_1 = this.getSuperConstructor(it);
      boolean _tripleNotEquals_1 = (_superConstructor_1 != null);
      this.addEquals(it, _instanceFields_1, _tripleNotEquals_1, context);
    }
    boolean _hasToString = this.hasToString(it);
    boolean _not_3 = (!_hasToString);
    if (_not_3) {
      this.addReflectiveToString(it, context);
    }
    Iterable<? extends MutableFieldDeclaration> _instanceFields_2 = this.getInstanceFields(it);
    final Consumer<MutableFieldDeclaration> _function = new Consumer<MutableFieldDeclaration>() {
      public void accept(final MutableFieldDeclaration it) {
        boolean _hasGetter = DataProcessor.this._propertyProcessor.hasGetter(it);
        boolean _not = (!_hasGetter);
        if (_not) {
          DataProcessor.this._propertyProcessor.addGetter(it, context);
        }
        it.setFinal(true);
        String _simpleName = it.getSimpleName();
        String _firstLower = StringExtensions.toFirstLower(_simpleName);
        String _plus = ("_" + _firstLower);
        it.setSimpleName(_plus);
      }
    };
    _instanceFields_2.forEach(_function);
  }
  
  public boolean hasDataConstructor(final ClassDeclaration cls) {
    Iterable<? extends ConstructorDeclaration> _declaredConstructors = cls.getDeclaredConstructors();
    final Function1<ConstructorDeclaration, Boolean> _function = new Function1<ConstructorDeclaration, Boolean>() {
      public Boolean apply(final ConstructorDeclaration it) {
        boolean _xblockexpression = false;
        {
          final ArrayList<TypeReference> expectedTypes = CollectionLiterals.<TypeReference>newArrayList();
          ConstructorDeclaration _superConstructor = DataProcessor.this.getSuperConstructor(cls);
          boolean _tripleNotEquals = (_superConstructor != null);
          if (_tripleNotEquals) {
            ConstructorDeclaration _superConstructor_1 = DataProcessor.this.getSuperConstructor(cls);
            Iterable<? extends ParameterDeclaration> _parameters = _superConstructor_1.getParameters();
            final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
              public TypeReference apply(final ParameterDeclaration it) {
                return it.getType();
              }
            };
            Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
            Iterables.<TypeReference>addAll(expectedTypes, _map);
          }
          Iterable<? extends FieldDeclaration> _instanceFields = DataProcessor.this.getInstanceFields(cls);
          final Function1<FieldDeclaration, TypeReference> _function_1 = new Function1<FieldDeclaration, TypeReference>() {
            public TypeReference apply(final FieldDeclaration it) {
              return it.getType();
            }
          };
          Iterable<TypeReference> _map_1 = IterableExtensions.map(_instanceFields, _function_1);
          Iterables.<TypeReference>addAll(expectedTypes, _map_1);
          Iterable<? extends ParameterDeclaration> _parameters_1 = it.getParameters();
          final Function1<ParameterDeclaration, TypeReference> _function_2 = new Function1<ParameterDeclaration, TypeReference>() {
            public TypeReference apply(final ParameterDeclaration it) {
              return it.getType();
            }
          };
          Iterable<TypeReference> _map_2 = IterableExtensions.map(_parameters_1, _function_2);
          List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map_2);
          _xblockexpression = Objects.equal(_list, expectedTypes);
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    return IterableExtensions.exists(_declaredConstructors, _function);
  }
  
  public MutableConstructorDeclaration addDataConstructor(final MutableClassDeclaration cls, final TransformationContext ctx) {
    final Procedure1<MutableConstructorDeclaration> _function = new Procedure1<MutableConstructorDeclaration>() {
      public void apply(final MutableConstructorDeclaration constructor) {
        final HashMap<Declaration, MutableParameterDeclaration> fieldToParameter = CollectionLiterals.<Declaration, MutableParameterDeclaration>newHashMap();
        Iterable<? extends ParameterDeclaration> _elvis = null;
        ConstructorDeclaration _superConstructor = DataProcessor.this.getSuperConstructor(cls);
        Iterable<? extends ParameterDeclaration> _parameters = null;
        if (_superConstructor!=null) {
          _parameters=_superConstructor.getParameters();
        }
        if (_parameters != null) {
          _elvis = _parameters;
        } else {
          _elvis = Collections.<ParameterDeclaration>unmodifiableList(Lists.<ParameterDeclaration>newArrayList());
        }
        final Iterable<? extends ParameterDeclaration> superParameters = _elvis;
        final Consumer<ParameterDeclaration> _function = new Consumer<ParameterDeclaration>() {
          public void accept(final ParameterDeclaration it) {
            String _simpleName = it.getSimpleName();
            TypeReference _type = it.getType();
            final MutableParameterDeclaration param = constructor.addParameter(_simpleName, _type);
            fieldToParameter.put(it, param);
          }
        };
        superParameters.forEach(_function);
        Iterable<? extends MutableFieldDeclaration> _constructedFields = DataProcessor.this.constructedFields(cls);
        final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
          public void apply(final MutableFieldDeclaration it) {
            String _simpleName = it.getSimpleName();
            TypeReference _type = it.getType();
            final MutableParameterDeclaration param = constructor.addParameter(_simpleName, _type);
            it.markAsInitialized();
            fieldToParameter.put(it, param);
          }
        };
        IterableExtensions.forEach(_constructedFields, _function_1);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("super(");
            final Function1<ParameterDeclaration, String> _function = new Function1<ParameterDeclaration, String>() {
              public String apply(final ParameterDeclaration it) {
                return it.getSimpleName();
              }
            };
            String _join = IterableExtensions.join(superParameters, ", ", _function);
            _builder.append(_join, "");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            {
              Iterable<? extends MutableFieldDeclaration> _constructedFields = DataProcessor.this.constructedFields(cls);
              for(final MutableFieldDeclaration field : _constructedFields) {
                _builder.append("this.");
                String _simpleName = field.getSimpleName();
                _builder.append(_simpleName, "");
                _builder.append(" = ");
                MutableParameterDeclaration _get = fieldToParameter.get(field);
                String _simpleName_1 = _get.getSimpleName();
                _builder.append(_simpleName_1, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        };
        constructor.setBody(_client);
      }
    };
    return cls.addConstructor(_function);
  }
  
  public Iterable<? extends MutableFieldDeclaration> constructedFields(final MutableClassDeclaration it) {
    Iterable<? extends MutableFieldDeclaration> _instanceFields = this.getInstanceFields(it);
    final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
      public Boolean apply(final MutableFieldDeclaration it) {
        Expression _initializer = it.getInitializer();
        return Boolean.valueOf(Objects.equal(_initializer, null));
      }
    };
    return IterableExtensions.filter(_instanceFields, _function);
  }
  
  public ConstructorDeclaration getSuperConstructor(final ClassDeclaration it) {
    boolean _or = false;
    TypeReference _extendedClass = it.getExtendedClass();
    boolean _equals = Objects.equal(_extendedClass, null);
    if (_equals) {
      _or = true;
    } else {
      TypeReference _extendedClass_1 = it.getExtendedClass();
      String _name = _extendedClass_1.getName();
      String _name_1 = Object.class.getName();
      boolean _equals_1 = Objects.equal(_name, _name_1);
      _or = _equals_1;
    }
    if (_or) {
      return null;
    }
    TypeReference _extendedClass_2 = it.getExtendedClass();
    Type _type = _extendedClass_2.getType();
    Iterable<? extends ConstructorDeclaration> _declaredConstructors = ((ClassDeclaration) _type).getDeclaredConstructors();
    return IterableExtensions.head(_declaredConstructors);
  }
  
  public boolean hasHashCode(final ClassDeclaration it) {
    MethodDeclaration _findDeclaredMethod = it.findDeclaredMethod("hashCode");
    return (_findDeclaredMethod != null);
  }
  
  public boolean hasEquals(final ClassDeclaration it) {
    Iterable<? extends MethodDeclaration> _declaredMethods = it.getDeclaredMethods();
    final Function1<MethodDeclaration, Boolean> _function = new Function1<MethodDeclaration, Boolean>() {
      public Boolean apply(final MethodDeclaration it) {
        boolean _and = false;
        boolean _and_1 = false;
        String _simpleName = it.getSimpleName();
        boolean _equals = Objects.equal(_simpleName, "equals");
        if (!_equals) {
          _and_1 = false;
        } else {
          Iterable<? extends ParameterDeclaration> _parameters = it.getParameters();
          int _size = IterableExtensions.size(_parameters);
          boolean _equals_1 = (_size == 1);
          _and_1 = _equals_1;
        }
        if (!_and_1) {
          _and = false;
        } else {
          Iterable<? extends ParameterDeclaration> _parameters_1 = it.getParameters();
          ParameterDeclaration _head = IterableExtensions.head(_parameters_1);
          TypeReference _type = _head.getType();
          String _name = _type.getName();
          boolean _equals_2 = Objects.equal(_name, "java.lang.Object");
          _and = _equals_2;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.exists(_declaredMethods, _function);
  }
  
  public boolean hasToString(final ClassDeclaration it) {
    MethodDeclaration _findDeclaredMethod = it.findDeclaredMethod("toString");
    return (_findDeclaredMethod != null);
  }
  
  public Iterable<? extends FieldDeclaration> getInstanceFields(final ClassDeclaration it) {
    Iterable<? extends FieldDeclaration> _declaredFields = it.getDeclaredFields();
    final Function1<FieldDeclaration, Boolean> _function = new Function1<FieldDeclaration, Boolean>() {
      public Boolean apply(final FieldDeclaration it) {
        boolean _isStatic = it.isStatic();
        return Boolean.valueOf((!_isStatic));
      }
    };
    return IterableExtensions.filter(_declaredFields, _function);
  }
  
  public Iterable<? extends MutableFieldDeclaration> getInstanceFields(final MutableClassDeclaration it) {
    Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
    final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
      public Boolean apply(final MutableFieldDeclaration it) {
        boolean _isStatic = it.isStatic();
        return Boolean.valueOf((!_isStatic));
      }
    };
    return IterableExtensions.filter(_declaredFields, _function);
  }
  
  public void addHashCode(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> includedFields, final boolean includeSuper, @Extension final TransformationContext context) {
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _primitiveInt = context.getPrimitiveInt();
        it.setReturnType(_primitiveInt);
        AnnotationReference _newAnnotationReference = context.newAnnotationReference(Override.class);
        it.addAnnotation(_newAnnotationReference);
        AnnotationReference _newAnnotationReference_1 = context.newAnnotationReference(Pure.class);
        it.addAnnotation(_newAnnotationReference_1);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("final int prime = 31;");
            _builder.newLine();
            _builder.append("int result = ");
            {
              if (includeSuper) {
                _builder.append("super.hashCode()");
              } else {
                _builder.append("1");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            {
              for(final FieldDeclaration field : includedFields) {
                String _contributeToHashCode = DataProcessor.this.contributeToHashCode(field, context);
                _builder.append(_contributeToHashCode, "");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("return result;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      }
    };
    cls.addMethod("hashCode", _function);
  }
  
  private String contributeToHashCode(final FieldDeclaration it, @Extension final TransformationContext context) {
    String _switchResult = null;
    TypeReference _type = it.getType();
    String _name = _type.getName();
    boolean _matched = false;
    if (!_matched) {
      String _name_1 = Double.TYPE.getName();
      if (Objects.equal(_name, _name_1)) {
        _matched=true;
        String _simpleName = it.getSimpleName();
        String _plus = ("result = prime * result + (int) (Double.doubleToLongBits(this." + _simpleName);
        String _plus_1 = (_plus + 
          ") ^ (Double.doubleToLongBits(this.");
        String _simpleName_1 = it.getSimpleName();
        String _plus_2 = (_plus_1 + _simpleName_1);
        _switchResult = (_plus_2 + ") >>> 32));");
      }
    }
    if (!_matched) {
      String _name_2 = Float.TYPE.getName();
      if (Objects.equal(_name, _name_2)) {
        _matched=true;
        String _simpleName_2 = it.getSimpleName();
        String _plus_3 = ("result = prime * result + Float.floatToIntBits(this." + _simpleName_2);
        _switchResult = (_plus_3 + ");");
      }
    }
    if (!_matched) {
      String _name_3 = Boolean.TYPE.getName();
      if (Objects.equal(_name, _name_3)) {
        _matched=true;
        String _simpleName_3 = it.getSimpleName();
        String _plus_4 = ("result = prime * result + (this." + _simpleName_3);
        _switchResult = (_plus_4 + " ? 1231 : 1237);");
      }
    }
    if (!_matched) {
      String _name_4 = Integer.TYPE.getName();
      if (Objects.equal(_name, _name_4)) {
        _matched=true;
      }
      if (!_matched) {
        String _name_5 = Character.TYPE.getName();
        if (Objects.equal(_name, _name_5)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _name_6 = Byte.TYPE.getName();
        if (Objects.equal(_name, _name_6)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _name_7 = Short.TYPE.getName();
        if (Objects.equal(_name, _name_7)) {
          _matched=true;
        }
      }
      if (_matched) {
        String _simpleName_4 = it.getSimpleName();
        String _plus_5 = ("result = prime * result + this." + _simpleName_4);
        _switchResult = (_plus_5 + ";");
      }
    }
    if (!_matched) {
      String _name_8 = Long.TYPE.getName();
      if (Objects.equal(_name, _name_8)) {
        _matched=true;
        String _simpleName_5 = it.getSimpleName();
        String _plus_6 = ("result = prime * result + (int) (this." + _simpleName_5);
        String _plus_7 = (_plus_6 + " ^ (this.");
        String _simpleName_6 = it.getSimpleName();
        String _plus_8 = (_plus_7 + _simpleName_6);
        _switchResult = (_plus_8 + " >>> 32));");
      }
    }
    if (!_matched) {
      String _simpleName_7 = it.getSimpleName();
      String _plus_9 = ("result = prime * result + ((this." + _simpleName_7);
      String _plus_10 = (_plus_9 + "== null) ? 0 : this.");
      String _simpleName_8 = it.getSimpleName();
      String _plus_11 = (_plus_10 + _simpleName_8);
      _switchResult = (_plus_11 + ".hashCode());");
    }
    return _switchResult;
  }
  
  public void addEquals(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> includedFields, final boolean includeSuper, @Extension final TransformationContext context) {
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _primitiveBoolean = context.getPrimitiveBoolean();
        it.setReturnType(_primitiveBoolean);
        AnnotationReference _newAnnotationReference = context.newAnnotationReference(Override.class);
        it.addAnnotation(_newAnnotationReference);
        AnnotationReference _newAnnotationReference_1 = context.newAnnotationReference(Pure.class);
        it.addAnnotation(_newAnnotationReference_1);
        TypeReference _object = context.getObject();
        it.addParameter("obj", _object);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("if (this == obj)");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("return true;");
            _builder.newLine();
            _builder.append("if (obj == null)");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("return false;");
            _builder.newLine();
            _builder.append("if (getClass() != obj.getClass())");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("return false;");
            _builder.newLine();
            {
              if (includeSuper) {
                _builder.append("if (!super.equals(obj))");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("return false;");
                _builder.newLine();
              }
            }
            String _simpleName = cls.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" other = (");
            String _simpleName_1 = cls.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append(") obj;");
            _builder.newLineIfNotEmpty();
            {
              for(final FieldDeclaration field : includedFields) {
                String _contributeToEquals = DataProcessor.this.contributeToEquals(field, context);
                _builder.append(_contributeToEquals, "");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("return true;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      }
    };
    cls.addMethod("equals", _function);
  }
  
  private String contributeToEquals(final FieldDeclaration it, @Extension final TransformationContext context) {
    String _switchResult = null;
    TypeReference _type = it.getType();
    String _name = _type.getName();
    boolean _matched = false;
    if (!_matched) {
      String _name_1 = Double.TYPE.getName();
      if (Objects.equal(_name, _name_1)) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("if (Double.doubleToLongBits(other.");
        String _simpleName = it.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(") != Double.doubleToLongBits(this.");
        String _simpleName_1 = it.getSimpleName();
        _builder.append(_simpleName_1, "");
        _builder.append("))");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("return false; ");
        _builder.newLine();
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      String _name_2 = Float.TYPE.getName();
      if (Objects.equal(_name, _name_2)) {
        _matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("if (Float.floatToLongBits(other.");
        String _simpleName_2 = it.getSimpleName();
        _builder_1.append(_simpleName_2, "");
        _builder_1.append(") != Float.floatToLongBits(this.");
        String _simpleName_3 = it.getSimpleName();
        _builder_1.append(_simpleName_3, "");
        _builder_1.append("))");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("  ");
        _builder_1.append("return false; ");
        _builder_1.newLine();
        _switchResult = _builder_1.toString();
      }
    }
    if (!_matched) {
      String _name_3 = Boolean.TYPE.getName();
      if (Objects.equal(_name, _name_3)) {
        _matched=true;
      }
      if (!_matched) {
        String _name_4 = Integer.TYPE.getName();
        if (Objects.equal(_name, _name_4)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _name_5 = Character.TYPE.getName();
        if (Objects.equal(_name, _name_5)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _name_6 = Byte.TYPE.getName();
        if (Objects.equal(_name, _name_6)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _name_7 = Short.TYPE.getName();
        if (Objects.equal(_name, _name_7)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _name_8 = Long.TYPE.getName();
        if (Objects.equal(_name, _name_8)) {
          _matched=true;
        }
      }
      if (_matched) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("if (other.");
        String _simpleName_4 = it.getSimpleName();
        _builder_2.append(_simpleName_4, "");
        _builder_2.append(" != this.");
        String _simpleName_5 = it.getSimpleName();
        _builder_2.append(_simpleName_5, "");
        _builder_2.append(")");
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("  ");
        _builder_2.append("return false;");
        _builder_2.newLine();
        _switchResult = _builder_2.toString();
      }
    }
    if (!_matched) {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("if (this.");
      String _simpleName_6 = it.getSimpleName();
      _builder_3.append(_simpleName_6, "");
      _builder_3.append(" == null) {");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("  ");
      _builder_3.append("if (other.");
      String _simpleName_7 = it.getSimpleName();
      _builder_3.append(_simpleName_7, "  ");
      _builder_3.append(" != null)");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("    ");
      _builder_3.append("return false;");
      _builder_3.newLine();
      _builder_3.append("} else if (!this.");
      String _simpleName_8 = it.getSimpleName();
      _builder_3.append(_simpleName_8, "");
      _builder_3.append(".equals(other.");
      String _simpleName_9 = it.getSimpleName();
      _builder_3.append(_simpleName_9, "");
      _builder_3.append("))");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("  ");
      _builder_3.append("return false;");
      _builder_3.newLine();
      _switchResult = _builder_3.toString();
    }
    return _switchResult;
  }
  
  public void addReflectiveToString(final MutableClassDeclaration cls, @Extension final TransformationContext context) {
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _string = context.getString();
        it.setReturnType(_string);
        AnnotationReference _newAnnotationReference = context.newAnnotationReference(Override.class);
        it.addAnnotation(_newAnnotationReference);
        AnnotationReference _newAnnotationReference_1 = context.newAnnotationReference(Pure.class);
        it.addAnnotation(_newAnnotationReference_1);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("String result = new ");
            _builder.append(ToStringHelper.class, "");
            _builder.append("().toString(this);");
            _builder.newLineIfNotEmpty();
            _builder.append("return result;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      }
    };
    cls.addMethod("toString", _function);
  }
}
