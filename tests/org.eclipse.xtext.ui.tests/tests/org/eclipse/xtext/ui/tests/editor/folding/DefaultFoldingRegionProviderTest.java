/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.folding;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegion;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.tests.editor.AbstractEditorTest;
import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class DefaultFoldingRegionProviderTest extends AbstractEditorTest {

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.FoldingTestLanguage";
	}
	
	public void testGetFoldingRegions0() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage", "element foo element bar end element baz end end");
		XtextEditor editor = openEditor(iFile);
		IXtextDocument document = editor.getDocument();
		DefaultFoldingRegionProvider reg = new DefaultFoldingRegionProvider();
		List<IFoldingRegion> regions = reg.getFoldingRegions(document);
		assertEquals(0,regions.size());
	}
	public void testGetFoldingRegions1() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage", "element foo \nelement bar end \nelement baz end end");
		XtextEditor editor = openEditor(iFile);
		IXtextDocument document = editor.getDocument();
		DefaultFoldingRegionProvider reg = new DefaultFoldingRegionProvider();
		List<IFoldingRegion> regions = reg.getFoldingRegions(document);
		assertEquals(1,regions.size());
	}
	public void testGetFoldingRegions2() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage", "element foo \nelement bar \nend \nelement baz end end");
		XtextEditor editor = openEditor(iFile);
		IXtextDocument document = editor.getDocument();
		DefaultFoldingRegionProvider reg = new DefaultFoldingRegionProvider();
		List<IFoldingRegion> regions = reg.getFoldingRegions(document);
		assertEquals(2,regions.size());
	}
	public void testGetFoldingRegions3() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage", "element foo \nelement \nbar end \nelement baz \nend end");
		XtextEditor editor = openEditor(iFile);
		IXtextDocument document = editor.getDocument();
		DefaultFoldingRegionProvider reg = new DefaultFoldingRegionProvider();
		List<IFoldingRegion> regions = reg.getFoldingRegions(document);
		assertEquals(3,regions.size());
	}
}
