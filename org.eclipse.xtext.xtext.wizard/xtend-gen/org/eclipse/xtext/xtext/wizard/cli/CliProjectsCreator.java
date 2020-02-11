/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard.cli;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.BinaryFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectsCreator;
import org.eclipse.xtext.xtext.wizard.SourceFolderDescriptor;
import org.eclipse.xtext.xtext.wizard.TextFile;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@SuppressWarnings("all")
public class CliProjectsCreator implements ProjectsCreator {
  @Accessors
  private String lineDelimiter;
  
  @Override
  public void createProjects(final WizardConfiguration config) {
    final Consumer<ProjectDescriptor> _function = (ProjectDescriptor it) -> {
      this.createProject(it);
    };
    config.getEnabledProjects().forEach(_function);
  }
  
  public void createProject(final ProjectDescriptor project) {
    String _location = project.getLocation();
    final File projectRoot = new File(_location);
    projectRoot.mkdirs();
    final Consumer<AbstractFile> _function = (AbstractFile it) -> {
      try {
        String _pathFor = project.getConfig().getSourceLayout().getPathFor(it.getOutlet());
        String _plus = (_pathFor + "/");
        String _relativePath = it.getRelativePath();
        final String projectRelativePath = (_plus + _relativePath);
        final File file = new File(projectRoot, projectRelativePath);
        file.getParentFile().mkdirs();
        boolean _matched = false;
        if (it instanceof TextFile) {
          _matched=true;
          final String normalizedContent = ((TextFile)it).getContent().replace(Strings.newLine(), this.lineDelimiter);
          Files.asCharSink(file, project.getConfig().getEncoding()).write(normalizedContent);
        }
        if (!_matched) {
          if (it instanceof BinaryFile) {
            _matched=true;
            Files.write(Resources.toByteArray(((BinaryFile)it).getContent()), file);
          }
        }
        boolean _isExecutable = it.isExecutable();
        if (_isExecutable) {
          file.setExecutable(true);
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    project.getFiles().forEach(_function);
    final Consumer<SourceFolderDescriptor> _function_1 = (SourceFolderDescriptor it) -> {
      String _path = it.getPath();
      new File(projectRoot, _path).mkdirs();
    };
    project.getSourceFolders().forEach(_function_1);
  }
  
  @Pure
  public String getLineDelimiter() {
    return this.lineDelimiter;
  }
  
  public void setLineDelimiter(final String lineDelimiter) {
    this.lineDelimiter = lineDelimiter;
  }
}
