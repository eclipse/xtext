/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ide.types;

import org.eclipse.xtext.naming.QualifiedName;

@SuppressWarnings("all")
public interface ITypeDescriptor {
  public abstract String getName();
  
  public abstract String getSimpleName();
  
  public abstract QualifiedName getQualifiedName();
  
  public abstract int getAccessFlags();
}
