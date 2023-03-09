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

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xtext.ui.graph.figures.layouts.ParallelLayout;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.PrimitiveFigureFactory;

/**
 * A segment with an additional connection bypassing the child segment.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class BypassSegment extends AbstractSegmentFigure {

	public BypassSegment(EObject eObject, ISegmentFigure child, PrimitiveFigureFactory primitiveFactory) {
		super(eObject);
		setEntry(primitiveFactory.createCrossPoint(this));
		CrossPointSegment crossPointSegment = new CrossPointSegment(eObject, primitiveFactory);
		if(ILayoutConstants.ROUTE_OPTIONAL_TOP) {
			add(crossPointSegment);
			add(child);
		} else {
			add(child);
			add(crossPointSegment);
		}
		setExit(primitiveFactory.createCrossPoint(this));
		primitiveFactory.createConnection(getEntry(), crossPointSegment.getEntry(), this, ILayoutConstants.CONCAVE_START);
		primitiveFactory.createConnection(crossPointSegment.getExit(), getExit(), this, ILayoutConstants.CONCAVE_END);
		primitiveFactory.createConnection(getEntry(), child.getEntry(), this, ILayoutConstants.CONCAVE_START);
		primitiveFactory.createConnection(child.getExit(), getExit(), this, ILayoutConstants.CONCAVE_END);
	}

	@Override
	protected LayoutManager createLayoutManager() {
		return new ParallelLayout();
	}

}
