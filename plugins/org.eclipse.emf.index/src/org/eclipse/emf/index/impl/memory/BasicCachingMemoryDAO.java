package org.eclipse.emf.index.impl.memory;

import static org.eclipse.emf.index.util.CollectionUtils.isNotEmpty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.index.IIndexStore;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class BasicCachingMemoryDAO<T> extends BasicMemoryDAOImpl<T> {

	protected BasicCachingMemoryDAO(IIndexStore indexStore) {
		super(indexStore);
	}

	protected abstract class Query extends BasicMemoryDAOImpl<T>.Query {

		protected Collection<T> mergeScopes(Collection<T> scope0, Collection<T> scope1) {
			if (scope0 == null) {
				return scope1;
			}
			if (scope1 == null) {
				return scope0;
			}
			if (isNotEmpty(scope0)) {
				if (isNotEmpty(scope1)) {
					List<T> mergedScope = new ArrayList<T>(scope0);
					mergedScope.removeAll(scope1);
					return mergedScope;
				}
				return scope0;
			}
			return scope1;
		}
	}

}
