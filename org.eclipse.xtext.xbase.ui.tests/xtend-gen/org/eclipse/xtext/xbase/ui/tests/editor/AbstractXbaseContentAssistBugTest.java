/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import com.google.inject.Injector;
import java.io.InputStream;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractXbaseContentAssistBugTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {
  private IProject demandCreateProject;
  
  private static IProject staticProject;
  
  @BeforeClass
  public static void createTestProject() throws Exception {
    TargetPlatformUtil.setTargetPlatform(AbstractXbaseContentAssistBugTest.class);
    AbstractXbaseContentAssistBugTest.staticProject = AbstractXbaseUITestCase.createPluginProject(AbstractXbaseContentAssistBugTest.class.getName());
  }
  
  @AfterClass
  public static void deleteTestProject() throws Exception {
    JavaProjectSetupUtil.deleteProject(AbstractXbaseContentAssistBugTest.staticProject);
  }
  
  @Override
  public void tearDown() throws Exception {
    if ((this.demandCreateProject != null)) {
      JavaProjectSetupUtil.deleteProject(this.demandCreateProject);
    }
    super.tearDown();
  }
  
  @Override
  public boolean doCleanWorkspace() {
    return false;
  }
  
  @Override
  public IJavaProject getJavaProject(final ResourceSet resourceSet) {
    final String projectName = this.getProjectName();
    IJavaProject javaProject = JavaProjectSetupUtil.findJavaProject(projectName);
    if (((javaProject == null) || (!javaProject.exists()))) {
      try {
        this.demandCreateProject = AbstractXbaseUITestCase.createPluginProject(projectName);
        javaProject = JavaProjectSetupUtil.findJavaProject(projectName);
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
          String _message = e.getMessage();
          String _plus = ("cannot create java project due to: " + _message);
          String _plus_1 = (_plus + " / ");
          String _plus_2 = (_plus_1 + e);
          Assert.fail(_plus_2);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return javaProject;
  }
  
  protected String getProjectName() {
    String _simpleName = this.getClass().getSimpleName();
    return (_simpleName + "Project");
  }
  
  @Override
  public XtextResource getResourceFor(final InputStream stream) {
    final XtextResource result = super.getResourceFor(stream);
    this.initializeTypeProvider(result);
    return result;
  }
  
  protected void initializeTypeProvider(final XtextResource result) {
    ResourceSet _resourceSet = result.getResourceSet();
    final XtextResourceSet resourceSet = ((XtextResourceSet) _resourceSet);
    final JdtTypeProviderFactory typeProviderFactory = new JdtTypeProviderFactory(this);
    typeProviderFactory.findOrCreateTypeProvider(resourceSet);
    resourceSet.setClasspathURIContext(this.getJavaProject(resourceSet));
  }
  
  protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
    Injector _injector = this.getInjector();
    return new ContentAssistProcessorTestBuilder(_injector, this);
  }
}
