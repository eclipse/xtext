/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/**
 * The annotated function assigns the returned value to the first argument.
 * 
 * That is, it is required that the first argument is a reference to an assignable
 * variable or field.
 * 
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.6
 */
@Beta
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
@Documented
@GwtCompatible
public @interface ReassignFirstArgument {

}
