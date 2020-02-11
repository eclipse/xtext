/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

/**
 * @author dhuebner - Initial contribution and API
 */
public class XtendEObjectNode extends EObjectNode {

	private int inheritanceDepth;
	private boolean isStatic;

	public XtendEObjectNode(EObject eObject, IOutlineNode parent, ImageDescriptor imageDescriptor, Object text,
			boolean isLeaf) {
		super(eObject, parent, imageDescriptor, text, isLeaf);
	}

	public int getInheritanceDepth() {
		return inheritanceDepth;
	}

	public void setInheritanceDepth(int inheritanceDepth) {
		this.inheritanceDepth = inheritanceDepth;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public boolean isStatic() {
		return isStatic;
	}

}
