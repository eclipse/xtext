/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.ui.notification;

import com.google.common.base.Objects;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.internal.compiler.util.SimpleLookupTable;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.builder.State;
import org.eclipse.jdt.internal.core.builder.StringSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.ui.notification.TypeNames;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @since 2.5
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaBuilderState {
  private final static Logger LOG = Logger.getLogger(JavaBuilderState.class);
  
  private final State state;
  
  private final IProject project;
  
  private Integer buildNumber;
  
  private SimpleLookupTable references;
  
  private Long lastStructuralBuildTime;
  
  private Set<QualifiedName> structurallyChangedTypes;
  
  private JavaBuilderState(final IProject project, final State state) {
    this.project = project;
    this.state = state;
  }
  
  public IProject getProject() {
    return this.project;
  }
  
  public static JavaBuilderState getLastBuiltState(final IJavaElement it) {
    JavaBuilderState _xblockexpression = null;
    {
      final IJavaProject javaProject = it.getJavaProject();
      boolean _equals = Objects.equal(javaProject, null);
      if (_equals) {
        return null;
      }
      IProject _project = javaProject.getProject();
      _xblockexpression = JavaBuilderState.getLastBuiltState(_project);
    }
    return _xblockexpression;
  }
  
  public static JavaBuilderState getLastBuiltState(final IProject it) {
    State _switchResult = null;
    JavaModelManager _javaModelManager = JavaModelManager.getJavaModelManager();
    Object _lastBuiltState = _javaModelManager.getLastBuiltState(it, null);
    final Object state = _lastBuiltState;
    boolean _matched = false;
    if (state instanceof State) {
      _matched=true;
      _switchResult = ((State)state);
    }
    if (!_matched) {
      _switchResult = null;
    }
    return new JavaBuilderState(it, _switchResult);
  }
  
  public Long getLastStructuralBuildTime() {
    Long _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.lastStructuralBuildTime, null));
      if (_notEquals) {
        return this.lastStructuralBuildTime;
      }
      boolean _equals = Objects.equal(this.state, null);
      if (_equals) {
        return this.lastStructuralBuildTime = Long.valueOf((-1l));
      }
      Object _readField = this.readField(this.state, "lastStructuralBuildTime", Long.valueOf((-1l)));
      _xblockexpression = this.lastStructuralBuildTime = ((Long) _readField);
    }
    return _xblockexpression;
  }
  
  public Integer getBuildNumber() {
    Integer _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.buildNumber, null));
      if (_notEquals) {
        return this.buildNumber;
      }
      boolean _equals = Objects.equal(this.state, null);
      if (_equals) {
        return this.buildNumber = Integer.valueOf((-1));
      }
      Object _readField = this.readField(this.state, "buildNumber", Integer.valueOf((-1)));
      _xblockexpression = this.buildNumber = ((Integer) _readField);
    }
    return _xblockexpression;
  }
  
  public Set<QualifiedName> getStructurallyChangedTypes() {
    Set<QualifiedName> _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.structurallyChangedTypes, null));
      if (_notEquals) {
        return this.structurallyChangedTypes;
      }
      HashSet<QualifiedName> _newHashSet = CollectionLiterals.<QualifiedName>newHashSet();
      this.structurallyChangedTypes = _newHashSet;
      Object _readField = null;
      if (this.state!=null) {
        _readField=this.readField(this.state, "structurallyChangedTypes", null);
      }
      final Object types = _readField;
      boolean _matched = false;
      if (types instanceof StringSet) {
        _matched=true;
        for (final String name : ((StringSet)types).values) {
          boolean _notEquals_1 = (!Objects.equal(name, null));
          if (_notEquals_1) {
            String[] _split = name.split("/");
            QualifiedName _create = QualifiedName.create(_split);
            this.structurallyChangedTypes.add(_create);
          }
        }
      }
      _xblockexpression = this.structurallyChangedTypes;
    }
    return _xblockexpression;
  }
  
  /**
   * <p>
   * Returns TypeNames which are direct children of a given package.
   * </p>
   */
  protected TypeNames _getQualifiedTypeNames(final IPackageFragment it) {
    TypeNames _xblockexpression = null;
    {
      IJavaProject _javaProject = it.getJavaProject();
      final TypeNames qualifiedTypeNames = new TypeNames(_javaProject);
      final SimpleLookupTable references = this.getReferences();
      boolean _equals = Objects.equal(references, null);
      if (_equals) {
        return qualifiedTypeNames;
      }
      final String packageName = it.getElementName();
      final IResource resource = it.getResource();
      boolean _equals_1 = Objects.equal(resource, null);
      if (_equals_1) {
        return qualifiedTypeNames;
      }
      final IPath packagePath = resource.getProjectRelativePath();
      IPackageFragmentRoot _packageFragmentRoot = this.getPackageFragmentRoot(it);
      IResource _resource = _packageFragmentRoot.getResource();
      IPath _projectRelativePath = _resource.getProjectRelativePath();
      final int srcPathSegmentCount = _projectRelativePath.segmentCount();
      for (final Object key : references.keyTable) {
        final Object typeLocator = key;
        boolean _matched = false;
        if (typeLocator instanceof String) {
          _matched=true;
          IJavaProject _javaProject_1 = it.getJavaProject();
          IProject _project = _javaProject_1.getProject();
          IFile _file = _project.getFile(((String)typeLocator));
          final IPath typeLocatorPath = _file.getProjectRelativePath();
          boolean _isPrefixOf = packagePath.isPrefixOf(typeLocatorPath);
          if (_isPrefixOf) {
            IPath _removeFirstSegments = typeLocatorPath.removeFirstSegments(srcPathSegmentCount);
            final IPath qualifiedPath = _removeFirstSegments.removeFileExtension();
            IPath _removeLastSegments = qualifiedPath.removeLastSegments(1);
            String _string = _removeLastSegments.toString();
            final String typePackageName = _string.replace("/", ".");
            boolean _equals_2 = packageName.equals(typePackageName);
            if (_equals_2) {
              String _lastSegment = qualifiedPath.lastSegment();
              final String simpleTypeName = _lastSegment.toString();
              IJavaProject _javaProject_2 = it.getJavaProject();
              TypeNames _qualifiedTypeNames = this.getQualifiedTypeNames(((String)typeLocator), packageName, simpleTypeName, _javaProject_2);
              qualifiedTypeNames.addAll(_qualifiedTypeNames);
            }
          }
        }
      }
      _xblockexpression = qualifiedTypeNames;
    }
    return _xblockexpression;
  }
  
  /**
   * <p>
   * Returns TypeNames which are direct children of a given CompilationUnit.
   * </p>
   */
  protected TypeNames _getQualifiedTypeNames(final ICompilationUnit it) {
    String _typeLocator = this.getTypeLocator(it);
    String _packageName = this.getPackageName(it);
    String _simplePrimaryTypeName = this.getSimplePrimaryTypeName(it);
    IJavaProject _javaProject = it.getJavaProject();
    return this.getQualifiedTypeNames(_typeLocator, _packageName, _simplePrimaryTypeName, _javaProject);
  }
  
  private IPackageFragmentRoot getPackageFragmentRoot(final IJavaElement it) {
    IPackageFragmentRoot _switchResult = null;
    IJavaElement _parent = it.getParent();
    final IJavaElement parent = _parent;
    boolean _matched = false;
    if (parent instanceof IPackageFragmentRoot) {
      _matched=true;
      _switchResult = ((IPackageFragmentRoot)parent);
    }
    if (!_matched) {
      _switchResult = this.getPackageFragmentRoot(parent);
    }
    return _switchResult;
  }
  
  private TypeNames getQualifiedTypeNames(final String typeLocator, final String packageName, final String simpleName, final IJavaProject project) {
    TypeNames _xblockexpression = null;
    {
      final TypeNames qualifiedTypeNames = new TypeNames(project);
      final String primaryTypeFqn = this.getQualifedTypeName(packageName, simpleName);
      char[][] _definedTypeNamesFor = null;
      if (this.state!=null) {
        _definedTypeNamesFor=this.state.getDefinedTypeNamesFor(typeLocator);
      }
      final char[][] typeNames = _definedTypeNamesFor;
      boolean _equals = Objects.equal(typeNames, null);
      if (_equals) {
        TypeNames _typeNames = new TypeNames(project);
        final Procedure1<TypeNames> _function = new Procedure1<TypeNames>() {
          @Override
          public void apply(final TypeNames it) {
            it.addTypeName(primaryTypeFqn, primaryTypeFqn);
          }
        };
        return ObjectExtensions.<TypeNames>operator_doubleArrow(_typeNames, _function);
      }
      final Procedure1<char[]> _function_1 = new Procedure1<char[]>() {
        @Override
        public void apply(final char[] it) {
          String _string = new String(it);
          final String typeName = JavaBuilderState.this.getQualifedTypeName(packageName, _string);
          qualifiedTypeNames.addTypeName(typeName, primaryTypeFqn);
        }
      };
      IterableExtensions.<char[]>forEach(((Iterable<char[]>)Conversions.doWrapArray(typeNames)), _function_1);
      _xblockexpression = qualifiedTypeNames;
    }
    return _xblockexpression;
  }
  
  private String getQualifedTypeName(final String packageName, final String simpleTypeName) {
    String _xblockexpression = null;
    {
      boolean _equals = Objects.equal(packageName, null);
      if (_equals) {
        return simpleTypeName;
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(packageName, "");
      _builder.append(".");
      _builder.append(simpleTypeName, "");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  private String getTypeLocator(final ICompilationUnit it) {
    IResource _resource = it.getResource();
    IPath _projectRelativePath = null;
    if (_resource!=null) {
      _projectRelativePath=_resource.getProjectRelativePath();
    }
    String _string = null;
    if (_projectRelativePath!=null) {
      _string=_projectRelativePath.toString();
    }
    return _string;
  }
  
  private String getPackageName(final ICompilationUnit it) {
    String _switchResult = null;
    IJavaElement _parent = it.getParent();
    final IJavaElement parent = _parent;
    boolean _matched = false;
    if (parent instanceof IPackageFragment) {
      boolean _isDefaultPackage = ((IPackageFragment)parent).isDefaultPackage();
      boolean _not = (!_isDefaultPackage);
      if (_not) {
        _matched=true;
        _switchResult = ((IPackageFragment)parent).getElementName();
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  private String getSimplePrimaryTypeName(final ICompilationUnit it) {
    String _xblockexpression = null;
    {
      final String elementName = it.getElementName();
      int _lastIndexOf = elementName.lastIndexOf(".");
      _xblockexpression = elementName.substring(0, _lastIndexOf);
    }
    return _xblockexpression;
  }
  
  private SimpleLookupTable getReferences() {
    SimpleLookupTable _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.references, null));
      if (_notEquals) {
        return this.references;
      }
      boolean _equals = Objects.equal(this.state, null);
      if (_equals) {
        return null;
      }
      SimpleLookupTable _switchResult = null;
      Object _readField = this.readField(this.state, "references", null);
      final Object references = _readField;
      boolean _matched = false;
      if (references instanceof SimpleLookupTable) {
        _matched=true;
        _switchResult = ((SimpleLookupTable)references);
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = this.references = _switchResult;
    }
    return _xblockexpression;
  }
  
  private Object readField(final Object instance, final String fieldName, final Object defaultValue) {
    try {
      Class<?> _class = instance.getClass();
      final Field field = _class.getDeclaredField(fieldName);
      field.setAccessible(true);
      final Object value = field.get(instance);
      boolean _notEquals = (!Objects.equal(value, null));
      if (_notEquals) {
        return value;
      }
      return defaultValue;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        boolean _isEnabledFor = JavaBuilderState.LOG.isEnabledFor(Level.ERROR);
        if (_isEnabledFor) {
          String _message = e.getMessage();
          JavaBuilderState.LOG.error(_message, e);
        }
        return defaultValue;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public TypeNames getQualifiedTypeNames(final Object it) {
    if (it instanceof ICompilationUnit) {
      return _getQualifiedTypeNames((ICompilationUnit)it);
    } else if (it instanceof IPackageFragment) {
      return _getQualifiedTypeNames((IPackageFragment)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
