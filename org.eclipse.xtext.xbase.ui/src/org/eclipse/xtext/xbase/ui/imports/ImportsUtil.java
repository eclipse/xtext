/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.imports;

import java.util.List;
import java.util.Set;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.imports.ImportsAcceptor.DefaultImportsAcceptor;
import org.eclipse.xtext.xbase.imports.ImportsCollector;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;

import com.google.inject.Inject;

/**
 * @author dhuebner - Initial contribution and API
 */
public class ImportsUtil {

	@Inject
	private RewritableImportSection.Factory importSectionFactory;
	@Inject
	private ReplaceConverter replaceConverter;
	@Inject
	private ImportsCollector importsCollector;

	/**
	 * Collects import declarations in XtextResource for the given range (offset -> endOffset)
	 * 
	 * @param xtextResource
	 *            {@link XtextResource} to work with
	 * @param textRegion
	 *            start and end of the range to inspect
	 * @return {@link Triple} where the first element holds the Type imports, the second staticImport and the third
	 *         static extension Imports
	 */
	public Triple<Set<String>, Set<String>, Set<String>> collectImports(XtextResource xtextResource,
			final ITextRegion textRegion) {
		DefaultImportsAcceptor acceptor = new DefaultImportsAcceptor();
		importsCollector.collectImports(xtextResource, textRegion, acceptor);
		return Tuples.create(acceptor.getTypes(), acceptor.getStaticImport(), acceptor.getExtensions());
	}

	/**
	 * Enhances the import section of the given xtextDocument with provided imports. Works with {@link IUnitOfWork}
	 */
	public void addImports(final String[] typeImports, final String[] staticImports, final String[] extensionImports,
			final IXtextDocument xtextDocument) {
		List<ReplaceRegion> result = xtextDocument.modify(new IUnitOfWork<List<ReplaceRegion>, XtextResource>() {
			@Override
			public List<ReplaceRegion> exec(XtextResource state) throws Exception {
				RewritableImportSection impSection = importSectionFactory.parse(state);
				for (String typeImport : typeImports) {
					impSection.addImport(typeImport);
				}
				for (String staticImport : staticImports) {
					Pair<String, String> pair = splitInTypeAndMember(staticImport);
					impSection.addStaticImport(pair.getFirst(), pair.getSecond());
				}
				for (String staticExtensionImport : extensionImports) {
					Pair<String, String> pair = splitInTypeAndMember(staticExtensionImport);
					impSection.addStaticExtensionImport(pair.getFirst(), pair.getSecond());
				}
				return impSection.rewrite();
			}
		});
		try {
			if (!result.isEmpty()) {
				replaceConverter.convertToTextEdit(result).apply(xtextDocument);
			}
		} catch (MalformedTreeException e) {
			//ignore if adding imports fails
		} catch (BadLocationException e) {
			//ignore if adding imports fails
		}
	}

	protected Pair<String, String> splitInTypeAndMember(String featuresQName) {
		int memberIdx = featuresQName.lastIndexOf('.');
		String type = featuresQName.substring(0, memberIdx);
		String member = featuresQName.substring(memberIdx + 1);
		int indexOf = member.indexOf("(");
		if (indexOf != -1) {
			member = member.substring(0, indexOf);
		}
		Pair<String, String> pair = Tuples.create(type, member);
		return pair;
	}
}
