/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.compare;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * Contributes the registration of compare infrastructure.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompareFragment2 extends AbstractGeneratorFragment2 {
  private final static Logger log = Logger.getLogger(CompareFragment2.class);
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Override
  public void generate() {
    boolean _isInfoEnabled = CompareFragment2.log.isInfoEnabled();
    if (_isInfoEnabled) {
      CompareFragment2.log.info("generating Compare Framework infrastructure");
    }
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    ManifestAccess _manifest = null;
    if (_eclipsePlugin!=null) {
      _manifest=_eclipsePlugin.getManifest();
    }
    boolean _notEquals = (!Objects.equal(_manifest, null));
    if (_notEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
      ManifestAccess _manifest_1 = _eclipsePlugin_1.getManifest();
      Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
      Iterables.<String>addAll(_requiredBundles, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.compare", "org.eclipse.xtext.ui")));
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeReference = new TypeReference("org.eclipse.compare.IViewerCreator");
    TypeReference _typeReference_1 = new TypeReference("org.eclipse.xtext.ui.compare.DefaultViewerCreator");
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeReference, _typeReference_1);
    ILanguageConfig _language = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language.getEclipsePluginGenModule();
    _addTypeToType.contributeTo(_eclipsePluginGenModule);
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin_2 = _projectConfig_2.getEclipsePlugin();
    PluginXmlAccess _pluginXml = null;
    if (_eclipsePlugin_2!=null) {
      _pluginXml=_eclipsePlugin_2.getPluginXml();
    }
    boolean _notEquals_1 = (!Objects.equal(_pluginXml, null));
    if (_notEquals_1) {
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_3 = _projectConfig_3.getEclipsePlugin();
      PluginXmlAccess _pluginXml_1 = _eclipsePlugin_3.getPluginXml();
      List<CharSequence> _entries = _pluginXml_1.getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<extension point=\"org.eclipse.compare.contentViewers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<viewer id=\"");
      Grammar _grammar = this.getGrammar();
      String _name = _grammar.getName();
      _builder.append(_name, "\t");
      _builder.append(".compare.contentViewers\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      Grammar _grammar_1 = this.getGrammar();
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar_1);
      _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.compare.InjectableViewerCreator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("extensions=\"");
      ILanguageConfig _language_1 = this.getLanguage();
      List<String> _fileExtensions = _language_1.getFileExtensions();
      String _join = IterableExtensions.join(_fileExtensions, ",");
      _builder.append(_join, "\t\t");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</viewer>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.compare.contentMergeViewers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<viewer id=\"");
      Grammar _grammar_2 = this.getGrammar();
      String _name_1 = _grammar_2.getName();
      _builder.append(_name_1, "\t");
      _builder.append(".compare.contentMergeViewers\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      Grammar _grammar_3 = this.getGrammar();
      TypeReference _eclipsePluginExecutableExtensionFactory_1 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar_3);
      _builder.append(_eclipsePluginExecutableExtensionFactory_1, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.compare.InjectableViewerCreator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("extensions=\"");
      ILanguageConfig _language_2 = this.getLanguage();
      List<String> _fileExtensions_1 = _language_2.getFileExtensions();
      String _join_1 = IterableExtensions.join(_fileExtensions_1, ",");
      _builder.append(_join_1, "\t\t");
      _builder.append("\" label=\"");
      Grammar _grammar_4 = this.getGrammar();
      String _simpleName = GrammarUtil.getSimpleName(_grammar_4);
      _builder.append(_simpleName, "\t\t");
      _builder.append(" Compare\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</viewer>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.editors.documentProviders\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<provider id=\"");
      Grammar _grammar_5 = this.getGrammar();
      String _name_2 = _grammar_5.getName();
      _builder.append(_name_2, "\t");
      _builder.append(".editors.documentProviders\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      Grammar _grammar_6 = this.getGrammar();
      TypeReference _eclipsePluginExecutableExtensionFactory_2 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar_6);
      _builder.append(_eclipsePluginExecutableExtensionFactory_2, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.editor.model.XtextDocumentProvider\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("extensions=\"");
      ILanguageConfig _language_3 = this.getLanguage();
      List<String> _fileExtensions_2 = _language_3.getFileExtensions();
      String _join_2 = IterableExtensions.join(_fileExtensions_2, ",");
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
        ILanguageConfig _language_4 = this.getLanguage();
        List<String> _fileExtensions_3 = _language_4.getFileExtensions();
        for(final String modelFileExtension : _fileExtensions_3) {
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
