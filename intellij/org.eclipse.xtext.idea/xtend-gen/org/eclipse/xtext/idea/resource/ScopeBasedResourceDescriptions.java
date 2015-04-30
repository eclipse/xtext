/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.intellij.psi.search.GlobalSearchScope;
import org.eclipse.xtext.idea.resource.AbstractScopeBasedSelectable;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ScopeBasedResourceDescriptions extends AbstractScopeBasedSelectable implements IResourceDescriptions {
  @Override
  public Iterable<IResourceDescription> getAllResourceDescriptions() {
    return super.getResourceDescriptions();
  }
  
  @Override
  public void setScope(final GlobalSearchScope scope) {
    super.setScope(scope);
  }
}
