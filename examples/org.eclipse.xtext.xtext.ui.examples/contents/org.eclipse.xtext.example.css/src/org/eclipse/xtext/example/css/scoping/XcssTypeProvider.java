package org.eclipse.xtext.example.css.scoping;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.example.css.xcss.ColorLiteral;
import org.eclipse.xtext.example.css.xcss.TypeSelector;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

import com.google.inject.Inject;

public class XcssTypeProvider extends XbaseTypeProvider {

	@Inject
	private SuperTypeCollector superTypeCollector;
	
	protected JvmTypeReference _type(TypeSelector selector, Context<JvmTypeReference> context) {
		JvmTypeReference control = getTypesService().getTypeForName(
				QualifiedName.create("org", "eclipse", "swt", "widgets", "Control"), selector);
		if (control == null)
			return selector;
		// TODO: Hack because typeService#isConformantTo does not work with non-parameterized references
		if (superTypeCollector.collectSuperTypesAsRawTypes(selector).contains(control.getType())) {
			JvmWildcardTypeReference wildcard = getTypesFactory().createJvmWildcardTypeReference();
			{
				JvmUpperBound upperBound = getTypesFactory().createJvmUpperBound();
				JvmParameterizedTypeReference copy = getTypesFactory().createJvmParameterizedTypeReference();
				copy.setType(selector.getType());
				upperBound.setTypeReference(copy);
				wildcard.getConstraints().add(upperBound);
			}
			{
				JvmTypeReference borderAware = getTypesService().getTypeForName(
						QualifiedName.create("org", "eclipse", "xtext", "example", "css", "runtime", "StyleAware"), selector);
				if (borderAware != null) {
					JvmUpperBound upperBound = getTypesFactory().createJvmUpperBound();
					upperBound.setTypeReference(borderAware);
					wildcard.getConstraints().add(upperBound);
				}
			}
			return wildcard;
		}
		return selector;
	}
	
	protected JvmTypeReference _type(ColorLiteral colorLiteral, Context<JvmTypeReference> context) {
		return getTypesService().getTypeForName(QualifiedName.create("org", "eclipse", "swt", "graphics", "Color"), colorLiteral);
	}
	
}
