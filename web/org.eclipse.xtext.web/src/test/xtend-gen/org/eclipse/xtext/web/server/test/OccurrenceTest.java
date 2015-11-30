/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.occurrences.OccurrencesResult;
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class OccurrenceTest extends AbstractWebServerTest {
  protected OccurrencesResult getOccurrences(final CharSequence resourceContent) {
    OccurrencesResult _xblockexpression = null;
    {
      final String content = resourceContent.toString();
      final int offset = content.indexOf("#");
      Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "occurrences");
      String _replace = content.replace("#", "");
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("fullText", _replace);
      String _string = Integer.valueOf(offset).toString();
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("caretOffset", _string);
      final XtextServiceDispatcher.ServiceDescriptor occurrences = this.getService(
        Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)));
      Function0<? extends IServiceResult> _service = occurrences.getService();
      IServiceResult _apply = _service.apply();
      _xblockexpression = ((OccurrencesResult) _apply);
    }
    return _xblockexpression;
  }
  
  protected void assertOccurrences(final CharSequence resourceContent, final CharSequence expectation) {
    String _string = expectation.toString();
    String _trim = _string.trim();
    OccurrencesResult _occurrences = this.getOccurrences(resourceContent);
    String _string_1 = _occurrences.toString();
    String _trim_1 = _string_1.trim();
    Assert.assertEquals(_trim, _trim_1);
  }
  
  @Test
  public void testNoOccurrenceOnEmptyFile() {
    final OccurrencesResult result = this.getOccurrences("#");
    List<TextRegion> _readRegions = result.getReadRegions();
    boolean _isEmpty = _readRegions.isEmpty();
    Assert.assertTrue(_isEmpty);
    List<TextRegion> _writeRegions = result.getWriteRegions();
    boolean _isEmpty_1 = _writeRegions.isEmpty();
    Assert.assertTrue(_isEmpty_1);
  }
  
  @Test
  public void testNoOccurrencesOnKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#state foo");
    _builder.newLine();
    final OccurrencesResult result = this.getOccurrences(_builder);
    List<TextRegion> _readRegions = result.getReadRegions();
    boolean _isEmpty = _readRegions.isEmpty();
    Assert.assertTrue(_isEmpty);
    List<TextRegion> _writeRegions = result.getWriteRegions();
    boolean _isEmpty_1 = _writeRegions.isEmpty();
    Assert.assertTrue(_isEmpty_1);
  }
  
  @Test
  public void testSingleWriteOccurrence() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("state #foo");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("OccurrencesResult [");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("stateId = \"-80000000\"");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("writeRegions = ArrayList (");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("[6:3]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("readRegions = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertOccurrences(_builder, _builder_1);
  }
  
  @Test
  public void testReadAndWriteOccurrence() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("input signal #foo");
    _builder.newLine();
    _builder.append("state bar ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set foo == true");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set foo == true");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("OccurrencesResult [");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("stateId = \"-80000000\"");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("writeRegions = ArrayList (");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("[13:3]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("readRegions = ArrayList (");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("[33:3],");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("[50:3]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertOccurrences(_builder, _builder_1);
  }
  
  @Test
  public void testReadAndWriteOccurrence_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("input signal foo");
    _builder.newLine();
    _builder.append("state bar ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set #foo == true");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set foo == true");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("OccurrencesResult [");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("stateId = \"-80000000\"");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("writeRegions = ArrayList (");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("[13:3]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("readRegions = ArrayList (");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("[33:3],");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("[50:3]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertOccurrences(_builder, _builder_1);
  }
  
  @Test
  public void testSyntaxError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("state foo");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.append("asdf#");
    _builder.newLine();
    _builder.append("state bar ");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("OccurrencesResult [");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("stateId = \"-80000000\"");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("writeRegions = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("readRegions = ArrayList ()");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertOccurrences(_builder, _builder_1);
  }
}
