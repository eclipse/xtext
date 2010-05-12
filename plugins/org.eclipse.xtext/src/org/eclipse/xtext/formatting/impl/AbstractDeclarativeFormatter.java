/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.formatting.IElementMatcherProvider;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementMatcher;
import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.ElementLocator;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractDeclarativeFormatter extends BaseFormatter {

	private FormattingConfig config;

	private IGrammarAccess grammarAccess;

	@Inject
	private IHiddenTokenHelper hiddenTokenHelper;

	@Inject
	private IElementMatcherProvider matcherProvider;

	protected abstract void configureFormatting(FormattingConfig config);

	@Override
	public ITokenStream createFormatterStream(String indent, ITokenStream out, boolean preserveWhitespaces) {
		return new FormattingConfigBasedStream(out, indent, getConfig(), createMatcher(), hiddenTokenHelper,
				preserveWhitespaces);
	}

	@SuppressWarnings("deprecation")
	protected FormattingConfig createFormattingConfig() {
		FormattingConfig cfg = new FormattingConfig(hiddenTokenHelper);
		cfg.setWhitespaceRule(getWSRule());
		return cfg;
	}

	protected IElementMatcher<ElementLocator> createMatcher() {
		return matcherProvider.createMatcher(getConfig().getLocatorsForSemanticTokens());
	}

	protected synchronized FormattingConfig getConfig() {
		if (config == null) {
			config = createFormattingConfig();
			configureFormatting(config);
		}
		return config;
	}

	protected IGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}

	protected void saveDebugGraphvizDiagram(String filename) {
		try {
			File file = new File(filename).getCanonicalFile();
			System.out.println("Saving Graphviz diagram to " + file);
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
			new ElementMatcherToDot().draw(createMatcher(), ps);
			ps.flush();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Inject
	public void setGrammarAccess(IGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

}
