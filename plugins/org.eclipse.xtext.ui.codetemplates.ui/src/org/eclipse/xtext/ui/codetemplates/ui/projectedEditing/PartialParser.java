package org.eclipse.xtext.ui.codetemplates.ui.projectedEditing;

import java.io.Reader;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialParser implements IParser {
	private final ParserRule rule;
	private final IParser originalParser;

	public static void assignRootRule(XtextResource resource, ParserRule rule) {
		final IParser originalParser = resource.getParser();
		IParser partialParser = new PartialParser(originalParser, rule);
		resource.setParser(partialParser);
	}
	
	protected PartialParser(IParser originalParser, ParserRule rule) {
		this.rule = rule;
		this.originalParser = originalParser;
	}

	public IParseResult parse(Reader reader) {
		return originalParser.parse(rule, reader);
	}
	
	public IParseResult parse(ParserRule rule, Reader reader) {
		return originalParser.parse(rule, reader);
	}
	
	public IParseResult parse(RuleCall ruleCall, Reader reader) {
		throw new UnsupportedOperationException();
	}

	public IParseResult reparse(IParseResult previousParseResult, ReplaceRegion replaceRegion) {
		return originalParser.reparse(previousParseResult, replaceRegion);
	}
}