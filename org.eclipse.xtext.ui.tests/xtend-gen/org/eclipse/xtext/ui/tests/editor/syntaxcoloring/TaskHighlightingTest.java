/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import com.google.inject.Inject;
import java.util.HashSet;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.util.CancelIndicator;
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
      final XtextResource resource = this.getResourceFromString(
        LineDelimiters.toUnix(_builder.toString()));
      this.expect(2, 4, DefaultHighlightingConfiguration.TASK_ID);
      this.expect(17, 5, DefaultHighlightingConfiguration.TASK_ID);
      this.getHighlighter().provideHighlightingFor(resource, this, CancelIndicator.NullImpl);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected DefaultSemanticHighlightingCalculator getHighlighter() {
    return this.highlighter;
  }
  
  protected boolean expect(final int offset, final int length, final String type) {
    TypedRegion _typedRegion = new TypedRegion(offset, length, type);
    return this.expectedRegions.add(_typedRegion);
  }
  
  @Override
  public void addPosition(final int offset, final int length, final String... id) {
    Assert.assertEquals(1, id.length);
    String _get = id[0];
    final TypedRegion region = new TypedRegion(offset, length, _get);
    Assert.assertFalse(region.toString(), this.expectedRegions.isEmpty());
    String _string = this.expectedRegions.toString();
    String _plus = ("expected: " + _string);
    String _plus_1 = (_plus + " but was: ");
    String _plus_2 = (_plus_1 + region);
    Assert.assertTrue(_plus_2, this.expectedRegions.remove(region));
  }
}
