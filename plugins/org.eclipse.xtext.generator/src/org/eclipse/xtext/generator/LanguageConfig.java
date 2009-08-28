/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.generator.ImplicitUiFragment;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class LanguageConfig extends CompositeGeneratorFragment {

	private final class ToStringFunction implements Function<IGeneratorFragment, String> {
		private String delim;

		/**
		 * @param string
		 */
		public ToStringFunction(String string) {
			this.delim = string;
		}

		public String apply(IGeneratorFragment from) {
			if (from instanceof CompositeGeneratorFragment) {
				return Strings.toString(((CompositeGeneratorFragment) from).fragments, this, delim);
			}
			return from.getClass().getSimpleName();
		}
	}

	private final static Logger LOG = Logger.getLogger(LanguageConfig.class);
	private Grammar grammar;

	private List<String> fileExtensions = new ArrayList<String>();

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (LOG.isInfoEnabled()) {
			LOG.info("generating infrastructure for " + grammar.getName() + " with fragments : "
					+ Strings.toString(this.fragments, new ToStringFunction(", "), ", "));
		}
		super.generate(grammar, ctx);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (getGrammar() == null) {
			issues.addError("property 'uri' is mandatory for element 'language'.", this);
		}
	}

	public void setFileExtensions(String fileExtensions) {
		if ("".equals(fileExtensions.trim()))
			return;
		String[] split = fileExtensions.split("\\s*,\\s*");
		for (String string : split) {
			this.fileExtensions.add(string);
		}
	}

	public List<String> getFileExtensions(Grammar g) {
		if (fileExtensions.isEmpty()) {
			String lowerCase = GrammarUtil.getName(g).toLowerCase();
			if (LOG.isInfoEnabled())
				LOG.info("No explicit fileExtensions configured. Using '*." + lowerCase + "'.");
			return Collections.singletonList(lowerCase);
		}
		return fileExtensions;
	}

	public void initialize(boolean isUi) {
		if (isUi)
			this.fragments.add(0, new ImplicitUiFragment(getFileExtensions(getGrammar())));
		this.fragments.add(0, new ImplicitRuntimeFragment());
	}

	public void setUri(String uri) {
		XtextResourceSet rs = new XtextResourceSet();
		XtextResource resource = (XtextResource) rs.getResource(URI.createURI(uri), true);
		if (resource.getContents().isEmpty()) {
			throw new IllegalArgumentException("Couldn't load grammar for '" + uri + "'.");
		}
		if (!resource.getErrors().isEmpty()) {
			throw new IllegalStateException(resource.getErrors().toString());
		}

		final Grammar grammar = (Grammar) resource.getContents().get(0);
		EValidator validator = EValidator.Registry.INSTANCE.getEValidator(XtextPackage.eINSTANCE);
		if (validator != null) {
			DiagnosticChain chain = new DiagnosticChain() {

				public void add(Diagnostic diagnostic) {
					if (diagnostic.getSeverity() == Diagnostic.ERROR) {
						if (diagnostic.getException() == null)
							throw new IllegalStateException(diagnostic.getMessage());
						else
							throw new IllegalStateException(diagnostic.getMessage(), diagnostic.getException());
					}
				}

				public void addAll(Diagnostic diagnostic) {
					add(diagnostic);
				}

				public void merge(Diagnostic diagnostic) {
					throw new UnsupportedOperationException();
				}
			};
			validator.validate(grammar, chain, null);
			TreeIterator<EObject> iterator = grammar.eAllContents();
			while (iterator.hasNext())
				validator.validate(iterator.next(), chain, null);
		}
		this.grammar = grammar;
	}

	/**
	 * @return
	 */
	public Grammar getGrammar() {
		return grammar;
	}

}
