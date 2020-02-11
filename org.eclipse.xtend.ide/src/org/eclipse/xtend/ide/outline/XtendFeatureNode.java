/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
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

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendFeatureNode extends XtendEObjectNode {

	private boolean isDispatch;
	
	private boolean isSynthetic;
	
	public XtendFeatureNode(EObject eObject, IOutlineNode parent, ImageDescriptor imageDescriptor, Object text, boolean isLeaf) {
		super(eObject, parent, imageDescriptor, text, isLeaf);
	}
	
	public void setDispatch(boolean isDispatch) {
		this.isDispatch = isDispatch;
	}
	
	public boolean isDispatch() {
		return isDispatch;
	}
	
	public void setSynthetic(boolean isSynthetic) {
		this.isSynthetic = isSynthetic;
	}
	
	public boolean isSynthetic() {
		return isSynthetic;
	}
}
