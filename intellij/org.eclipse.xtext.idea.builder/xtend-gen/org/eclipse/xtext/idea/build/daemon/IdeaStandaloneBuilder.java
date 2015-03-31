/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import java.io.File;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.StandaloneBuilder;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.idea.build.daemon.BuildDaemonFileSystemAccess;
import org.eclipse.xtext.idea.build.daemon.IdeaIssueHandler;
import org.eclipse.xtext.idea.build.daemon.XtextBuildParameters;
import org.eclipse.xtext.idea.build.daemon.XtextBuildResultCollector;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaStandaloneBuilder extends StandaloneBuilder {
  private final static Logger LOG = Logger.getLogger(IdeaStandaloneBuilder.class);
  
  private XtextBuildParameters buildParameters;
  
  private XtextBuildResultCollector buildResultCollector;
  
  public void setBuildData(final XtextBuildParameters buildParameters) {
    this.buildParameters = buildParameters;
    File _baseDir = buildParameters.getBaseDir();
    String _path = _baseDir.getPath();
    this.setBaseDir(_path);
    List<File> _classpath = buildParameters.getClasspath();
    final Function1<File, String> _function = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getPath();
      }
    };
    List<String> _map = ListExtensions.<File, String>map(_classpath, _function);
    this.setClassPathEntries(_map);
    String _encoding = buildParameters.getEncoding();
    this.setEncoding(_encoding);
    File _orCreateTmpDir = this.getOrCreateTmpDir();
    String _path_1 = _orCreateTmpDir.getPath();
    this.setTempDir(_path_1);
    List<File> _sourceRoots = buildParameters.getSourceRoots();
    final Function1<File, String> _function_1 = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getPath();
      }
    };
    List<String> _map_1 = ListExtensions.<File, String>map(_sourceRoots, _function_1);
    this.setSourceDirs(_map_1);
  }
  
  public void setBuildResultCollector(final XtextBuildResultCollector buildResultCollector) {
    this.buildResultCollector = buildResultCollector;
    ((IdeaIssueHandler) this.issueHandler).setBuildResultCollector(buildResultCollector);
  }
  
  @Override
  protected JavaIoFileSystemAccess configureFileSystemAccess(final JavaIoFileSystemAccess fsa, final LanguageAccess language) {
    JavaIoFileSystemAccess _xblockexpression = null;
    {
      if ((fsa instanceof BuildDaemonFileSystemAccess)) {
        ((BuildDaemonFileSystemAccess)fsa).setBuildResultCollector(this.buildResultCollector);
      }
      _xblockexpression = fsa;
    }
    return _xblockexpression;
  }
  
  private File getOrCreateTmpDir() {
    final String contentRoot = this.getBaseDir();
    final File tmpDir = new File(contentRoot, "xtend-stubs");
    boolean _exists = tmpDir.exists();
    boolean _not = (!_exists);
    if (_not) {
      tmpDir.mkdir();
    } else {
      boolean _isDirectory = tmpDir.isDirectory();
      boolean _not_1 = (!_isDirectory);
      if (_not_1) {
        IdeaStandaloneBuilder.LOG.error((("Compilation tmpDir " + tmpDir) + " exists and is a file"));
      }
    }
    return tmpDir;
  }
}
