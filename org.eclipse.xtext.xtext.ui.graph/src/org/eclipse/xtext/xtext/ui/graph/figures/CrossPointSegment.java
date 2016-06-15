/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.figures;

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xtext.ui.graph.figures.layouts.SequenceLayout;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.CrossPoint;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.PrimitiveFigureFactory;

/**
 * A segment containing a single {@link CrossPoint}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CrossPointSegment extends AbstractSegmentFigure {

	public CrossPointSegment(EObject eObject, PrimitiveFigureFactory primitiveFactory) {
		super(eObject);
		CrossPoint crossPoint = primitiveFactory.createCrossPoint(this);
		setEntry(crossPoint);
		setExit(crossPoint);
	}

	@Override
	protected LayoutManager createLayoutManager() {
		return new SequenceLayout(ILayoutConstants.MIN_SEGMENT_HEIGHT);
	}

}
