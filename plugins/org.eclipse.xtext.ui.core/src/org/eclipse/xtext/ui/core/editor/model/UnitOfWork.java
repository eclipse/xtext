/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.xtext.resource.XtextResource;

/**
 * A unit of work acts as a transaction block, which can be passed to an
 * IXtextDocument in order to get read or write access to it's parsed models.
 * 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public interface UnitOfWork<T> {

	/**
	 * @param resource - The resource containing the current state - <b>Do not return any references to something contained in this resource</b>
	 * @return
	 * @throws Exception
	 */
	T exec(XtextResource resource) throws Exception;
}