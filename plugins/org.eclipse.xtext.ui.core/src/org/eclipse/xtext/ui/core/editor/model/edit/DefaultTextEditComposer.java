/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model.edit;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.SerializerUtil;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DefaultTextEditComposer extends EContentAdapter implements ITextEditComposer {

	@Inject
	private SerializerUtil serializerUtil;

	private Resource resource;
	private int resourceSize;
	private boolean resourceChanged;

	private Collection<EObject> modifiedObjects = new LinkedHashSet<EObject>();

	private boolean recording = false;

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);

		if (!doRecord(notification))
			return;

		if (notification.getNotifier() instanceof EObject) {
			recordObjectModification((EObject) notification.getNotifier());
		}
		else if (notification.getNotifier() instanceof Resource) {
			recordResourceModification((Resource) notification.getNotifier());
		}
	}

	protected void recordObjectModification(EObject obj) {
		if (obj.eResource() == null || obj.eResource() != resource)
			getModifiedObjects().remove(obj);
		else
			getModifiedObjects().add(obj);
	}

	protected void recordResourceModification(Resource notifier) {
		resourceChanged = true;
	}

	protected Collection<EObject> getModifiedObjects() {
		return modifiedObjects;
	}

	protected boolean doRecord(Notification notification) {
		if (!recording || notification.isTouch())
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

	public void beginRecording(Resource newResource) {
		if (newResource != resource) {
			if (resource != null)
				resource.eAdapters().remove(this);
			newResource.eAdapters().add(this);
			resource = newResource;
		}
		if (resource.getContents().isEmpty()) {
			resourceSize = 0;
		}
		else {
			final EObject root = resource.getContents().get(0);
			resourceSize = NodeUtil.getNodeAdapter(root).getParserNode().getTotalLength();
		}
		recording = true;
	}

	public TextEdit endRecording() {
		recording = false;
		TextEdit textEdit = getTextEdit();

		getModifiedObjects().clear();
		resourceChanged = false;

		return textEdit;
	}

	public TextEdit getTextEdit() {
		TextEdit result = null;

		if (resourceChanged) {
			String text = resource.getContents().isEmpty() ? "" : serializerUtil.serialize(
					resource.getContents().get(0)).trim();
			result = new ReplaceEdit(0, resourceSize, text);
		}
		else {
			final Collection<EObject> modifiedObjects = getModifiedObjects();
			if (!modifiedObjects.isEmpty()) {
				List<TextEdit> edits = getObjectEdits();
				if (edits.size() == 1)
					result = edits.get(0);
				else {
					result = new MultiTextEdit();
					for (TextEdit edit : edits) {
						result.addChild(edit);
					}
				}
			}
		}

		return result;
	}

	private List<TextEdit> getObjectEdits() {
		final Collection<EObject> modifiedObjects = getModifiedObjects();
		Collection<EObject> topLevelObjects = EcoreUtil.filterDescendants(modifiedObjects);
		List<TextEdit> edits = Lists.newArrayList();

		for (EObject eObject : topLevelObjects) {
			NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(eObject);
			CompositeNode node = nodeAdapter.getParserNode();

			String text = serializerUtil.serialize(eObject, false);
			TextEdit edit = new ReplaceEdit(node.getOffset(), node.getLength(), text);
			edits.add(edit);
		}
		return edits;
	}

}