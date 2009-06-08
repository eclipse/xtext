/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.actions;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;

/**
 * @author Peter Friese - Initial contribution and API
 */
public abstract class AbstractFilterAction extends AbstractOutlineAction {

	public AbstractFilterAction(String text, XtextContentOutlinePage outlinePage) {
		super(text, outlinePage);
	}

	private ViewerFilter filter;

	@Override
	protected String getToggleId() {
		return "ParserRulesFilter.isChecked";
	}
	
	protected ViewerFilter getFilter() {
		if (filter == null) {
			filter = createFilter();
		}
		return filter;
	}
	
	protected abstract ViewerFilter createFilter();
	
	@Override
	protected void performAction(boolean checkedState) {
		if (checkedState) {
			getOutlinePage().enableFilter(getFilter());
		}
		else {
			getOutlinePage().disableFilter(getFilter());
		}
	}

}