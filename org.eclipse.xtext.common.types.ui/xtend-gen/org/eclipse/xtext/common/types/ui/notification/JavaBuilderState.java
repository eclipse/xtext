/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.ui.notification;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @since 2.5
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaBuilderState {
  private static final Logger LOG = Logger.getLogger(JavaBuilderState.class);
  
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
      if ((javaProject == null)) {
        return null;
      }
      _xblockexpression = JavaBuilderState.getLastBuiltState(javaProject.getProject());
    }
    return _xblockexpression;
  }
  
  public static JavaBuilderState getLastBuiltState(final IProject it) {
    State _switchResult = null;
    Object _lastBuiltState = JavaModelManager.getJavaModelManager().getLastBuiltState(it, null);
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
      if ((this.lastStructuralBuildTime != null)) {
        return this.lastStructuralBuildTime;
      }
      if ((this.state == null)) {
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
      if ((this.buildNumber != null)) {
        return this.buildNumber;
      }
      if ((this.state == null)) {
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
      if ((this.structurallyChangedTypes != null)) {
        return this.structurallyChangedTypes;
      }
      this.structurallyChangedTypes = CollectionLiterals.<QualifiedName>newHashSet();
      Object _readField = null;
      if (this.state!=null) {
        _readField=this.readField(this.state, "structurallyChangedTypes", null);
      }
      final Object types = _readField;
      boolean _matched = false;
      if (types instanceof StringSet) {
        _matched=true;
        for (final String name : ((StringSet)types).values) {
          if ((name != null)) {
            QualifiedName _create = QualifiedName.create(name.split("/"));
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
      if ((references == null)) {
        return qualifiedTypeNames;
      }
      final String packageName = it.getElementName();
      final IResource resource = it.getResource();
      if ((resource == null)) {
        return qualifiedTypeNames;
      }
      final IPath packagePath = resource.getProjectRelativePath();
      final int srcPathSegmentCount = this.getPackageFragmentRoot(it).getResource().getProjectRelativePath().segmentCount();
      for (final Object key : references.keyTable) {
        final Object typeLocator = key;
        boolean _matched = false;
        if (typeLocator instanceof String) {
          _matched=true;
          final IPath typeLocatorPath = it.getJavaProject().getProject().getFile(((String)typeLocator)).getProjectRelativePath();
          boolean _isPrefixOf = packagePath.isPrefixOf(typeLocatorPath);
          if (_isPrefixOf) {
            final IPath qualifiedPath = typeLocatorPath.removeFirstSegments(srcPathSegmentCount).removeFileExtension();
            final String typePackageName = qualifiedPath.removeLastSegments(1).toString().replace("/", ".");
            boolean _equals = packageName.equals(typePackageName);
            if (_equals) {
              final String simpleTypeName = qualifiedPath.lastSegment().toString();
              qualifiedTypeNames.addAll(this.getQualifiedTypeNames(((String)typeLocator), packageName, simpleTypeName, it.getJavaProject()));
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
    return this.getQualifiedTypeNames(this.getTypeLocator(it), this.getPackageName(it), this.getSimplePrimaryTypeName(it), it.getJavaProject());
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
      if ((typeNames == null)) {
        TypeNames _typeNames = new TypeNames(project);
        final Procedure1<TypeNames> _function = (TypeNames it) -> {
          it.addTypeName(primaryTypeFqn, primaryTypeFqn);
        };
        return ObjectExtensions.<TypeNames>operator_doubleArrow(_typeNames, _function);
      }
      final Consumer<char[]> _function_1 = (char[] it) -> {
        String _string = new String(it);
        final String typeName = this.getQualifedTypeName(packageName, _string);
        qualifiedTypeNames.addTypeName(typeName, primaryTypeFqn);
      };
      ((List<char[]>)Conversions.doWrapArray(typeNames)).forEach(_function_1);
      _xblockexpression = qualifiedTypeNames;
    }
    return _xblockexpression;
  }
  
  private String getQualifedTypeName(final String packageName, final String simpleTypeName) {
    String _xblockexpression = null;
    {
      if ((packageName == null)) {
        return simpleTypeName;
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(packageName);
      _builder.append(".");
      _builder.append(simpleTypeName);
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
      _xblockexpression = elementName.substring(0, elementName.lastIndexOf("."));
    }
    return _xblockexpression;
  }
  
  private SimpleLookupTable getReferences() {
    SimpleLookupTable _xblockexpression = null;
    {
      if ((this.references != null)) {
        return this.references;
      }
      if ((this.state == null)) {
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
      final Field field = instance.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      final Object value = field.get(instance);
      if ((value != null)) {
        return value;
      }
      return defaultValue;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        boolean _isEnabledFor = JavaBuilderState.LOG.isEnabledFor(Level.ERROR);
        if (_isEnabledFor) {
          JavaBuilderState.LOG.error(e.getMessage(), e);
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
