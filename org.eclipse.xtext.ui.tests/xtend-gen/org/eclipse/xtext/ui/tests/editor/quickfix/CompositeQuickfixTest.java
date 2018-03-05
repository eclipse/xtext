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
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompositeQuickfixTest extends AbstractQuickfixTest {
  @Test
  public void testSimpleFixMultipleMarkers() throws Exception {
    IProject _createGeneralXtextProject = this.createGeneralXtextProject("myProject");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"bad doc\"");
    _builder.newLine();
    _builder.append("Foo { ref Bor }");
    _builder.newLine();
    _builder.append("\"bad doc\"");
    _builder.newLine();
    _builder.append("Bor { }");
    _builder.newLine();
    final IFile resource = this.createFile(_createGeneralXtextProject, "test.quickfixcrossreftestlanguage", _builder.toString());
    final IMarker[] markers = this.getMarkers(resource);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<0<\"bad doc\">0>");
    _builder_1.newLine();
    _builder_1.append("Foo { ref Bor }");
    _builder_1.newLine();
    _builder_1.append("<1<\"bad doc\">1>");
    _builder_1.newLine();
    _builder_1.append("Bor { }");
    _builder_1.newLine();
    _builder_1.append("---------------");
    _builder_1.newLine();
    _builder_1.append("0: message=multiFixableIssue2");
    _builder_1.newLine();
    _builder_1.append("1: message=multiFixableIssue2");
    _builder_1.newLine();
    this.assertContentsAndMarkers(resource, markers, _builder_1);
    this.applyQuickfixOnMultipleMarkers(markers);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"not bad doc\"");
    _builder_2.newLine();
    _builder_2.append("Foo { ref Bor }");
    _builder_2.newLine();
    _builder_2.append("\"not bad doc\"");
    _builder_2.newLine();
    _builder_2.append("Bor { }");
    _builder_2.newLine();
    _builder_2.append("---------------");
    _builder_2.newLine();
    _builder_2.append("(no markers found)");
    _builder_2.newLine();
    this.assertContentsAndMarkers(resource, _builder_2);
  }
  
  @Test
  public void testSimpleSingleMarker() throws Exception {
    IProject _createGeneralXtextProject = this.createGeneralXtextProject("myProject");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"bad doc\"");
    _builder.newLine();
    _builder.append("Foo { ref Bor }");
    _builder.newLine();
    _builder.append("\"bad doc\"");
    _builder.newLine();
    _builder.append("Bor { }");
    _builder.newLine();
    final IFile resource = this.createFile(_createGeneralXtextProject, "test.quickfixcrossreftestlanguage", _builder.toString());
    final IMarker[] markers = this.getMarkers(resource);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<0<\"bad doc\">0>");
    _builder_1.newLine();
    _builder_1.append("Foo { ref Bor }");
    _builder_1.newLine();
    _builder_1.append("<1<\"bad doc\">1>");
    _builder_1.newLine();
    _builder_1.append("Bor { }");
    _builder_1.newLine();
    _builder_1.append("---------------");
    _builder_1.newLine();
    _builder_1.append("0: message=multiFixableIssue2");
    _builder_1.newLine();
    _builder_1.append("1: message=multiFixableIssue2");
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
    _builder_2.append("\"not bad doc\"");
    _builder_2.newLine();
    _builder_2.append("Foo { ref Bor }");
    _builder_2.newLine();
    _builder_2.append("<0<\"bad doc\">0>");
    _builder_2.newLine();
    _builder_2.append("Bor { }");
    _builder_2.newLine();
    _builder_2.append("---------------");
    _builder_2.newLine();
    _builder_2.append("0: message=multiFixableIssue2");
    _builder_2.newLine();
    this.assertContentsAndMarkers(resource, _builder_2);
  }
  
  @Test
  public void testSimpleQuickAssist() throws Exception {
    IProject _createGeneralXtextProject = this.createGeneralXtextProject("myProject");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"bad doc\"");
    _builder.newLine();
    _builder.append("Foo { ref Bor }");
    _builder.newLine();
    _builder.append("\"bad doc\"");
    _builder.newLine();
    _builder.append("Bor { }");
    _builder.newLine();
    final XtextEditor editor = this.newXtextEditor(_createGeneralXtextProject, "test.quickfixcrossreftestlanguage", _builder.toString());
    final ICompletionProposal[] proposals = this.computeQuickAssistProposals(editor, 1);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Multi fix 2");
    final Function1<ICompletionProposal, String> _function = (ICompletionProposal it) -> {
      return it.getDisplayString();
    };
    Assert.assertEquals(_builder_1.toString(), IterableExtensions.join(ListExtensions.<ICompletionProposal, String>map(((List<ICompletionProposal>)Conversions.doWrapArray(proposals)), _function), "\n"));
    IterableExtensions.<ICompletionProposal>head(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals))).apply(editor.getDocument());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"not bad doc\"");
    _builder_2.newLine();
    _builder_2.append("Foo { ref Bor }");
    _builder_2.newLine();
    _builder_2.append("\"bad doc\"");
    _builder_2.newLine();
    _builder_2.append("Bor { }");
    _builder_2.newLine();
    Assert.assertEquals(_builder_2.toString(), editor.getDocument().get());
  }
  
  @Test
  public void testMultiFixMultipleMarkers() throws Exception {
    IProject _createGeneralXtextProject = this.createGeneralXtextProject("myProject");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("c {\tbadname { foo {} } }");
    _builder.newLine();
    _builder.append("a {\tbadname { bar {} } }");
    _builder.newLine();
    _builder.append("b {\tbadname { baz {} } }");
    _builder.newLine();
    final IFile resource = this.createFile(_createGeneralXtextProject, "test.quickfixcrossreftestlanguage", _builder.toString());
    final IMarker[] markers = this.getMarkers(resource);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<0<c>0> {\tbadname { foo {} } }");
    _builder_1.newLine();
    _builder_1.append("<1<a>1> {\tbadname { bar {} } }");
    _builder_1.newLine();
    _builder_1.append("<2<b>2> {\tbadname { baz {} } }");
    _builder_1.newLine();
    _builder_1.append("---------------------------------");
    _builder_1.newLine();
    _builder_1.append("0: message=badNameInSubelements");
    _builder_1.newLine();
    _builder_1.append("1: message=badNameInSubelements");
    _builder_1.newLine();
    _builder_1.append("2: message=badNameInSubelements");
    _builder_1.newLine();
    this.assertContentsAndMarkers(resource, markers, _builder_1);
    this.applyQuickfixOnMultipleMarkers(markers);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("newElement { } c {\tgoodname { foo {} } }");
    _builder_2.newLine();
    _builder_2.append("newElement { } a {\tgoodname { bar {} } }");
    _builder_2.newLine();
    _builder_2.append("newElement { } b {\tgoodname { baz {} } }");
    _builder_2.newLine();
    _builder_2.append("-------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("(no markers found)");
    _builder_2.newLine();
    this.assertContentsAndMarkers(resource, _builder_2);
  }
  
  @Test
  public void testMultiFixSingleMarker() throws Exception {
    IProject _createGeneralXtextProject = this.createGeneralXtextProject("myProject");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("c {\tbadname { foo {} } }");
    _builder.newLine();
    _builder.append("a {\tbadname { bar {} } }");
    _builder.newLine();
    final IFile resource = this.createFile(_createGeneralXtextProject, "test.quickfixcrossreftestlanguage", _builder.toString());
    final IMarker[] markers = this.getMarkers(resource);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<0<c>0> {\tbadname { foo {} } }");
    _builder_1.newLine();
    _builder_1.append("<1<a>1> {\tbadname { bar {} } }");
    _builder_1.newLine();
    _builder_1.append("---------------------------------");
    _builder_1.newLine();
    _builder_1.append("0: message=badNameInSubelements");
    _builder_1.newLine();
    _builder_1.append("1: message=badNameInSubelements");
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
    _builder_2.append("newElement { } c {\tgoodname { foo {} } }");
    _builder_2.newLine();
    _builder_2.append("<0<a>0> {\tbadname { bar {} } }");
    _builder_2.newLine();
    _builder_2.append("-------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("0: message=badNameInSubelements");
    _builder_2.newLine();
    this.assertContentsAndMarkers(resource, _builder_2);
  }
  
  @Test
  public void testMultiQuickAssist() throws Exception {
    IProject _createGeneralXtextProject = this.createGeneralXtextProject("myProject");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("c {\tbadname { foo {} } }");
    _builder.newLine();
    _builder.append("a {\tbadname { bar {} } }");
    _builder.newLine();
    final XtextEditor editor = this.newXtextEditor(_createGeneralXtextProject, "test.quickfixcrossreftestlanguage", _builder.toString());
    final ICompletionProposal[] proposals = this.computeQuickAssistProposals(editor, 1);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Fix Bad Names");
    final Function1<ICompletionProposal, String> _function = (ICompletionProposal it) -> {
      return it.getDisplayString();
    };
    Assert.assertEquals(_builder_1.toString(), IterableExtensions.join(ListExtensions.<ICompletionProposal, String>map(((List<ICompletionProposal>)Conversions.doWrapArray(proposals)), _function), "\n"));
    IterableExtensions.<ICompletionProposal>head(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals))).apply(editor.getDocument());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("newElement { } c {\tgoodname { foo {} } }");
    _builder_2.newLine();
    _builder_2.append("a {\tbadname { bar {} } }");
    _builder_2.newLine();
    Assert.assertEquals(_builder_2.toString(), editor.getDocument().get());
  }
}
