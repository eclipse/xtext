/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.build;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor
@Accessors
@SuppressWarnings("all")
public class IndexState {
  private final ResourceDescriptionsData resourceDescriptions;
  
  private final Source2GeneratedMapping fileMappings;
  
  public IndexState() {
    this(new ResourceDescriptionsData(CollectionLiterals.<IResourceDescription>emptySet()), new Source2GeneratedMapping());
  }
  
  public IndexState(final ResourceDescriptionsData resourceDescriptions, final Source2GeneratedMapping fileMappings) {
    super();
    this.resourceDescriptions = resourceDescriptions;
    this.fileMappings = fileMappings;
  }
  
  @Pure
  public ResourceDescriptionsData getResourceDescriptions() {
    return this.resourceDescriptions;
  }
  
  @Pure
  public Source2GeneratedMapping getFileMappings() {
    return this.fileMappings;
  }
}
