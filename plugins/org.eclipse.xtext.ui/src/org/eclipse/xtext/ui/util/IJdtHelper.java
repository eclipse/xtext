/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.core.resources.IResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.1
 */
public interface IJdtHelper {

	boolean isJavaCoreAvailable();
	
	boolean isFromOutputPath(IResource resource);
	
}
