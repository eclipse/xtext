/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import java.io.File;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.build.daemon.BuildDaemonFileSystemAccess;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaLanguageAccess extends LanguageAccess {
  public IdeaLanguageAccess(final Set<OutputConfiguration> outputConfigurations, final IResourceServiceProvider resourceServiceProvider) {
    super(outputConfigurations, resourceServiceProvider, false);
  }
  
  public IdeaLanguageAccess(final Set<OutputConfiguration> outputConfigurations, final IResourceServiceProvider resourceServiceProvider, final boolean linksAgainstJavaTypes) {
    super(outputConfigurations, resourceServiceProvider, linksAgainstJavaTypes);
  }
  
  @Override
  public JavaIoFileSystemAccess createFileSystemAccess(final File baseDir) {
    IResourceServiceProvider _resourceServiceProvider = this.getResourceServiceProvider();
    BuildDaemonFileSystemAccess _get = _resourceServiceProvider.<BuildDaemonFileSystemAccess>get(BuildDaemonFileSystemAccess.class);
    final Procedure1<BuildDaemonFileSystemAccess> _function = new Procedure1<BuildDaemonFileSystemAccess>() {
      @Override
      public void apply(final BuildDaemonFileSystemAccess it) {
        JavaIoFileSystemAccess _createFileSystemAccess = IdeaLanguageAccess.super.createFileSystemAccess(baseDir);
        Map<String, OutputConfiguration> _outputConfigurations = _createFileSystemAccess.getOutputConfigurations();
        it.setOutputConfigurations(_outputConfigurations);
      }
    };
    return ObjectExtensions.<BuildDaemonFileSystemAccess>operator_doubleArrow(_get, _function);
  }
}
