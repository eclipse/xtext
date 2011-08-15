package org.eclipse.xtext.common.types.ui.notification;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * The delta converter transforms {@link IJavaElementDelta JDT's deltas} to 
 * {@link IResourceDescription.Delta xtext's deltas}.
 * Each of the resulting deltas will return <code>true</code> when 
 * {@link IResourceDescription.Delta#haveEObjectDescriptionsChanged() 
 * haveEObjectDescriptionsChanged} is queried.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeltaConverter {
	
	private static final Logger logger = Logger.getLogger(DeltaConverter.class);
	
	private final TypeURIHelper uriHelper;
	
	/**
	 * The converter for fully qualified names to instances of {@link org.eclipse.xtext.naming.QualifiedName}.
	 * It is safe to use the default qualified name converter since it uses the '.' as separator.
	 */
	private final IQualifiedNameConverter nameConverter;
	
	@Inject
	public DeltaConverter(IQualifiedNameConverter nameConverter, TypeURIHelper uriHelper) {
		this.nameConverter = nameConverter;
		this.uriHelper = uriHelper;
	}
	
	/**
	 * @return a possibly empty list of converted deltas.
	 */
	public List<IResourceDescription.Delta> convert(IJavaElementDelta delta) {
		// a file was opened or closed - we do not expect a change
		if (delta.getFlags() == IJavaElementDelta.F_AST_AFFECTED)
			return Collections.emptyList();
		List<IResourceDescription.Delta> result = Lists.newArrayListWithExpectedSize(2);
		convertCompilationUnits(delta, result);
		return result;
	}

	protected void convertCompilationUnit(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		if ((delta.getFlags() & IJavaElementDelta.F_CHILDREN) != 0) {
			IJavaElementDelta[] children = delta.getAffectedChildren();
			for(IJavaElementDelta child: children) {
				IJavaElement childElement = child.getElement();
				if (childElement instanceof IType) {
					IType type = (IType) childElement;
					URI uri = getURIFor(type);
					List<IEObjectDescription> exported = getExportedEObjects(type);
					IResourceDescription oldDescription = null;
					TypeResourceDescription newDescription = null;
					if (child.getKind() == IJavaElementDelta.REMOVED) {
						oldDescription = new TypeResourceDescription(uri, exported);
					} else if (child.getKind() == IJavaElementDelta.ADDED) {
						newDescription = new TypeResourceDescription(uri, exported);
					} else {
						newDescription = new TypeResourceDescription(uri, exported);
						List<IEObjectDescription> additionallyExportedEObjects = getAdditionallyExportedEObjects(type, child);
						oldDescription = new LayeredTypeResourceDescription(newDescription, additionallyExportedEObjects);
					}
					IResourceDescription.Delta resourceDelta = new ChangedResourceDescriptionDelta(oldDescription, newDescription);
					result.add(resourceDelta);
				}
			}
		} else if ((delta.getFlags() & (
					IJavaElementDelta.F_PRIMARY_RESOURCE 
				  | IJavaElementDelta.F_MOVED_FROM 
				  | IJavaElementDelta.F_MOVED_TO)) != 0
				  || delta.getKind() == IJavaElementDelta.ADDED && delta.getFlags() == 0) {
			ICompilationUnit cu = (ICompilationUnit) delta.getElement();
			try {
				for(IType type: cu.getTypes()) {
					URI uri = getURIFor(type);
					List<IEObjectDescription> exported = getExportedEObjects(type);
					IResourceDescription oldDescription = null;
					TypeResourceDescription newDescription = null;
					newDescription = new TypeResourceDescription(uri, exported);
					List<IEObjectDescription> additionallyExportedEObjects = getAdditionallyExportedEObjects(type, delta);
					oldDescription = new LayeredTypeResourceDescription(newDescription, additionallyExportedEObjects);
					IResourceDescription.Delta resourceDelta = new ChangedResourceDescriptionDelta(oldDescription, newDescription);
					result.add(resourceDelta);
				}
			} catch(JavaModelException e) {
				if (logger.isDebugEnabled())
					logger.debug(e, e);
			}
		}
	}
	
	protected List<IEObjectDescription> getAdditionallyExportedEObjects(IType type, IJavaElementDelta delta) {
		QualifiedName typeName = nameConverter.toQualifiedName(type.getFullyQualifiedName());
		NameBasedEObjectDescriptionBuilder descriptionBuilder = new NameBasedEObjectDescriptionBuilder(typeName);
		traverseDelta(delta, descriptionBuilder);
		return descriptionBuilder.getExported();
	}

	protected void traverseDelta(IJavaElementDelta delta, NameBasedEObjectDescriptionBuilder acceptor) {
		for(IJavaElementDelta childDelta: delta.getAffectedChildren()) {
			if (childDelta.getKind() == IJavaElementDelta.REMOVED) {
				String childName = childDelta.getElement().getElementName();
				acceptor.accept(childName);
			} else {
				IJavaElement childElement = childDelta.getElement();
				if (childElement.getElementType() == IJavaElement.TYPE) {
					NameBasedEObjectDescriptionBuilder childAcceptor = acceptor.nestType(childElement.getElementName());
					traverseDelta(childDelta, childAcceptor);
				}
			}
		}
	}

	protected List<IEObjectDescription> getExportedEObjects(IType type) {
		QualifiedName typeName = nameConverter.toQualifiedName(type.getFullyQualifiedName());
		NameBasedEObjectDescriptionBuilder descriptionBuilder = new NameBasedEObjectDescriptionBuilder(typeName);
		traverseType(type, descriptionBuilder);
		List<IEObjectDescription> exported = descriptionBuilder.getExported();
		return exported;
	}
	
	protected void traverseType(IType type, NameBasedEObjectDescriptionBuilder acceptor) {
		try {
			if (type.exists()) {
				for(IField field: type.getFields()) {
					if (!Flags.isSynthetic(field.getFlags())) {
						String fieldName = field.getElementName();
						acceptor.accept(fieldName);
					}
				}
				for(IMethod method: type.getMethods()) {
					if (!Flags.isSynthetic(method.getFlags())) {
						String methodName = method.getElementName();
						acceptor.accept(methodName);
					}
				}
				for(IType nestedType: type.getTypes()) {
					traverseType(nestedType, acceptor.nestType(nestedType.getElementName()));
				}
			}
		} catch(JavaModelException e) {
			if (logger.isDebugEnabled())
				logger.debug(e, e);
		}
	}
	
	protected void convertCompilationUnits(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		IJavaElement element = delta.getElement();
		if (delta.getKind() != IJavaElementDelta.REMOVED && hasStructureErrors(element)) 
			return;
		if (element.getElementType() == IJavaElement.COMPILATION_UNIT) {
			convertCompilationUnit(delta, result);
		}
		if (element.getElementType() < IJavaElement.COMPILATION_UNIT) {
			for(IJavaElementDelta child: delta.getAffectedChildren()) {
				convertCompilationUnits(child, result);
			}
			if (delta.getKind() == IJavaElementDelta.ADDED && 
					delta.getAffectedChildren().length == 0 && 
					element.getElementType() == IJavaElement.PACKAGE_FRAGMENT) {
				IPackageFragment fragment = (IPackageFragment) element;
				try {
					for(ICompilationUnit cu: fragment.getCompilationUnits()) {
						for(IType type: cu.getTypes()) {
							URI uri = getURIFor(type);
							List<IEObjectDescription> exported = getExportedEObjects(type);
							TypeResourceDescription newDescription = new TypeResourceDescription(uri, exported);
							IResourceDescription.Delta resourceDelta = new ChangedResourceDescriptionDelta(null, newDescription);
							result.add(resourceDelta);
						}
					}
				} catch(JavaModelException e) {
					if (logger.isDebugEnabled())
						logger.debug(e, e);
				}
			}
		}
	}

	protected boolean hasStructureErrors(IJavaElement element) {
		try {
			return !element.isStructureKnown();
		} catch (JavaModelException e) {
			if (logger.isDebugEnabled())
				logger.debug(e, e);
			return true;
		}
	}

	protected URI getURIFor(IType type) {
		URI result = uriHelper.createResourceURIForFQN(type.getFullyQualifiedName());
		return result;
	}

}