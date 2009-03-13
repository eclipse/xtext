
package org.eclipse.xtext.valueconverter;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class Bug250313CheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public Bug250313CheckValidator() {
		addCheckFile("org::eclipse::xtext::valueconverter::Bug250313Checks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.valueconverter.bug250313.Bug250313Package.eINSTANCE);
	    
		return result;
	}
	
}
