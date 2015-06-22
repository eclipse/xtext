/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetType;
import com.intellij.openapi.module.Module;
import org.eclipse.xtext.idea.sdomain.idea.facet.SDomainFacetConfiguration;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class SDomainFacet extends Facet<SDomainFacetConfiguration> {
  public SDomainFacet(final FacetType<SDomainFacet, SDomainFacetConfiguration> facetType, final Module module, final String name, final SDomainFacetConfiguration configuration, final Facet<SDomainFacetConfiguration> underlyingFacet) {
    super(facetType, module, name, configuration, underlyingFacet);
  }
}
