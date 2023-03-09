/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;

import com.google.inject.Inject;

/**
 * A utility class for testing the outline's tree of Xtext languages.
 * 
 * Example:
 * <pre>
 * &#64;RunWith(XtextRunner)
 * &#64;InjectWith(MyLanguageUiInjectorProvider) 
 * class OutlineTest extends AbstractOutlineTest {
 * 
 *	&#64;Test def void myTest() {
 *	  '''
 *	  	// DSL code
 *	  	Foo bla {
 *	  		Bar b
 *	  		Bar c
 *	  	}
 *	  '''.assertAllLabels('''
 *	  	bla
 *	  	  b
 *	  	  c
 *	  '''
 *	}
 *  }
 * </pre>
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Lorenzo Bettini - Adapted to be used for any DSL
 * 
 * @since 2.12
 */
public abstract class AbstractOutlineTest extends AbstractEditorTest {

	protected static int TAB_INDENT = 2;

	protected static String TEST_PROJECT = "test";

	protected IFile file;
	protected XtextEditor editor;
	protected IXtextDocument document;

	public String fileExtension;

	@Inject
	protected IOutlineTreeProvider treeProvider;

	@Inject
	public void setFileExtensionProvider(FileExtensionProvider extensionProvider) {
		fileExtension = extensionProvider.getPrimaryFileExtension();
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		createjavaProject(TEST_PROJECT);
	}

	protected IJavaProject createjavaProject(String projectName) throws CoreException {
		IJavaProject javaProject = createJavaProject(projectName);
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		return javaProject;
	}

	protected IOutlineNode getOutlineTree(CharSequence modelAsText)
			throws Exception {
		file = IResourcesSetupUtil.createFile(TEST_PROJECT + "/test."
				+ fileExtension, modelAsText.toString());
		editor = openEditor(file);
		document = editor.getDocument();
		return treeProvider.createRoot(document);
	}

	/**
	 * The root node of the outline of the passed program
	 * is expanded and a string representation of the tree is
	 * built where children are indented of TAB_INDENT number of tabs; this
	 * string representation is then compared with the expected representation.
	 * 
	 * @param modelAsText
	 * @param expected
	 * @throws Exception 
	 */
	protected void assertAllLabels(CharSequence modelAsText, CharSequence expected) throws Exception {
		assertAllLabels(getOutlineTree(modelAsText), expected);
	}

	/**
	 * The outline node is expanded and a string representation of the tree is
	 * built where children are indented of TAB_INDENT number of tabs; this
	 * string representation is then compared with the expected representation.
	 * 
	 * @param rootNode
	 * @param expected
	 */
	protected void assertAllLabels(IOutlineNode rootNode, CharSequence expected) {
		assertEquals(expected.toString().trim(),
				outlineStringRepresentation(rootNode).trim());
	}

	protected String outlineStringRepresentation(IOutlineNode node) {
		StringBuffer buffer = new StringBuffer();
		outlineStringRepresentation(node, buffer, 0);
		return buffer.toString();
	}

	protected void outlineStringRepresentation(IOutlineNode node,
			StringBuffer buffer, int tabs) {
		if (getNodeText(node) != "<unnamed>") {
			addToStringRepresentation(node, buffer, tabs);
			tabs += TAB_INDENT;
		}
		for (IOutlineNode child : node.getChildren()) {
			addToStringRepresentation(child, buffer, tabs);
			if (child.hasChildren()) {
				for (IOutlineNode child2 : child.getChildren()) {
					outlineStringRepresentation(child2, buffer, tabs + TAB_INDENT);
				}
			}
		}
	}

	protected void addToStringRepresentation(IOutlineNode node,
			StringBuffer buffer, int tabs) {
		indent(buffer, tabs);
		buffer.append(getNodeText(node) + System.getProperty("line.separator"));
	}

	protected String getNodeText(IOutlineNode node) {
		return node.getText().toString();
	}

	protected void indent(StringBuffer buffer, int tabs) {
		for (int i = 0; i < tabs; ++i) {
			buffer.append(" ");
		}
	}

}
