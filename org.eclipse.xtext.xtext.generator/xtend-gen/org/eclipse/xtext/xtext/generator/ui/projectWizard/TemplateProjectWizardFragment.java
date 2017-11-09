/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.projectWizard;

import com.google.common.collect.Iterables;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
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
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
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
 *         fragment = ui.projectWizard.TemplateProjectWizardFragment {
 *             generate = true
 *         }
 *     }
 * }
 * </pre>
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
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
      Iterables.<String>addAll(_requiredBundles, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.ui", "org.eclipse.core.runtime", "org.eclipse.core.resources", "org.eclipse.ui.ide", "org.eclipse.ui.forms")));
      Set<String> _exportedPackages = this.getProjectConfig().getEclipsePlugin().getManifest().getExportedPackages();
      String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(this.getGrammar());
      String _plus = (_eclipsePluginBasePackage + ".wizard");
      Iterables.<String>addAll(_exportedPackages, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_plus)));
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.wizard.IProjectCreator");
    String _projectCreatorClassName = this.getProjectCreatorClassName();
    TypeReference _typeReference_1 = new TypeReference(_projectCreatorClassName);
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
      _builder.append(":");
      String _projectWizardClassName = this.getProjectWizardClassName();
      _builder.append(_projectWizardClassName, "\t\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("id=\"");
      String _projectWizardClassName_1 = this.getProjectWizardClassName();
      _builder.append(_projectWizardClassName_1, "\t\t");
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
      _entries.add(_builder.toString());
      List<CharSequence> _entries_1 = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<extension");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("point=\"org.eclipse.xtext.ui.projectTemplate\">");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("<projectTemplateProvider");
      _builder_1.newLine();
      _builder_1.append("         ");
      _builder_1.append("class=\"");
      String _projectTemplateProviderClassName = this.getProjectTemplateProviderClassName();
      _builder_1.append(_projectTemplateProviderClassName, "         ");
      _builder_1.append("\"");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("         ");
      _builder_1.append("grammarName=\"");
      String _name = this.getGrammar().getName();
      _builder_1.append(_name, "         ");
      _builder_1.append("\">");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("   ");
      _builder_1.append("</projectTemplateProvider>");
      _builder_1.newLine();
      _builder_1.append("</extension>");
      _builder_1.newLine();
      _entries_1.add(_builder_1.toString());
    }
    this.generateProjectInfo();
    this.generateWizardNewProjectCreationPage();
    this.generateProjectTemplateProvider();
    this.generateNewProjectWizard();
    this.generateProjectCreator();
    this.generateDefaultIcons();
  }
  
  public void generateProjectInfo() {
    final TypeReference projectInfoClass = TypeReference.typeRef(this.getProjectInfoClassName());
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(projectInfoClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = projectInfoClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.wizard.template.TemplateProjectInfo");
        _builder.append(_typeRef);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        String _simpleName_1 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(AbstractProjectTemplate projectTemplate) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(projectTemplate);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrcGen());
  }
  
  public void generateWizardNewProjectCreationPage() {
    final TypeReference mainPageClass = TypeReference.typeRef(this.getProjectWizardCreationPageClassName());
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(mainPageClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = mainPageClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.ui.dialogs.WizardNewProjectCreationPage");
        _builder.append(_typeRef);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _simpleName_1 = mainPageClass.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(String pageName) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(pageName);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrcGen());
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
        _builder.append("import org.eclipse.core.runtime.Status;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.template.IProjectFileGenerator");
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
        _builder.append("* Provide all available project templates to be available in the NewProjectWizard. Each template is described through one class annotated with @Template.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* With @Template the label, icon and description of the template, displayed to the user in the wizard, are defined.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* In addition it is possible to define fields that are displayed as text field, checkbox or combobox. There exist three methods #text, #check and #combo");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* to create such fields. These fields are presented to the user on a second page and can be used to configure the generated content by the end user.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* The variables can be enabled/disabled by overriding #updateVariables. Each variable has a #isEnabled and a #setEnabled. It is also allowed to change");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* the variable values in this method (e.g. to change a string in response to a change of a checkbox).");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* The variables can be validated by overriding the method #validate. Errors generated here are displayed in the wizard. The validation takes place after");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* #updateVariables has been executed.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* In the end code is to be generated. The method #generateFiles is executed. The given IrojectFileGenerator can be used to generate files inside the");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* newly generated project. Values from variables might be used here to configure the generated files.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* <pre>");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* \tdef helloFile() {");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* \t\tnew ProjectFile(");
        _builder.append(openVar, " ");
        _builder.append("quotes");
        _builder.append(closeVar, " ");
        _builder.append("src/");
        _builder.append(openVar, " ");
        _builder.append("path");
        _builder.append(closeVar, " ");
        _builder.append("/Model.pas");
        _builder.append(quotes, " ");
        _builder.append(", ");
        _builder.append(quotes, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("* \t\t\tHello ");
        _builder.append(openVar, " ");
        _builder.append("name");
        _builder.append(closeVar, " ");
        _builder.append("!");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("* \t\t");
        _builder.append(openVar, " ");
        _builder.append("quotes");
        _builder.append(closeVar, " ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("* \t}");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* </pre>");
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
        String _name = TemplateProjectWizardFragment.this.getGrammar().getName();
        _builder.append(_name);
        _builder.append(". You can set a parameter to modify the content in the generated file");
        _builder.newLineIfNotEmpty();
        _builder.append("and a parameter to set the package the file is created in.</p>\")");
        _builder.newLine();
        _builder.append("final class HelloWorldProject {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("var advanced = check(\"Advanced\", false, \"Check to enabled advanced configuration\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("var name = combo(\"Name\", #[\"Xtext\", \"World\", \"Foo\", \"Bar\"], \"The name to say \'Hello\' to\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("var path = text(\"Package\", \"");
        String _get = TemplateProjectWizardFragment.this.getLanguage().getFileExtensions().get(0);
        _builder.append(_get, "\t");
        _builder.append("\", \"The package path to place the files in\")");
        _builder.newLineIfNotEmpty();
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
        String _get_1 = TemplateProjectWizardFragment.this.getLanguage().getFileExtensions().get(0);
        _builder.append(_get_1, "\t\t\t");
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
        _builder.append("\t");
        _builder.append("override generateFiles(IProjectFileGenerator generator) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("generator.generate(");
        _builder.append(quotes, "\t\t");
        _builder.append("src/");
        _builder.append(openVar, "\t\t");
        _builder.append("path");
        _builder.append(closeVar, "\t\t");
        _builder.append("/Model.");
        String _get_2 = TemplateProjectWizardFragment.this.getLanguage().getFileExtensions().get(0);
        _builder.append(_get_2, "\t\t");
        _builder.append(quotes, "\t\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(quotes, "\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("/*");
        _builder.newLine();
        _builder.append("\t\t\t\t ");
        _builder.append("* This is an example model");
        _builder.newLine();
        _builder.append("\t\t\t\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("Hello ");
        _builder.append(openVar, "\t\t\t\t");
        _builder.append("name");
        _builder.append(closeVar, "\t\t\t\t");
        _builder.append("!");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(quotes, "\t\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }
  
  public void generateProjectCreator() {
    final TypeReference genClass = TypeReference.typeRef(this.getProjectCreatorClassName());
    final TypeReference projectInfoClass = TypeReference.typeRef(this.getProjectInfoClassName());
    String _xifexpression = null;
    if (this.pluginProject) {
      _xifexpression = "org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator";
    } else {
      _xifexpression = "org.eclipse.xtext.ui.wizard.AbstractProjectCreator";
    }
    final TypeReference baseClass = TypeReference.typeRef(_xifexpression);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(genClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("import java.util.HashMap;");
        _builder.newLine();
        _builder.append("import java.util.List;");
        _builder.newLine();
        _builder.append("import java.util.Set;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("import org.eclipse.core.resources.IProject;");
        _builder.newLine();
        _builder.append("import org.eclipse.core.resources.IResource;");
        _builder.newLine();
        _builder.append("import org.eclipse.core.runtime.CoreException;");
        _builder.newLine();
        _builder.append("import org.eclipse.core.runtime.IProgressMonitor;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.generator.IFileSystemAccess;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.generator.IFileSystemAccess2;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.generator.IOutputConfigurationProvider;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.generator.OutputConfiguration;");
        _builder.newLine();
        {
          if (TemplateProjectWizardFragment.this.pluginProject) {
            _builder.append("import org.eclipse.xtext.ui.util.PluginProjectFactory;");
            _builder.newLine();
          } else {
            _builder.append("import org.eclipse.xtext.ui.util.ProjectFactory;");
            _builder.newLine();
          }
        }
        _builder.append("import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.template.ProjectFileGenerator;");
        _builder.newLine();
        _builder.append("import com.google.common.collect.ImmutableList;");
        _builder.newLine();
        {
          if (TemplateProjectWizardFragment.this.pluginProject) {
            _builder.append("import com.google.common.collect.Lists;");
            _builder.newLine();
          }
        }
        _builder.append("import javax.inject.Inject;");
        _builder.newLine();
        _builder.append("import com.google.inject.Provider;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = genClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        _builder.append(baseClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("protected static final String DSL_PROJECT_NAME = \"");
        String _namespace = GrammarUtil.getNamespace(TemplateProjectWizardFragment.this.getGrammar());
        _builder.append(_namespace, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Inject");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Inject");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private IOutputConfigurationProvider outputConfigurationProvider;");
        _builder.newLine();
        {
          if ((!TemplateProjectWizardFragment.this.pluginProject)) {
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Inject");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("private Provider<ProjectFactory> projectFactoryProvider;");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Override");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("protected ProjectFactory createProjectFactory() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return projectFactoryProvider.get();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Override");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("protected PluginProjectFactory createProjectFactory() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("PluginProjectFactory projectFactory = super.createProjectFactory();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("projectFactory.setWithPluginXml(false);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return projectFactory;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        String _simpleName_1 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append(" getProjectInfo() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return (");
        String _simpleName_2 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_2, "\t\t");
        _builder.append(") super.getProjectInfo();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected String getModelFolderName() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return \"src\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected List<String> getAllFolders() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Set<OutputConfiguration> outputConfigurations = outputConfigurationProvider.getOutputConfigurations();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("String outputFolder = \"src-gen\";");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("for (OutputConfiguration outputConfiguration : outputConfigurations) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (IFileSystemAccess.DEFAULT_OUTPUT.equals(outputConfiguration.getName())) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("outputFolder = outputConfiguration.getOutputDirectory();");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("break;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return ImmutableList.of(getModelFolderName(), outputFolder);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        {
          if (TemplateProjectWizardFragment.this.pluginProject) {
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Override");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("protected List<String> getRequiredBundles() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return Lists.newArrayList(DSL_PROJECT_NAME);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void enhanceProject(final IProject project, final IProgressMonitor monitor) throws CoreException {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("IFileSystemAccess2 access = getFileSystemAccess(project, monitor);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("createFromTemplate(access, getProjectInfo());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("project.refreshLocal(IResource.DEPTH_INFINITE, monitor);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected IFileSystemAccess2 getFileSystemAccess(final IProject project, final IProgressMonitor monitor) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("EclipseResourceFileSystemAccess2 access = fileSystemAccessProvider.get();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("access.setContext(project);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("access.setMonitor(monitor);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("defaultOutput.setDescription(\"Output Folder\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("defaultOutput.setOutputDirectory(\"./\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("defaultOutput.setOverrideExistingResources(true);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("defaultOutput.setCreateOutputDirectory(true);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("defaultOutput.setCleanUpDerivedResources(false);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("defaultOutput.setSetDerivedProperty(false);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("defaultOutput.setKeepLocalHistory(false);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("HashMap<String, OutputConfiguration> outputConfigurations = new HashMap<String, OutputConfiguration>();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("outputConfigurations.put(IFileSystemAccess.DEFAULT_OUTPUT, defaultOutput);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("access.setOutputConfigurations(outputConfigurations);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return access;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private void createFromTemplate(IFileSystemAccess2 access, ");
        String _simpleName_3 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_3, "\t");
        _builder.append(" projectInfo) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("AbstractProjectTemplate projectTemplate = projectInfo.getProjectTemplate();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("projectTemplate.generateFiles(new ProjectFileGenerator(access));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrcGen());
  }
  
  public void generateNewProjectWizard() {
    final TypeReference genClass = TypeReference.typeRef(this.getProjectWizardClassName());
    final TypeReference projectInfoClass = TypeReference.typeRef(this.getProjectInfoClassName());
    final TypeReference creationPageClassName = TypeReference.typeRef(this.getProjectWizardCreationPageClassName());
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(genClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.IProjectCreator;");
        _builder.newLine();
        _builder.append("import javax.inject.Inject;");
        _builder.newLine();
        _builder.append("import java.util.List;");
        _builder.newLine();
        _builder.append("import org.eclipse.jface.wizard.IWizardPage;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.template.NewProjectWizardTemplateParameterPage;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.template.NewProjectWizardTemplateSelectionPage;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.template.ProjectTemplateLabelProvider;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.template.ProjectVariable;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = genClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.wizard.XtextNewProjectWizard");
        _builder.append(_typeRef);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static final String GRAMMAR_NAME = \"");
        String _name = TemplateProjectWizardFragment.this.getGrammar().getName();
        _builder.append(_name, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private ");
        _builder.append(creationPageClassName, "\t");
        _builder.append(" mainPage;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private NewProjectWizardTemplateSelectionPage templatePage;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private NewProjectWizardTemplateParameterPage templateParameterPage;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Inject");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private ProjectTemplateLabelProvider labelProvider;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Inject");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _simpleName_1 = genClass.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(IProjectCreator projectCreator) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(projectCreator);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("setWindowTitle(\"New ");
        String _simpleName_2 = GrammarUtil.getSimpleName(TemplateProjectWizardFragment.this.getGrammar());
        _builder.append(_simpleName_2, "\t\t");
        _builder.append(" Project\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(creationPageClassName, "\t");
        _builder.append(" getMainPage() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return mainPage;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Use this method to add pages to the wizard.");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* The one-time generated version of this class will add a default new project page to the wizard.");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void addPages() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("mainPage = createMainPage(\"basicNewProjectPage\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("mainPage.setTitle(\"");
        String _simpleName_3 = GrammarUtil.getSimpleName(TemplateProjectWizardFragment.this.getGrammar());
        _builder.append(_simpleName_3, "\t\t");
        _builder.append(" Project\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("mainPage.setDescription(\"Create a new ");
        String _simpleName_4 = GrammarUtil.getSimpleName(TemplateProjectWizardFragment.this.getGrammar());
        _builder.append(_simpleName_4, "\t\t");
        _builder.append(" project.\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("addPage(mainPage);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("templatePage = createTemplatePage(\"templateNewProjectPage\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("templatePage.setTitle(\"");
        String _simpleName_5 = GrammarUtil.getSimpleName(TemplateProjectWizardFragment.this.getGrammar());
        _builder.append(_simpleName_5, "\t\t");
        _builder.append(" Project\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("templatePage.setDescription(\"Create a new ");
        String _simpleName_6 = GrammarUtil.getSimpleName(TemplateProjectWizardFragment.this.getGrammar());
        _builder.append(_simpleName_6, "\t\t");
        _builder.append(" project.\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("addPage(templatePage);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(creationPageClassName, "\t");
        _builder.append(" createMainPage(String pageName) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return new ");
        _builder.append(creationPageClassName, "\t\t");
        _builder.append("(pageName);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected NewProjectWizardTemplateSelectionPage createTemplatePage(String pageName) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return new NewProjectWizardTemplateSelectionPage(pageName, GRAMMAR_NAME, labelProvider);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Use this method to read the project settings from the wizard pages and feed them into the project info class.");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected IExtendedProjectInfo getProjectInfo() {");
        _builder.newLine();
        _builder.append("\t\t");
        String _simpleName_7 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_7, "\t\t");
        _builder.append(" projectInfo = new ");
        String _simpleName_8 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_8, "\t\t");
        _builder.append("(templatePage.getSelectedTemplate());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("projectInfo.setProjectName(mainPage.getProjectName());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (!mainPage.useDefaults()) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("projectInfo.setLocationPath(mainPage.getLocationPath());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return projectInfo;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public IWizardPage getNextPage(IWizardPage page) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (page instanceof NewProjectWizardTemplateSelectionPage) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("AbstractProjectTemplate selectedTemplate = templatePage.getSelectedTemplate();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (selectedTemplate == null)");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("List<ProjectVariable> variables = selectedTemplate.getVariables();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (variables.isEmpty())");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("NewProjectWizardTemplateParameterPage parameterPage = new NewProjectWizardTemplateParameterPage(");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("selectedTemplate);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("parameterPage.setWizard(this);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("templateParameterPage = parameterPage;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("parameterPage.setTitle(\"");
        String _simpleName_9 = GrammarUtil.getSimpleName(TemplateProjectWizardFragment.this.getGrammar());
        _builder.append(_simpleName_9, "\t\t\t");
        _builder.append(" Project\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("parameterPage.setDescription(\"Create a new ");
        String _simpleName_10 = GrammarUtil.getSimpleName(TemplateProjectWizardFragment.this.getGrammar());
        _builder.append(_simpleName_10, "\t\t\t");
        _builder.append(" project.\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return parameterPage;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return super.getNextPage(page);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public IWizardPage getPreviousPage(IWizardPage page) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (page instanceof NewProjectWizardTemplateParameterPage) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("templateParameterPage = null;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return templatePage;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return super.getPreviousPage(page);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public boolean canFinish() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return super.canFinish() && (templateParameterPage == null ? true : templateParameterPage.isPageComplete());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrcGen());
  }
  
  public void generateDefaultIcons() {
    final BinaryFileAccess projectTemplate = this.fileAccessFactory.createBinaryFile("project_template.png");
    projectTemplate.setContent(this.readBinaryFileFromPackage("project_template.png"));
    projectTemplate.writeTo(this.getProjectConfig().getEclipsePlugin().getIcons());
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus = ("new_" + _simpleName);
    String _plus_1 = (_plus + "_proj.gif");
    final BinaryFileAccess newProject = this.fileAccessFactory.createBinaryFile(_plus_1);
    newProject.setContent(this.readBinaryFileFromPackage("new_xproj.gif"));
    newProject.writeTo(this.getProjectConfig().getEclipsePlugin().getIcons());
  }
  
  private byte[] readBinaryFileFromPackage(final String fileName) {
    try {
      InputStream _resourceAsStream = TemplateProjectWizardFragment.class.getResourceAsStream(fileName);
      final BufferedInputStream bis = new BufferedInputStream(_resourceAsStream);
      final ByteArrayOutputStream buf = new ByteArrayOutputStream();
      int next = bis.read();
      while ((next != (-1))) {
        {
          buf.write(((byte) next));
          next = bis.read();
        }
      }
      return buf.toByteArray();
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
  
  protected String getProjectWizardInitialContentsClassName() {
    String _projectWizardClassName = this.getProjectWizardClassName();
    return (_projectWizardClassName + "InitialContents");
  }
  
  protected String getProjectWizardClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "NewProjectWizard");
  }
  
  protected String getProjectWizardCreationPageClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "WizardNewProjectCreationPage");
  }
  
  protected String projectWizardTemplateSelectionPageClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "WizardNewProjectWizardTemplateSelectionPage");
  }
  
  protected String getProjectCreatorClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "ProjectCreator");
  }
  
  protected String getProjectInfoClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "ProjectInfo");
  }
  
  protected String getProjectWizardPackage() {
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(this.getGrammar());
    return (_eclipsePluginBasePackage + ".wizard.");
  }
  
  @Pure
  public boolean isGenerate() {
    return this.generate;
  }
  
  public void setGenerate(final boolean generate) {
    this.generate = generate;
  }
  
  @Pure
  public boolean isPluginProject() {
    return this.pluginProject;
  }
  
  public void setPluginProject(final boolean pluginProject) {
    this.pluginProject = pluginProject;
  }
}
