/*******************************************************************************
 * Copyright (c) itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import static org.eclipse.xtext.GrammarUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Abstract base implementation for the {@link IValueConverterService}.
 * 
 * All methods that are annotated with {@link ValueConverter @ValueConverter} are
 * used to collect the strategies for this language. Furthermore, the {@link EFactory EMF factories}
 * are inspected to create converters for data types that have not yet been mapped.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractDeclarativeValueConverterService extends AbstractValueConverterService implements IValueConverterService.Introspectable {

	private static final Logger log = Logger.getLogger(AbstractDeclarativeValueConverterService.class);

	private Grammar grammar;
	
	// volatile because of http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
	private volatile Map<String, IValueConverter<Object>> converters;

	@Inject 
	protected DefaultTerminalConverter.Factory defaultTerminalConverterFactory;
	
	@Inject
	private RuleNames ruleNames;
	
	@Inject
	public void setGrammar(IGrammarAccess grammarAccess) {
		this.grammar = grammarAccess.getGrammar();
	}

	protected Grammar getGrammar() {
		return grammar;
	}

	@Override
	public String toString(Object value, String lexerRule) {
		return getConverter(lexerRule).toString(value);
	}

	@Override
	public Object toValue(String string, String lexerRule, INode node) throws ValueConverterException {
		return getConverter(lexerRule).toValue(string, node);
	}

	/**
	 * @since 2.7
	 */
	@Override
	@SuppressWarnings("unchecked")
	public IValueConverter<Object> getConverter(String lexerRule) {
		Map<String, IValueConverter<Object>> map = getConverters();
		if (map.containsKey(lexerRule)) {
			return map.get(lexerRule);
		}
		return (IValueConverter<Object>) IValueConverter.NO_OP_CONVERTER;
	}

	protected Map<String, IValueConverter<Object>> getConverters() {
		if (converters == null) {
			synchronized(this) {
				if (converters == null) {
					Map<String, IValueConverter<Object>> converters = Maps.newHashMap(); 
					internalRegisterForClass(getClass(), converters);
					this.converters = ImmutableMap.copyOf(converters);
				}
			}
		}
		return converters;
	}

	/**
	 * @since 2.4
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected void internalRegisterForClass(Class<?> clazz, Map<String, IValueConverter<Object>> converters) {
		recursiveRegisterForClass(clazz, converters);
		registerEFactoryConverters(converters);
	}

	/**
	 * @since 2.9
	 */
	protected void recursiveRegisterForClass(Class<?> clazz, Map<String, IValueConverter<Object>> converters) {
		Method[] methods = clazz.getDeclaredMethods();
		Set<String> thisConverters = Sets.newHashSet();
		recursiveRegisterForClass(methods, thisConverters, true, converters);
		recursiveRegisterForClass(methods, thisConverters, false, converters);
		if (clazz.getSuperclass() != null) {
			recursiveRegisterForClass(clazz.getSuperclass(), converters);
		}
	}

	private void recursiveRegisterForClass(Method[] methods, Set<String> thisConverters, boolean onlyExplicitConverters,
			Map<String, IValueConverter<Object>> converters) {
		for (Method method : methods) {
			if (isConfigurationMethod(method)) {
				try {
					String ruleName = method.getAnnotation(ValueConverter.class).rule();
					if (onlyExplicitConverters ^ ruleName.indexOf('.') < 0) {
						AbstractRule rule = GrammarUtil.findRuleForName(getGrammar(), ruleName);
						if (rule != null) {
							if (rule instanceof TerminalRule) {
								if (((TerminalRule) rule).isFragment())
									throw new IllegalStateException("Tried to register a value converter for a fragment terminal rule: '" + ruleName + "'");
							}
							if (!thisConverters.add(ruleName)) {
								throw new IllegalStateException("Tried to register two value converters for rule '" + ruleName + "'");
							}
							IValueConverter<Object> converter = registerIfMissing(ruleName, rule, method, converters);
							String qualifiedName = ruleNames.getQualifiedName(rule);
							registerIfMissing(qualifiedName, rule, converter, method, converters);
						} else {
							log.trace("Tried to register value converter for rule '" + ruleName
									+ "' which is not available in the grammar.");
						}
					}
				} catch (IllegalStateException e) {
					throw e;
				} catch (IllegalArgumentException e) {
					log.warn(e.getMessage(), e);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	private IValueConverter<Object> registerIfMissing(String name, AbstractRule rule, Method method,
			Map<String, IValueConverter<Object>> converters) throws IllegalAccessException, InvocationTargetException {
		if (!converters.containsKey(name)) {
			IValueConverter<Object> valueConverter = reflectiveGetConverter(method, rule);
			converters.put(name, valueConverter);
			return valueConverter;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private IValueConverter<Object> reflectiveGetConverter(Method method, AbstractRule rule)
			throws IllegalAccessException, InvocationTargetException {
		IValueConverter<Object> valueConverter = (IValueConverter<Object>) method.invoke(this);
		if (valueConverter instanceof IValueConverter.RuleSpecific)
			((IValueConverter.RuleSpecific) valueConverter).setRule(rule);
		return valueConverter;
	}
	
	private void registerIfMissing(String name, AbstractRule rule, IValueConverter<Object> valueConverter, Method method,
			Map<String, IValueConverter<Object>> converters) throws IllegalAccessException, InvocationTargetException {
		if (!converters.containsKey(name)) {
			if (valueConverter == null) {
				valueConverter = reflectiveGetConverter(method, rule);
			}
			converters.put(name, valueConverter);
		}
	}

	protected boolean isConfigurationMethod(Method method) {
		return method.isAnnotationPresent(ValueConverter.class) && method.getParameterTypes().length == 0
				&& IValueConverter.class.isAssignableFrom(method.getReturnType());
	}

	/**
	 * @since 2.4
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected void registerEFactoryConverters(Map<String, IValueConverter<Object>> converters) {
		for (ParserRule parserRule : allParserRules(getGrammar())) {
			if (isDatatypeRule(parserRule)) {
				registerIfMissing(parserRule.getName(), parserRule, converters);
				registerIfMissing(ruleNames.getQualifiedName(parserRule), parserRule, converters);
			}
		}
		for (TerminalRule terminalRule : allTerminalRules(getGrammar())) {
			if (!terminalRule.isFragment()) {
				registerIfMissing(terminalRule.getName(), terminalRule, converters);
				registerIfMissing(ruleNames.getQualifiedName(terminalRule), terminalRule, converters);
			}
		}
	}

	private void registerIfMissing(String name, TerminalRule terminalRule,
			Map<String, IValueConverter<Object>> converters) {
		if (!converters.containsKey(name)) {
			converters.put(name, defaultTerminalConverterFactory.create(terminalRule));
		}
	}

	private void registerIfMissing(String name, ParserRule parserRule,
			Map<String, IValueConverter<Object>> converters) {
		if (!converters.containsKey(name)) {
			EDataType datatype = (EDataType) parserRule.getType().getClassifier();
			converters.put(name, new EFactoryValueConverter(datatype));
		}
	}
	
	public void setDefaultTerminalConverterFactory(DefaultTerminalConverter.Factory defaultTerminalConverterFactory) {
		this.defaultTerminalConverterFactory = defaultTerminalConverterFactory;
	}
	
	public DefaultTerminalConverter.Factory getDefaultTerminalConverterFactory() {
		return defaultTerminalConverterFactory;
	}

}
