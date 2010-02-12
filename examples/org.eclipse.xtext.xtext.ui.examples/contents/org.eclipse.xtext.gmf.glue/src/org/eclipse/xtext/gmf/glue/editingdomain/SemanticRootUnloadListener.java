/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.editingdomain;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * Reloads the semantic root element (the element of the diagram) on changes and refreshes the diagram. GMF does by
 * default not listen to such events which can occur in an {@link XtextResource}, if the document changes close to the
 * root element.
 * 
 * Activate an instance of this in the {@link EditPart#activate()} method of the {@link DiagramEditPart}.
 * 
 * @author koehnlein
 */
public class SemanticRootUnloadListener implements ResourceSetListener {

	private DiagramEditPart rootEditPart;
	private EObject semanticRootElement;

	public SemanticRootUnloadListener(DiagramEditPart rootEditPart) {
		this.rootEditPart = rootEditPart;
		this.semanticRootElement = rootEditPart.resolveSemanticElement();
	}

	public void activate() {
		rootEditPart.getEditingDomain().addResourceSetListener(this);
	}

	public void deactivate() {
		rootEditPart.getEditingDomain().removeResourceSetListener(this);
	}

	public NotificationFilter getFilter() {
		return new NotificationFilter.Custom() {
			@Override
			public boolean matches(Notification notification) {
				int featureID = notification.getFeatureID(Resource.class);
				Object notifier = notification.getNotifier();
				int eventType = notification.getEventType();
				return notification.getOldValue() == semanticRootElement && featureID == Resource.RESOURCE__CONTENTS
						&& (eventType == Notification.REMOVE || eventType == Notification.SET)
						&& notifier instanceof Resource;
			}
		};
	}

	public boolean isAggregatePrecommitListener() {
		return false;
	}

	public boolean isPostcommitOnly() {
		return true;
	}

	public boolean isPrecommitOnly() {
		return false;
	}

	public void resourceSetChanged(ResourceSetChangeEvent event) {
		semanticRootElement = rootEditPart.resolveSemanticElement();
		rootEditPart.refresh();
	}

	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		return null;
	}

}
