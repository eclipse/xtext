/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.hyperlinking;

import com.google.inject.Inject;
import java.io.InputStream;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class AbstractHyperlinkingTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {
  @Inject
  private IHyperlinkHelper hyperlinkHelper;
  
  private static IProject staticProject;
  
  @BeforeClass
  public static void createTestProject() throws Exception {
    String _name = AbstractHyperlinkingTest.class.getName();
    IProject _createPluginProject = AbstractXbaseUITestCase.createPluginProject(_name);
    AbstractHyperlinkingTest.staticProject = _createPluginProject;
  }
  
  @AfterClass
  public static void deleteTestProject() throws Exception {
    JavaProjectSetupUtil.deleteProject(AbstractHyperlinkingTest.staticProject);
  }
  
  @Override
  public XtextResource getResourceFor(final InputStream stream) {
    try {
      XtextResourceSet _resourceSet = this.getResourceSet();
      URI _createURI = URI.createURI(("Test." + this.fileExtension));
      Resource _createResource = _resourceSet.createResource(_createURI);
      final XtextResource result = ((XtextResource) _createResource);
      result.load(stream, null);
      return result;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        throw new RuntimeException(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public XtextResourceSet getResourceSet() {
    final XtextResourceSet rs = this.<XtextResourceSet>get(XtextResourceSet.class);
    this.initializeTypeProvider(rs);
    return rs;
  }
  
  protected void initializeTypeProvider(final XtextResourceSet set) {
    final JdtTypeProviderFactory typeProviderFactory = new JdtTypeProviderFactory(this);
    typeProviderFactory.findOrCreateTypeProvider(set);
    IJavaProject _javaProject = this.getJavaProject(set);
    set.setClasspathURIContext(_javaProject);
  }
  
  @Override
  public IJavaProject getJavaProject(final ResourceSet set) {
    return JavaCore.create(AbstractHyperlinkingTest.staticProject);
  }
  
  public IHyperlink[] getHyperLinks(final String modelAsString) {
    IHyperlink[] _xblockexpression = null;
    {
      String _replace = modelAsString.replace("|", "");
      StringInputStream _stringInputStream = new StringInputStream(_replace);
      final XtextResource resource = this.getResourceFor(_stringInputStream);
      final int index = modelAsString.indexOf("|");
      _xblockexpression = this.hyperlinkHelper.createHyperlinksByOffset(resource, index, true);
    }
    return _xblockexpression;
  }
}
