/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.ui.projectWizard;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;

/**
 * Contributes the registration of compare infrastructure.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
@Deprecated
@SuppressWarnings("all")
public class SimpleProjectWizardFragment2 extends AbstractXtextGeneratorFragment {
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
      Iterables.<String>addAll(_requiredBundles, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.ui", "org.eclipse.core.runtime", "org.eclipse.core.resources", "org.eclipse.ui.ide")));
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
      _builder.append("<wizard");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("category=\"org.eclipse.xtext.projectwiz\"");
      _builder.newLine();
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
      String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
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
    this.generateWizardNewProjectCreationPage();
    this.generateNewProjectWizardInitialContents();
    this.generateProjectCreator();
    this.generateNewProjectWizard();
  }

  public void generateProjectInfo() {
    final TypeReference projectInfoClass = TypeReference.typeRef(this.getProjectInfoClassName());
    final JavaFileAccess file = this.fileAccessFactory.createJavaFile(projectInfoClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = projectInfoClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.wizard.DefaultProjectInfo");
        _builder.append(_typeRef);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  public void generateWizardNewProjectCreationPage() {
    final TypeReference mainPageClass = TypeReference.typeRef(this.getProjectWizardCreationPageClassName());
    final JavaFileAccess file = this.fileAccessFactory.createJavaFile(mainPageClass);
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
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  public void generateNewProjectWizardInitialContents() {
    final TypeReference initialContentsClass = TypeReference.typeRef(this.getProjectWizardInitialContentsClassName());
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
        _builder.append(_simpleName);
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
          if (SimpleProjectWizardFragment2.this.pluginProject) {
            _builder.append("import org.eclipse.xtext.ui.util.PluginProjectFactory;");
            _builder.newLine();
          } else {
            _builder.append("import org.eclipse.xtext.ui.util.ProjectFactory;");
            _builder.newLine();
          }
        }
        _builder.append("import com.google.common.collect.ImmutableList;");
        _builder.newLine();
        {
          if (SimpleProjectWizardFragment2.this.pluginProject) {
            _builder.append("import com.google.common.collect.Lists;");
            _builder.newLine();
          }
        }
        _builder.append("import com.google.inject.Inject;");
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
        String _namespace = GrammarUtil.getNamespace(SimpleProjectWizardFragment2.this.getGrammar());
        _builder.append(_namespace, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Inject");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private ");
        String _simpleName_1 = TypeReference.typeRef(SimpleProjectWizardFragment2.this.getProjectWizardInitialContentsClassName()).getSimpleName();
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
        {
          if ((!SimpleProjectWizardFragment2.this.pluginProject)) {
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
        {
          if (SimpleProjectWizardFragment2.this.pluginProject) {
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
        _builder.append("initialContents.generateInitialContents(access);");
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
        _builder.append("import com.google.inject.Inject;");
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
        _builder.append("private ");
        _builder.append(creationPageClassName, "\t");
        _builder.append(" mainPage;");
        _builder.newLineIfNotEmpty();
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
        String _simpleName_2 = GrammarUtil.getSimpleName(SimpleProjectWizardFragment2.this.getGrammar());
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
        String _simpleName_3 = GrammarUtil.getSimpleName(SimpleProjectWizardFragment2.this.getGrammar());
        _builder.append(_simpleName_3, "\t\t");
        _builder.append(" Project\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("mainPage.setDescription(\"Create a new ");
        String _simpleName_4 = GrammarUtil.getSimpleName(SimpleProjectWizardFragment2.this.getGrammar());
        _builder.append(_simpleName_4, "\t\t");
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
        String _simpleName_5 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_5, "\t\t");
        _builder.append(" projectInfo = new ");
        String _simpleName_6 = projectInfoClass.getSimpleName();
        _builder.append(_simpleName_6, "\t\t");
        _builder.append("();");
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
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrcGen());
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
