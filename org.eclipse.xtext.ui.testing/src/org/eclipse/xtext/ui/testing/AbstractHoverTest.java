/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.testing;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.16
 */
@SuppressWarnings("restriction")
public abstract class AbstractHoverTest extends AbstractEditorTest {

	@Inject
	protected IEObjectHover eObjectHover;

	@Inject
	protected FileExtensionProvider fileExtensionProvider;

	/**
	 * Test that the expected text appears in a popup window while hovering over a specific text in a given DSL text.
	 * 
	 * @param charSequence
	 *            the initial DSL text.
	 * @param hoverText
	 *            the text you are hovering over.
	 * @param hoverContent
	 *            the text that is expected to be part of the hover popup.
	 */
	public void hasHoverOver(CharSequence charSequence, String hoverText, String hoverContent) {
		Region region = new Region(charSequence.toString().indexOf(hoverText), hoverText.length());
		hasHoverOver(charSequence, region, hoverContent);
	}

	/**
	 * Test that the expected text appears in a popup window while hovering over a specific region in a given DSL text.
	 * 
	 * @param charSequence
	 *            the initial DSL text.
	 * @param hoverRegion
	 *            the region you are hovering over.
	 * @param hoverContent
	 *            the text that is expected to be part of the hover popup.
	 */
	public void hasHoverOver(CharSequence charSequence, IRegion hoverRegion, String hoverContent) {
		IFile file = dslFile(getProjectName(), getFileName(), getFileExtension(), charSequence);
		hoverPopupHasContent(hoveringOver(file, hoverRegion), hoverContent);
	}

	protected String getProjectName() {
		return "HoverTestProject";
	}

	protected String getFileName() {
		return "hover";
	}

	protected String getFileExtension() {
		return fileExtensionProvider.getPrimaryFileExtension();
	}

	protected XtextEditor openInEditor(IFile dslFile) {
		try {
			IResourcesSetupUtil.waitForBuild(new NullProgressMonitor());
			return openEditor(dslFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected BrowserInformationControlInput hoveringOver(IFile dslFile, IRegion hoverRegion) {
		XtextEditor editor = openInEditor(dslFile);
		Object hoverInfo = ((ITextHoverExtension2) eObjectHover).getHoverInfo2(editor.getInternalSourceViewer(), hoverRegion);
		return (BrowserInformationControlInput) hoverInfo;
	}

	protected void hoverPopupHasContent(BrowserInformationControlInput info, String expectedHoverContent) {
		assertNotNull("No hover found!", info);

		String actualHoverContent = info.getHtml();
		String message = "Could not find the text '%s' in the hover popup:\n%s\n";
		assertTrue(String.format(message, expectedHoverContent, actualHoverContent), actualHoverContent.contains(expectedHoverContent));
	}
}
