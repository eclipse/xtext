/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.resourceFactory;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * Contributes the registration <code>org.eclipse.emf.ecore.extension_parser</code>
 * to the Eclipse (UI) plugin's plugin.xml. See
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=264578">
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=264578</a> for details.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceFactoryFragment2 extends AbstractGeneratorFragment2 {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Override
  public void generate() {
    ILanguageConfig _language = this.getLanguage();
    StandaloneSetupAccess _runtimeGenSetup = _language.getRuntimeGenSetup();
    List<StringConcatenationClient> _registrations = _runtimeGenSetup.getRegistrations();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(IResourceFactory.class, "");
        _builder.append(" resourceFactory = injector.getInstance(");
        _builder.append(IResourceFactory.class, "");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append(IResourceServiceProvider.class, "");
        _builder.append(" serviceProvider = injector.getInstance(");
        _builder.append(IResourceServiceProvider.class, "");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          ILanguageConfig _language = ResourceFactoryFragment2.this.getLanguage();
          List<String> _fileExtensions = _language.getFileExtensions();
          for(final String fileExtension : _fileExtensions) {
            _builder.append(Resource.class, "");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(\"");
            _builder.append(fileExtension, "");
            _builder.append("\", resourceFactory);");
            _builder.newLineIfNotEmpty();
            _builder.append(IResourceServiceProvider.class, "");
            _builder.append(".Registry.INSTANCE.getExtensionToFactoryMap().put(\"");
            _builder.append(fileExtension, "");
            _builder.append("\", serviceProvider);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    };
    _registrations.add(_client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    PluginXmlAccess _pluginXml = null;
    if (_eclipsePlugin!=null) {
      _pluginXml=_eclipsePlugin.getPluginXml();
    }
    boolean _notEquals = (!Objects.equal(_pluginXml, null));
    if (_notEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
      PluginXmlAccess _pluginXml_1 = _eclipsePlugin_1.getPluginXml();
      List<CharSequence> _entries = _pluginXml_1.getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- adding resource factories -->");
      _builder.newLine();
      {
        ILanguageConfig _language_1 = this.getLanguage();
        List<String> _fileExtensions = _language_1.getFileExtensions();
        for(final String fileExtension : _fileExtensions) {
          _builder.append("\t");
          _builder.append("<extension");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("point=\"org.eclipse.emf.ecore.extension_parser\">");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("<parser");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("class=\"");
          Grammar _grammar = this.getGrammar();
          TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar);
          _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t\t");
          _builder.append(":org.eclipse.xtext.resource.IResourceFactory\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("type=\"");
          _builder.append(fileExtension, "\t\t\t");
          _builder.append("\">");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("</parser>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("</extension>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("<extension point=\"org.eclipse.xtext.extension_resourceServiceProvider\">");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("    ");
          _builder.append("<resourceServiceProvider");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("        ");
          _builder.append("class=\"");
          Grammar _grammar_1 = this.getGrammar();
          TypeReference _eclipsePluginExecutableExtensionFactory_1 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar_1);
          _builder.append(_eclipsePluginExecutableExtensionFactory_1, "\t        ");
          _builder.append(":org.eclipse.xtext.ui.resource.IResourceUIServiceProvider\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("        ");
          _builder.append("uriExtension=\"");
          _builder.append(fileExtension, "\t        ");
          _builder.append("\">");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("    ");
          _builder.append("</resourceServiceProvider>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("</extension>");
          _builder.newLine();
        }
      }
      _entries.add(_builder.toString());
    }
  }
}
