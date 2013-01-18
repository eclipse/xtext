package org.eclipse.xtend.core.tests.macro;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
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
    Pair<String,String> _mappedTo = Pair.<String, String>of("myannotation/AbstractAnnotation.xtend", _builder.toString());
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
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder_1.toString());
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
  
  @Test
  public void testPropertyAnnotation() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("myannotation/PropertyAnnotation.xtend", "\n\t\t\t\tpackage myannotation\n\t\t\t\t\n\t\t\t\timport java.util.List\n\t\t\t\timport org.eclipse.xtend.lib.macro.Active\n\t\t\t\timport org.eclipse.xtend.lib.macro.ModifyContext\n\t\t\t\timport org.eclipse.xtend.lib.macro.ModifyProcessor\n\t\t\t\timport org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration\n\n\t\t\t\t@Active(typeof(PropertyProcessor))\n\t\t\t\tannotation Property2 { }\n\t\t\t\tclass PropertyProcessor implements ModifyProcessor<MutableFieldDeclaration> {\n\t\t\t\t\t\n\t\t\t\t\textension ModifyContext ctx\n\t\t\t\t\t\n\t\t\t\t\toverride modify(List<? extends MutableFieldDeclaration> annotatedSourceFields, ModifyContext context) {\n\t\t\t\t\t\tctx = context\n\t\t\t\t\t\tannotatedSourceFields.forEach [ field |\n\t\t\t\t\t\t\tfield.declaringType.addMethod(field.getterName) [\n\t\t\t\t\t\t\t\tbody = [\'\'\'\n\t\t\t\t\t\t\t\t\treturn this.\u00ABfield.name\u00BB;\n\t\t\t\t\t\t\t\t\'\'\']\n\t\t\t\t\t\t\t]\n\t\t\t\t\t\t]\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tdef private String getterName(MutableFieldDeclaration field) {\n\t\t\t\t\t\treturn \'get\'+field.name.toFirstUpper\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myusercode");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@myannotation.Property2 String myField");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder.toString());
    final Procedure1<CompilationUnit> _function = new Procedure1<CompilationUnit>() {
        public void apply(final CompilationUnit it) {
          List<? extends ClassDeclaration> _generatedClassDeclarations = it.getGeneratedClassDeclarations();
          final ClassDeclaration clazz = IterableExtensions.head(_generatedClassDeclarations);
          List<? extends MemberDeclaration> _members = clazz.getMembers();
          Iterable<MutableMethodDeclaration> _filter = Iterables.<MutableMethodDeclaration>filter(_members, MutableMethodDeclaration.class);
          final MutableMethodDeclaration getter = IterableExtensions.<MutableMethodDeclaration>head(_filter);
          String _name = getter.getName();
          Assert.assertEquals("getMyField", _name);
        }
      };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
  
  public abstract void assertProcessing(final Pair<String,String> macroFile, final Pair<String,String> clientFile, final Procedure1<? super CompilationUnit> expectations);
}
