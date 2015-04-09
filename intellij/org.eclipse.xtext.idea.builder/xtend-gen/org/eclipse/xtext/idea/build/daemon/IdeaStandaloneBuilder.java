/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import java.io.File;
import org.apache.log4j.Logger;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.IncrementalStandaloneBuilder;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.idea.build.daemon.BuildDaemonFileSystemAccess;
import org.eclipse.xtext.idea.build.daemon.IdeaIssueHandler;
import org.eclipse.xtext.idea.build.daemon.XtextBuildResultCollector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaStandaloneBuilder extends IncrementalStandaloneBuilder {
  private final static Logger LOG = Logger.getLogger(IdeaStandaloneBuilder.class);
  
  private XtextBuildResultCollector buildResultCollector;
  
  public void setBuildResultCollector(final XtextBuildResultCollector buildResultCollector) {
    this.buildResultCollector = buildResultCollector;
    IIssueHandler _issueHandler = this.getIssueHandler();
    ((IdeaIssueHandler) _issueHandler).setBuildResultCollector(buildResultCollector);
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
  
  @Override
  protected File createTempDir(final String subDir) {
    BuildRequest _request = this.getRequest();
    File _baseDir = _request.getBaseDir();
    final File tmpDir = new File(_baseDir, subDir);
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
