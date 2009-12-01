package org.eclipse.xtext.builder.tests.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class AbstractBuilderTestLanguageJavaValidator extends AbstractDeclarativeValidator {

    @Override
    protected List<EPackage> getEPackages() {
        List<EPackage> result = new ArrayList<EPackage>();
        result.add(org.eclipse.xtext.builder.tests.builderTestLanguage.BuilderTestLanguagePackage.eINSTANCE);
        return result;
    }

}
