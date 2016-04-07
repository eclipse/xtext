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
import com.intellij.openapi.diagnostic.Logger;
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
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtend.core.idea.config.GradleBuildFileUtility;
import org.eclipse.xtend.core.idea.config.MavenArtifact;
import org.eclipse.xtend.core.idea.config.MavenUtility;
import org.eclipse.xtend.core.idea.framework.XtendLibraryDescription;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.idea.util.PlatformUtil;
import org.eclipse.xtext.idea.util.ProjectLifecycleUtil;
import org.eclipse.xtext.util.XtextVersion;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.jetbrains.annotations.Nullable;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendLibraryConfigurator {
  private final static Logger LOG = Logger.getInstance(XtendLibraryConfigurator.class.getName());
  
  private static MavenArtifact XTEND_LIB_MAVEN_ID;
  
  @Inject
  @Extension
  private GradleBuildFileUtility _gradleBuildFileUtility;
  
  @Inject
  @Extension
  private ProjectLifecycleUtil _projectLifecycleUtil;
  
  @Inject
  @Extension
  private PlatformUtil _platformUtil;
  
  @Inject
  @Extension
  private MavenUtility _mavenUtility;
  
  @Inject
  private XtendLibraryDescription xtendLibDescr;
  
  public void ensureXtendLibAvailable(final ModifiableRootModel rootModel) {
    this.ensureXtendLibAvailable(rootModel, null);
  }
  
  public void ensureXtendLibAvailable(final ModifiableRootModel rootModel, @Nullable final PsiFile context) {
    Project _project = rootModel.getProject();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        XtendLibraryConfigurator.this.doEnsureXtendLibAvailable(rootModel, context);
      }
    };
    this._projectLifecycleUtil.executeWhenProjectReady(_project, _function);
  }
  
  protected void doEnsureXtendLibAvailable(final ModifiableRootModel rootModel, @Nullable final PsiFile context) {
    final Module module = rootModel.getModule();
    final GlobalSearchScope scope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module);
    Project _project = rootModel.getProject();
    JavaPsiFacade _instance = JavaPsiFacade.getInstance(_project);
    String _name = Data.class.getName();
    final PsiClass psiClass = _instance.findClass(_name, scope);
    boolean _equals = Objects.equal(psiClass, null);
    if (_equals) {
      final boolean testScope = this.isTestScope(context);
      boolean _and = false;
      boolean _isMavenInstalled = this._platformUtil.isMavenInstalled();
      if (!_isMavenInstalled) {
        _and = false;
      } else {
        boolean _isMavenizedModule = this._mavenUtility.isMavenizedModule(module);
        _and = _isMavenizedModule;
      }
      if (_and) {
        this._mavenUtility.addXtendLibMavenDependency(module, testScope);
      } else {
        boolean _and_1 = false;
        boolean _isGradleInstalled = this._platformUtil.isGradleInstalled();
        if (!_isGradleInstalled) {
          _and_1 = false;
        } else {
          boolean _isGradleedModule = this._gradleBuildFileUtility.isGradleedModule(module);
          _and_1 = _isGradleedModule;
        }
        if (_and_1) {
          this._gradleBuildFileUtility.addXtendLibGradleDependency(module, testScope);
        } else {
          this.addJavaRuntimeLibrary(module, rootModel);
        }
      }
    }
  }
  
  public static MavenArtifact xtendLibMavenId() {
    if ((XtendLibraryConfigurator.XTEND_LIB_MAVEN_ID == null)) {
      XtextVersion _current = XtextVersion.getCurrent();
      final String version = _current.getVersion();
      XtendLibraryConfigurator.LOG.info(("The current Xtend plugin version is " + version));
      MavenArtifact _mavenArtifact = new MavenArtifact("org.eclipse.xtend", "org.eclipse.xtend.lib", version);
      XtendLibraryConfigurator.XTEND_LIB_MAVEN_ID = _mavenArtifact;
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
      boolean _isWritable = rootModel.isWritable();
      if (_isWritable) {
        rootModel.addLibraryEntry(library);
      }
    }
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
          for (final String it : roots) {
            libModel.addRoot(it, type);
          }
        }
      };
      MapExtensions.<OrderRootType, List<String>>forEach(_libraryRoots, _function_3);
      libModel.commit();
      model.commit();
      return createdLib;
    }
  }
  
  protected boolean isTestScope(@Nullable final PsiFile context) {
    if ((context == null)) {
      return false;
    }
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
}
