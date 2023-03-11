/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtext.common.types.JvmConstructor;

@SuppressWarnings("all")
public class JvmConstructorDeclarationImpl extends JvmExecutableDeclarationImpl<JvmConstructor> implements ConstructorDeclaration {
  @Override
  public String getSimpleName() {
    return this.getDeclaringType().getSimpleName();
  }
}
