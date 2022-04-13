/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.resourceFactory;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;

/**
 * Contributes the registration <code>org.eclipse.emf.ecore.extension_parser</code>
 * to the Eclipse (UI) plugin's plugin.xml. See
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=264578">
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=264578</a> for details.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceFactoryFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Override
  public void generate() {
    List<StringConcatenationClient> _registrations = this.getLanguage().getRuntimeGenSetup().getRegistrations();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(IResourceFactory.class);
        _builder.append(" resourceFactory = injector.getInstance(");
        _builder.append(IResourceFactory.class);
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append(IResourceServiceProvider.class);
        _builder.append(" serviceProvider = injector.getInstance(");
        _builder.append(IResourceServiceProvider.class);
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          List<String> _fileExtensions = ResourceFactoryFragment2.this.getLanguage().getFileExtensions();
          for(final String fileExtension : _fileExtensions) {
            _builder.append(Resource.class);
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(\"");
            _builder.append(fileExtension);
            _builder.append("\", resourceFactory);");
            _builder.newLineIfNotEmpty();
            _builder.append(IResourceServiceProvider.class);
            _builder.append(".Registry.INSTANCE.getExtensionToFactoryMap().put(\"");
            _builder.append(fileExtension);
            _builder.append("\", serviceProvider);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    };
    _registrations.add(_client);
    IBundleProjectConfig _eclipsePlugin = this.getProjectConfig().getEclipsePlugin();
    PluginXmlAccess _pluginXml = null;
    if (_eclipsePlugin!=null) {
      _pluginXml=_eclipsePlugin.getPluginXml();
    }
    boolean _tripleNotEquals = (_pluginXml != null);
    if (_tripleNotEquals) {
      List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- adding resource factories -->");
      _builder.newLine();
      {
        List<String> _fileExtensions = this.getLanguage().getFileExtensions();
        for(final String fileExtension : _fileExtensions) {
          _builder.append("<extension");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("point=\"org.eclipse.emf.ecore.extension_parser\">");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("<parser");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("class=\"");
          TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
          _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
          _builder.append(":org.eclipse.xtext.resource.IResourceFactory\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("type=\"");
          _builder.append(fileExtension, "\t\t");
          _builder.append("\">");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("</parser>");
          _builder.newLine();
          _builder.append("</extension>");
          _builder.newLine();
          _builder.append("<extension point=\"org.eclipse.xtext.extension_resourceServiceProvider\">");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("<resourceServiceProvider");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("class=\"");
          TypeReference _eclipsePluginExecutableExtensionFactory_1 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
          _builder.append(_eclipsePluginExecutableExtensionFactory_1, "\t\t");
          _builder.append(":org.eclipse.xtext.ui.resource.IResourceUIServiceProvider\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("uriExtension=\"");
          _builder.append(fileExtension, "\t\t");
          _builder.append("\">");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("</resourceServiceProvider>");
          _builder.newLine();
          _builder.append("</extension>");
          _builder.newLine();
        }
      }
      _entries.add(_builder.toString());
    }
  }
}
