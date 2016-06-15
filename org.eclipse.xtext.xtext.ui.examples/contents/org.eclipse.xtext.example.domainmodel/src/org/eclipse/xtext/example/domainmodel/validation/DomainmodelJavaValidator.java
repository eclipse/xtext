/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.validation;

import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

public class DomainmodelJavaValidator extends AbstractDomainmodelJavaValidator {

    @Check
    public void checkTypeNameStartsWithCapital(Entity entity) {
        if (!Character.isUpperCase(entity.getName().charAt(0))) {
            warning("Name should start with a capital", 
            		DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME,
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
    
    @Check
    public void checkPackage(PackageDeclaration packages) {
    	if(Strings.isEmpty(packages.getName())) {
    		error("Name cannot be empty", DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
    	}
        if (packages.getName().equals("java")) {
            error("Invalid package name", 
            		DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
        }
    }

}
