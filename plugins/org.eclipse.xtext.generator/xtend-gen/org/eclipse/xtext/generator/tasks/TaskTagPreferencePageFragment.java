/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.tasks;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class TaskTagPreferencePageFragment extends Xtend2GeneratorFragment {
  @Inject
  private Grammar grammar;
  
  @Inject
  @Extension
  private Naming naming;
  
  public void addToPluginXmlUi(final Xtend2ExecutionContext ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- task preference page for ");
    String _name = this.grammar.getName();
    _builder.append(_name, "");
    _builder.append(" -->");
    _builder.newLineIfNotEmpty();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("point=\"org.eclipse.ui.preferencePages\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<page");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("category=\"");
    String _name_1 = this.grammar.getName();
    _builder.append(_name_1, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("class=\"");
    String _executableExtensionFactory = this.naming.executableExtensionFactory(this.grammar);
    _builder.append(_executableExtensionFactory, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferencePage\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _name_2 = this.grammar.getName();
    _builder.append(_name_2, "\t\t");
    _builder.append(".task.preferencePage\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"Task Tags\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<keywordReference id=\"");
    String _name_3 = this.grammar.getName();
    String _packageName = this.naming.toPackageName(_name_3);
    String _plus = (_packageName + ".ui.keyword_");
    String _name_4 = this.grammar.getName();
    String _simpleName = this.naming.toSimpleName(_name_4);
    String _plus_1 = (_plus + _simpleName);
    _builder.append(_plus_1, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</page>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("point=\"org.eclipse.ui.propertyPages\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<page");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("category=\"");
    String _name_5 = this.grammar.getName();
    _builder.append(_name_5, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("class=\"");
    String _executableExtensionFactory_1 = this.naming.executableExtensionFactory(this.grammar);
    _builder.append(_executableExtensionFactory_1, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferencePage\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _name_6 = this.grammar.getName();
    _builder.append(_name_6, "\t\t");
    _builder.append(".task.propertyPage\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"Task Tags\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<keywordReference id=\"");
    String _name_7 = this.grammar.getName();
    String _packageName_1 = this.naming.toPackageName(_name_7);
    String _plus_2 = (_packageName_1 + ".ui.keyword_");
    String _name_8 = this.grammar.getName();
    String _simpleName_1 = this.naming.toSimpleName(_name_8);
    String _plus_3 = (_plus_2 + _simpleName_1);
    _builder.append(_plus_3, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<enabledWhen>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<adapt type=\"org.eclipse.core.resources.IProject\"/>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</enabledWhen>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<filter name=\"projectNature\" value=\"org.eclipse.xtext.ui.shared.xtextNature\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</page>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    ctx.append(_builder);
  }
  
  public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
    Set<Binding> _xblockexpression = null;
    {
      final BindFactory bind = new BindFactory();
      bind.addTypeToType("org.eclipse.xtext.tasks.ITaskTagProvider", 
        "org.eclipse.xtext.tasks.PreferenceTaskTagProvider");
      _xblockexpression = bind.getBindings();
    }
    return _xblockexpression;
  }
  
  public Set<Binding> getGuiceBindingsUi(final Grammar grammar) {
    Set<Binding> _xblockexpression = null;
    {
      final BindFactory bind = new BindFactory();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class)");
      _builder.newLine();
      _builder.append(".annotatedWith(com.google.inject.name.Names.named(\"taskTagPreferenceInitializer\"))");
      _builder.newLine();
      _builder.append(".to(org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferenceInitializer.class)");
      _builder.newLine();
      bind.addConfiguredBinding(
        "TaskTagPreferenceStoreInitializer", _builder.toString());
      _xblockexpression = bind.getBindings();
    }
    return _xblockexpression;
  }
}
