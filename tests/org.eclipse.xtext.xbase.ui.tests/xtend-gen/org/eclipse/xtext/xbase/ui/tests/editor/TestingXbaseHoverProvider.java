/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
