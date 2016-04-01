/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.projectWizard;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

/**
 * Contributes the registration of compare infrastructure.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
@SuppressWarnings("all")
public class SimpleProjectWizardFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Accessors
  private boolean generate = false;
  
  @Override
  public void generate() {
    if ((!this.generate)) {
      return;
    }
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    ManifestAccess _manifest = null;
    if (_eclipsePlugin!=null) {
      _manifest=_eclipsePlugin.getManifest();
    }
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
      ManifestAccess _manifest_1 = _eclipsePlugin_1.getManifest();
      Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
      Iterables.<String>addAll(_requiredBundles, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.ui", "org.eclipse.core.runtime", "org.eclipse.core.resources", "org.eclipse.ui.ide")));
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.wizard.IProjectCreator");
    String _projectCreatorClassName = this.getProjectCreatorClassName();
    TypeReference _typeReference_1 = new TypeReference(_projectCreatorClassName);
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeReference, _typeReference_1);
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language.getEclipsePluginGenModule();
    _addTypeToType.contributeTo(_eclipsePluginGenModule);
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin_2 = _projectConfig_2.getEclipsePlugin();
    PluginXmlAccess _pluginXml = null;
    if (_eclipsePlugin_2!=null) {
      _pluginXml=_eclipsePlugin_2.getPluginXml();
    }
    boolean _notEquals = (!Objects.equal(_pluginXml, null));
    if (_notEquals) {
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_3 = _projectConfig_3.getEclipsePlugin();
      PluginXmlAccess _pluginXml_1 = _eclipsePlugin_3.getPluginXml();
      List<CharSequence> _entries = _pluginXml_1.getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("point=\"org.eclipse.ui.newWizards\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<wizard");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("category=\"org.eclipse.xtext.projectwiz\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      Grammar _grammar = this.getGrammar();
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar);
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
      Grammar _grammar_1 = this.getGrammar();
      String _simpleName = GrammarUtil.getSimpleName(_grammar_1);
      _builder.append(_simpleName, "\t\t");
      _builder.append(" Project\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("project=\"true\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</wizard>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
    }
    this.generateProjectInfo();
    this.generateNewProjectWizardInitialContents();
    this.generateProjectCreator();
    this.generateNewProjectWizard();
  }
  
  public void generateProjectInfo() {
    String _projectInfoClassName = this.getProjectInfoClassName();
    final TypeReference projectInfoClass = TypeReference.typeRef(_projectInfoClassName);
    final JavaFileAccess file = this.fileAccessFactory.createJavaFile(projectInfoClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = projectInfoClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.wizard.DefaultProjectInfo");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    file.writeTo(_src);
  }
  
  public void generateNewProjectWizardInitialContents() {
    String _projectWizardInitialContentsClassName = this.getProjectWizardInitialContentsClassName();
    final TypeReference initialContentsClass = TypeReference.typeRef(_projectWizardInitialContentsClassName);
    final XtendFileAccess file = this.fileAccessFactory.createXtendFile(initialContentsClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("import com.google.inject.Inject");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.generator.IFileSystemAccess2");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.resource.FileExtensionProvider");
        _builder.newLine();
        _builder.newLine();
        _builder.append("class ");
        String _simpleName = initialContentsClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@Inject");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("FileExtensionProvider fileExtensionProvider");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def generateInitialContents(IFileSystemAccess2 fsa) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("fsa.generateFile(");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\"src/model/Model.\" + fileExtensionProvider.primaryFileExtension,");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\'\'");
        _builder.append("\'");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("/*");
        _builder.newLine();
        _builder.append("\t\t\t ");
        _builder.append("* This is an example model");
        _builder.newLine();
        _builder.append("\t\t\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("Hello Xtext!");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\'\'");
        _builder.append("\'");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    file.writeTo(_src);
  }
  
  public void generateProjectCreator() {
    String _projectCreatorClassName = this.getProjectCreatorClassName();
    final TypeReference genClass = TypeReference.typeRef(_projectCreatorClassName);
    String _projectInfoClassName = this.getProjectInfoClassName();
    final TypeReference projectInfoClass = TypeReference.typeRef(_projectInfoClassName);
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
        _builder.append("import org.eclipse.xtext.generator.IOutputConfigurationProvider;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.generator.OutputConfiguration;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.util.PluginProjectFactory;");
        _builder.newLine();
        _builder.append("import com.google.common.collect.ImmutableList;");
        _builder.newLine();
        _builder.append("import com.google.common.collect.Lists;");
        _builder.newLine();
        _builder.append("import com.google.inject.Inject;");
        _builder.newLine();
        _builder.append("import com.google.inject.Provider;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = genClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@Inject");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private ");
        String _projectWizardInitialContentsClassName = SimpleProjectWizardFragment2.this.getProjectWizardInitialContentsClassName();
        TypeReference _typeRef_1 = TypeReference.typeRef(_projectWizardInitialContentsClassName);
        String _simpleName_1 = _typeRef_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append(" initialContents;");
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
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected static final String DSL_GENERATOR_PROJECT_NAME = \"");
        Grammar _grammar = SimpleProjectWizardFragment2.this.getGrammar();
        String _namespace = GrammarUtil.getNamespace(_grammar);
        _builder.append(_namespace, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected PluginProjectFactory createProjectFactory() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("PluginProjectFactory projectFactory = super.createProjectFactory();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("projectFactory.setWithPluginXml(false);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return projectFactory;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        String _simpleName_2 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_2, "\t");
        _builder.append(" getProjectInfo() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return (");
        String _simpleName_3 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_3, "\t\t");
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
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected List<String> getRequiredBundles() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return Lists.newArrayList(DSL_GENERATOR_PROJECT_NAME);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void enhanceProject(final IProject project, final IProgressMonitor monitor) throws CoreException {");
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
        _builder.append("initialContents.generateInitialContents(access);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("project.refreshLocal(IResource.DEPTH_INFINITE, monitor);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _srcGen = _eclipsePlugin.getSrcGen();
    file.writeTo(_srcGen);
  }
  
  public void generateNewProjectWizard() {
    String _projectWizardClassName = this.getProjectWizardClassName();
    final TypeReference genClass = TypeReference.typeRef(_projectWizardClassName);
    String _projectInfoClassName = this.getProjectInfoClassName();
    final TypeReference projectInfoClass = TypeReference.typeRef(_projectInfoClassName);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(genClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.IProjectInfo;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.wizard.IProjectCreator;");
        _builder.newLine();
        _builder.append("import com.google.inject.Inject;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = genClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.wizard.XtextNewProjectWizard");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private WizardNewProjectCreationPage mainPage;");
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
        Grammar _grammar = SimpleProjectWizardFragment2.this.getGrammar();
        String _name = _grammar.getName();
        _builder.append(_name, "\t\t");
        _builder.append(" Project\");");
        _builder.newLineIfNotEmpty();
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
        _builder.append("mainPage = new WizardNewProjectCreationPage(\"basicNewProjectPage\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("mainPage.setTitle(\"");
        Grammar _grammar_1 = SimpleProjectWizardFragment2.this.getGrammar();
        String _name_1 = _grammar_1.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(" Project\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("mainPage.setDescription(\"Create a new ");
        Grammar _grammar_2 = SimpleProjectWizardFragment2.this.getGrammar();
        String _name_2 = _grammar_2.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append(" project.\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("addPage(mainPage);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
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
        _builder.append("protected IProjectInfo getProjectInfo() {");
        _builder.newLine();
        _builder.append("\t\t");
        String _simpleName_2 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_2, "\t\t");
        _builder.append(" projectInfo = new ");
        String _simpleName_3 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_3, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("projectInfo.setProjectName(mainPage.getProjectName());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return projectInfo;");
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
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _srcGen = _eclipsePlugin.getSrcGen();
    file.writeTo(_srcGen);
  }
  
  protected String getProjectWizardInitialContentsClassName() {
    String _projectWizardClassName = this.getProjectWizardClassName();
    return (_projectWizardClassName + "InitialContents");
  }
  
  protected String getProjectWizardClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    Grammar _grammar = this.getGrammar();
    String _simpleName = GrammarUtil.getSimpleName(_grammar);
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "NewProjectWizard");
  }
  
  protected String getProjectCreatorClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    Grammar _grammar = this.getGrammar();
    String _simpleName = GrammarUtil.getSimpleName(_grammar);
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "ProjectCreator");
  }
  
  protected String getProjectInfoClassName() {
    String _projectWizardPackage = this.getProjectWizardPackage();
    Grammar _grammar = this.getGrammar();
    String _simpleName = GrammarUtil.getSimpleName(_grammar);
    String _plus = (_projectWizardPackage + _simpleName);
    return (_plus + "ProjectInfo");
  }
  
  protected String getProjectWizardPackage() {
    Grammar _grammar = this.getGrammar();
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(_grammar);
    return (_eclipsePluginBasePackage + ".wizard.");
  }
  
  @Pure
  public boolean isGenerate() {
    return this.generate;
  }
  
  public void setGenerate(final boolean generate) {
    this.generate = generate;
  }
}
