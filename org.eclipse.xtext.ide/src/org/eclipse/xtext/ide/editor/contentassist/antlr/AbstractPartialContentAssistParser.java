/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.util.Collection;

import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Inject;

/**
 * Base class for content assist parsers that can reduce the input preceding the cursor
 * position without any impact on the follow set.
 * @since 2.9
 */
public abstract class AbstractPartialContentAssistParser extends AbstractContentAssistParser implements IPartialContentAssistParser {
	
	@Inject
	private EntryPointFinder entryPointFinder;
	
	@Override
	public Collection<FollowElement> getFollowElements(IParseResult parseResult, int offset, boolean strict) {
		return getFollowElements(parseResult, entryPointFinder, offset, strict);
	}

}
