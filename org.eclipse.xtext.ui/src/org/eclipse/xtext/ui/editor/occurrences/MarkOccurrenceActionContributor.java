/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.occurrences;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.actions.AbstractToggleActionContributor;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class MarkOccurrenceActionContributor extends AbstractToggleActionContributor implements IActionContributor {

	public static final String EDITOR_MARK_OCCURRENCES = "ui.editor.markOccurrences"; //$NON-NLS-1$

	@Inject
	private Provider<OccurrenceMarker> occurrenceMarkerProvider;

	private Map<XtextEditor, OccurrenceMarker> editor2marker = newConcurrentMap();
	
	@Override
	public void contributeActions(XtextEditor editor) {
		editor2marker.computeIfAbsent(editor, (e)->{
			Action action = getAction();
			editor.setAction(action.getId(), action);
			IToolBarManager toolBarManager = editor.getEditorSite().getActionBars().getToolBarManager();
			if(toolBarManager.find(action.getId())==null) {
				ActionContributionItem item = new ActionContributionItem(action);
				item.setVisible(false);
				toolBarManager.add(item);				
			}
			OccurrenceMarker occurrenceMarker = occurrenceMarkerProvider.get();
			occurrenceMarker.connect(editor, isPropertySet());
			return occurrenceMarker;
		});
	}
	
	/**
	 * @since 2.17
	 */
	public OccurrenceMarker findOccurrenceMarker(XtextEditor editor) {
		return editor2marker.get(editor);
	}

	@Override
	public void editorDisposed(XtextEditor editor) {
		OccurrenceMarker occurrenceMarker = editor2marker.remove(editor);
		if(occurrenceMarker != null) {
			occurrenceMarker.disconnect(editor);
		}
	}

	@Override
	public String getPreferenceKey() {
		return EDITOR_MARK_OCCURRENCES;
	}

	@Override
	protected void stateChanged(boolean newState) {
		for(OccurrenceMarker occurrenceMarker: editor2marker.values()) {
			occurrenceMarker.setMarkOccurrences(newState);
		}
	}

	@Override
	protected void configureAction(Action action) {
		action.setText(Messages.MarkOccurrenceActionContributor_text);
		action.setDescription(Messages.MarkOccurrenceActionContributor_description);
		action.setToolTipText(Messages.MarkOccurrenceActionContributor_toolTipText);
		action.setImageDescriptor(XtextPluginImages.DESC_MARK_OCCURRENCES);
		action.setDisabledImageDescriptor(XtextPluginImages.DESC_MARK_OCCURRENCES_DISABLED);
		addPropertyChangeListener();
	}

}
