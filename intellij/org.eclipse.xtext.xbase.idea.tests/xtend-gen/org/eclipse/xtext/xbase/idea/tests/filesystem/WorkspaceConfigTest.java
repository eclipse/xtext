/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.tests.filesystem;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import junit.framework.TestCase;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.idea.tests.LightXbaseTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class WorkspaceConfigTest extends LightXbaseTest {
  @Inject
  private Provider<WorkspaceConfig> workspaceConfigs;
  
  public void testDefaultProject() {
    final WorkspaceConfig config = this.workspaceConfigs.get();
    Project _project = this.getProject();
    String _basePath = _project.getBasePath();
    String _absoluteFileSystemPath = config.getAbsoluteFileSystemPath();
    TestCase.assertEquals(_basePath, _absoluteFileSystemPath);
    Map<String, ProjectConfig> _projects = config.getProjects();
    Collection<ProjectConfig> _values = _projects.values();
    final Procedure1<ProjectConfig> _function = new Procedure1<ProjectConfig>() {
      public void apply(final ProjectConfig it) {
        Module _module = WorkspaceConfigTest.this.myFixture.getModule();
        String _name = _module.getName();
        String _name_1 = it.getName();
        TestCase.assertEquals(_name, _name_1);
        Path _path = new Path("src");
        Path _path_1 = new Path("src-gen");
        Pair<Path, Path> _mappedTo = Pair.<Path, Path>of(_path, _path_1);
        Map<Path, Path> _sourceFolderMappings = it.getSourceFolderMappings();
        TestCase.assertEquals(Collections.<Path, Path>unmodifiableMap(CollectionLiterals.<Path, Path>newHashMap(_mappedTo)), _sourceFolderMappings);
      }
    };
    IterableExtensions.<ProjectConfig>forEach(_values, _function);
  }
}
