package org.eclipse.xtext.test.parser;

import org.eclipse.emf.ecore.EPackage;

public class TestLanguageASTFactory extends org.eclipse.xtext.core.parser.AbstractEcoreElementFactory {
	private final java.util.Map<String, EPackage[]> map = new java.util.HashMap<String, EPackage[]>();
	{
	
		map.put(null, new EPackage[] {
			org.eclipse.xtext.test.TestLanguageConstants.getTestLangEPackage()
		});
	
	};
	
	protected EPackage[] getEPackages(String alias) {
		return map.get(alias);
	}
}
