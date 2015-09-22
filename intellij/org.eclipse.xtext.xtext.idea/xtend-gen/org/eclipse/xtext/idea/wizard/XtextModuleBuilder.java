package org.eclipse.xtext.idea.wizard;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.JavaModuleType;
import com.intellij.openapi.module.ModifiableModuleModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.StdModuleTypes;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.projectRoots.SdkTypeId;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.File;
import java.util.List;
import javax.swing.Icon;
import org.eclipse.xtext.idea.Icons;
import org.eclipse.xtext.idea.wizard.IdeaProjectCreator;
import org.eclipse.xtext.idea.wizard.XtextWizardStep;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@SuppressWarnings("all")
public class XtextModuleBuilder extends ModuleBuilder {
  private WizardConfiguration wizardConfiguration = new WizardConfiguration();
  
  @Override
  public Icon getNodeIcon() {
    return Icons.DSL_FILE_TYPE;
  }
  
  @Override
  public String getDescription() {
    return "Xtext Language Project";
  }
  
  @Override
  public String getPresentableName() {
    return "Xtext";
  }
  
  @Override
  public String getGroupName() {
    return "Xtext";
  }
  
  @Override
  public String getBuilderId() {
    return "xtextModuleBuilder";
  }
  
  @Override
  public String getParentGroup() {
    return JavaModuleType.JAVA_GROUP;
  }
  
  @Override
  public void setupRootModel(final ModifiableRootModel rootModel) throws ConfigurationException {
    String _contentEntryPath = this.getContentEntryPath();
    String path = FileUtil.toSystemIndependentName(_contentEntryPath);
    File _file = new File(path);
    _file.mkdirs();
    LocalFileSystem _instance = LocalFileSystem.getInstance();
    final VirtualFile root = _instance.refreshAndFindFileByPath(path);
    rootModel.addContentEntry(root);
    if ((this.myJdk != null)) {
      rootModel.setSdk(this.myJdk);
    } else {
      rootModel.inheritSdk();
    }
  }
  
  @Override
  public List<Module> commit(final Project project, final ModifiableModuleModel model, final ModulesProvider modulesProvider) {
    final List<Module> rootModule = super.commit(project, model, modulesProvider);
    ModifiableModuleModel _xifexpression = null;
    if ((model != null)) {
      _xifexpression = model;
    } else {
      ModuleManager _instance = ModuleManager.getInstance(project);
      _xifexpression = _instance.getModifiableModel();
    }
    final ModifiableModuleModel moduleModel = _xifexpression;
    String _basePath = project.getBasePath();
    this.wizardConfiguration.setRootLocation(_basePath);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        IdeaProjectCreator _ideaProjectCreator = new IdeaProjectCreator(moduleModel);
        _ideaProjectCreator.createProjects(XtextModuleBuilder.this.wizardConfiguration);
        moduleModel.commit();
      }
    };
    _application.runWriteAction(_function);
    return rootModule;
  }
  
  @Override
  public int getWeight() {
    return 53;
  }
  
  @Override
  public ModuleType<?> getModuleType() {
    return StdModuleTypes.JAVA;
  }
  
  @Override
  public boolean isSuitableSdkType(final SdkTypeId sdk) {
    JavaSdk _instance = JavaSdk.getInstance();
    return (sdk == _instance);
  }
  
  @Override
  public ModuleWizardStep getCustomOptionsStep(final WizardContext context, final Disposable parentDisposable) {
    return new XtextWizardStep(context);
  }
  
  public WizardConfiguration getWizardConfiguration() {
    return this.wizardConfiguration;
  }
}
