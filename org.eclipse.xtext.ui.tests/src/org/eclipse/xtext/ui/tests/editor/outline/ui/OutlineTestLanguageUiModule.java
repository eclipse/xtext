/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline.ui;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.actions.OutlineWithEditorLinker;
import org.eclipse.xtext.ui.tests.editor.outline.CustomOutlineWithEditorLinker;
import org.eclipse.xtext.ui.tests.editor.outline.SampleFilterContribution;
import org.eclipse.xtext.ui.tests.editor.outline.SyncableOutlinePage;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OutlineTestLanguageUiModule extends
		org.eclipse.xtext.ui.tests.editor.outline.ui.AbstractOutlineTestLanguageUiModule {
	public OutlineTestLanguageUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return SyncableOutlinePage.class;
	}

	public void configureSampleFilterContribution(Binder binder) {
		if (PlatformUI.isWorkbenchRunning())
			binder.bind(IOutlineContribution.class).annotatedWith(Names.named(SampleFilterContribution.PREFERENCE_KEY))
					.to(SampleFilterContribution.class);
	}

	public Class<? extends OutlineWithEditorLinker> bindOutlineWithEditorLinker() {
		return CustomOutlineWithEditorLinker.class;
	}
	
	@Override
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return null;
	}
	
	
}
