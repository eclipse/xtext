/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.codemining.ICodeMining;
import org.eclipse.jface.text.codemining.ICodeMiningProvider;
import org.eclipse.jface.text.codemining.LineHeaderCodeMining;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 * @since 2.23
 */
@Beta
public class AbstractCodeMiningTest extends AbstractEditorTest {

	@Inject
	protected FileExtensionProvider fileExtensionProvider;

	@Inject
	protected ICodeMiningProvider codeMiningProvider;

	/**
	 * Test that the expected code minings are present on a given DSL text.
	 *
	 * @param initialText
	 *            The initial DSL text.
	 * @param expected
	 *            The DSL text where the expected code minings are inserted on the right position.
	 */
	public void testCodeMining(CharSequence initialText, String expected) {
		// Given
		IFile dslFile = dslFile(initialText);
		// When
		XtextEditor editor = openEditor(dslFile);
		// Then
		codeMiningsArePresent(editor, expected);
	}

	@Override
	protected XtextEditor openEditor(IFile dslFile) {
		try {
			XtextEditor editor = super.openEditor(dslFile);
			assertNotNull(editor);
			return editor;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void codeMiningsArePresent(XtextEditor editor, String expected) {
		String actual = insertCodeMinings(editor);
		assertEquals(expected, actual);
	}

	protected String insertCodeMinings(XtextEditor editor) {
		ISourceViewer viewer = editor.getInternalSourceViewer();

		String text = editor.getDocument().get();
		StringBuilder sb = new StringBuilder();

		List<? extends ICodeMining> codeMinings;
		try {
			codeMinings = codeMiningProvider.provideCodeMinings(viewer, new NullProgressMonitor()).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}

		for (ICodeMining codeMining : codeMinings) {
			try {
				codeMining.resolve(viewer, new NullProgressMonitor()).get();
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
			assertTrue("CodeMining is not resolved!", codeMining.isResolved());
		}

		codeMinings.sort((ICodeMining cm1, ICodeMining cm2) -> cm1.getPosition().getOffset() - cm2.getPosition().getOffset());

		int currentOffset = 0;
		for (int i = 0; i < codeMinings.size(); i++) {

			ICodeMining codeMining = codeMinings.get(i);

			int codeMiningOffset = codeMining.getPosition().getOffset();

			List<ICodeMining> codeMiningsOnTheSameOffset = getCodeMiningsByOffset(codeMinings, codeMiningOffset);

			String codeMiningsText = getCodeMiningsText(codeMiningsOnTheSameOffset);

			sb.append(text.substring(currentOffset, codeMiningOffset) + codeMiningsText);

			currentOffset = codeMiningOffset;
			if (containsLineHeaderCodeMining(codeMiningsOnTheSameOffset)) {
				sb.append(System.lineSeparator());
				currentOffset--;
			}

			i = getLastCodeMiningOnOffset(codeMinings, codeMiningOffset);
		}

		sb.append(text.substring(currentOffset));
		return sb.toString();
	}

	protected List<ICodeMining> getCodeMiningsByOffset(List<? extends ICodeMining> codeMinings, int offset) {
		List<ICodeMining> result = new ArrayList<ICodeMining>();
		for (ICodeMining codeMining : codeMinings) {
			int codeMiningOffset = codeMining.getPosition().getOffset();
			if (codeMiningOffset == offset) {
				result.add(codeMining);
			}
		}
		return result;
	}

	protected String getCodeMiningsText(List<? extends ICodeMining> codeMinings) {
		StringBuilder result = new StringBuilder();

		int count = 0;
		for (ICodeMining codeMining : codeMinings) {
			String codeMiningLabel = codeMining.getLabel();
			if (codeMiningLabel != null) {
				if (count != 0) {
					result.append(" | ");
				}
				result.append(codeMiningLabel);
			}
			count++;
		}
		return result.toString();
	}

	protected boolean containsLineHeaderCodeMining(List<ICodeMining> codeMinings) {
		for (ICodeMining codeMining : codeMinings) {
			if (codeMining instanceof LineHeaderCodeMining) {
				return true;
			}
		}
		return false;
	}

	protected int getLastCodeMiningOnOffset(List<? extends ICodeMining> codeMinings, int offset) {
		int i = 0;
		for (; i < codeMinings.size(); i++) {
			ICodeMining codeMining = codeMinings.get(i);
			if (codeMining.getPosition().getOffset() > offset) {
				return i - 1;
			}
		}
		return codeMinings.size();
	}

	protected IFile dslFile(CharSequence content) {
		return dslFile(getProjectName(), getFileName(), getFileExtension(), content);
	}

	protected String getProjectName() {
		return "CodeMiningTestProject";
	}

	protected String getFileName() {
		return "codeMining";
	}

	protected String getFileExtension() {
		return fileExtensionProvider.getPrimaryFileExtension();
	}

}
