package org.eclipse.xtext.ui.editor.templates;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jface.text.templates.TemplateVariable;

/**
 * Resolves a template variable to <code>EEnumLiteral literals</code> which are
 * assignment-compatible with the <code>TemplateVariable variable</code>
 * enumeration parameter (e.g. in ${modifier:Enum('Visibility')}).
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EnumTemplateVariableResolver extends
		AbstractTemplateVariableResolver {

	public EnumTemplateVariableResolver() {
		super("Enum", "EnumTemplateVariableResolver for Enumeration");
	}

	@Override
	public List<String> resolveValues(TemplateVariable variable,
			XtextTemplateContext castedContext) {
		String enumerationName = (String) variable.getVariableType()
				.getParams().iterator().next();
		EEnum enumeration = (EEnum) getEClassifierForGrammar(enumerationName,
				getGrammar(castedContext));
		List<String> literals = new ArrayList<String>();
		for (EEnumLiteral enumLiteral : enumeration.getELiterals()) {
			literals.add(enumLiteral.getLiteral());
		}
		return literals;
	}

}
