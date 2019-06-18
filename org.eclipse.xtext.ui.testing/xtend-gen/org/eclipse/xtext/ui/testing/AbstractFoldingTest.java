/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.testing;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

/**
 * @author miklossy - Initial contribution and API
 * @since 2.19
 */
@Beta
@SuppressWarnings("all")
public abstract class AbstractFoldingTest extends AbstractEditorTest {
  @Inject
  @Extension
  protected FileExtensionProvider _fileExtensionProvider;
  
  @Inject
  @Extension
  protected IFoldingRegionProvider _iFoldingRegionProvider;
  
  /**
   * Special symbol indicating the beginning of a folding region.
   */
  public String b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>");
    return _builder.toString();
  }
  
  /**
   * Special symbol indicating the end of a folding region.
   */
  public String e() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<]");
    return _builder.toString();
  }
  
  /**
   * Test that the expected folding regions are present on a given DSL text.
   * 
   * @param it The DSL text where the expected folding regions are enclosed by the {@link #b() b} and {@link #e() e} symbols.
   */
  public void testFoldingRegions(final CharSequence it) {
    this.foldingRegionsArePresent(this.openInEditor(this.dslFile(it)), it);
  }
  
  protected IFile dslFile(final CharSequence text) {
    try {
      IFile _xblockexpression = null;
      {
        final IFile file = IResourcesSetupUtil.createFile(this.getProjectName(), this.getFileName(), this.getFileExtension(), this.getContent(text));
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
  
  protected String getProjectName() {
    return "FoldingTestProject";
  }
  
  protected String getFileName() {
    return "folding";
  }
  
  protected String getFileExtension() {
    return this._fileExtensionProvider.getPrimaryFileExtension();
  }
  
  protected String getContent(final CharSequence text) {
    return text.toString().replaceAll(Pattern.quote(this.b()), "").replaceAll(Pattern.quote(this.e()), "");
  }
  
  protected IXtextDocument openInEditor(final IFile dslFile) {
    try {
      IXtextDocument _xblockexpression = null;
      {
        final IXtextDocument document = this.openEditor(dslFile).getDocument();
        Assert.assertNotNull(document);
        _xblockexpression = document;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void foldingRegionsArePresent(final IXtextDocument document, final CharSequence expected) {
    final String actual = this.insertFoldingRegionMarkers(document);
    Assert.assertEquals(expected.toString().trim(), actual);
  }
  
  protected String insertFoldingRegionMarkers(final IXtextDocument document) {
    try {
      String _xblockexpression = null;
      {
        final String lineSeparator = System.lineSeparator();
        final List<String> lines = IterableExtensions.<String>toList(((Iterable<String>)Conversions.doWrapArray(document.get().split(lineSeparator))));
        Collection<FoldedPosition> _foldingRegions = this._iFoldingRegionProvider.getFoldingRegions(document);
        for (final FoldedPosition foldingRegion : _foldingRegions) {
          {
            final int startLine = document.getLineOfOffset(foldingRegion.offset);
            String _b = this.b();
            String _get = lines.get(startLine);
            String _plus = (_b + _get);
            lines.set(startLine, _plus);
            int _lineOfOffset = document.getLineOfOffset((foldingRegion.offset + foldingRegion.length));
            final int endLine = (_lineOfOffset - 1);
            String _get_1 = lines.get(endLine);
            String _e = this.e();
            String _plus_1 = (_get_1 + _e);
            lines.set(endLine, _plus_1);
          }
        }
        _xblockexpression = IterableExtensions.join(lines, lineSeparator);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
