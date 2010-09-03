/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterAction;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.xtext.ui.Activator;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class FilterParserRulesAction extends AbstractFilterAction {

	public FilterParserRulesAction() {
		setText(Messages.FilterParserRulesAction_title);
		setToolTipText(Messages.FilterParserRulesAction_tooltip);
		setDescription(Messages.FilterParserRulesAction_description);
		setImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif")); //$NON-NLS-1$
		setDisabledImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif")); //$NON-NLS-1$
	}

	@Override
	protected ViewerFilter createViewerFilter() {
		return new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if ((parentElement != null) && (parentElement instanceof EObjectNode)) {
					EObjectNode parentNode = (EObjectNode) parentElement;
					EClass eClass = parentNode.getEClass();
					if (eClass != null && eClass.equals(XtextPackage.Literals.PARSER_RULE)) {
						return false;
					}
				}
				return true;
			}
		};
	}

	@Override
	protected String getPropertyKey() {
		return "ui.outline.parserRules";
	}

}