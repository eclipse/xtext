/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.macro.Active;

/**
 * This annotation is used by the Xtend compiler.
 * It turns an annotated class into an immutable value object.
 * 
 * All fields become final and a getter method is added.
 * The fields' name are prepended with an underscore (i.e. <tt>myField</tt> becomes <tt>_myField</tt>)
 * One constructor for initializing the uninitialized fields is added.
 * {@link Object#equals(Object)} and {@link Object#hashCode()} implementations are added.
 * {@link Object#toString()} implementation is added.
 * 
 * @author Sven Efftinge
 * @deprecated use {@link org.eclipse.xtend.lib.annotations.Data} instead
 */
@Target(ElementType.TYPE)
@Active(DataProcessor.class)
@Deprecated
@Documented
@SuppressWarnings("all")
public @interface Data {
}
