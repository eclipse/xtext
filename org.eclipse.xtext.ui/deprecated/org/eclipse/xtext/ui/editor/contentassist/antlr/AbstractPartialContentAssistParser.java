package org.eclipse.xtext.ui.editor.contentassist.antlr;

import java.util.Collection;

import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Inject;

/**
 * Base class for content assist parsers that can reduce the input preceding the cursor
 * position without any impact on the follow set.
 * 
 * @since 2.7
 * @author Sebastian Zarnekow
 */
public abstract class AbstractPartialContentAssistParser extends AbstractContentAssistParser implements IPartialContentAssistParser {
	
	@Inject
	private EntryPointFinder entryPointFinder;
	
	@Override
	public Collection<FollowElement> getFollowElements(IParseResult parseResult, int offset, boolean strict) {
		return getFollowElements(parseResult, entryPointFinder, offset, strict);
	}
	
}
