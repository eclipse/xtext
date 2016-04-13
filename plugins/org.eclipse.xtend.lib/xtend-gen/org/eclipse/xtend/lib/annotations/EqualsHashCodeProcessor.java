package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @since 2.7
 * @noreference
 * @noextend
 */
@Beta
@SuppressWarnings("all")
public class EqualsHashCodeProcessor extends AbstractClassProcessor {
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
    
    public boolean hasHashCode(final ClassDeclaration it) {
      MethodDeclaration _findDeclaredMethod = it.findDeclaredMethod("hashCode");
      return (_findDeclaredMethod != null);
    }
    
    public boolean hasEquals(final ClassDeclaration it) {
      Iterable<? extends MethodDeclaration> _declaredMethods = it.getDeclaredMethods();
      final Function1<MethodDeclaration, Boolean> _function = new Function1<MethodDeclaration, Boolean>() {
        @Override
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
            TypeReference _object = Util.this.context.getObject();
            boolean _equals_2 = Objects.equal(_type, _object);
            _and = _equals_2;
          }
          return Boolean.valueOf(_and);
        }
      };
      return IterableExtensions.exists(_declaredMethods, _function);
    }
    
    public boolean hasSuperEquals(final ClassDeclaration cls) {
      boolean _xblockexpression = false;
      {
        TypeReference _extendedClass = cls.getExtendedClass();
        Type _type = _extendedClass.getType();
        final ClassDeclaration superClass = ((ClassDeclaration) _type);
        boolean _xifexpression = false;
        TypeReference _newTypeReference = this.context.newTypeReference(superClass);
        TypeReference _object = this.context.getObject();
        boolean _equals = _newTypeReference.equals(_object);
        if (_equals) {
          _xifexpression = false;
        } else {
          boolean _xifexpression_1 = false;
          boolean _hasEquals = this.hasEquals(superClass);
          if (_hasEquals) {
            _xifexpression_1 = true;
          } else {
            _xifexpression_1 = this.hasSuperEquals(superClass);
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
    
    public boolean hasSuperHashCode(final ClassDeclaration cls) {
      boolean _xblockexpression = false;
      {
        TypeReference _extendedClass = cls.getExtendedClass();
        Type _type = _extendedClass.getType();
        final ClassDeclaration superClass = ((ClassDeclaration) _type);
        boolean _xifexpression = false;
        TypeReference _newTypeReference = this.context.newTypeReference(superClass);
        TypeReference _object = this.context.getObject();
        boolean _equals = _newTypeReference.equals(_object);
        if (_equals) {
          _xifexpression = false;
        } else {
          boolean _xifexpression_1 = false;
          boolean _hasHashCode = this.hasHashCode(superClass);
          if (_hasHashCode) {
            _xifexpression_1 = true;
          } else {
            _xifexpression_1 = this.hasSuperHashCode(superClass);
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
    
    public void addEquals(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> includedFields, final boolean includeSuper) {
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        @Override
        public void apply(final MutableMethodDeclaration it) {
          Element _primarySourceElement = Util.this.context.getPrimarySourceElement(cls);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          TypeReference _primitiveBoolean = Util.this.context.getPrimitiveBoolean();
          it.setReturnType(_primitiveBoolean);
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Override.class);
          it.addAnnotation(_newAnnotationReference);
          AnnotationReference _newAnnotationReference_1 = Util.this.context.newAnnotationReference(Pure.class);
          it.addAnnotation(_newAnnotationReference_1);
          TypeReference _object = Util.this.context.getObject();
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
              TypeReference _newWildCardSelfTypeReference = Util.this.newWildCardSelfTypeReference(cls);
              _builder.append(_newWildCardSelfTypeReference, "");
              _builder.append(" other = (");
              TypeReference _newWildCardSelfTypeReference_1 = Util.this.newWildCardSelfTypeReference(cls);
              _builder.append(_newWildCardSelfTypeReference_1, "");
              _builder.append(") obj;");
              _builder.newLineIfNotEmpty();
              {
                for(final FieldDeclaration field : includedFields) {
                  StringConcatenationClient _contributeToEquals = Util.this.contributeToEquals(field);
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
    
    private TypeReference newWildCardSelfTypeReference(final ClassDeclaration cls) {
      Iterable<? extends TypeParameterDeclaration> _typeParameters = cls.getTypeParameters();
      final Function1<TypeParameterDeclaration, TypeReference> _function = new Function1<TypeParameterDeclaration, TypeReference>() {
        @Override
        public TypeReference apply(final TypeParameterDeclaration it) {
          TypeReference _object = Util.this.context.getObject();
          return Util.this.context.newWildcardTypeReference(_object);
        }
      };
      Iterable<TypeReference> _map = IterableExtensions.map(_typeParameters, _function);
      return this.context.newTypeReference(cls, ((TypeReference[])Conversions.unwrapArray(_map, TypeReference.class)));
    }
    
    public StringConcatenationClient contributeToEquals(final FieldDeclaration it) {
      StringConcatenationClient _switchResult = null;
      TypeReference _type = it.getType();
      TypeReference _orObject = this.orObject(_type);
      String _name = _orObject.getName();
      boolean _matched = false;
      String _name_1 = Double.TYPE.getName();
      if (Objects.equal(_name, _name_1)) {
        _matched=true;
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("if (");
            _builder.append(Double.class, "");
            _builder.append(".doubleToLongBits(other.");
            String _simpleName = it.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(") != ");
            _builder.append(Double.class, "");
            _builder.append(".doubleToLongBits(this.");
            String _simpleName_1 = it.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append("))");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append("return false; ");
            _builder.newLine();
          }
        };
        _switchResult = _client;
      }
      if (!_matched) {
        String _name_2 = Float.TYPE.getName();
        if (Objects.equal(_name, _name_2)) {
          _matched=true;
          StringConcatenationClient _client_1 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("if (");
              _builder.append(Float.class, "");
              _builder.append(".floatToIntBits(other.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(") != ");
              _builder.append(Float.class, "");
              _builder.append(".floatToIntBits(this.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1, "");
              _builder.append("))");
              _builder.newLineIfNotEmpty();
              _builder.append("  ");
              _builder.append("return false; ");
              _builder.newLine();
            }
          };
          _switchResult = _client_1;
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
          StringConcatenationClient _client_2 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("if (other.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" != this.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1, "");
              _builder.append(")");
              _builder.newLineIfNotEmpty();
              _builder.append("  ");
              _builder.append("return false;");
              _builder.newLine();
            }
          };
          _switchResult = _client_2;
        }
      }
      if (!_matched) {
        StringConcatenationClient _client_3 = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("if (this.");
            String _simpleName = it.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" == null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append("if (other.");
            String _simpleName_1 = it.getSimpleName();
            _builder.append(_simpleName_1, "  ");
            _builder.append(" != null)");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("return false;");
            _builder.newLine();
            _builder.append("} else if (!");
            StringConcatenationClient _deepEquals = Util.this.deepEquals(it);
            _builder.append(_deepEquals, "");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append("return false;");
            _builder.newLine();
          }
        };
        _switchResult = _client_3;
      }
      return _switchResult;
    }
    
    public StringConcatenationClient deepEquals(final FieldDeclaration it) {
      StringConcatenationClient _xifexpression = null;
      TypeReference _type = it.getType();
      boolean _isArray = _type.isArray();
      if (_isArray) {
        StringConcatenationClient _xifexpression_1 = null;
        TypeReference _type_1 = it.getType();
        TypeReference _arrayComponentType = _type_1.getArrayComponentType();
        boolean _isPrimitive = _arrayComponentType.isPrimitive();
        if (_isPrimitive) {
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append(Arrays.class, "");
              _builder.append(".equals(this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(", other.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1, "");
              _builder.append(")");
            }
          };
          _xifexpression_1 = _client;
        } else {
          StringConcatenationClient _client_1 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append(Arrays.class, "");
              _builder.append(".deepEquals(this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(", other.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1, "");
              _builder.append(")");
            }
          };
          _xifexpression_1 = _client_1;
        }
        _xifexpression = _xifexpression_1;
      } else {
        StringConcatenationClient _client_2 = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("this.");
            String _simpleName = it.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(".equals(other.");
            String _simpleName_1 = it.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append(")");
          }
        };
        _xifexpression = _client_2;
      }
      return _xifexpression;
    }
    
    public void addHashCode(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> includedFields, final boolean includeSuper) {
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        @Override
        public void apply(final MutableMethodDeclaration it) {
          Element _primarySourceElement = Util.this.context.getPrimarySourceElement(cls);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          TypeReference _primitiveInt = Util.this.context.getPrimitiveInt();
          it.setReturnType(_primitiveInt);
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Override.class);
          it.addAnnotation(_newAnnotationReference);
          AnnotationReference _newAnnotationReference_1 = Util.this.context.newAnnotationReference(Pure.class);
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
                  StringConcatenationClient _contributeToHashCode = Util.this.contributeToHashCode(field);
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
    
    public StringConcatenationClient contributeToHashCode(final FieldDeclaration it) {
      StringConcatenationClient _switchResult = null;
      TypeReference _type = it.getType();
      TypeReference _orObject = this.orObject(_type);
      String _name = _orObject.getName();
      boolean _matched = false;
      String _name_1 = Double.TYPE.getName();
      if (Objects.equal(_name, _name_1)) {
        _matched=true;
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("result = prime * result + (int) (");
            _builder.append(Double.class, "");
            _builder.append(".doubleToLongBits(this.");
            String _simpleName = it.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(") ^ (");
            _builder.append(Double.class, "");
            _builder.append(".doubleToLongBits(this.");
            String _simpleName_1 = it.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append(") >>> 32));");
          }
        };
        _switchResult = _client;
      }
      if (!_matched) {
        String _name_2 = Float.TYPE.getName();
        if (Objects.equal(_name, _name_2)) {
          _matched=true;
          StringConcatenationClient _client_1 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("result = prime * result + ");
              _builder.append(Float.class, "");
              _builder.append(".floatToIntBits(this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(");");
            }
          };
          _switchResult = _client_1;
        }
      }
      if (!_matched) {
        String _name_3 = Boolean.TYPE.getName();
        if (Objects.equal(_name, _name_3)) {
          _matched=true;
          StringConcatenationClient _client_2 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("result = prime * result + (this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" ? 1231 : 1237);");
            }
          };
          _switchResult = _client_2;
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
          StringConcatenationClient _client_3 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("result = prime * result + this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(";");
            }
          };
          _switchResult = _client_3;
        }
      }
      if (!_matched) {
        String _name_8 = Long.TYPE.getName();
        if (Objects.equal(_name, _name_8)) {
          _matched=true;
          StringConcatenationClient _client_4 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("result = prime * result + (int) (this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" ^ (this.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1, "");
              _builder.append(" >>> 32));");
            }
          };
          _switchResult = _client_4;
        }
      }
      if (!_matched) {
        StringConcatenationClient _client_5 = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("result = prime * result + ((this.");
            String _simpleName = it.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append("== null) ? 0 : ");
            StringConcatenationClient _deepHashCode = Util.this.deepHashCode(it);
            _builder.append(_deepHashCode, "");
            _builder.append(");");
          }
        };
        _switchResult = _client_5;
      }
      return _switchResult;
    }
    
    public StringConcatenationClient deepHashCode(final FieldDeclaration it) {
      StringConcatenationClient _xblockexpression = null;
      {
        TypeReference _type = it.getType();
        final TypeReference type = this.orObject(_type);
        StringConcatenationClient _xifexpression = null;
        boolean _isArray = type.isArray();
        if (_isArray) {
          StringConcatenationClient _xifexpression_1 = null;
          TypeReference _arrayComponentType = type.getArrayComponentType();
          boolean _isPrimitive = _arrayComponentType.isPrimitive();
          if (_isPrimitive) {
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append(Arrays.class, "");
                _builder.append(".hashCode(this.");
                String _simpleName = it.getSimpleName();
                _builder.append(_simpleName, "");
                _builder.append(")");
              }
            };
            _xifexpression_1 = _client;
          } else {
            StringConcatenationClient _client_1 = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append(Arrays.class, "");
                _builder.append(".deepHashCode(this.");
                String _simpleName = it.getSimpleName();
                _builder.append(_simpleName, "");
                _builder.append(")");
              }
            };
            _xifexpression_1 = _client_1;
          }
          _xifexpression = _xifexpression_1;
        } else {
          StringConcatenationClient _client_2 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(".hashCode()");
            }
          };
          _xifexpression = _client_2;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
    
    private TypeReference orObject(final TypeReference ref) {
      TypeReference _elvis = null;
      if (ref != null) {
        _elvis = ref;
      } else {
        TypeReference _object = this.context.getObject();
        _elvis = _object;
      }
      return _elvis;
    }
  }
  
  @Override
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    Type _findTypeGlobally = context.findTypeGlobally(Data.class);
    AnnotationReference _findAnnotation = it.findAnnotation(_findTypeGlobally);
    boolean _tripleNotEquals = (_findAnnotation != null);
    if (_tripleNotEquals) {
      return;
    }
    @Extension
    final EqualsHashCodeProcessor.Util util = new EqualsHashCodeProcessor.Util(context);
    boolean _hasEquals = util.hasEquals(it);
    if (_hasEquals) {
      Type _findTypeGlobally_1 = context.findTypeGlobally(EqualsHashCode.class);
      final AnnotationReference annotation = it.findAnnotation(_findTypeGlobally_1);
      context.addWarning(annotation, "equals is already defined, this annotation has no effect");
    } else {
      boolean _hasHashCode = util.hasHashCode(it);
      if (_hasHashCode) {
        context.addWarning(it, "hashCode is already defined, this annotation has no effect");
      } else {
        Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
        final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
          @Override
          public Boolean apply(final MutableFieldDeclaration it) {
            boolean _and = false;
            boolean _and_1 = false;
            boolean _isStatic = it.isStatic();
            boolean _not = (!_isStatic);
            if (!_not) {
              _and_1 = false;
            } else {
              boolean _isTransient = it.isTransient();
              boolean _not_1 = (!_isTransient);
              _and_1 = _not_1;
            }
            if (!_and_1) {
              _and = false;
            } else {
              boolean _isThePrimaryGeneratedJavaElement = context.isThePrimaryGeneratedJavaElement(it);
              _and = _isThePrimaryGeneratedJavaElement;
            }
            return Boolean.valueOf(_and);
          }
        };
        final Iterable<? extends MutableFieldDeclaration> fields = IterableExtensions.filter(_declaredFields, _function);
        boolean _hasSuperEquals = util.hasSuperEquals(it);
        util.addEquals(it, fields, _hasSuperEquals);
        boolean _hasSuperHashCode = util.hasSuperHashCode(it);
        util.addHashCode(it, fields, _hasSuperHashCode);
      }
    }
  }
}
