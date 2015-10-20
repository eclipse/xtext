/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.outline;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * Contributes the 'Quick Outline' entry to the language editor's context menu.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class QuickOutlineFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Override
  public void generate() {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    ManifestAccess _manifest = _eclipsePlugin.getManifest();
    boolean _notEquals = (!Objects.equal(_manifest, null));
    if (_notEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
      ManifestAccess _manifest_1 = _eclipsePlugin_1.getManifest();
      Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.ui");
    }
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin_2 = _projectConfig_2.getEclipsePlugin();
    PluginXmlAccess _pluginXml = _eclipsePlugin_2.getPluginXml();
    boolean _notEquals_1 = (!Objects.equal(_pluginXml, null));
    if (_notEquals_1) {
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_3 = _projectConfig_3.getEclipsePlugin();
      PluginXmlAccess _pluginXml_1 = _eclipsePlugin_3.getPluginXml();
      List<CharSequence> _entries = _pluginXml_1.getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- Quick Outline -->");
      _builder.newLine();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("point=\"org.eclipse.ui.handlers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<handler ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      Grammar _grammar = this.getGrammar();
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar);
      _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.editor.outline.quickoutline.ShowQuickOutlineActionHandler\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("commandId=\"org.eclipse.xtext.ui.editor.outline.QuickOutline\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<activeWhen>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<reference");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("definitionId=\"");
      Grammar _grammar_1 = this.getGrammar();
      String _name = _grammar_1.getName();
      _builder.append(_name, "\t\t\t\t");
      _builder.append(".Editor.opened\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("</reference>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</activeWhen>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</handler>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("point=\"org.eclipse.ui.commands\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<command");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("description=\"Open the quick outline.\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("id=\"org.eclipse.xtext.ui.editor.outline.QuickOutline\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("name=\"Quick Outline\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</command>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.menus\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<menuContribution");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("locationURI=\"popup:#TextEditorContext?after=group.open\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<command commandId=\"org.eclipse.xtext.ui.editor.outline.QuickOutline\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("style=\"push\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("tooltip=\"Open Quick Outline\">");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<visibleWhen checkEnabled=\"false\">");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<reference definitionId=\"");
      Grammar _grammar_2 = this.getGrammar();
      String _name_1 = _grammar_2.getName();
      _builder.append(_name_1, "\t\t\t\t");
      _builder.append(".Editor.opened\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("</visibleWhen>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</command>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</menuContribution>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
    }
  }
}
