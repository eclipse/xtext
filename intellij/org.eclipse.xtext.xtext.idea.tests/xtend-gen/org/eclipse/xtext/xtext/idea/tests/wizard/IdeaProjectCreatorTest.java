package org.eclipse.xtext.xtext.idea.tests.wizard;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.testFramework.PsiTestCase;
import java.io.IOException;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.xtext.idea.wizard.XtextModuleBuilder;
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
    Project _project = this.getProject();
    final List<Module> modules = this.builder.commit(_project);
    int _size = modules.size();
    TestCase.assertEquals(1, _size);
    Module _get = modules.get(0);
    String _name = _get.getName();
    TestCase.assertEquals("mydsl.core", _name);
    Module _get_1 = modules.get(0);
    String _moduleFilePath = _get_1.getModuleFilePath();
    boolean _endsWith = _moduleFilePath.endsWith("/mydsl.core/mydsl.core.iml");
    TestCase.assertTrue(_endsWith);
  }
  
  @Test
  public void testCreateGradleProject() {
    WizardConfiguration _wizardConfiguration = this.builder.getWizardConfiguration();
    _wizardConfiguration.setPreferredBuildSystem(BuildSystem.GRADLE);
    Project _project = this.getProject();
    final List<Module> modules = this.builder.commit(_project);
    int _size = modules.size();
    TestCase.assertEquals(2, _size);
    Module _get = modules.get(0);
    String _name = _get.getName();
    TestCase.assertEquals("mydsl", _name);
    Module _get_1 = modules.get(0);
    String _moduleFilePath = _get_1.getModuleFilePath();
    boolean _endsWith = _moduleFilePath.endsWith("/mydsl/mydsl.iml");
    TestCase.assertTrue(_endsWith);
    Module _get_2 = modules.get(1);
    String _name_1 = _get_2.getName();
    TestCase.assertEquals("mydsl.core", _name_1);
    Module _get_3 = modules.get(1);
    String _moduleFilePath_1 = _get_3.getModuleFilePath();
    boolean _endsWith_1 = _moduleFilePath_1.endsWith("/mydsl.core/mydsl.core.iml");
    TestCase.assertTrue(_endsWith_1);
  }
  
  @Test
  public void testCreateGradleHirachicalProject() {
    WizardConfiguration _wizardConfiguration = this.builder.getWizardConfiguration();
    _wizardConfiguration.setPreferredBuildSystem(BuildSystem.GRADLE);
    WizardConfiguration _wizardConfiguration_1 = this.builder.getWizardConfiguration();
    _wizardConfiguration_1.setProjectLayout(ProjectLayout.HIERARCHICAL);
    Project _project = this.getProject();
    final List<Module> modules = this.builder.commit(_project);
    int _size = modules.size();
    TestCase.assertEquals(2, _size);
    Module _get = modules.get(0);
    String _name = _get.getName();
    TestCase.assertEquals("mydsl", _name);
    Module _get_1 = modules.get(0);
    String _moduleFilePath = _get_1.getModuleFilePath();
    boolean _endsWith = _moduleFilePath.endsWith("/mydsl/mydsl.iml");
    TestCase.assertTrue(_endsWith);
    Module _get_2 = modules.get(1);
    String _name_1 = _get_2.getName();
    TestCase.assertEquals("mydsl.core", _name_1);
    Module _get_3 = modules.get(1);
    String _moduleFilePath_1 = _get_3.getModuleFilePath();
    boolean _endsWith_1 = _moduleFilePath_1.endsWith("/mydsl/mydsl.core/mydsl.core.iml");
    TestCase.assertTrue(_endsWith_1);
    Project _project_1 = this.getProject();
    ModuleManager _instance = ModuleManager.getInstance(_project_1);
    final Module[] allModules = _instance.getModules();
    int _size_1 = ((List<Module>)Conversions.doWrapArray(allModules)).size();
    TestCase.assertEquals(3, _size_1);
  }
  
  @Test
  public void testCreateTwoLanguagesProject() {
    Project _project = this.getProject();
    ModuleManager _instance = ModuleManager.getInstance(_project);
    final Module[] allModules = _instance.getModules();
    int _size = ((List<Module>)Conversions.doWrapArray(allModules)).size();
    TestCase.assertEquals(0, _size);
    WizardConfiguration _wizardConfiguration = this.builder.getWizardConfiguration();
    _wizardConfiguration.setPreferredBuildSystem(BuildSystem.GRADLE);
    WizardConfiguration _wizardConfiguration_1 = this.builder.getWizardConfiguration();
    _wizardConfiguration_1.setProjectLayout(ProjectLayout.HIERARCHICAL);
    this.builder.setName("mydsl");
    Project _project_1 = this.getProject();
    final List<Module> modules = this.builder.commit(_project_1);
    int _size_1 = modules.size();
    TestCase.assertEquals(2, _size_1);
    Module _get = modules.get(0);
    String _name = _get.getName();
    TestCase.assertEquals("mydsl", _name);
    Module _get_1 = modules.get(0);
    String _moduleFilePath = _get_1.getModuleFilePath();
    boolean _endsWith = _moduleFilePath.endsWith("/mydsl/mydsl.iml");
    TestCase.assertTrue(_endsWith);
    Module _get_2 = modules.get(1);
    String _name_1 = _get_2.getName();
    TestCase.assertEquals("mydsl.core", _name_1);
    Module _get_3 = modules.get(1);
    String _moduleFilePath_1 = _get_3.getModuleFilePath();
    boolean _endsWith_1 = _moduleFilePath_1.endsWith("/mydsl/mydsl.core/mydsl.core.iml");
    TestCase.assertTrue(_endsWith_1);
    this.builder.setName("mydsl2");
    Project _project_2 = this.getProject();
    final Module rootModule = this.builder.commitModule(_project_2, null);
    String _name_2 = rootModule.getName();
    TestCase.assertEquals("mydsl2", _name_2);
    String _moduleFilePath_2 = rootModule.getModuleFilePath();
    boolean _endsWith_2 = _moduleFilePath_2.endsWith("/mydsl2/mydsl2.iml");
    TestCase.assertTrue(_endsWith_2);
    String _moduleFilePath_3 = rootModule.getModuleFilePath();
    boolean _endsWith_3 = _moduleFilePath_3.endsWith("/mydsl/mydsl2/mydsl2.iml");
    TestCase.assertFalse(_endsWith_3);
  }
}
