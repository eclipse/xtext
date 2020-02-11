/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;

/**
 * Annotate methods in your own {@link AbstractDeclarativeValueConverterService}
 * to mark them as contributions to all known value converters.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface ValueConverter {
	/**
	 * The name of the rule that is converted by this value converter.
	 * May be a qualified name, e.g. {@code com.acme.MySuperLang.MyDataTypeRule} to
	 * provide value converters for inherited rules that are called with the explicit
	 * notation {@code super::MyDataTypeRule} or {@code com::acme::MySuperLang::MyDataTypeRule}.
	 */
	String rule();
}
