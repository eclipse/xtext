/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ResourceSet {
	private List<ISetupFile> files = Lists.newArrayList();

	public void add(ISetupFile file) {
		getFiles().add(file);
	}

	public List<ISetupFile> getFiles() {
		return files;
	}

}
