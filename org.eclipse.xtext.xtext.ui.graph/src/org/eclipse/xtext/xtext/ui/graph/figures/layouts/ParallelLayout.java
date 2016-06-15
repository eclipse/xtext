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
import org.eclipse.xtext.xtext.ui.graph.figures.ISegmentFigure;

/**
 * Layouts children vertically with common entry and exit nodes to the left /
 * right.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ParallelLayout extends AbstractLayout {

	private int hmargin;

	public ParallelLayout(int hmargin) {
		this.hmargin = hmargin;
	}

	public ParallelLayout() {
		this(0);
	}

	@Override
	public void layout(IFigure container) {
		if (container instanceof ISegmentFigure) {
			ISegmentFigure containerSegment = (ISegmentFigure) container;
			int width = 0;
			for (Object child : containerSegment.getChildren()) {
				if (child instanceof ISegmentFigure) {
					Dimension childSize = ((ISegmentFigure) child).getPreferredSize();
					width = Math.max(width, childSize.width);
				}
			}
			int y = 0;
			Rectangle bounds = Rectangle.SINGLETON;
			for (Object child : containerSegment.getChildren()) {
				if (child instanceof ISegmentFigure) {
					Dimension childSize = ((ISegmentFigure) child).getPreferredSize();
					bounds.setLocation(ILayoutConstants.PARALLEL_SEGMENT_HSPACE + hmargin + (width - childSize.width)
							/ 2, y);
					bounds.setSize(childSize);
					((ISegmentFigure) child).setBounds(bounds);
					y += childSize.height + ILayoutConstants.VSPACE;
				}
			}
			y = (y - ILayoutConstants.VSPACE) / 2;
			bounds.setLocation(hmargin, y);
			bounds.setSize(0, 0);
			containerSegment.getEntry().setBounds(bounds);
			bounds.setLocation(width + 2 * ILayoutConstants.PARALLEL_SEGMENT_HSPACE + hmargin, y);
			containerSegment.getExit().setBounds(bounds);
		}
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		if (container instanceof ISegmentFigure) {
			ISegmentFigure containerSegment = (ISegmentFigure) container;
			int width = 0;
			int height = 0;
			for (Object child : containerSegment.getChildren()) {
				if (child instanceof ISegmentFigure) {
					Dimension childSize = ((ISegmentFigure) child).getPreferredSize();
					width = Math.max(width, childSize.width);
					height += childSize.height + ILayoutConstants.VSPACE;
				}
			}
			height -= ILayoutConstants.VSPACE;
			width += 2 * ILayoutConstants.PARALLEL_SEGMENT_HSPACE + 2 * hmargin + 1;
			return new Dimension(width, height);
		}
		return new Dimension();
	}

}