/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.NonRecursiveEContentAdapter;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @author Jan Koehnlein
 */
public class DefaultTextEditComposer extends NonRecursiveEContentAdapter implements ITextEditComposer {

	@Inject
	private ISerializer serializer;

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
		} else if (notification.getNotifier() instanceof Resource) {
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

	protected void reset() {
		getModifiedObjects().clear();
		resourceChanged = false;
	}

	@Override
	public void beginRecording(Resource newResource) {
		reset();

		if (newResource != resource) {
			if (resource != null)
				resource.eAdapters().remove(this);
			newResource.eAdapters().add(this);
			resource = newResource;
		}
		if (resource.getContents().isEmpty()) {
			resourceSize = 0;
		} else {
			final EObject root = resource.getContents().get(0);
			ICompositeNode rootNode = NodeModelUtils.getNode(root);
			if (rootNode == null) {
				throw new IllegalStateException("Cannot find root node in resource " + resource.getURI());
			}
			resourceSize = rootNode.getTotalLength();
		}
		recording = true;
	}

	@Override
	public TextEdit endRecording() {
		recording = false;
		TextEdit textEdit = getTextEdit();

		reset();
		return textEdit;
	}

	@Override
	public TextEdit getTextEdit() {
		TextEdit result = null;

		if (resourceChanged) {
			String text = resource.getContents().isEmpty() ? "" : serializer.serialize(
					resource.getContents().get(0));
			result = new ReplaceEdit(0, resourceSize, text);
		} else {
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

	protected List<TextEdit> getObjectEdits() {
		final Collection<EObject> modifiedObjects = getModifiedObjects();
		Collection<EObject> topLevelObjects = EcoreUtil.filterDescendants(modifiedObjects);
		Iterable<EObject> containedModifiedObjects = Collections.emptyList();
		if (!resource.getContents().isEmpty()) {
			final EObject root = resource.getContents().get(0);
			containedModifiedObjects = Iterables.filter(topLevelObjects, new Predicate<EObject>() {
				@Override
				public boolean apply(EObject input) {
					return EcoreUtil.isAncestor(root, input);
				}
			});
		}
		List<TextEdit> edits = Lists.newArrayListWithExpectedSize(Iterables.size(containedModifiedObjects));
		for (EObject modifiedObject : containedModifiedObjects) {
			ReplaceRegion replaceRegion = serializer.serializeReplacement(modifiedObject, getSaveOptions());
			TextEdit edit = new ReplaceEdit(replaceRegion.getOffset(), replaceRegion.getLength(), replaceRegion.getText());
			edits.add(edit);
		}
		return edits;
	}

	protected SaveOptions getSaveOptions() {
		return SaveOptions.defaultOptions();
	}

	/**
	 * @deprecated use {@link #setSerializer(ISerializer)} instead.
	 */
	@Deprecated
	public void setSerializerUtil(ISerializer serializer) {
		setSerializer(serializer);
	}
	
	/**
	 * If used in a non-Guice environment, we need to be able to set this.
	 * @since 2.0
	 */
	public void setSerializer(ISerializer serializer) {
		this.serializer = serializer;
	}
}