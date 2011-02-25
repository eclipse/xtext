package org.eclipse.xtext.example.domainmodel.validation;

import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

public class DomainmodelJavaValidator extends AbstractDomainmodelJavaValidator {

    @Check
    public void checkTypeNameStartsWithCapital(Entity entity) {
        if (!Character.isUpperCase(entity.getName().charAt(0))) {
            warning("Name should start with a capital", 
            		DomainmodelPackage.Literals.ENTITY__NAME,
            		ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
            		IssueCodes.INVALID_TYPE_NAME, 
            		entity.getName());
        }
    }

    @Check
    public void checkFeatureNameStartsWithLowercase(Feature feature) {
        if (!Character.isLowerCase(feature.getName().charAt(0))) {
            warning("Name should start with a lowercase", 
            		DomainmodelPackage.Literals.FEATURE__NAME,
            		ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
            		IssueCodes.INVALID_FEATURE_NAME, 
            		feature.getName());
        }
    }
    
    @Check(CheckType.EXPENSIVE)
    public void checkPackage(PackageDeclaration packages) {
        if (packages.getName().equals("java")) {
            error("Invalid package name", 
            		DomainmodelPackage.Literals.PACKAGE_DECLARATION__NAME);
        }
    }
}
