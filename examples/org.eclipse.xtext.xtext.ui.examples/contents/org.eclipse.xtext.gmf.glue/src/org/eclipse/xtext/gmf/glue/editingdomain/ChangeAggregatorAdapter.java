/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.editingdomain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Lists;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @author Jan Koehnlein
 */
public class ChangeAggregatorAdapter extends EContentAdapter {

	private Collection<EObject> modifiedObjects = new LinkedHashSet<EObject>();

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
		if (obj.eResource() == null
				|| false == obj.eResource() instanceof XtextResource)
			modifiedObjects.remove(obj);
		else
			modifiedObjects.add(obj);
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
		modifiedObjects.clear();
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
		Map<Resource, List<EObject>> resource2ChangePathMap = new HashMap<Resource, List<EObject>>();
		for (EObject eObject : modifiedObjects) {
			if (!eObject.eIsProxy()) {
				Resource resource = eObject.eResource();
				List<EObject> resourceChangePath = resource2ChangePathMap
						.get(resource);
				if (resourceChangePath == null) {
					resourceChangePath = allContainers(eObject);
					resource2ChangePathMap.put(resource, resourceChangePath);
				} else {
					resourceChangePath.retainAll(allContainers(eObject));
				}
			}
		}
		List<EObject> modificationRoots = new ArrayList<EObject>(
				resource2ChangePathMap.size());
		for (List<EObject> changePath : resource2ChangePathMap.values()) {
			if (!changePath.isEmpty()) {
				modificationRoots.add(changePath.get(changePath.size() - 1));
			}
		}
		return modificationRoots;
	}

	private LinkedList<EObject> allContainers(EObject eObject) {
		final LinkedList<EObject> allContainers = Lists.newLinkedList();
		allContainers.add(eObject);
		EObject currentContainer = eObject.eContainer();
		final Resource resource = eObject.eResource();
		while (currentContainer != null
				&& resource == currentContainer.eResource()) {
			allContainers.addFirst(currentContainer);
			currentContainer = currentContainer.eContainer();
		}
		return allContainers;
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