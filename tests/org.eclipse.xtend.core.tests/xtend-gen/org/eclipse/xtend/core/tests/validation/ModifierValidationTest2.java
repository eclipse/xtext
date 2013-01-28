package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.validation.ModifierValidationTest;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage.Literals;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class ModifierValidationTest2 extends ModifierValidationTest {
  @Inject
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testMethodInInterfaceAllowedModifiers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private def foo() {}");
    XtendMember _memberInInterface = this.memberInInterface(_builder.toString());
    this._validationTestHelper.assertError(_memberInInterface, Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package def foo() {}");
    XtendMember _memberInInterface_1 = this.memberInInterface(_builder_1.toString());
    this._validationTestHelper.assertError(_memberInInterface_1, Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("protected def foo() {}");
    XtendMember _memberInInterface_2 = this.memberInInterface(_builder_2.toString());
    this._validationTestHelper.assertError(_memberInInterface_2, Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("public def foo() {}");
    XtendMember _memberInInterface_3 = this.memberInInterface(_builder_3.toString());
    this._validationTestHelper.assertNoError(_memberInInterface_3, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("static def foo() {}");
    XtendMember _memberInInterface_4 = this.memberInInterface(_builder_4.toString());
    this._validationTestHelper.assertError(_memberInInterface_4, Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("abstract def int foo()");
    XtendMember _memberInInterface_5 = this.memberInInterface(_builder_5.toString());
    this._validationTestHelper.assertNoErrors(_memberInInterface_5);
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("final def foo() {}");
    XtendMember _memberInInterface_6 = this.memberInInterface(_builder_6.toString());
    this._validationTestHelper.assertError(_memberInInterface_6, Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
  }
}
