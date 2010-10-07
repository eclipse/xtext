/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.editingdomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Sets;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @author Jan Koehnlein
 */
public class ChangeAggregatorAdapter extends EContentAdapter {

	private Set<XtextResource> changedResources = Sets.newHashSet();
	
	private boolean isRecording = false;

	private boolean isSuspended = false;

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);

		if (!doRecord(notification))
			return;

		if (notification.getNotifier() instanceof EObject) {
			recordObjectModification((EObject) notification.getNotifier());
		}
	}

	protected void recordObjectModification(EObject obj) {
		Resource resource = obj.eResource();
		if (resource instanceof XtextResource) {
			changedResources.add((XtextResource) resource);
		}
	}

	protected boolean doRecord(Notification notification) {
		if (!isRecording || isSuspended || notification.isTouch())
			return false;

		switch (notification.getEventType()) {
			case Notification.ADD:
			case Notification.ADD_MANY:
			case Notification.MOVE:
			case Notification.REMOVE:
			case Notification.REMOVE_MANY:
			case Notification.SET:
			case Notification.UNSET:
				return true;
			default:
				return false;
		}
	}

	private void reset() {
		changedResources.clear();
	}

	public void beginRecording() {
		reset();
		isRecording = true;
	}

	public void endRecording() {
		isRecording = false;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public List<EObject> getModificationRoots() {
		List<EObject> modificationRoots = new ArrayList<EObject>();
		for(XtextResource resource : changedResources) {
			if(!resource.getContents().isEmpty())
				modificationRoots.add(resource.getContents().get(0));
		}
		return modificationRoots;
	}

	/**
	 * Only attach to XtextResources
	 */
	@Override
	protected void setTarget(Resource target) {
		if (target instanceof XtextResource) {
			super.setTarget(target);
		}
	}

	@Override
	protected void setTarget(EObject target) {
		if (target.eResource() instanceof XtextResource) {
			super.setTarget(target);
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ChangeAggregatorAdapter.class;
	}

}