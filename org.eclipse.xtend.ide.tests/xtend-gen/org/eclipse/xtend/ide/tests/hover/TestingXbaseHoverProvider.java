/**
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;

@SuppressWarnings("all")
public class TestingXbaseHoverProvider extends XbaseHoverProvider {
  public XtextBrowserInformationControlInput getHoverInfo(final EObject element) {
    Region _region = new Region(0, 0);
    return super.getHoverInfo(element, _region, null);
  }
}
