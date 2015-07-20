/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageDeclaration;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.search.BasicSearchEngine;
import org.eclipse.jdt.internal.core.search.IndexQueryRequestor;
import org.eclipse.jdt.internal.core.search.PatternSearchJob;
import org.eclipse.jdt.internal.core.search.indexing.IIndexConstants;
import org.eclipse.jdt.internal.core.search.indexing.IndexManager;
import org.eclipse.jdt.internal.core.search.matching.TypeDeclarationPattern;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ResourceSetContext;
import org.eclipse.xtext.ui.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.validation.UniqueClassNameValidator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ProjectAwareUniqueClassNameValidator extends UniqueClassNameValidator {
  private enum SourceTraversal {
    INTERRUPT,
    
    DUPLICATE,
    
    UNIQUE;
  }
  
  /**
   * Context key for output configurations.
   */
  private final static String OUTPUT_CONFIGS = "ProjectAwareUniqueClassNameValidator.outputConfigs";
  
  @Inject
  private IJavaProjectProvider javaProjectProvider;
  
  @Inject
  private IDerivedResourceMarkers derivedResourceMarkers;
  
  @Inject
  private IContextualOutputConfigurationProvider outputConfigurationProvider;
  
  @Override
  public boolean doCheckUniqueName(final QualifiedName name, final JvmDeclaredType type) {
    boolean _doCheckUniqueName = super.doCheckUniqueName(name, type);
    if (_doCheckUniqueName) {
      try {
        return this.doCheckUniqueInProject(name, type);
      } catch (final Throwable _t) {
        if (_t instanceof JavaModelException) {
          final JavaModelException e = (JavaModelException)_t;
          return true;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } else {
      return false;
    }
  }
  
  private ProjectAwareUniqueClassNameValidator.SourceTraversal doCheckUniqueInProjectSource(final String packageName, final String typeName, final JvmDeclaredType type, final IPackageFragmentRoot[] sourceFolders) throws JavaModelException {
    final IndexManager indexManager = JavaModelManager.getIndexManager();
    for (final IPackageFragmentRoot sourceFolder : sourceFolders) {
      int _awaitingJobsCount = indexManager.awaitingJobsCount();
      boolean _greaterThan = (_awaitingJobsCount > 0);
      if (_greaterThan) {
        IResource _resource = sourceFolder.getResource();
        boolean _isDerived = this.isDerived(_resource);
        boolean _not = (!_isDerived);
        if (_not) {
          IPackageFragment packageFragment = sourceFolder.getPackageFragment(packageName);
          boolean _exists = packageFragment.exists();
          if (_exists) {
            ICompilationUnit[] units = packageFragment.getCompilationUnits();
            for (final ICompilationUnit unit : units) {
              {
                final IResource resource = unit.getResource();
                boolean _isDerived_1 = this.isDerived(resource);
                boolean _not_1 = (!_isDerived_1);
                if (_not_1) {
                  IType javaType = unit.getType(typeName);
                  boolean _exists_1 = javaType.exists();
                  if (_exists_1) {
                    String _elementName = unit.getElementName();
                    this.addIssue(type, _elementName);
                    return ProjectAwareUniqueClassNameValidator.SourceTraversal.DUPLICATE;
                  }
                }
              }
            }
          }
        }
      } else {
        return ProjectAwareUniqueClassNameValidator.SourceTraversal.INTERRUPT;
      }
    }
    return ProjectAwareUniqueClassNameValidator.SourceTraversal.UNIQUE;
  }
  
  public boolean doCheckUniqueInProject(final QualifiedName name, final JvmDeclaredType type) throws JavaModelException {
    Resource _eResource = type.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final IJavaProject javaProject = this.javaProjectProvider.getJavaProject(_resourceSet);
    Map<Object, Object> _context = this.getContext();
    Resource _eResource_1 = type.eResource();
    Set<OutputConfiguration> _outputConfigurations = this.outputConfigurationProvider.getOutputConfigurations(_eResource_1);
    _context.put(ProjectAwareUniqueClassNameValidator.OUTPUT_CONFIGS, _outputConfigurations);
    final String packageName = type.getPackageName();
    final String typeName = type.getSimpleName();
    IPackageFragmentRoot[] _packageFragmentRoots = javaProject.getPackageFragmentRoots();
    final Function1<IPackageFragmentRoot, Boolean> _function = new Function1<IPackageFragmentRoot, Boolean>() {
      @Override
      public Boolean apply(final IPackageFragmentRoot it) {
        try {
          int _kind = it.getKind();
          return Boolean.valueOf((_kind == IPackageFragmentRoot.K_SOURCE));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final Iterable<IPackageFragmentRoot> sourceFolders = IterableExtensions.<IPackageFragmentRoot>filter(((Iterable<IPackageFragmentRoot>)Conversions.doWrapArray(_packageFragmentRoots)), _function);
    IndexManager indexManager = JavaModelManager.getIndexManager();
    boolean _or = false;
    int _length = ((Object[])Conversions.unwrapArray(sourceFolders, Object.class)).length;
    boolean _equals = (_length == 0);
    if (_equals) {
      _or = true;
    } else {
      int _awaitingJobsCount = indexManager.awaitingJobsCount();
      boolean _greaterThan = (_awaitingJobsCount > 0);
      _or = _greaterThan;
    }
    if (_or) {
      String _elvis = null;
      if (packageName != null) {
        _elvis = packageName;
      } else {
        _elvis = "";
      }
      ProjectAwareUniqueClassNameValidator.SourceTraversal _doCheckUniqueInProjectSource = this.doCheckUniqueInProjectSource(_elvis, typeName, type, ((IPackageFragmentRoot[])Conversions.unwrapArray(sourceFolders, IPackageFragmentRoot.class)));
      if (_doCheckUniqueInProjectSource != null) {
        switch (_doCheckUniqueInProjectSource) {
          case DUPLICATE:
            return false;
          case UNIQUE:
            return true;
          default:
            break;
        }
      } else {
      }
    }
    final HashSet<String> workingCopyPaths = CollectionLiterals.<String>newHashSet();
    ICompilationUnit[] copies = this.getWorkingCopies(type);
    boolean _notEquals = (!Objects.equal(copies, null));
    if (_notEquals) {
      for (final ICompilationUnit workingCopy : copies) {
        {
          final IPath path = workingCopy.getPath();
          boolean _and = false;
          IPath _path = javaProject.getPath();
          boolean _isPrefixOf = _path.isPrefixOf(path);
          if (!_isPrefixOf) {
            _and = false;
          } else {
            IResource _resource = workingCopy.getResource();
            boolean _isDerived = this.isDerived(_resource);
            boolean _not = (!_isDerived);
            _and = _not;
          }
          if (_and) {
            IPackageDeclaration _packageDeclaration = workingCopy.getPackageDeclaration(packageName);
            boolean _exists = _packageDeclaration.exists();
            if (_exists) {
              IType result = workingCopy.getType(typeName);
              boolean _exists_1 = result.exists();
              if (_exists_1) {
                String _elementName = workingCopy.getElementName();
                this.addIssue(type, _elementName);
                return false;
              }
            }
            IPath _path_1 = workingCopy.getPath();
            String _string = _path_1.toString();
            workingCopyPaths.add(_string);
          }
        }
      }
    }
    char[] _xifexpression = null;
    boolean _equals_1 = Objects.equal(packageName, null);
    if (_equals_1) {
      _xifexpression = CharOperation.NO_CHAR;
    } else {
      _xifexpression = packageName.toCharArray();
    }
    char[] _charArray = typeName.toCharArray();
    final TypeDeclarationPattern pattern = new TypeDeclarationPattern(_xifexpression, CharOperation.NO_CHAR_CHAR, _charArray, IIndexConstants.TYPE_SUFFIX, 
      (SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE));
    final IndexQueryRequestor _function_1 = new IndexQueryRequestor() {
      @Override
      public boolean acceptIndexMatch(final String documentPath, final SearchPattern indexRecord, final SearchParticipant participant, final AccessRuleSet access) {
        boolean _contains = workingCopyPaths.contains(documentPath);
        if (_contains) {
          return true;
        }
        IWorkspace _workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot _root = _workspace.getRoot();
        Path _path = new Path(documentPath);
        IFile file = _root.getFile(_path);
        boolean _isDerived = ProjectAwareUniqueClassNameValidator.this.isDerived(file);
        boolean _not = (!_isDerived);
        if (_not) {
          String _name = file.getName();
          ProjectAwareUniqueClassNameValidator.this.addIssue(type, _name);
          return false;
        }
        return true;
      }
    };
    IndexQueryRequestor searchRequestor = _function_1;
    try {
      SearchParticipant _defaultSearchParticipant = BasicSearchEngine.getDefaultSearchParticipant();
      IJavaSearchScope _createJavaSearchScope = BasicSearchEngine.createJavaSearchScope(((IJavaElement[])Conversions.unwrapArray(sourceFolders, IJavaElement.class)));
      PatternSearchJob _patternSearchJob = new PatternSearchJob(pattern, _defaultSearchParticipant, _createJavaSearchScope, searchRequestor);
      indexManager.performConcurrentJob(_patternSearchJob, 
        IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, null);
      return true;
    } catch (final Throwable _t) {
      if (_t instanceof OperationCanceledException) {
        final OperationCanceledException oce = (OperationCanceledException)_t;
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private ICompilationUnit[] getWorkingCopies(final JvmDeclaredType type) {
    ResourceSetContext _get = ResourceSetContext.get(type);
    boolean _isBuilder = _get.isBuilder();
    if (_isBuilder) {
      return new ICompilationUnit[] {};
    }
    JavaModelManager _javaModelManager = JavaModelManager.getJavaModelManager();
    return _javaModelManager.getWorkingCopies(DefaultWorkingCopyOwner.PRIMARY, false);
  }
  
  protected boolean isDerived(final IResource resource) {
    try {
      IMarker[] _findDerivedResourceMarkers = this.derivedResourceMarkers.findDerivedResourceMarkers(resource);
      int _length = _findDerivedResourceMarkers.length;
      boolean _greaterEqualsThan = (_length >= 1);
      if (_greaterEqualsThan) {
        return true;
      }
      Map<Object, Object> _context = this.getContext();
      Object _get = _context.get(ProjectAwareUniqueClassNameValidator.OUTPUT_CONFIGS);
      final Collection<OutputConfiguration> outputConfigurations = ((Collection<OutputConfiguration>) _get);
      boolean _notEquals = (!Objects.equal(outputConfigurations, null));
      if (_notEquals) {
        final IPath projectRelativePath = resource.getProjectRelativePath();
        for (final OutputConfiguration outputConfiguration : outputConfigurations) {
          Set<String> _outputDirectories = outputConfiguration.getOutputDirectories();
          for (final String dir : _outputDirectories) {
            Path _path = new Path(dir);
            boolean _isPrefixOf = _path.isPrefixOf(projectRelativePath);
            if (_isPrefixOf) {
              return true;
            }
          }
        }
      }
      return false;
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  protected boolean checkUniqueInIndex(final JvmDeclaredType type, final Iterable<IEObjectDescription> descriptions) {
    final URI objectURI = EcoreUtil.getURI(type);
    boolean _isPlatformResource = objectURI.isPlatformResource();
    if (_isPlatformResource) {
      final String project = objectURI.segment(1);
      final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
        @Override
        public Boolean apply(final IEObjectDescription it) {
          final URI candidate = it.getEObjectURI();
          boolean _and = false;
          boolean _isPlatformResource = candidate.isPlatformResource();
          if (!_isPlatformResource) {
            _and = false;
          } else {
            String _segment = candidate.segment(1);
            boolean _equals = Objects.equal(_segment, project);
            _and = _equals;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(descriptions, _function);
      return super.checkUniqueInIndex(type, _filter);
    }
    return true;
  }
}
