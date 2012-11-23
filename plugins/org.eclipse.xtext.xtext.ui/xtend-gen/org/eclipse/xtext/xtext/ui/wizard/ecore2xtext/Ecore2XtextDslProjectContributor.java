package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import java.util.Collection;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor.IFileCreator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.EPackageInfo;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.Ecore2XtextGrammarCreator;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.Ecore2XtextProjectInfo;
import org.eclipse.xtext.xtext.ui.wizard.project.DefaultProjectFactoryContributor;

/**
 * Contributes a workflow file and the grammar to the new Ecore2Xtext DSL project
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("all")
public class Ecore2XtextDslProjectContributor extends DefaultProjectFactoryContributor {
  private Ecore2XtextProjectInfo projectInfo;
  
  private String modelFolder = "";
  
  public Ecore2XtextDslProjectContributor(final Ecore2XtextProjectInfo projectInfo) {
    this.projectInfo = projectInfo;
  }
  
  public void setModelFolder(final String modelFolder) {
    this.modelFolder = modelFolder;
  }
  
  public void contributeFiles(final IProject project, final IFileCreator creator) {
    this.createWorkflowFile(creator);
    this.createGrammarFile(creator);
  }
  
  public IFile createWorkflowFile(final IFileCreator creator) {
    CharSequence _workflow = this.workflow();
    String _plus = (this.modelFolder + "/");
    String _basePackagePath = this.projectInfo.getBasePackagePath();
    String _plus_1 = (_plus + _basePackagePath);
    String _plus_2 = (_plus_1 + "/Generate");
    String _languageNameAbbreviation = this.projectInfo.getLanguageNameAbbreviation();
    String _plus_3 = (_plus_2 + _languageNameAbbreviation);
    String _plus_4 = (_plus_3 + ".mwe2");
    IFile _writeToFile = creator.writeToFile(_workflow, _plus_4);
    return _writeToFile;
  }
  
  public IFile createGrammarFile(final IFileCreator creator) {
    Ecore2XtextGrammarCreator _ecore2XtextGrammarCreator = new Ecore2XtextGrammarCreator();
    CharSequence _grammar = _ecore2XtextGrammarCreator.grammar(this.projectInfo);
    String _plus = (this.modelFolder + "/");
    String _grammarFilePath = this.projectInfo.getGrammarFilePath();
    String _plus_1 = (_plus + _grammarFilePath);
    IFile _writeToFile = creator.writeToFile(_grammar, _plus_1);
    return _writeToFile;
  }
  
  private CharSequence workflow() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module ");
    String _basePackagePath = this.projectInfo.getBasePackagePath();
    String _plus = (_basePackagePath + "/");
    String _languageNameAbbreviation = this.projectInfo.getLanguageNameAbbreviation();
    String _plus_1 = (_plus + _languageNameAbbreviation);
    String _replaceAll = _plus_1.replaceAll("/", ".");
    _builder.append(_replaceAll, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.mwe.utils.*");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.generator.*");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.ui.generator.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("var grammarURI = \"classpath:/");
    String _basePackagePath_1 = this.projectInfo.getBasePackagePath();
    _builder.append(_basePackagePath_1, "");
    _builder.append("/");
    String _languageNameAbbreviation_1 = this.projectInfo.getLanguageNameAbbreviation();
    _builder.append(_languageNameAbbreviation_1, "");
    _builder.append(".xtext\"");
    _builder.newLineIfNotEmpty();
    _builder.append("var file.extensions = \"");
    String _firstFileExtension = this.projectInfo.getFirstFileExtension();
    _builder.append(_firstFileExtension, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("var projectName = \"");
    String _projectName = this.projectInfo.getProjectName();
    _builder.append(_projectName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("var runtimeProject = \"../${projectName}\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Workflow {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("bean = StandaloneSetup {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("scanClassPath  = true");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("platformUri = \"${runtimeProject}/..\"");
    _builder.newLine();
    {
      Collection<EPackageInfo> _ePackageInfos = this.projectInfo.getEPackageInfos();
      for(final EPackageInfo ePackageInfo : _ePackageInfos) {
        {
          String _ePackageJavaFQN = ePackageInfo.getEPackageJavaFQN();
          boolean _notEquals = ObjectExtensions.operator_notEquals(_ePackageJavaFQN, null);
          if (_notEquals) {
            _builder.append("\t");
            _builder.append("registerGeneratedEPackage = \"");
            String _ePackageJavaFQN_1 = ePackageInfo.getEPackageJavaFQN();
            _builder.append(_ePackageJavaFQN_1, "	");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      Collection<EPackageInfo> _ePackageInfos_1 = this.projectInfo.getEPackageInfos();
      final Function1<EPackageInfo,URI> _function = new Function1<EPackageInfo,URI>() {
          public URI apply(final EPackageInfo e) {
            URI _genmodelURI = e.getGenmodelURI();
            return _genmodelURI;
          }
        };
      Iterable<URI> _map = IterableExtensions.<EPackageInfo, URI>map(_ePackageInfos_1, _function);
      Set<URI> _set = IterableExtensions.<URI>toSet(_map);
      for(final URI genmodelURI : _set) {
        _builder.append("\t");
        _builder.append("// registerGenModelFile = \"");
        _builder.append(genmodelURI, "	");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("component = DirectoryCleaner {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("directory = \"${runtimeProject}/src-gen\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("component = DirectoryCleaner {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("directory = \"${runtimeProject}.ui/src-gen\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("component = Generator {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("pathRtProject = runtimeProject");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("pathUiProject = \"${runtimeProject}.ui\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("projectNameRt = projectName");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("projectNameUi = \"${projectName}.ui\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("language = {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("uri = grammarURI");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fileExtensions = file.extensions");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// Java API to access grammar elements (required by several other fragments)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = grammarAccess.GrammarAccessFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// generates Java API for the generated EPackages");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// fragment = ecore.EcoreGeneratorFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// the serialization component");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = parseTreeConstructor.ParseTreeConstructorFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// a custom ResourceFactory for use with EMF ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = resourceFactory.ResourceFactoryFragment {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("fileExtensions = file.extensions");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// the Antlr parser");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = parser.antlr.XtextAntlrGeneratorFragment {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("options = {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("classSplitting = true");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// the Ecore2Xtext specific terminal converter");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = ecore2xtext.Ecore2XtextValueConverterServiceFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// java-based API for validation ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = validation.JavaValidatorFragment {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// composedCheck = \"org.eclipse.xtext.validation.ImportUriValidator\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// composedCheck = \"org.eclipse.xtext.validation.NamesAreUniqueValidator\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// scoping and exporting API");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = scoping.ImportURIScopingFragment {}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = exporting.SimpleNamesFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// scoping and exporting API ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// fragment = scoping.ImportNamespacesScopingFragment {}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// fragment = exporting.QualifiedNamesFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// formatter API ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = ecore2xtext.FormatterFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// labeling API ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = labeling.LabelProviderFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// outline API ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("fragment = outline.OutlineTreeProviderFragment {}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("fragment = outline.QuickOutlineFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// java-based API for content assistance ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = contentAssist.JavaBasedContentAssistFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// antlr parser generator tailored for content assist ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = parser.antlr.XtextAntlrUiGeneratorFragment {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("options = {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("classSplitting = true");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// provides a compare view");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("fragment = compare.CompareFragment {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("fileExtensions = file.extensions");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = builder.BuilderIntegrationFragment {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// project wizard (optional) ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// fragment = projectWizard.SimpleProjectWizardFragment {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//\t\tgeneratorProjectName = \"${projectName}.generator\" ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//\t\tmodelFileExtension = file.extensions");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// quickfix API ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fragment = quickfix.QuickfixProviderFragment {}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
