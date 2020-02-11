/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.junit;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.Naming;

import com.google.common.collect.Lists;

/**
 * @author Michael Clay - Initial contribution and API
 */
@Deprecated
public class Junit4Fragment extends AbstractGeneratorFragment {
	private static final Logger log = Logger.getLogger(Junit4Fragment.class);
	
	private boolean useDeprecatedClasses = true;
	
	/**
	 * @since 2.11
	 */
	public boolean isUseDeprecatedClasses() {
		return useDeprecatedClasses;
	}

	/**
	 * @since 2.11
	 */
	public void setUseDeprecatedClasses(boolean useDeprecatedClasses) {
		this.useDeprecatedClasses = useDeprecatedClasses;
	}

	@Deprecated
	private boolean genContentAssistTest;

	@Deprecated
	public boolean isGenContentAssistTest() {
		return genContentAssistTest;
	}

	@Deprecated
	public void setGenContentAssistTest(boolean genUiTest) {
		this.genContentAssistTest = genUiTest;
	}

	public static String getQualifiedInjectorProviderName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + "." + GrammarUtil.getSimpleName(grammar) + "InjectorProvider";
	}

	public static String getQualifiedUiInjectorProviderName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + "." + GrammarUtil.getSimpleName(grammar) + "UiInjectorProvider";
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (getNaming().getPathTestProject()!=null) {
			if (log.isInfoEnabled()) {
				log.info("generating Junit4 Test support classes");
			}
			super.generate(grammar, ctx);
		} else {
			log.warn("skip execution of '"+getClass().getName()+"' due to missing configuration");
		}
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Lists.<Object>newArrayList(this);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (getNaming().getPathTestProject()==null) {
			issues.addWarning("Missing test project path configuration 'Generator#pathTestProject' required for fragment '"+getClass().getName()+"'.");
		}
	}

	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		return new String[] { getNaming().activatorPackageName()};
	}
	
	/**
	 * @since 2.3
	 */
	@Override
	public String[] getRequiredBundlesTests(Grammar grammar) {
		List<String> bundles = Lists.newArrayList(
			getNaming().getProjectNameRt(),
			getTestingPackage(),
			"org.eclipse.xtext.xbase.lib"
		);
		if (getNaming().hasUI()) {
			bundles.add(getNaming().getProjectNameUi());
			bundles.add("org.eclipse.core.runtime");
			bundles.add("org.eclipse.ui.workbench;resolution:=optional");
		}
		return bundles.toArray(new String[bundles.size()]);
	}
	
	/**
	 * @since 2.11
	 */
	public String getTestingPackage() {
		if (useDeprecatedClasses)
			return "org.eclipse.xtext.junit4";
		else
			return "org.eclipse.xtext.testing";
	}

	/**
	 * @since 2.3
	 */
	@Override
	public String[] getExportedPackagesTests(Grammar grammar) {
		return new String[]{ getNaming().basePackageRuntime(grammar) };
	}

	/**
	 * @since 2.3
	 */
	@Override
	public String[] getImportedPackagesTests(Grammar grammar) {
		return new String[] {
				"org.junit.runner;version=\"4.5.0\"",
				"org.junit.runner.manipulation;version=\"4.5.0\"",
				"org.junit.runner.notification;version=\"4.5.0\"",
				"org.junit.runners;version=\"4.5.0\"",
				"org.junit.runners.model;version=\"4.5.0\"",
				"org.hamcrest.core"
		};
	}



}
