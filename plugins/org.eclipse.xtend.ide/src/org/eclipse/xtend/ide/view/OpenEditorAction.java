/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.view;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.action.Action;
import org.eclipse.xtext.common.types.ui.navigation.GlobalDerivedMemberAwareURIEditorOpener;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class OpenEditorAction extends Action {
	private DerivedSourceView derivedSourceView;
	private GlobalDerivedMemberAwareURIEditorOpener uriEditorOpener;

	public OpenEditorAction(DerivedSourceView derivedSourceView, GlobalDerivedMemberAwareURIEditorOpener uriEditorOpener) {
		Assert.isNotNull(derivedSourceView);
		Assert.isNotNull(uriEditorOpener);
		this.derivedSourceView = derivedSourceView;
		this.uriEditorOpener = uriEditorOpener;
		JavaPluginImages.setLocalImageDescriptors(this, "goto_input.gif"); //$NON-NLS-1$
		setText(Messages.OpenEditorAction_Label);
		setToolTipText(Messages.OpenEditorAction_ToolTip);
		setDescription(Messages.OpenEditorAction_Description);

	}

	@Override
	public void run() {
		IFile file = derivedSourceView.getSelectedFile();
		ICompilationUnit compilationUnit = (ICompilationUnit) JavaCore.create(file);
		uriEditorOpener.open(null, compilationUnit.findPrimaryType(), false);
	}
}