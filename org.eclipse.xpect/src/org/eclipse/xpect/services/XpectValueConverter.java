package org.eclipse.xpect.services;

import java.util.Set;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.ImmutableSet;

public class XpectValueConverter extends DefaultTerminalConverters {

	public class IDConverter extends AbstractNullSafeConverter<String> {

		private Set<String> allKeywords = ImmutableSet.copyOf(GrammarUtil
				.getAllKeywords(getGrammar()));

		@Override
		protected String internalToValue(String string, INode node) {
			return string.replaceAll("[\\^\\s]", "");
		}

		@Override
		protected String internalToString(String value) {
			if (allKeywords.contains(value))
				return "^" + value;
			return value;
		}
	}

	private IDConverter idValueConverter;

	@ValueConverter(rule = "INVOCATION")
	public IValueConverter<String> INVOCATION() {
		if (idValueConverter == null)
			idValueConverter = new IDConverter();
		return idValueConverter;
	}

}
