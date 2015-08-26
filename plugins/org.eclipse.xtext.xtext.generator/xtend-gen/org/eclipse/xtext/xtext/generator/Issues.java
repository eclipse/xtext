/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

@SuppressWarnings("all")
public interface Issues {
  public abstract void addError(final String message);
  
  public abstract void addError(final String message, final Object source);
  
  public abstract void addWarning(final String message);
  
  public abstract void addWarning(final String message, final Object source);
}
