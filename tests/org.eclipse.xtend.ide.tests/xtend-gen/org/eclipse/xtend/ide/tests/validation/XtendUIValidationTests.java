package org.eclipse.xtend.ide.tests.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.JavaModel;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendUIValidationTests extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private IPreferenceStoreAccess prefStoreAccess;
  
  @Inject
  private OnChangeEvictingCache cache;
  
  @Override
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
      this.helper.assertError(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.WRONG_PACKAGE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWrongFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertWarning(xtendFile, XtendPackage.Literals.XTEND_TYPE_DECLARATION, IssueCodes.WRONG_FILE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoWrongFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertNoWarnings(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.WRONG_FILE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertError(_get, XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertWarning(_get, XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertError(_get, XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertWarning(_get, XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
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
      _builder.append("def bar(List<?> l){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Foo.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertNoIssues(_get);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertError(_get, XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendField field = ((XtendField) _head_1);
      JvmTypeReference _type = field.getType();
      this.helper.assertError(_type, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertError(_initialValue, XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertWarning(_get, XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendField field = ((XtendField) _head_1);
      JvmTypeReference _type = field.getType();
      this.helper.assertWarning(_type, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertWarning(_initialValue, XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertWarning(_get, XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendField field = ((XtendField) _head_1);
      JvmTypeReference _type = field.getType();
      this.helper.assertWarning(_type, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertWarning(_initialValue, XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XImportSection _importSection = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
      XImportDeclaration _get = _importDeclarations.get(0);
      this.helper.assertError(_get, XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendField field = ((XtendField) _head_1);
      JvmTypeReference _type = field.getType();
      this.helper.assertError(_type, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertError(_initialValue, XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendFunction function = ((XtendFunction) _head_1);
      EList<XtendParameter> _parameters = function.getParameters();
      XtendParameter _get = _parameters.get(0);
      this.helper.assertError(_get, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendFunction function = ((XtendFunction) _head_1);
      EList<XtendParameter> _parameters = function.getParameters();
      XtendParameter _get = _parameters.get(0);
      this.helper.assertWarning(_get, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
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
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendFunction function = ((XtendFunction) _head_1);
      EList<XtendParameter> _parameters = function.getParameters();
      XtendParameter _get = _parameters.get(0);
      this.helper.assertError(_get, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenArrayTypeUsage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass[] x) {}");
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
      XtendParameter _get = _parameters.get(0);
      this.helper.assertError(_get, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
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
      this.helper.assertError(type, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      this.helper.assertWarning(typeParameter, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Ignore("Enable on demand")
  public void testPerformance_1() {
    this.testPerformance();
  }
  
  @Test
  @Ignore("Enable on demand")
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIssueCodeDelegation() {
    try {
      JavaModelManager _javaModelManager = JavaModelManager.getJavaModelManager();
      JavaModel _javaModel = _javaModelManager.getJavaModel();
      IProject _project = this.testHelper.getProject();
      final IJavaProject javaProject = _javaModel.getJavaProject(_project);
      final String javaSeverity = javaProject.getOption(JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE, true);
      try {
        boolean _notEquals = (!Objects.equal(javaSeverity, "error"));
        if (_notEquals) {
          Assert.fail((("Wrong expectation Java compiler option \'" + JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE) + "\' should be \'error\' by default"));
        }
        String otherSeverity = "warning";
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class ValidationClazz {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass x) {}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        final XtendFile xtendFile = this.testHelper.xtendFile("ValidationClazz.xtend", _builder.toString());
        EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
        Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
        XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
        EList<XtendMember> _members = _head.getMembers();
        XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
        final XtendFunction function = ((XtendFunction) _head_1);
        EList<XtendParameter> _parameters = function.getParameters();
        XtendParameter _get = _parameters.get(0);
        this.helper.assertError(_get, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
        Resource _eResource = xtendFile.eResource();
        this.cache.clear(_eResource);
        javaProject.setOption(JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE, otherSeverity);
        EList<XtendParameter> _parameters_1 = function.getParameters();
        XtendParameter _get_1 = _parameters_1.get(0);
        this.helper.assertWarning(_get_1, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      } finally {
        javaProject.setOption(JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE, javaSeverity);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConfigurableIssueCode() {
    try {
      final IPersistentPreferenceStore xtendPrefStore = this.getXtendPreferencesStore();
      try {
        xtendPrefStore.setValue(IssueCodes.UNUSED_PRIVATE_MEMBER, "warning");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class TestConfigurableIssueCode {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private String unusedField = \"unusedField\"");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        XtendFile _xtendFile = this.testHelper.xtendFile("TestConfigurableIssueCode.xtend", _builder.toString());
        final Procedure1<XtendFile> _function = new Procedure1<XtendFile>() {
          @Override
          public void apply(final XtendFile it) {
            EList<XtendTypeDeclaration> _xtendTypes = it.getXtendTypes();
            Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
            XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
            EList<XtendMember> _members = _head.getMembers();
            final XtendMember unusedField = IterableExtensions.<XtendMember>head(_members);
            XtendUIValidationTests.this.helper.assertWarning(unusedField, XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNUSED_PRIVATE_MEMBER);
          }
        };
        ObjectExtensions.<XtendFile>operator_doubleArrow(_xtendFile, _function);
        xtendPrefStore.setValue(IssueCodes.UNUSED_PRIVATE_MEMBER, "error");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("class TestConfigurableIssueCode {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("private String unusedField = \"unusedField\"");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        XtendFile _xtendFile_1 = this.testHelper.xtendFile("TestConfigurableIssueCode.xtend", _builder_1.toString());
        final Procedure1<XtendFile> _function_1 = new Procedure1<XtendFile>() {
          @Override
          public void apply(final XtendFile it) {
            EList<XtendTypeDeclaration> _xtendTypes = it.getXtendTypes();
            Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
            XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
            EList<XtendMember> _members = _head.getMembers();
            final XtendMember unusedField = IterableExtensions.<XtendMember>head(_members);
            XtendUIValidationTests.this.helper.assertError(unusedField, XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNUSED_PRIVATE_MEMBER);
          }
        };
        ObjectExtensions.<XtendFile>operator_doubleArrow(_xtendFile_1, _function_1);
      } finally {
        xtendPrefStore.setToDefault(IssueCodes.UNUSED_PRIVATE_MEMBER);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaDocRefs_Delegation() throws Exception {
    JavaModelManager _javaModelManager = JavaModelManager.getJavaModelManager();
    JavaModel _javaModel = _javaModelManager.getJavaModel();
    IProject _project = this.testHelper.getProject();
    final IJavaProject javaProject = _javaModel.getJavaProject(_project);
    final String javaSeverity = javaProject.getOption(JavaCore.COMPILER_PB_INVALID_JAVADOC, true);
    try {
      boolean _notEquals = (!Objects.equal(javaSeverity, "ignore"));
      if (_notEquals) {
        Assert.fail((("Wrong expectation Java compiler option \'" + JavaCore.COMPILER_PB_INVALID_JAVADOC) + "\' should be \'ignore\' by default"));
      }
      String otherSeverity = "warning";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class ValidationClazz {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* {@link List}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def doStuff(){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("ValidationClazz.xtend", _builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      final XtendClass clazz = ((XtendClass) _head);
      EList<XtendMember> _members = clazz.getMembers();
      final XtendMember member = IterableExtensions.<XtendMember>head(_members);
      this.helper.assertNoIssues(member);
      Resource _eResource = xtendFile.eResource();
      this.cache.clear(_eResource);
      javaProject.setOption(JavaCore.COMPILER_PB_INVALID_JAVADOC, otherSeverity);
      this.helper.assertWarning(member, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, "javaDoc", "List", "cannot be resolved to a type");
    } finally {
      javaProject.setOption(JavaCore.COMPILER_PB_INVALID_JAVADOC, javaSeverity);
    }
  }
  
  public IPersistentPreferenceStore getXtendPreferencesStore() {
    IProject _project = this.testHelper.getProject();
    IPreferenceStore _writablePreferenceStore = this.prefStoreAccess.getWritablePreferenceStore(_project);
    return ((IPersistentPreferenceStore) _writablePreferenceStore);
  }
}
