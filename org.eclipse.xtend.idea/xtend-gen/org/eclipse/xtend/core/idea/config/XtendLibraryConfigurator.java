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
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.OrderRootType;
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
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
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
    final Runnable _function = () -> {
      this.doEnsureXtendLibAvailable(rootModel, context);
    };
    this._projectLifecycleUtil.executeWhenProjectReady(rootModel.getProject(), _function);
  }
  
  protected void doEnsureXtendLibAvailable(final ModifiableRootModel rootModel, @Nullable final PsiFile context) {
    final Module module = rootModel.getModule();
    final GlobalSearchScope scope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module);
    final PsiClass psiClass = JavaPsiFacade.getInstance(rootModel.getProject()).findClass(Data.class.getName(), scope);
    if ((psiClass == null)) {
      final boolean testScope = this.isTestScope(context);
      if ((this._platformUtil.isMavenInstalled() && this._mavenUtility.isMavenizedModule(module))) {
        this._mavenUtility.addXtendLibMavenDependency(module, testScope);
      } else {
        if ((this._platformUtil.isGradleInstalled() && this._gradleBuildFileUtility.isGradleedModule(module))) {
          this._gradleBuildFileUtility.addXtendLibGradleDependency(module, testScope);
        } else {
          this.addJavaRuntimeLibrary(module, rootModel);
        }
      }
    }
  }
  
  public static MavenArtifact xtendLibMavenId() {
    if ((XtendLibraryConfigurator.XTEND_LIB_MAVEN_ID == null)) {
      final String version = XtextVersion.getCurrent().getVersion();
      XtendLibraryConfigurator.LOG.info(("The current Xtend plugin version is " + version));
      MavenArtifact _mavenArtifact = new MavenArtifact("org.eclipse.xtend", "org.eclipse.xtend.lib", version);
      XtendLibraryConfigurator.XTEND_LIB_MAVEN_ID = _mavenArtifact;
    }
    return XtendLibraryConfigurator.XTEND_LIB_MAVEN_ID;
  }
  
  public void addJavaRuntimeLibrary(final Module module, final ModifiableRootModel rootModel) {
    final Library library = this.createOrGetXtendJavaLibrary(rootModel, module);
    if (((library != null) && (rootModel.findLibraryOrderEntry(library) == null))) {
      boolean _isWritable = rootModel.isWritable();
      if (_isWritable) {
        rootModel.addLibraryEntry(library);
      }
    }
  }
  
  public Library createOrGetXtendJavaLibrary(final ModifiableRootModel rootModel, final Module module) {
    Library[] _libraries = LibraryTablesRegistrar.getInstance().getLibraryTable(module.getProject()).getLibraries();
    Library[] _libraries_1 = LibraryTablesRegistrar.getInstance().getLibraryTable().getLibraries();
    final Iterable<Library> libraryTable = Iterables.<Library>concat(((Iterable<? extends Library>)Conversions.doWrapArray(_libraries)), ((Iterable<? extends Library>)Conversions.doWrapArray(_libraries_1)));
    final Function1<Library, Boolean> _function = (Library it) -> {
      String _name = it.getName();
      boolean _startsWith = false;
      if (_name!=null) {
        _startsWith=_name.startsWith(XtendLibraryDescription.XTEND_LIBRARY_NAME);
      }
      return Boolean.valueOf(_startsWith);
    };
    final Iterable<Library> xtendLibs = IterableExtensions.<Library>filter(libraryTable, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(xtendLibs);
    boolean _not = (!_isEmpty);
    if (_not) {
      final Function1<Library, Boolean> _function_1 = (Library it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, XtendLibraryDescription.XTEND_LIBRARY_NAME));
      };
      boolean _exists = IterableExtensions.<Library>exists(xtendLibs, _function_1);
      if (_exists) {
        final Function1<Library, Boolean> _function_2 = (Library it) -> {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, XtendLibraryDescription.XTEND_LIBRARY_NAME));
        };
        return IterableExtensions.<Library>findFirst(xtendLibs, _function_2);
      } else {
        return IterableExtensions.<Library>head(xtendLibs);
      }
    } else {
      final NewLibraryConfiguration libDescr = this.xtendLibDescr.createLibraryDescription();
      final LibraryTable.ModifiableModel model = rootModel.getModuleLibraryTable().getModifiableModel();
      final Library createdLib = model.createLibrary(libDescr.getDefaultLibraryName());
      final Library.ModifiableModel libModel = createdLib.getModifiableModel();
      final BiConsumer<OrderRootType, List<String>> _function_3 = (OrderRootType type, List<String> roots) -> {
        final Consumer<String> _function_4 = (String it) -> {
          libModel.addRoot(it, type);
        };
        roots.forEach(_function_4);
      };
      this.xtendLibDescr.libraryRoots().forEach(_function_3);
      libModel.commit();
      model.commit();
      return createdLib;
    }
  }
  
  protected boolean isTestScope(@Nullable final PsiFile context) {
    if ((context == null)) {
      return false;
    }
    VirtualFile virtualFile = context.getOriginalFile().getVirtualFile();
    if ((virtualFile != null)) {
      return ProjectRootManager.getInstance(context.getProject()).getFileIndex().isInTestSourceContent(virtualFile);
    }
    return false;
  }
}
