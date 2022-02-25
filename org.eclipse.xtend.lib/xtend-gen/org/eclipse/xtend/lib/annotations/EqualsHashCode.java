/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Arrays;
import org.eclipse.xtend.lib.macro.Active;

/**
 * Creates default implementations for {@link Object#equals(Object) equals} and {@link Object#hashCode hashCode}.
 * 
 * All non-static, non-transient fields are used. Subclasses are never equal to their superclasses.
 * If there is a superclass that overrides equals, then <code>super.equals()</code> and <code>super.hashCode</code> are also called.
 * Array-valued fields are compared using #{@link Arrays#deepEquals}.
 * @since 2.7
 */
@Beta
@GwtCompatible
@Target(ElementType.TYPE)
@Active(EqualsHashCodeProcessor.class)
@SuppressWarnings("all")
public @interface EqualsHashCode {
}
