package org.eclipse.xtext.builder.trace;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;

import com.google.inject.ImplementedBy;

/**
 * Equivalent to {@link ITraceForStorageProvider} for ITypeRoots (e.g. IClassFiles) since there is no IStorage for them.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@NonNullByDefault
@ImplementedBy(TraceForTypeRootProvider.class)
public interface ITraceForTypeRootProvider {
	
	@Nullable ITrace getTraceToSource(ITypeRoot derivedResource);
	
}