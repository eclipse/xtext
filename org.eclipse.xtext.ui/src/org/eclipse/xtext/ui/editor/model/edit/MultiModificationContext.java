/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.emf.ecore.EObject;

/**
 * @since 2.13
 * @author Dennis Huebner - Initial contribution and API
 */
public class MultiModificationContext implements IMultiModificationContext {
	private EObject element;
	private IMultiModification modification;
	private EObject toModify;

	public MultiModificationContext(EObject element) {
		this.element = element;
	}

	@Override
	public EObject getElement() {
		return this.element;
	}

	@Override
	public void applyModification() {
		if (modification == null) {
			throw new IllegalStateException("Call setModification() before applying the modification");
		}
		modification.apply(toModify);
	}

	@Override
	public void setModification(EObject toModify, IMultiModification modification) {
		this.toModify = toModify;
		this.modification = modification;
	}
}
