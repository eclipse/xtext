/**
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.testing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.15
 */
@SuppressWarnings("all")
public abstract class AbstractHighlightingTest extends AbstractEditorTest {
  @Inject
  @Extension
  private FileExtensionProvider _fileExtensionProvider;
  
  /**
   * @param it The editor's input text. The input text must contain the given <code>text</code>.
   * @param text The text that's highlighting style is to test.
   * @param style The expected highlighting configuration text style used when highlighting the given <code>text</code>.
   */
  public void testHighlighting(final CharSequence it, final String text, final TextStyle style) {
    int _style = style.getStyle();
    int _xifexpression = (int) 0;
    RGB _color = style.getColor();
    boolean _tripleEquals = (_color == null);
    if (_tripleEquals) {
      _xifexpression = 0;
    } else {
      _xifexpression = style.getColor().red;
    }
    int _xifexpression_1 = (int) 0;
    RGB _color_1 = style.getColor();
    boolean _tripleEquals_1 = (_color_1 == null);
    if (_tripleEquals_1) {
      _xifexpression_1 = 0;
    } else {
      _xifexpression_1 = style.getColor().green;
    }
    int _xifexpression_2 = (int) 0;
    RGB _color_2 = style.getColor();
    boolean _tripleEquals_2 = (_color_2 == null);
    if (_tripleEquals_2) {
      _xifexpression_2 = 0;
    } else {
      _xifexpression_2 = style.getColor().blue;
    }
    int _xifexpression_3 = (int) 0;
    RGB _backgroundColor = style.getBackgroundColor();
    boolean _tripleEquals_3 = (_backgroundColor == null);
    if (_tripleEquals_3) {
      _xifexpression_3 = 255;
    } else {
      _xifexpression_3 = style.getBackgroundColor().red;
    }
    int _xifexpression_4 = (int) 0;
    RGB _backgroundColor_1 = style.getBackgroundColor();
    boolean _tripleEquals_4 = (_backgroundColor_1 == null);
    if (_tripleEquals_4) {
      _xifexpression_4 = 255;
    } else {
      _xifexpression_4 = style.getBackgroundColor().green;
    }
    int _xifexpression_5 = (int) 0;
    RGB _backgroundColor_2 = style.getBackgroundColor();
    boolean _tripleEquals_5 = (_backgroundColor_2 == null);
    if (_tripleEquals_5) {
      _xifexpression_5 = 255;
    } else {
      _xifexpression_5 = style.getBackgroundColor().blue;
    }
    this.testHighlighting(it, text, _style, _xifexpression, _xifexpression_1, _xifexpression_2, _xifexpression_3, _xifexpression_4, _xifexpression_5);
  }
  
  /**
   * @param it The editor's input text. The input text must contain the given <code>text</code>.
   * @param text The text that's highlighting style is to test.
   * @param fontStyle The expected font style used when highlighting the given <code>text</code>.
   * @param foregroundR The red component of the expected foreground color when highlighting the given <code>text</code>.
   * @param foregroundG The green component of the expected foreground color when highlighting the given <code>text</code>.
   * @param foregroundB The blue component of the expected foreground color when highlighting the given <code>text</code>.
   */
  public void testHighlighting(final CharSequence it, final String text, final int fontStyle, final int foregroundR, final int foregroundG, final int foregroundB) {
    this.testHighlighting(it, text, fontStyle, foregroundR, foregroundG, foregroundB, 255, 255, 255);
  }
  
  /**
   * @param it The editor's input text. The input text must contain the given <code>text</code>.
   * @param text The text that's highlighting style is to test.
   * @param fontStyle The expected font style used when highlighting the given <code>text</code>.
   * @param foregroundR The red component of the expected foreground color when highlighting the given <code>text</code>.
   * @param foregroundG The green component of the expected foreground color when highlighting the given <code>text</code>.
   * @param foregroundB The blue component of the expected foreground color when highlighting the given <code>text</code>.
   * @param backgroundR The red component of the expected background color when highlighting the given <code>text</code>.
   * @param backgroundG The green component of the expected background color when highlighting the given <code>text</code>.
   * @param backgroundB The blue component of the expected background color when highlighting the given <code>text</code>.
   */
  public void testHighlighting(final CharSequence it, final String text, final int fontStyle, final int foregroundR, final int foregroundG, final int foregroundB, final int backgroundR, final int backgroundG, final int backgroundB) {
    this.testHighlighting(this.openInEditor(this.dslFile(it)), text, fontStyle, foregroundR, foregroundG, foregroundB, backgroundR, backgroundG, backgroundB);
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
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("HighlightingTestProject");
    return _builder.toString();
  }
  
