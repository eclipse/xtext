package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public abstract class AbstractActiveAnnotationsTest {
  @Test
  public void testSimpleModification() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myannotation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.ModifyContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.ModifyProcessor");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Active(typeof(AbstractProcessor))");
    _builder.newLine();
    _builder.append("annotation Abstract { }");
    _builder.newLine();
    _builder.append("class AbstractProcessor implements ModifyProcessor<MutableClassDeclaration> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension ModifyContext ctx");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override modify(List<? extends MutableClassDeclaration> annotatedSourceClasses, ModifyContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctx = context");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("annotatedSourceClasses.forEach [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("^abstract = true");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String,CharSequence> _mappedTo = Pair.<String, CharSequence>of("myannotation/AbstractAnnotation.xtend", _builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package myusercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@myannotation.Abstract");
    _builder_1.newLine();
    _builder_1.append("class MyClass {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String,CharSequence> _mappedTo_1 = Pair.<String, CharSequence>of("myusercode/UserCode.xtend", _builder_1);
    final Procedure1<CompilationUnit> _function = new Procedure1<CompilationUnit>() {
        public void apply(final CompilationUnit it) {
          List<? extends ClassDeclaration> _generatedClassDeclarations = it.getGeneratedClassDeclarations();
          final ClassDeclaration clazz = IterableExtensions.head(_generatedClassDeclarations);
          boolean _isAbstract = clazz.isAbstract();
          Assert.assertTrue(_isAbstract);
        }
      };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
  
  public abstract void assertProcessing(final Pair<String,CharSequence> macroFile, final Pair<String,CharSequence> clientFile, final Procedure1<? super CompilationUnit> expectations);
}
