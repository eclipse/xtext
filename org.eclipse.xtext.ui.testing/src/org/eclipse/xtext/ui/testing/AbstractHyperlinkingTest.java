/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.testing;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.17
 */
public abstract class AbstractHyperlinkingTest extends AbstractEditorTest {

	@Inject
	protected IHyperlinkHelper hyperlinkHelper;

	@Inject
	protected FileExtensionProvider fileExtensionProvider;

	@Inject
	protected IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	protected IResourceSetProvider resourceSetProvider;

	/**
	 * @since 2.19
	 */
	@Inject
	protected XtextDocumentUtil xtextDocumentUtil;

	protected IProject project;

	// Position marker
	protected String c = "<|>";

	/**
	 * Tests that the user can navigate to the target element in a DSL text when activating the hyperlink on a certain region.
	 * 
	 * @param charSequence
	 *            The DSL text. The text must contain the {@link #c} special symbols twice indicating the beginning and the end of the
	 *            region where the hyperlink navigation gets activated.
	 * @param hyperlinkTarget
	 *            The fully qualified name of the expected target element.
	 */
	public void hasHyperlinkTo(CharSequence charSequence, String hyperlinkTarget) {
		hasHyperlinkTo(charSequence, hyperlinkRegion(charSequence), hyperlinkTarget);
	}

	/**
	 * Tests that the user can navigate to the target element in a DSL text when activating the hyperlink on a certain region.
	 * 
	 * @param charSequence
	 *            The initial DSL text.
	 * @param hyperlinkRegion
	 *            The region where the hyperlink navigation gets activated.
	 * @param hyperlinkTarget
	 *            The fully qualified name of the expected target element.
	 */
	public void hasHyperlinkTo(CharSequence charSequence, IRegion hyperlinkRegion, String hyperlinkTarget) {
		IHyperlink[] hyperlinks = hyperlinkingOn(dslFile(charSequence), hyperlinkRegion.getOffset());
		hyperlinkIsOffered(hyperlinks, hyperlinkRegion, hyperlinkTarget);
	}

	protected IFile dslFile(CharSequence text) {
		String content = text.toString().replace(c, "");
		return super.dslFile(getProjectName(), getFileName(), getFileExtension(), content);
	}

	protected IHyperlink[] hyperlinkingOn(IFile dslFile, int offset) {
		XtextEditor editor = openInEditor(dslFile);
		IXtextDocument document = xtextDocumentUtil.getXtextDocument(editor.getInternalSourceViewer());
		XtextResource resource = document.readOnly((state) -> state);
		return hyperlinkHelper.createHyperlinksByOffset(resource, offset, true);
	}

	protected XtextEditor openInEditor(IFile dslFile) {
		// Wait for the cross-reference resolution
		IResourcesSetupUtil.waitForBuild();
		try {
			return openEditor(dslFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void hyperlinkIsOffered(IHyperlink[] hyperlinks, IRegion expectedRegion, String expectedHyperlinkTarget) {
		assertNotNull("No hyperlinks found!", hyperlinks);
		assertEquals(1, hyperlinks.length);

		IHyperlink hyperlink = hyperlinks[0];
		assertEquals(expectedRegion, hyperlink.getHyperlinkRegion());
		assertEquals(expectedHyperlinkTarget, target(hyperlink));
	}

	protected String target(IHyperlink hyperlink) {
		if (hyperlink instanceof JdtHyperlink) {
			return _target((JdtHyperlink) hyperlink);
		} else if (hyperlink instanceof XtextHyperlink) {
			return _target((XtextHyperlink) hyperlink);
		} else {
			return _target(hyperlink);
		}
	}

	protected String _target(JdtHyperlink hyperlink) {
		IJavaElement javaElement = hyperlink.getJavaElement();
		assertTrue(javaElement instanceof IType);
		return ((IType) javaElement).getFullyQualifiedName();
	}

	protected String _target(XtextHyperlink hyperlink) {
		ResourceSet resourceSet = resourceSetProvider.get(project);
		EObject eObject = resourceSet.getEObject(hyperlink.getURI(), true);
		return qualifiedNameProvider.getFullyQualifiedName(eObject).toString();
	}

	protected String _target(IHyperlink hyperlink) {
		fail("Unsupported hyperlink " + hyperlink.getClass());
		return null;
	}

	protected String getProjectName() {
		return "HyperlinkingTestProject";
	}

	protected String getFileName() {
		return "hyperlinking";
	}

	protected String getFileExtension() {
		return fileExtensionProvider.getPrimaryFileExtension();
	}

	protected IRegion hyperlinkRegion(CharSequence input) {
		String text = input.toString();
		int first = text.indexOf(c);
		if (first == -1) {
			fail("Can't locate the first position symbol '" + c + "' in the input text");
		}

		int second = text.lastIndexOf(c);
		if (first == second) {
			fail("Can't locate the second position symbol '" + c + "' in the input text");
		}

		int offset = first;
		int length = second - first - c.length();
		return new Region(offset, length);
	}

}
