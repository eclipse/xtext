/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@Accessors
@SuppressWarnings("all")
public class StandaloneSetupAccess {
  private final List<StringConcatenationClient> registrations = CollectionLiterals.<StringConcatenationClient>newArrayList();
  
  @Deprecated
  private final Set<TypeReference> imports = CollectionLiterals.<TypeReference>newHashSet();
  
  /**
   * @deprecated this set is required for backwards-compatibility to Xpand templates included with
   * 		{@code org.eclipse.xtext.generator.adapter.FragmentAdapter}.
   */
  @Deprecated
  public Set<TypeReference> getImports() {
    return this.imports;
  }
  
  @Pure
  public List<StringConcatenationClient> getRegistrations() {
    return this.registrations;
  }
}
