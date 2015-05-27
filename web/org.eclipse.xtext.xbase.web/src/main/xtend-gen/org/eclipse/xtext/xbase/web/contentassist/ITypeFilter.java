/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.contentassist;

@SuppressWarnings("all")
public interface ITypeFilter {
  public abstract boolean accept(final int modifiers, final String packageName, final String simpleTypeName, final String[] enclosingTypeNames, final String path);
}
