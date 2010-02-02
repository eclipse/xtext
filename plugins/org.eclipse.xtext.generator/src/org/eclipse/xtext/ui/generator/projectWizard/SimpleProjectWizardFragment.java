/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.projectWizard;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.XpandUtil;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Naming;

import com.google.common.collect.Lists;

/**
 * An {@link IGeneratorFragment} to generate a simple project wizard.
 *  
 * @author Sven Efftinge - Initial contribution and API
 * @author Knut Wannheden
 */
public class SimpleProjectWizardFragment extends AbstractGeneratorFragment {

	private static final Logger LOG = Logger.getLogger(SimpleProjectWizardFragment.class);

	private String generatorProjectName;
	private String modelFileExtension;

	@Override
	public void generate(final Grammar grammar, XpandExecutionContext ctx) {
		final String templateName = getNewProjectTemplateName(grammar, getNaming());
		final Outlet outlet = ctx.getOutput().getOutlet(Generator.SRC_UI);
		final File templateFile = new File(new File(outlet.getPath()), templateName.replaceAll("::", "/") + '.' + XpandUtil.TEMPLATE_EXTENSION);
		final boolean templateExisted = templateFile.exists();
		List<Object> parameters = getParameters(grammar);
		parameters.add(outlet.getFileEncoding());
		XpandFacade.create(ctx).evaluate2(getTemplate()+"::generate", grammar, parameters);
		if (!templateExisted && templateFile.exists()) {
			LOG.info("A new template " + templateName + " has been generated into " + outlet.getPath() + ".");
			LOG.info("  Make sure to enable the Xtend/Xpand nature and JavaBeans metamodel to edit this template.");
		}
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] {
				"org.eclipse.ui",
				"org.eclipse.core.runtime",
				"org.eclipse.core.resources",
				"org.eclipse.ui.ide",
				"org.eclipse.xtend",
				"org.eclipse.xpand"
			};
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.xtext.ui.wizard.IProjectCreator",
						GrammarUtil.getNamespace(grammar)+".ui.wizard." + GrammarUtil.getName(grammar) + "ProjectCreator")
			.getBindings();
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Lists.<Object> newArrayList(getGeneratorProjectName(grammar), getModelFileExtension(grammar));
	}

	private String getGeneratorProjectName(Grammar g) {
		if (generatorProjectName != null) {
			return generatorProjectName;
		}
		throw new IllegalStateException(getClass().getName()
				+ " : The property 'generatorProjectName' is mandatory but has not been configured.");
	}

	public String getModelFileExtension(Grammar g) {
		if (modelFileExtension == null) {
			modelFileExtension = GrammarUtil.getName(g).toLowerCase();
			if (LOG.isInfoEnabled())
				LOG.info("No explicit 'modelFileExtension' configured. Using '" + modelFileExtension + "'.");
		}
		return modelFileExtension;
	}

	/**
	 * Sets the name of the generator project.
	 * 
	 * @param generatorProjectName
	 */
	public void setGeneratorProjectName(String generatorProjectName) {
		if (generatorProjectName == null || "".equals(generatorProjectName.trim())) {
			return;
		}
		this.generatorProjectName = generatorProjectName.trim();
	}

	/**
	 * Sets the file extension used when creating the initial sample model.
	 * 
	 * @param modelFileExtension
	 */
	public void setModelFileExtension(String modelFileExtension) {
		if (modelFileExtension == null || "".equals(modelFileExtension.trim())) {
			return;
		}
		this.modelFileExtension = modelFileExtension.trim();
	}

	public static String getNewProjectTemplateName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar).replace(".", "::") + "::wizard::"
				+ GrammarUtil.getName(grammar) + "NewProject";
	}
}
