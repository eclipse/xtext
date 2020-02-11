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

import org.eclipse.swt.graphics.Color;
import org.eclipse.xtext.xtext.ui.graph.figures.layouts.RailroadConnectionRouter;

/**
 * All constants used for layouting and rendering.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ILayoutConstants {

	// common spacings
	int HSPACE = 10;
	int VSPACE = 9;
	int VSPACE_BETWEEN_TRACKS = 25;
	int COMPARTMENT_PADDING = 10;
	
	// nodes
	int ROUNDED_RECTANGLE_RADIUS = 7;
	Color NODE_SELECTION_COLOR = new Color(null, 115, 158, 227);
	
	// connections
	int CONNECTION_RADIUS = 5;
	boolean ROUTE_OPTIONAL_TOP = false;
	boolean ROUTE_MULTIPLE_TOP = true;
	RailroadConnectionRouter.BendConstraint CONVEX_END = new RailroadConnectionRouter.BendConstraint(false, true);
	RailroadConnectionRouter.BendConstraint CONVEX_START = new RailroadConnectionRouter.BendConstraint(true, true);
	RailroadConnectionRouter.BendConstraint CONCAVE_END = new RailroadConnectionRouter.BendConstraint(false, false);
	RailroadConnectionRouter.BendConstraint CONCAVE_START = new RailroadConnectionRouter.BendConstraint(true, false);

	// segments
	int MIN_SEGMENT_HEIGHT = 25; 
	int PARALLEL_SEGMENT_HSPACE = 20;

}
