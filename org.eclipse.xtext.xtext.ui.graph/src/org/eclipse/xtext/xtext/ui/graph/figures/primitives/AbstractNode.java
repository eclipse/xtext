/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.figures.primitives;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.xtext.xtext.ui.graph.figures.IEObjectReferer;
import org.eclipse.xtext.xtext.ui.graph.figures.ILayoutConstants;
import org.eclipse.xtext.xtext.ui.graph.figures.ISelectable;

/**
 * Base class of all nodes.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractNode extends CrossPoint implements IEObjectReferer, ISelectable {

	public static final int PADDING = 5;

	private Label label;
	private boolean isSelected = false;

	private URI grammarElementURI;

	private Region textRegion;

	protected AbstractNode(EObject eObject, String text, Font font, Region textRegion) {
		if (eObject != null)
			grammarElementURI = EcoreUtil.getURI(eObject);
		setLayoutManager(new ToolbarLayout());
		setBackgroundColor(getUnselectedBackgroundColor());
		label = new Label(text);
		add(label);
		setBorder(createBorder());
		setFont(font);
		this.textRegion = textRegion;
	}

	protected abstract Border createBorder();

	@Override
	public void setFont(Font f) {
		super.setFont(f);
		label.setFont(f);
	}

	@Override
	public void setSelected(boolean isSelected) {
		if (isSelected != this.isSelected) {
			if (isSelected)
				setBackgroundColor(getSelectedBackgroundColor());
			else
				setBackgroundColor(getUnselectedBackgroundColor());
			this.isSelected = isSelected;
			invalidate();
		}
	}

	protected Color getSelectedBackgroundColor() {
		return ILayoutConstants.NODE_SELECTION_COLOR;
	}

	protected Color getUnselectedBackgroundColor() {
		return ColorConstants.buttonLightest;
	}

	@Override
	public URI getEObjectURI() {
		return grammarElementURI;
	}

	@Override
	public Region getTextRegion() {
		return textRegion;
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
	
	public boolean isSelectable() {
		return true;
	}
}
