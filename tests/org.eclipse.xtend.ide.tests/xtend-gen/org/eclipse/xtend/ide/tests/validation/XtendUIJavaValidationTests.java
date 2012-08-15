package org.eclipse.xtend.ide.tests.validation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage.Literals;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendUIJavaValidationTests extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;

  @Inject
  private ValidationTestHelper helper;

  @Test
  public void testForbiddenImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtext.ui.tests.restricted.RestrictedClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendImport> _imports = xtendFile.getImports();
      XtendImport _get = _imports.get(0);
      this.helper.assertError(_get, Literals.XTEND_IMPORT, IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDiscouragedImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtext.ui.tests.internal.InternalClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendImport> _imports = xtendFile.getImports();
      XtendImport _get = _imports.get(0);
      this.helper.assertWarning(_get, Literals.XTEND_IMPORT, IssueCodes.DISCOURAGED_REFERENCE);
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
      EList<XtendImport> _imports = xtendFile.getImports();
      XtendImport _get = _imports.get(0);
      this.helper.assertNoIssues(_get);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testForbiddenConstructorCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtext.ui.tests.restricted.RestrictedClass");
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
      EList<XtendImport> _imports = xtendFile.getImports();
      XtendImport _get = _imports.get(0);
      this.helper.assertError(_get, Literals.XTEND_IMPORT, IssueCodes.FORBIDDEN_REFERENCE);
      EList<XtendClass> _xtendClasses = xtendFile.getXtendClasses();
      XtendClass _get_1 = _xtendClasses.get(0);
      EList<XtendMember> _members = _get_1.getMembers();
      XtendMember _get_2 = _members.get(0);
      final XtendField field = ((XtendField) _get_2);
      JvmTypeReference _type = field.getType();
      this.helper.assertError(_type, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.FORBIDDEN_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertError(_initialValue, org.eclipse.xtext.xbase.XbasePackage.Literals.XCONSTRUCTOR_CALL, IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDiscouragedConstructorCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtext.ui.tests.internal.InternalClass");
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
      EList<XtendImport> _imports = xtendFile.getImports();
      XtendImport _get = _imports.get(0);
      this.helper.assertWarning(_get, Literals.XTEND_IMPORT, IssueCodes.DISCOURAGED_REFERENCE);
      EList<XtendClass> _xtendClasses = xtendFile.getXtendClasses();
      XtendClass _get_1 = _xtendClasses.get(0);
      EList<XtendMember> _members = _get_1.getMembers();
      XtendMember _get_2 = _members.get(0);
      final XtendField field = ((XtendField) _get_2);
      JvmTypeReference _type = field.getType();
      this.helper.assertWarning(_type, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.DISCOURAGED_REFERENCE);
      XExpression _initialValue = field.getInitialValue();
      this.helper.assertWarning(_initialValue, org.eclipse.xtext.xbase.XbasePackage.Literals.XCONSTRUCTOR_CALL, IssueCodes.DISCOURAGED_REFERENCE);
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
      _builder.append("def bar(org.eclipse.xtext.ui.tests.restricted.RestrictedClass x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendClass> _xtendClasses = xtendFile.getXtendClasses();
      XtendClass _get = _xtendClasses.get(0);
      EList<XtendMember> _members = _get.getMembers();
      XtendMember _get_1 = _members.get(0);
      final XtendFunction function = ((XtendFunction) _get_1);
      EList<XtendParameter> _parameters = function.getParameters();
      XtendParameter _get_2 = _parameters.get(0);
      this.helper.assertError(_get_2, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDiscouragedTypeUsage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtext.ui.tests.internal.InternalClass x){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      EList<XtendClass> _xtendClasses = xtendFile.getXtendClasses();
      XtendClass _get = _xtendClasses.get(0);
      EList<XtendMember> _members = _get.getMembers();
      XtendMember _get_1 = _members.get(0);
      final XtendFunction function = ((XtendFunction) _get_1);
      EList<XtendParameter> _parameters = function.getParameters();
      XtendParameter _get_2 = _parameters.get(0);
      this.helper.assertWarning(_get_2, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
