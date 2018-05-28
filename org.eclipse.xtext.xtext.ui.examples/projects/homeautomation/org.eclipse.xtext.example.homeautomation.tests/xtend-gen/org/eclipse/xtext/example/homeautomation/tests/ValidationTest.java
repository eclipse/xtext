package org.eclipse.xtext.example.homeautomation.tests;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.RuleEnginePackage;
import org.eclipse.xtext.example.homeautomation.tests.RuleEngineInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuleEngineInjectorProvider.class)
@SuppressWarnings("all")
public class ValidationTest {
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  @Extension
  private ValidationTestHelper _validationTestHelper = new ValidationTestHelper(ValidationTestHelper.Mode.EXACT);
  
  @Test
  public void testDeviceWithNoStates() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be");
    _builder.newLine();
    _builder.newLine();
    this.assertError(_builder, RuleEnginePackage.Literals.DEVICE, "The device \"Window\" must have at least one state.");
  }
  
  @Test
  public void testStatesWithSameName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, open");
    _builder.newLine();
    _builder.newLine();
    this.assertError(_builder, RuleEnginePackage.Literals.STATE, "State names must be unique.");
  }
  
  @Test
  public void testTwoDevicesWithSameName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open");
    _builder.newLine();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.newLine();
    this.assertError(_builder, RuleEnginePackage.Literals.DEVICE, "Device names must be unique.");
  }
  
  @Test
  public void testTwoRulesWithSameDescription() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"ruleDescription\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Window.closed)");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("Rule \"ruleDescription\" when Window.closed then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Window.open)");
    _builder.newLine();
    this.assertError(_builder, RuleEnginePackage.Literals.RULE, "Rule descriptions must be unique.");
  }
  
  @Test
  public void testRuleWithEmptyDescription() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Window.closed)");
    _builder.newLine();
    this.assertError(_builder, RuleEnginePackage.Literals.RULE, "A rule description must not be empty.");
  }
  
  @Test
  public void testRecursiveRule() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"Recursive rule\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Window.open)");
    _builder.newLine();
    this.assertWarning(_builder, XbasePackage.Literals.XFEATURE_CALL, 
      "Firing the same device state that triggers the rule \"Recursive rule\" may lead to endless recursion.");
  }
  
  private void assertWarning(final CharSequence text, final EClass objectType, final String message) {
    try {
      this._validationTestHelper.assertWarning(this._parseHelper.parse(text), objectType, null, message);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertError(final CharSequence text, final EClass objectType, final String message) {
    try {
      this._validationTestHelper.assertError(this._parseHelper.parse(text), objectType, null, message);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
