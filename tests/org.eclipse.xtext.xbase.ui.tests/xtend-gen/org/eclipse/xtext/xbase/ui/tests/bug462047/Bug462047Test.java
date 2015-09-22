/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.bug462047;

import com.google.inject.Inject;
import org.apache.log4j.Level;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.logging.LoggingTester;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.testlanguages.bug462047.Bug462047LangUiInjectorProvider;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(Bug462047LangUiInjectorProvider.class)
@SuppressWarnings("all")
public class Bug462047Test extends AbstractEditorTest {
  private IProject project;
  
  @Inject
  private XtextEditorInfo editorInfo;
  
  @Before
  public void createProjects() {
    try {
      IProject _createPluginProject = AbstractXbaseUITestCase.createPluginProject("bug462047");
      this.project = _createPluginProject;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void deleteProjects() {
    try {
      IResourcesSetupUtil.cleanWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected String getEditorId() {
    return this.editorInfo.getEditorId();
  }
  
  @Test
  public void testNoErrors() {
    try {
      IResourcesSetupUtil.createFile("bug462047/src/a.bug462047lang", "element CORE ref CORE.b");
      final IFile file = IResourcesSetupUtil.createFile("bug462047/src/b.bug462047lang", "element b ref CORE.c");
      IResourcesSetupUtil.createFile("bug462047/src/c.bug462047lang", "element c");
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          try {
            final XtextEditor editor = Bug462047Test.this.openEditor(file);
            final IXtextDocument document = XtextDocumentUtil.get(editor);
            final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
              @Override
              public Object exec(final XtextResource res) throws Exception {
                EcoreUtil.resolveAll(res);
                final ResourceSet resourceSet = res.getResourceSet();
                URI _createURI = URI.createURI("java:/Objects/CORE.CORE");
                Resource _resource = resourceSet.getResource(_createURI, false);
                Assert.assertNull(_resource);
                return null;
              }
            };
            document.<Object>readOnly(_function);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      LoggingTester.LogCapture _captureLogging = LoggingTester.captureLogging(Level.ERROR, BatchLinkableResource.class, _function);
      _captureLogging.assertNoLogEntries();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
