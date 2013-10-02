/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.ui.notification;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashSet;
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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @since 2.5
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaBuilderState {
  private final static Logger LOG = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(JavaBuilderState.class);
      return _logger;
    }
  }.apply();
  
  private SimpleLookupTable references;
  
  private final State state;
  
  private JavaBuilderState(final State state) {
    this.state = state;
  }
  
  public static JavaBuilderState getLastBuiltState(final IJavaElement it) {
    JavaBuilderState _xblockexpression = null;
    {
      final IJavaProject javaProject = it.getJavaProject();
      boolean _equals = Objects.equal(javaProject, null);
      if (_equals) {
        return null;
      }
      State _switchResult = null;
      JavaModelManager _javaModelManager = JavaModelManager.getJavaModelManager();
      IProject _project = javaProject.getProject();
      Object _lastBuiltState = _javaModelManager.getLastBuiltState(_project, null);
      final Object state = _lastBuiltState;
      boolean _matched = false;
      if (!_matched) {
        if (state instanceof State) {
          _matched=true;
          _switchResult = ((State)state);
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      JavaBuilderState _javaBuilderState = new JavaBuilderState(_switchResult);
      _xblockexpression = (_javaBuilderState);
    }
    return _xblockexpression;
  }
  
  /**
   * <p>
   * Return types which are direct children of a given package.
   * </p>
   */
  protected LinkedHashSet<String> _getQualifiedTypeNames(final IPackageFragment it) {
    LinkedHashSet<String> _xblockexpression = null;
    {
      final LinkedHashSet<String> qualifiedTypeNames = CollectionLiterals.<String>newLinkedHashSet();
      final SimpleLookupTable references = this.getReferences();
      boolean _equals = Objects.equal(references, null);
      if (_equals) {
        return qualifiedTypeNames;
      }
      final String packageName = it.getElementName();
      IResource _resource = it.getResource();
      final IPath packagePath = _resource.getProjectRelativePath();
      IPackageFragmentRoot _packageFragmentRoot = this.getPackageFragmentRoot(it);
      IResource _resource_1 = _packageFragmentRoot.getResource();
      IPath _projectRelativePath = _resource_1.getProjectRelativePath();
      final int srcPathSegmentCount = _projectRelativePath.segmentCount();
      for (final Object key : references.keyTable) {
        final Object typeLocator = key;
        boolean _matched = false;
        if (!_matched) {
          if (typeLocator instanceof String) {
            _matched=true;
            IJavaProject _javaProject = it.getJavaProject();
            IProject _project = _javaProject.getProject();
            IFile _file = _project.getFile(((String)typeLocator));
            final IPath typeLocatorPath = _file.getProjectRelativePath();
            boolean _isPrefixOf = packagePath.isPrefixOf(typeLocatorPath);
            if (_isPrefixOf) {
              IPath _removeFirstSegments = typeLocatorPath.removeFirstSegments(srcPathSegmentCount);
              final IPath qulifiedPath = _removeFirstSegments.removeFileExtension();
              IPath _removeLastSegments = qulifiedPath.removeLastSegments(1);
              String _string = _removeLastSegments.toString();
              final String typePackageName = _string.replace("/", ".");
              boolean _equals_1 = packageName.equals(typePackageName);
              if (_equals_1) {
                String _lastSegment = qulifiedPath.lastSegment();
                final String simpleTypeName = _lastSegment.toString();
                LinkedHashSet<String> _qualifiedTypeNames = this.getQualifiedTypeNames(((String)typeLocator), packageName, simpleTypeName);
                Iterables.<String>addAll(qualifiedTypeNames, _qualifiedTypeNames);
              }
            }
          }
        }
      }
      _xblockexpression = (qualifiedTypeNames);
    }
    return _xblockexpression;
  }
  
  /**
   * <p>
   * Return types which are children of a given compilation unit.
   * </p>
   */
  protected LinkedHashSet<String> _getQualifiedTypeNames(final ICompilationUnit it) {
    String _typeLocator = this.getTypeLocator(it);
    String _packageName = this.getPackageName(it);
    String _simplePrimaryTypeName = this.getSimplePrimaryTypeName(it);
    LinkedHashSet<String> _qualifiedTypeNames = this.getQualifiedTypeNames(_typeLocator, _packageName, _simplePrimaryTypeName);
    return _qualifiedTypeNames;
  }
  
  private IPackageFragmentRoot getPackageFragmentRoot(final IJavaElement it) {
    IPackageFragmentRoot _switchResult = null;
    IJavaElement _parent = it.getParent();
    final IJavaElement parent = _parent;
    boolean _matched = false;
    if (!_matched) {
      if (parent instanceof IPackageFragmentRoot) {
        _matched=true;
        _switchResult = ((IPackageFragmentRoot)parent);
      }
    }
    if (!_matched) {
      IPackageFragmentRoot _packageFragmentRoot = this.getPackageFragmentRoot(parent);
      _switchResult = _packageFragmentRoot;
    }
    return _switchResult;
  }
  
  private LinkedHashSet<String> getQualifiedTypeNames(final String typeLocator, final String packageName, final String simpleName) {
    LinkedHashSet<String> _xblockexpression = null;
    {
      char[][] _definedTypeNamesFor = null;
      if (this.state!=null) {
        _definedTypeNamesFor=this.state.getDefinedTypeNamesFor(typeLocator);
      }
      final char[][] typeNames = _definedTypeNamesFor;
      boolean _equals = Objects.equal(typeNames, null);
      if (_equals) {
        String _qualifedTypeName = this.getQualifedTypeName(packageName, simpleName);
        return CollectionLiterals.<String>newLinkedHashSet(_qualifedTypeName);
      }
      final LinkedHashSet<String> qualifiedTypeNames = CollectionLiterals.<String>newLinkedHashSet();
      final Procedure1<char[]> _function = new Procedure1<char[]>() {
        public void apply(final char[] it) {
          String _string = new String(it);
          String _qualifedTypeName = JavaBuilderState.this.getQualifedTypeName(packageName, _string);
          qualifiedTypeNames.add(_qualifedTypeName);
        }
      };
      IterableExtensions.<char[]>forEach(((Iterable<char[]>)Conversions.doWrapArray(typeNames)), _function);
      _xblockexpression = (qualifiedTypeNames);
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
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  private String getTypeLocator(final ICompilationUnit it) {
    IResource _resource = it.getResource();
    IPath _projectRelativePath = _resource.getProjectRelativePath();
    String _string = _projectRelativePath.toString();
    return _string;
  }
  
  private String getPackageName(final ICompilationUnit it) {
    String _switchResult = null;
    IJavaElement _parent = it.getParent();
    final IJavaElement parent = _parent;
    boolean _matched = false;
    if (!_matched) {
      if (parent instanceof IPackageFragment) {
        boolean _isDefaultPackage = ((IPackageFragment)parent).isDefaultPackage();
        boolean _not = (!_isDefaultPackage);
        if (_not) {
          _matched=true;
          String _elementName = ((IPackageFragment)parent).getElementName();
          _switchResult = _elementName;
        }
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
      String _substring = elementName.substring(0, _lastIndexOf);
      _xblockexpression = (_substring);
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
      if (!_matched) {
        if (references instanceof SimpleLookupTable) {
          _matched=true;
          _switchResult = ((SimpleLookupTable)references);
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      SimpleLookupTable _references = this.references = _switchResult;
      _xblockexpression = (_references);
    }
    return _xblockexpression;
  }
  
  private Object readField(final Object instance, final String fieldName, final Object defaultValue) {
    try {
      Class<? extends Object> _class = instance.getClass();
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
          JavaBuilderState.LOG.error(e);
        }
        return defaultValue;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public LinkedHashSet<String> getQualifiedTypeNames(final Object it) {
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
