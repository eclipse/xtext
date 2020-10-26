package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.head;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toMap;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toSet;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdaterContext;
import org.eclipse.xtext.ide.serializer.impl.ReferenceUpdater;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Element;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwareFactory;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Import;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.xbase.lib.MapExtensions;

public class FileAwareTestLanguageReferenceUpdater extends ReferenceUpdater {
	@Inject
	private IQualifiedNameProvider names;

	private FileAwareFactory fileAwareFactory = FileAwareFactory.eINSTANCE;

	@Override
	public void update(IReferenceUpdaterContext context) {
		super.update(context);
		PackageDeclaration pkg = ((PackageDeclaration) head(context.getResource().getContents()));
		QualifiedName pkgName = names.getFullyQualifiedName(pkg);
		Map<Element, Import> actual = toMap(pkg.getImports(), imp -> imp.getElement());
		Iterable<Element> targets = filter(
				transform(context.getUpdatableReferences(), ur -> ur.getTargetEObject()),
				Element.class);
		Set<Element> expected = toSet(filter(targets, e -> !names.getFullyQualifiedName(e).startsWith(pkgName)));
		Set<Element> toAdd = toSet(filter(expected, it -> !actual.containsKey(it)));
		Map<Element, Import> toDelete = MapExtensions.filter(actual, (Element e, Import i) -> !expected.contains(e));
		if (!toAdd.isEmpty() || !toDelete.isEmpty()) {
			context.modifyModel(() -> {
				toDelete.values().forEach(it -> EcoreUtil.remove(it));
				toAdd.forEach(e -> {
					EList<Import> imports = pkg.getImports();
					Import newImport = fileAwareFactory.createImport();
					newImport.setElement(e);
					imports.add(newImport);
				});
			});
		}
	}
}
