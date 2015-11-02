package org.eclipse.xtext.idea.wizard;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.externalSystem.service.execution.ProgressExecutionMode;
import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemSettings;
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil;
import com.intellij.openapi.externalSystem.util.ExternalSystemUtil;
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
import java.util.Collections;
import java.util.List;
import javax.swing.Icon;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.XtextXtextIcons;
import org.eclipse.xtext.idea.lang.XtextLanguage;
import org.eclipse.xtext.idea.util.ProjectLifecycleUtil;
import org.eclipse.xtext.idea.wizard.IdeaProjectCreator;
import org.eclipse.xtext.idea.wizard.XtextWizardStep;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.wizard.ParentProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;
import org.jetbrains.idea.maven.project.MavenProjectsManager;
import org.jetbrains.plugins.gradle.settings.DistributionType;
import org.jetbrains.plugins.gradle.settings.GradleProjectSettings;
import org.jetbrains.plugins.gradle.util.GradleConstants;

@SuppressWarnings("all")
public class XtextModuleBuilder extends ModuleBuilder {
  private final static Logger LOG = Logger.getInstance(XtextWizardStep.class.getName());
  
  @Inject
  @Extension
  private ProjectLifecycleUtil _projectLifecycleUtil;
  
  @Inject
  private Provider<WizardConfiguration> wizardConfigProvider;
  
  @Inject
  private WizardConfiguration wizardConfiguration;
  
  @Inject
  private IdeaProjectCreator.Factory projectCreatorfactory;
  
  public XtextModuleBuilder() {
    XtextLanguage.INSTANCE.injectMembers(this);
    WizardConfiguration _get = this.wizardConfigProvider.get();
    this.wizardConfiguration = _get;
  }
  
  @Override
  public Icon getNodeIcon() {
    return XtextXtextIcons.GRAMMAR_FILE_TYPE;
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
  public Module commitModule(final Project project, final ModifiableModuleModel model) {
    final List<Module> modulesCreated = this.commit(project, model, null);
    ParentProjectDescriptor _parentProject = this.wizardConfiguration.getParentProject();
    boolean _isEnabled = _parentProject.isEnabled();
    if (_isEnabled) {
      final Function1<Module, Boolean> _function = new Function1<Module, Boolean>() {
        @Override
        public Boolean apply(final Module module) {
          String _name = module.getName();
          ParentProjectDescriptor _parentProject = XtextModuleBuilder.this.wizardConfiguration.getParentProject();
          String _name_1 = _parentProject.getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        }
      };
      return IterableExtensions.<Module>findFirst(modulesCreated, _function);
    }
    final Function1<Module, Boolean> _function_1 = new Function1<Module, Boolean>() {
      @Override
      public Boolean apply(final Module module) {
        String _name = XtextModuleBuilder.this.getName();
        String _name_1 = module.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      }
    };
    return IterableExtensions.<Module>findFirst(modulesCreated, _function_1);
  }
  
  @Override
  public List<Module> commit(final Project project, final ModifiableModuleModel model, final ModulesProvider modulesProvider) {
    ModifiableModuleModel _xifexpression = null;
    if ((model != null)) {
      _xifexpression = model;
    } else {
      ModuleManager _instance = ModuleManager.getInstance(project);
      _xifexpression = _instance.getModifiableModel();
    }
    final ModifiableModuleModel moduleModel = _xifexpression;
    this.setupWizardConfiguration(this.wizardConfiguration);
    VirtualFile _baseDir = project.getBaseDir();
    String _path = _baseDir.getPath();
    this.wizardConfiguration.setRootLocation(_path);
    String _name = this.getName();
    this.wizardConfiguration.setBaseName(_name);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        IdeaProjectCreator _create = XtextModuleBuilder.this.projectCreatorfactory.create(moduleModel);
        _create.createProjects(XtextModuleBuilder.this.wizardConfiguration);
        moduleModel.commit();
      }
    };
    _application.runWriteAction(_function);
    boolean _needsMavenBuild = this.wizardConfiguration.needsMavenBuild();
    if (_needsMavenBuild) {
      final Runnable _function_1 = new Runnable() {
        @Override
        public void run() {
          MavenProjectsManager manager = MavenProjectsManager.getInstance(project);
          if ((manager != null)) {
            ParentProjectDescriptor _parentProject = XtextModuleBuilder.this.wizardConfiguration.getParentProject();
            String _location = _parentProject.getLocation();
            String _plus = (_location + File.separator);
            final String pomFilePath = (_plus + "pom.xml");
            LocalFileSystem _instance = LocalFileSystem.getInstance();
            final VirtualFile virtualFile = _instance.refreshAndFindFileByPath(pomFilePath);
            if ((virtualFile != null)) {
              manager.addManagedFilesOrUnignore(Collections.<VirtualFile>unmodifiableList(CollectionLiterals.<VirtualFile>newArrayList(virtualFile)));
            } else {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Can\'t start maven import. File ");
              _builder.append(pomFilePath, "");
              _builder.append(" does not exists.");
              XtextModuleBuilder.LOG.error(_builder);
            }
          }
        }
      };
      this._projectLifecycleUtil.executeWhenProjectReady(project, _function_1);
    }
    boolean _needsGradleBuild = this.wizardConfiguration.needsGradleBuild();
    if (_needsGradleBuild) {
      final GradleProjectSettings gradleProjectSettings = new GradleProjectSettings();
      ParentProjectDescriptor _parentProject = this.wizardConfiguration.getParentProject();
      String _location = _parentProject.getLocation();
      gradleProjectSettings.setExternalProjectPath(_location);
      gradleProjectSettings.setDistributionType(DistributionType.DEFAULT_WRAPPED);
      final AbstractExternalSystemSettings settings = ExternalSystemApiUtil.getSettings(project, GradleConstants.SYSTEM_ID);
      settings.linkProject(gradleProjectSettings);
      ParentProjectDescriptor _parentProject_1 = this.wizardConfiguration.getParentProject();
      String _location_1 = _parentProject_1.getLocation();
      ExternalSystemUtil.refreshProject(project, GradleConstants.SYSTEM_ID, _location_1, false, ProgressExecutionMode.IN_BACKGROUND_ASYNC);
    }
    return (List<Module>)Conversions.doWrapArray(moduleModel.getModules());
  }
  
  public void setupWizardConfiguration(final WizardConfiguration wizardConfiguration) {
    wizardConfiguration.setNeedsGradleWrapper(false);
  }
  
  public WizardConfiguration getWizardConfiguration() {
    return this.wizardConfiguration;
  }
}
