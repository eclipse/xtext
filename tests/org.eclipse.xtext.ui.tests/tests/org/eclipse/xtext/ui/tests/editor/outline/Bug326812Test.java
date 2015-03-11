/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.outline.actions.LinkWithEditorOutlineContribution;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Bug326812Test extends AbstractOutlineWorkbenchTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		preferenceStore.setValue(LinkWithEditorOutlineContribution.PREFERENCE_KEY, true);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		preferenceStore.setValue(LinkWithEditorOutlineContribution.PREFERENCE_KEY,
				preferenceStore.getDefaultBoolean(LinkWithEditorOutlineContribution.PREFERENCE_KEY));
	}

	@Test public void testCloseTwoEditorsForSameLanguage() throws Exception {
		modelAsText = "one { two {} three {} } four {}";
		IFile file = IResourcesSetupUtil.createFile("test/othertest.outlinetestlanguage", modelAsText);
		openEditor(file);
		IWorkbenchPage page = editor.getSite().getPage();
		page.closeAllEditors(false);
		assertFalse(CustomOutlineWithEditorLinker.DEACTIVATE_CALLED_WITH_NULL_TEXT_LISTENER);
	}

}
