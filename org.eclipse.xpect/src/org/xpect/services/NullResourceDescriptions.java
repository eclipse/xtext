package org.xpect.services;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

/**
 * workaround to fix https://github.com/meysholdt/Xpect/issues/21
 * 
 * The Xpect language doesn't declare/export any named elements at all
 * 
 * @author Moritz Eysholdt
 */
public class NullResourceDescriptions implements IResourceDescriptions {

	public boolean isEmpty() {
		return true;
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		return Collections.emptyList();
	}

	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return Collections.emptyList();
	}

	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return Collections.emptyList();
	}

	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return Collections.emptyList();
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Collections.emptyList();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return null;
	}

}
