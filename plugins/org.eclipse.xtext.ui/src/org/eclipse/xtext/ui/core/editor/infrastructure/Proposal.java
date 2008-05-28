/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.infrastructure;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class Proposal {
	private ImageDescriptor icon;
	private StyledString label;
	private String text;
	private String description;

	/**
	 * @return the icon
	 */
	public ImageDescriptor getIcon() {
		return icon;
	}

	/**
	 * @return the label
	 */
	public StyledString getLabel() {
		return label;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param icon
	 * 		the icon to set
	 */
	public void setIcon(ImageDescriptor icon) {
		this.icon = icon;
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
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
