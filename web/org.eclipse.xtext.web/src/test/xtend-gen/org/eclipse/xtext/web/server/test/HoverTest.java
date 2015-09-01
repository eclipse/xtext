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
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class HoverTest extends AbstractWebServerTest {
  protected HoverResult getHover(final CharSequence resourceContent) {
    HoverResult _xblockexpression = null;
    {
      final String content = resourceContent.toString();
      final int offset = content.indexOf("#");
      Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "hover");
      String _replace = content.replace("#", "");
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("fullText", _replace);
      String _string = Integer.valueOf(offset).toString();
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("caretOffset", _string);
      final XtextServiceDispatcher.ServiceDescriptor hover = this.getService(
        Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)));
      boolean _isHasTextInput = hover.isHasTextInput();
      Assert.assertTrue(_isHasTextInput);
      Function0<? extends IServiceResult> _service = hover.getService();
      IServiceResult _apply = _service.apply();
      _xblockexpression = ((HoverResult) _apply);
    }
    return _xblockexpression;
  }
  
  protected HoverResult assertTitle(final HoverResult result, final String expectedTitle) {
    HoverResult _xblockexpression = null;
    {
      String _title = result.getTitle();
      Assert.assertEquals(expectedTitle, _title);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected HoverResult assertContent(final HoverResult result, final String expectedContent) {
    HoverResult _xblockexpression = null;
    {
      String _content = result.getContent();
      Assert.assertEquals(expectedContent, _content);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  @Test
  public void testNoHoverOnEmptyFile() {
    HoverResult _hover = this.getHover("#");
    String _content = _hover.getContent();
    Assert.assertNull(_content);
  }
  
  @Test
  public void testUnDocumentedElement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("state #foo");
    _builder.newLine();
    HoverResult _hover = this.getHover(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<div class=\"hover\">");
    _builder_1.newLine();
    _builder_1.append("</div>");
    _builder_1.newLine();
    HoverResult _assertContent = this.assertContent(_hover, _builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("<div class=\"hover\">");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("<div class=\"State-icon default-icon\">");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("<div class=\"element-name\">");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("foo");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("</div>");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("</div>");
    _builder_2.newLine();
    _builder_2.append("</div>");
    _builder_2.newLine();
    this.assertTitle(_assertContent, _builder_2.toString());
  }
  
  @Test
  public void testDocumentedElement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This is foo!");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("state #foo");
    _builder.newLine();
    HoverResult _hover = this.getHover(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<div class=\"hover\">");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("This is foo!");
    _builder_1.newLine();
    _builder_1.append("</div>");
    _builder_1.newLine();
    HoverResult _assertContent = this.assertContent(_hover, _builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("<div class=\"hover\">");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("<div class=\"State-icon default-icon\">");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("<div class=\"element-name\">");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("foo");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("</div>");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("</div>");
    _builder_2.newLine();
    _builder_2.append("</div>");
    _builder_2.newLine();
    this.assertTitle(_assertContent, _builder_2.toString());
  }
  
  @Test
  public void testKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This is foo!");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("#state foo");
    _builder.newLine();
    HoverResult _hover = this.getHover(_builder);
    String _content = _hover.getContent();
    Assert.assertNull(_content);
  }
  
  @Test
  public void testSubClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("input signal #foo");
    _builder.newLine();
    HoverResult _hover = this.getHover(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<div class=\"hover\">");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<div class=\"InputSignal-icon Signal-icon default-icon\">");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("<div class=\"element-name\">");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("</div>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("</div>");
    _builder_1.newLine();
    _builder_1.append("</div>");
    _builder_1.newLine();
    this.assertTitle(_hover, _builder_1.toString());
  }
  
  @Test
  public void testDecoratedIcon() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("output signal #foo");
    _builder.newLine();
    HoverResult _hover = this.getHover(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<div class=\"hover\">");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<div class=\"OutputSignal-icon Signal-icon default-icon\">");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("<div class=\"output-icon\">");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("<div class=\"element-name\">");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("</div>");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("</div>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("</div>");
    _builder_1.newLine();
    _builder_1.append("</div>");
    _builder_1.newLine();
    this.assertTitle(_hover, _builder_1.toString());
  }
  
  @Test
  public void testNoHoverUnnamedElement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("input signal x");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state State1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set z = fal#se");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    HoverResult _hover = this.getHover(_builder);
    String _content = _hover.getContent();
    Assert.assertNull(_content);
  }
}
