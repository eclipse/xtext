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

import static org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys.*;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class NewLineTab extends AbstractModifyDialogTab {

	public NewLineTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		super(modifyListener, workingValues);
	}

	@Override
	protected String previewText() {
		return PreviewCode.newLinePreviewText();
	}

	@Override
	protected void doCreatePreferences(Composite composite, int col) {
		//		Group generalGroup = createGroup(col, composite, "Expressions");
		//		createCheckboxPref(generalGroup, col, "Around expressions", xtendFormatterConfig.newLineAroundExpression);

		Group annoGr = createGroup(col, composite, "Annotations");
		createCheckboxPref(annoGr, col, "Insert new line after annotations on types", newLineAfterClassAnnotations);
		createCheckboxPref(annoGr, col, "Insert new line after annotations on fields", newLineAfterFieldAnnotations);
		createCheckboxPref(annoGr, col, "Insert new line after annotations on constructors", newLineAfterConstructorAnnotations);
		createCheckboxPref(annoGr, col, "Insert new line after annotations on methods", newLineAfterMethodAnnotations);
		createCheckboxPref(annoGr, col, "Insert new line after annotations on parameters", newLineAfterParameterAnnotations);
		createCheckboxPref(annoGr, col, "Preserve new lines", preserveNewLines);

	}
}
