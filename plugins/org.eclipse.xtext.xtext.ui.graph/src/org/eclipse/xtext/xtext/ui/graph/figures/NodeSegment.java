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
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.xtext.ui.graph.figures.layouts.SequenceLayout;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.AbstractNode;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.NodeType;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.PrimitiveFigureFactory;

/**
 * A segment containing a single {@link Node}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NodeSegment extends AbstractSegmentFigure {

	public NodeSegment(EObject eObject, NodeType nodeType, String name, PrimitiveFigureFactory primitiveFactory, Region textRegion) {
		super(eObject);
		AbstractNode node = primitiveFactory.createNode(nodeType, eObject, name, this, textRegion);
		setEntry(node);
		setExit(node);
	}

	@Override
	protected LayoutManager createLayoutManager() {
		return new SequenceLayout();
	}

}
