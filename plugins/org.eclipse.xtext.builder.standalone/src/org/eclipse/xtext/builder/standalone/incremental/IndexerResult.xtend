/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtend.lib.annotations.Data

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.9 
 */
@Data
class IndexerResult {
	List<URI> changedResources
	List<URI> deletedResources
	ResourceDescriptionsData newIndex
}