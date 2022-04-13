/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.ui.tasks;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class TaskTagPreferencePageFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  private Grammar grammar;

  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Override
  public void generate() {
    final GuiceModuleAccess.BindingFactory rtBindings = new GuiceModuleAccess.BindingFactory().addTypeToType(
      TypeReference.typeRef("org.eclipse.xtext.tasks.ITaskTagProvider"), 
      TypeReference.typeRef("org.eclipse.xtext.tasks.PreferenceTaskTagProvider"));
    rtBindings.contributeTo(this.getLanguage().getRuntimeGenModule());
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class)");
        _builder.newLine();
        _builder.append(".annotatedWith(com.google.inject.name.Names.named(\"taskTagPreferenceInitializer\"))");
        _builder.newLine();
        _builder.append(".to(org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferenceInitializer.class);");
        _builder.newLine();
      }
    };
    final GuiceModuleAccess.BindingFactory eclipseBindings = _bindingFactory.addConfiguredBinding(
      "TaskTagPreferenceStoreInitializer", _client);
    eclipseBindings.contributeTo(this.getLanguage().getEclipsePluginGenModule());
    IBundleProjectConfig _eclipsePlugin = this.getProjectConfig().getEclipsePlugin();
    PluginXmlAccess _pluginXml = null;
    if (_eclipsePlugin!=null) {
      _pluginXml=_eclipsePlugin.getPluginXml();
    }
    boolean _tripleNotEquals = (_pluginXml != null);
    if (_tripleNotEquals) {
      List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- task preference page for ");
      String _name = this.grammar.getName();
      _builder.append(_name);
      _builder.append(" -->");
      _builder.newLineIfNotEmpty();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("point=\"org.eclipse.ui.preferencePages\">");
      _builder.newLine();
      _builder.append("<page");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("category=\"");
      String _name_1 = this.grammar.getName();
      _builder.append(_name_1, "\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.grammar);
      _builder.append(_eclipsePluginExecutableExtensionFactory, "\t");
      _builder.append(":org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferencePage\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("id=\"");
      String _name_2 = this.grammar.getName();
      _builder.append(_name_2, "\t");
      _builder.append(".task.preferencePage\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("name=\"Task Tags\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<keywordReference id=\"");
      String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.grammar);
      String _plus = (_runtimeBasePackage + ".ui.keyword_");
      String _simpleName = GrammarUtil.getSimpleName(this.grammar);
      String _plus_1 = (_plus + _simpleName);
      _builder.append(_plus_1, "\t");
      _builder.append("\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("</page>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("point=\"org.eclipse.ui.propertyPages\">");
      _builder.newLine();
      _builder.append("<page");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("category=\"");
      String _name_3 = this.grammar.getName();
      _builder.append(_name_3, "\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory_1 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.grammar);
      _builder.append(_eclipsePluginExecutableExtensionFactory_1, "\t");
      _builder.append(":org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferencePage\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("id=\"");
      String _name_4 = this.grammar.getName();
      _builder.append(_name_4, "\t");
      _builder.append(".task.propertyPage\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("name=\"Task Tags\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<keywordReference id=\"");
      String _runtimeBasePackage_1 = this._xtextGeneratorNaming.getRuntimeBasePackage(this.grammar);
      String _plus_2 = (_runtimeBasePackage_1 + ".ui.keyword_");
      String _simpleName_1 = GrammarUtil.getSimpleName(this.grammar);
      String _plus_3 = (_plus_2 + _simpleName_1);
      _builder.append(_plus_3, "\t");
      _builder.append("\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("<enabledWhen>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<adapt type=\"org.eclipse.core.resources.IProject\"/>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</enabledWhen>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<filter name=\"projectNature\" value=\"org.eclipse.xtext.ui.shared.xtextNature\"/>");
      _builder.newLine();
      _builder.append("</page>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
    }
  }
}
