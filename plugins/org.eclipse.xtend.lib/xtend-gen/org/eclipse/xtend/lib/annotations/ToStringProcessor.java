package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtend.lib.annotations.ToStringConfiguration;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public class ToStringProcessor extends AbstractClassProcessor {
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
    
    public boolean hasToString(final ClassDeclaration it) {
      MethodDeclaration _findDeclaredMethod = it.findDeclaredMethod("toString");
      return (_findDeclaredMethod != null);
    }
    
    public ToStringConfiguration getToStringConfig(final ClassDeclaration it) {
      ToStringConfiguration _xblockexpression = null;
      {
        Type _findTypeGlobally = this.context.findTypeGlobally(ToString.class);
        final AnnotationReference anno = it.findAnnotation(_findTypeGlobally);
        ToStringConfiguration _xifexpression = null;
        boolean _tripleEquals = (anno == null);
        if (_tripleEquals) {
          _xifexpression = null;
        } else {
          _xifexpression = new ToStringConfiguration(anno);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
    
    public void addReflectiveToString(final MutableClassDeclaration cls, final ToStringConfiguration config) {
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          NamedElement _primarySourceElement = Util.this.context.getPrimarySourceElement(cls);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          TypeReference _string = Util.this.context.getString();
          it.setReturnType(_string);
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Override.class);
          it.addAnnotation(_newAnnotationReference);
          AnnotationReference _newAnnotationReference_1 = Util.this.context.newAnnotationReference(Pure.class);
          it.addAnnotation(_newAnnotationReference_1);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("String result = new ");
              _builder.append(ToStringBuilder.class, "");
              _builder.append("(this)");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(".addAllFields()");
              _builder.newLine();
              _builder.append("\t");
              {
                boolean _isSkipNulls = config.isSkipNulls();
                if (_isSkipNulls) {
                  _builder.append(".skipNulls()");
                }
              }
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              {
                boolean _isSingleLine = config.isSingleLine();
                if (_isSingleLine) {
                  _builder.append(".singleLine()");
                }
              }
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              {
                boolean _isHideFieldNames = config.isHideFieldNames();
                if (_isHideFieldNames) {
                  _builder.append(".hideFieldNames()");
                }
              }
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(".toString();");
              _builder.newLine();
              _builder.append("return result;");
              _builder.newLine();
            }
          };
          it.setBody(_client);
        }
      };
      cls.addMethod("toString", _function);
    }
    
    public void addToString(final MutableClassDeclaration cls, final Iterable<? extends FieldDeclaration> fields, final ToStringConfiguration config) {
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          NamedElement _primarySourceElement = Util.this.context.getPrimarySourceElement(cls);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          TypeReference _string = Util.this.context.getString();
          it.setReturnType(_string);
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Override.class);
          it.addAnnotation(_newAnnotationReference);
          AnnotationReference _newAnnotationReference_1 = Util.this.context.newAnnotationReference(Pure.class);
          it.addAnnotation(_newAnnotationReference_1);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append(ToStringBuilder.class, "");
              _builder.append(" b = new ");
              _builder.append(ToStringBuilder.class, "");
              _builder.append("(this);");
              _builder.newLineIfNotEmpty();
              {
                boolean _isSkipNulls = config.isSkipNulls();
                if (_isSkipNulls) {
                  _builder.append("b.skipNulls();");
                }
              }
              _builder.newLineIfNotEmpty();
              {
                boolean _isSingleLine = config.isSingleLine();
                if (_isSingleLine) {
                  _builder.append("b.singleLine();");
                }
              }
              _builder.newLineIfNotEmpty();
              {
                boolean _isHideFieldNames = config.isHideFieldNames();
                if (_isHideFieldNames) {
                  _builder.append("b.hideFieldNames();");
                }
              }
              _builder.newLineIfNotEmpty();
              {
                for(final FieldDeclaration field : fields) {
                  _builder.append("b.add(\"");
                  String _simpleName = field.getSimpleName();
                  _builder.append(_simpleName, "");
                  _builder.append("\", this.");
                  String _simpleName_1 = field.getSimpleName();
                  _builder.append(_simpleName_1, "");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("return b.toString();");
              _builder.newLine();
            }
          };
          it.setBody(_client);
        }
      };
      cls.addMethod("toString", _function);
    }
  }
  
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    Type _findTypeGlobally = context.findTypeGlobally(Data.class);
    AnnotationReference _findAnnotation = it.findAnnotation(_findTypeGlobally);
    boolean _tripleNotEquals = (_findAnnotation != null);
    if (_tripleNotEquals) {
      return;
    }
    @Extension
    final ToStringProcessor.Util util = new ToStringProcessor.Util(context);
    Type _findTypeGlobally_1 = context.findTypeGlobally(ToString.class);
    final AnnotationReference annotation = it.findAnnotation(_findTypeGlobally_1);
    final ToStringConfiguration configuration = new ToStringConfiguration(annotation);
    boolean _hasToString = util.hasToString(it);
    if (_hasToString) {
      context.addWarning(annotation, "toString is already defined, this annotation has no effect.");
    } else {
      TypeReference _extendedClass = it.getExtendedClass();
      TypeReference _object = context.getObject();
      boolean _notEquals = (!Objects.equal(_extendedClass, _object));
      if (_notEquals) {
        util.addReflectiveToString(it, configuration);
      } else {
        Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
        final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
          public Boolean apply(final MutableFieldDeclaration it) {
            boolean _and = false;
            boolean _and_1 = false;
            boolean _isThePrimaryGeneratedJavaElement = context.isThePrimaryGeneratedJavaElement(it);
            if (!_isThePrimaryGeneratedJavaElement) {
              _and_1 = false;
            } else {
              boolean _isStatic = it.isStatic();
              boolean _not = (!_isStatic);
              _and_1 = _not;
            }
            if (!_and_1) {
              _and = false;
            } else {
              boolean _isTransient = it.isTransient();
              boolean _not_1 = (!_isTransient);
              _and = _not_1;
            }
            return Boolean.valueOf(_and);
          }
        };
        Iterable<? extends MutableFieldDeclaration> _filter = IterableExtensions.filter(_declaredFields, _function);
        util.addToString(it, _filter, configuration);
      }
    }
  }
}
