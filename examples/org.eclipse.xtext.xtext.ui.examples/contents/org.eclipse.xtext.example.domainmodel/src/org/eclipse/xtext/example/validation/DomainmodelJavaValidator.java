package org.eclipse.xtext.example.validation;

import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.Type;
import org.eclipse.xtext.validation.Check;

public class DomainmodelJavaValidator extends AbstractDomainmodelJavaValidator {

    public static final String INVALID_TYPE_NAME = "org.eclipse.xtext.DomainModel.InvalidTypeName";

    @Check
    public void checkTypeNameStartsWithCapital(Type type) {
        if (!Character.isUpperCase(type.getName().charAt(0))) {
            warning("Name should start with a capital", DomainmodelPackage.TYPE__NAME, INVALID_TYPE_NAME);
        }
    }

}
