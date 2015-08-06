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
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.LibraryOrderEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtend.core.idea.config.XtendLibraryDescription;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendLibraryManager {
  @Inject
  private XtendLibraryDescription xtendLibDescr;
  
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
        return Boolean.valueOf(_name.startsWith(XtendLibraryDescription.XTEND_LIBRARY_NAME));
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
  
  public LibraryOrderEntry ensureXtendLibAvailable(final ModifiableRootModel rootModel, final Module module) {
    LibraryOrderEntry _xblockexpression = null;
    {
      Project _project = module.getProject();
      JavaPsiFacade _instance = JavaPsiFacade.getInstance(_project);
      String _name = Data.class.getName();
      GlobalSearchScope _moduleWithDependenciesAndLibrariesScope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module);
      final PsiClass psiClass = _instance.findClass(_name, _moduleWithDependenciesAndLibrariesScope);
      LibraryOrderEntry _xifexpression = null;
      boolean _equals = Objects.equal(psiClass, null);
      if (_equals) {
        LibraryOrderEntry _xblockexpression_1 = null;
        {
          final Library library = this.createOrGetXtendJavaLibrary(rootModel, module);
          LibraryOrderEntry _xifexpression_1 = null;
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(library, null));
          if (!_notEquals) {
            _and = false;
          } else {
            LibraryTable _moduleLibraryTable = rootModel.getModuleLibraryTable();
            Library[] _libraries = _moduleLibraryTable.getLibraries();
            boolean _contains = ((List<Library>)Conversions.doWrapArray(_libraries)).contains(library);
            boolean _not = (!_contains);
            _and = _not;
          }
          if (_and) {
            _xifexpression_1 = rootModel.addLibraryEntry(library);
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
