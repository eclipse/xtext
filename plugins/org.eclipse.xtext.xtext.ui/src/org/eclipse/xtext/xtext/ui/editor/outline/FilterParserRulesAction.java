/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterAction;
import org.eclipse.xtext.xtext.ui.Activator;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class FilterParserRulesAction extends AbstractFilterAction {

	public FilterParserRulesAction(XtextContentOutlinePage outlinePage) {
		super("Filter Parser Rules", outlinePage);
		setToolTipText("Show / hide parser rules");
		setDescription("Show / hide parser rules");
		setImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif"));
		setDisabledImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif"));
	}

	@Override
	protected String getToggleId() {
		return "ParserRulesFilter.isChecked";
	}
	
	@Override
	protected ViewerFilter createFilter() {
		return new ParserRulesOutlineFilter();
	}

}