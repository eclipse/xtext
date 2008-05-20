package org.eclipse.xtext.core.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class AbstractParseTreeRewriter {

	protected abstract AbstractEcoreElementFactory getFactory();

	protected final InstanceDescription getDescr(InstanceDescription obj) {
		return obj;
	}

	protected final InstanceDescription getDescr(EObject obj) {
		return new InstanceDescription(obj, false);
	}

	protected final InstanceDescription getDescr(EObject obj, boolean lookahead) {
		return new InstanceDescription(obj, lookahead);
	}

	public final class InstanceDescription {

		public boolean isInstanceOf(String string) {
			EClass class1 = getFactory().getEClass(string);
			return class1 != null && class1.isSuperTypeOf(getDelegate().eClass());
		}

		public boolean isOfType(String string) {
			EClass class1 = getFactory().getEClass(string);
			return class1 != null && class1.equals(getDelegate().eClass());
		}

		public EObject getDelegate() {
			return described;
		}

		private boolean isLookahead = false;

		private EObject described;
		private Map<String, Integer> featureConsumedCounter = new HashMap<String, Integer>();

		public InstanceDescription(EObject described, boolean lookahead) {
			super();
			if (described==null)
				throw new NullPointerException("described");
			this.described = described;
			this.isLookahead = lookahead;
			EList<EStructuralFeature> features = described.eClass().getEAllStructuralFeatures();
			for (EStructuralFeature f : features) {
				Integer integer = 0;
				if (described.eIsSet(f)) {
					if (f.isMany()) {
						integer = ((List<?>) described.eGet(f)).size();
					} else {
						integer = 1;
					}
				}
				featureConsumedCounter.put(f.getName(), integer);
			}
		}

		private InstanceDescription(EObject described, Map<String, Integer> featureConsumedCounter) {
			super();
			this.isLookahead = true;
			this.described = described;
			this.featureConsumedCounter = featureConsumedCounter;
		}

		public boolean isLookahead() {
			return isLookahead;
		}

		@Override
		public String toString() {
			return hashCode() + "/" + described.hashCode();
		}

		public Object consume(String feature) {
			if (!isConsumable(feature))
				throw new IllegalStateException(feature + " is not consumable");
			Integer counter = lazyGet(feature);
			EStructuralFeature f = getFeature(feature);
			Object get = described.eGet(f);
			if (f.isMany()) {
				List<?> list = (List<?>) get;
				get = list.get(counter-1);
			}
			featureConsumedCounter.put(feature, counter - 1);
			return get;
		}
		
		public boolean checkConsume(String feature) {
			if (!isConsumable(feature))
				return false;
			Integer counter = lazyGet(feature);
			EStructuralFeature f = getFeature(feature);
			Object get = described.eGet(f);
			if (f.isMany()) {
				List<?> list = (List<?>) get;
				get = list.get(counter-1);
			}
			featureConsumedCounter.put(feature, counter - 1);
			return true;
		}

		private Integer lazyGet(String feature) {
			Integer integer = featureConsumedCounter.get(feature);
			if (integer == null) {
				return 0;
			}
			return integer;
		}

		private EStructuralFeature getFeature(String feature) {
			return described.eClass().getEStructuralFeature(feature);
		}

		public boolean isConsumable(String feature) {
			return lazyGet(feature) > 0;
		}

		public boolean isConsumed() {
			for (Integer i : featureConsumedCounter.values()) {
				if (i > 0)
					return false;
			}
			return true;
		}

		public InstanceDescription newLookaheadDescription() {
			return new InstanceDescription(described, new HashMap<String, Integer>(featureConsumedCounter));
		}
		
	}
	
	private StringBuffer buff = new StringBuffer();
	
	protected void executeAction(Object element) {
		if (buff.length()>0) 
			buff.insert(0, " ");
		buff.insert(0,element);
	}
	
	public String getText() {
		return buff.toString();
	}

}
