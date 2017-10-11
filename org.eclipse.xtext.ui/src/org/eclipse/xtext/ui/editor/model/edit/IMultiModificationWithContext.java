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
public interface IMultiModificationWithContext {
	
	/**
	 *	@param element the element to provide a QuickFix for. Could also be requested using {@link IMultiModificationContext#getElement()}
	 *	@param context add modification to this context using {@link IMultiModificationContext#addModification(EObject, IMultiModification)}
	 */
	void apply(EObject element, IMultiModificationContext context);
}
