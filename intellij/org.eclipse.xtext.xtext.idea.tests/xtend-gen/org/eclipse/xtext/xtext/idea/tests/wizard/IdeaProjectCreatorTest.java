package org.eclipse.xtext.xtext.idea.tests.wizard;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.testFramework.PsiTestCase;
import java.io.IOException;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.wizard.XtextModuleBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;
import org.junit.Test;

@SuppressWarnings("all")
public class IdeaProjectCreatorTest extends PsiTestCase {
  private XtextModuleBuilder builder;
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    XtextModuleBuilder _xtextModuleBuilder = new XtextModuleBuilder();
    this.builder = _xtextModuleBuilder;
    this.builder.setName("mydsl");
    WizardConfiguration _wizardConfiguration = this.builder.getWizardConfiguration();
    LanguageDescriptor _language = _wizardConfiguration.getLanguage();
    _language.setName("org.xtext.MyDsl");
  }
  
  @Override
  protected Module createMainModule() throws IOException {
    return null;
  }
  
  @Test
  public void testCreateProject() {
    final List<Module> modules = this.executeModuleBuilder();
    int _size = modules.size();
    TestCase.assertEquals(1, _size);
    Module _get = modules.get(0);
    String _name = _get.getName();
    TestCase.assertEquals("mydsl", _name);
    Module _get_1 = modules.get(0);
    String _moduleFilePath = _get_1.getModuleFilePath();
    boolean _endsWith = _moduleFilePath.endsWith("/mydsl/mydsl.iml");
    TestCase.assertTrue(_endsWith);
  }
  
  public List<Module> executeModuleBuilder() {
    Project _project = this.getProject();
    final List<Module> modules = this.builder.commit(_project);
    return modules;
  }
  
  @Test
  public void testCreateGradleProject() {
    WizardConfiguration _wizardConfiguration = this.builder.getWizardConfiguration();
    _wizardConfiguration.setPreferredBuildSystem(BuildSystem.GRADLE);
    final List<Module> modules = this.executeModuleBuilder();
    int _size = modules.size();
    TestCase.assertEquals(2, _size);
    Module _get = modules.get(0);
    String _name = _get.getName();
    TestCase.assertEquals("mydsl.parent", _name);
    Module _get_1 = modules.get(0);
    String _moduleFilePath = _get_1.getModuleFilePath();
    boolean _endsWith = _moduleFilePath.endsWith("/mydsl.parent/mydsl.parent.iml");
    TestCase.assertTrue(_endsWith);
    Module _get_2 = modules.get(1);
    String _name_1 = _get_2.getName();
    TestCase.assertEquals("mydsl", _name_1);
    Module _get_3 = modules.get(1);
    String _moduleFilePath_1 = _get_3.getModuleFilePath();
    boolean _endsWith_1 = _moduleFilePath_1.endsWith("/mydsl/mydsl.iml");
    TestCase.assertTrue(_endsWith_1);
  }
  
  @Test
  public void testCreateGradleHirachicalProject() {
    WizardConfiguration _wizardConfiguration = this.builder.getWizardConfiguration();
    _wizardConfiguration.setPreferredBuildSystem(BuildSystem.GRADLE);
    WizardConfiguration _wizardConfiguration_1 = this.builder.getWizardConfiguration();
    _wizardConfiguration_1.setProjectLayout(ProjectLayout.HIERARCHICAL);
    final List<Module> modules = this.executeModuleBuilder();
    int _size = modules.size();
    TestCase.assertEquals(2, _size);
    Module _get = modules.get(0);
    String _name = _get.getName();
    TestCase.assertEquals("mydsl.parent", _name);
    Module _get_1 = modules.get(0);
    String _moduleFilePath = _get_1.getModuleFilePath();
    boolean _endsWith = _moduleFilePath.endsWith("/mydsl.parent/mydsl.parent.iml");
    TestCase.assertTrue(_endsWith);
    Module _get_2 = modules.get(1);
    String _name_1 = _get_2.getName();
    TestCase.assertEquals("mydsl", _name_1);
    Module _get_3 = modules.get(1);
    String _moduleFilePath_1 = _get_3.getModuleFilePath();
    boolean _endsWith_1 = _moduleFilePath_1.endsWith("/mydsl.parent/mydsl/mydsl.iml");
    TestCase.assertTrue(_endsWith_1);
    Project _project = this.getProject();
    ModuleManager _instance = ModuleManager.getInstance(_project);
    final Module[] allModules = _instance.getModules();
    int _size_1 = ((List<Module>)Conversions.doWrapArray(allModules)).size();
    TestCase.assertEquals(2, _size_1);
  }
  
  @Test
  public void testCreateTwoLanguagesProject() {
    Project _project = this.getProject();
    ModuleManager _instance = ModuleManager.getInstance(_project);
    final Module[] allModules = _instance.getModules();
    int _size = ((List<Module>)Conversions.doWrapArray(allModules)).size();
    TestCase.assertEquals(0, _size);
    WizardConfiguration _wizardConfiguration = this.builder.getWizardConfiguration();
    _wizardConfiguration.setPreferredBuildSystem(BuildSystem.MAVEN);
    WizardConfiguration _wizardConfiguration_1 = this.builder.getWizardConfiguration();
    _wizardConfiguration_1.setProjectLayout(ProjectLayout.HIERARCHICAL);
    this.builder.setName("mydsl");
    final List<Module> modules = this.executeModuleBuilder();
    int _size_1 = modules.size();
    TestCase.assertEquals(2, _size_1);
    Module _get = modules.get(0);
    String _name = _get.getName();
    TestCase.assertEquals("mydsl.parent", _name);
    Module _get_1 = modules.get(0);
    String _moduleFilePath = _get_1.getModuleFilePath();
    boolean _endsWith = _moduleFilePath.endsWith("/mydsl.parent/mydsl.parent.iml");
    TestCase.assertTrue(_endsWith);
    Module _get_2 = modules.get(1);
    String _name_1 = _get_2.getName();
    TestCase.assertEquals("mydsl", _name_1);
    Module _get_3 = modules.get(1);
    String _moduleFilePath_1 = _get_3.getModuleFilePath();
    boolean _endsWith_1 = _moduleFilePath_1.endsWith("/mydsl.parent/mydsl/mydsl.iml");
    TestCase.assertTrue(_endsWith_1);
    this.builder.setName("mydsl2");
    Project _project_1 = this.getProject();
    final Module rootModule = this.builder.commitModule(_project_1, null);
    String _name_2 = rootModule.getName();
    TestCase.assertEquals("mydsl2.parent", _name_2);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Wrong .iml path  ");
    String _moduleFilePath_2 = rootModule.getModuleFilePath();
    _builder.append(_moduleFilePath_2, "");
    Project _project_2 = this.getProject();
    String _basePath = _project_2.getBasePath();
    String _plus = (_basePath + "/mydsl2.parent/mydsl2.parent.iml");
    String _moduleFilePath_3 = rootModule.getModuleFilePath();
    TestCase.assertEquals(_builder.toString(), _plus, _moduleFilePath_3);
  }
  
  @Override
  protected void tearDown() throws Exception {
    Project _project = this.getProject();
    boolean _tripleNotEquals = (_project != null);
    if (_tripleNotEquals) {
      Project _project_1 = this.getProject();
      ModuleManager _instance = ModuleManager.getInstance(_project_1);
      Module[] _modules = _instance.getModules();
      CollectionExtensions.<Module>addAll(this.myModulesToDispose, _modules);
    }
    super.tearDown();
  }
}
