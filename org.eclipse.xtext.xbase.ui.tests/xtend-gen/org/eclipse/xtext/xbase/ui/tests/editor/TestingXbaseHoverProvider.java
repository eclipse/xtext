/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class TestingXbaseHoverProvider extends XbaseHoverProvider {
  public XtextBrowserInformationControlInput getHoverInfo(final EObject element) {
    Region _region = new Region(0, 0);
    return super.getHoverInfo(element, _region, null);
  }
}
