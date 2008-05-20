package org.eclipse.xtext.testlanguages.parser;

import org.eclipse.emf.ecore.EPackage;

public class SimpleExpressionsASTFactory extends org.eclipse.xtext.core.parser.AbstractEcoreElementFactory {
	private final java.util.Map<String, EPackage[]> map = new java.util.HashMap<String, EPackage[]>();
	{
	
		map.put(null, new EPackage[] {
			org.eclipse.xtext.testlanguages.SimpleExpressionsConstants.getsimpleExpressionsEPackage()
		});
	
	};
	
	protected EPackage[] getEPackages(String alias) {
		return map.get(alias);
	}
}
