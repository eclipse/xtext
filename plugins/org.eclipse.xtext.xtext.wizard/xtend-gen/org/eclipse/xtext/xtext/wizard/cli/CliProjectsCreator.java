/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard.cli;

import com.google.common.io.Files;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectsCreator;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TextFile;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@SuppressWarnings("all")
public class CliProjectsCreator implements ProjectsCreator {
  @Override
  public void createProjects(final WizardConfiguration config) {
    Set<ProjectDescriptor> _enabledProjects = config.getEnabledProjects();
    final Procedure1<ProjectDescriptor> _function = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        CliProjectsCreator.this.createProject(it);
      }
    };
    IterableExtensions.<ProjectDescriptor>forEach(_enabledProjects, _function);
  }
  
  public void createProject(final ProjectDescriptor project) {
    String _location = project.getLocation();
    final File projectRoot = new File(_location);
    projectRoot.mkdirs();
    Iterable<? extends TextFile> _files = project.getFiles();
    final Procedure1<TextFile> _function = new Procedure1<TextFile>() {
      @Override
      public void apply(final TextFile it) {
        try {
          WizardConfiguration _config = project.getConfig();
          SourceLayout _sourceLayout = _config.getSourceLayout();
          Outlet _outlet = it.getOutlet();
          String _pathFor = _sourceLayout.getPathFor(_outlet);
          String _plus = (_pathFor + "/");
          String _relativePath = it.getRelativePath();
          final String projectRelativePath = (_plus + _relativePath);
          final File file = new File(projectRoot, projectRelativePath);
          File _parentFile = file.getParentFile();
          _parentFile.mkdirs();
          String _content = it.getContent();
          WizardConfiguration _config_1 = project.getConfig();
          Charset _encoding = _config_1.getEncoding();
          Files.write(_content, file, _encoding);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IterableExtensions.forEach(_files, _function);
    Set<String> _sourceFolders = project.getSourceFolders();
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        File _file = new File(projectRoot, it);
        _file.mkdirs();
      }
    };
    IterableExtensions.<String>forEach(_sourceFolders, _function_1);
  }
}
