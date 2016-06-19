/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.tests.macro.CheckMutableInterfaceDeclarationProcessor;
import org.eclipse.xtend.lib.macro.Active;

@Active(CheckMutableInterfaceDeclarationProcessor.class)
public @interface CheckMutableInterfaceDeclaration {
}
