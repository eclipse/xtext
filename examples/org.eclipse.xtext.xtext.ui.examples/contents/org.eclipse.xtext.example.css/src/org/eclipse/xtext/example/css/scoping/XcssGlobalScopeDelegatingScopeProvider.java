package org.eclipse.xtext.example.css.scoping;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.css.xcss.StyleSheet;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

public class XcssGlobalScopeDelegatingScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Override
	protected Set<ImportNormalizer> getImportedNamespaceResolvers(EObject context) {
		if (context instanceof StyleSheet) {
			Set<ImportNormalizer> result = super.getImportedNamespaceResolvers(context);
			result.add(createImportedNamespaceResolver("org.eclipse.swt.widgets.*"));
			return result;
		}
		return Collections.emptySet();
	}
	
}
