/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xtext.ui.graph.figures.layouts.CompartmentLayout;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.PrimitiveFigureFactory;

/**
 * A track segment in a compartment. 
 * 
 * @author Jan Koehnlein
 */
public class CompartmentSegment extends AbstractSegmentFigure {

	private ISegmentFigure innerFigure;
	
	public CompartmentSegment(EObject eObject, ISegmentFigure innerSegment, PrimitiveFigureFactory primitiveFactory) {
		super(eObject);
		setEntry(primitiveFactory.createCrossPoint(this));
		setExit(primitiveFactory.createCrossPoint(this));
		add(innerSegment);
		primitiveFactory.createConnection(getEntry(), innerSegment.getEntry(), this);
		primitiveFactory.createConnection(innerSegment.getExit(), getExit(), this);
		setBorder(new LineBorder(getForegroundColor(), 1, Graphics.LINE_DASH));
		innerFigure = innerSegment;
	}

	public ISegmentFigure getInnerSegment() {
		return innerFigure;
	}
	
	@Override
	protected LayoutManager createLayoutManager() {
		return new CompartmentLayout();
	}

}
