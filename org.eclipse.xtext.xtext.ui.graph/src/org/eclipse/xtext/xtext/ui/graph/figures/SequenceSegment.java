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
package org.eclipse.xtext.xtext.ui.graph.figures;

import java.util.List;

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xtext.ui.graph.figures.layouts.SequenceLayout;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.CrossPoint;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.PrimitiveFigureFactory;

/**
 * A sequence of segments.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SequenceSegment extends AbstractSegmentFigure {

	public SequenceSegment(EObject eObject, List<ISegmentFigure> body, PrimitiveFigureFactory primitiveFactory) {
		super(eObject);
		if (body.isEmpty()) {
			setEntry(primitiveFactory.createCrossPoint(this));
			setExit(getEntry());
		} else {
			boolean isFirst = true;
			CrossPoint currentEnd = null;
			for (ISegmentFigure child : body) {
				if (isFirst) {
					setEntry(child.getEntry());
					isFirst = false;
				} else {
					primitiveFactory.createConnection(currentEnd, child.getEntry(), this);
				}
				add(child);
				currentEnd = child.getExit();
			}
			setExit(currentEnd);
		}
	}

	@Override
	protected LayoutManager createLayoutManager() {
		return new SequenceLayout();
	}

}
