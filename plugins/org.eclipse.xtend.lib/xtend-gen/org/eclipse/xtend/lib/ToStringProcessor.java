package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import org.eclipse.xtend.lib.ToString;
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
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

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
    
    public void addReflectiveToString(final MutableClassDeclaration cls) {
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
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
          TypeReference _string = Util.this.context.getString();
          it.setReturnType(_string);
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Override.class);
          it.addAnnotation(_newAnnotationReference);
          AnnotationReference _newAnnotationReference_1 = Util.this.context.newAnnotationReference(Pure.class);
          it.addAnnotation(_newAnnotationReference_1);
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
                  _builder.append("b.append(this.");
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
  }
  
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final ToStringProcessor.Util util = new ToStringProcessor.Util(context);
    @Extension
    final ValueObjectProcessor.Util voUtil = new ValueObjectProcessor.Util(context);
    boolean _hasToString = util.hasToString(it);
    if (_hasToString) {
      Type _findTypeGlobally = context.findTypeGlobally(ToString.class);
      final AnnotationReference annotation = it.findAnnotation(_findTypeGlobally);
      context.addWarning(annotation, "toString is already defined, this annotation has no effect.");
    } else {
      TypeReference _extendedClass = it.getExtendedClass();
      TypeReference _object = context.getObject();
      boolean _notEquals = (!Objects.equal(_extendedClass, _object));
      if (_notEquals) {
        util.addReflectiveToString(it);
      } else {
        Iterable<? extends MutableFieldDeclaration> _valueObjectFields = voUtil.getValueObjectFields(it);
        util.addToString(it, _valueObjectFields);
      }
    }
  }
}
