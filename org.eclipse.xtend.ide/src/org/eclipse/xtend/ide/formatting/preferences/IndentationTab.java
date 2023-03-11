/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class IndentationTab extends AbstractModifyDialogTab {
	
	public IndentationTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		super(modifyListener, workingValues);
	}

	@Override
	protected String previewText() {
		return PreviewCode.defaultPreviewText();
	}

	@Override
	protected void doCreatePreferences(Composite composite, int numColumns) {
		Group generalGroup = createGroup(numColumns, composite, GENERAL_SETTINGS);
		createComboPref(generalGroup, numColumns, "Tab policy:", "indentation", new String[] { "\t", " " },
				new String[] { "Tabs only", "Spaces" });
		// we don't preferences for this anymore since it's taken form the general text editor preferences
//		createNumberPref(generalGroup, numColumns, "Indentation length:",
//				new XtendFormatterConfigKeys().getIndentationLength());
	}

}
