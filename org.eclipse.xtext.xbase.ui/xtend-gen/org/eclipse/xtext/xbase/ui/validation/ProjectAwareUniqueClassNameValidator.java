/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
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
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
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
  private static final String OUTPUT_CONFIGS = "ProjectAwareUniqueClassNameValidator.outputConfigs";
  
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
        boolean _isDerived = this.isDerived(sourceFolder.getResource());
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
                    this.addIssue(type, unit.getElementName());
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
    final IJavaProject javaProject = this.javaProjectProvider.getJavaProject(type.eResource().getResourceSet());
    this.getContext().put(ProjectAwareUniqueClassNameValidator.OUTPUT_CONFIGS, this.outputConfigurationProvider.getOutputConfigurations(type.eResource()));
    final String packageName = type.getPackageName();
    final String typeName = type.getSimpleName();
    final Function1<IPackageFragmentRoot, Boolean> _function = (IPackageFragmentRoot it) -> {
      try {
        int _kind = it.getKind();
        return Boolean.valueOf((_kind == IPackageFragmentRoot.K_SOURCE));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final Iterable<IPackageFragmentRoot> sourceFolders = IterableExtensions.<IPackageFragmentRoot>filter(((Iterable<IPackageFragmentRoot>)Conversions.doWrapArray(javaProject.getPackageFragmentRoots())), _function);
    IndexManager indexManager = JavaModelManager.getIndexManager();
    if (((((Object[])Conversions.unwrapArray(sourceFolders, Object.class)).length == 0) || (indexManager.awaitingJobsCount() > 0))) {
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
    if ((copies != null)) {
      for (final ICompilationUnit workingCopy : copies) {
        {
          final IPath path = workingCopy.getPath();
          if ((javaProject.getPath().isPrefixOf(path) && (!this.isDerived(workingCopy.getResource())))) {
            boolean _exists = workingCopy.getPackageDeclaration(packageName).exists();
            if (_exists) {
              IType result = workingCopy.getType(typeName);
              boolean _exists_1 = result.exists();
              if (_exists_1) {
                this.addIssue(type, workingCopy.getElementName());
                return false;
              }
            }
            workingCopyPaths.add(workingCopy.getPath().toString());
          }
        }
      }
    }
    char[] _xifexpression = null;
    if ((packageName == null)) {
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
        IWorkspaceRoot _root = ResourcesPlugin.getWorkspace().getRoot();
        Path _path = new Path(documentPath);
        IFile file = _root.getFile(_path);
        boolean _isDerived = ProjectAwareUniqueClassNameValidator.this.isDerived(file);
        boolean _not = (!_isDerived);
        if (_not) {
          ProjectAwareUniqueClassNameValidator.this.addIssue(type, file.getName());
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
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private ICompilationUnit[] getWorkingCopies(final JvmDeclaredType type) {
    boolean _isBuilder = ResourceSetContext.get(type).isBuilder();
    if (_isBuilder) {
      return new ICompilationUnit[] {};
    }
    return JavaModelManager.getJavaModelManager().getWorkingCopies(DefaultWorkingCopyOwner.PRIMARY, false);
  }
  
  protected boolean isDerived(final IResource resource) {
    try {
      if (((this.derivedResourceMarkers != null) && (this.derivedResourceMarkers.findDerivedResourceMarkers(resource).length >= 1))) {
        return true;
      }
      Object _get = this.getContext().get(ProjectAwareUniqueClassNameValidator.OUTPUT_CONFIGS);
      final Collection<OutputConfiguration> outputConfigurations = ((Collection<OutputConfiguration>) _get);
      if ((outputConfigurations != null)) {
        final IPath projectRelativePath = resource.getProjectRelativePath();
        for (final OutputConfiguration outputConfiguration : outputConfigurations) {
          Set<String> _outputDirectories = outputConfiguration.getOutputDirectories();
          for (final String dir : _outputDirectories) {
            {
              final Function1<OutputConfiguration.SourceMapping, Boolean> _function = (OutputConfiguration.SourceMapping it) -> {
                return Boolean.valueOf(it.getSourceFolder().endsWith(dir));
              };
              final Iterable<OutputConfiguration.SourceMapping> sourceMappingsThatMatchTheCurrentOutputDirectory = IterableExtensions.<OutputConfiguration.SourceMapping>filter(outputConfiguration.getSourceMappings(), _function);
              for (final OutputConfiguration.SourceMapping sourceMapping : sourceMappingsThatMatchTheCurrentOutputDirectory) {
                {
                  final String sourceFolder = sourceMapping.getSourceFolder();
                  boolean _isPrefixOf = new Path(sourceFolder).isPrefixOf(projectRelativePath);
                  if (_isPrefixOf) {
                    return true;
                  }
                }
              }
              boolean _isPrefixOf = new Path(dir).isPrefixOf(projectRelativePath);
              if (_isPrefixOf) {
                return true;
              }
            }
          }
        }
      }
      return false;
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
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
      final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
        final URI candidate = it.getEObjectURI();
        return Boolean.valueOf((candidate.isPlatformResource() && Objects.equal(candidate.segment(1), project)));
      };
      return super.checkUniqueInIndex(type, IterableExtensions.<IEObjectDescription>filter(descriptions, _function));
    }
    return true;
  }
}
