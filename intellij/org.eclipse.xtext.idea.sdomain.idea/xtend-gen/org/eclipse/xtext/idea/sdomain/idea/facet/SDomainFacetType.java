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
import com.intellij.facet.FacetTypeId;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import javax.swing.Icon;
import org.eclipse.xtext.idea.Icons;
import org.eclipse.xtext.idea.sdomain.idea.facet.SDomainFacet;
import org.eclipse.xtext.idea.sdomain.idea.facet.SDomainFacetConfiguration;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class SDomainFacetType extends FacetType<SDomainFacet, SDomainFacetConfiguration> {
  private final static String TYPE_ID_STRING = "sdomain";
  
  public final static FacetTypeId<SDomainFacet> TYPEID = new FacetTypeId<SDomainFacet>(SDomainFacetType.TYPE_ID_STRING);
  
  public SDomainFacetType() {
    super(SDomainFacetType.TYPEID, SDomainFacetType.TYPE_ID_STRING, "SDomain", null);
  }
  
  @Override
  public SDomainFacetConfiguration createDefaultConfiguration() {
    return new SDomainFacetConfiguration();
  }
  
  @Override
  public SDomainFacet createFacet(final Module module, final String name, final SDomainFacetConfiguration configuration, final Facet underlyingFacet) {
    return new SDomainFacet(this, module, name, configuration, underlyingFacet);
  }
  
  @Override
  public boolean isSuitableModuleType(final ModuleType moduleType) {
    return true;
  }
  
  @Override
  public Icon getIcon() {
    return Icons.DSL_FILE_TYPE;
  }
}
