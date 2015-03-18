/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.tests.macro.Bug446364Processor;
import org.eclipse.xtend.lib.macro.Active;

@Active(Bug446364Processor.class)
public @interface Bug446364 {
  public String value();
}
