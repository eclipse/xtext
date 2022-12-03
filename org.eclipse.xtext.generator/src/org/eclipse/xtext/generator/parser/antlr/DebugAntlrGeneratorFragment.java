/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.GeneratorWarning;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlrRuntimeModule;
import org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlrStandaloneSetup;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtext.generator.parser.antlr.DebugGrammarToken;

import com.google.common.base.Joiner;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class DebugAntlrGeneratorFragment extends AbstractAntlrGeneratorFragment {

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		issues.addInfo("Generate debugging grammar file");
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		DebugGrammarToken token = DebugGrammarToken.aquire();
		try {
			super.generate(grammar, ctx);
			String srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath();
			String absoluteGrammarFileName = srcGenPath+"/"+getGrammarFileName(grammar, getNaming()).replace('.', '/')+".g";
			prettyPrint(absoluteGrammarFileName, Charset.forName(getEncoding(ctx, Generator.SRC_GEN)));
		} finally {
			token.done();
		}
	}
	
	/**
	 * @since 2.7
	 */
	protected void prettyPrint(String absoluteGrammarFileName, Charset encoding) {
		try {
			String content = readFileIntoString(absoluteGrammarFileName, encoding);
			final ILineSeparatorInformation lineSeparatorInformation = new ILineSeparatorInformation() {
				@Override
				public String getLineSeparator() {
					return DebugAntlrGeneratorFragment.this.getLineDelimiter();
				}
			};
			Injector injector = new SimpleAntlrStandaloneSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(new SimpleAntlrRuntimeModule() {
						@Override
						public void configure(Binder binder) {
							super.configure(binder);
							binder.bind(ILineSeparatorInformation.class).toInstance(lineSeparatorInformation);
						}
					});
				}
			}.createInjectorAndDoEMFRegistration();
			XtextResource resource = injector.getInstance(XtextResource.class);
			resource.setURI(URI.createFileURI(absoluteGrammarFileName));
			resource.load(new StringInputStream(content, encoding.name()),
					Collections.singletonMap(XtextResource.OPTION_ENCODING, encoding.name()));
			if (!resource.getErrors().isEmpty()) {
				String errors = Joiner.on(getLineDelimiter()).join(resource.getErrors());
				throw new GeneratorWarning("Non fatal problem: Debug grammar could not be formatted due to:" + getLineDelimiter() + errors);
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(content.length());
			resource.save(outputStream, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
			String toBeWritten = new NewlineNormalizer(getLineDelimiter()).normalizeLineDelimiters(
					new String(outputStream.toByteArray(), encoding.name()));
			writeStringIntoFile(absoluteGrammarFileName, toBeWritten, encoding);
		} catch(IOException e) {
			throw new GeneratorWarning(e.getMessage());
		}
	}

	/**
	 * @deprecated use {@link #prettyPrint(String, Charset)} instead.
	 */
	@Deprecated(forRemoval = true)
	protected void prettyPrint(String absoluteGrammarFileName) {
		prettyPrint(absoluteGrammarFileName, Charset.defaultCharset());
	}

	public String getGrammarFileName(Grammar g, Naming naming) {
		return naming.basePackageRuntime(g) + ".parser.antlr.internal.DebugInternal" + GrammarUtil.getSimpleName(g);
	}
}
