/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util.internal;

import com.google.common.annotations.Beta;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.macro.Active;

@Beta
@Target(ElementType.TYPE)
@Active(LogProcessor.class)
public @interface Log {
}
