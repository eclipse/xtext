package org.eclipse.xtext.builder;

import java.util.Set;

import org.eclipse.core.resources.IStorage;


public interface IResourceIndexer {

	/**
	 * @param storage
	 * @return the name changes
	 */
	public Set<String> addOrUpdate(IStorage storage);
	
	/**
	 * @param storage
	 * @return the name changes
	 */
	public Set<String> delete(IStorage storage);
}
