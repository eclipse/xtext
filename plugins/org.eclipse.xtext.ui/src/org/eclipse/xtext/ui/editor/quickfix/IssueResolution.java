/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Jan Koehnlein
 */
public class IssueResolution {

	private String description;
	private String label;
	private String image;
	private IModification modification;
	private IModificationContext modificationContext;
	
	public IssueResolution(String label, String description, String image, IModificationContext modificationContext, IModification modification) {
		this.description = description;
		this.label = label;
		this.image = image;
		this.modificationContext = modificationContext;
		this.modification = modification;
	}

	public String getDescription() {
		return description;
	}

	public String getLabel() {
		return label;
	}

	public String getImage() {
		return image;
	}

	public void apply() {
		try {
			modification.apply(modificationContext);
		} catch(Exception exc) {
			throw new WrappedException(exc);
		}
	}
}
