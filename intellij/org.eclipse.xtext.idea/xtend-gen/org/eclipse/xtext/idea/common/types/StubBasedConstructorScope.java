/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types;

import org.eclipse.xtext.common.types.xtext.AbstractConstructorScope;
import org.eclipse.xtext.idea.common.types.StubBasedTypeScope;

@SuppressWarnings("all")
public class StubBasedConstructorScope extends AbstractConstructorScope {
  protected StubBasedConstructorScope(final StubBasedTypeScope typeScope) {
    super(typeScope);
  }
}
