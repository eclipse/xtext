package org.eclipse.xtext.scoping.namespaces;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.ImplementedBy;

/**
 * 
 * Used to abstract over the concrete implementation of project dependencies, etc.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
@ImplementedBy(IContainerDependencyProvider.Null.class)
public interface IContainerDependencyProvider {

	String getContainer(EObject context);

	List<String> getReferencedContainers(EObject context);

	public static class Null implements IContainerDependencyProvider {

		public String getContainer(EObject context) {
			return null;
		}

		public List<String> getReferencedContainers(EObject context) {
			return Collections.emptyList();
		}

	}
}