/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener;
import org.eclipse.xtext.ui.editor.model.XtextEditorModelChangeEvent;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.ui.editor.preferences.TaskTagsPreferencePage.TaskTag;
import org.eclipse.xtext.ui.internal.XtextMarkerManager;

/**
 * Represents an implementation of interface
 * {@link org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener} used to
 * handle the creation of <i>Task Tags</i> to be displayed in eclipse
 * <i>Tasks</i> View.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener
 * 
 */
public class TaskTagsMarkerListener implements IXtextEditorModelListener {

	// constants
	private static final String ORG_ECLIPSE_XTEXT_UI_TASKMARKER = "org.eclipse.xtext.ui.taskmarker";
	private static final String SL_COMMENT = "SL_COMMENT";
	private static final String ML_COMMENT = "ML_COMMENT";
	// state
	private String pluginId;
	private IResource resource;
	private IProgressMonitor progressMonitor;
	private IPreferenceStore preferenceStore;

	/**
	 * 
	 * @param resource
	 * @param progressMonitor
	 */
	public TaskTagsMarkerListener(String pluginId, IResource resource,
			IProgressMonitor progressMonitor) {

		Assert.isNotNull(pluginId, "parameter 'pluginId' must not be null");
		Assert.isNotNull(resource, "parameter 'resource' must not be null");
		Assert.isNotNull(resource,
				"parameter 'progressMonitor' must not be null");
		this.pluginId = pluginId;
		this.resource = resource;
		this.progressMonitor = progressMonitor;

		ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(
				new InstanceScope(), this.pluginId);
		scopedPreferenceStore.setSearchContexts(new IScopeContext[] {
				new InstanceScope(), new ConfigurationScope() });
		this.preferenceStore = scopedPreferenceStore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener#modelChanged
	 * (org.eclipse.xtext.ui.editor.model.XtextEditorModelChangeEvent)
	 */
	public void modelChanged(XtextEditorModelChangeEvent event) {

		String markerType = this.pluginId + "." + ORG_ECLIPSE_XTEXT_UI_TASKMARKER;

		XtextMarkerManager.clearMarkerForType(resource, progressMonitor,
				markerType);

		// preparing the required structures for XtextProblemMarkerCreator

		List<Map<String, Object>> taskMarkerAttributesMapList = new ArrayList<Map<String, Object>>();

		for (LeafNode leafNode : event.getModel().getParseTreeRootNode()
				.getLeafNodes()) {

			TaskTag taskTag = getTaskTag(leafNode);

			if (null != taskTag) {

				Map<String, Object> markerAttributesMap = new HashMap<String, Object>();

				markerAttributesMap.put(IMarker.MESSAGE, leafNode.getText()
						.trim());
				markerAttributesMap.put(IMarker.CHAR_START, leafNode
						.getOffset());
				markerAttributesMap.put(IMarker.CHAR_END, leafNode.getOffset()
						+ leafNode.getLength());

				if (PreferenceConstants.PRIORITY_HIGH.equalsIgnoreCase(taskTag
						.getPriority())) {
					markerAttributesMap.put(IMarker.PRIORITY,
							IMarker.PRIORITY_HIGH);
				} else if (PreferenceConstants.PRIORITY_NORMAL
						.equalsIgnoreCase(taskTag.getPriority())) {
					markerAttributesMap.put(IMarker.PRIORITY,
							IMarker.PRIORITY_NORMAL);
				} else {
					markerAttributesMap.put(IMarker.PRIORITY,
							IMarker.PRIORITY_LOW);
				}

				markerAttributesMap.put(IMarker.LOCATION, this.resource
						.getLocationURI().toString());
				markerAttributesMap.put(IMarker.LOCATION, "line "
						+ leafNode.getLine());

				taskMarkerAttributesMapList.add(markerAttributesMap);
			}
		}

		if (!taskMarkerAttributesMapList.isEmpty()) {
			XtextMarkerManager.createMarker(resource, Collections.singletonMap(
					markerType, taskMarkerAttributesMapList), progressMonitor);
		}

	}

	private TaskTag getTaskTag(LeafNode leafNode) {

		if (leafNode.getGrammarElement() instanceof LexerRule
				&& (((LexerRule) leafNode.getGrammarElement()).getName()
						.equalsIgnoreCase(SL_COMMENT) || ((LexerRule) leafNode
						.getGrammarElement()).getName().equalsIgnoreCase(
						ML_COMMENT))) {

			List<TaskTag> todoTaskList = TaskTag
					.getTodoTaskList(preferenceStore);

			Boolean caseSensitive = TaskTag.isCaseSensitive(preferenceStore);

			for (TaskTag todoTask : todoTaskList) {

				if ((caseSensitive && leafNode.getText().indexOf(
						todoTask.getName()) != -1)
						|| (!caseSensitive && leafNode.getText().toLowerCase()
								.indexOf(todoTask.getName().toLowerCase()) != -1)) {
					return todoTask;
				}

			}
		}

		return null;
	}

}
