package org.eclipse.xtext.ui.tests.quickfix.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class AbstractQuickfixCrossrefTestLanguageJavaValidator extends AbstractDeclarativeValidator {

    @Override
    protected List<EPackage> getEPackages() {
        List<EPackage> result = new ArrayList<EPackage>();
        result.add(org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.QuickfixCrossrefPackage.eINSTANCE);
        return result;
    }

}
