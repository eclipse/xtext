package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AccessorsProcessor implements TransformationParticipant<MutableFieldDeclaration> {
  public void doTransform(final List<? extends MutableFieldDeclaration> javaFields, @Extension final TransformationContext context) {
    for (final MutableFieldDeclaration f : javaFields) {
      {
        String _simpleName = f.getSimpleName();
        String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
        final String getterName = ("get" + _firstUpper);
        String _simpleName_1 = f.getSimpleName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_simpleName_1);
        final String setterName = ("set" + _firstUpper_1);
        MutableTypeDeclaration _declaringType = f.getDeclaringType();
        final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
          public void apply(final MutableMethodDeclaration it) {
            TypeReference _type = f.getType();
            it.setReturnType(_type);
            final CompilationStrategy _function = new CompilationStrategy() {
              public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("return ");
                String _simpleName = f.getSimpleName();
                _builder.append(_simpleName, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                return _builder;
              }
            };
            it.setBody(_function);
          }
        };
        this.tryAddMethod(_declaringType, getterName, _function);
        boolean _isFinal = f.isFinal();
        boolean _not = (!_isFinal);
        if (_not) {
          MutableTypeDeclaration _declaringType_1 = f.getDeclaringType();
          final Procedure1<MutableMethodDeclaration> _function_1 = new Procedure1<MutableMethodDeclaration>() {
            public void apply(final MutableMethodDeclaration it) {
              TypeReference _primitiveVoid = context.getPrimitiveVoid();
              it.setReturnType(_primitiveVoid);
              String _simpleName = f.getSimpleName();
              TypeReference _type = f.getType();
              it.addParameter(_simpleName, _type);
              final CompilationStrategy _function = new CompilationStrategy() {
                public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("this.");
                  String _simpleName = f.getSimpleName();
                  _builder.append(_simpleName, "");
                  _builder.append(" = ");
                  String _simpleName_1 = f.getSimpleName();
                  _builder.append(_simpleName_1, "");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  return _builder;
                }
              };
              it.setBody(_function);
            }
          };
          this.tryAddMethod(_declaringType_1, setterName, _function_1);
        }
      }
    }
  }
  
  public MutableMethodDeclaration tryAddMethod(final MutableTypeDeclaration it, final String name, final Procedure1<? super MutableMethodDeclaration> initializer) {
    MutableMethodDeclaration _elvis = null;
    MutableMethodDeclaration _findDeclaredMethod = it.findDeclaredMethod(name);
    if (_findDeclaredMethod != null) {
      _elvis = _findDeclaredMethod;
    } else {
      MutableMethodDeclaration _addMethod = it.addMethod(name, (Procedure1<MutableMethodDeclaration>)initializer);
      _elvis = ObjectExtensions.<MutableMethodDeclaration>operator_elvis(_findDeclaredMethod, _addMethod);
    }
    return _elvis;
  }
}
