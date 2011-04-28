/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.valueconverter;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;

import com.google.inject.Singleton;

/**
 * Adds a value conversion for the QualifiedNameWithWildCard rule.
 * 
 * @author Jan Koehnlein
 */
@Singleton
public class DomainmodelValueConverterService extends XbaseValueConverterService {

	@ValueConverter(rule = "QualifiedNameWithWildCard")
	public IValueConverter<String> getQualifiedNameWithWildCard() {
		return getQualifiedNameValueConverter();
	}
	
}
