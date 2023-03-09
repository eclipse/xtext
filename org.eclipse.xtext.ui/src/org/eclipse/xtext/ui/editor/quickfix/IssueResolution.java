/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	private int relevance;
	
	public IssueResolution(String label, String description, String image, IModificationContext modificationContext, IModification modification) {
		this(label, description, image, modificationContext, modification, 0);
	}
	
	/**
	 * @since 2.4
	 */
	public IssueResolution(String label, String description, String image, IModificationContext modificationContext, IModification modification, int relevance) {
		this.description = description;
		this.label = label;
		this.image = image;
		this.modificationContext = modificationContext;
		this.modification = modification;
		this.relevance = relevance;
	}
	
	/**
	 * @since 2.4
	 */
	public int getRelevance() {
		return relevance;
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
	/**
	 * @since 2.2
	 */
	public IModification getModification() {
		return modification;
	}
	/**
	 * @since 2.2
	 */
	public IModificationContext getModificationContext() {
		return modificationContext;
	}

	public void apply() {
		try {
			modification.apply(modificationContext);
		} catch(Exception exc) {
			throw new WrappedException(exc);
		}
	}
}
