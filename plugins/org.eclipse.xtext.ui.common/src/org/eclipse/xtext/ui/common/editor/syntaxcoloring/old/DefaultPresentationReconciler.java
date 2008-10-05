package org.eclipse.xtext.ui.common.editor.syntaxcoloring.old;

import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.xtext.service.Inject;

public class DefaultPresentationReconciler extends PresentationReconciler implements IPresentationReconciler {
	
	@Inject
	private XtextTokenScanner scanner;
	
	private DefaultDamagerRepairer damageRepairer = null;

	public DefaultDamagerRepairer getDamageRepairer() {
		if (damageRepairer==null) {
			damageRepairer = new DefaultDamagerRepairer(scanner);
		}
		return damageRepairer;
	}
	
	public IPresentationDamager getDamager(String contentType) {
		return getDamageRepairer();
	}

	public IPresentationRepairer getRepairer(String contentType) {
		return getDamageRepairer();
	}

}
