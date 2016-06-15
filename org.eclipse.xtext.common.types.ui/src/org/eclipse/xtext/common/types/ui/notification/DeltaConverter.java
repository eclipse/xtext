package org.eclipse.xtext.common.types.ui.notification;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaProject;
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
import org.eclipse.xtext.ui.containers.JavaProjectsState;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * The delta converter transforms {@link IJavaElementDelta JDT's deltas} to
 * {@link org.eclipse.xtext.resource.IResourceDescription.Delta xtext's deltas}. Each of the resulting deltas will
 * return <code>true</code> when
 * {@link org.eclipse.xtext.resource.IResourceDescription.Delta#haveEObjectDescriptionsChanged()
 * haveEObjectDescriptionsChanged} is queried.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 */
public class DeltaConverter {

	/**
	 * Wraps an exception that occured during event conversion. Events that cannot be converted are assumed to have
	 * changes but the {@link #getUri()} may be misleading.
	 * 
	 * @since 2.4
	 * @deprecated this class is not used anymore
	 */
	@Deprecated
	public static class ThrowableWrapper implements IResourceDescription.Delta {

		private String location;
		private String eventAsString;
		private Throwable cause;

		public ThrowableWrapper(String location, String eventAsString, Throwable cause) {
			this.location = location;
			this.eventAsString = eventAsString;
			this.cause = cause;
		}

		@Override
		public URI getUri() {
			return URI.createURI(location);
		}

		@Override
		public IResourceDescription getOld() {
			return null;
		}

		@Override
		public IResourceDescription getNew() {
			return null;
		}

		@Override
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

	private static final Logger LOGGER = Logger.getLogger(DeltaConverter.class);

	private final TypeURIHelper uriHelper;

	/**
	 * The converter for fully qualified names to instances of {@link org.eclipse.xtext.naming.QualifiedName}. It is
	 * safe to use the default qualified name converter since it uses the '.' as separator.
	 */
	private final IQualifiedNameConverter nameConverter;
	
	@Inject
	private ISharedStateContributionRegistry javaProjectsStateAccess;
	private JavaProjectsState cachedState;
	
	/**
	 * @since 2.5
	 */
	@Inject
	public DeltaConverter(IQualifiedNameConverter nameConverter, TypeURIHelper uriHelper, IResourceDescriptions resourceDescriptions) {
		this.nameConverter = nameConverter;
		this.uriHelper = uriHelper;
		this.resourceDescriptions = resourceDescriptions;
	}

	private IResourceDescriptions resourceDescriptions;

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
		} catch (Throwable throwable) {
			if (throwable instanceof VirtualMachineError) {
				throw (VirtualMachineError) throwable;
			}
			if (LOGGER.isEnabledFor(Level.ERROR)) {
				LOGGER.error(throwable.getMessage(), throwable);
			}
			return Collections.emptyList();
		}
	}

	protected void convertCompilationUnit(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		if (delta.getKind() == IJavaElementDelta.ADDED) {
			convertAddedCompilationUnit(delta, result);
		} else if (delta.getKind() == IJavaElementDelta.REMOVED) {
			convertRemovedTypes(delta, result);
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
	 * @since 2.5
	 */
	protected void convertChangedCompilationUnit(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		if ((delta.getFlags() & IJavaElementDelta.F_PRIMARY_WORKING_COPY) != 0) {
			return;
		}
		TypeNames typeNames = getTypeNamesFromIndex(delta);
		
		ICompilationUnit compilationUnit = (ICompilationUnit) delta.getElement();
		try {
			for (IType type : compilationUnit.getTypes()) {
				if (isDerived(type))
					return;
				String typeName = type.getFullyQualifiedName();
				URI topLevelURI = uriHelper.createResourceURIForFQN(typeName);
				convertChangedTypeAndChildren(result, typeNames, type, topLevelURI);
				
			}
			convertRemovedTypes(typeNames, result);
		} catch (JavaModelException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e, e);
			}
		}
	}
	/**
	 * @since 2.8
	 */
	private void convertChangedTypeAndChildren(List<IResourceDescription.Delta> result, TypeNames previousTypeNames,
			IType type, URI topLevelUri) {
		String typeName = type.getFullyQualifiedName();
		if (previousTypeNames.remove(typeName)) {
			convertChangedType(topLevelUri, type, result);
		} else {
			convertNewType(topLevelUri, type, result);
		}
		try {
			for(IType child : type.getTypes()){
				convertChangedTypeAndChildren(result, previousTypeNames, child, topLevelUri);
			}
		} catch (JavaModelException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e, e);
			}
		}
	}

	/**
	 * @since 2.5
	 * @deprecated
	 * @see #convertChangedType(URI, IType, List)
	 */
	@Deprecated
	protected void convertChangedType(IType type, List<IResourceDescription.Delta> result) {
		if (!isDerived(type)) {
			TypeResourceDescription newDescription = createTypeResourceDescription(type.getFullyQualifiedName());
			IResourceDescription oldDescription = createTypeResourceDescription(newDescription.getURI(),
					type.getFullyQualifiedName());
			result.add(createStructureChangeDelta(type, oldDescription, newDescription));
		}
	}
	
	/**
	 * @since 2.8
	 */
	protected void convertChangedType(URI topLevelUri, IType type, List<IResourceDescription.Delta> result) {
		TypeResourceDescription newDescription = createTypeResourceDescription(topLevelUri, type.getFullyQualifiedName());
		IResourceDescription oldDescription = createTypeResourceDescription(newDescription.getURI(),
				type.getFullyQualifiedName());
		result.add(createStructureChangeDelta(type, oldDescription, newDescription));
	}

	/**
	 * @since 2.5
	 */
	protected void convertNewTypes(ICompilationUnit compilationUnit, List<IResourceDescription.Delta> result) {
		try {
			for (IType type : compilationUnit.getTypes()) {
				if (isDerived(type))
					return;
				String typeName = type.getFullyQualifiedName();
				URI topLevelURI = uriHelper.createResourceURIForFQN(typeName);
				convertNewTypeAndChildren(topLevelURI, type, result);
			}
		} catch (JavaModelException e) {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug(e, e);
		}
	}

	/**
	 * @since 2.5
	 * @deprecated 
	 * @see #convertNewType(URI, IType, List)
	 */
	@Deprecated
	protected void convertNewType(IType type, List<IResourceDescription.Delta> result) {
		if (!isDerived(type)) {
			result.add(createContentChangeDelta(null, createTypeResourceDescription(type.getFullyQualifiedName())));
		}
	}

	/**
	 * @since 2.8
	 */
	protected void convertNewTypeAndChildren(URI topLevelType, IType type, List<IResourceDescription.Delta> result) {
		convertNewType(topLevelType, type, result);
		try {
			for(IType child : type.getTypes()){
				convertNewTypeAndChildren(topLevelType, child, result);
			}
		} catch (JavaModelException e) {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug(e, e);
		}
	}
	
	/**
	 * @since 2.8
	 */
	protected void convertNewType(URI topLevelType, IType type, List<IResourceDescription.Delta> result) {
		result.add(createContentChangeDelta(null, createTypeResourceDescription(topLevelType, type.getFullyQualifiedName())));
	}

	/**
	 * @since 2.8
	 */
	protected void convertRemovedType(String typeName, IJavaProject project, List<IResourceDescription.Delta> result) {
		if (!isDerived(typeName, project)) {
			result.add(createContentChangeDelta(createTypeResourceDescription(typeName), null));
		}
	}
	
	/**
	 * @since 2.8
	 */
	protected void convertRemovedType(URI toplevelUri, String typeName, IJavaProject context, List<IResourceDescription.Delta> result) {
		if (!isDerived(typeName, context)) {
			result.add(createContentChangeDelta(createTypeResourceDescription(toplevelUri, typeName), null));
		}
	}

	/**
	 * @since 2.5
	 * @deprecated 
	 * @see #createTypeResourceDescription(URI, String)
	 */
	@Deprecated
	protected TypeResourceDescription createTypeResourceDescription(String typeName) {
		URI uri = uriHelper.createResourceURIForFQN(typeName);
		return createTypeResourceDescription(uri, typeName);
	}

	/**
	 * @since 2.5
	 */
	protected TypeResourceDescription createTypeResourceDescription(URI uri, String qualifiedTypeName) {
		QualifiedName qualifiedName = nameConverter.toQualifiedName(qualifiedTypeName);
		NameBasedEObjectDescription nameBasedEObjectDescription = new NameBasedEObjectDescription(qualifiedName);
		return new TypeResourceDescription(uri,
				Collections.<IEObjectDescription> singletonList(nameBasedEObjectDescription));
	}

	/**
	 * @since 2.5
	 */
	protected Delta createContentChangeDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new ChangedResourceDescriptionDelta(oldDescription, newDescription);
	}

	/**
	 * @since 2.5
	 */
	protected IResourceDescription.Delta createStructureChangeDelta(IType type, IResourceDescription oldDescription,
			IResourceDescription newDescription) {
		return new ChangedResourceDescriptionDelta(oldDescription, newDescription);
	}

	/**
	 * @since 2.4
	 */
	protected boolean isDerived(IType type) {
		return isDerived(type.getFullyQualifiedName(), type.getJavaProject());
	}

	/**
	 * @since 2.8
	 */
	protected boolean isDerived(String typeName, IJavaProject project) {
		QualifiedName qualifiedName = nameConverter.toQualifiedName(typeName);
		Iterable<IEObjectDescription> iterable = resourceDescriptions.getExportedObjects(
				TypesPackage.Literals.JVM_TYPE, qualifiedName, false);
		Iterator<IEObjectDescription> iterator = iterable.iterator();
		if (iterator.hasNext()) {
			if (project != null) {
				JavaProjectsState javaProjectsState = getJavaProjectsState();
				List<String> visibleContainers = javaProjectsState.getVisibleContainerHandles(project.getHandleIdentifier());
				while(iterator.hasNext()) {
					IEObjectDescription description = iterator.next();
					URI resourceURI = description.getEObjectURI().trimFragment();
					String handle = javaProjectsState.getContainerHandle(resourceURI);
					if (visibleContainers.contains(handle)) {
						return true;
					}
				}
				return false;
			}
			return true;
		}
		return false;
	}
	
	private JavaProjectsState getJavaProjectsState() {
		if (cachedState != null)
			return cachedState;
		return cachedState = javaProjectsStateAccess.getSingleContributedInstance(JavaProjectsState.class);
	}

	/**
	 * @deprecated This method is not used anymore.
	 */
	@Deprecated
	protected List<IEObjectDescription> getAdditionallyExportedEObjects(IType type, IJavaElementDelta delta) {
		QualifiedName typeName = nameConverter.toQualifiedName(type.getFullyQualifiedName());
		NameBasedEObjectDescriptionBuilder descriptionBuilder = new NameBasedEObjectDescriptionBuilder(typeName);
		traverseDelta(delta, descriptionBuilder);
		return descriptionBuilder.getExported();
	}

	/**
	 * We don't traverse nested types because they will be included into separate deltas.
	 * 
	 * @deprecated This method is not used anymore.
	 */
	@Deprecated
	protected void traverseDelta(IJavaElementDelta delta, NameBasedEObjectDescriptionBuilder acceptor) {
		for (IJavaElementDelta childDelta : delta.getRemovedChildren()) {
			if (childDelta.getElement().getElementType() != IJavaElement.TYPE) {
				acceptor.accept(childDelta.getElement().getElementName());
			}
		}
	}

	/**
	 * @deprecated This method is not used anymore.
	 */
	@Deprecated
	protected List<IEObjectDescription> getExportedEObjects(IType type) {
		QualifiedName typeName = nameConverter.toQualifiedName(type.getFullyQualifiedName());
		NameBasedEObjectDescriptionBuilder descriptionBuilder = new NameBasedEObjectDescriptionBuilder(typeName);
		traverseType(type, descriptionBuilder);
		return descriptionBuilder.getExported();
	}

	/**
	 * We don't include nested types because structural changes of nested types should not affect Xtend classes which
	 * use top level types.
	 * 
	 * @deprecated This method is not used anymore.
	 */
	@Deprecated
	protected void traverseType(IType type, NameBasedEObjectDescriptionBuilder acceptor) {
		try {
			if (type.exists()) {
				for (IField field : type.getFields()) {
					if (!Flags.isSynthetic(field.getFlags())) {
						String fieldName = field.getElementName();
						acceptor.accept(fieldName);
					}
				}
				for (IMethod method : type.getMethods()) {
					if (!Flags.isSynthetic(method.getFlags())) {
						String methodName = method.getElementName();
						acceptor.accept(methodName);
					}
				}

			}
		} catch (JavaModelException e) {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug(e, e);
		}
	}

	protected void convertCompilationUnits(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		IJavaElement element = delta.getElement();
		if (element.getElementType() == IJavaElement.COMPILATION_UNIT) {
			convertCompilationUnit(delta, result);
		}
		if (element.getElementType() < IJavaElement.COMPILATION_UNIT) {
			for (IJavaElementDelta child : delta.getAffectedChildren()) {
				convertCompilationUnits(child, result);
			}
			if (element.getElementType() == IJavaElement.PACKAGE_FRAGMENT) {
				convertPackageFragment(delta, result);
			}
		}
	}

	/**
	 * @since 2.5
	 */
	protected void convertPackageFragment(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		if (delta.getKind() == IJavaElementDelta.ADDED) {
			convertAddedPackageFragment(delta, result);
		} else if (delta.getKind() == IJavaElementDelta.REMOVED) {
			convertRemovedTypes(delta, result);
		}
	}

	/**
	 * @since 2.5
	 */
	protected void convertAddedPackageFragment(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		IPackageFragment fragment = (IPackageFragment) delta.getElement();
		try {
			for (ICompilationUnit cu : fragment.getCompilationUnits()) {
				convertNewTypes(cu, result);
			}
		} catch (JavaModelException e) {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug(e, e);
		}
	}

	/**
	 * @since 2.5
	 */
	protected void convertRemovedTypes(IJavaElementDelta delta, List<IResourceDescription.Delta> result) {
		convertRemovedTypes(getTypeNamesFromIndex(delta), result);
	}


	/**
	 * @since 2.8
	 * @deprecated
	 * @see #convertRemovedTypes(TypeNames, List)
	 */
	@Deprecated
	protected void convertRemovedTypes(Collection<String> typeNames, IJavaProject project, List<IResourceDescription.Delta> result) {
		for (String typeName : typeNames) {
			convertRemovedType(typeName, project, result);
		}
	}
	
	/**
	 * @since 2.8
	 */
	protected void convertRemovedTypes(TypeNames typeNames, List<IResourceDescription.Delta> result) {
		for (String typeName : typeNames.getTypeNames()) {
			URI toplevelUri = uriHelper.createResourceURIForFQN(typeNames.getTopLevelTypeName(typeName));
			convertRemovedType(toplevelUri, typeName, typeNames.getProjectContext(), result);
		}
	}
	
	/**
	 * @since 2.5
	 * @deprecated 
	 * @see #getTypeNamesFromIndex(IJavaElementDelta)
	 * 
	 */
	@Deprecated
	protected Collection<String> getQualifiedTypeNames(IJavaElementDelta delta) {
		return getQualifiedTypeNames(delta.getElement());
	}

	/**
	 * @since 2.5
	 * @deprecated 
	 * @see #getTypeNamesFromIndex(IJavaElement)
	 * 
	 */
	@Deprecated
	protected Collection<String> getQualifiedTypeNames(IJavaElement element) {
		return getTypeNamesFromIndex(element).getTypeNames();
	}
	
	/**
	 * @since 2.8
	 */
	protected TypeNames getTypeNamesFromIndex(IJavaElementDelta delta) {
		return getTypeNamesFromIndex(delta.getElement());
	}

	/**
	 * @since 2.8
	 */
	protected TypeNames getTypeNamesFromIndex(IJavaElement element) {
		return JavaBuilderState.getLastBuiltState(element).getQualifiedTypeNames(element);
	}

	protected URI getURIFor(IType type) {
		return uriHelper.createResourceURIForFQN(type.getFullyQualifiedName());
	}

	/**
	 * @since 2.3
	 * @deprecated This method is not used anymore.
	 */
	@Deprecated
	protected IType getPrimaryTypeFrom(ICompilationUnit cu) {
		try {
			if (cu.exists()) {
				IType primaryType = cu.findPrimaryType();
				if (primaryType != null)
					return primaryType;

				// if no exact match is found, return the first public type in CU (if any)
				for (IType type : cu.getTypes()) {
					if (Flags.isPublic(type.getFlags()))
						return type;
				}
			}
		} catch (JavaModelException e) {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug(e, e);
		}
		return null;
	}

	/**
	 * @since 2.3
	 * @deprecated This method is not used anymore.
	 */
	@Deprecated
	protected String getExpectedPrimaryTypeNameFor(ICompilationUnit cu) {
		String fileName = cu.getElementName();
		String typeName = fileName.substring(0, fileName.lastIndexOf('.'));
		IPackageFragment pkg = (IPackageFragment) cu.getParent();
		if (!pkg.isDefaultPackage()) {
			typeName = pkg.getElementName() + '.' + typeName;
		}
		return typeName;
	}

}