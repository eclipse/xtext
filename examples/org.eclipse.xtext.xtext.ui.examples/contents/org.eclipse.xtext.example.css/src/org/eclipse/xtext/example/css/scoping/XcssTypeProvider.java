package org.eclipse.xtext.example.css.scoping;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.css.xcss.ColorLiteral;
import org.eclipse.xtext.example.css.xcss.TypeSelector;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

public class XcssTypeProvider extends XbaseTypeProvider {

	protected JvmTypeReference _type(TypeSelector selector, Context<JvmTypeReference> context) {
		return selector;
	}
	
	protected JvmTypeReference _type(ColorLiteral colorLiteral, Context<JvmTypeReference> context) {
		return getTypesService().getTypeForName(QualifiedName.create("org", "eclipse", "swt", "graphics", "Color"), colorLiteral);
	}
	
}
