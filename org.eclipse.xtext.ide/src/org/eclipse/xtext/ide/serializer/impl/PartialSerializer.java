/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import static org.eclipse.emf.ecore.change.ChangeKind.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.regionaccess.IAstRegion;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.EObjectChange;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceRecording;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.TokenStreamSequenceAdapter;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.IContextFinder;
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.eclipse.xtext.serializer.tokens.IValueSerializer;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class PartialSerializer {
	@Inject
	private InsertionPointFinder insertionPointFinder;

	protected static class DeleteRegionStrategy implements SerializationStrategy {
		private final IAstRegion region;

		public DeleteRegionStrategy(IAstRegion region) {
			super();
			this.region = region;
		}

		@Override
		public void serialize(ITextRegionDiffBuilder result) {
			result.remove(region.getPreviousHiddenRegion(), region.getNextHiddenRegion());
		}
	}

	protected static class InsertRegionStrategy implements SerializationStrategy {
		private final IHiddenRegion insertAt;
		private final ISequentialRegion toInsert;

		public InsertRegionStrategy(IHiddenRegion insertAt, IAstRegion toInsert) {
			super();
			this.insertAt = insertAt;
			this.toInsert = toInsert;
		}

		@Override
		public void serialize(ITextRegionDiffBuilder result) {
			result.replace(insertAt, insertAt, toInsert.getPreviousHiddenRegion(), toInsert.getNextHiddenRegion());
		}
	}

	protected static class ReplaceRegionStrategy implements SerializationStrategy {
		private final String newText;
		private final ISemanticRegion region;

		public ReplaceRegionStrategy(ISemanticRegion region, String newText) {
			super();
			this.region = region;
			this.newText = newText;
		}

		@Override
		public void serialize(ITextRegionDiffBuilder result) {
			result.replace(region, newText);
		}
	}

	protected interface SerializationStrategy {
		void serialize(ITextRegionDiffBuilder result);
	}

	protected class SerializeRecursiveStrategy implements SerializationStrategy {
		private final ISerializationContext context;
		private final EObject root;
		private final ISequentialRegion insertAt;

		public SerializeRecursiveStrategy(ISequentialRegion insertAt, EObject root, ISerializationContext context) {
			super();
			Preconditions.checkNotNull(insertAt);
			Preconditions.checkNotNull(context);
			Preconditions.checkNotNull(root);
			this.insertAt = insertAt;
			this.context = context;
			this.root = root;
		}

		@Override
		public void serialize(ITextRegionDiffBuilder result) {
			ISemanticSequencer semantic = semanticSequencerProvider.get();
			ISyntacticSequencer syntactic = syntacticSequencerProvider.get();
			IHiddenTokenSequencer hidden = hiddenTokenSequencerProvider.get();
			semantic.init((ISemanticSequenceAcceptor) syntactic, errorAcceptor);
			syntactic.init(context, root, (ISyntacticSequenceAcceptor) hidden, errorAcceptor);
			ISequenceAcceptor acceptor;
			if (insertAt instanceof IHiddenRegion) {
				IHiddenRegion h = (IHiddenRegion) insertAt;
				acceptor = result.replaceSequence(h, h, context, root);
			} else {
				IHiddenRegion originalFirst = insertAt.getPreviousHiddenRegion();
				IHiddenRegion originalLast = insertAt.getNextHiddenRegion();
				acceptor = result.replaceSequence(originalFirst, originalLast, context, root);
			}
			hidden.init(context, root, acceptor, errorAcceptor);
			if (acceptor instanceof TokenStreamSequenceAdapter)
				((TokenStreamSequenceAdapter) acceptor).init(context);
			semantic.createSequence(context, root);
		}
	}

	@Inject
	private IGrammarConstraintProvider constraintProvider;

	@Inject
	private IContextFinder contextFinder;

	@Inject
	private ICrossReferenceSerializer crossRefSerializer;

	private ISerializationDiagnostic.Acceptor errorAcceptor = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;

	@Inject
	private IGrammarAccess grammar;

	@Inject
	private Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;

	@Inject
	private Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String serializerLanguage;

	@Inject
	private Provider<ISyntacticSequencer> syntacticSequencerProvider;

	@Inject
	private ITransientValueService transientValues;

	@Inject
	private IValueSerializer valueSerializer;

	protected void assertLanguage(ResourceRecording change) {
		Resource resource = change.getResource();
		if (resource instanceof XtextResource) {
			String resourceLanguage = ((XtextResource) resource).getLanguageName();
			if (!serializerLanguage.equals(resourceLanguage)) {
				throw new IllegalArgumentException("Can't use serializer from language " + serializerLanguage
						+ " to serialize a resource from language " + resourceLanguage + ".");
			}
		}
	}

	protected List<EObjectChange> collectRootChanges(Collection<? extends EObjectChange> roots) {
		List<EObjectChange> result = Lists.newArrayList();
		LinkedList<EObjectChange> stack = new LinkedList<>();
		stack.addAll(roots);
		while (!stack.isEmpty()) {
			EObjectChange candidate = stack.pop();
			if (candidate.getChanges().isEmpty()) {
				stack.addAll(candidate.getChildren());
			} else {
				result.add(candidate);
			}
		}
		return result;
	}

	public ISerializationDiagnostic.Acceptor getErrorAcceptor() {
		return errorAcceptor;
	}

	protected ISerializationContext getSerializationContext(EObject semanticObject) {
		Iterator<ISerializationContext> contexts = contextFinder.findByContentsAndContainer(semanticObject, null)
				.iterator();
		if (!contexts.hasNext())
			throw new RuntimeException("No Context for " + EmfFormatter.objPath(semanticObject) + " could be found");
		return contexts.next();
	}

	protected ISerializationContext getSerializationContext(IEObjectRegion region) {
		EObject grammarElement = region.getGrammarElement();
		if (grammarElement instanceof RuleCall) {
			grammarElement = ((RuleCall) grammarElement).getRule();
		}
		return SerializationContext.fromEObject(grammarElement, region.getSemanticElement());
	}

	public void serializeChanges(ResourceRecording changes, ITextRegionDiffBuilder result) {
		assertLanguage(changes);
		SerializationContextMap<IConstraint> constraints = constraintProvider.getConstraints(grammar.getGrammar());
		List<EObjectChange> rootChanges = collectRootChanges(changes.getRootEObjectRecordings());
		List<SerializationStrategy> strategies = Lists.newArrayList();
		for (EObjectChange change : rootChanges) {
			List<SerializationStrategy> strat = trySerializeEObject(change, result, constraints);
			if (strat != null) {
				strategies.addAll(strat);
			}
		}
		for (SerializationStrategy strategy : strategies) {
			strategy.serialize(result);
		}
	}

	protected List<SerializationStrategy> trySerializeEObject(EObjectChange change, ITextRegionDiffBuilder result,
			SerializationContextMap<IConstraint> constraints) {
		List<SerializationStrategy> strategies = Lists.newArrayList();
		EObject obj = change.getEObject();
		IEObjectRegion originalEObjectRegion = result.getOriginalTextRegionAccess().regionForEObject(obj);
		ISerializationContext modified = getSerializationContext(obj);
		if (originalEObjectRegion == null) {
			return null;
		}
		ISerializationContext original = getSerializationContext(originalEObjectRegion);
		if (!original.equals(modified)) {
			strategies.add(new SerializeRecursiveStrategy(originalEObjectRegion, obj, modified));
			return strategies;
		}
		IConstraint constraint = constraints.get(modified);
		List<SerializationStrategy> features = trySerializeIndividualFeatures(change, originalEObjectRegion, modified,
				constraint);
		if (features == null) {
			strategies.add(new SerializeRecursiveStrategy(originalEObjectRegion, obj, modified));
			return strategies;
		}
		strategies.addAll(features);
		for (EObjectChange child : change.getChildren()) {
			List<SerializationStrategy> c = trySerializeEObject(child, result, constraints);
			if (c == null) {
				return Collections.singletonList(new SerializeRecursiveStrategy(originalEObjectRegion, obj, modified));
			} else {
				strategies.addAll(c);
			}
		}
		return strategies;
	}

	public void setErrorAcceptor(ISerializationDiagnostic.Acceptor errorAcceptor) {
		this.errorAcceptor = errorAcceptor;
	}

	protected List<SerializationStrategy> trySerializeIndividualFeatures(EObjectChange change, IEObjectRegion original,
			ISerializationContext context, IConstraint constraint) {
		List<SerializationStrategy> result = Lists.newArrayList();
		EObject object = change.getEObject();
		for (FeatureChange featureChange : change.getChanges()) {
			EStructuralFeature feature = featureChange.getFeature();
			List<SerializationStrategy> values = null;
			// if (feature instanceof EReference && ((EReference)
			// feature).isContainment()) {
			// if (feature.isMany()) {
			// values = trySerializeMultiValueContainment(object, featureChange,
			// original, constraint);
			// } else {
			// values = trySerializeSingleValue(object, featureChange, original,
			// constraint);
			// }
			// } else {
			if (feature.isMany()) {
				values = trySerializeMultiValue(object, featureChange, original, constraint);
			} else {
				values = trySerializeSingleValue(object, featureChange, original, constraint);
			}
			// }
			if (values == null) {
				return null;
			}
			result.addAll(values);
		}
		return result;
	}

	protected List<SerializationStrategy> trySerializeSingleValue(EObject owner, FeatureChange change,
			IEObjectRegion ownerRegion, IConstraint constraint) {
		List<SerializationStrategy> result = Lists.newArrayList();
		EStructuralFeature feature = change.getFeature();
		IFeatureInfo featureInfo = constraint.getFeatures()[owner.eClass().getFeatureID(feature)];
		List<IConstraintElement> assignments = featureInfo.getAssignments();
		if (assignments.isEmpty()) {
			ValueTransient valueTransient = transientValues.isValueTransient(owner, feature);
			if (valueTransient == ValueTransient.YES) {
				return result;
			}
			return null;
		} else if (assignments.size() != 1) {
			return null;
		}
		boolean optional = assignments.get(0).isOptional();
		IAstRegion featureRegion = findRegion(ownerRegion, change);
		ValueTransient valueTransient = transientValues.isValueTransient(owner, feature);
		switch (valueTransient) {
		case YES:
			if (featureRegion != null) {
				if (optional) {
					result.add(new DeleteRegionStrategy(featureRegion));
				} else {
					return null;
				}
			}
			break;
		case PREFERABLY:
			if (featureRegion != null) {
				if (optional) {
					result.add(new DeleteRegionStrategy(featureRegion));
				} else {
					SerializationStrategy update = updateSingleValue(owner, feature, featureRegion);
					if (update != null) {
						result.add(update);
					} else {
						return null;
					}
				}
			}
			break;
		case NO:
			if (featureRegion == null) {
				return null;
			}
			SerializationStrategy update = updateSingleValue(owner, feature, featureRegion);
			if (update != null) {
				result.add(update);
			} else {
				return null;
			}
			break;
		}
		return result;
	}

	protected List<IAstRegion> findRegions(IEObjectRegion owner, FeatureChange change) {
		EStructuralFeature feature = change.getFeature();
		if (feature instanceof EReference && ((EReference) feature).isContainment()) {
			ITextRegionAccess access = owner.getTextRegionAccess();
			Set<EObject> children = Sets.newHashSet();
			for (ListChange lc : change.getListChanges()) {
				children.addAll(lc.getReferenceValues());
			}
			List<IEObjectRegion> result = Lists.newArrayList();
			for (EObject obj : children) {
				IEObjectRegion region = access.regionForEObject(obj);
				if (region != null) {
					result.add(region);
				}
			}
			for (IAstRegion astRegion : owner.getAstRegions()) {
				if (astRegion instanceof IEObjectRegion) {
					if (feature.equals(astRegion.getContainingFeature())) {
						result.add((IEObjectRegion) astRegion);
					}
				}
			}
			Collections.sort(result, (a, b) -> a.getOffset() - b.getOffset());
			return ImmutableList.copyOf(result);
		} else {
			return ImmutableList.copyOf(owner.getRegionFor().features(feature));
		}
	}

	protected IAstRegion findRegion(IEObjectRegion owner, FeatureChange change) {
		EStructuralFeature feature = change.getFeature();
		if (feature instanceof EReference && ((EReference) feature).isContainment()) {
			ITextRegionAccess access = owner.getTextRegionAccess();
			EObject oldValue = change.getReferenceValue();
			if (oldValue != null) {
				return access.regionForEObject(oldValue);
			}
			for (IAstRegion astRegion : owner.getAstRegions()) {
				if (astRegion instanceof IEObjectRegion) {
					if (feature.equals(astRegion.getContainingFeature())) {
						return  astRegion;
					}
				}
			}
			return null;
		} else {
			return owner.getRegionFor().feature(feature);
		}
	}

	protected List<SerializationStrategy> trySerializeMultiValue(EObject owner, FeatureChange change,
			IEObjectRegion ownerRegion, IConstraint constraint) {
		EStructuralFeature feature = change.getFeature();
		List<SerializationStrategy> result = Lists.newArrayList();
		IFeatureInfo featureInfo = constraint.getFeatures()[owner.eClass().getFeatureID(feature)];
		List<IConstraintElement> assignments = featureInfo.getAssignments();
		if (assignments.size() != 1) {
			return null;
		}
		IConstraintElement assignment = assignments.get(0);
		if (!assignment.isMany()) {
			return null;
		}
		List<IAstRegion> originals = findRegions(ownerRegion, change);
		EList<ListChange> listChanges = change.getListChanges();
		if (listChanges.isEmpty() && originals.isEmpty()) {
			ISerializationContext ctx = getSerializationContext(owner);
			AbstractElement ins = assignment.getGrammarElement();
			IHiddenRegion insertAt = insertionPointFinder.findInsertionPoint(ctx, ownerRegion, ins);
			if (insertAt == null) {
				return null;
			}
			for (Object value : (List<?>) owner.eGet(feature)) {
				EObject obj = (EObject) value;
				ISerializationContext context = getSerializationContext(obj);
				result.add(new SerializeRecursiveStrategy(insertAt, obj, context));
			}
			return result;
		}
		// ListTransient listTransient = transientValues.isListTransient(owner, feature);
		List<Object> modifying = Lists.newArrayList(((List<?>) owner.eGet(feature)));
		for (ListChange lc : listChanges) {
			ChangeKind kind = lc.getKind();
			if (kind == ADD_LITERAL) {
				IAstRegion region = originals.get(lc.getIndex());
				result.add(new DeleteRegionStrategy(region));
			} else if (kind == MOVE_LITERAL || kind == REMOVE_LITERAL) {
				if (originals.isEmpty()) {
					return null;
				}
				int index = lc.getIndex();
				IHiddenRegion insertAt;
				if (index >= originals.size()) {
					insertAt = ((ISequentialRegion) originals.get(originals.size() - 1)).getNextHiddenRegion();
				} else {
					insertAt = ((ISequentialRegion) originals.get(index)).getPreviousHiddenRegion();
				}
				if (insertAt == null) {
					return null;
				}
				EObject value = (EObject) modifying.get(index);
				modifying.remove(index);
				if (kind == REMOVE_LITERAL) {
					ISerializationContext context = getSerializationContext(value);
					result.add(new SerializeRecursiveStrategy(insertAt, value, context));
				} else if (kind == ChangeKind.MOVE_LITERAL) {
					int moveToIndex = lc.getMoveToIndex();
					IAstRegion source = originals.get(moveToIndex);
					result.add(new DeleteRegionStrategy(source));
					result.add(new InsertRegionStrategy(insertAt, source));
				}
			}
		}
		return result;

	}

	protected SerializationStrategy updateSingleValue(EObject object, EStructuralFeature feature, IAstRegion region) {
		Preconditions.checkArgument(!feature.isMany());
		Object value = object.eGet(feature);
		EObject grammarElement = region.getGrammarElement();
		if (feature instanceof EAttribute) {
			if (grammarElement instanceof RuleCall) {
				RuleCall rc = (RuleCall) grammarElement;
				String newValue = valueSerializer.serializeAssignedValue(object, rc, value, null, errorAcceptor);
				if (newValue != null) {
					return new ReplaceRegionStrategy((ISemanticRegion) region, newValue);
				}
			}
			return null;
		} else if (feature instanceof EReference) {
			if (((EReference) feature).isContainment()) {
				IEObjectRegion reg = (IEObjectRegion) region;
				EObject newEObject = (EObject) object.eGet(feature);
				ISerializationContext newContext = getSerializationContext(newEObject);
				ISerializationContext oldContext = getSerializationContext(reg);
				if (!oldContext.equals(newContext)) {
					return null;
				}
				return new SerializeRecursiveStrategy(reg, newEObject, newContext);
			} else {
				CrossReference cr = GrammarUtil.containingCrossReference(grammarElement);
				if (cr != null) {
					EObject target = (EObject) value;
					String newValue = crossRefSerializer.serializeCrossRef(object, cr, target, null, errorAcceptor);
					if (newValue != null) {
						return new ReplaceRegionStrategy((ISemanticRegion) region, newValue);
					}
				}
			}
			return null;
		}
		return null;
	}

}
