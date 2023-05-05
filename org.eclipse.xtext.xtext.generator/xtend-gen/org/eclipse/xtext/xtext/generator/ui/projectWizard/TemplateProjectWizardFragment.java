/**
 * Copyright (c) 2017, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.ui.projectWizard;

import com.google.common.annotations.Beta;
import com.google.common.collect.Iterables;
import com.google.common.io.ByteStreams;
import com.google.inject.Inject;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.BinaryFileAccess;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;

/**
 * Add a new project wizard with a template selection page.
 * 
 * Example usage:
 * <pre>
 * component = XtextGenerator {
 *     language = StandardLanguage {
 *         projectWizard = {
 *             generate = true
 *         }
 *     }
 * }
 * </pre>
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Beta
@SuppressWarnings("all")
public class TemplateProjectWizardFragment extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  private FileAccessFactory fileAccessFactory;

  @Accessors
  private boolean generate = false;

  @Accessors
  private boolean generateToolbarButton = false;

  @Accessors
  private boolean pluginProject = true;

  @Override
  public void generate() {
    if ((!this.generate)) {
      return;
    }
    IBundleProjectConfig _eclipsePlugin = this.getProjectConfig().getEclipsePlugin();
    ManifestAccess _manifest = null;
    if (_eclipsePlugin!=null) {
      _manifest=_eclipsePlugin.getManifest();
    }
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _requiredBundles = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
      Iterables.<String>addAll(_requiredBundles, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.core.runtime", "org.eclipse.core.resources", "org.eclipse.ui", "org.eclipse.ui.ide", "org.eclipse.ui.forms", "org.eclipse.xtend.lib")));
      if (this.pluginProject) {
        Set<String> _requiredBundles_1 = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
        Iterables.<String>addAll(_requiredBundles_1, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.jdt.core", "org.eclipse.pde.core")));
      }
      Set<String> _exportedPackages = this.getProjectConfig().getEclipsePlugin().getManifest().getExportedPackages();
      String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(this.getGrammar());
      String _plus = (_eclipsePluginBasePackage + ".wizard");
      Iterables.<String>addAll(_exportedPackages, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_plus)));
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.wizard.IProjectCreator");
    TypeReference _typeReference_1 = new TypeReference("org.eclipse.xtext.ui.wizard.template.DefaultTemplateProjectCreator");
    _bindingFactory.addTypeToType(_typeReference, _typeReference_1).contributeTo(this.getLanguage().getEclipsePluginGenModule());
    IBundleProjectConfig _eclipsePlugin_1 = this.getProjectConfig().getEclipsePlugin();
    PluginXmlAccess _pluginXml = null;
    if (_eclipsePlugin_1!=null) {
      _pluginXml=_eclipsePlugin_1.getPluginXml();
    }
    boolean _tripleNotEquals_1 = (_pluginXml != null);
    if (_tripleNotEquals_1) {
      List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("point=\"org.eclipse.ui.newWizards\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<category id=\"");
      String _eclipsePluginBasePackage_1 = this._xtextGeneratorNaming.getEclipsePluginBasePackage(this.getGrammar());
      _builder.append(_eclipsePluginBasePackage_1, "\t");
      _builder.append(".category\" name=\"");
      String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
      _builder.append(_simpleName, "\t");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</category>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<wizard");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("category=\"");
      String _eclipsePluginBasePackage_2 = this._xtextGeneratorNaming.getEclipsePluginBasePackage(this.getGrammar());
      _builder.append(_eclipsePluginBasePackage_2, "\t\t");
      _builder.append(".category\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.wizard.template.TemplateNewProjectWizard\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("id=\"");
      String _projectWizardClassName = this.getProjectWizardClassName();
      _builder.append(_projectWizardClassName, "\t\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("name=\"");
      String _simpleName_1 = GrammarUtil.getSimpleName(this.getGrammar());
      _builder.append(_simpleName_1, "\t\t");
      _builder.append(" Project\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("icon=\"icons/new_");
      String _simpleName_2 = GrammarUtil.getSimpleName(this.getGrammar());
      _builder.append(_simpleName_2, "\t\t");
      _builder.append("_proj.gif\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("project=\"true\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</wizard>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("point=\"org.eclipse.xtext.ui.projectTemplate\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<projectTemplateProvider");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory_1 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      _builder.append(_eclipsePluginExecutableExtensionFactory_1, "\t\t");
      _builder.append(":");
      String _projectTemplateProviderClassName = this.getProjectTemplateProviderClassName();
      _builder.append(_projectTemplateProviderClassName, "\t\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("grammarName=\"");
      String _languageId = GrammarUtil.getLanguageId(this.getGrammar());
      _builder.append(_languageId, "\t\t");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</projectTemplateProvider>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("point=\"org.eclipse.ui.perspectiveExtensions\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<perspectiveExtension targetID=\"org.eclipse.ui.resourcePerspective\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<newWizardShortcut id=\"");
      String _projectWizardClassName_1 = this.getProjectWizardClassName();
      _builder.append(_projectWizardClassName_1, "\t\t");
      _builder.append("\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</perspectiveExtension>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<perspectiveExtension targetID=\"org.eclipse.jdt.ui.JavaPerspective\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<newWizardShortcut id=\"");
      String _projectWizardClassName_2 = this.getProjectWizardClassName();
      _builder.append(_projectWizardClassName_2, "\t\t");
      _builder.append("\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</perspectiveExtension>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
      if (this.generateToolbarButton) {
        List<CharSequence> _entries_1 = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<extension");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("point=\"org.eclipse.ui.menus\">");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("<menuContribution");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("allPopups=\"false\"");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("locationURI=\"toolbar:org.eclipse.ui.main.toolbar\">");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("<toolbar");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("id=\"");
        String _eclipsePluginBasePackage_3 = this._xtextGeneratorNaming.getEclipsePluginBasePackage(this.getGrammar());
        _builder_1.append(_eclipsePluginBasePackage_3, "\t\t\t");
        _builder_1.append(".toolbar\">");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t\t\t");
        _builder_1.append("<!--");
        _builder_1.newLine();
        _builder_1.append("\t\t\t\t");
        _builder_1.append("For some reason the tooltip is not shown when hovering over the toolbar button");
        _builder_1.newLine();
        _builder_1.append("\t\t\t\t");
        _builder_1.append("See also https://www.eclipse.org/forums/index.php/t/1079111/");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("-->");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("<command");
        _builder_1.newLine();
        _builder_1.append("\t\t\t\t");
        _builder_1.append("commandId=\"org.eclipse.ui.newWizard\"");
        _builder_1.newLine();
        _builder_1.append("\t\t\t\t");
        _builder_1.append("tooltip=\"Create a new ");
        String _simpleName_3 = GrammarUtil.getSimpleName(this.getGrammar());
        _builder_1.append(_simpleName_3, "\t\t\t\t");
        _builder_1.append(" project\">");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t\t\t\t");
        _builder_1.append("<parameter");
        _builder_1.newLine();
        _builder_1.append("\t\t\t\t\t");
        _builder_1.append("name=\"newWizardId\"");
        _builder_1.newLine();
        _builder_1.append("\t\t\t\t\t");
        _builder_1.append("value=\"");
        String _projectWizardClassName_3 = this.getProjectWizardClassName();
        _builder_1.append(_projectWizardClassName_3, "\t\t\t\t\t");
        _builder_1.append("\">");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t\t\t\t");
        _builder_1.append("</parameter>");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("</command>");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("</toolbar>");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("</menuContribution>");
        _builder_1.newLine();
        _builder_1.append("</extension>");
        _builder_1.newLine();
        _entries_1.add(_builder_1.toString());
      }
    }
    this.generateProjectTemplateProvider();
    this.generateDefaultIcons();
  }

  public void generateProjectTemplateProvider() {
    final TypeReference initialContentsClass = TypeReference.typeRef(this.getProjectTemplateProviderClassName());
    final String quotes = "\'\'\'";
    final String openVar = "«";
    final String closeVar = "»";
    final XtendFileAccess file = this.fileAccessFactory.createXtendFile(initialContentsClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("import org.eclipse.core.runtime.Status");
        _builder.newLine();
        {
          if (TemplateProjectWizardFragment.this.pluginProject) {
            _builder.append("import org.eclipse.jdt.core.JavaCore");
            _builder.newLine();
          }
        }
        _builder.append("import org.eclipse.xtext.ui.XtextProjectHelper");
        _builder.newLine();
        {
          if (TemplateProjectWizardFragment.this.pluginProject) {
            _builder.append("import org.eclipse.xtext.ui.util.PluginProjectFactory");
            _builder.newLine();
          } else {
            _builder.append("import org.eclipse.xtext.ui.util.ProjectFactory");
            _builder.newLine();
          }
        }
        _builder.append("import org.eclipse.xtext.ui.wizard.template.IProjectGenerator");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.template.ProjectTemplate");
        _builder.newLine();
        _builder.newLine();
        _builder.append("import static org.eclipse.core.runtime.IStatus.*");
        _builder.newLine();
        _builder.newLine();
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Create a list with all project templates to be shown in the template new project wizard.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Each template is able to generate one or more projects. Each project can be configured such that any number of files are included.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        String _simpleName = initialContentsClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" implements IProjectTemplateProvider {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("override getProjectTemplates() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("#[new HelloWorldProject]");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("@ProjectTemplate(label=\"Hello World\", icon=\"project_template.png\", description=\"<p><b>Hello World</b></p>");
        _builder.newLine();
        _builder.append("<p>This is a parameterized hello world for ");
        String _simpleName_1 = GrammarUtil.getSimpleName(TemplateProjectWizardFragment.this.getGrammar());
        _builder.append(_simpleName_1);
        _builder.append(". You can set a parameter to modify the content in the generated file");
        _builder.newLineIfNotEmpty();
        _builder.append("and a parameter to set the package the file is created in.</p>\")");
        _builder.newLine();
        _builder.append("final class HelloWorldProject {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("val advanced = check(\"Advanced:\", false)");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("val advancedGroup = group(\"Properties\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("val name = combo(\"Name:\", #[\"Xtext\", \"World\", \"Foo\", \"Bar\"], \"The name to say \'Hello\' to\", advancedGroup)");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("val path = text(\"Package:\", \"mydsl\", \"The package path to place the files in\", advancedGroup)");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("override protected updateVariables() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("name.enabled = advanced.value");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("path.enabled = advanced.value");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (!advanced.value) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("name.value = \"Xtext\"");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("path.value = \"");
        String _get = TemplateProjectWizardFragment.this.getLanguage().getFileExtensions().get(0);
        _builder.append(_get, "\t\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("override protected validate() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (path.value.matches(\'[a-z][a-z0-9_]*(/[a-z][a-z0-9_]*)*\'))");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("null");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("else");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("new Status(ERROR, \"Wizard\", \"\'\" + path + \"\' is not a valid package name\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        {
          if (TemplateProjectWizardFragment.this.pluginProject) {
            _builder.append("\t");
            _builder.append("override generateProjects(IProjectGenerator generator) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("generator.generate(new PluginProjectFactory => [");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("projectName = projectInfo.projectName");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("location = projectInfo.locationPath");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("projectNatures += #[JavaCore.NATURE_ID, \"org.eclipse.pde.PluginNature\", XtextProjectHelper.NATURE_ID]");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("builderIds += #[JavaCore.BUILDER_ID, XtextProjectHelper.BUILDER_ID]");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("folders += \"src\"");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("addFile(");
            _builder.append(quotes, "\t\t\t");
            _builder.append("src/");
            _builder.append(openVar, "\t\t\t");
            _builder.append("path");
            _builder.append(closeVar, "\t\t\t");
            _builder.append("/Model.");
            String _get_1 = TemplateProjectWizardFragment.this.getLanguage().getFileExtensions().get(0);
            _builder.append(_get_1, "\t\t\t");
            _builder.append(quotes, "\t\t\t");
            _builder.append(", ");
            _builder.append(quotes, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("/*");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t ");
            _builder.append("* This is an example model");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Hello ");
            _builder.append(openVar, "\t\t\t\t");
            _builder.append("name");
            _builder.append(closeVar, "\t\t\t\t");
            _builder.append("!");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append(quotes, "\t\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("])");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("override generateProjects(IProjectGenerator generator) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("generator.generate(new ProjectFactory => [");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("projectName = projectInfo.projectName");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("location = projectInfo.locationPath");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("projectNatures += XtextProjectHelper.NATURE_ID");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("builderIds += XtextProjectHelper.BUILDER_ID");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("addFile(");
            _builder.append(quotes, "\t\t\t");
            _builder.append("src/");
            _builder.append(openVar, "\t\t\t");
            _builder.append("path");
            _builder.append(closeVar, "\t\t\t");
            _builder.append("/Model.");
            String _get_2 = TemplateProjectWizardFragment.this.getLanguage().getFileExtensions().get(0);
            _builder.append(_get_2, "\t\t\t");
            _builder.append(quotes, "\t\t\t");
            _builder.append(", ");
            _builder.append(quotes, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("/*");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t ");
            _builder.append("* This is an example model");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Hello ");
            _builder.append(openVar, "\t\t\t\t");
            _builder.append("name");
            _builder.append(closeVar, "\t\t\t\t");
            _builder.append("!");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append(quotes, "\t\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("])");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  public void generateDefaultIcons() {
    final BinaryFileAccess projectTemplate = this.fileAccessFactory.createBinaryFile("project_template.png");
    boolean _existIn = projectTemplate.existIn(this.getProjectConfig().getEclipsePlugin().getIcons());
    boolean _not = (!_existIn);
    if (_not) {
      projectTemplate.setContent(this.readBinaryFileFromPackage("project_template.png"));
      projectTemplate.writeTo(this.getProjectConfig().getEclipsePlugin().getIcons());
    }
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus = ("new_" + _simpleName);
    String _plus_1 = (_plus + "_proj.gif");
    final BinaryFileAccess newProject = this.fileAccessFactory.createBinaryFile(_plus_1);
    boolean _existIn_1 = newProject.existIn(this.getProjectConfig().getEclipsePlugin().getIcons());
    boolean _not_1 = (!_existIn_1);
    if (_not_1) {
      newProject.setContent(this.readBinaryFileFromPackage("new_xproj.gif"));
      newProject.writeTo(this.getProjectConfig().getEclipsePlugin().getIcons());
    }
  }

  private byte[] readBinaryFileFromPackage(final String fileName) {
    try {
      final InputStream stream = TemplateProjectWizardFragment.class.getResourceAsStream(fileName);
      try {
        return ByteStreams.toByteArray(stream);
      } finally {
        stream.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected String getProjectTemplateProviderClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "ProjectTemplateProvider");
  }

  protected String getProjectWizardClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "NewProjectWizard");
  }

  protected String getProjectWizardPackage() {
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(this.getGrammar());
    return (_eclipsePluginBasePackage + ".wizard.");
  }

  /**
   * Generate the wizard. Set to 'false' by default. Change to 'true' to generate the wizard.
   */
  public boolean setGenerate(final boolean value) {
    return this.generate = value;
  }

  /**
   * Generate a new project wizard toolbar button. Set to 'false' by default. Change to 'true' to add the new project wizard button to the toolbar.
   * 
   * @since 2.20
   */
  public boolean setGenerateToolbarButton(final boolean value) {
    return this.generateToolbarButton = value;
  }

  /**
   * Generate the projects as eclipse plugins. Affects only the example content of the templates. Can be changed
   * manually afterwards.
   */
  public boolean setPluginProject(final boolean value) {
    return this.pluginProject = value;
  }

  @Pure
  public boolean isGenerate() {
    return this.generate;
  }

  @Pure
  public boolean isGenerateToolbarButton() {
    return this.generateToolbarButton;
  }

  @Pure
  public boolean isPluginProject() {
    return this.pluginProject;
  }
}
