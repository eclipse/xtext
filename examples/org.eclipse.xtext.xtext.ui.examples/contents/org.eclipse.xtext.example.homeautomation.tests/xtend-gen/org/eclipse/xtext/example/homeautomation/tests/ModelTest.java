package org.eclipse.xtext.example.homeautomation.tests;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Declaration;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.example.homeautomation.ruleEngine.State;
import org.eclipse.xtext.example.homeautomation.tests.RuleEngineInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuleEngineInjectorProvider.class)
@SuppressWarnings("all")
public class ModelTest {
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  @Test
  public void testParsing() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Device Window can be open, closed");
      _builder.newLine();
      _builder.append("Device Heater can be on, off");
      _builder.newLine();
      _builder.append("Rule \"Save energy\" when Window.open then");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("fire(Heater.off)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("println(\'Another penny to the piggy bank!\')");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      EList<Declaration> _declarations = model.getDeclarations();
      Declaration _get = _declarations.get(0);
      final Device device = ((Device) _get);
      String _name = device.getName();
      Assert.assertEquals("Window", _name);
      EList<Declaration> _declarations_1 = model.getDeclarations();
      Declaration _get_1 = _declarations_1.get(2);
      final Rule rule = ((Rule) _get_1);
      String _description = rule.getDescription();
      Assert.assertEquals("Save energy", _description);
      State _deviceState = rule.getDeviceState();
      String _name_1 = _deviceState.getName();
      Assert.assertEquals("open", _name_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
