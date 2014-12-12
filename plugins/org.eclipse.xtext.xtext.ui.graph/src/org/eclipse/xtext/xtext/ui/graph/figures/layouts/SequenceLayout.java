/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
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
import org.eclipse.xtext.xtext.ui.graph.figures.ILayoutConstants;

/**
 * Layouts children left to right an centered vertically. Could not find a
 * Draw2D layout for this :-(
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SequenceLayout extends AbstractLayout {

	private int minHeight;

	public SequenceLayout(int minHeight) {
		this.minHeight = minHeight;
	}

	public SequenceLayout() {
		this(0);
	}

	@Override
	public void layout(IFigure container) {
		int height = minHeight;
		for (Object child : container.getChildren()) {
			if (child instanceof IFigure) {
				Dimension childSize = ((IFigure) child).getPreferredSize();
				height = Math.max(height, childSize.height);
			}
		}
		Rectangle bounds = Rectangle.SINGLETON;
		int x = 0;
		for (Object child : container.getChildren()) {
			if (child instanceof IFigure) {
				Dimension childSize = ((IFigure) child).getPreferredSize();
				bounds.setLocation(x, (height - childSize.height) / 2);
				bounds.setSize(childSize);
				((IFigure) child).setBounds(bounds);
				x += childSize.width + ILayoutConstants.HSPACE;
			}
		}
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		int width = 0;
		int height = minHeight;
		for (Object child : container.getChildren()) {
			if (child instanceof IFigure) {
				Dimension childSize = ((IFigure) child).getPreferredSize();
				height = Math.max(height, childSize.height);
				width += childSize.width + ILayoutConstants.HSPACE;
			}
		}
		width -= ILayoutConstants.HSPACE;
		return new Dimension(width, height);
	}

}
