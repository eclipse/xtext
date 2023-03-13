/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.preferences;

import static org.eclipse.xtend.ide.swtbot.EclipseAPI.*;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.xtend.ide.swtbot.api.preferences.PreferencesDialogAPI;
import org.eclipse.xtend.ide.swtbot.api.preferences.XtendFormatterPreferenceEditDialogAPI;
import org.eclipse.xtend.ide.tests.AbstractSwtBotTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests for the formatter preference page.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class FormatterPreferencesTest extends AbstractSwtBotTest {

	@Before
	public void setUp() {
		closeAllShells();
	}

	@After
	public void tearDown() {
		closeAllShells();
	}

	@Test
	public void formatterPreferencesEditDialog_CanBeOpenedAndAllSectionsExist() throws Exception {
		PreferencesDialogAPI preferenceDialog = mainMenu().openPreferences();

		XtendFormatterPreferenceEditDialogAPI editDialog = preferenceDialog.activateXtendFormatterPage().openEditDialog();
		editDialog.activateBracesSection();
		editDialog.activateWhiteSpaceSection();
		editDialog.activateBlankLinesSection();
		editDialog.activateNewLinesSection();
		editDialog.activateLineWrappingSection();
		editDialog.cancel();

		preferenceDialog.cancel();
	}

}
