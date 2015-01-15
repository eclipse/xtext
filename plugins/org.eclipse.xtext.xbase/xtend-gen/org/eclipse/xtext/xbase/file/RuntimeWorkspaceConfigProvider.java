/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.file;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.io.File;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
@Accessors
@SuppressWarnings("all")
public class RuntimeWorkspaceConfigProvider implements Provider<WorkspaceConfig> {
  private File workspaceRoot = new File(".").getAbsoluteFile().getParentFile();
  
  private WorkspaceConfig workspaceConfig;
  
  @Override
  public WorkspaceConfig get() {
    boolean _equals = Objects.equal(this.workspaceConfig, null);
    if (_equals) {
      String _absolutePath = this.workspaceRoot.getAbsolutePath();
      WorkspaceConfig _workspaceConfig = new WorkspaceConfig(_absolutePath);
      final Procedure1<WorkspaceConfig> _function = new Procedure1<WorkspaceConfig>() {
        @Override
        public void apply(final WorkspaceConfig it) {
          File[] _listFiles = RuntimeWorkspaceConfigProvider.this.workspaceRoot.listFiles();
          final Function1<File, Boolean> _function = new Function1<File, Boolean>() {
            @Override
            public Boolean apply(final File it) {
              return Boolean.valueOf(it.isDirectory());
            }
          };
          Iterable<File> _filter = IterableExtensions.<File>filter(((Iterable<File>)Conversions.doWrapArray(_listFiles)), _function);
          for (final File dir : _filter) {
            String _name = dir.getName();
            ProjectConfig _projectConfig = new ProjectConfig(_name);
            final Procedure1<ProjectConfig> _function_1 = new Procedure1<ProjectConfig>() {
              @Override
              public void apply(final ProjectConfig it) {
              }
            };
            ProjectConfig _doubleArrow = ObjectExtensions.<ProjectConfig>operator_doubleArrow(_projectConfig, _function_1);
            it.addProjectConfig(_doubleArrow);
          }
        }
      };
      WorkspaceConfig _doubleArrow = ObjectExtensions.<WorkspaceConfig>operator_doubleArrow(_workspaceConfig, _function);
      this.workspaceConfig = _doubleArrow;
    }
    return this.workspaceConfig;
  }
  
  @Pure
  public File getWorkspaceRoot() {
    return this.workspaceRoot;
  }
  
  public void setWorkspaceRoot(final File workspaceRoot) {
    this.workspaceRoot = workspaceRoot;
  }
  
  @Pure
  public WorkspaceConfig getWorkspaceConfig() {
    return this.workspaceConfig;
  }
  
  public void setWorkspaceConfig(final WorkspaceConfig workspaceConfig) {
    this.workspaceConfig = workspaceConfig;
  }
}
