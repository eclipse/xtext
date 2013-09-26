package org.eclipse.xtext.common.types.ui.notification;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IImportContainer;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * The delta converter transforms {@link IJavaElementDelta JDT's deltas} to 
 * {@link org.eclipse.xtext.resource.IResourceDescription.Delta xtext's deltas}.
 * Each of the resulting deltas will return <code>true</code> when 
 * {@link org.eclipse.xtext.resource.IResourceDescription.Delta#haveEObjectDescriptionsChanged() 
 * haveEObjectDescriptionsChanged} is queried.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeltaConverter {
	
	/**
	 * Wraps an exception that occured during event conversion.
	 * Events that cannot be converted are assumed to have changes but
	 * the {@link #getUri()} may be misleading.
	 * 
	 * @since 2.4
	 * @deprecated this class is not used anymore
	 */
	public static class ThrowableWrapper implements IResourceDescription.Delta {

		private String location;
		private String eventAsString;
		private Throwable cause;

		public ThrowableWrapper(String location, String eventAsString, Throwable cause) {
			this.location = location;
			this.eventAsString = eventAsString;
			this.cause = cause;
		}
		
		public URI getUri() {
			return URI.createURI(location);
		}

		public IResourceDescription getOld() {
			return null;
		}

		public IResourceDescription getNew() {
			return null;
		}

		public boolean haveEObjectDescriptionsChanged() {
			return true;
		}
		
		public String getLocation() {
			return location;
		}

		public Throwable getCause() {
			return cause;
		}
		
		@Override
		public String toString() {
			return "Exception while processing " + eventAsString + ": " + cause.getMessage();
		}
		
	}
	
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
	
	@Inject private IResourceDescriptions resourceDescriptions;
	
	/**
	 * @return a possibly empty list of converted deltas.
	 */
	public List<IResourceDescription.Delta> convert(IJavaElementDelta delta) {
		/*
		 * a file was opened or closed or there is no relevant structural change in the delta
		 * - we do not expect an IResourceDescription.Delta
		 * 
		 * Deltas without any affected children or without content changes
		 * are considered to be irrelevant
		 */
		if (delta.getFlags() == IJavaElementDelta.F_AST_AFFECTED 
				|| delta.getFlags() == (IJavaElementDelta.F_AST_AFFECTED | IJavaElementDelta.F_CONTENT | IJavaElementDelta.F_FINE_GRAINED)) {
			return Collections.emptyList();
		}
		try {
			List<IResourceDescription.Delta> result = Lists.newArrayListWithExpectedSize(2);
			convertCompilationUnits(delta, result);
			return result;
		} catch(Throwable throwable) {
			if (throwable instanceof VirtualMachineError) {
				throw (VirtualMachineError) throwable;
			}
			if (logger.isEnabledFor(Level.ERROR)) {
				logger.error(throwable.getMessage(), throwable);
			}
			return Collections.emptyList();
		}
	}

	protected void convertCompilationUnit(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		if (delta.getKind() == IJavaElementDelta.ADDED) {
			convertAddedCompilationUnit(delta, result);
		} else if (delta.getKind() == IJavaElementDelta.REMOVED) {
			convertRemovedCompilationUnit(delta, result);
		} else {
			convertChangedCompilationUnit(delta, result);
		}
	}

	/**
	 * @since 2.5
	 */
	protected void convertAddedCompilationUnit(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		ICompilationUnit compilationUnit = (ICompilationUnit) delta.getElement();
		convertNewTypes(compilationUnit, result);
	}

	/**
	 * It is not possible to get information about removed types because a respective compilation unit does not exist.
	 * So we can only guess that primary type were removed.
	 * @since 2.5
	 */
	protected void convertRemovedCompilationUnit(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		ICompilationUnit compilationUnit = (ICompilationUnit) delta.getElement();
		String expectedPrimaryTypeName = getExpectedPrimaryTypeNameFor(compilationUnit);
		URI uri = uriHelper.createResourceURIForFQN(expectedPrimaryTypeName);
		TypeResourceDescription oldDescription = new TypeResourceDescription(uri, Collections.<IEObjectDescription>singletonList(
				new NameBasedEObjectDescription(nameConverter.toQualifiedName(expectedPrimaryTypeName))));
		IResourceDescription.Delta resourceDelta = createContentChangeDelta(compilationUnit, oldDescription, null);
		result.add(resourceDelta);
	}

	/**
	 * @since 2.5
	 */
	protected void convertChangedCompilationUnit(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		if ((delta.getFlags() & IJavaElementDelta.F_PRIMARY_WORKING_COPY) != 0) {
			return;
		}
		if (hasChildren(delta)) {
			convertCompilationUnitChildren(delta, result);
		}
		if (!hasContentChanges(delta)) {
			return;
		}
		/*
		 * A compilation unit was changed but delta does not contain any information about children.
		 * So we can only assume that a primary type was changed.
		 */
		ICompilationUnit compilationUnit = (ICompilationUnit) delta.getElement();
		IType primaryType = getPrimaryTypeFrom(compilationUnit);
		String expectedPrimaryTypeName = getExpectedPrimaryTypeNameFor(compilationUnit);
		if (primaryType != null) {
			if (!isDerived(primaryType)) {
				URI uri = getURIFor(primaryType);
				List<IEObjectDescription> exported = getExportedEObjects(primaryType);
				TypeResourceDescription newDescription = new TypeResourceDescription(uri, exported);
				TypeResourceDescription oldDescription = null;
				if (primaryType.getFullyQualifiedName().equals(expectedPrimaryTypeName)) {
					oldDescription = new TypeResourceDescription(uri, Collections.<IEObjectDescription>singletonList(
						new NameBasedEObjectDescription(nameConverter.toQualifiedName(expectedPrimaryTypeName))));
				}
				Delta resourceDescriptionDelta = createDelta(delta, compilationUnit, oldDescription, newDescription);
				result.add(resourceDescriptionDelta);
			}
		}
	}

	private void convertCompilationUnitChildren(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		ICompilationUnit compilationUnit = (ICompilationUnit) delta.getElement();
		for(IJavaElementDelta child: delta.getAffectedChildren()) {
			IJavaElement childElement = child.getElement();
			if (childElement instanceof IType) {
				convertTypeDelta(compilationUnit, child, result);
			} else if (childElement instanceof IImportContainer) {
				convertImportContainerDelta(compilationUnit, result);
			}
		}
	}
	
	/**
	 * handle types changes
	 */
	private void convertTypeDelta(ICompilationUnit compilationUnit, IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		IType type = (IType) delta.getElement();
		if (hasChildren(delta)) {
			for(IJavaElementDelta child: delta.getAffectedChildren()) {
				if (child.getElement() instanceof IType) {
					convertTypeDelta(compilationUnit, child, result);
				}
			}
		}
		if (delta.getKind() == IJavaElementDelta.ADDED) {
			converNewTypes(type, compilationUnit, result);
		}
		if (!isDerived(type)) {
			URI uri = getURIFor(type);
			List<IEObjectDescription> exported = getExportedEObjects(type);
			IResourceDescription oldDescription = null;
			TypeResourceDescription newDescription = null;
			if (delta.getKind() == IJavaElementDelta.REMOVED) {
				oldDescription = new TypeResourceDescription(uri, exported);
			} else if (delta.getKind() == IJavaElementDelta.ADDED) {
				newDescription = new TypeResourceDescription(uri, exported);
			} else {
				newDescription = new TypeResourceDescription(uri, exported);
				List<IEObjectDescription> additionallyExportedEObjects = getAdditionallyExportedEObjects(type, delta);
				oldDescription = new LayeredTypeResourceDescription(newDescription, additionallyExportedEObjects);
			}
			IResourceDescription.Delta resourceDelta = createDelta(delta, compilationUnit, oldDescription, newDescription);
			result.add(resourceDelta);
		}
	}

	/**
	 * handle import changes
	 */
	private void convertImportContainerDelta(ICompilationUnit compilationUnit, List<IResourceDescription.Delta> result) {
		try {
			for(IType type: compilationUnit.getAllTypes()) {
				if (!isDerived(type)) {
					URI uri = getURIFor(type);
					List<IEObjectDescription> exported = getExportedEObjects(type);
					TypeResourceDescription newDescription = new TypeResourceDescription(uri, exported);
					IResourceDescription oldDescription = new TypeResourceDescription(uri, Collections.<IEObjectDescription>singletonList(
							new NameBasedEObjectDescription(nameConverter.toQualifiedName(type.getFullyQualifiedName()))));
					IResourceDescription.Delta resourceDelta = createStructureChangeDelta(compilationUnit, oldDescription, newDescription);
					result.add(resourceDelta);
				}
			}
		} catch(JavaModelException e) {
			if (logger.isDebugEnabled())
				logger.debug(e, e);
		}
	}

	private void converNewTypes(IType type, ICompilationUnit compilationUnit, List<IResourceDescription.Delta> result) {
		try {
			convertNewTypes(type.getTypes(), compilationUnit, result);
		} catch (JavaModelException e) {
			if (logger.isDebugEnabled())
				logger.debug(e, e);
		}
	}

	private void convertNewTypes(ICompilationUnit compilationUnit, List<IResourceDescription.Delta> result) {
		try {
			convertNewTypes(compilationUnit.getAllTypes(), compilationUnit, result);
		} catch (JavaModelException e) {
			if (logger.isDebugEnabled())
				logger.debug(e, e);
		}
	}

	private void convertNewTypes(IType[] types, ICompilationUnit compilationUnit, List<IResourceDescription.Delta> result) {
		for (IType type : types) {
			if (!isDerived(type)) {
				URI uri = getURIFor(type);
				List<IEObjectDescription> exported = getExportedEObjects(type);
				TypeResourceDescription newDescription = new TypeResourceDescription(uri, exported);
				IResourceDescription.Delta resourceDelta = createContentChangeDelta(compilationUnit, null, newDescription);
				result.add(resourceDelta);
			}
		}
	}

	/**
	 * @since 2.5
	 */
	protected Delta createDelta(IJavaElementDelta delta, ICompilationUnit compilationUnit, IResourceDescription oldDescription, IResourceDescription newDescription) {
		if (hasStructuralChanges(delta)) {
			return createStructureChangeDelta(compilationUnit, oldDescription, newDescription);
		}
		return createContentChangeDelta(compilationUnit, oldDescription, newDescription);
	}

	/**
	 * @since 2.5
	 */
	protected Delta createContentChangeDelta(ICompilationUnit compilationUnit, IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new ChangedResourceDescriptionDelta(oldDescription, newDescription);
	}

	/**
	 * @since 2.5
	 */
	protected IResourceDescription.Delta createStructureChangeDelta(ICompilationUnit compilationUnit, IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new ChangedResourceDescriptionDelta(oldDescription, newDescription);
	}

	/**
	 * @since 2.5
	 */
	protected boolean hasChildren(IJavaElementDelta delta) {
		return (delta.getFlags() & IJavaElementDelta.F_CHILDREN) != 0;
	}

	/**
	 * @since 2.5
	 */
	protected boolean hasStructuralChanges(IJavaElementDelta delta) {
		return (delta.getFlags() & IJavaElementDelta.F_FINE_GRAINED) != 0;
	}

	/**
	 * @since 2.5
	 */
	protected boolean hasContentChanges(IJavaElementDelta delta) {
		return (delta.getFlags() & IJavaElementDelta.F_CONTENT) != 0;
	}
	
	/**
	 * @since 2.4
	 */
	protected boolean isDerived(IType type) {
		QualifiedName qualifiedName = nameConverter.toQualifiedName(type.getFullyQualifiedName());
		Iterable<IEObjectDescription> iterable = resourceDescriptions.getExportedObjects(TypesPackage.Literals.JVM_TYPE, qualifiedName, false);
		return iterable.iterator().hasNext();
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
		if (element.getElementType() == IJavaElement.COMPILATION_UNIT) {
			convertCompilationUnit(delta, result);
		}
		if (element.getElementType() < IJavaElement.COMPILATION_UNIT) {
			for(IJavaElementDelta child: delta.getAffectedChildren()) {
				convertCompilationUnits(child, result);
			}
			if (delta.getKind() == IJavaElementDelta.ADDED && delta.getAffectedChildren().length == 0 && element.getElementType() == IJavaElement.PACKAGE_FRAGMENT) {
				IPackageFragment fragment = (IPackageFragment) element;
				try {
					for(ICompilationUnit cu: fragment.getCompilationUnits()) {
						convertNewTypes(cu, result);
					}
				} catch(JavaModelException e) {
					if (logger.isDebugEnabled())
						logger.debug(e, e);
				}
			}
		}
	}

	protected URI getURIFor(IType type) {
		URI result = uriHelper.createResourceURIForFQN(type.getFullyQualifiedName());
		return result;
	}
	
	/**
	 * @since 2.3
	 */
	protected IType getPrimaryTypeFrom(ICompilationUnit cu)
	{
		try {
			if (cu.exists()) {
				IType primaryType = cu.findPrimaryType();
				if (primaryType != null)
					return primaryType;
				
				// if no exact match is found, return the first public type in CU (if any)
				for(IType type: cu.getTypes()) {
					if (Flags.isPublic(type.getFlags()))
						return type;
				}
			}
		} catch(JavaModelException e) {
			if (logger.isDebugEnabled())
				logger.debug(e, e);
		}
		return null;
	}
	
	/**
	 * @since 2.3
	 */
	protected String getExpectedPrimaryTypeNameFor(ICompilationUnit cu) {
		String fileName = cu.getElementName();
		String typeName = fileName.substring(0, fileName.lastIndexOf('.'));
		IPackageFragment pkg = (IPackageFragment)cu.getParent();
		if (!pkg.isDefaultPackage()) {
			typeName = pkg.getElementName() + '.' + typeName;
		}
		return typeName;
	}

}