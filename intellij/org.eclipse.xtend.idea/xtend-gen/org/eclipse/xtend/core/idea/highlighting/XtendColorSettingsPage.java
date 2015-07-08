package org.eclipse.xtend.core.idea.highlighting;

import org.eclipse.xtend.core.idea.highlighting.XtendBaseColorSettingsPage;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class XtendColorSettingsPage extends XtendBaseColorSettingsPage {
  @Override
  public String getDemoText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Created on 06.07.15.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class XtendType {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String str = \"string\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Integer i = 5");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }
}
