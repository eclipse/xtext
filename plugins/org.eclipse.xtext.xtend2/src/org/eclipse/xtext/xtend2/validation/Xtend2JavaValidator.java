package org.eclipse.xtext.xtend2.validation;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
 
public class Xtend2JavaValidator extends XbaseJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(Xtend2Package.eINSTANCE, XbasePackage.eINSTANCE);
	}

}
