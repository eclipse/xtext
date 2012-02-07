/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITracingAppendable extends IAppendable {

	ITracingAppendable trace(EObject object);
	
	ITracingAppendable trace(URI sourceURI, String sourceProject, int offset, int length);
	
	ITracingAppendable trace(URI sourceURI, int offset, int length);
	
}
