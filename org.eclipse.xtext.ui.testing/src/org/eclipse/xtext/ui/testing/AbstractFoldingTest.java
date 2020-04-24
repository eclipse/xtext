/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.testing;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 * @since 2.19
 */
@Beta
public abstract class AbstractFoldingTest extends AbstractEditorTest {

	@Inject
	protected FileExtensionProvider fileExtensionProvider;

	@Inject
	protected IFoldingRegionProvider foldingRegionProvider;

	/**
	 * @return the special symbol indicating the beginning of a folding region.
	 */
	public String b() {
		return "[>";
	}

	/**
	 * @return the special symbol indicating the end of a folding region.
	 */
	public String e() {
		return "<]";
	}

	/**
	 * Test that the expected folding regions are present on a given DSL text.
	 * 
	 * @param charSequence
	 *            The DSL text where the expected folding regions are enclosed by the {@link #b() b} and {@link #e() e} symbols.
	 */
	public void testFoldingRegions(CharSequence charSequence) {
		IFile file = dslFile(getProjectName(), getFileName(), getFileExtension(), getContent(charSequence));
		foldingRegionsArePresent(openInEditor(file), charSequence);
	}

	protected String getProjectName() {
		return "FoldingTestProject";
	}

	protected String getFileName() {
		return "folding";
	}

	protected String getFileExtension() {
		return fileExtensionProvider.getPrimaryFileExtension();
	}

	protected String getContent(CharSequence text) {
		return text.toString().replace(b(), "").replace(e(), "");
	}

	protected IXtextDocument openInEditor(IFile dslFile) {
		try {
			IXtextDocument document = openEditor(dslFile).getDocument();
			assertNotNull(document);
			return document;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void foldingRegionsArePresent(IXtextDocument document, CharSequence expected) {
		assertEquals(expected.toString().trim(), insertFoldingRegionMarkers(document));
	}

	protected String insertFoldingRegionMarkers(IXtextDocument document) {
		if (document.getLength() == 0) { // The document is empty
			return null;
		}

		try {
			String lineSeparator = document.getLineDelimiter(0);
			if (lineSeparator == null) { // The document contains a single line
				lineSeparator = document.getLegalLineDelimiters()[0];
			}
			return insertFoldingRegionMarkers(document, lineSeparator);
		} catch (BadLocationException e) {
			throw new RuntimeException(e);
		}
	}

	protected String insertFoldingRegionMarkers(IXtextDocument document, String lineSeparator) {
		List<String> lines = Arrays.asList(document.get().split(lineSeparator));
		try {
			for (FoldedPosition foldingRegion : foldingRegionProvider.getFoldingRegions(document)) {
				// Insert the beginning folding region marker at the beginning of the corresponding line
				int startLine = document.getLineOfOffset(foldingRegion.offset);
				lines.set(startLine, b() + lines.get(startLine));

				// Insert the end folding region marker at the end of the corresponding line
				int endLine = document.getLineOfOffset(foldingRegion.offset + foldingRegion.length) - 1;
				lines.set(endLine, lines.get(endLine) + e());
			}
		} catch (BadLocationException e) {
			throw new RuntimeException(e);
		}
		return Joiner.on(lineSeparator).join(lines);
	}
}
