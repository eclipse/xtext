/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.ex;

import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment2;

import com.google.common.annotations.Beta;

/**
 * Use this fragment if you want to use an external lexer , e.g: in case the generated lexer has to be customized.
 *
 * @since 2.20
 * @author dietrich - Initial contribution and API
 */
@Beta
public class ExternalAntlrLexerFragment extends AbstractAntlrGeneratorFragment2 {
	
	private String lexerGrammar;

	private boolean highlighting;

	private boolean runtime;

	private boolean contentAssist;
	
	@Override
	protected void doGenerate() {
		if (runtime) {
			StringConcatenationClient binding = new StringConcatenationClient() {
				@Override
				protected void appendTo(TargetStringConcatenation target) {
					target.append("binder.bind(" + Lexer.class.getName() + ".class)"+
							".annotatedWith(com.google.inject.name.Names.named(" +
							"org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME" +
							")).to(" + lexerGrammar +".class);");
				}
			};
			new GuiceModuleAccess.BindingFactory().addConfiguredBinding("RuntimeLexer", binding).contributeTo(getLanguage().getRuntimeGenModule());
		}
		if (highlighting) {
				if (this.getProjectConfig().getEclipsePlugin().getRoot() != null) {
					StringConcatenationClient binding = new StringConcatenationClient() {
						@Override
						protected void appendTo(TargetStringConcatenation target) {
							target.append("binder.bind(" + Lexer.class.getName() + ".class)"+
									".annotatedWith(com.google.inject.name.Names.named(" +
									"org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING" +
									")).to(" + lexerGrammar +".class);");
						}
					};
					new GuiceModuleAccess.BindingFactory().addConfiguredBinding("HighlightingLexer", binding).contributeTo(getLanguage().getEclipsePluginGenModule());
				}
			}
			if (contentAssist) {
				if (this.getProjectConfig().getGenericIde().getRoot() != null) {
					StringConcatenationClient binding = new StringConcatenationClient() {
						@Override
						protected void appendTo(TargetStringConcatenation target) {
							target.append("binder.bind(org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer.class)"+
									".annotatedWith(com.google.inject.name.Names.named(" +
									"org.eclipse.xtext.ide.LexerIdeBindings.CONTENT_ASSIST" +
									")).to(" + lexerGrammar +".class);");
						}
					};
					new GuiceModuleAccess.BindingFactory().addConfiguredBinding("ContentAssistLexer", binding).contributeTo(getLanguage().getIdeGenModule());
			
				} 
				if (this.getProjectConfig().getEclipsePlugin().getRoot() != null) {
					StringConcatenationClient binding = new StringConcatenationClient() {
						@Override
						protected void appendTo(TargetStringConcatenation target) {
							target.append("binder.bind(org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer.class)"+
									".annotatedWith(com.google.inject.name.Names.named(" +
									"org.eclipse.xtext.ide.LexerIdeBindings.CONTENT_ASSIST" +
									")).to(" + lexerGrammar +".class);");
						}
					};
					new GuiceModuleAccess.BindingFactory().addConfiguredBinding("ContentAssistLexer", binding).contributeTo(getLanguage().getEclipsePluginGenModule());
				}
			}
			
			
		
		
		IXtextGeneratorFileSystemAccess srcGenFsa = this.getProjectConfig().getRuntime().getSrcGen();
		IXtextGeneratorFileSystemAccess srcFsa = this.getProjectConfig().getRuntime().getSrc();
		if (contentAssist || highlighting) {
			if (this.getProjectConfig().getGenericIde().getRoot() != null) {
				srcGenFsa = this.getProjectConfig().getGenericIde().getSrcGen();
				srcFsa = this.getProjectConfig().getGenericIde().getSrc();
			} else {
				srcGenFsa = this.getProjectConfig().getEclipsePlugin().getSrcGen();
				srcFsa = this.getProjectConfig().getEclipsePlugin().getSrc();
			}
		}
		String srcGenPath = srcGenFsa.getPath();
		String srcPath = srcFsa.getPath();
		String grammarFile = srcPath + "/" + getLexerGrammar().replace('.', '/') + ".g";
		String generateTo = "";
		if (getLexerGrammar().lastIndexOf('.') != -1) {
			generateTo = getLexerGrammar().substring(0, getLexerGrammar().lastIndexOf('.'));
		}
		generateTo = srcGenPath + "/" + generateTo.replace('.', '/');
		addAntlrParam("-fo");
		addAntlrParam(generateTo);
		final String encoding = getCodeConfig().getEncoding();
		getAntlrTool().runWithEncodingAndParams(grammarFile, encoding, getAntlrParams());
		
		TypeReference lexerType = new TypeReference(getLexerGrammar());
		splitParserAndLexerIfEnabled(srcGenFsa, null /* parser */, lexerType);
		normalizeTokens(srcGenFsa, getLexerGrammar().replace('.', '/') + ".tokens");
		suppressWarnings(srcGenFsa, lexerType);
		normalizeLineDelimiters(srcGenFsa, lexerType);
	}
	
	@Override
	protected void splitParserClassFile(IXtextGeneratorFileSystemAccess fsa, TypeReference parser) {
		// no-op
	}
	
	@Override
	protected void improveParserCodeQuality(IXtextGeneratorFileSystemAccess fsa, TypeReference parser) {
		// no-op
	}
	
	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (contentAssist && highlighting || runtime && highlighting || contentAssist && runtime) {
			issues.addError("Only one of those flags is allowed: contentAssist, runtime, highlighting flag");
		}
	}


	public void setLexerGrammar(String lexerGrammar) {
		this.lexerGrammar = lexerGrammar;
	}

	public String getLexerGrammar() {
		return lexerGrammar;
	}

	public void setHighlighting(boolean highlighting) {
		this.highlighting = highlighting;
	}

	public boolean isHighlighting() {
		return highlighting;
	}

	public void setRuntime(boolean runtime) {
		this.runtime = runtime;
	}

	public boolean isRuntime() {
		return runtime;
	}

	public void setContentAssist(boolean contentAssist) {
		this.contentAssist = contentAssist;
	}

	public boolean isContentAssist() {
		return contentAssist;
	}
	
}
