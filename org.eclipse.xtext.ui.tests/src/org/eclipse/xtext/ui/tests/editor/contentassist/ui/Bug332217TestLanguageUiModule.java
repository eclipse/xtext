/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;

/**
 * Use this class to register components to be used within the IDE.
 */
public class Bug332217TestLanguageUiModule extends org.eclipse.xtext.ui.tests.editor.contentassist.ui.AbstractBug332217TestLanguageUiModule {
	public Bug332217TestLanguageUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	/**
	 * Bind a null implementation to detect wrong elements in the first element set
	 * of the content assist context.
	 */
	@Override
	public Class<? extends IProposalConflictHelper> bindIProposalConflictHelper() {
		return IProposalConflictHelper.NullHelper.class;
	}
	
}
