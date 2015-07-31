package org.eclipse.xtext.common.types.ui.trace;

import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;

import com.google.inject.ImplementedBy;

/**
 * Equivalent to {@link ITraceForStorageProvider} for ITypeRoots (e.g. IClassFiles) since there is no IStorage for them.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(TraceForTypeRootProvider.class)
public interface ITraceForTypeRootProvider {
	
	/* @Nullable */ IEclipseTrace getTraceToSource(ITypeRoot derivedResource);
	
}