/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RuleNode extends EObjectNode {

	private StyledString fullText;
	
	public RuleNode(EObject eObject, IOutlineNode parent, Image image, Object text, boolean isLeaf) {
		super(eObject, parent, image, text, isLeaf);
	}

	public void setFullText(StyledString fullText) {
		this.fullText = fullText;
	}
	
	public StyledString getFullText() {
		return fullText;
	}
}
