/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.junit;

import org.eclipse.compare.CompareUI;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jface.action.Action;
import org.xpect.ui.util.FileUtil;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
class CompareAction extends Action {

	private final ITestElement ctx;
	private final URI uri;

	public CompareAction(ITestElement ctx, URI uri) {
		super();
		this.ctx = ctx;
		this.uri = uri;
		setText("Compare");
		setToolTipText("Compare test expecation with actual test result.");
	}

	@Override
	public boolean isEnabled() {
		return ctx instanceof TestElement && ((TestElement) ctx).isComparisonFailure();
	}

	@Override
	public void run() {
		IFile iFile = uri == null ? null : FileUtil.findFileInWorkspace(uri);
		FailureCompareEditorInput inp = new FailureCompareEditorInput(ctx, iFile);
		CompareUI.openCompareEditor(inp);
	}
}