/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.LibraryOrderEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.xml.XmlFile;
import com.intellij.util.xml.DomUtil;
import com.intellij.util.xml.GenericDomValue;
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtend.core.idea.config.GradleBuildFileUtility;
import org.eclipse.xtend.core.idea.framework.XtendLibraryDescription;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.util.ProjectLifecycleUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.jetbrains.idea.maven.dom.MavenDomUtil;
import org.jetbrains.idea.maven.dom.model.MavenDomDependency;
import org.jetbrains.idea.maven.dom.model.MavenDomProjectModel;
import org.jetbrains.idea.maven.model.MavenId;
import org.jetbrains.idea.maven.project.MavenProject;
import org.jetbrains.idea.maven.project.MavenProjectsManager;
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendLibraryConfigurator {
  protected final static Logger LOG = Logger.getInstance(XtendLibraryConfigurator.class.getName());
  
  @Inject
  @Extension
  private GradleBuildFileUtility gradleUtils;
  
  @Inject
  private XtendLibraryDescription xtendLibDescr;
  
  private static MavenId XTEND_LIB_MAVEN_ID;
  
  @Inject
  @Extension
  private ProjectLifecycleUtil _projectLifecycleUtil;
  
  public void ensureXtendLibAvailable(final ModifiableRootModel rootModel) {
    this.ensureXtendLibAvailable(rootModel, null);
  }
  
  public void ensureXtendLibAvailable(final ModifiableRootModel rootModel, final PsiFile context) {
    Project _project = rootModel.getProject();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        XtendLibraryConfigurator.this.doEnsureXtendLibAvailable(rootModel, context);
      }
    };
    this._projectLifecycleUtil.executeWhenProjectReady(_project, _function);
  }
  
  protected void doEnsureXtendLibAvailable(final ModifiableRootModel rootModel, final PsiFile context) {
    final Module module = rootModel.getModule();
    final GlobalSearchScope scope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module);
    Project _project = rootModel.getProject();
    JavaPsiFacade _instance = JavaPsiFacade.getInstance(_project);
    String _name = Data.class.getName();
    final PsiClass psiClass = _instance.findClass(_name, scope);
    boolean _equals = Objects.equal(psiClass, null);
    if (_equals) {
      boolean _isMavenizedModule = this.isMavenizedModule(module);
      if (_isMavenizedModule) {
        this.addMavenDependency(module, context);
      } else {
        boolean _isGradleedModule = this.gradleUtils.isGradleedModule(module);
        if (_isGradleedModule) {
          this.addGradleDependency(module, context);
        } else {
          this.addJavaRuntimeLibrary(module, rootModel);
        }
      }
    }
  }
  
  public void addGradleDependency(final Module module, final PsiFile context) {
    final GroovyFile buildFile = this.gradleUtils.locateBuildFile(module);
    if ((buildFile == null)) {
      String _name = module.getName();
      String _plus = ("Gradle build file not found in module " + _name);
      XtendLibraryConfigurator.LOG.error(_plus);
      return;
    }
    Project _project = module.getProject();
    List<PsiFile> _newImmutableList = CollectionLiterals.<PsiFile>newImmutableList(buildFile);
    new WriteCommandAction.Simple(_project, "Gradle: Add Xtend Runtime Library", ((PsiFile[])Conversions.unwrapArray(_newImmutableList, PsiFile.class))) {
      @Override
      protected void run() throws Throwable {
        String _xifexpression = null;
        boolean _isTestScope = false;
        if (context!=null) {
          _isTestScope=XtendLibraryConfigurator.this.isTestScope(context);
        }
        if (_isTestScope) {
          _xifexpression = "testCompile";
        } else {
          _xifexpression = "compile";
        }
        final String scope = _xifexpression;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(scope, "");
        _builder.append(" \'");
        MavenId _xtendLibMavenId = XtendLibraryConfigurator.xtendLibMavenId();
        String _key = _xtendLibMavenId.getKey();
        _builder.append(_key, "");
        _builder.append("\' ");
        XtendLibraryConfigurator.this.gradleUtils.addDependency(buildFile, _builder.toString());
      }
    }.execute();
  }
  
  public static MavenId xtendLibMavenId() {
    if ((XtendLibraryConfigurator.XTEND_LIB_MAVEN_ID == null)) {
      PluginId _id = PluginId.getId("org.eclipse.xtend.idea");
      final IdeaPluginDescriptor xtendPlugin = PluginManager.getPlugin(_id);
      String _version = null;
      if (xtendPlugin!=null) {
        _version=xtendPlugin.getVersion();
      }
      final String version = _version;
      XtendLibraryConfigurator.LOG.info(("The current Xtend plugin version is " + version));
      MavenId _mavenId = new MavenId("org.eclipse.xtend", "org.eclipse.xtend.lib", "2.8.4");
      XtendLibraryConfigurator.XTEND_LIB_MAVEN_ID = _mavenId;
    }
    return XtendLibraryConfigurator.XTEND_LIB_MAVEN_ID;
  }
  
  public void addJavaRuntimeLibrary(final Module module, final ModifiableRootModel rootModel) {
    final Library library = this.createOrGetXtendJavaLibrary(rootModel, module);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(library, null));
    if (!_notEquals) {
      _and = false;
    } else {
      LibraryOrderEntry _findLibraryOrderEntry = rootModel.findLibraryOrderEntry(library);
      boolean _tripleEquals = (_findLibraryOrderEntry == null);
      _and = _tripleEquals;
    }
    if (_and) {
      rootModel.addLibraryEntry(library);
    }
  }
  
  public void addMavenDependency(final Module module, final PsiFile context) {
    final Project project = module.getProject();
    final MavenProjectsManager mavenProjectsManager = MavenProjectsManager.getInstance(project);
    final MavenProject mavenProject = mavenProjectsManager.findProject(module);
    if ((mavenProject == null)) {
      return;
    }
    VirtualFile _file = mavenProject.getFile();
    final MavenDomProjectModel model = MavenDomUtil.getMavenDomProjectModel(project, _file);
    if ((model == null)) {
      return;
    }
    XmlFile _file_1 = DomUtil.getFile(model);
    List<PsiFile> _newImmutableList = CollectionLiterals.<PsiFile>newImmutableList(_file_1);
    new WriteCommandAction.Simple(project, "Add Xtend lib Maven Dependency", ((PsiFile[])Conversions.unwrapArray(_newImmutableList, PsiFile.class))) {
      @Override
      protected void run() throws Throwable {
        MavenId _xtendLibMavenId = XtendLibraryConfigurator.xtendLibMavenId();
        MavenDomDependency dependency = MavenDomUtil.createDomDependency(model, null, _xtendLibMavenId);
        boolean _isTestScope = false;
        if (context!=null) {
          _isTestScope=XtendLibraryConfigurator.this.isTestScope(context);
        }
        if (_isTestScope) {
          GenericDomValue<String> _scope = dependency.getScope();
          _scope.setStringValue("test");
        }
      }
    }.execute();
  }
  
  public Library createOrGetXtendJavaLibrary(final ModifiableRootModel rootModel, final Module module) {
    LibraryTablesRegistrar _instance = LibraryTablesRegistrar.getInstance();
    Project _project = module.getProject();
    LibraryTable _libraryTable = _instance.getLibraryTable(_project);
    Library[] _libraries = _libraryTable.getLibraries();
    LibraryTablesRegistrar _instance_1 = LibraryTablesRegistrar.getInstance();
    LibraryTable _libraryTable_1 = _instance_1.getLibraryTable();
    Library[] _libraries_1 = _libraryTable_1.getLibraries();
    final Iterable<Library> libraryTable = Iterables.<Library>concat(((Iterable<? extends Library>)Conversions.doWrapArray(_libraries)), ((Iterable<? extends Library>)Conversions.doWrapArray(_libraries_1)));
    final Function1<Library, Boolean> _function = new Function1<Library, Boolean>() {
      @Override
      public Boolean apply(final Library it) {
        String _name = it.getName();
        boolean _startsWith = false;
        if (_name!=null) {
          _startsWith=_name.startsWith(XtendLibraryDescription.XTEND_LIBRARY_NAME);
        }
        return Boolean.valueOf(_startsWith);
      }
    };
    final Iterable<Library> xtendLibs = IterableExtensions.<Library>filter(libraryTable, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(xtendLibs);
    boolean _not = (!_isEmpty);
    if (_not) {
      final Function1<Library, Boolean> _function_1 = new Function1<Library, Boolean>() {
        @Override
        public Boolean apply(final Library it) {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, XtendLibraryDescription.XTEND_LIBRARY_NAME));
        }
      };
      boolean _exists = IterableExtensions.<Library>exists(xtendLibs, _function_1);
      if (_exists) {
        final Function1<Library, Boolean> _function_2 = new Function1<Library, Boolean>() {
          @Override
          public Boolean apply(final Library it) {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, XtendLibraryDescription.XTEND_LIBRARY_NAME));
          }
        };
        return IterableExtensions.<Library>findFirst(xtendLibs, _function_2);
      } else {
        return IterableExtensions.<Library>head(xtendLibs);
      }
    } else {
      final NewLibraryConfiguration libDescr = this.xtendLibDescr.createLibraryDescription();
      LibraryTable _moduleLibraryTable = rootModel.getModuleLibraryTable();
      final LibraryTable.ModifiableModel model = _moduleLibraryTable.getModifiableModel();
      String _defaultLibraryName = libDescr.getDefaultLibraryName();
      final Library createdLib = model.createLibrary(_defaultLibraryName);
      final Library.ModifiableModel libModel = createdLib.getModifiableModel();
      HashMap<OrderRootType, List<String>> _libraryRoots = this.xtendLibDescr.libraryRoots();
      final Procedure2<OrderRootType, List<String>> _function_3 = new Procedure2<OrderRootType, List<String>>() {
        @Override
        public void apply(final OrderRootType type, final List<String> roots) {
          final Procedure1<String> _function = new Procedure1<String>() {
            @Override
            public void apply(final String it) {
              libModel.addRoot(it, type);
            }
          };
          IterableExtensions.<String>forEach(roots, _function);
        }
      };
      MapExtensions.<OrderRootType, List<String>>forEach(_libraryRoots, _function_3);
      libModel.commit();
      model.commit();
      return createdLib;
    }
  }
  
  protected boolean isTestScope(final PsiFile context) {
    PsiFile _originalFile = context.getOriginalFile();
    VirtualFile virtualFile = _originalFile.getVirtualFile();
    if ((virtualFile != null)) {
      Project _project = context.getProject();
      ProjectRootManager _instance = ProjectRootManager.getInstance(_project);
      ProjectFileIndex _fileIndex = _instance.getFileIndex();
      return _fileIndex.isInTestSourceContent(virtualFile);
    }
    return false;
  }
  
  public boolean isMavenizedModule(final Module module) {
    Project _project = module.getProject();
    MavenProjectsManager mavenProjectsManager = MavenProjectsManager.getInstance(_project);
    boolean _xifexpression = false;
    if ((mavenProjectsManager != null)) {
      _xifexpression = mavenProjectsManager.isMavenizedModule(module);
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
}
