/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import com.google.inject.Inject;
import java.util.HashSet;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class TaskHighlightingTest extends AbstractXtextTests implements IHighlightedPositionAcceptor {
  @Inject
  private DefaultSemanticHighlightingCalculator highlighter;
  
  private final HashSet<Object> expectedRegions = CollectionLiterals.<Object>newHashSet();
  
  @Before
  public void setup() {
    try {
      this.with(NoJdtTestLanguageStandaloneSetup.class);
      this.injectMembers(this);
      this.expectedRegions.clear();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("//TODO foo");
      _builder.newLine();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* FIXME bar");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Fixme no match");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* FOO also no match");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("Hello notATODO!");
      _builder.newLine();
      String _unix = LineDelimiters.toUnix(_builder.toString());
      final XtextResource resource = this.getResourceFromString(_unix);
      this.expect(2, 4, DefaultHighlightingConfiguration.TASK_ID);
      this.expect(17, 5, DefaultHighlightingConfiguration.TASK_ID);
      this.highlighter.provideHighlightingFor(resource, this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected boolean expect(final int offset, final int length, final String type) {
    TypedRegion _typedRegion = new TypedRegion(offset, length, type);
    return this.expectedRegions.add(_typedRegion);
  }
  
  public void addPosition(final int offset, final int length, final String... id) {
    int _length = id.length;
    Assert.assertEquals(1, _length);
    String _get = id[0];
    final TypedRegion region = new TypedRegion(offset, length, _get);
    String _string = region.toString();
    boolean _isEmpty = this.expectedRegions.isEmpty();
    Assert.assertFalse(_string, _isEmpty);
    String _string_1 = this.expectedRegions.toString();
    String _plus = ("expected: " + _string_1);
    String _plus_1 = (_plus + " but was: ");
    String _plus_2 = (_plus_1 + region);
    boolean _remove = this.expectedRegions.remove(region);
    Assert.assertTrue(_plus_2, _remove);
  }
}
