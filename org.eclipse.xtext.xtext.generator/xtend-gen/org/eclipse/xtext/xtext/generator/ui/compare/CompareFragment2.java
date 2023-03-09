/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.ui.compare;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Names;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;

/**
 * Contributes the registration of compare infrastructure.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompareFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Override
  public void generate() {
    IBundleProjectConfig _eclipsePlugin = this.getProjectConfig().getEclipsePlugin();
    ManifestAccess _manifest = null;
    if (_eclipsePlugin!=null) {
      _manifest=_eclipsePlugin.getManifest();
    }
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _requiredBundles = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
      Iterables.<String>addAll(_requiredBundles, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.compare", "org.eclipse.xtext.ui")));
    }
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(String.class);
        _builder.append(".class).annotatedWith(");
        _builder.append(Names.class);
        _builder.append(".named(");
        TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.UIBindings");
        _builder.append(_typeReference);
        _builder.append(".COMPARE_VIEWER_TITLE)).toInstance(\"");
        String _simpleName = GrammarUtil.getSimpleName(CompareFragment2.this.getGrammar());
        _builder.append(_simpleName);
        _builder.append(" Compare\");");
      }
    };
    final StringConcatenationClient statement = _client;
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeReference = new TypeReference("org.eclipse.compare.IViewerCreator");
    TypeReference _typeReference_1 = new TypeReference("org.eclipse.xtext.ui.compare.DefaultViewerCreator");
    _bindingFactory.addTypeToType(_typeReference, _typeReference_1).addConfiguredBinding("CompareViewerTitle", statement).contributeTo(this.getLanguage().getEclipsePluginGenModule());
    IBundleProjectConfig _eclipsePlugin_1 = this.getProjectConfig().getEclipsePlugin();
    PluginXmlAccess _pluginXml = null;
    if (_eclipsePlugin_1!=null) {
      _pluginXml=_eclipsePlugin_1.getPluginXml();
    }
    boolean _tripleNotEquals_1 = (_pluginXml != null);
    if (_tripleNotEquals_1) {
      List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<extension point=\"org.eclipse.compare.contentViewers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<viewer id=\"");
      String _name = this.getGrammar().getName();
      _builder.append(_name, "\t");
      _builder.append(".compare.contentViewers\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.compare.InjectableViewerCreator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("extensions=\"");
      String _join = IterableExtensions.join(this.getLanguage().getFileExtensions(), ",");
      _builder.append(_join, "\t\t");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</viewer>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<contentTypeBinding");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("contentTypeId=\"");
      String _name_1 = this.getGrammar().getName();
      _builder.append(_name_1, "\t\t");
      _builder.append(".contenttype\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("contentViewerId=\"");
      String _name_2 = this.getGrammar().getName();
      _builder.append(_name_2, "\t\t");
      _builder.append(".compare.contentViewers\" />");
      _builder.newLineIfNotEmpty();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.compare.contentMergeViewers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<viewer id=\"");
      String _name_3 = this.getGrammar().getName();
      _builder.append(_name_3, "\t");
      _builder.append(".compare.contentMergeViewers\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory_1 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      _builder.append(_eclipsePluginExecutableExtensionFactory_1, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.compare.InjectableViewerCreator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("extensions=\"");
      String _join_1 = IterableExtensions.join(this.getLanguage().getFileExtensions(), ",");
      _builder.append(_join_1, "\t\t");
      _builder.append("\" label=\"");
      String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
      _builder.append(_simpleName, "\t\t");
      _builder.append(" Compare\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</viewer>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<contentTypeBinding");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("contentTypeId=\"");
      String _name_4 = this.getGrammar().getName();
      _builder.append(_name_4, "\t\t");
      _builder.append(".contenttype\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("contentMergeViewerId=\"");
      String _name_5 = this.getGrammar().getName();
      _builder.append(_name_5, "\t\t");
      _builder.append(".compare.contentMergeViewers\" />");
      _builder.newLineIfNotEmpty();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.editors.documentProviders\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<provider id=\"");
      String _name_6 = this.getGrammar().getName();
      _builder.append(_name_6, "\t");
      _builder.append(".editors.documentProviders\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory_2 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      _builder.append(_eclipsePluginExecutableExtensionFactory_2, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.editor.model.XtextDocumentProvider\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("extensions=\"");
      String _join_2 = IterableExtensions.join(this.getLanguage().getFileExtensions(), ",");
      _builder.append(_join_2, "\t\t");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</provider>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.team.core.fileTypes\">");
      _builder.newLine();
      {
        List<String> _fileExtensions = this.getLanguage().getFileExtensions();
        for(final String modelFileExtension : _fileExtensions) {
          _builder.append("\t");
          _builder.append("<fileTypes");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("extension=\"");
          _builder.append(modelFileExtension, "\t\t");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("type=\"text\">");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("</fileTypes>");
          _builder.newLine();
        }
      }
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
    }
  }
}
