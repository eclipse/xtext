/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xpect.XjmTest;
import org.eclipse.xpect.XpectFile;
import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.XpectJavaModel;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectOutlineTreeProvider extends DefaultOutlineTreeProvider {
	protected void _createChildren(IOutlineNode parentNode, XpectFile file) {
		for (EObject childElement : file.getInvocations())
			createNode(parentNode, childElement);
	}

	protected void _createChildren(IOutlineNode parentNode, XpectInvocation inv) {
	}

	public String _text(XpectFile file) {
		String filename = file.eResource().getURI().lastSegment();
		XpectJavaModel model = file.getJavaModel();
		if (model != null && !model.eIsProxy()) {
			XjmTest suite = model.getTestOrSuite();
			if (suite != null && !suite.eIsProxy()) {
				JvmDeclaredType jvmClass = suite.getJvmClass();
				if (jvmClass != null && !jvmClass.eIsProxy())
					return filename + " - " + jvmClass.getSimpleName();
			}
		}
		return filename;
	}

	public String _text(XpectInvocation inv) {
		return inv.getMethodName();
	}
}
