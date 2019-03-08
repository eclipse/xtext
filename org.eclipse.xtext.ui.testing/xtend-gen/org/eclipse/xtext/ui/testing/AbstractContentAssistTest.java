/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.testing;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.io.InputStream;
import java.util.ArrayList;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.ResourceLoadHelper;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * @since 2.12
 */
@SuppressWarnings("all")
public abstract class AbstractContentAssistTest implements ResourceLoadHelper, IJavaProjectProvider {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private FileExtensionProvider fileExtensionProvider;
  
  @Inject
  private Injector injector;
  
  private static IJavaProject javaProject;
  
  @BeforeClass
  @BeforeAll
  public static void setUp() {
    try {
      AbstractContentAssistTest.javaProject = JavaProjectSetupUtil.createJavaProject("contentAssistTest");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @AfterClass
  @AfterAll
  public static void tearDown() {
    try {
      IProject _project = AbstractContentAssistTest.javaProject.getProject();
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      _project.delete(true, _nullProgressMonitor);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @SuppressWarnings("unchecked")
  protected ArrayList<String> expect(final String[]... arrays) {
    final ArrayList<String> expectation = CollectionLiterals.<String>newArrayList();
    for (final String[] array : arrays) {
      CollectionExtensions.<String>addAll(expectation, array);
    }
    return expectation;
  }
  
  protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
    return new ContentAssistProcessorTestBuilder(this.injector, this);
  }
  
  @Override
  public XtextResource getResourceFor(final InputStream stream) {
    try {
      XtextResource _xblockexpression = null;
      {
        final XtextResourceSet set = this.resourceSetProvider.get();
        this.initializeTypeProvider(set);
        String _primaryFileExtension = this.fileExtensionProvider.getPrimaryFileExtension();
        String _plus = ("Test." + _primaryFileExtension);
        final Resource result = set.createResource(URI.createURI(_plus));
        result.load(stream, null);
        _xblockexpression = ((XtextResource) result);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void initializeTypeProvider(final XtextResourceSet set) {
    final JdtTypeProviderFactory typeProviderFactory = new JdtTypeProviderFactory(this);
    typeProviderFactory.findOrCreateTypeProvider(set);
    set.setClasspathURIContext(this.getJavaProject(set));
  }
  
  @Override
  public IJavaProject getJavaProject(final ResourceSet resourceSet) {
    return AbstractContentAssistTest.javaProject;
  }
}
