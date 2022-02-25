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
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Creates a default {@link Object#toString toString} implementation.
 * 
 * <p>
 * All non-static fields of this class and all of its superclasses are used.
 * Reflection is used to access all fields if this class has a superclass. This may not work in restrictive environments.
 * For such cases use {@link ToStringBuilder} to write a non-reflective implementation.
 * </p>
 * The default format is:
 * <pre>
 *  ClassName [
 *    field1 = "Foo"
 *    field2 = 2
 *    field3 = null
 *  ]
 * </pre>
 * 
 * The class name is hardcoded. Subclasses which inherit this class without overriding <code>toString</code> will show the same name.
 * 
 * </p>
 * <p>
 * For brevity there are options to hide field names, skip fields with null values and print everything on one line.
 * </p>
 * @since 2.7
 */
@Beta
@Target(ElementType.TYPE)
@Active(ToStringProcessor.class)
@GwtCompatible
@SuppressWarnings("all")
public @interface ToString {
  /**
   * Fields with null values are not shown in the output.
   */
  public boolean skipNulls() default false;
  /**
   * Seperate fields with a comma and a single space
   */
  public boolean singleLine() default false;
  /**
   * Only list the values of the fields, not their names
   */
  public boolean hideFieldNames() default false;
  /**
   * By default, Iterables, Arrays and multiline Strings are pretty-printed.
   * Switching to their normal representation makes the toString method significantly faster.
   * @since 2.9
   */
  public boolean verbatimValues() default false;
}
