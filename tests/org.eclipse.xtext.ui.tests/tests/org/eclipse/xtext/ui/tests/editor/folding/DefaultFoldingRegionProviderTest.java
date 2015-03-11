/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.folding;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.tests.folding.Element;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultFoldingRegionProviderTest extends AbstractEditorTest {

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.FoldingTestLanguage";
	}

	@Test public void testGetFoldingRegions0() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage", "element foo element bar end element baz end end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(0, regions.size());
	}

	@SuppressWarnings("deprecation")
	protected DefaultFoldingRegionProvider createFoldingRegionProvider() {
		return new DefaultFoldingRegionProvider(new DefaultLocationInFileProvider());
	}

	@Test public void testGetFoldingRegions1() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage", "element foo \nelement bar end \nelement baz end end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
	}

	@Test public void testGetFoldingRegions2() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage", "element foo \nelement bar \nend \nelement baz end end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(2, regions.size());
	}

	@Test public void testGetFoldingRegions3() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"element foo \nelement \nbar end \nelement baz \nend end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(3, regions.size());
	}

	@Test public void testGetFoldingRegionsWithMlCommentInSameLine() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"/* */\n element foo \nelement bar end \nelement baz end end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
	}

	@Test public void testGetFoldingRegionsWithMlCommentStart() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"/**\n*/\n element foo \nelement bar end \nelement baz end end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(2, regions.size());
	}

	@Test public void testGetFoldingRegionsWithMlCommentEnd() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"element foo \nelement bar end \nelement baz end end\n/**\n*/");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(2, regions.size());
	}

	@Test public void testGetFoldingRegionsWithMlCommentBetween() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"element foo \nelement bar \n /**\n*/ \n end \nelement baz end end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(3, regions.size());
	}

	@Test public void testGetFoldingRegionsWithMutltipleMlComment() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"/**\n*/\n element foo \nelement bar \n/**\n*/\n end \nelement \n/**\n*/\n baz end \n/**\n*/\n end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(7, regions.size());
	}
	
	@Test public void testSignificantPartOfMlComment_01() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"\n/**\n *\n */\n element foo end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
		FoldedPosition position = Iterables.getOnlyElement(regions);
		assertEquals(1, position.getOffset());
		assertEquals("/**\n *\n */\n".length(), position.getLength());
		assertEquals(0, position.computeCaptionOffset(document));
		IRegion[] projectionRegions = position.computeProjectionRegions(document);
		assertEquals(1, projectionRegions.length);
		assertEquals("\n/**\n".length(), projectionRegions[0].getOffset());
		assertEquals(" *\n */\n".length(), projectionRegions[0].getLength());
	}
	
	@Test public void testSignificantPartOfMlComment_02() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"\n/** foo\n *\n */\n element foo end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
		FoldedPosition position = Iterables.getOnlyElement(regions);
		assertEquals(1, position.getOffset());
		assertEquals("/** foo\n *\n */\n".length(), position.getLength());
		assertEquals("/** ".length(), position.computeCaptionOffset(document));
		IRegion[] projectionRegions = position.computeProjectionRegions(document);
		assertEquals(1, projectionRegions.length);
		assertEquals("\n/** foo\n".length(), projectionRegions[0].getOffset());
		assertEquals(" *\n */\n".length(), projectionRegions[0].getLength());
	}
	
	@Test public void testSignificantPartOfMlComment_03() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"\n/**\n *\n * foo\n *\n */\n element foo end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
		FoldedPosition position = Iterables.getOnlyElement(regions);
		assertEquals(1, position.getOffset());
		assertEquals("/**\n *\n * foo\n *\n */\n".length(), position.getLength());
		assertEquals("/**\n *\n * ".length(), position.computeCaptionOffset(document));
		IRegion[] projectionRegions = position.computeProjectionRegions(document);
		assertEquals(2, projectionRegions.length);
		assertEquals("\n".length(), projectionRegions[0].getOffset());
		assertEquals("/**\n *\n".length(), projectionRegions[0].getLength());
		assertEquals("\n/**\n *\n * foo\n".length(), projectionRegions[1].getOffset());
		assertEquals(" *\n */\n".length(), projectionRegions[1].getLength());
	}
	
	@Test public void testSignificantPartOfMlComment_04() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"\n/**\n *\n * foo */\n element foo end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
		FoldedPosition position = Iterables.getOnlyElement(regions);
		assertEquals(1, position.getOffset());
		assertEquals("/**\n *\n * foo */\n".length(), position.getLength());
		assertEquals("/**\n *\n * ".length(), position.computeCaptionOffset(document));
		IRegion[] projectionRegions = position.computeProjectionRegions(document);
		assertEquals(1, projectionRegions.length);
		assertEquals("\n".length(), projectionRegions[0].getOffset());
		assertEquals("/**\n *\n".length(), projectionRegions[0].getLength());
	}
	
	@Test public void testSignificantPartOfModel_01() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"\n" +
				"element foo\n" +
				"end\n");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
		FoldedPosition position = Iterables.getOnlyElement(regions);
		assertEquals("\n".length(), position.getOffset());
		assertEquals("element foo\nend\n".length(), position.getLength());
		assertEquals("element ".length(), position.computeCaptionOffset(document));
		IRegion[] projectionRegions = position.computeProjectionRegions(document);
		assertEquals(1, projectionRegions.length);
		assertEquals("\nelement foo\n".length(), projectionRegions[0].getOffset());
		assertEquals("end\n".length(), projectionRegions[0].getLength());
	}
	
	@Test public void testSignificantPartOfModel_02() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"\n" +
				"element\n" +
				"  foo\n" +
				"end\n");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
		FoldedPosition position = Iterables.getOnlyElement(regions);
		assertEquals("\n".length(), position.getOffset());
		assertEquals("element\n  foo\nend\n".length(), position.getLength());
		assertEquals("element\n  ".length(), position.computeCaptionOffset(document));
		IRegion[] projectionRegions = position.computeProjectionRegions(document);
		assertEquals(2, projectionRegions.length);
		assertEquals("\n".length(), projectionRegions[0].getOffset());
		assertEquals("element\n".length(), projectionRegions[0].getLength());
		assertEquals("\nelement\n  foo\n".length(), projectionRegions[1].getOffset());
		assertEquals("end\n".length(), projectionRegions[1].getLength());
	}
	
	@Test public void testSignificantPartOfModel_03() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage",
				"\n" +
				"element\n" +
				"  foo end\n");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = createFoldingRegionProvider();
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
		FoldedPosition position = Iterables.getOnlyElement(regions);
		assertEquals("\n".length(), position.getOffset());
		assertEquals("element\n  foo end\n".length(), position.getLength());
		assertEquals("element\n  ".length(), position.computeCaptionOffset(document));
		IRegion[] projectionRegions = position.computeProjectionRegions(document);
		assertEquals(1, projectionRegions.length);
		assertEquals("\n".length(), projectionRegions[0].getOffset());
		assertEquals("element\n".length(), projectionRegions[0].getLength());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testShouldProcessContent() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage", 
				"element foo \n" +
				"element bar \n" +
				"end \n" +
				"end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = new DefaultFoldingRegionProvider(new DefaultLocationInFileProvider()) {
			@Override
			protected boolean shouldProcessContent(EObject object) {
				if (object instanceof Element) {
					return !"foo".equals(((Element) object).getName());
				}
				return super.shouldProcessContent(object);
			}
		};
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
		assertEquals(0, regions.iterator().next().getOffset());
	}

	@SuppressWarnings("deprecation")
	@Test public void testIsHandled() throws Exception {
		IFile iFile = createFile("foo/bar.foldingtestlanguage", 
				"element foo \n" +
				"element bar \n" +
				"end \n" +
				"end");
		IXtextDocument document = openFileAndReturnDocument(iFile);
		DefaultFoldingRegionProvider reg = new DefaultFoldingRegionProvider(new DefaultLocationInFileProvider()) {
			@Override
			protected boolean isHandled(EObject object) {
				if (object instanceof Element) {
					return !"foo".equals(((Element) object).getName());
				}
				return super.isHandled(object);
			}
		};
		Collection<FoldedPosition> regions = reg.getFoldingRegions(document);
		assertEquals(1, regions.size());
		assertEquals("element foo \n".length(), regions.iterator().next().getOffset());
	}
	
	protected IXtextDocument openFileAndReturnDocument(IFile iFile) throws Exception {
		XtextEditor editor = openEditor(iFile);
		IXtextDocument document = editor.getDocument();
		return document;
	}
}
