package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import org.eclipse.xtend.lib.ValueObjectProcessor;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @since 2.7
 */
@Beta
@SuppressWarnings("all")
public class EqualsHashCodeProcessor extends AbstractClassProcessor {
  /**
   * @since 2.7
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
    
    public void addEquals(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> includedFields, final boolean includeSuper) {
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
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
              String _simpleName = cls.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" other = (");
              String _simpleName_1 = cls.getSimpleName();
              _builder.append(_simpleName_1, "");
              _builder.append(") obj;");
              _builder.newLineIfNotEmpty();
              {
                for(final FieldDeclaration field : includedFields) {
                  String _contributeToEquals = Util.this.contributeToEquals(field);
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
          _builder_1.append("if (Float.floatToIntBits(other.");
          String _simpleName_2 = it.getSimpleName();
          _builder_1.append(_simpleName_2, "");
          _builder_1.append(") != Float.floatToIntBits(this.");
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
    
    public void addHashCode(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> includedFields, final boolean includeSuper) {
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
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
                  String _contributeToHashCode = Util.this.contributeToHashCode(field);
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
        _switchResult = (_plus_11 + 
          ".hashCode());");
      }
      return _switchResult;
    }
  }
  
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final EqualsHashCodeProcessor.Util util = new EqualsHashCodeProcessor.Util(context);
    @Extension
    final ValueObjectProcessor.Util voUtil = new ValueObjectProcessor.Util(context);
    boolean _hasEquals = util.hasEquals(it);
    if (_hasEquals) {
      context.addWarning(it, "equals is already defined, this annotation has no effect");
    } else {
      boolean _hasHashCode = util.hasHashCode(it);
      if (_hasHashCode) {
        context.addWarning(it, "hashCode is already defined, this annotation has no effect");
      } else {
        TypeReference _extendedClass = it.getExtendedClass();
        TypeReference _object = context.getObject();
        final boolean hasSuperClass = (!Objects.equal(_extendedClass, _object));
        Iterable<? extends MutableFieldDeclaration> _valueObjectFields = voUtil.getValueObjectFields(it);
        util.addEquals(it, _valueObjectFields, hasSuperClass);
        Iterable<? extends MutableFieldDeclaration> _valueObjectFields_1 = voUtil.getValueObjectFields(it);
        util.addHashCode(it, _valueObjectFields_1, hasSuperClass);
      }
    }
  }
}
