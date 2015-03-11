/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * The annotated constructor or method causes no externally visible side-effects and 
 * does not mutate non-local state. 
 * 
 * In other words: if the result of a pure function or constructor is not used, it 
 * is dead code and is supposed to be removeable without changing the behavior of the 
 * program.
 * 
 * On {@link Inline}d methods this means the compiler cannot use the resulting Java
 * expression as a statement. 
 *  
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
    ElementType.CONSTRUCTOR,
    ElementType.METHOD})
@Documented
@Beta
@GwtCompatible public @interface Pure {

}
