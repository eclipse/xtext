/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import java.util.Arrays;
import java.util.Objects;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
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
    private static final int PRIME_VALUE = 31;

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
      final Function1<MethodDeclaration, Boolean> _function = (MethodDeclaration it_1) -> {
        return Boolean.valueOf(((Objects.equals(it_1.getSimpleName(), "equals") && (IterableExtensions.size(it_1.getParameters()) == 1)) && Objects.equals(IterableExtensions.head(it_1.getParameters()).getType(), this.context.getObject())));
      };
      return IterableExtensions.exists(it.getDeclaredMethods(), _function);
    }

    public boolean hasSuperEquals(final ClassDeclaration cls) {
      boolean _xblockexpression = false;
      {
        Type _type = cls.getExtendedClass().getType();
        final ClassDeclaration superClass = ((ClassDeclaration) _type);
        boolean _xifexpression = false;
        boolean _equals = this.context.newTypeReference(superClass).equals(this.context.getObject());
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
        Type _type = cls.getExtendedClass().getType();
        final ClassDeclaration superClass = ((ClassDeclaration) _type);
        boolean _xifexpression = false;
        boolean _equals = this.context.newTypeReference(superClass).equals(this.context.getObject());
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
      final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
        this.context.setPrimarySourceElement(it, this.context.getPrimarySourceElement(cls));
        it.setReturnType(this.context.getPrimitiveBoolean());
        it.addAnnotation(this.context.newAnnotationReference(Override.class));
        it.addAnnotation(this.context.newAnnotationReference(Pure.class));
        it.addParameter("obj", this.context.getObject());
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
            {
              int _size = IterableExtensions.size(includedFields);
              boolean _greaterThan = (_size > 0);
              if (_greaterThan) {
                TypeReference _newWildCardSelfTypeReference = Util.this.newWildCardSelfTypeReference(cls);
                _builder.append(_newWildCardSelfTypeReference);
                _builder.append(" other = (");
                TypeReference _newWildCardSelfTypeReference_1 = Util.this.newWildCardSelfTypeReference(cls);
                _builder.append(_newWildCardSelfTypeReference_1);
                _builder.append(") obj;");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              for(final FieldDeclaration field : includedFields) {
                StringConcatenationClient _contributeToEquals = Util.this.contributeToEquals(field);
                _builder.append(_contributeToEquals);
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("return true;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      cls.addMethod("equals", _function);
    }

    private TypeReference newWildCardSelfTypeReference(final ClassDeclaration cls) {
      final Function1<TypeParameterDeclaration, TypeReference> _function = (TypeParameterDeclaration it) -> {
        return this.context.newWildcardTypeReference(this.context.getObject());
      };
      return this.context.newTypeReference(cls, ((TypeReference[])Conversions.unwrapArray(IterableExtensions.map(cls.getTypeParameters(), _function), TypeReference.class)));
    }

    public StringConcatenationClient contributeToEquals(final FieldDeclaration it) {
      StringConcatenationClient _switchResult = null;
      String _name = this.orObject(it.getType()).getName();
      boolean _matched = false;
      String _name_1 = Double.TYPE.getName();
      if (Objects.equals(_name, _name_1)) {
        _matched=true;
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("if (");
            _builder.append(Double.class);
            _builder.append(".doubleToLongBits(other.");
            String _simpleName = it.getSimpleName();
            _builder.append(_simpleName);
            _builder.append(") != ");
            _builder.append(Double.class);
            _builder.append(".doubleToLongBits(this.");
            String _simpleName_1 = it.getSimpleName();
            _builder.append(_simpleName_1);
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
        if (Objects.equals(_name, _name_2)) {
          _matched=true;
          StringConcatenationClient _client_1 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("if (");
              _builder.append(Float.class);
              _builder.append(".floatToIntBits(other.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName);
              _builder.append(") != ");
              _builder.append(Float.class);
              _builder.append(".floatToIntBits(this.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1);
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
        if (Objects.equals(_name, _name_3)) {
          _matched=true;
        }
        if (!_matched) {
          String _name_4 = Integer.TYPE.getName();
          if (Objects.equals(_name, _name_4)) {
            _matched=true;
          }
        }
        if (!_matched) {
          String _name_5 = Character.TYPE.getName();
          if (Objects.equals(_name, _name_5)) {
            _matched=true;
          }
        }
        if (!_matched) {
          String _name_6 = Byte.TYPE.getName();
          if (Objects.equals(_name, _name_6)) {
            _matched=true;
          }
        }
        if (!_matched) {
          String _name_7 = Short.TYPE.getName();
          if (Objects.equals(_name, _name_7)) {
            _matched=true;
          }
        }
        if (!_matched) {
          String _name_8 = Long.TYPE.getName();
          if (Objects.equals(_name, _name_8)) {
            _matched=true;
          }
        }
        if (_matched) {
          StringConcatenationClient _client_2 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("if (other.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName);
              _builder.append(" != this.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1);
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
            _builder.append(_simpleName);
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
            _builder.append(_deepEquals);
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
      boolean _isArray = it.getType().isArray();
      if (_isArray) {
        StringConcatenationClient _xifexpression_1 = null;
        boolean _isPrimitive = it.getType().getArrayComponentType().isPrimitive();
        if (_isPrimitive) {
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append(Arrays.class);
              _builder.append(".equals(this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName);
              _builder.append(", other.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1);
              _builder.append(")");
            }
          };
          _xifexpression_1 = _client;
        } else {
          StringConcatenationClient _client_1 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append(Arrays.class);
              _builder.append(".deepEquals(this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName);
              _builder.append(", other.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1);
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
            _builder.append(_simpleName);
            _builder.append(".equals(other.");
            String _simpleName_1 = it.getSimpleName();
            _builder.append(_simpleName_1);
            _builder.append(")");
          }
        };
        _xifexpression = _client_2;
      }
      return _xifexpression;
    }

    public void addHashCode(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> includedFields, final boolean includeSuper) {
      String _xifexpression = null;
      if (includeSuper) {
        _xifexpression = "super.hashCode()";
      } else {
        _xifexpression = "1";
      }
      final String defaultBase = _xifexpression;
      final int fields = IterableExtensions.size(includedFields);
      final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
        this.context.setPrimarySourceElement(it, this.context.getPrimarySourceElement(cls));
        it.setReturnType(this.context.getPrimitiveInt());
        it.addAnnotation(this.context.newAnnotationReference(Override.class));
        it.addAnnotation(this.context.newAnnotationReference(Pure.class));
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            {
              if ((fields >= 2)) {
                _builder.append("final int prime = ");
                _builder.append(EqualsHashCodeProcessor.Util.PRIME_VALUE);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("int result = ");
                _builder.append(defaultBase);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                {
                  ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, fields, true);
                  for(final Integer i : _doubleDotLessThan) {
                    {
                      if (((i).intValue() == (fields - 1))) {
                        _builder.append("return");
                      } else {
                        _builder.append("result =");
                      }
                    }
                    _builder.append(" prime * result + ");
                    StringConcatenationClient _contributeToHashCode = Util.this.contributeToHashCode(((FieldDeclaration[])Conversions.unwrapArray(includedFields, FieldDeclaration.class))[(i).intValue()]);
                    _builder.append(_contributeToHashCode);
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                if ((fields == 1)) {
                  _builder.append("return ");
                  _builder.append(EqualsHashCodeProcessor.Util.PRIME_VALUE);
                  _builder.append(" * ");
                  _builder.append(defaultBase);
                  _builder.append(" + ");
                  StringConcatenationClient _contributeToHashCode_1 = Util.this.contributeToHashCode(IterableExtensions.head(includedFields));
                  _builder.append(_contributeToHashCode_1);
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("return ");
                  _builder.append(defaultBase);
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        };
        it.setBody(_client);
      };
      cls.addMethod("hashCode", _function);
    }

    public StringConcatenationClient contributeToHashCode(final FieldDeclaration it) {
      StringConcatenationClient _switchResult = null;
      String _name = this.orObject(it.getType()).getName();
      boolean _matched = false;
      String _name_1 = Double.TYPE.getName();
      if (Objects.equals(_name, _name_1)) {
        _matched=true;
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("(int) (");
            _builder.append(Double.class);
            _builder.append(".doubleToLongBits(this.");
            String _simpleName = it.getSimpleName();
            _builder.append(_simpleName);
            _builder.append(") ^ (");
            _builder.append(Double.class);
            _builder.append(".doubleToLongBits(this.");
            String _simpleName_1 = it.getSimpleName();
            _builder.append(_simpleName_1);
            _builder.append(") >>> 32))");
          }
        };
        _switchResult = _client;
      }
      if (!_matched) {
        String _name_2 = Float.TYPE.getName();
        if (Objects.equals(_name, _name_2)) {
          _matched=true;
          StringConcatenationClient _client_1 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append(Float.class);
              _builder.append(".floatToIntBits(this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName);
              _builder.append(")");
            }
          };
          _switchResult = _client_1;
        }
      }
      if (!_matched) {
        String _name_3 = Boolean.TYPE.getName();
        if (Objects.equals(_name, _name_3)) {
          _matched=true;
          StringConcatenationClient _client_2 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("(this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName);
              _builder.append(" ? 1231 : 1237)");
            }
          };
          _switchResult = _client_2;
        }
      }
      if (!_matched) {
        String _name_4 = Integer.TYPE.getName();
        if (Objects.equals(_name, _name_4)) {
          _matched=true;
        }
        if (!_matched) {
          String _name_5 = Character.TYPE.getName();
          if (Objects.equals(_name, _name_5)) {
            _matched=true;
          }
        }
        if (!_matched) {
          String _name_6 = Byte.TYPE.getName();
          if (Objects.equals(_name, _name_6)) {
            _matched=true;
          }
        }
        if (!_matched) {
          String _name_7 = Short.TYPE.getName();
          if (Objects.equals(_name, _name_7)) {
            _matched=true;
          }
        }
        if (_matched) {
          StringConcatenationClient _client_3 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName);
            }
          };
          _switchResult = _client_3;
        }
      }
      if (!_matched) {
        String _name_8 = Long.TYPE.getName();
        if (Objects.equals(_name, _name_8)) {
          _matched=true;
          StringConcatenationClient _client_4 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("(int) (this.");
              String _simpleName = it.getSimpleName();
              _builder.append(_simpleName);
              _builder.append(" ^ (this.");
              String _simpleName_1 = it.getSimpleName();
              _builder.append(_simpleName_1);
              _builder.append(" >>> 32))");
            }
          };
          _switchResult = _client_4;
        }
      }
      if (!_matched) {
        StringConcatenationClient _client_5 = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("((this.");
            String _simpleName = it.getSimpleName();
            _builder.append(_simpleName);
            _builder.append("== null) ? 0 : ");
            StringConcatenationClient _deepHashCode = Util.this.deepHashCode(it);
            _builder.append(_deepHashCode);
            _builder.append(")");
          }
        };
        _switchResult = _client_5;
      }
      return _switchResult;
    }

    public StringConcatenationClient deepHashCode(final FieldDeclaration it) {
      StringConcatenationClient _xblockexpression = null;
      {
        final TypeReference type = this.orObject(it.getType());
        StringConcatenationClient _xifexpression = null;
        boolean _isArray = type.isArray();
        if (_isArray) {
          StringConcatenationClient _xifexpression_1 = null;
          boolean _isPrimitive = type.getArrayComponentType().isPrimitive();
          if (_isPrimitive) {
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append(Arrays.class);
                _builder.append(".hashCode(this.");
                String _simpleName = it.getSimpleName();
                _builder.append(_simpleName);
                _builder.append(")");
              }
            };
            _xifexpression_1 = _client;
          } else {
            StringConcatenationClient _client_1 = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append(Arrays.class);
                _builder.append(".deepHashCode(this.");
                String _simpleName = it.getSimpleName();
                _builder.append(_simpleName);
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
              _builder.append(_simpleName);
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
    AnnotationReference _findAnnotation = it.findAnnotation(context.findTypeGlobally(Data.class));
    boolean _tripleNotEquals = (_findAnnotation != null);
    if (_tripleNotEquals) {
      return;
    }
    @Extension
    final EqualsHashCodeProcessor.Util util = new EqualsHashCodeProcessor.Util(context);
    boolean _hasEquals = util.hasEquals(it);
    if (_hasEquals) {
      final AnnotationReference annotation = it.findAnnotation(context.findTypeGlobally(EqualsHashCode.class));
      context.addWarning(annotation, "equals is already defined, this annotation has no effect");
    } else {
      boolean _hasHashCode = util.hasHashCode(it);
      if (_hasHashCode) {
        context.addWarning(it, "hashCode is already defined, this annotation has no effect");
      } else {
        final Function1<MutableFieldDeclaration, Boolean> _function = (MutableFieldDeclaration it_1) -> {
          return Boolean.valueOf((((!it_1.isStatic()) && (!it_1.isTransient())) && context.isThePrimaryGeneratedJavaElement(it_1)));
        };
        final Iterable<? extends MutableFieldDeclaration> fields = IterableExtensions.filter(it.getDeclaredFields(), _function);
        util.addEquals(it, fields, util.hasSuperEquals(it));
        util.addHashCode(it, fields, util.hasSuperHashCode(it));
      }
    }
  }
}
