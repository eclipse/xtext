/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.valueconverter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DomainmodelValueConverterService extends DefaultTerminalConverters {

	@Inject
	private QualifiedNameValueConverter qualifiedNameValueConverter;
	
	@ValueConverter(rule = "QualifiedName")
	public IValueConverter<String> QualifiedName() {
		return qualifiedNameValueConverter;
	}

	@ValueConverter(rule = "QualifiedNameWithWildCard")
	public IValueConverter<String> QualifiedNameWithWildCard() {
		return qualifiedNameValueConverter;
	}
	
}
