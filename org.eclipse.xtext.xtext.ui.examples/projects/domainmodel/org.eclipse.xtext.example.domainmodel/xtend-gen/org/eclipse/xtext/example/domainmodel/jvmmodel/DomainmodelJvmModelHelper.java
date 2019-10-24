/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.jvmmodel;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

/**
 * @author Lorenzo Bettini - Initial contribution and API, https://github.com/eclipse/xtext-eclipse/issues/1205
 */
@SuppressWarnings("all")
public class DomainmodelJvmModelHelper {
  @Inject
  @Extension
  private OverrideHelper _overrideHelper;
  
  /**
   * Detects duplicated {@link JvmOperation}s in the passed {@link JvmDeclaredType}
   * taking into consideration overloading and type erasure; each collection of
   * duplicates is passed to the consumer.
   */
  public void handleDuplicateJvmOperations(final JvmDeclaredType jvmDeclaredType, final Consumer<Collection<JvmOperation>> consumer) {
    final List<IResolvedOperation> methods = this._overrideHelper.getResolvedFeatures(jvmDeclaredType).getDeclaredOperations();
    final Multimap<String, JvmOperation> signature2Declarations = HashMultimap.<String, JvmOperation>create();
    final Consumer<IResolvedOperation> _function = (IResolvedOperation it) -> {
      signature2Declarations.put(it.getResolvedErasureSignature(), it.getDeclaration());
    };
    methods.forEach(_function);
    final Consumer<Collection<JvmOperation>> _function_1 = (Collection<JvmOperation> jvmOperations) -> {
      int _size = jvmOperations.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        consumer.accept(jvmOperations);
      }
    };
    signature2Declarations.asMap().values().forEach(_function_1);
  }
}
