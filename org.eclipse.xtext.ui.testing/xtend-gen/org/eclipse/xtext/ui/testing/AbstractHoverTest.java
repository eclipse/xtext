/**
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.testing;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.Region;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.16
 */
@SuppressWarnings("all")
public abstract class AbstractHoverTest extends AbstractEditorTest {
  @Inject
  protected IEObjectHover eObjectHover;
  
  @Inject
  @Extension
  protected SyncUtil _syncUtil;
  
  @Inject
  @Extension
  protected FileExtensionProvider _fileExtensionProvider;
  
  /**
   * Test that the expected text appears in a popup window while hovering over a certain text in a given DSL text.
   * 
   * @param it the initial DSL text.
   * @param hoverText the text you are hovering over.
   * @param hoverContent the text that is expected to be part of the hover popup.
   */
  public void hasHoverOver(final CharSequence it, final String hoverText, final String hoverContent) {
    int _indexOf = it.toString().indexOf(hoverText);
    int _length = hoverText.length();
    Region _region = new Region(_indexOf, _length);
    this.hasHoverOver(it, _region, hoverContent);
  }
  
  /**
   * Test that the expected text appears in a popup window while hovering over a certain region in a given DSL text.
   * 
   * @param it the initial DSL text.
   * @param hoverRegion the region you are hovering over.
   * @param hoverContent the text that is expected to be part of the hover popup.
   */
  public void hasHoverOver(final CharSequence it, final IRegion hoverRegion, final String hoverContent) {
    this.hoverPopupHasContent(this.hoveringOver(this.dslFile(it), hoverRegion), hoverContent);
  }
  
  protected IFile dslFile(final CharSequence content) {
    try {
      IFile _xblockexpression = null;
      {
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
  
  protected String getProjectName() {
    return "HoverTestProject";
  }
  
  protected String getFileName() {
    return "hover";
  }
  
  protected String getFileExtension() {
    return this._fileExtensionProvider.getPrimaryFileExtension();
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
  
  protected BrowserInformationControlInput hoveringOver(final IFile dslFile, final IRegion hoverRegion) {
    BrowserInformationControlInput _xblockexpression = null;
    {
      final XtextEditor editor = this.openInEditor(dslFile);
      final ITextHoverExtension2 textHover = ((ITextHoverExtension2) this.eObjectHover);
      Object _hoverInfo2 = textHover.getHoverInfo2(editor.getInternalSourceViewer(), hoverRegion);
      _xblockexpression = ((BrowserInformationControlInput) _hoverInfo2);
    }
    return _xblockexpression;
  }
  
  protected void hoverPopupHasContent(final BrowserInformationControlInput info, final String expectedHoverContent) {
    Assert.assertNotNull("No hover found!", info);
    final String actualHoverContent = info.getHtml();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Could not find the text \'");
    _builder.append(expectedHoverContent);
    _builder.append("\' in the hover popup:");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(actualHoverContent, "\t");
    _builder.newLineIfNotEmpty();
    Assert.assertTrue(_builder.toString(), actualHoverContent.contains(expectedHoverContent));
  }
}
