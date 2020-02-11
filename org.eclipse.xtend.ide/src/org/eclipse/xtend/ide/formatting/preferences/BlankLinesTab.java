/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import static org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys.*;

import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class BlankLinesTab extends AbstractModifyDialogTab {

	public BlankLinesTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		super(modifyListener, workingValues);
	}

	@Override
	protected String previewText() {
		return PreviewCode.lineWrappingPreviewText();
	}

	@Override
	protected void doCreatePreferences(Composite composite, int col) {

		Group cuGroup = createGroup(col, composite, "Blank lines in compilation unit");
		createNumberPref(cuGroup, col, "After package declaration:", blankLinesAfterPackageDecl);
		createNumberPref(cuGroup, col, "Between imports:", blankLinesBetweenImports);
		createNumberPref(cuGroup, col, "After import declaration:", blankLinesAfterImports);
		createNumberPref(cuGroup, col, "Between class declarations:", blankLinesBetweenClasses);
		
		Group cdGr = createGroup(col, composite, "Blank lines within type declarations");
			
		createNumberPref(cdGr, col, "Before first declaration:", blankLinesBeforeFirstMember);
		createNumberPref(cdGr, col, "After last member declaration:", blankLinesAfterLastMember);
		createNumberPref(cdGr, col, "Between fields:", blankLinesBetweenFields);
		createNumberPref(cdGr, col, "Between fields and methods:", blankLinesBetweenFieldsAndMethods);
		createNumberPref(cdGr, col, "Between methods:", blankLinesBetweenMethods);
		createNumberPref(cdGr, col, "Between enum literals:", blankLinesBetweenEnumLiterals);
		
		Group methodGroup = createGroup(col, composite, "Blank lines in method declarations");
		createCheckboxPref(methodGroup, col, "Keep simple methods on one line", keepOneLineMethods);
		
		Group eblGroup = createGroup(col, composite, "Existing blank lines");
		createNumberPref(eblGroup, col, "Number of empty lines to preserve:", preserveBlankLines);

	}
}
