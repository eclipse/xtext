package org.eclipse.xtend.web;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.web.server.occurrences.OccurrencesService;
import org.eclipse.xtext.xbase.XBlockExpression;

@SuppressWarnings("all")
public class XtendOccurrencesService extends OccurrencesService {
  @Override
  protected boolean filter(final EObject element) {
    boolean _xblockexpression = false;
    {
      if ((element instanceof XBlockExpression)) {
        return false;
      }
      _xblockexpression = super.filter(element);
    }
    return _xblockexpression;
  }
}
