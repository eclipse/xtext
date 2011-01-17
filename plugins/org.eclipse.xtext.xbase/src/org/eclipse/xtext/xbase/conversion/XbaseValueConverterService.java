/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.conversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * The value converter service for Xbase. It main purpose is to register
 * a qualified name converter.
 * Clients, who extend Xbase should inherit from this value converter service.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XbaseValueConverterService extends DefaultTerminalConverters {

	@Inject
	private QualifiedNameValueConverter qualifiedNameValueConverter;
	
	@ValueConverter(rule = "QualifiedName")
	public IValueConverter<String> getQualifiedNameValueConverter() {
		return qualifiedNameValueConverter;
	}
}
