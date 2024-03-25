/**
 * Copyright (c) 2024 Sigasi (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.textmate;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtext.generator.AbstractExternalFolderAwareFragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * A fragment to generate <a href="https://macromates.com/manual/en/language_grammars">TextMate</a> grammars.
 * 
 * @see TextMateGrammar
 * 
 * @author David Medina
 * @author Sebastian Zarnekow
 * @since 2.35
 */
public class TextMateHighlightingFragment extends AbstractExternalFolderAwareFragment {
	
	private TextMateGrammar textMateGrammar;
	
	private String fileName;
	
	public TextMateGrammar getTextMateGrammar() {
		if (textMateGrammar == null) {
			textMateGrammar = new TextMateGrammar();
		}
		return textMateGrammar;
	}

	public void setTextMateGrammar(TextMateGrammar textMateGrammar) {
		this.textMateGrammar = textMateGrammar;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void generate() {
		String json = toJsonString();
		getOutputLocation().generateFile(fileName, json);
	}

	protected String toJsonString() {
		Grammar grammar = getGrammar();
		if (fileName == null) {
			fileName = getLanguageName(grammar) + ".tmLanguage.json"; 
		}
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.setPrettyPrinting()
				.create();
		String json = gson.toJson(getTextMateGrammar().init(getGrammar()));
		return json;
	}

	protected String getLanguageName(Grammar g) {
		return GrammarUtil.getSimpleName(g).toLowerCase();
	}

}
