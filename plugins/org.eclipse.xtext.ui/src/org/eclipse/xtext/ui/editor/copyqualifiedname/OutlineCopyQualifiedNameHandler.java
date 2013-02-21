/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.copyqualifiedname;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
public class OutlineCopyQualifiedNameHandler extends AbstractCopyQualifiedNameHandler {

	@Override
	protected String getQualifiedName(ExecutionEvent event) {
		IOutlineNode outlineNode = getOutlineNode(event);
		if (outlineNode == null) {
			return null;
		}
		return outlineNode.readOnly(new IUnitOfWork<String, EObject>() {

			public String exec(EObject selectedElement) throws Exception {
				return getQualifiedName(selectedElement);
			}

		});
	}

	private IOutlineNode getOutlineNode(ExecutionEvent event) {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (!(currentSelection instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection structuredSelection = (IStructuredSelection) currentSelection;
		return (IOutlineNode) structuredSelection.getFirstElement();
	}

}
