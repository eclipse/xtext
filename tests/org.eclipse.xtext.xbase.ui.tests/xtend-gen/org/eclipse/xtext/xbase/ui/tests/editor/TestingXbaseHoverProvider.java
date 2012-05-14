package org.eclipse.xtext.xbase.ui.tests.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;

@SuppressWarnings("all")
public class TestingXbaseHoverProvider extends XbaseHoverProvider {
  public XtextBrowserInformationControlInput getHoverInfo(final EObject element) {
    Region _region = new Region(0, 0);
    XtextBrowserInformationControlInput _hoverInfo = super.getHoverInfo(element, _region, null);
    return _hoverInfo;
  }
}
