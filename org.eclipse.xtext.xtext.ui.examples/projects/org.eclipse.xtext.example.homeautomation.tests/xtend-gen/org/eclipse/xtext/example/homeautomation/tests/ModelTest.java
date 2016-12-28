package org.eclipse.xtext.example.homeautomation.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Declaration;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.example.homeautomation.tests.RuleEngineInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
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
      Declaration _get = model.getDeclarations().get(0);
      final Device device = ((Device) _get);
      Assert.assertEquals("Window", device.getName());
      Declaration _get_1 = model.getDeclarations().get(2);
      final Rule rule = ((Rule) _get_1);
      Assert.assertEquals("Save energy", rule.getDescription());
      Assert.assertEquals("open", rule.getDeviceState().getName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
