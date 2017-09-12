/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import org.antlr.runtime.BaseRecognizer;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;

/**
 * A wrapper for an existing {@link IUnorderedGroupHelper} that ignores the first
 * invocation of {@link #enter(UnorderedGroup)}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.13
 */
public class IgnoreFirstEntranceUnorderedGroupHelper implements IUnorderedGroupHelper {
	private final IUnorderedGroupHelper helper;
	boolean first = true;

	/**
	 * Protected contructor to allow to override this type. 
	 * 
	 * @see BaseContentAssistParser#ignoreFirstEntrance(IUnorderedGroupHelper)
	 */
	protected IgnoreFirstEntranceUnorderedGroupHelper(IUnorderedGroupHelper helper) {
		this.helper = helper;
	}

	@Override
	public void initializeWith(BaseRecognizer recognizer) {
		helper.initializeWith(recognizer);
	}

	@Override
	public void enter(UnorderedGroup group) {
		if (!first)
			helper.enter(group);
		first = false;
	}

	@Override
	public void leave(UnorderedGroup group) {
		helper.leave(group);
	}

	@Override
	public boolean canSelect(UnorderedGroup group, int index) {
		return helper.canSelect(group, index);
	}

	@Override
	public void select(UnorderedGroup group, int index) {
		helper.select(group, index);
	}

	@Override
	public void returnFromSelection(UnorderedGroup group) {
		helper.returnFromSelection(group);
	}

	@Override
	public boolean canLeave(UnorderedGroup group) {
		return helper.canLeave(group);
	}

	@Override
	public UnorderedGroupState snapShot(UnorderedGroup... groups) {
		return helper.snapShot(groups);
	}
}