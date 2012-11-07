/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class NewLineTab extends AbstractModifyDialogTab {

	public NewLineTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		super(modifyListener, workingValues);
	}

	@Override
	protected String previewText() {
		return PreviewCode.lineWrappingPreviewText();
	}

	@Override
	protected void doCreatePreferences(Composite composite, int numColumns) {
		Group generalGroup = createGroup(numColumns, composite, "Insert new line");
		XtendFormatterConfigKeys xtendFormatterConfig = new XtendFormatterConfigKeys();
		createMinMaxPref(generalGroup, numColumns, "After package name (min/max):", xtendFormatterConfig.newLinesAfterPackageName);
		createMinMaxPref(generalGroup, numColumns, "Between imports (min/max):", xtendFormatterConfig.newLinesBetweenImports);
		createMinMaxPref(generalGroup, numColumns, "After import section (min/max):", xtendFormatterConfig.newLinesAfterImportSection);
		createMinMaxPref(generalGroup, numColumns, "Before first member (min/max):", xtendFormatterConfig.newLinesBeforeFirstMember);
		createMinMaxPref(generalGroup, numColumns, "After last member (min/max):", xtendFormatterConfig.newLinesAfterLastMember);
		createMinMaxPref(generalGroup, numColumns, "Between fields (min/max):", xtendFormatterConfig.newLinesBetweenFields);
		createMinMaxPref(generalGroup, numColumns, "Between fields and methods (min/max):", xtendFormatterConfig.newLinesBetweenFieldsAndMethods);
		createMinMaxPref(generalGroup, numColumns, "Between methods (min/max):", xtendFormatterConfig.newLinesBetweenMethods);
		createMinMaxPref(generalGroup, numColumns, "Between classes (min/max):", xtendFormatterConfig.newLinesBetweenClasses);
		createMinMaxPref(generalGroup, numColumns, "Around expressions (min/max):", xtendFormatterConfig.newLinesAroundExpression);
		createMinMaxPref(generalGroup, numColumns, "After aannotations (min/max):", xtendFormatterConfig.newLinesAfterAnnotations);
	}
}
