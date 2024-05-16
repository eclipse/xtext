package org.eclipse.xtext.xbase.testlanguages.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel;

/**
 * @author Lorenzo Bettini
 *
 */
public class JvmGenericTypeValidatorTestLangQualifiedNameProvider extends XbaseQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof JvmGenericTypeValidatorTestLangModel) {
			JvmGenericTypeValidatorTestLangModel model = (JvmGenericTypeValidatorTestLangModel) obj;
			if (model.getPackage() != null)
				return getConverter().toQualifiedName(model.getPackage());
		}
		return super.getFullyQualifiedName(obj);
	}
}
