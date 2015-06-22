/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.facet

import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StorageScheme
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration

/** 
 * @author dhuebner - Initial contribution and API
 */
@State(name="SDomainGenerator", storages=#[
	@Storage(id="ipr", file="$PROJECT_FILE$"),
	@Storage(id="prjDir", file="${PROJECT_CONFIG_DIR$/SDomainGeneratorConfig.xml", scheme=StorageScheme.DIRECTORY_BASED)
])
class SDomainFacetConfiguration extends AbstractFacetConfiguration {

	override protected getTabTitle() {
		"SDomain facet"
	}

}
	