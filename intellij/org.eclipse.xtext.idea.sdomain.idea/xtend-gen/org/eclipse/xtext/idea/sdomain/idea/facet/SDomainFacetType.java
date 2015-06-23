/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class SDomainFacetType extends AbstractFacetType<AbstractFacetConfiguration> {
  private final static String TYPE_ID_STRING = "sdomain";
  
  public final static FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(SDomainFacetType.TYPE_ID_STRING);
  
  public SDomainFacetType() {
    super(SDomainFacetType.TYPEID, SDomainFacetType.TYPE_ID_STRING, "SDomain");
    SDomainLanguage.INSTANCE.injectMembers(this);
  }
}
