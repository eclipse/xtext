/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.edit.IContextFreeModification;

/**
 * @since 2.13
 * @author Dennis Huebner - Initial contribution and API
 */
public class FixContext {
	private EObject element;
	private IContextFreeModification modification;
	private EObject toModify;

	public FixContext(EObject element) {
		this.element = element;
	}

	public EObject getElement() {
		return this.element;
	}

	public void applyModification() {
		if (modification == null) {
			throw new IllegalStateException("Call setModification() before applying the modification");
		}
		modification.apply(toModify);
	}

	public void setModification(EObject toModify, IContextFreeModification modification) {
		this.toModify = toModify;
		this.modification = modification;
	}
}
