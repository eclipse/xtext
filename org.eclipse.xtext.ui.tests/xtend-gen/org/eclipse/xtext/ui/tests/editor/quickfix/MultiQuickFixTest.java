/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.tests.editor.quickfix.AbstractQuickfixTest;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class MultiQuickFixTest extends AbstractQuickfixTest {
  @Test
  public void testFixMultipleMarkers() throws Exception {
    IProject _createGeneralXtextProject = this.createGeneralXtextProject("myProject");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"no doc\"");
    _builder.newLine();
    _builder.append("Foo { ref Bor }");
    _builder.newLine();
    _builder.append("\"no doc\" Bor { }");
    _builder.newLine();
    final IFile resource = this.createFile(_createGeneralXtextProject, "test.quickfixcrossreftestlanguage", _builder.toString());
    final IMarker[] markers = this.getMarkers(resource);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<0<\"no doc\">0>");
    _builder_1.newLine();
    _builder_1.append("Foo { ref Bor }");
    _builder_1.newLine();
    _builder_1.append("<1<\"no doc\">1> Bor { }");
    _builder_1.newLine();
    _builder_1.append("----------------------");
    _builder_1.newLine();
    _builder_1.append("0: message=multiFixableIssue");
    _builder_1.newLine();
    _builder_1.append("1: message=multiFixableIssue");
    _builder_1.newLine();
    this.assertContentsAndMarkers(resource, markers, _builder_1);
    this.applyQuickfixOnMultipleMarkers(markers);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"Better documentation\"");
    _builder_2.newLine();
    _builder_2.append("Foo { ref Bor }");
    _builder_2.newLine();
    _builder_2.append("\"Better documentation\" Bor { }");
    _builder_2.newLine();
    _builder_2.append("------------------------------");
    _builder_2.newLine();
    _builder_2.append("(no markers found)");
    _builder_2.newLine();
    this.assertContentsAndMarkers(resource, _builder_2);
  }
  
  @Test
  public void testFixSingleMarker() throws Exception {
    IProject _createGeneralXtextProject = this.createGeneralXtextProject("myProject");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"no doc\"");
    _builder.newLine();
    _builder.append("Foo { ref Bor }");
    _builder.newLine();
    _builder.append("\"no doc\" Bor { }");
    _builder.newLine();
    final IFile resource = this.createFile(_createGeneralXtextProject, "test.quickfixcrossreftestlanguage", _builder.toString());
    final IMarker[] markers = this.getMarkers(resource);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<0<\"no doc\">0>");
    _builder_1.newLine();
    _builder_1.append("Foo { ref Bor }");
    _builder_1.newLine();
    _builder_1.append("<1<\"no doc\">1> Bor { }");
    _builder_1.newLine();
    _builder_1.append("----------------------");
    _builder_1.newLine();
    _builder_1.append("0: message=multiFixableIssue");
    _builder_1.newLine();
    _builder_1.append("1: message=multiFixableIssue");
    _builder_1.newLine();
    this.assertContentsAndMarkers(resource, markers, _builder_1);
    final Function1<IMarker, Integer> _function = (IMarker it) -> {
      try {
        Object _attribute = it.getAttribute(IMarker.CHAR_START);
        return ((Integer) _attribute);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final IMarker firstMarker = IterableExtensions.<IMarker>head(IterableExtensions.<IMarker, Integer>sortBy(((Iterable<IMarker>)Conversions.doWrapArray(markers)), _function));
    this.applyQuickfixOnSingleMarkers(firstMarker);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"Better documentation\"");
    _builder_2.newLine();
    _builder_2.append("Foo { ref Bor }");
    _builder_2.newLine();
    _builder_2.append("<0<\"no doc\">0> Bor { }");
    _builder_2.newLine();
    _builder_2.append("----------------------");
    _builder_2.newLine();
    _builder_2.append("0: message=multiFixableIssue");
    _builder_2.newLine();
    this.assertContentsAndMarkers(resource, _builder_2);
  }
  
  @Test
  public void testQuickAssist() throws Exception {
    IProject _createGeneralXtextProject = this.createGeneralXtextProject("myProject");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"no doc\"");
    _builder.newLine();
    _builder.append("Foo { ref Bor }");
    _builder.newLine();
    _builder.append("\"no doc\" Bor { }");
    _builder.newLine();
    final XtextEditor editor = this.newXtextEditor(_createGeneralXtextProject, "test.quickfixcrossreftestlanguage", _builder.toString());
    final ICompletionProposal[] proposals = this.computeQuickAssistProposals(editor, 1);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Multi fix");
    final Function1<ICompletionProposal, String> _function = (ICompletionProposal it) -> {
      return it.getDisplayString();
    };
    Assert.assertEquals(_builder_1.toString(), IterableExtensions.join(ListExtensions.<ICompletionProposal, String>map(((List<ICompletionProposal>)Conversions.doWrapArray(proposals)), _function), "\n"));
    IterableExtensions.<ICompletionProposal>head(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals))).apply(editor.getDocument());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"Better documentation\"");
    _builder_2.newLine();
    _builder_2.append("Foo { ref Bor }");
    _builder_2.newLine();
    _builder_2.append("\"no doc\" Bor { }");
    _builder_2.newLine();
    Assert.assertEquals(_builder_2.toString(), editor.getDocument().get());
  }
}
