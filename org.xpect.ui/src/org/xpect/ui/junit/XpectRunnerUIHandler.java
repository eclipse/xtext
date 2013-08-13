/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.junit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.runners.IRunnerUIHandler;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.xpect.ui.util.TestDataUIUtil;
import org.xpect.ui.util.TestDataUIUtil.TestElementInfo;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectRunnerUIHandler implements IRunnerUIHandler {

	@Inject
	private IURIEditorOpener globalOpener;

	public boolean contextMenuAboutToShow(ViewPart part, ITestElement ctx, IMenuManager menu) {
		TestElementInfo parsed = TestDataUIUtil.parse(ctx);
		URI uri = parsed.getURI();
		CompareAction compareAction = new CompareAction(ctx);
		if (compareAction.isEnabled())
			menu.add(compareAction);
		if (uri != null) {
			if (uri.hasFragment())
				menu.add(new OpenFileAction(globalOpener, uri, "Go to XPECT", "Show XPECT statement in the Xpect file editor."));
			else
				menu.add(new OpenFileAction(globalOpener, uri, "Go to File", "Open file in the Xpect editor."));
		}
		String method = parsed.getMethod();
		if (method != null)
			menu.add(new OpenJavaMethodAction(parsed, "Go to Method", "Show Java Method declaration"));
		return false;
	}

	public boolean handleDoubleClick(ViewPart part, ITestElement ctx) {
		CompareAction compareAction = new CompareAction(ctx);
		if (compareAction.isEnabled()) {
			compareAction.run();
			return true;
		}
		TestElementInfo parsed = TestDataUIUtil.parse(ctx);
		URI uri = parsed.getURI();
		if (uri != null) {
			new OpenFileAction(globalOpener, uri, "foo", "bar").run();
			return true;
		}
		return false;
	}

	public String getSimpleLabel(ViewPart part, ITestElement element) {
		return null;
		// if(element instanceof ITestCaseElement)
		// return ((ITestCaseElement))
		// Map<String, String> parsed = parse(element);
		// String title = parsed.get("title");
		// if (!Strings.isEmpty(title))
		// return title;
		// return "unknown type:" + element.getClass();
	}

}
