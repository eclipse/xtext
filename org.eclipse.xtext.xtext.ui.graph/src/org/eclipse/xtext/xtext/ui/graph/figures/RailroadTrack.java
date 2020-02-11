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
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.xtext.ui.graph.figures.layouts.SequenceLayout;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.AbstractNode;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.CrossPoint;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.NodeType;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.PrimitiveFigureFactory;

/**
 * A railroad track with a label and an exit node. Between these arbitrary
 * {@link ISegmentFigure}s can be inserted.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RailroadTrack extends AbstractSegmentFigure {

	public RailroadTrack(EObject eObject, String name, ISegmentFigure body, PrimitiveFigureFactory primitiveFactory,
			Region textRegion) {
		super(eObject);
		AbstractNode label = primitiveFactory.createNode(NodeType.LABEL, eObject, name, this, textRegion);
		if (body != null)
			add(body);
		CrossPoint exit = primitiveFactory.createCrossPoint(this);
		if (body != null) {
			primitiveFactory.createConnection(label, body.getEntry(), this);
			primitiveFactory.createConnection(body.getExit(), exit, this);
		} else {
			primitiveFactory.createConnection(label, exit, this);
		}
	}

	@Override
	protected LayoutManager createLayoutManager() {
		return new SequenceLayout();
	}

	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}
}
