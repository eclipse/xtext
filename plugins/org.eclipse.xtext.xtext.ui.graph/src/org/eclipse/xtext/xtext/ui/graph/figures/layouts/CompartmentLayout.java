/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.figures.layouts;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.xtext.xtext.ui.graph.figures.CompartmentSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.ILayoutConstants;

public class CompartmentLayout extends AbstractLayout {

	public CompartmentLayout() {
	}

	@Override
	public void layout(IFigure container) {
		if (container instanceof CompartmentSegment) {
			CompartmentSegment compartment = (CompartmentSegment) container;
			Rectangle innerBounds = new Rectangle();
			innerBounds.setLocation(ILayoutConstants.COMPARTMENT_PADDING, ILayoutConstants.COMPARTMENT_PADDING);
			innerBounds.setSize(compartment.getInnerSegment().getPreferredSize());
			compartment.getInnerSegment().setBounds(innerBounds);
			
			Rectangle bounds = Rectangle.SINGLETON;
			bounds.setLocation(0, innerBounds.getCenter().y);
			bounds.setSize(0, 0);
			compartment.getEntry().setBounds(bounds);
			bounds.setLocation(innerBounds.getRight().x + ILayoutConstants.COMPARTMENT_PADDING, innerBounds.getCenter().y);
			compartment.getExit().setBounds(bounds);
		}
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		if (container instanceof CompartmentSegment) {
			CompartmentSegment compartment = (CompartmentSegment) container;
			Dimension preferredSize = compartment.getInnerSegment().getPreferredSize(wHint, hHint);
			return new Dimension(preferredSize.width + 2 * ILayoutConstants.COMPARTMENT_PADDING + 2, preferredSize.height
					+ 2 * ILayoutConstants.COMPARTMENT_PADDING + 2);
		}
		return new Dimension();
	}

}
