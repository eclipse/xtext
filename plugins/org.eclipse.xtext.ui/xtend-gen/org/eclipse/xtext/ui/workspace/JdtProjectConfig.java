/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.workspace;

import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseSourceFolder;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class JdtProjectConfig extends EclipseProjectConfig {
  @Override
  public Set<? extends ISourceFolder> getSourceFolders() {
    try {
      IProject _project = this.getProject();
      final IJavaProject javaProject = JavaCore.create(_project);
      boolean _exists = javaProject.exists();
      boolean _not = (!_exists);
      if (_not) {
        return CollectionLiterals.<ISourceFolder>emptySet();
      }
      final IClasspathEntry[] classpath = javaProject.getRawClasspath();
      final Function1<IClasspathEntry, Boolean> _function = new Function1<IClasspathEntry, Boolean>() {
        @Override
        public Boolean apply(final IClasspathEntry it) {
          int _entryKind = it.getEntryKind();
          return Boolean.valueOf((_entryKind == IClasspathEntry.CPE_SOURCE));
        }
      };
      final Iterable<IClasspathEntry> sourceEntries = IterableExtensions.<IClasspathEntry>filter(((Iterable<IClasspathEntry>)Conversions.doWrapArray(classpath)), _function);
      final Function1<IClasspathEntry, String> _function_1 = new Function1<IClasspathEntry, String>() {
        @Override
        public String apply(final IClasspathEntry it) {
          IPath _path = it.getPath();
          IPath _removeFirstSegments = _path.removeFirstSegments(1);
          return _removeFirstSegments.toString();
        }
      };
      final Iterable<String> sourceFolders = IterableExtensions.<IClasspathEntry, String>map(sourceEntries, _function_1);
      final Function1<String, EclipseSourceFolder> _function_2 = new Function1<String, EclipseSourceFolder>() {
        @Override
        public EclipseSourceFolder apply(final String it) {
          IProject _project = JdtProjectConfig.this.getProject();
          return new EclipseSourceFolder(_project, it);
        }
      };
      Iterable<EclipseSourceFolder> _map = IterableExtensions.<String, EclipseSourceFolder>map(sourceFolders, _function_2);
      return IterableExtensions.<EclipseSourceFolder>toSet(_map);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JdtProjectConfig(final IProject project) {
    super(project);
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (!super.equals(obj))
      return false;
    JdtProjectConfig other = (JdtProjectConfig) obj;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
    return result;
  }
}
