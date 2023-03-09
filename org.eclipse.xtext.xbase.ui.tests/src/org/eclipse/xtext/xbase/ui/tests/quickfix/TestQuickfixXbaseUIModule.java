/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.quickfix;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.xbase.ui.XbaseUiModule;

public class TestQuickfixXbaseUIModule extends XbaseUiModule {
	public TestQuickfixXbaseUIModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends IssueModificationContext> bindIssueModificationContext() {
		return TestIssueModificationContext.class;
	}
}
