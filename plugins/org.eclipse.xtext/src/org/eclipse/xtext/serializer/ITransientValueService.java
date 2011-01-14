package org.eclipse.xtext.serializer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.serializer.impl.TransientValueService;

import com.google.inject.ImplementedBy;

/**
 * Implementations of this interface decide which values are serialized during serialization. The behavior differs
 * slightly for single-value features and multi-value features, because single-value-features have an extra status:
 * "optional".
 * 
 * Transient Values must not be serialized in any case.
 * 
 * Optional Values should not be serialized, but the serializer may decide to serialize them anyway, if needed. The use
 * case for this is that if a features holds its default value, this values doesn't need to be serialized. However, the
 * grammar may require the grammar to be serialized. Example: (x=INT y=INT)?; For x=1 and y=0 with 0 being y's default
 * value, 0 needs to be serialized since otherwise x can not be serialized.
 * 
 * Multi-Value-Features don't have this "optional" status, because even if their list holds a default-value, this valu
 * needs to be serialized to be preserved.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(TransientValueService.class)
public interface ITransientValueService {

	/**
	 * @return All values contained by multiValueFeature that should be serialized.
	 */
	<T> List<T> getNonTransientValues(EObject semanticObject, EStructuralFeature multiValueFeature);

	/**
	 * @return true, if the value of singleValueFeature can be omitted during serialization. It is recommended to mark
	 *         values as optional if omitting them doesn't lead to the loss of semantic information. For example, if the
	 *         values equals its default value.
	 */
	boolean isOptional(EObject semanticObject, EStructuralFeature singelValueFeature);

	/**
	 * @return true, if the value of singleValueFeature must not be serialized.
	 */
	boolean isTransient(EObject semanticObject, EStructuralFeature singelValueFeature);
}
