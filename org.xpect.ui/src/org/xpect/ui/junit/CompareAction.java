/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.junit;

import org.eclipse.compare.CompareUI;
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jface.action.Action;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
class CompareAction extends Action {

	private ITestElement ctx;

	public CompareAction(ITestElement ctx) {
		super();
		this.ctx = ctx;
		setText("Compare");
		setToolTipText("Compare test expecation with actual test result.");
	}

	@Override
	public boolean isEnabled() {
		return ctx instanceof TestElement && ((TestElement) ctx).isComparisonFailure();
	}

	@Override
	public void run() {
		FailureCompareEditorInput inp = new FailureCompareEditorInput(ctx);
		CompareUI.openCompareEditor(inp);
	}
}