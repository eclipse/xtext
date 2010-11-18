package org.eclipse.xtext.example.css.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.css.xcss.StyleSheet;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

import static java.util.Collections.*;

public class XcssGlobalScopeDelegatingScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context) {
		if (context instanceof StyleSheet) {
			List<ImportNormalizer> result = super.internalGetImportedNamespaceResolvers(context);
			result.add(createImportedNamespaceResolver("org.eclipse.swt.widgets.*"));
			result.add(createImportedNamespaceResolver("org.eclipse.swt.custom.*"));
			return result;
		}
		return emptyList();
	}
	
}
