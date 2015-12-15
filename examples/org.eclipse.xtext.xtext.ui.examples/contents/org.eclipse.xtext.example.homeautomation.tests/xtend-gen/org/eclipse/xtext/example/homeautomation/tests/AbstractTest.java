package org.eclipse.xtext.example.homeautomation.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.homeautomation.tests.RuleEngineInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuleEngineInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractTest {
  protected abstract void test(final CharSequence document);
  
  @Test
  public void test1() {
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
    this.test(_builder);
  }
  
  @Test
  public void test2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.append("Rule \"Save energy\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (v : Heater.values)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val output = \'Heater state \' + v.name");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(output)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.test(_builder);
  }
  
  @Test
  public void test3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off");
    _builder.newLine();
    _builder.append("Rule \"Save energy\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch new java.util.Random().nextInt()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 1,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 2:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("println(\'Another penny to the piggy bank!\')");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.on)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("println(\'I do support global warming!\')");
    _builder.newLine();
    this.test(_builder);
  }
}
