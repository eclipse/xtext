/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import org.antlr.runtime.BaseRecognizer;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;

import com.google.common.base.Preconditions;

/**
 * A wrapper for an existing {@link IUnorderedGroupHelper} that ignores the first
 * invocation of {@link #enter(UnorderedGroup)}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.14
 */
public class IgnoreFirstEntranceUnorderedGroupHelper implements IUnorderedGroupHelper {
	private final IUnorderedGroupHelper helper;
	protected boolean first = true;

	/**
	 * Protected contructor to allow to override this type. 
	 * 
	 * @see BaseContentAssistParser#ignoreFirstEntrance(IUnorderedGroupHelper)
	 */
	protected IgnoreFirstEntranceUnorderedGroupHelper(IUnorderedGroupHelper helper) {
		this.helper = Preconditions.checkNotNull(helper, "helper may not be null");
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
	
	protected IUnorderedGroupHelper getHelper() {
		return helper;
	}
}