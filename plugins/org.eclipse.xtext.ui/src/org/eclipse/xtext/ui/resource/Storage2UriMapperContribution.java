/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.util.Pair;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
public interface Storage2UriMapperContribution {
	
	void initializeCache();
	
	boolean isRejected(@NonNull IFolder folder);
	
	@NonNull
	Iterable<Pair<IStorage, IProject>> getStorages(@NonNull URI uri);
	
	@Nullable
	URI getUri(@NonNull IStorage storage);
	
}
