/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.xtext.ui.Activator;

import com.google.inject.BindingAnnotation;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FilterTerminalRulesContribution extends AbstractFilterOutlineContribution {

	@Retention(RUNTIME)
	@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
	@BindingAnnotation
	public @interface Annotation {}

	public static final String PREFERENCE_KEY = "ui.outline.filterTerminalRules"; 
	
	@Override
	protected boolean apply(IOutlineNode node) {
		return !(node instanceof EObjectNode) 
			|| !((EObjectNode)node).getEClass().equals(XtextPackage.Literals.TERMINAL_RULE) ;
	}
	
	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	protected void configureAction(Action action) {
		action.setText(Messages.FilterTerminalRulesContribution_title);
		action.setDescription(Messages.FilterTerminalRulesContribution_description);
		action.setToolTipText(Messages.FilterTerminalRulesContribution_tooltip);
		action.setImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif"));  
		action.setDisabledImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif"));
	}
}
