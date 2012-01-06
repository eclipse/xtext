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
import org.eclipse.xtext.conversion.impl.KeywordAlternativeConverter;
import org.eclipse.xtext.conversion.impl.KeywordBasedValueConverter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * <p>The value converter service for Xbase. It registers
 * the {@link QualifiedNameValueConverter} and a {@link KeywordBasedValueConverter}
 * for each operator.</p>
 * <p>Clients, who extend Xbase should inherit from this value converter service.</p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XbaseValueConverterService extends DefaultTerminalConverters {

	@Inject
	private XbaseQualifiedNameValueConverter qualifiedNameValueConverter;
	
	@Inject
	private StaticQualifierValueConverter staticQualifierConverter;
	
	@Inject
	private Provider<KeywordBasedValueConverter> keywordBasedConverterProvider;
	
	@Inject
	private KeywordAlternativeConverter validIDConverter;
	
	@Inject
	private KeywordAlternativeConverter idOrSuperConverter;
	
	@ValueConverter(rule = "IdOrSuper")
	public IValueConverter<String> getIdOrSuperValueConverter() {
		return idOrSuperConverter;
	}
	
	@ValueConverter(rule = "ValidID")
	public IValueConverter<String> getValidIDConverter() {
		return validIDConverter;
	}
	
	@ValueConverter(rule = "QualifiedName")
	public IValueConverter<String> getQualifiedNameValueConverter() {
		return qualifiedNameValueConverter;
	}
	
	@ValueConverter(rule = "StaticQualifier")
	public IValueConverter<String> getStaticQualifierConverter() {
		return staticQualifierConverter;
	}
	
	@ValueConverter(rule = "OpSingleAssign")
	public IValueConverter<String> getOpSingleAssignConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpMultiAssign")
	public IValueConverter<String> getOpMultiAssignConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpOr")
	public IValueConverter<String> getOpOrConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpAnd")
	public IValueConverter<String> getOpAndConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpEquality")
	public IValueConverter<String> getOpEqualityConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpCompare")
	public IValueConverter<String> getOpCompareConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpOther")
	public IValueConverter<String> getOpOtherConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpAdd")
	public IValueConverter<String> getOpAddConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpMulti")
	public IValueConverter<String> getOpMultiConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpUnary")
	public IValueConverter<String> getOpUnaryConverter() {
		return keywordBasedConverterProvider.get();
	}
	
}
