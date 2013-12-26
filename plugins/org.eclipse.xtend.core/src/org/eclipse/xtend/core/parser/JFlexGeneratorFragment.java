/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.Generator;

import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.google.common.io.InputSupplier;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JFlexGeneratorFragment extends AbstractGeneratorFragment {
	
	private JFlexMain main;
	
	private String patternPath;
	
	private String additionalRulePath;
	
	@Mandatory
	public void setJFlexMain(JFlexMain main) {
		this.main = main;
	}
	
	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		final String srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath();
		final String directory = srcGenPath + '/' + getNaming().asPath(getNaming().basePackageRuntime(grammar) + ".parser.antlr.internal");
		String fileName = "Internal" + GrammarUtil.getName(grammar)	+ "Flexer.flex";
		main.runJFlex(new String[] {
				"-d",
				directory,
				directory + "/" + fileName
		});
	}
	
	public void setPatternPath(String patternPath) {
		this.patternPath = patternPath;
	}
	
	public void setAdditionalRulePath(String rulePath) {
		this.additionalRulePath = rulePath;
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Lists.<Object>newArrayList(read(patternPath), read(additionalRulePath));
	}

	private String read(final String path) {
		if (path != null) {
			try {
				String patterns = CharStreams.toString(new InputSupplier<InputStreamReader>() {
					public InputStreamReader getInput() throws IOException {
						return new InputStreamReader(getClass().getResourceAsStream(path), "ISO-8859-1");
					}
				});
				return patterns;	
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
	
}
