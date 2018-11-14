package org.eclipse.xtext.example.homeautomation.ui.tests;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.homeautomation.ui.tests.RuleEngineUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuleEngineUiInjectorProvider.class)
@SuppressWarnings("all")
public class RuleEngineContentAssistTest extends AbstractContentAssistTest {
  private final String c = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<|>");
      return _builder.toString();
    }
  }.apply();
  
  @Test
  public void empty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device");
    _builder_1.newLine();
    this.testContentAssistant(_builder, 
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Device", "Rule")), "Device", _builder_1.toString());
  }
  
  @Test
  public void rule_device_state() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when ");
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window can be open, closed");
    _builder_1.newLine();
    _builder_1.append("Device Heater can be on, off, error");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Rule \'rule1\' when Window.open");
    _builder_1.newLine();
    this.testContentAssistant(_builder, 
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Window.open", "Window.closed", "Heater.on", "Heater.off", "Heater.error")), "Window.open", _builder_1.toString());
  }
  
  @Test
  public void rule_device_state_with_prefix() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Win");
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window can be open, closed");
    _builder_1.newLine();
    _builder_1.append("Device Heater can be on, off, error");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Rule \'rule1\' when Window.open");
    _builder_1.newLine();
    this.testContentAssistant(_builder, 
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Window.open", "Window.closed")), "Window.open", _builder_1.toString());
  }
  
  @Test
  public void rule_then_part() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.c, "\t");
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window can be open, closed");
    _builder_1.newLine();
    _builder_1.append("Device Heater can be on, off, error");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Rule \'rule1\' when Window.open then");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("switch");
    _builder_1.newLine();
    this.testContentAssistant(_builder, 
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("do", "false", "for", "if", "new", "null", "return", "switch", "synchronized", "throw", "true", "try", "typeof", "val", "var", "while")), "switch", _builder_1.toString());
  }
  
  @Test
  public void rule_then_part_with_prefix() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.o");
    _builder.append(this.c, "\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window can be open, closed");
    _builder_1.newLine();
    _builder_1.append("Device Heater can be on, off, error");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Rule \'rule1\' when Window.open then");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("fire(Heater.off)");
    _builder_1.newLine();
    this.testContentAssistant(_builder, 
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("on", "off")), "off", _builder_1.toString());
  }
  
  private void testContentAssistant(final CharSequence text, final List<String> expectedProposals, final String proposalToApply, final String expectedContent) {
    try {
      final int cursorPosition = text.toString().indexOf(this.c);
      final String content = text.toString().replace(this.c, "");
      this.newBuilder().append(content).assertTextAtCursorPosition(cursorPosition, ((String[])Conversions.unwrapArray(expectedProposals, String.class))).applyProposal(cursorPosition, proposalToApply).expectContent(expectedContent);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
