/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;

import com.google.common.collect.Lists;

/**
 * {@link IGeneratorFragment} to generate a java based validity checker for a given grammar.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class JavaValidatorFragment extends AbstractValidatorFragment {
	private static final Logger log = Logger.getLogger(JavaValidatorFragment.class);
	private final List<String> composedChecks = new ArrayList<String>();
	private String basePackage;
	
	@Override
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	
	@Override
	public String getBasePackage(Grammar g, Naming n) {
		if (basePackage != null) {
			return basePackage;
		}
		return super.getBasePackage(g, n);
	}

	/**
	 * Adds a validator that is to be executed additionally.
	 * 
	 * @param composedCheckValidator
	 *            name of a class extending {@link org.eclipse.emf.validation.internal.service.AbstractValidator<T>}.
	 */
	public void addComposedCheck(String composedCheckValidator) {
		this.composedChecks.add(composedCheckValidator);
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (log.isInfoEnabled())
			log.info("executing generate for " + getClass().getName());
		XpandFacade.create(ctx).evaluate2(getTemplate() + "::generate", grammar, getParameters(grammar));
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory().addTypeToTypeEagerSingleton(getValidatorName(grammar, "", getNaming()),
				getValidatorName(grammar, "", getNaming())).getBindings();
	}

	public static String getValidatorName(Grammar g, String prefix, Naming n) {
		return n.basePackageRuntime(g) + ".validation." + prefix + GrammarUtil.getName(g) + "JavaValidator";
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		List<Object> parameters = Lists.newArrayList(super.getParameters(grammar));
		parameters.add(this.composedChecks);
		return parameters;
	}
}
