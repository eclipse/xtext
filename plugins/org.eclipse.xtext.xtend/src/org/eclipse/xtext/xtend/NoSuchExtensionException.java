/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend;

import java.util.List;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class NoSuchExtensionException extends AbstractXtendExecutionException {

	private static final long serialVersionUID = 3318038998385424895L;

	public NoSuchExtensionException(String extensionName, List<?> params) {
		super("Could not find extension", extensionName, params);
	}

}
