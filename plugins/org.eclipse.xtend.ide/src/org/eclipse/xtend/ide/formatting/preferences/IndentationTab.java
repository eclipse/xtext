/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * @author dhuebner - Initial contribution and API
 */
public class IndentationTab extends AbstractModifyDialogTab {

	public IndentationTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		super(modifyListener, workingValues);
	}

	@Override
	protected void initializePage() {
		// TODO Set preview Text
	}

	@Override
	protected void doCreatePreferences(Composite composite, int numColumns) {
		final Group generalGroup = createGroup(numColumns, composite, "General");

		final String[] tabPolicyValues = new String[] { JavaCore.SPACE, JavaCore.TAB,
				DefaultCodeFormatterConstants.MIXED };
		final String[] tabPolicyLabels = new String[] { "Space", "Tab", "Mixed" };
		createComboPref(generalGroup, numColumns, "Tab policy", DefaultCodeFormatterConstants.FORMATTER_TAB_CHAR,
				tabPolicyValues, tabPolicyLabels);
		createNumberPref(generalGroup, numColumns, "Indent size", DefaultCodeFormatterConstants.FORMATTER_TAB_SIZE, 0,
				32);

	}

	@Override
	protected void doUpdatePreview() {
		// TODO get preview, do update/refresh
	}

}
