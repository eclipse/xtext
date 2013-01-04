package org.eclipse.xtend.core.tests.macro.declaration;

import com.google.inject.Provider;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class DeclarationsTest extends AbstractXtendTestCase {
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  @Test
  public void testSimpleClassWithField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass extends Object implements java.io.Serializable {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("MyClass foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnit> _function = new Procedure1<CompilationUnit>() {
        public void apply(final CompilationUnit it) {
          String _packageName = it.getPackageName();
          Assert.assertEquals("foo", _packageName);
          List<TypeDeclaration> _sourceTypeDeclarations = it.getSourceTypeDeclarations();
          TypeDeclaration _head = IterableExtensions.<TypeDeclaration>head(_sourceTypeDeclarations);
          final ClassDeclaration clazz = ((ClassDeclaration) _head);
          String _name = clazz.getName();
          Assert.assertEquals("foo.MyClass", _name);
          TypeReference _superclass = clazz.getSuperclass();
          String _string = _superclass.toString();
          Assert.assertEquals("Object", _string);
          List<TypeReference> _implementedInterfaces = clazz.getImplementedInterfaces();
          TypeReference _head_1 = IterableExtensions.<TypeReference>head(_implementedInterfaces);
          String _string_1 = _head_1.toString();
          Assert.assertEquals("java.io.Serializable", _string_1);
          List<? extends MemberDeclaration> _members = clazz.getMembers();
          MemberDeclaration _head_2 = IterableExtensions.head(_members);
          final FieldDeclaration field = ((FieldDeclaration) _head_2);
          String _name_1 = field.getName();
          Assert.assertEquals("foo", _name_1);
          List<TypeDeclaration> _generatedTypeDeclarations = it.getGeneratedTypeDeclarations();
          TypeDeclaration _head_3 = IterableExtensions.<TypeDeclaration>head(_generatedTypeDeclarations);
          TypeReference _type = field.getType();
          Type _type_1 = _type.getType();
          Assert.assertSame(_head_3, _type_1);
        }
      };
    this.asCompilationUnit(_validFile, _function);
  }
  
  public XtendFile validFile(final CharSequence code) {
    try {
      String _string = code.toString();
      XtendFile _file = this.file(_string, true);
      return _file;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void asCompilationUnit(final XtendFile file, final Procedure1<? super CompilationUnit> block) {
    final CompilationUnitImpl compilationUnit = this.compilationUnitProvider.get();
    compilationUnit.setXtendFile(file);
    block.apply(compilationUnit);
  }
}
