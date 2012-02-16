/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.Nullable;

/*
 * Implementation note:
 * We do not extend ITextRegion since that one offers #merge.
 * If ILocationData was mergable with ITextRegion, one or the
 * other would have to either dicard information or create an
 * unwanted dependency. Otherwise the result of #merge would 
 * depend on the order which is not desired.
 */
/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ILocationData {

	int getOffset();
	int getLength();
	@Nullable URI getLocation();
	@Nullable String getProjectName();
	
}
