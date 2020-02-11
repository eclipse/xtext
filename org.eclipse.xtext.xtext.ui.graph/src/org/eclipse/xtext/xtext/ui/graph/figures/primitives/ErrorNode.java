/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.figures.primitives;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * Node representing an erroneous grammar element.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ErrorNode extends RectangleNode {

	public ErrorNode(EObject eObject, String text, Font font, Region textRegion) {
		super(eObject, text, font, textRegion);
	}

	@Override
	protected Color getUnselectedBackgroundColor() {
		return ColorConstants.red;
	}
}
