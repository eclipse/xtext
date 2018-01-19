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
      Iterables.<String>addAll(_requiredBundles, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.core.runtime", "org.eclipse.core.resources", "org.eclipse.ui", "org.eclipse.ui.ide", "org.eclipse.ui.forms")));
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
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("point=\"org.eclipse.xtext.ui.projectTemplate\">");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("<projectTemplateProvider");
      _builder.newLine();
      _builder.append("         ");
      _builder.append("class=\"");
      String _projectTemplateProviderClassName = this.getProjectTemplateProviderClassName();
      _builder.append(_projectTemplateProviderClassName, "         ");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("         ");
      _builder.append("grammarName=\"");
      String _name = this.getGrammar().getName();
      _builder.append(_name, "         ");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("   ");
      _builder.append("</projectTemplateProvider>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
    }
    this.generateProjectInfo();
    this.generateWizardNewProjectCreationPage();
    this.generateProjectTemplateProvider();
    this.generateNewProjectWizard();
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
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
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
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
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
        {
          if (TemplateProjectWizardFragment.this.pluginProject) {
            _builder.append("import java.util.Arrays");
            _builder.newLine();
          }
        }
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
        {
          if (TemplateProjectWizardFragment.this.pluginProject) {
            _builder.append("\t");
            _builder.append("override generateProjects(IProjectGenerator generator) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("generator.generate(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("new PluginProjectFactory().setProjectName(getProjectInfo().getProjectName()).setLocation(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("getProjectInfo().getLocationPath()).addProjectNatures(JavaCore.NATURE_ID,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("\"org.eclipse.pde.PluginNature\", XtextProjectHelper.NATURE_ID).addBuilderIds(JavaCore.BUILDER_ID).");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("addFolders(Arrays.asList(\"src\")).addFile(");
            _builder.append(quotes, "\t\t\t\t");
            _builder.append("src/");
            _builder.append(openVar, "\t\t\t\t");
            _builder.append("path");
            _builder.append(closeVar, "\t\t\t\t");
            _builder.append("/Model.");
            String _get_2 = TemplateProjectWizardFragment.this.getLanguage().getFileExtensions().get(0);
            _builder.append(_get_2, "\t\t\t\t");
            _builder.append(quotes, "\t\t\t\t");
            _builder.append(", ");
            _builder.append(quotes, "\t\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("/*");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t ");
            _builder.append("* This is an example model");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("Hello ");
            _builder.append(openVar, "\t\t\t\t\t");
            _builder.append("name");
            _builder.append(closeVar, "\t\t\t\t\t");
            _builder.append("!");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append(quotes, "\t\t\t\t");
            _builder.append("))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("override generateProjects(IProjectGenerator generator) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("generator.generate(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("new ProjectFactory().setProjectName(getProjectInfo().getProjectName()).setLocation(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("getProjectInfo().getLocationPath()).addProjectNatures(XtextProjectHelper.NATURE_ID).");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("addFile(");
            _builder.append(quotes, "\t\t\t\t");
            _builder.append("src/");
            _builder.append(openVar, "\t\t\t\t");
            _builder.append("path");
            _builder.append(closeVar, "\t\t\t\t");
            _builder.append("/Model.");
            String _get_3 = TemplateProjectWizardFragment.this.getLanguage().getFileExtensions().get(0);
            _builder.append(_get_3, "\t\t\t\t");
            _builder.append(quotes, "\t\t\t\t");
            _builder.append(", ");
            _builder.append(quotes, "\t\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("/*");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t ");
            _builder.append("* This is an example model");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("Hello ");
            _builder.append(openVar, "\t\t\t\t\t");
            _builder.append("name");
            _builder.append(closeVar, "\t\t\t\t\t");
            _builder.append("!");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append(quotes, "\t\t\t\t");
            _builder.append("))");
            _builder.newLineIfNotEmpty();
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
  
  public void generateNewProjectWizard() {
    final TypeReference genClass = TypeReference.typeRef(this.getProjectWizardClassName());
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(genClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = genClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.wizard.template.TemplateNewProjectWizard");
        _builder.append(_typeRef);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected String getGrammarName() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return \"");
        String _name = TemplateProjectWizardFragment.this.getGrammar().getName();
        _builder.append(_name, "\t\t");
        _builder.append("\";");
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
