/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.ui.core.editor.AbstractEditorTest;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class OutlineViewTest extends AbstractEditorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		closeWelcomePage();
	}
	
	public void testOutlineAvailable() throws PartInitException {
		ContentOutline outlineView = (ContentOutline) getActivePage().showView(IPageLayout.ID_OUTLINE);
		String title = outlineView.getTitle();
		System.out.println(title);
	}

}
