/**
 * Copyright (c) 2017, 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.testing.AbstractMultiQuickfixTest;
import org.eclipse.xtext.ui.testing.AbstractWorkbenchTest;
import org.eclipse.xtext.ui.tests.quickfix.ui.tests.QuickfixCrossrefTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(QuickfixCrossrefTestLanguageUiInjectorProvider.class)
public class CompositeQuickfixTest extends AbstractMultiQuickfixTest {
	@Test
	public void testSimpleFixMultipleMarkers() throws Exception {
		String model =
				"\"bad doc\"\n" +
				"Foo { ref Bor }\n" +
				"\"bad doc\"\n" +
				"Bor { }\n";
		IFile resource = dslFile(model);
		IMarker[] markers = getMarkers(resource);
		String contentAndMarkersBefore =
				"<0<\"bad doc\">0>\n" +
				"Foo { ref Bor }\n" +
				"<1<\"bad doc\">1>\n" +
				"Bor { }\n" +
				"-----\n" +
				"0: message=multiFixableIssue2\n" +
				"1: message=multiFixableIssue2\n";
		assertContentsAndMarkers(resource, markers, contentAndMarkersBefore);
		applyQuickfixOnMultipleMarkers(markers);
		String contentAndMarkersAfter =
				"\"not bad doc\"\n" +
				"Foo { ref Bor }\n" +
				"\"not bad doc\"\n" +
				"Bor { }\n" +
				"-----\n" +
				"(no markers found)\n";
		assertContentsAndMarkers(resource, contentAndMarkersAfter);
	}

	@Test
	public void testSimpleSingleMarker() throws Exception {
		String model =
				"\"bad doc\"\n" +
				"Foo { ref Bor }\n" +
				"\"bad doc\"\n" +
				"Bor { }\n";
		IFile resource = dslFile(model);
		IMarker[] markers = getMarkers(resource);
		String contentAndMarkersBefore =
				"<0<\"bad doc\">0>\n" +
				"Foo { ref Bor }\n" +
				"<1<\"bad doc\">1>\n" +
				"Bor { }\n" +
				"-----\n" +
				"0: message=multiFixableIssue2\n" +
				"1: message=multiFixableIssue2\n";
		assertContentsAndMarkers(resource, markers, contentAndMarkersBefore);
		IMarker firstMarker = getFirstMarker(markers);
		applyQuickfixOnSingleMarkers(firstMarker);
		String contentAndMarkersAfter =
				"\"not bad doc\"\n" +
				"Foo { ref Bor }\n" +
				"<0<\"bad doc\">0>\n" +
				"Bor { }\n" +
				"-----\n" +
				"0: message=multiFixableIssue2\n";
		assertContentsAndMarkers(resource, contentAndMarkersAfter);
	}

	@Test
	public void testSimpleQuickAssist() throws Exception {
		String model =
				"\"bad doc\"\n" +
				"Foo { ref Bor }\n" +
				"\"bad doc\"\n" +
				"Bor { }\n";
		IFile resource = dslFile(model);
		XtextEditor editor = openEditor(resource);
		ICompletionProposal[] proposals = computeQuickAssistProposals(editor, 1);
		assertEquals("Multi fix 2".toString(),
				Joiner.on("\n").join(Lists.transform(Arrays.asList(proposals), ICompletionProposal::getDisplayString)));
		proposals[0].apply(editor.getDocument());
		String expectation =
				"\"not bad doc\"\n" +
				"Foo { ref Bor }\n" +
				"\"bad doc\"\n" +
				"Bor { }\n";
		assertEquals(expectation.toString(), editor.getDocument().get());
	}

	@Test
	public void testMultiFixMultipleMarkers() throws Exception {
		String model =
				"c {	badname { foo {} } }\n" +
				"a {	badname { bar {} } }\n" +
				"b {	badname { baz {} } }\n";
		IFile resource = dslFile(model);
		IMarker[] markers = getMarkers(resource);
		String contentAndMarkersBefore =
				"<0<c>0> {	badname { foo {} } }\n" +
				"<1<a>1> {	badname { bar {} } }\n" +
				"<2<b>2> {	badname { baz {} } }\n" +
				"-----\n" +
				"0: message=badNameInSubelements\n" +
				"1: message=badNameInSubelements\n" +
				"2: message=badNameInSubelements\n";
		assertContentsAndMarkers(resource, markers, contentAndMarkersBefore);
		applyQuickfixOnMultipleMarkers(markers);
		String contentAndMarkersAfter =
				"newElement { } c {	goodname { foo {} } }\n" +
				"newElement { } a {	goodname { bar {} } }\n" +
				"newElement { } b {	goodname { baz {} } }\n" +
				"-----\n" +
				"(no markers found)\n";
		assertContentsAndMarkers(resource, contentAndMarkersAfter);
	}

	@Test
	public void testMultiFixSingleMarker() throws Exception {
		String model =
				"c {	badname { foo {} } }\n" +
				"a {	badname { bar {} } }\n";
		IFile resource = dslFile(model);
		IMarker[] markers = getMarkers(resource);
		String contentAndMarkersBefore =
				"<0<c>0> {	badname { foo {} } }\n" +
				"<1<a>1> {	badname { bar {} } }\n" +
				"-----\n" +
				"0: message=badNameInSubelements\n" +
				"1: message=badNameInSubelements\n";
		assertContentsAndMarkers(resource, markers, contentAndMarkersBefore);
		IMarker firstMarker = getFirstMarker(markers);
		applyQuickfixOnSingleMarkers(firstMarker);
		String contentAndMarkersAfter =
				"newElement { } c {	goodname { foo {} } }\n" +
				"<0<a>0> {	badname { bar {} } }\n" +
				"-----\n" +
				"0: message=badNameInSubelements\n";
		assertContentsAndMarkers(resource, contentAndMarkersAfter);
	}

	@Test
	public void testMultiQuickAssist() throws Exception {
		String model =
				"c {	badname { foo {} } }\n" +
				"a {	badname { bar {} } }\n";
		IFile resource = dslFile(model);
		XtextEditor editor = openEditor(resource);
		ICompletionProposal[] proposals = computeQuickAssistProposals(editor, 1);
		assertEquals("Fix Bad Names".toString(),
				Joiner.on("\n").join(Lists.transform(Arrays.asList(proposals), ICompletionProposal::getDisplayString)));
		proposals[0].apply(editor.getDocument());
		String expectation =
				"newElement { } c {	goodname { foo {} } }\n" +
				"a {	badname { bar {} } }\n";
		assertEquals(expectation.toString(), editor.getDocument().get());
	}

	@Test
	public void testNoCrossRef() throws Exception {
		String model =
				"fixable_a {	ref fixable_b }\n" +
				"fixable_b {	ref fixable_a }\n";
		IFile resource = dslFile(model);
		XtextEditor editor = openEditor(resource);
		ICompletionProposal[] proposals = computeQuickAssistProposals(editor, 1);
		assertEquals("rename fixable".toString(),
				Joiner.on("\n").join(Lists.transform(Arrays.asList(proposals), ICompletionProposal::getDisplayString)));
		proposals[0].apply(editor.getDocument());
		String expectation =
				"fixedName {	ref fixable_b }\n" +
				"fixable_b {	ref fixable_a }\n";
		assertEquals(expectation.toString(), editor.getDocument().get());
	}

	@Test
	public void testTextualMultiModification() throws Exception {
		String model =
				"lowercase_a {}\n" +
				"lowercase_b {}\n" +
				"lowercase_c {}\n" +
				"lowercase_d {}\n" +
				"lowercase_e {}\n" +
				"lowercase_f {}\n";
		IFile resource = dslFile(model);
		XtextEditor xtextEditor = (XtextEditor) IDE.openEditor(AbstractWorkbenchTest.getActivePage(), resource);
		IMarker[] markers = getMarkers(resource);
		String contentAndMarkersBefore =
				"<0<lowercase_a>0> {}\n" +
				"<1<lowercase_b>1> {}\n" +
				"<2<lowercase_c>2> {}\n" +
				"<3<lowercase_d>3> {}\n" +
				"<4<lowercase_e>4> {}\n" +
				"<5<lowercase_f>5> {}\n" +
				"-----\n" +
				"0: message=lowercase\n" +
				"1: message=lowercase\n" +
				"2: message=lowercase\n" +
				"3: message=lowercase\n" +
				"4: message=lowercase\n" +
				"5: message=lowercase\n";
		assertContentsAndMarkers(resource, markers, contentAndMarkersBefore);
		applyQuickfixOnMultipleMarkers(markers);
		xtextEditor.doSave(null);
		String contentAndMarkersAfter =
				"LOWERCASE_A_LOWERCASE_A {}\n" +
				"LOWERCASE_B_LOWERCASE_B {}\n" +
				"LOWERCASE_C_LOWERCASE_C {}\n" +
				"LOWERCASE_D_LOWERCASE_D {}\n" +
				"LOWERCASE_E_LOWERCASE_E {}\n" +
				"LOWERCASE_F_LOWERCASE_F {}\n" +
				"-----\n" +
				"(no markers found)\n";
		assertContentsAndMarkers(resource, contentAndMarkersAfter);
	}
}
