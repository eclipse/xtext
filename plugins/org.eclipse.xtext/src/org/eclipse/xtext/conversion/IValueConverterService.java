package org.eclipse.xtext.conversion;

import org.eclipse.xtext.service.ILanguageService;

public interface IValueConverterService extends ILanguageService {
	public Object toValue(String string, String lexerRule);
	public String toString(Object value, String lexerRule);
}
