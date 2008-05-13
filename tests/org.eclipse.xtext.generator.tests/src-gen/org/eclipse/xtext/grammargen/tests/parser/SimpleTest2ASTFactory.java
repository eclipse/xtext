package org.eclipse.xtext.grammargen.tests.parser;

import org.eclipse.emf.ecore.EPackage;

public class SimpleTest2ASTFactory extends org.eclipse.xtext.core.parser.AbstractEcoreElementFactory {
	private final java.util.Map<String, EPackage[]> map = new java.util.HashMap<String, EPackage[]>();
	{
	
		map.put(null, new EPackage[] {
		
			
			org.eclipse.xtext.grammargen.tests.SimpleTest2EPackageAccess.getSimpleTest2EPackage()
			
		
		});
	
	};
	
	protected EPackage[] getEPackages(String alias) {
		return map.get(alias);
	}
}
