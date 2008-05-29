/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.codecompletion;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class Proposal {

	private StyledString label;
	private String text;
	private String description;
	private Image image;

	public Proposal(String text) {
		Assert.isLegal(text != null);
		this.text = text;
	}

	/**
	 * @return the label
	 */
	public StyledString getLabel() {
		if (label == null)
			return new StyledString(text);
		return label;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param label
	 * 		the label to set
	 */
	public void setLabel(StyledString label) {
		this.label = label;
	}

	/**
	 * @param text
	 * 		the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 * 		the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param image
	 * 		the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}
}
