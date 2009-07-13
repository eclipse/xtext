package org.eclipse.xtext.wikitext;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;

public class SourceFileHyperlinkPhaseModifierTest extends TestCase {

	private MarkupParser parser;

	private TextileLanguage markupLanaguage;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		initParser();
	}

	private void initParser() throws IOException {
		parser = new MarkupParser();
		markupLanaguage = new XtextTextileDialect();
		parser.setMarkupLanguage(markupLanaguage);
	}

	public void testSrc() {
		String html = parser.parseToHtml("${org.eclipse.xtext.generator/src/org.eclipse.xtext.generator.IGeneratorFragment}"); //$NON-NLS-1$
		System.out.println("HTML: \n" + html); //$NON-NLS-1$
		assertTrue(html.contains("http://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.tmf/org.eclipse.xtext/plugins/org.eclipse.xtext.generator/src/org/eclipse/xtext/generator/IGeneratorFragment.java")); //$NON-NLS-1$
	}

	public void testSrcGen() {
		String html = parser.parseToHtml("${org.eclipse.xtext.generator/src-gen/org.eclipse.xtext.generator.IGeneratorFragment}"); //$NON-NLS-1$
		System.out.println("HTML: \n" + html); //$NON-NLS-1$
		assertTrue(html.contains("http://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.tmf/org.eclipse.xtext/plugins/org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/IGeneratorFragment.java")); //$NON-NLS-1$
	}

}
