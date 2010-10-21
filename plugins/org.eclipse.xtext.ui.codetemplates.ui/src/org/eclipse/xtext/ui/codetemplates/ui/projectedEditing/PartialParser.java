package org.eclipse.xtext.ui.codetemplates.ui.projectedEditing;

import java.io.Reader;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialParser implements IParser {
	private final AbstractRule rule;
	private final IParser originalParser;

	public static void assignRootRule(XtextResource resource, ParserRule rule) {
		final IParser originalParser = resource.getParser();
		IParser partialParser = new PartialParser(originalParser, rule);
		resource.setParser(partialParser);
	}
	
	protected PartialParser(IParser originalParser, AbstractRule rule) {
		this.rule = rule;
		this.originalParser = originalParser;
	}

	public IParseResult parse(Reader reader) {
		return originalParser.parse(rule.getName(), reader);
	}
	
	public IParseResult parse(String ruleName, Reader reader) {
		return originalParser.parse(ruleName, reader);
	}

	public IParseResult reparse(CompositeNode originalRootNode, int offset, int length,
			String change) {
		return originalParser.reparse(originalRootNode, offset, length, change);
	}
}