package org.eclipse.xtend.ide.tests.validation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage.Literals;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendUIValidationTests extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private ValidationTestHelper helper;
  
  public void tearDown() throws Exception {
    this.testHelper.tearDown();
  }
  
  @Test
  public void testWrongPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package my.foo.pack");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertError(xtendFile, Literals.XTEND_FILE, IssueCodes.WRONG_PACKAGE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertError(_get, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDiscouragedImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertWarning(_get, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenImportInnerClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass$InnerRestrictedClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertError(_get, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDiscouragedImportInnerClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass$InnerInternalClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertWarning(_get, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testValidImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(List l){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertNoIssues(_get);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenConstructorCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("RestrictedClass x = new RestrictedClass");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertError(_get, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendField field = ((XtendField) _head_1);
      JvmTypeReference _type = field.getType();
      this.helper.assertError(_type, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertError(_initialValue, org.eclipse.xtext.xbase.XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDiscouragedConstructorCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("InternalClass x = new InternalClass");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertWarning(_get, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendField field = ((XtendField) _head_1);
      JvmTypeReference _type = field.getType();
      this.helper.assertWarning(_type, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertWarning(_initialValue, org.eclipse.xtext.xbase.XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDiscouragedConstructorCallInnernClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass$InnerInternalClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("InnerInternalClass x = new InnerInternalClass");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertWarning(_get, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendField field = ((XtendField) _head_1);
      JvmTypeReference _type = field.getType();
      this.helper.assertWarning(_type, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertWarning(_initialValue, org.eclipse.xtext.xbase.XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenConstructorCallInnerClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass$InnerRestrictedClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("InnerRestrictedClass x = new InnerRestrictedClass");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertError(_get, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendField field = ((XtendField) _head_1);
      JvmTypeReference _type = field.getType();
      this.helper.assertError(_type, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertError(_initialValue, org.eclipse.xtext.xbase.XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenTypeUsageInnernClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass$InnerRestrictedClass x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendFunction function = ((XtendFunction) _head_1);
      EList<XtendParameter> _parameters = function.getParameters();
      XtendParameter _get = _parameters.get(0);
      this.helper.assertError(_get, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDiscouragedTypeUsageInnernClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.internal.InternalClass$InnerInternalClass x){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendFunction function = ((XtendFunction) _head_1);
      EList<XtendParameter> _parameters = function.getParameters();
      XtendParameter _get = _parameters.get(0);
      this.helper.assertWarning(_get, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenTypeUsage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendFunction function = ((XtendFunction) _head_1);
      EList<XtendParameter> _parameters = function.getParameters();
      XtendParameter _get = _parameters.get(0);
      this.helper.assertError(_get, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParameterizedTypeReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass<org.eclipse.xtend.core.tests.internal.InternalClass> x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendFunction function = ((XtendFunction) _head_1);
      EList<XtendParameter> _parameters = function.getParameters();
      final XtendParameter parameter = _parameters.get(0);
      JvmTypeReference _parameterType = parameter.getParameterType();
      final JvmParameterizedTypeReference type = ((JvmParameterizedTypeReference) _parameterType);
      EList<JvmTypeReference> _arguments = type.getArguments();
      final JvmTypeReference typeParameter = _arguments.get(0);
      this.helper.assertError(type, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      this.helper.assertWarning(typeParameter, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Ignore(value = "Enable on demand")
  public void testPerformance_1() {
    this.testPerformance();
  }
  
  @Test
  @Ignore(value = "Enable on demand")
  public void testPerformance_2() {
    this.testPerformance();
  }
  
  public void testPerformance() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      {
        IntegerRange _upTo = new IntegerRange(0, 200);
        for(final Integer i : _upTo) {
          _builder.append("RestrictedClass x");
          _builder.append(i, "");
          _builder.append(" = new RestrictedClass");
          _builder.newLineIfNotEmpty();
          _builder.append("InternalClass y");
          _builder.append(i, "");
          _builder.append(" = new InternalClass");
          _builder.newLineIfNotEmpty();
          _builder.append("def bar(InternalClass p1");
          _builder.append(i, "");
          _builder.append(", RestrictedClass p2");
          _builder.append(i, "");
          _builder.append("){}");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.validate(xtendFile);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