  protected String getFileName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("highlighting");
    return _builder.toString();
  }
  
  protected String getFileExtension() {
    return this._fileExtensionProvider.getPrimaryFileExtension();
  }
  
  protected StyledText openInEditor(final IFile dslFile) {
    try {
      StyledText _xblockexpression = null;
      {
        final XtextEditor editor = this.openEditor(dslFile);
        this.waitForEventProcessing();
        _xblockexpression = editor.getInternalSourceViewer().getTextWidget();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * @since 2.18
   */
  protected void waitForEventProcessing() {
    while (Display.getDefault().readAndDispatch()) {
    }
  }
  
  protected void testHighlighting(final StyledText styledText, final String text, final int fontStyle, final int foregroundR, final int foregroundG, final int foregroundB, final int backgroundR, final int backgroundG, final int backgroundB) {
    final Color expectedForegroundColor = new Color(null, foregroundR, foregroundG, foregroundB);
    final Color expectedBackgroundColor = new Color(null, backgroundR, backgroundG, backgroundB);
    final String content = styledText.getText();
    final int offset = this.getStartPosition(content, text);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Cannot locate \'");
    _builder.append(text);
    _builder.append("\' in ");
    _builder.append(content);
    Assert.assertNotEquals(_builder.toString(), (-1), offset);
    for (int i = 0; (i < text.length()); i++) {
      {
        final int currentPosition = (offset + i);
        final String character = styledText.getTextRange(currentPosition, 1);
        final StyleRange styleRange = styledText.getStyleRangeAtOffset(currentPosition);
        boolean _isRelevant = this.isRelevant(character);
        if (_isRelevant) {
          final Procedure1<StyleRange> _function = (StyleRange it) -> {
            this.assertFontStyle(it, character, fontStyle);
            this.assertForegroundColor(it, character, expectedForegroundColor);
            this.assertBackgroundColor(it, character, expectedBackgroundColor);
          };
          ObjectExtensions.<StyleRange>operator_doubleArrow(styleRange, _function);
        }
      }
    }
  }
  
  /**
   * @since 2.18
   */
  protected int getStartPosition(final String content, final String text) {
    return content.indexOf(text);
  }
  
  protected boolean isRelevant(final String character) {
    String _trim = character.trim();
    return Objects.equal(character, _trim);
  }
  
  protected void assertFontStyle(final StyleRange it, final String character, final int expected) {
    final int actual = it.fontStyle;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Expected font style does not correspond to the actual font style on character ");
    _builder.append(character);
    Assert.assertEquals(_builder.toString(), expected, actual);
  }
  
  protected void assertForegroundColor(final StyleRange it, final String character, final Color expected) {
    Color _elvis = null;
    if (it.foreground != null) {
      _elvis = it.foreground;
    } else {
      Color _color = new Color(null, 0, 0, 0);
      _elvis = _color;
    }
    final Color actual = _elvis;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Expected foreground color does not correspond to the actual foreground color on character ");
    _builder.append(character);
    Assert.assertEquals(_builder.toString(), expected, actual);
  }
  
  protected void assertBackgroundColor(final StyleRange it, final String character, final Color expected) {
    Color _elvis = null;
    if (it.background != null) {
      _elvis = it.background;
    } else {
      Color _color = new Color(null, 255, 255, 255);
      _elvis = _color;
    }
    final Color actual = _elvis;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Expected background color does not correspond to the actual background color on character ");
    _builder.append(character);
    Assert.assertEquals(_builder.toString(), expected, actual);
  }
}
