package org.eclipse.xtext.example.validation;

import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.Type;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

public class DomainmodelJavaValidator extends AbstractDomainmodelJavaValidator {

    public static final String INVALID_TYPE_NAME = "org.eclipse.xtext.DomainModel.InvalidTypeName";
    @Check
    public void checkTypeNameStartsWithCapital(Type type) {
        if (!Character.isUpperCase(type.getName().charAt(0))) {
            warning("Name should start with a capital", 
            		DomainmodelPackage.Literals.TYPE__NAME,
            		ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
            		INVALID_TYPE_NAME, 
            		type.getName());
        }
    }

    public static final String INVALID_FEATURE_NAME = "org.eclipse.xtext.DomainModel.InvalidFeatureName";
    @Check
    public void checkFeatureNameStartsWithLowercase(Feature feature) {
        if (!Character.isLowerCase(feature.getName().charAt(0))) {
            warning("Name should start with a lowercase", 
            		DomainmodelPackage.Literals.TYPED_ELEMENT__NAME,
            		ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
            		INVALID_FEATURE_NAME, 
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
