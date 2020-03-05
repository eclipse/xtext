/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package lazy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import lazy.LazyProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * Adds a lazy getter and an initializer method.
 */
@Target(ElementType.FIELD)
@Active(LazyProcessor.class)
@SuppressWarnings("all")
public @interface Lazy {
}
