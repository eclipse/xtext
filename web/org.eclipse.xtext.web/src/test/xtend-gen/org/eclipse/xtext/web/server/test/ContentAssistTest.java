/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import java.io.File;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ContentAssistTest extends AbstractWebServerTest {
  protected void assertContentAssistResult(final CharSequence resourceContent, final CharSequence expectedResult) {
    String contentString = resourceContent.toString();
    final int cursorOffset = contentString.indexOf("|");
    if ((cursorOffset >= 0)) {
      String _substring = contentString.substring(0, cursorOffset);
      String _substring_1 = contentString.substring((cursorOffset + 1));
      String _plus = (_substring + _substring_1);
      contentString = _plus;
      this.assertContentAssistResult(contentString, cursorOffset, expectedResult);
    } else {
      this.assertContentAssistResult(resourceContent, 0, expectedResult);
    }
  }
  
  protected void assertContentAssistResult(final CharSequence resourceContent, final int offset, final CharSequence expectedResult) {
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "assist");
    String _string = resourceContent.toString();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("fullText", _string);
    String _string_1 = Integer.valueOf(offset).toString();
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("caretOffset", _string_1);
    final XtextServiceDispatcher.ServiceDescriptor contentAssist = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)));
    boolean _isHasSideEffects = contentAssist.isHasSideEffects();
    Assert.assertFalse(_isHasSideEffects);
    Function0<? extends IServiceResult> _service = contentAssist.getService();
    IServiceResult _apply = _service.apply();
    final ContentAssistResult result = ((ContentAssistResult) _apply);
    String _string_2 = expectedResult.toString();
    String _string_3 = result.toString();
    Assert.assertEquals(_string_2, _string_3);
  }
  
  @Test
  public void testKeywords() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ContentAssistResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("stateId = \"-80000000\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entries = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("ContentAssistEntry [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("prefix = \"\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("proposal = \"input\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("textReplacements = ArrayList ()");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("editPositions = ArrayList ()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("ContentAssistEntry [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("prefix = \"\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("proposal = \"output\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("textReplacements = ArrayList ()");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("editPositions = ArrayList ()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("ContentAssistEntry [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("prefix = \"\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("proposal = \"state\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("textReplacements = ArrayList ()");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("editPositions = ArrayList ()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("]");
    this.assertContentAssistResult("", _builder);
  }
  
  @Test
  public void testKeywordWithPrefix() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ContentAssistResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("stateId = \"-80000000\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entries = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("ContentAssistEntry [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("prefix = \"sta\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("proposal = \"state\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("textReplacements = ArrayList ()");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("editPositions = ArrayList ()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("]");
    this.assertContentAssistResult("sta|", _builder);
  }
  
  @Test
  public void testTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ContentAssistResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("stateId = \"-80000000\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entries = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("ContentAssistEntry [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("prefix = \"\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("proposal = \"name\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("description = \"ID\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("textReplacements = ArrayList ()");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("editPositions = ArrayList (");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("[6:4]");
    _builder.newLine();
    _builder.append("      ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("]");
    this.assertContentAssistResult("state | end", _builder);
  }
  
  @Test
  public void testCrossref() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("input signal x");
    _builder.newLine();
    _builder.append("state foo");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.append("state bar");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if x == true goto |");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ContentAssistResult [");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("stateId = \"-80000000\"");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("entries = ArrayList (");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ContentAssistEntry [");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("prefix = \"\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("proposal = \"bar\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("description = \"State\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("textReplacements = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("editPositions = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("],");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ContentAssistEntry [");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("prefix = \"\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("proposal = \"foo\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("description = \"State\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("textReplacements = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("editPositions = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("]");
    this.assertContentAssistResult(_builder, _builder_1);
  }
  
  @Test
  public void testCustomTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("output signal x");
    _builder.newLine();
    _builder.append("state foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set x = |");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ContentAssistResult [");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("stateId = \"-80000000\"");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("entries = ArrayList (");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ContentAssistEntry [");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("prefix = \"\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("proposal = \"false\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("textReplacements = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("editPositions = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("],");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ContentAssistEntry [");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("prefix = \"\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("proposal = \"true\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("textReplacements = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("editPositions = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("]");
    this.assertContentAssistResult(_builder, _builder_1);
  }
  
  @Test
  public void testCustomCrossref() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("input signal x");
    _builder.newLine();
    _builder.append("state foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if | == true goto foo");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ContentAssistResult [");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("stateId = \"-80000000\"");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("entries = ArrayList (");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ContentAssistEntry [");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("prefix = \"\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("proposal = \"x\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("description = \"input signal\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("textReplacements = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("editPositions = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("]");
    this.assertContentAssistResult(_builder, _builder_1);
  }
  
  @Test
  public void testIncorrectStateId() {
    final File file = this.createFile("state foo end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "assist");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("caretOffset", "3");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("requiredStateId", "totalerquatsch");
    final XtextServiceDispatcher.ServiceDescriptor contentAssist = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)));
    boolean _isHasConflict = contentAssist.isHasConflict();
    Assert.assertTrue(_isHasConflict);
    Function0<? extends IServiceResult> _service = contentAssist.getService();
    final IServiceResult result = _service.apply();
    Matcher<IServiceResult> _instanceOf = IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class);
    Assert.<IServiceResult>assertThat(result, _instanceOf);
    String _conflict = ((ServiceConflictResult) result).getConflict();
    Assert.assertEquals(_conflict, "invalidStateId");
  }
}
