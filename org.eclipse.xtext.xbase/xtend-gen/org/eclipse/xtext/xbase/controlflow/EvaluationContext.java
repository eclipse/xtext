/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.controlflow;

import com.google.inject.Inject;
import java.util.Map;
import java.util.Stack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;

/**
 * @author Sebastian Zarnekow - Initial API and implementation
 */
@SuppressWarnings("all")
public class EvaluationContext {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  private RecursionGuard<EObject> visiting = new RecursionGuard<EObject>();
  
  private Map<Resource, IResolvedTypes> resolvedTypesPerResource = CollectionLiterals.<Resource, IResolvedTypes>newHashMap();
  
  private Stack<IResolvedTypes> resolvedTypesStack = new Stack<IResolvedTypes>();
  
  public boolean tryNext(final XExpression expression) {
    boolean _tryNext = this.visiting.tryNext(expression);
    if (_tryNext) {
      this.resolveTypes(expression);
      return true;
    }
    return false;
  }
  
  public void addResolvedTypes(final Resource resource, final IResolvedTypes resolvedTypes) {
    this.resolvedTypesPerResource.put(resource, resolvedTypes);
  }
  
  private void resolveTypes(final XExpression expression) {
    final Resource resource = expression.eResource();
    IResolvedTypes resolvedTypes = this.resolvedTypesPerResource.get(resource);
    if ((resolvedTypes == null)) {
      IResolvedTypes _resolveTypes = this.typeResolver.resolveTypes(expression);
      resolvedTypes = _resolveTypes;
      this.resolvedTypesPerResource.put(resource, resolvedTypes);
    }
    this.resolvedTypesStack.push(resolvedTypes);
  }
  
  public IResolvedTypes getResolvedTypes() {
    return this.resolvedTypesStack.peek();
  }
  
  public void done(final XExpression expression) {
    this.resolvedTypesStack.pop();
    this.visiting.done(expression);
  }
}
