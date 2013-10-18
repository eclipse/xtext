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
            return "\r\n";
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("blank_4", _function_4);
    final Procedure1<MutableMethodDeclaration> _function_5 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            return "\r";
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("blank_5", _function_5);
    final Procedure1<MutableMethodDeclaration> _function_6 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            return "\n\n";
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("newline_1", _function_6);
    final Procedure1<MutableMethodDeclaration> _function_7 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            return "\r\n\r\n";
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("newline_2", _function_7);
    final Procedure1<MutableMethodDeclaration> _function_8 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            return "\r\r";
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("newline_3", _function_8);
    final Procedure1<MutableMethodDeclaration> _function_9 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationContext it) {
            return "\n\r";
          }
        };
        it.setBody(_function);
      }
    };
    annotatedClass.addMethod("newline_4", _function_9);
    final Procedure1<MutableMethodDeclaration> _function_10 = new Procedure1<MutableMethodDeclaration>() {
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
    annotatedClass.addMethod("def_1", _function_10);
    final Procedure1<MutableMethodDeclaration> _function_11 = new Procedure1<MutableMethodDeclaration>() {
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
    annotatedClass.addMethod("def_2", _function_11);
    final Procedure1<MutableMethodDeclaration> _function_12 = new Procedure1<MutableMethodDeclaration>() {
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
    annotatedClass.addMethod("def_3", _function_12);
    final Procedure1<MutableMethodDeclaration> _function_13 = new Procedure1<MutableMethodDeclaration>() {
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
    annotatedClass.addMethod("def_4", _function_13);
  }
}
