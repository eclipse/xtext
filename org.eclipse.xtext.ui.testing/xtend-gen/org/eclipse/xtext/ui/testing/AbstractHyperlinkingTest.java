/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.testing;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.17
 */
@SuppressWarnings("all")
public abstract class AbstractHyperlinkingTest extends AbstractEditorTest {
  @Inject
  @Extension
  protected IHyperlinkHelper _iHyperlinkHelper;
  
  @Inject
  @Extension
  protected FileExtensionProvider _fileExtensionProvider;
  
  @Inject
  @Extension
  protected IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  protected SyncUtil _syncUtil;
  
  @Inject
  protected IResourceSetProvider resourceSetProvider;
  
  /**
   * @since 2.19
   */
  @Inject
  @Extension
  protected XtextDocumentUtil _xtextDocumentUtil;
  
  protected IProject project;
  
  protected final String c = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<|>");
      return _builder.toString();
    }
  }.apply();
  
  /**
   * Tests that the user can navigate to the target element in a DSL text when activating the hyperlink on a certain region.
   * 
   * @param it
   *            The DSL text. The text must contain the {@link #c} special symbols twice indicating the beginning and the end of the
   *            region wehre the hyperlink navigation gets activated.
   * @param hyperlinkTarget
   *            The fully qualified name of the expected target element.
   */
  public void hasHyperlinkTo(final CharSequence it, final String hyperlinkTarget) {
    this.hasHyperlinkTo(it, this.hyperlinkRegion(it), hyperlinkTarget);
  }
  
  /**
   * Tests that the user can navigate to the target element in a DSL text when activating the hyperlink on a certain region.
   * 
   * @param it The initial DSL text.
   * @param hyperlinkRegion The region where the hyperlink navigation gets activated.
   * @param hyperlinkTarget The fully qualified name of the expected target element.
   */
  public void hasHyperlinkTo(final CharSequence it, final IRegion hyperlinkRegion, final String hyperlinkTarget) {
    this.hyperlinkIsOffered(this.hyperlinkingOn(this.dslFile(it), hyperlinkRegion.getOffset()), hyperlinkRegion, hyperlinkTarget);
  }
  
  protected IFile dslFile(final CharSequence text) {
    try {
      IFile _xblockexpression = null;
      {
        final String content = text.toString().replace(this.c, "");
        final IFile file = IResourcesSetupUtil.createFile(this.getProjectName(), this.getFileName(), this.getFileExtension(), content.toString());
        final IProject project = file.getProject();
        boolean _hasNature = project.hasNature(XtextProjectHelper.NATURE_ID);
        boolean _not = (!_hasNature);
        if (_not) {
          IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
        }
        _xblockexpression = file;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IHyperlink[] hyperlinkingOn(final IFile dslFile, final int offset) {
    IHyperlink[] _xblockexpression = null;
    {
      final XtextEditor editor = this.openInEditor(dslFile);
      final IXtextDocument document = this._xtextDocumentUtil.getXtextDocument(editor.getInternalSourceViewer());
      final XtextResource resource = document.<XtextResource>readOnly(new IUnitOfWork<XtextResource, XtextResource>() {
        @Override
        public XtextResource exec(final XtextResource state) {
          return state;
        }
      });
      _xblockexpression = this._iHyperlinkHelper.createHyperlinksByOffset(resource, offset, true);
    }
    return _xblockexpression;
  }
  
  protected XtextEditor openInEditor(final IFile dslFile) {
    try {
      XtextEditor _xblockexpression = null;
      {
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        this._syncUtil.waitForBuild(_nullProgressMonitor);
        _xblockexpression = this.openEditor(dslFile);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void hyperlinkIsOffered(final IHyperlink[] hyperlinks, final IRegion expectedRegion, final String expectedHyperlinkTarget) {
    Assert.assertNotNull("No hyperlinks found!", hyperlinks);
    Assert.assertEquals(1, hyperlinks.length);
    final IHyperlink hyperlink = IterableExtensions.<IHyperlink>head(((Iterable<IHyperlink>)Conversions.doWrapArray(hyperlinks)));
    Assert.assertEquals(expectedRegion, hyperlink.getHyperlinkRegion());
    Assert.assertEquals(expectedHyperlinkTarget, this.target(hyperlink));
  }
  
  protected String _target(final JdtHyperlink hyperlink) {
    String _xblockexpression = null;
    {
      final IJavaElement javaElement = hyperlink.getJavaElement();
      Assert.assertTrue((javaElement instanceof IType));
      _xblockexpression = ((IType) javaElement).getFullyQualifiedName();
    }
    return _xblockexpression;
  }
  
  protected String _target(final XtextHyperlink hyperlink) {
    String _xblockexpression = null;
    {
      final ResourceSet resourceSet = this.resourceSetProvider.get(this.project);
      final EObject eObject = resourceSet.getEObject(hyperlink.getURI(), true);
      _xblockexpression = this._iQualifiedNameProvider.getFullyQualifiedName(eObject).toString();
    }
    return _xblockexpression;
  }
  
  protected String _target(final IHyperlink hyperlink) {
    Object _xblockexpression = null;
    {
      Class<? extends IHyperlink> _class = hyperlink.getClass();
      String _plus = ("Unsupported hyperlink " + _class);
      Assert.fail(_plus);
      _xblockexpression = null;
    }
    return ((String)_xblockexpression);
  }
  
  protected String getProjectName() {
    return "HyperlinkingTestProject";
  }
  
  protected String getFileName() {
    return "hyperlinking";
  }
  
  protected String getFileExtension() {
    return this._fileExtensionProvider.getPrimaryFileExtension();
  }
  
  protected IRegion hyperlinkRegion(final CharSequence input) {
    Region _xblockexpression = null;
    {
      final String text = input.toString();
      final int first = text.indexOf(this.c);
      if ((first == (-1))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Can\'t locate the first position symbol \'");
        _builder.append(this.c);
        _builder.append("\' in the input text");
        Assert.fail(_builder.toString());
      }
      final int second = text.lastIndexOf(this.c);
      if ((first == second)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Can\'t locate the second position symbol \'");
        _builder_1.append(this.c);
        _builder_1.append("\' in the input text");
        Assert.fail(_builder_1.toString());
      }
      final int offset = first;
      int _length = this.c.length();
      final int length = ((second - first) - _length);
      _xblockexpression = new Region(offset, length);
    }
    return _xblockexpression;
  }
  
  protected String target(final IHyperlink hyperlink) {
    if (hyperlink instanceof JdtHyperlink) {
      return _target((JdtHyperlink)hyperlink);
    } else if (hyperlink instanceof XtextHyperlink) {
      return _target((XtextHyperlink)hyperlink);
    } else if (hyperlink != null) {
      return _target(hyperlink);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(hyperlink).toString());
    }
  }
}
