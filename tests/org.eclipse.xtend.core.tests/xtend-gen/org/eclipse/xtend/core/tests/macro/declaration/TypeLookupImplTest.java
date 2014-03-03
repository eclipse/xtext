package org.eclipse.xtend.core.tests.macro.declaration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.TypeLookupImpl;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TypeLookupImplTest extends AbstractXtendTestCase {
  @Test
  public void testFindClass_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {}");
    _builder.newLine();
    _builder.append("enum MyEnum {}");
    _builder.newLine();
    _builder.append("interface MyInterface {}");
    _builder.newLine();
    _builder.append("annotation MyAnnotation {}");
    _builder.newLine();
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        MutableClassDeclaration _findClass = _typeLookup.findClass("foo.MyClass");
        Assert.assertNotNull(_findClass);
        TypeLookupImpl _typeLookup_1 = it.getTypeLookup();
        MutableClassDeclaration _findClass_1 = _typeLookup_1.findClass("foo.MyClass.Unknown");
        Assert.assertNull(_findClass_1);
        TypeLookupImpl _typeLookup_2 = it.getTypeLookup();
        MutableClassDeclaration _findClass_2 = _typeLookup_2.findClass("foo.MyInterface");
        Assert.assertNull(_findClass_2);
        TypeLookupImpl _typeLookup_3 = it.getTypeLookup();
        MutableEnumerationTypeDeclaration _findEnumerationType = _typeLookup_3.findEnumerationType("foo.MyEnum");
        Assert.assertNotNull(_findEnumerationType);
        TypeLookupImpl _typeLookup_4 = it.getTypeLookup();
        MutableAnnotationTypeDeclaration _findAnnotationType = _typeLookup_4.findAnnotationType("foo.MyAnnotation");
        Assert.assertNotNull(_findAnnotationType);
        TypeLookupImpl _typeLookup_5 = it.getTypeLookup();
        MutableInterfaceDeclaration _findInterface = _typeLookup_5.findInterface("foo.MyInterface");
        Assert.assertNotNull(_findInterface);
        TypeLookupImpl _typeLookup_6 = it.getTypeLookup();
        MutableClassDeclaration _findClass_3 = _typeLookup_6.findClass("java.lang.String");
        Assert.assertNull(_findClass_3);
      }
    };
    this.asCompilationUnit(_validFile, _function);
  }
  
  @Test
  public void testFindClass_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.tests.macro.declaration.AddNestedTypes");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@AddNestedTypes class MyClass {}");
    _builder.newLine();
    _builder.append("@AddNestedTypes enum MyEnum {}");
    _builder.newLine();
    _builder.append("@AddNestedTypes interface MyInterface {}");
    _builder.newLine();
    _builder.append("@AddNestedTypes annotation MyAnnotation {}");
    _builder.newLine();
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        MutableClassDeclaration _findClass = _typeLookup.findClass("foo.MyClass.NestedClass");
        Assert.assertNotNull(_findClass);
        TypeLookupImpl _typeLookup_1 = it.getTypeLookup();
        MutableInterfaceDeclaration _findInterface = _typeLookup_1.findInterface("foo.MyClass.NestedInterface");
        Assert.assertNotNull(_findInterface);
        TypeLookupImpl _typeLookup_2 = it.getTypeLookup();
        MutableEnumerationTypeDeclaration _findEnumerationType = _typeLookup_2.findEnumerationType("foo.MyClass.NestedEnumerationType");
        Assert.assertNotNull(_findEnumerationType);
        TypeLookupImpl _typeLookup_3 = it.getTypeLookup();
        MutableAnnotationTypeDeclaration _findAnnotationType = _typeLookup_3.findAnnotationType("foo.MyClass.NestedAnnotationType");
        Assert.assertNotNull(_findAnnotationType);
      }
    };
    this.asCompilationUnit(_validFile, _function);
  }
  
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  @Inject
  private ProcessorInstanceForJvmTypeProvider instanceForJvmTypeProvider;
  
  public XtendFile validFile(final CharSequence code) {
    try {
      XtendFile _xblockexpression = null;
      {
        Class<? extends TypeLookupImplTest> _class = this.getClass();
        ClassLoader _classLoader = _class.getClassLoader();
        this.instanceForJvmTypeProvider.setClassLoader(_classLoader);
        String _string = code.toString();
        _xblockexpression = (this.file(_string, true));
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void asCompilationUnit(final XtendFile file, final Procedure1<? super CompilationUnitImpl> block) {
    final CompilationUnitImpl compilationUnit = this.compilationUnitProvider.get();
    compilationUnit.setXtendFile(file);
    block.apply(compilationUnit);
  }
}
