package org.eclipse.xtext.idea.wizard;

import com.google.common.io.Resources;
import com.google.inject.Inject;
import com.intellij.ide.highlighter.ModuleFileType;
import com.intellij.openapi.module.ModifiableModuleModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.StdModuleTypes;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.idea.config.XtextProjectConfigurator;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.idea.lang.XtextLanguage;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.BinaryFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ParentProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectsCreator;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TextFile;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;

@SuppressWarnings("all")
public class IdeaProjectCreator implements ProjectsCreator {
  public static class Factory {
    public IdeaProjectCreator create(final ModifiableModuleModel model) {
      final IdeaProjectCreator pc = new IdeaProjectCreator(model);
      XtextLanguage.INSTANCE.injectMembers(pc);
      return pc;
    }
  }
  
  @Inject
  private XtextProjectConfigurator projectConfigrator;
  
  private ModifiableModuleModel model;
  
  public IdeaProjectCreator(final ModifiableModuleModel model) {
    this.model = model;
  }
  
  @Override
  public void createProjects(final WizardConfiguration config) {
    Set<ProjectDescriptor> _enabledProjects = config.getEnabledProjects();
    for (final ProjectDescriptor it : _enabledProjects) {
      this.createProject(it);
    }
  }
  
  public Module createProject(final ProjectDescriptor project) {
    try {
      String _location = project.getLocation();
      final VirtualFile projectRoot = VfsUtil.createDirectories(_location);
      final LocalFileSystem fileSystem = LocalFileSystem.getInstance();
      Iterable<? extends AbstractFile> _files = project.getFiles();
      for (final AbstractFile it : _files) {
        {
          WizardConfiguration _config = project.getConfig();
          SourceLayout _sourceLayout = _config.getSourceLayout();
          Outlet _outlet = it.getOutlet();
          String _pathFor = _sourceLayout.getPathFor(_outlet);
          String _plus = (_pathFor + "/");
          String _relativePath = it.getRelativePath();
          final String projectRelativePath = (_plus + _relativePath);
          String _path = projectRoot.getPath();
          File _file = new File(_path);
          final File ioFile = new File(_file, projectRelativePath);
          File _parentFile = ioFile.getParentFile();
          _parentFile.mkdirs();
          ioFile.createNewFile();
          boolean _isExecutable = it.isExecutable();
          if (_isExecutable) {
            ioFile.setExecutable(true);
          }
          final VirtualFile virtualFile = fileSystem.refreshAndFindFileByIoFile(ioFile);
          boolean _matched = false;
          if (!_matched) {
            if (it instanceof TextFile) {
              _matched=true;
              String _content = ((TextFile)it).getContent();
              VfsUtil.saveText(virtualFile, _content);
            }
          }
          if (!_matched) {
            if (it instanceof BinaryFile) {
              _matched=true;
              URL _content = ((BinaryFile)it).getContent();
              byte[] _byteArray = Resources.toByteArray(_content);
              virtualFile.setBinaryContent(_byteArray);
            }
          }
        }
      }
      String _moduleFilePath = this.moduleFilePath(project);
      String _id = StdModuleTypes.JAVA.getId();
      final Module module = this.model.newModule(_moduleFilePath, _id);
      ModuleRootManager _instance = ModuleRootManager.getInstance(module);
      final ModifiableRootModel rootModel = _instance.getModifiableModel();
      rootModel.inheritSdk();
      String _location_1 = project.getLocation();
      final VirtualFile modelContentRootDir = fileSystem.refreshAndFindFileByPath(_location_1);
      final ContentEntry contentEntry = rootModel.addContentEntry(modelContentRootDir);
      Outlet[] _generateOutlets = Outlet.generateOutlets();
      final Function1<Outlet, String> _function = new Function1<Outlet, String>() {
        @Override
        public String apply(final Outlet it) {
          return project.sourceFolder(it);
        }
      };
      final List<String> genFolders = ListExtensions.<Outlet, String>map(((List<Outlet>)Conversions.doWrapArray(_generateOutlets)), _function);
      Set<String> _sourceFolders = project.getSourceFolders();
      for (final String it_1 : _sourceFolders) {
        {
          final VirtualFile sourceRoot = VfsUtil.createDirectoryIfMissing(modelContentRootDir, it_1);
          JavaSourceRootType rootType = JavaSourceRootType.SOURCE;
          final boolean isGen = genFolders.contains(it_1);
          JpsJavaExtensionService _instance_1 = JpsJavaExtensionService.getInstance();
          final JavaSourceRootProperties properties = _instance_1.createSourceRootProperties("", isGen);
          contentEntry.<JavaSourceRootProperties>addSourceFolder(sourceRoot, rootType, properties);
        }
      }
      if ((!(project instanceof ParentProjectDescriptor))) {
        final AbstractFacetConfiguration conf = this.projectConfigrator.createOrGetFacetConf(module, "org.eclipse.xtend.core.Xtend");
        if ((conf != null)) {
          GeneratorConfigurationState _state = conf.getState();
          String _absoluteSourceFolder = this.absoluteSourceFolder(project, Outlet.MAIN_XTEND_GEN);
          _state.setOutputDirectory(_absoluteSourceFolder);
          GeneratorConfigurationState _state_1 = conf.getState();
          String _absoluteSourceFolder_1 = this.absoluteSourceFolder(project, Outlet.TEST_XTEND_GEN);
          _state_1.setTestOutputDirectory(_absoluteSourceFolder_1);
        }
      }
      rootModel.commit();
      return module;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String absoluteSourceFolder(final ProjectDescriptor project, final Outlet outlet) {
    String _location = project.getLocation();
    String _plus = (_location + "/");
    String _sourceFolder = project.sourceFolder(outlet);
    return (_plus + _sourceFolder);
  }
  
  public String moduleFilePath(final ProjectDescriptor project) {
    String _location = project.getLocation();
    String _plus = (_location + File.separator);
    String _name = project.getName();
    String _plus_1 = (_plus + _name);
    return (_plus_1 + ModuleFileType.DOT_DEFAULT_EXTENSION);
  }
}
