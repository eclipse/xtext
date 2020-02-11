/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class NamedSerializationContexts<T extends Object> {
  private final String name;
  
  private final EClass type;
  
  private final List<ISerializationContext> contexts;
  
  private final T value;
  
  public NamedSerializationContexts(final String name, final EClass type, final List<ISerializationContext> contexts, final T value) {
    super();
    this.name = name;
    this.type = type;
    this.contexts = contexts;
    this.value = value;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public EClass getType() {
    return this.type;
  }
  
  @Pure
  public List<ISerializationContext> getContexts() {
    return this.contexts;
  }
  
  @Pure
  public T getValue() {
    return this.value;
  }
}
