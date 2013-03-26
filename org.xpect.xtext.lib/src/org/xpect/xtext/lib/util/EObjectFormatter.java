package org.xpect.xtext.lib.util;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EObjectFormatter implements Function<EObject, String> {

	protected boolean resolveCrossReferences = false;

	protected boolean showIndex = false;

	public String apply(EObject from) {
		return format(from);
	}

	protected String assignmentOperator(EObject object, EStructuralFeature feature) {
		if (feature instanceof EReference && !((EReference) feature).isContainment())
			return "->";
		else
			return "=";
	}

	public String format(EObject object) {
		if (object == null)
			return "null";
		StringBuilder result = new StringBuilder();
		result.append(object.eClass().getName());
		result.append(" {");
		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures())
			if (shouldFormat(object, feature))
				result.append(indent("\n" + format(object, feature)));
		result.append("\n}");
		return result.toString();
	}

	protected String format(EObject object, EStructuralFeature feature) {
		StringBuilder result = new StringBuilder();
		result.append(feature.getName());
		result.append(" ");
		result.append(assignmentOperator(object, feature));
		result.append(" ");
		Object val = object.eGet(feature, resolveCrossReferences);
		if (feature.isMany()) {
			result.append("[");
			List<?> vals = (List<?>) val;
			List<?> sortedVals = sort(object, feature, vals);
			if (vals == sortedVals) {
				for (int i = 0; i < vals.size(); i++)
					if (shouldFormat(object, feature, i, vals.get(i)))
						result.append(indent("\n" + format(object, feature, i, vals.get(i))));
			} else {
				for (int i = 0; i < sortedVals.size(); i++)
					if (shouldFormat(object, feature, sortedVals.get(i)))
						result.append(indent("\n" + format(object, feature, sortedVals.get(i))));
			}
			result.append("\n]");
		} else
			result.append(format(object, feature, val));
		return result.toString();
	}

	protected String format(EObject object, EStructuralFeature feature, int index, Object value) {
		if (showIndex)
			return index + ": " + format(object, feature, value);
		return format(object, feature, value);
	}

	protected String format(EObject object, EStructuralFeature feature, Object value) {
		if (feature instanceof EAttribute)
			return formatAttributeValue(object, (EAttribute) feature, value);
		else if (feature instanceof EReference) {
			EReference ref = (EReference) feature;
			if (ref.isContainment())
				return format((EObject) value);
			return formatCrossRefValue(object, ref, (EObject) value);
		}
		return "";
	}

	public String format(Iterable<? extends EObject> object) {
		return Joiner.on('\n').join(Iterables.transform(object, this));
	}

	protected String formatAttributeValue(EObject object, EAttribute feature, Object value) {
		if (value == null)
			return "null";
		EFactory factory = feature.getEAttributeType().getEPackage().getEFactoryInstance();
		String stringVal = factory.convertToString(feature.getEAttributeType(), value);
		return "'" + stringVal + "'";
	}

	protected String formatCrossRefValue(EObject object, EReference feature, EObject value) {
		if (value == null)
			return "null";
		if (value.eIsProxy())
			return "proxy (URI: " + ((InternalEObject) value).eProxyURI() + ")";
		if (value.eResource() == object.eResource())
			return value.eClass().getName() + " " + object.eResource().getURIFragment(value);
		URI uri = EcoreUtil.getURI(value);
		uri = uri.deresolve(object.eResource().getURI());
		return value.eClass().getName() + " " + uri.toString();
	}

	protected String indent(String string) {
		return string.replaceAll("\\n", "\n  ");
	}

	public EObjectFormatter resolveCrossReferences() {
		this.resolveCrossReferences = true;
		return this;
	}

	protected boolean shouldFormat(EObject object, EStructuralFeature feature) {
		if (feature.isDerived())
			return false;
		if (feature instanceof EReference && ((EReference) feature).isContainer())
			return false;
		return object.eIsSet(feature);
	}

	protected boolean shouldFormat(EObject object, EStructuralFeature feature, int index, Object value) {
		return true;
	}

	protected boolean shouldFormat(EObject object, EStructuralFeature feature, Object value) {
		return true;
	}

	public EObjectFormatter showIndex() {
		this.showIndex = true;
		return this;
	}

	protected List<?> sort(EObject obj, EStructuralFeature feature, List<?> values) {
		return values;
	}

}