/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import static org.eclipse.xtext.util.Files.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.GeneratorWarning;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlrStandaloneSetup;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.base.Joiner;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugAntlrGeneratorFragment extends AbstractAntlrGeneratorFragment {

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		issues.addInfo("Generate debugging grammar file");
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		String srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath();
		String absoluteGrammarFileName = srcGenPath+"/"+getGrammarFileName(grammar, getNaming()).replace('.', '/')+".g";
		prettyPrint(absoluteGrammarFileName);
	}

	protected void prettyPrint(String absoluteGrammarFileName) {
		try {
			String content = readFileIntoString(absoluteGrammarFileName);
			Injector injector = new SimpleAntlrStandaloneSetup().createInjectorAndDoEMFRegistration();
			XtextResource resource = injector.getInstance(XtextResource.class);
			resource.setURI(URI.createFileURI(absoluteGrammarFileName));
			resource.load(new StringInputStream(content), null);
			if (!resource.getErrors().isEmpty()) {
				String errors = Joiner.on('\n').join(resource.getErrors());
				throw new GeneratorWarning("Non fatal problem: Debug grammar could not be formatted due to:\n" + errors);
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(content.length());
			resource.save(outputStream, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
			writeStringIntoFile(absoluteGrammarFileName, outputStream.toString());
		} catch(IOException e) {
			throw new GeneratorWarning(e.getMessage());
		}
	}

	public String getGrammarFileName(Grammar g, Naming naming) {
		return naming.basePackageRuntime(g) + ".parser.antlr.internal.DebugInternal" + GrammarUtil.getName(g);
	}
}
