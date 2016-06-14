/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.services;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;
import org.eclipse.xtext.conversion.impl.INTValueConverter;
import org.eclipse.xtext.conversion.impl.STRINGValueConverter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Default converters for Strings, Integers and IDs.
 */
@Singleton
public class DefaultTerminalConverters extends AbstractDeclarativeValueConverterService {
	
	@Inject
	private AbstractIDValueConverter idValueConverter;

	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		return idValueConverter;
	}

	@Inject
	private AbstractIDValueConverter terminalsIdValueConverter;

	/**
	 * @since 2.9
	 */
	@ValueConverter(rule = "org.eclipse.xtext.common.Terminals.ID")
	public IValueConverter<String> TerminalsID() {
		return terminalsIdValueConverter;
	}
	
	@Inject
	private INTValueConverter intValueConverter;
	
	@ValueConverter(rule = "INT")
	public IValueConverter<Integer> INT() {
		return intValueConverter;
	}
	
	@Inject
	private INTValueConverter terminalsIntValueConverter;
	
	/**
	 * @since 2.9
	 */
	@ValueConverter(rule = "org.eclipse.xtext.common.Terminals.INT")
	public IValueConverter<Integer> TerminalsINT() {
		return terminalsIntValueConverter;
	}

	@Inject
	private STRINGValueConverter stringValueConverter;
	
	@ValueConverter(rule = "STRING")
	public IValueConverter<String> STRING() {
		return stringValueConverter;
	}

	@Inject
	private STRINGValueConverter terminalsStringValueConverter;
	
	/**
	 * @since 2.9
	 */
	@ValueConverter(rule = "org.eclipse.xtext.common.Terminals.STRING")
	public IValueConverter<String> TerminalsSTRING() {
		return terminalsStringValueConverter;
	}

}
