/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractToggleOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.xtext.ui.Activator;

import com.google.inject.BindingAnnotation;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class HideReturnTypesContribution extends AbstractToggleOutlineContribution {

	@Retention(RUNTIME)
	@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
	@BindingAnnotation
	public @interface Annotation {}

	public static final String PREFERENCE_KEY = "ui.outline.showReturnTypes";
	
	private TreeViewer treeViewer;

	@Override
	protected void configureAction(Action action) {
		action.setText(Messages.HideReturnTypesAction_title);
		action.setToolTipText(Messages.HideReturnTypesAction_tooltip);
		action.setDescription(Messages.HideReturnTypesAction_description);
		action.setImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif")); 
		action.setDisabledImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif"));
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	protected void stateChanged(boolean newState) {
		if(treeViewer != null && !treeViewer.getTree().isDisposed())
			treeViewer.refresh(true);
	}
	
	@Override
	public void register(OutlinePage outlinePage) {
		super.register(outlinePage);
		this.treeViewer= outlinePage.getTreeViewer();
	}
	
	@Override
	public void deregister(OutlinePage outlinePage) {
		this.treeViewer = null;
		super.deregister(outlinePage);
	}
}