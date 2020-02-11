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
import org.eclipse.xtext.xtext.ui.graph.figures.layouts.ParallelLayout;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.PrimitiveFigureFactory;

/**
 * Connects all child segments to a common entry and a common exit {@link CrossPoint}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ParallelSegment extends AbstractSegmentFigure {

	public ParallelSegment(EObject eObject, List<ISegmentFigure> children, PrimitiveFigureFactory primitiveFactory) {
		super(eObject);
		setEntry(primitiveFactory.createCrossPoint(this));
		if (children.isEmpty()) {
			setExit(getEntry());
		} else {
			setExit(primitiveFactory.createCrossPoint(this));
			for (ISegmentFigure child : children) {
				add(child);
				primitiveFactory.createConnection(getEntry(), child.getEntry(), this, ILayoutConstants.CONCAVE_START);
				primitiveFactory.createConnection(child.getExit(), getExit(), this, ILayoutConstants.CONCAVE_END);
			}
		}
	}

	@Override
	protected LayoutManager createLayoutManager() {
		return new ParallelLayout();
	}

}
