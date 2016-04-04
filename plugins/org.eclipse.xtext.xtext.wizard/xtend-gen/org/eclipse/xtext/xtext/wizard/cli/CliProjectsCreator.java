/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard.cli;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.BinaryFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectsCreator;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TextFile;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@SuppressWarnings("all")
public class CliProjectsCreator implements ProjectsCreator {
  @Accessors
  private String lineDelimiter;
  
  @Override
  public void createProjects(final WizardConfiguration config) {
    Set<ProjectDescriptor> _enabledProjects = config.getEnabledProjects();
    for (final ProjectDescriptor it : _enabledProjects) {
      this.createProject(it);
    }
  }
  
  public void createProject(final ProjectDescriptor project) {
    try {
      String _location = project.getLocation();
      final File projectRoot = new File(_location);
      projectRoot.mkdirs();
      Iterable<? extends AbstractFile> _files = project.getFiles();
      for (final AbstractFile it : _files) {
        {
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
          boolean _matched = false;
          if (!_matched) {
            if (it instanceof TextFile) {
              _matched=true;
              String _content = ((TextFile)it).getContent();
              String _newLine = Strings.newLine();
              final String normalizedContent = _content.replace(_newLine, this.lineDelimiter);
              WizardConfiguration _config_1 = project.getConfig();
              Charset _encoding = _config_1.getEncoding();
              Files.write(normalizedContent, file, _encoding);
            }
          }
          if (!_matched) {
            if (it instanceof BinaryFile) {
              _matched=true;
              URL _content = ((BinaryFile)it).getContent();
              byte[] _byteArray = Resources.toByteArray(_content);
              Files.write(_byteArray, file);
            }
          }
          boolean _isExecutable = it.isExecutable();
          if (_isExecutable) {
            file.setExecutable(true);
          }
        }
      }
      Set<String> _sourceFolders = project.getSourceFolders();
      for (final String it_1 : _sourceFolders) {
        File _file = new File(projectRoot, it_1);
        _file.mkdirs();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public String getLineDelimiter() {
    return this.lineDelimiter;
  }
  
  public void setLineDelimiter(final String lineDelimiter) {
    this.lineDelimiter = lineDelimiter;
  }
}
