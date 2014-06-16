package org.eclipse.xtend.lib.macro;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import java.lang.annotation.Annotation;
import org.eclipse.xtend.lib.macro.CommonQueries;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

/**
 * @since 2.7
 */
@Beta
@SuppressWarnings("all")
public class CommonTransformations {
  @Extension
  private TransformationContext context;
  
  public CommonTransformations(final TransformationContext context) {
    this.context = context;
  }
  
  public void addGetter(final MutableFieldDeclaration field) {
    field.markAsRead();
    MutableTypeDeclaration _declaringType = field.getDeclaringType();
    String _getterName = CommonQueries.getGetterName(field);
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        CommonTransformations.this.addAnnotation(it, Pure.class);
        TypeReference _type = field.getType();
        it.setReturnType(_type);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("return this.");
            String _simpleName = field.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(";");
          }
        };
        it.setBody(_client);
      }
    };
    _declaringType.addMethod(_getterName, _function);
  }
  
  public void addSetter(final MutableFieldDeclaration field) {
    boolean _isFinal = field.isFinal();
    if (_isFinal) {
      this.context.addError(field, "Cannot set a final field");
      return;
    }
    TypeReference _type = field.getType();
    boolean _isInferred = _type.isInferred();
    if (_isInferred) {
      this.context.addError(field, "Type cannot be inferred.");
      return;
    }
    MutableTypeDeclaration _declaringType = field.getDeclaringType();
    String _setterName = CommonQueries.getSetterName(field);
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _primitiveVoid = CommonTransformations.this.context.getPrimitiveVoid();
        it.setReturnType(_primitiveVoid);
        String _simpleName = field.getSimpleName();
        TypeReference _type = field.getType();
        final MutableParameterDeclaration param = it.addParameter(_simpleName, _type);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("this.");
            String _simpleName = field.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" = ");
            String _simpleName_1 = param.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append(";");
          }
        };
        it.setBody(_client);
      }
    };
    _declaringType.addMethod(_setterName, _function);
  }
  
  public void addHashCode(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> includedFields, final boolean includeSuper) {
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _primitiveInt = CommonTransformations.this.context.getPrimitiveInt();
        it.setReturnType(_primitiveInt);
        CommonTransformations.this.addAnnotation(it, Override.class);
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
                String _contributeToHashCode = CommonTransformations.this.contributeToHashCode(field);
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
  
  private String contributeToHashCode(final FieldDeclaration it) {
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
  
  public void addEquals(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> includedFields, final boolean includeSuper) {
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _primitiveBoolean = CommonTransformations.this.context.getPrimitiveBoolean();
        it.setReturnType(_primitiveBoolean);
        CommonTransformations.this.addAnnotation(it, Override.class);
        CommonTransformations.this.addAnnotation(it, Pure.class);
        TypeReference _object = CommonTransformations.this.context.getObject();
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
                String _contributeToEquals = CommonTransformations.this.contributeToEquals(field);
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
  
  private String contributeToEquals(final FieldDeclaration it) {
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
  
  public void addReflectiveToString(final MutableClassDeclaration cls) {
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _string = CommonTransformations.this.context.getString();
        it.setReturnType(_string);
        CommonTransformations.this.addAnnotation(it, Override.class);
        CommonTransformations.this.addAnnotation(it, Pure.class);
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
  
  public void addToString(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> fields) {
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _string = CommonTransformations.this.context.getString();
        it.setReturnType(_string);
        CommonTransformations.this.addAnnotation(it, Override.class);
        CommonTransformations.this.addAnnotation(it, Pure.class);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("StringBuilder b = new StringBuilder(\"");
            String _simpleName = cls.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("b.append(\"{\");");
            _builder.newLine();
            {
              boolean _hasElements = false;
              for(final FieldDeclaration field : fields) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate("\nb.append(\", \");", "");
                }
                _builder.append("b.append(\"");
                String _simpleName_1 = field.getSimpleName();
                _builder.append(_simpleName_1, "");
                _builder.append("=\");");
                _builder.newLineIfNotEmpty();
                _builder.append("b.append(");
                String _simpleName_2 = field.getSimpleName();
                _builder.append(_simpleName_2, "");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("b.append(\"}\");");
            _builder.newLine();
            _builder.append("return b.toString();");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      }
    };
    cls.addMethod("toString", _function);
  }
  
  public void addAnnotation(final MutableAnnotationTarget it, final Class<? extends Annotation> annotation) {
    AnnotationReference _newAnnotationReference = this.context.newAnnotationReference(annotation);
    it.addAnnotation(_newAnnotationReference);
  }
}
