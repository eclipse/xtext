/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.documentation;

import org.eclipse.emf.ecore.EObject;

/**
 * Returns a documentation string for an EObject.
 * 
 * @author Christoph Kulla - Initial contribution and API
 */
public interface IEObjectDocumentationProvider {

	public String getDocumentation (EObject o);

}
