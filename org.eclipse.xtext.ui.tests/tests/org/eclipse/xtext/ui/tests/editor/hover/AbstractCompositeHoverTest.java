/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.hover;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.AbstractCompositeHover;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class AbstractCompositeHoverTest extends AbstractEditorTest {
	
	protected XtextEditor editor;
	protected IXtextDocument document;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		String modelAsText = "// file content doesn't matter";
		IFile file = IResourcesSetupUtil.createFile("test/test.testlanguage", modelAsText);
		editor = openEditor(file);
		document = editor.getDocument();
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		editor.close(false);
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.TestLanguage";
	}

	@SuppressWarnings("deprecation")
	@Test public void testNullHoverList () {
		AbstractCompositeHover hover = new AbstractCompositeHover() {

			@Override
			protected List<ITextHover> createHovers() {
				return null;
			}
		};
	
		assertEquals (null, hover.getHovers());
		assertNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 0));
		assertNull (hover.getHoverControlCreator());
		assertNull (hover.getHoverInfo(editor.getInternalSourceViewer(), new Region(0,0)));
		assertNull (hover.getHoverInfo2(editor.getInternalSourceViewer(), new Region(0,0)));
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testEmptyHoverList () {
		AbstractCompositeHover hover = new AbstractCompositeHover() {

			@Override
			protected List<ITextHover> createHovers() {
				List<ITextHover> hovers = Lists.newArrayList();
				return hovers;
			}
		};
	
		assertEquals (0, hover.getHovers().size());
		assertNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 0));
		assertNull (hover.getHoverControlCreator());
		assertNull (hover.getHoverInfo(editor.getInternalSourceViewer(), new Region(0,0)));
		assertNull (hover.getHoverInfo2(editor.getInternalSourceViewer(), new Region(0,0)));
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testSingleHover () {
		AbstractCompositeHover hover = new AbstractCompositeHover() {

			@Override
			protected List<ITextHover> createHovers() {
				List<ITextHover> hovers = Lists.newArrayList();
				hovers.add (new ITextHover() {
					
					@Override
					public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
						// TODO Auto-generated method stub
						if (offset==0)
							return new Region (offset, 0);
						return null;
					}
					
					@Override
					public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
						return "test";
					}
				});
				return hovers;
			}
		};
	
		assertEquals (1, hover.getHovers().size());
		assertNotNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 0));
		assertEquals ("test", hover.getHoverInfo(editor.getInternalSourceViewer(), new Region(0,0)));
		assertNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 5));
		assertNull (hover.getHoverInfo(editor.getInternalSourceViewer(), new Region(0,0)));
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testMultipleHovers () {
		final ITextHover hover1 = new ITextHover() {
			
			@Override
			public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
				// TODO Auto-generated method stub
				if (offset==0)
					return new Region (offset, 0);
				return null;
			}
			
			@Override
			public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
				return "hover1";
			}
		};
		final ITextHover hover2 = new ITextHover() {
			
			@Override
			public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
				// TODO Auto-generated method stub
				if (offset==1)
					return new Region (offset, 0);
				return null;
			}
			
			@Override
			public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
				return "hover2";
			}
		};
			
		AbstractCompositeHover hover = new AbstractCompositeHover() {
			@Override
			protected List<ITextHover> createHovers() {
				List<ITextHover> hovers = Lists.newArrayList();
				hovers.add (hover1);
				hovers.add (hover2);
				return hovers;
			}
		};
	
		assertEquals (2, hover.getHovers().size());
		assertNotNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 0));
		assertEquals ("hover1", hover.getHoverInfo(editor.getInternalSourceViewer(), new Region(0,0)));
		assertNotNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 1));
		assertEquals ("hover2", hover.getHoverInfo(editor.getInternalSourceViewer(), new Region(1,0)));
	}
	
	protected void activate(IWorkbenchPart part) {
		editor.getSite().getPage().activate(part);
	}


}
