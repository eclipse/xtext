/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.conversion;

import java.util.Set;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.conversion.impl.INTValueConverter;
import org.eclipse.xtext.conversion.impl.KeywordAlternativeConverter;
import org.eclipse.xtext.conversion.impl.KeywordBasedValueConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableSet;
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
	
	public static class OtherOperatorsValueConverter extends AbstractValueConverter<String> {

		private final static Set<String> operators = ImmutableSet.of(
			"->",
			"..",
			"..<",
			">..",
			"=>",
			">>",
			">>>",
			"<<",
			"<<<",
			"<>",
			"?:",
			"<=>");
		
		@Override
		public String toValue(String string, INode node) throws ValueConverterException {
			return string;
		}

		@Override
		public String toString(String value) throws ValueConverterException {
			if (!operators.contains(value))
				throw new ValueConverterException("'" + value + "' is not a valid operator.", null, null);
			return value;
		}
		
	}
	
	public static class CompareOperatorsValueConverter extends AbstractValueConverter<String> {

		private final static Set<String> operators = ImmutableSet.of(
			">=",
			"<=",
			">",
			"<");
		
		@Override
		public String toValue(String string, INode node) throws ValueConverterException {
			return string;
		}

		@Override
		public String toString(String value) throws ValueConverterException {
			if (!operators.contains(value))
				throw new ValueConverterException("'" + value + "' is not a valid operator.", null, null);
			return value;
		}
		
	}
	
	public static class MultiAssignOperatorsValueConverter extends AbstractValueConverter<String> {

		private final static Set<String> operators = ImmutableSet.of(
			"+=",
			"-=",
			"*=",
			"/=",
			"&=",
			"|=",
			"^=",
			"%=",
			"<<=",
			">>=",
			">>>=");
		
		@Override
		public String toValue(String string, INode node) throws ValueConverterException {
			return string;
		}

		@Override
		public String toString(String value) throws ValueConverterException {
			if (!operators.contains(value))
				throw new ValueConverterException("'" + value + "' is not a valid operator.", null, null);
			return value;
		}
		
	}

	@Inject
	private XbaseQualifiedNameValueConverter qualifiedNameValueConverter;
	
	@Inject
	private XbaseQualifiedNameInStaticImportValueConverter qualifiedNameInStaticImportValueConverter;
	
	@Inject
	private Provider<KeywordBasedValueConverter> keywordBasedConverterProvider;
	
	@Inject
	private OtherOperatorsValueConverter otherOperatorsValueConverter;
	
	@Inject
	private CompareOperatorsValueConverter compareOperatorsValueConverter;
	
	@Inject
	private MultiAssignOperatorsValueConverter multiAssignOperatorsValueConverter;
	
	@Inject
	private KeywordAlternativeConverter validIDConverter;
	
	@Inject
	private KeywordAlternativeConverter featureCallIDConverter;
	
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
	
	@ValueConverter(rule = "FeatureCallID")
	public IValueConverter<String> getFeatureCallIDValueConverter() {
		return featureCallIDConverter;
	}
	
	@ValueConverter(rule = "QualifiedName")
	public IValueConverter<String> getQualifiedNameValueConverter() {
		return qualifiedNameValueConverter;
	}
	
	@ValueConverter(rule = "QualifiedNameWithWildcard")
	public IValueConverter<String> getQualifiedNameWithWildCardValueConverter() {
		return getQualifiedNameValueConverter();
	}
	
	@ValueConverter(rule = "QualifiedNameInStaticImport")
	public IValueConverter<String> getQualifiedNameInStaticImportValueConverter() {
		return qualifiedNameInStaticImportValueConverter;
	}
	
	@ValueConverter(rule = "OpSingleAssign")
	public IValueConverter<String> getOpSingleAssignConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpMultiAssign")
	public IValueConverter<String> getOpMultiAssignConverter() {
		return multiAssignOperatorsValueConverter;
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
		return compareOperatorsValueConverter;
	}
	
	@ValueConverter(rule = "OpOther")
	public IValueConverter<String> getOpOtherConverter() {
		return otherOperatorsValueConverter;
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
	
	@ValueConverter(rule = "OpPostfix")
	public IValueConverter<String> getOpPostfixConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@Inject
	private IntUnderscoreValueConverter intUnderscoreValueConverter;
	
	@Override
	@ValueConverter(rule = "INT")
	public IValueConverter<Integer> INT() {
		return intUnderscoreValueConverter;
	}
	
	public static class IntUnderscoreValueConverter extends INTValueConverter {
		@Override
		public Integer toValue(String string, INode node) {
			if (Strings.isEmpty(string))
				throw new ValueConverterException("Couldn't convert empty string to an int value.", node, null);
			String withoutUnderscore = string.replace("_", "");
			if (Strings.isEmpty(withoutUnderscore))
				throw new ValueConverterException("Couldn't convert input '" + string + "' to an int value.", node, null);
			return super.toValue(withoutUnderscore, node);
		}
	}
}
