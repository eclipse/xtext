package org.eclipse.xtext.metamodelreferencing.tests.parser;

import org.eclipse.emf.ecore.EPackage;

public class MetamodelRefTestASTFactory extends org.eclipse.xtext.core.parser.AbstractEcoreElementFactory {
	private final java.util.Map<String, EPackage[]> map = new java.util.HashMap<String, EPackage[]>();
	{
	
		map.put("xtext", new EPackage[] {
		
			
			org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestEPackageAccess.get("http://www.eclipse.org/2008/Xtext")
			
		
		});
	
		map.put(null, new EPackage[] {
		
			
			org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestEPackageAccess.getSimpleTestEPackage()
			
		
		});
	
	};
	
	protected EPackage[] getEPackages(String alias) {
		return map.get(alias);
	}
}
