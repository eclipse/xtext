package org.eclipse.xtext.example.homeautomation.ui.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.homeautomation.ui.tests.RuleEngineUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.testing.AbstractHighlightingTest;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuleEngineUiInjectorProvider.class)
@SuppressWarnings("all")
public class RuleEngineHighlightingTest extends AbstractHighlightingTest {
  @Inject
  @Extension
  private DefaultHighlightingConfiguration _defaultHighlightingConfiguration;
  
  @Test
  public void device_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    this.testHighlighting(_builder, "Device", this._defaultHighlightingConfiguration.keywordTextStyle());
  }
  
  @Test
  public void can_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    this.testHighlighting(_builder, "can", this._defaultHighlightingConfiguration.keywordTextStyle());
  }
  
  @Test
  public void be_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    this.testHighlighting(_builder, "be", this._defaultHighlightingConfiguration.keywordTextStyle());
  }
  
  @Test
  public void rule_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "Rule", this._defaultHighlightingConfiguration.keywordTextStyle());
  }
  
  @Test
  public void when_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "when", this._defaultHighlightingConfiguration.keywordTextStyle());
  }
  
  @Test
  public void then_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "then", this._defaultHighlightingConfiguration.keywordTextStyle());
  }
  
  @Test
  public void single_quoted_rule_description() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "rule1", this._defaultHighlightingConfiguration.stringTextStyle());
  }
  
  @Test
  public void double_quoted_rule_description() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"rule1\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "rule1", this._defaultHighlightingConfiguration.stringTextStyle());
  }
  
  @Test
  public void single_line_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// A language for home automation systems.");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"rule1\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "A language for home automation systems", this._defaultHighlightingConfiguration.commentTextStyle());
  }
  
  @Test
  public void multi_line_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* A language for home automation systems");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* supporting indentation-based code blocks");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* similar to Python.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* A language for home automation systems");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* supporting indentation-based code blocks");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* similar to Python.");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    this.testHighlighting(_builder, _builder_1.toString(), this._defaultHighlightingConfiguration.commentTextStyle());
  }
}
