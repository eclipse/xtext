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
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.testing.AbstractMultiQuickfixTest;
import org.eclipse.xtext.ui.tests.quickfix.ui.tests.QuickfixCrossrefTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author dhuebner - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(QuickfixCrossrefTestLanguageUiInjectorProvider.class)
public class MultiQuickFixTest extends AbstractMultiQuickfixTest {
	@Test
	public void testFixMultipleMarkers() throws Exception {
		String model =
				"\"no doc\"\n" +
				"Foo { ref Bor }\n" +
				"\"no doc\" Bor { }\n";
		IFile resource = dslFile(model);
		IMarker[] markers = getMarkers(resource);
		String contentAndMarkersBefore =
				"<0<\"no doc\">0>\n" +
				"Foo { ref Bor }\n" +
				"<1<\"no doc\">1> Bor { }\n" +
				"-----\n" +
				"0: message=multiFixableIssue\n" +
				"1: message=multiFixableIssue\n";
		assertContentsAndMarkers(resource, markers, contentAndMarkersBefore);
		applyQuickfixOnMultipleMarkers(markers);
		String contentAndMarkersAfter =
				"\"Better documentation\"\n" +
				"Foo { ref Bor }\n" +
				"\"Better documentation\" Bor { }\n" +
				"-----\n" +
				"(no markers found)\n";
		assertContentsAndMarkers(resource, contentAndMarkersAfter);
	}

	@Test
	public void testFixSingleMarker() throws Exception {
		String model =
				"\"no doc\"\n" +
				"Foo { ref Bor }\n" +
				"\"no doc\" Bor { }\n";
		IFile resource = dslFile(model);
		IMarker[] markers = getMarkers(resource);
		String contentAndMarkersBefore =
				"<0<\"no doc\">0>\n" +
				"Foo { ref Bor }\n" +
				"<1<\"no doc\">1> Bor { }\n" +
				"-----\n" +
				"0: message=multiFixableIssue\n" +
				"1: message=multiFixableIssue\n";
		assertContentsAndMarkers(resource, markers, contentAndMarkersBefore);
		IMarker firstMarker = getFirstMarker(markers);
		applyQuickfixOnSingleMarkers(firstMarker);
		String contentAndMarkersAfter =
				"\"Better documentation\"\n" +
				"Foo { ref Bor }\n" +
				"<0<\"no doc\">0> Bor { }\n" +
				"-----\n" +
				"0: message=multiFixableIssue\n";
		assertContentsAndMarkers(resource, contentAndMarkersAfter);
	}

	@Test
	public void testQuickAssist() throws Exception {
		String model = 
				"\n" +
				"\"no doc\"\n" +
				"Foo { ref Bor }\n" +
				"\"no doc\" Bor { }\n";
		IFile dslFile = dslFile(model);
		XtextEditor editor = openEditor(dslFile);
		ICompletionProposal[] proposals = computeQuickAssistProposals(editor, 1);
		assertEquals("Multi fix".toString(),
				Joiner.on("\n").join(Lists.transform(Arrays.asList(proposals), ICompletionProposal::getDisplayString)));
		proposals[0].apply(editor.getDocument());
		String expectation =
				"\n" +
				"\"Better documentation\"\n" +
				"Foo { ref Bor }\n" +
				"\"no doc\" Bor { }\n";
		assertEquals(expectation.toString(), editor.getDocument().get());
	}
}
