package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring;

import com.google.common.collect.Iterables;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdaterContext;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.ReferenceUpdater;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Element;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwareFactory;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Import;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FileAwareTestLanguageReferenceUpdater extends ReferenceUpdater {
  @Inject
  private IQualifiedNameProvider names;
  
  @Extension
  private FileAwareFactory _fileAwareFactory = FileAwareFactory.eINSTANCE;
  
  @Override
  public void update(final IReferenceUpdaterContext context) {
    super.update(context);
    EObject _head = IterableExtensions.<EObject>head(context.getResource().getContents());
    final PackageDeclaration pkg = ((PackageDeclaration) _head);
    final QualifiedName pkgName = this.names.getFullyQualifiedName(pkg);
    final Function1<Import, Element> _function = (Import it) -> {
      return it.getElement();
    };
    final Map<Element, Import> actual = IterableExtensions.<Element, Import>toMap(pkg.getImports(), _function);
    final Function1<IUpdatableReference, EObject> _function_1 = (IUpdatableReference it) -> {
      return it.getTargetEObject();
    };
    final Iterable<Element> targets = Iterables.<Element>filter(ListExtensions.<IUpdatableReference, EObject>map(context.getUpdatableReferences(), _function_1), Element.class);
    final Function1<Element, Boolean> _function_2 = (Element it) -> {
      boolean _startsWith = this.names.getFullyQualifiedName(it).startsWith(pkgName);
      return Boolean.valueOf((!_startsWith));
    };
    final Set<Element> expected = IterableExtensions.<Element>toSet(IterableExtensions.<Element>filter(targets, _function_2));
    final Function1<Element, Boolean> _function_3 = (Element it) -> {
      boolean _containsKey = actual.containsKey(it);
      return Boolean.valueOf((!_containsKey));
    };
    final Set<Element> toAdd = IterableExtensions.<Element>toSet(IterableExtensions.<Element>filter(expected, _function_3));
    final Function2<Element, Import, Boolean> _function_4 = (Element $0, Import $1) -> {
      boolean _contains = expected.contains($0);
      return Boolean.valueOf((!_contains));
    };
    final Map<Element, Import> toDelete = MapExtensions.<Element, Import>filter(actual, _function_4);
    if (((!toAdd.isEmpty()) || (!toDelete.isEmpty()))) {
      final Runnable _function_5 = () -> {
        final Consumer<Import> _function_6 = (Import it) -> {
          EcoreUtil.remove(it);
        };
        toDelete.values().forEach(_function_6);
        final Consumer<Element> _function_7 = (Element e) -> {
          EList<Import> _imports = pkg.getImports();
          Import _createImport = this._fileAwareFactory.createImport();
          final Procedure1<Import> _function_8 = (Import it) -> {
            it.setElement(e);
          };
          Import _doubleArrow = ObjectExtensions.<Import>operator_doubleArrow(_createImport, _function_8);
          _imports.add(_doubleArrow);
        };
        toAdd.forEach(_function_7);
      };
      context.modifyModel(_function_5);
    }
  }
}
