/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ArtificialNode extends AbstractOutlineNode {

	public ArtificialNode(IOutlineNode parent, Image image, Object text, boolean hasPredictedChildren) {
		super(parent, image, text, hasPredictedChildren);
	}

}
