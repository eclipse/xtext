/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.xtend.ide.labeling.XtendImages;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextEditorErrorTickUpdater;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

import com.google.inject.Inject;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class XtendEditorErrorTickUpdater extends XtextEditorErrorTickUpdater {
	
	@Inject
	private XtendImages images;
	
	@Inject
	private IImageHelper pluginImageHelper;
	
	@Override
	protected void updateEditorImage(XtextEditor xtextEditor) {
		if (xtextEditor != null && !xtextEditor.isEditable()) {
			Severity severity = getSeverity(xtextEditor);
			if (severity != null && severity != Severity.INFO) {
				ImageDescriptor descriptor = severity == Severity.ERROR ? XtextPluginImages.DESC_OVR_ERROR
						: XtextPluginImages.DESC_OVR_WARNING;
				// TODO replace with new constructor that takes an ImageDescription when on Oxygen+
				DecorationOverlayIcon decorationOverlayIcon = new DecorationOverlayIcon(pluginImageHelper.getImage(images.forReadonly()), descriptor,
						IDecoration.BOTTOM_LEFT);
				scheduleUpdateEditor(decorationOverlayIcon);
			} else {
				scheduleUpdateEditor(images.forReadonly());
			}
		} else {
			super.updateEditorImage(xtextEditor);
		}
	}

}
