package org.eclipse.xtext.dummy.parser;

import org.eclipse.emf.ecore.EPackage;

public class DummyLanguageASTFactory extends org.eclipse.xtext.core.parser.AbstractEcoreElementFactory {
	private final java.util.Map<String, EPackage[]> map = new java.util.HashMap<String, EPackage[]>();
	{
	
		map.put(null, new EPackage[] {
			org.eclipse.xtext.dummy.DummyLanguageConstants.getDummyLangEPackage()
		});
	
	};
	
	protected EPackage[] getEPackages(String alias) {
		return map.get(alias);
	}
}
