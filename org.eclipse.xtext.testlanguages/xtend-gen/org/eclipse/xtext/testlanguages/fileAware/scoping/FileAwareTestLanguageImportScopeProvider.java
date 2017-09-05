package org.eclipse.xtext.testlanguages.fileAware.scoping;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Element;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Import;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FileAwareTestLanguageImportScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
  @Override
  protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(final EObject context, final boolean ignoreCase) {
    final List<ImportNormalizer> resolvers = super.internalGetImportedNamespaceResolvers(context, ignoreCase);
    if ((context instanceof PackageDeclaration)) {
      QualifiedName _qualifiedName = this.getQualifiedNameConverter().toQualifiedName(((PackageDeclaration)context).getName());
      ImportNormalizer _importNormalizer = new ImportNormalizer(_qualifiedName, true, false);
      resolvers.add(_importNormalizer);
      EList<Import> _imports = ((PackageDeclaration)context).getImports();
      for (final Import imp : _imports) {
        {
          final QualifiedName name = this.getImportedNamespace(imp);
          ImportNormalizer _importNormalizer_1 = new ImportNormalizer(name, false, false);
          resolvers.add(_importNormalizer_1);
        }
      }
    }
    return resolvers;
  }
  
  private QualifiedName getImportedNamespace(final Import imp) {
    final Element ele = imp.getElement();
    boolean _eIsProxy = ele.eIsProxy();
    if (_eIsProxy) {
      final String name = IterableExtensions.<INode>head(NodeModelUtils.findNodesForFeature(imp, FileAwarePackage.Literals.IMPORT__ELEMENT)).getText().trim();
      return this.getQualifiedNameConverter().toQualifiedName(name);
    } else {
      return this.getQualifiedNameProvider().getFullyQualifiedName(ele);
    }
  }
}
