/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.IncrementalStandaloneBuilder;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.idea.build.daemon.BuildDaemonFileSystemAccess;
import org.eclipse.xtext.idea.build.daemon.IdeaIssueHandler;
import org.eclipse.xtext.idea.build.daemon.XtextBuildResultCollector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaStandaloneBuilder extends IncrementalStandaloneBuilder {
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
  protected void beforeGenerate(final Resource resource, final IFileSystemAccess fileSystemAccess) {
    this.buildResultCollector.setCurrentResource(resource);
  }
}
