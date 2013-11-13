/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.file;

import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.file.JavaIoFileSystemTest;
import org.eclipse.xtext.xbase.ui.file.EclipseFileSystemSupportImpl;
import org.eclipse.xtext.xbase.ui.tests.file.MockEclipseOutputConfiguration;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class EclipseFileSystemTest extends JavaIoFileSystemTest {
  @Before
  public void setUp() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot root = _workspace.getRoot();
      final IProject project = root.getProject("foo");
      boolean _exists = project.exists();
      if (_exists) {
        project.delete(true, null);
      }
      project.create(null);
      project.open(null);
      EclipseFileSystemSupportImpl _eclipseFileSystemSupportImpl = new EclipseFileSystemSupportImpl();
      final Procedure1<EclipseFileSystemSupportImpl> _function = new Procedure1<EclipseFileSystemSupportImpl>() {
        public void apply(final EclipseFileSystemSupportImpl it) {
          it.setWorkspaceRoot(root);
          org.eclipse.xtext.parser.IEncodingProvider.Runtime _runtime = new org.eclipse.xtext.parser.IEncodingProvider.Runtime();
          it.setEncodingProvider(_runtime);
          final Function1<IProject,Set<OutputConfiguration>> _function = new Function1<IProject,Set<OutputConfiguration>>() {
            public Set<OutputConfiguration> apply(final IProject it) {
              OutputConfiguration _outputConfiguration = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
              final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
                public void apply(final OutputConfiguration it) {
                  it.setKeepLocalHistory(Boolean.valueOf(false));
                }
              };
              OutputConfiguration _doubleArrow = ObjectExtensions.<OutputConfiguration>operator_doubleArrow(_outputConfiguration, _function);
              return Collections.<OutputConfiguration>unmodifiableSet(Sets.<OutputConfiguration>newHashSet(_doubleArrow));
            }
          };
          MockEclipseOutputConfiguration _mockEclipseOutputConfiguration = new MockEclipseOutputConfiguration(_function);
          it.setEclipseOutputConfigurationProvider(_mockEclipseOutputConfiguration);
        }
      };
      EclipseFileSystemSupportImpl _doubleArrow = ObjectExtensions.<EclipseFileSystemSupportImpl>operator_doubleArrow(_eclipseFileSystemSupportImpl, _function);
      this.fs = _doubleArrow;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMakeandDeleteFile() {
    super.testMakeandDeleteFile();
  }
}
