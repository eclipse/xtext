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
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.web.server.test.HashMapSessionStore;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ContentAssistTest extends AbstractWebServerTest {
  protected void assertContentAssistResult(final String resourceContent, final int offset, final String expectedResult) {
    try {
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      Pair<String, String> _mappedTo = Pair.<String, String>of("fullText", resourceContent);
      String _string = Integer.valueOf(offset).toString();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("caretOffset", _string);
      final XtextServiceDispatcher.ServiceDescriptor contentAssist = _dispatcher.getService("/content-assist", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)), sessionStore);
      boolean _isHasSideEffects = contentAssist.isHasSideEffects();
      Assert.assertFalse(_isHasSideEffects);
      boolean _isHasTextInput = contentAssist.isHasTextInput();
      Assert.assertTrue(_isHasTextInput);
      Function0<? extends IServiceResult> _service = contentAssist.getService();
      IServiceResult _apply = _service.apply();
      final ContentAssistResult result = ((ContentAssistResult) _apply);
      String _string_1 = result.toString();
      Assert.assertEquals(expectedResult, _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testKeywords() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ContentAssistResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entries = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Entry [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("prefix = \"\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("proposal = \"entity\"");
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
    _builder.append("Entry [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("prefix = \"\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("proposal = \"package\"");
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
    this.assertContentAssistResult("entity foo {} ", 14, _builder.toString());
  }
  
  @Test
  public void testKeywordWithPrefix() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ContentAssistResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entries = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Entry [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("prefix = \"ent\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("proposal = \"entity\"");
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
    this.assertContentAssistResult("entity foo {}", 3, _builder.toString());
  }
  
  @Test
  public void testIncorrectStateId() {
    try {
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      Pair<String, String> _mappedTo = Pair.<String, String>of("fullText", "entity foo {}");
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("caretOffset", "3");
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("requiredStateId", "totalerquatsch");
      final XtextServiceDispatcher.ServiceDescriptor contentAssist = _dispatcher.getService("/content-assist", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)), sessionStore);
      boolean _isHasConflict = contentAssist.isHasConflict();
      Assert.assertTrue(_isHasConflict);
      Function0<? extends IServiceResult> _service = contentAssist.getService();
      final IServiceResult result = _service.apply();
      Matcher<IServiceResult> _instanceOf = IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class);
      Assert.<IServiceResult>assertThat(result, _instanceOf);
      String _conflict = ((ServiceConflictResult) result).getConflict();
      Assert.assertEquals(_conflict, "invalidStateId");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
