/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover.html;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class DefaultHoverDocumentationProvider implements IEObjectHoverDocumentationProvider {

	@Inject
	protected IEObjectDocumentationProvider documentationProvider;
	
	@Override
	public String getDocumentation(EObject object) {
		return documentationProvider.getDocumentation(object);
	}

}
