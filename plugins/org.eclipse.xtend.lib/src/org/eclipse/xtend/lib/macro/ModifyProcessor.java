package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;

/**
 * 
 * @author Sven Efftinge
 *
 * @param <T> the type which this processor processes. FeatureCall in case of a regualar macro, or any subtype of AnnotationTarget for active annotations.
 */
public interface ModifyProcessor<T extends MutableNamedElement> {
	
	void modify(List<? extends T> annotatedTargetElements, ModifyContext context);
}
