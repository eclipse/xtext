/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractInheritingGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

import com.google.common.collect.Lists;

/**
 * {@link IGeneratorFragment} to generate a java based validity checker for a given grammar.
 * 
 * @author Michael Clay - Initial contribution and API
 */
@Deprecated
public class JavaValidatorFragment extends AbstractInheritingGeneratorFragment {
	private static final Logger log = Logger.getLogger(JavaValidatorFragment.class);
	private final List<String> composedChecks = new ArrayList<String>();
	private String basePackage;

	public String getGeneratedEPackageName(Grammar g, Naming n, EPackage pack) {
		return getBasePackage(g, n) + "." + pack.getName() + "." + Strings.toFirstUpper(pack.getName()) + "Package";
	}

	public static String getValidationPackage(Grammar grammar, Naming n) {
		return n.basePackageRuntime(grammar) + ".validation";
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[] { getValidationPackage(grammar, getNaming()) };
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getBasePackage(Grammar g, Naming n) {
		if (basePackage != null) {
			return basePackage;
		}
		return n.basePackageRuntime(g);
	}

	/**
	 * Adds a validator that is to be executed additionally.
	 * 
	 * @param composedCheckValidator
	 *            name of a class extending {@link AbstractDeclarativeValidator}.
	 */
	public void addComposedCheck(String composedCheckValidator) {
		this.composedChecks.add(composedCheckValidator);
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (log.isInfoEnabled()) {
			log.info("generating Java-based EValidator API");
		}
		XpandFacade.create(ctx).evaluate2(getTemplate() + "::generate", grammar, getParameters(grammar));
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory().addTypeToTypeEagerSingleton(getValidatorName(grammar, "", getNaming()),
				getValidatorName(grammar, "", getNaming())).getBindings();
	}

	public static String getValidatorName(Grammar g, String prefix, Naming n) {
		return n.basePackageRuntime(g) + ".validation." + prefix + GrammarUtil.getSimpleName(g) + "JavaValidator";
	}

	protected String getValidatorSuperClassName(Grammar grammar) {
		Grammar superGrammar = Util.getNonTerminalsSuperGrammar(grammar);
		if (isInheritImplementation() && superGrammar != null) 
			return getValidatorName(superGrammar, "", getNaming());
		else 
			return getDefaultValidatorSuperClassName();
	}

	protected String getDefaultValidatorSuperClassName() {
		return "org.eclipse.xtext.validation.AbstractDeclarativeValidator";
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		List<String> packageQNames = new ArrayList<String>();
		List<GeneratedMetamodel> list = EcoreUtil2.typeSelect(grammar.getMetamodelDeclarations(),
				GeneratedMetamodel.class);
		for (GeneratedMetamodel generatedMetamodel : list) {
			packageQNames.add(getGeneratedEPackageName(grammar, getNaming(), generatedMetamodel.getEPackage()));
		}
		List<Object> parameters = Lists.newArrayList((Object) packageQNames);
		parameters.add(this.composedChecks);
		parameters.add(getValidatorSuperClassName(grammar));
		return parameters;
	}
}
