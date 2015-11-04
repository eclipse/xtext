package org.eclipse.xtend.web

import org.eclipse.xtext.web.server.occurrences.OccurrencesService
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.XBlockExpression

class XtendOccurrencesService extends OccurrencesService {
	
	override protected filter(EObject element) {
		if (element instanceof XBlockExpression){
			return false
		}
		super.filter(element)
	}
	
}