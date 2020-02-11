/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Set;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@SuppressWarnings("all")
public class ConstraintVisitingInfo {
  private Set<JvmTypeParameter> visiting;
  
  private JvmTypeParameterDeclarator declarator;
  
  private int idx;
  
  public ConstraintVisitingInfo() {
    this.visiting = CollectionLiterals.<JvmTypeParameter>newHashSet();
  }
  
  public ConstraintVisitingInfo(final JvmTypeParameter initial) {
    this.visiting = CollectionLiterals.<JvmTypeParameter>newHashSet(initial);
  }
  
  public boolean tryVisit(final JvmTypeParameter parameter) {
    return this.visiting.add(parameter);
  }
  
  public boolean canVisit(final JvmTypeParameter parameter) {
    boolean _contains = this.visiting.contains(parameter);
    return (!_contains);
  }
  
  public void didVisit(final JvmTypeParameter parameter) {
    this.visiting.remove(parameter);
  }
  
  public void pushInfo(final JvmTypeParameterDeclarator declarator, final int idx) {
    if ((declarator == null)) {
      throw new NullPointerException("declarator may not be null");
    }
    this.declarator = declarator;
    this.idx = idx;
  }
  
  public JvmTypeParameterDeclarator getCurrentDeclarator() {
    return this.declarator;
  }
  
  public int getCurrentIndex() {
    return this.idx;
  }
}
