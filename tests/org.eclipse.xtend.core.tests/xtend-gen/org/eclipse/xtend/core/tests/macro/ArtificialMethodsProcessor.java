package org.eclipse.xtend.core.tests.macro;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy.CompilationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtend2.lib.StringConcatenationClient.TargetStringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ArtificialMethodsProcessor extends AbstractClassProcessor {
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            return _builder;
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("blank", _function);
    final Procedure1<MutableMethodDeclaration> _function_1 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("\t\t\t\t");
            _builder.newLine();
            return _builder;
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("blank_1", _function_1);
    final Procedure1<MutableMethodDeclaration> _function_2 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            return "";
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("blank_2", _function_2);
    final Procedure1<MutableMethodDeclaration> _function_3 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            return "\n";
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("blank_3", _function_3);
    final Procedure1<MutableMethodDeclaration> _function_4 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("int foo = 42;");
            _builder.newLine();
            return _builder;
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("blank_4", _function_4);
    final Procedure1<MutableMethodDeclaration> _function_5 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(TargetStringConcatenation _builder) {
            _builder.append("int foo = 42;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      }
    };
    annotatedClass.addMethod("blank_5", _function_5);
    final Procedure1<MutableMethodDeclaration> _function_6 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(TargetStringConcatenation _builder) {
            _builder.append("int foo = 42;");
          }
        };
        it.setBody(_client);
      }
    };
    annotatedClass.addMethod("blank_6", _function_6);
    final Procedure1<MutableMethodDeclaration> _function_7 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(TargetStringConcatenation _builder) {
            _builder.append(List.class, "");
            _builder.append("<? extends Object> list = new ");
            _builder.append(ArrayList.class, "");
            _builder.append("<");
            _builder.append(BigDecimal.class, "");
            _builder.append(">();");
          }
        };
        it.setBody(_client);
      }
    };
    annotatedClass.addMethod("blank_7", _function_7);
  }
}
