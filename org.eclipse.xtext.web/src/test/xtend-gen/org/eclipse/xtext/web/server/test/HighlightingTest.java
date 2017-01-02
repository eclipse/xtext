/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.hover.HoverResult;
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingResult;
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class HighlightingTest extends AbstractWebServerTest {
  protected void assertHighlighting(final CharSequence resourceContent, final String... styleClasses) {
    final String content = resourceContent.toString();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "highlight");
    String _replace = content.replace("#", "");
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("fullText", _replace);
    final XtextServiceDispatcher.ServiceDescriptor highlighting = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)));
    IServiceResult _apply = highlighting.getService().apply();
    final HighlightingResult result = ((HighlightingResult) _apply);
    Assert.assertEquals(styleClasses.length, result.getRegions().size());
    int offset = 0;
    final String[] snippets = content.split("#");
    for (int i = 0; (i < styleClasses.length); i++) {
      {
        int _offset = offset;
        int _length = snippets[(2 * i)].length();
        offset = (_offset + _length);
        final int length = snippets[((2 * i) + 1)].length();
        final HighlightingResult.Region region = result.getRegions().get(i);
        Assert.assertEquals(styleClasses[i], IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(region.getStyleClasses()))));
        Assert.assertEquals(offset, region.getOffset());
        Assert.assertEquals(length, region.getLength());
        int _offset_1 = offset;
        offset = (_offset_1 + length);
      }
    }
  }
  
  protected HoverResult assertTitle(final HoverResult result, final String expectedTitle) {
    HoverResult _xblockexpression = null;
    {
      Assert.assertEquals(expectedTitle, result.getTitle());
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected HoverResult assertContent(final HoverResult result, final String expectedContent) {
    HoverResult _xblockexpression = null;
    {
      Assert.assertEquals(expectedContent, result.getContent());
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  @Test
  public void testNoHighlightingOnEmptyFile() {
    this.assertHighlighting("#");
  }
  
  @Test
  public void testNoSignal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("state State");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.assertHighlighting(_builder);
  }
  
  @Test
  public void testInputSignal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("input signal #in#");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state State");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if #in# == true goto State");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.assertHighlighting(_builder, "InputSignal", "InputSignal");
  }
  
  @Test
  public void testOutputSignal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("output signal #out#");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state State");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set #out# = false");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.assertHighlighting(_builder, "OutputSignal", "OutputSignal");
  }
  
  @Test
  public void testMixed() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("input signal #in#");
    _builder.newLine();
    _builder.append("output signal #out#");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state State");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set #out# = false");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if #in# == true goto State");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.assertHighlighting(_builder, "InputSignal", "OutputSignal", "OutputSignal", "InputSignal");
  }
}
