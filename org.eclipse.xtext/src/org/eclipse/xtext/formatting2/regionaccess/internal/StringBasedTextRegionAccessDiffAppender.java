/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.regionaccess.HiddenRegionPartAssociation;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;

import com.google.common.base.Preconditions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringBasedTextRegionAccessDiffAppender {
	private ITextSegment diffFirstCopy = null;
	private ITextSegment diffFirstOriginal = null;
	private ITextSegment diffLastCopy = null;
	private ITextSegment diffLastOriginal = null;
	private int diffNesting = 0;
	private ISequentialRegion last;
	private final StringBasedTextRegionAccessDiff result;
	private final Map<ITextSegment, String> textChanges;

	public StringBasedTextRegionAccessDiffAppender(ITextRegionAccess base, Map<ITextSegment, String> textChanges) {
		super();
		this.result = new StringBasedTextRegionAccessDiff(base);
		this.textChanges = textChanges;
		IHiddenRegion region = base.regionForRootEObject().getPreviousHiddenRegion();
		this.diffLastOriginal = region;
		this.diffLastCopy = appendHiddenRegion(region.isUndefined());
	}

	protected StringHiddenRegion appendHiddenRegion(boolean undefined) {
		StringSemanticRegion previous = (StringSemanticRegion) this.last;
		StringHiddenRegion region = new StringHiddenRegion(result);
		if (previous != null) {
			previous.setTrailingHiddenRegion(region);
			region.setPrevious(previous);
		}
		region.setUndefined(undefined);
		this.last = region;
		return region;
	}

	public void beginDiff() {
		if (diffFirstOriginal == null && diffFirstCopy == null && diffNesting == 0) {
			diffFirstOriginal = diffLastOriginal;
			diffFirstCopy = diffLastCopy;
		}
		diffNesting++;
	}

	protected IHiddenRegion copyAndAppend(IHiddenRegion source) {
		StringHiddenRegion region = appendHiddenRegion(source.isUndefined());
		for (IHiddenRegionPart part : source.getParts()) {
			copyAndAppend(part);
		}
		return region;
	}

	public void copyAndAppend(IHiddenRegion region, HiddenRegionPartAssociation association) {
		for (IHiddenRegionPart part : region.getParts()) {
			if (part.getAssociation() == association) {
				copyAndAppend(part);
			}
		}
	}

	public IHiddenRegionPart copyAndAppend(IHiddenRegionPart part) {
		StringHiddenRegion region;
		if (this.last instanceof StringHiddenRegion) {
			region = (StringHiddenRegion) this.last;
		} else {
			region = appendHiddenRegion(true);
		}
		String text = part.getText();
		int offset = result.append(text);
		if (part instanceof IComment) {
			IComment comment = ((IComment) part);
			AbstractRule grammarElement = (AbstractRule) comment.getGrammarElement();
			StringComment newComment = new StringComment(region, grammarElement, offset, text.length());
			region.addPart(newComment);
			recordDiff(part, newComment);
			return newComment;
		} else if (part instanceof IWhitespace) {
			IWhitespace ws = (IWhitespace) part;
			AbstractRule grammarElement = (AbstractRule) ws.getGrammarElement();
			StringWhitespace newWs = new StringWhitespace(region, grammarElement, offset, text.length());
			region.addPart(newWs);
			recordDiff(part, newWs);
			return newWs;
		}
		throw new IllegalStateException();
	}

	protected ISemanticRegion copyAndAppend(ISemanticRegion source) {
		StringHiddenRegion hidden = (StringHiddenRegion) this.last;
		EObject semanticElement = source.getSemanticElement();
		AbstractEObjectRegion region = getOrCreateEObjectRegion(semanticElement, source.getEObjectRegion(), null);
		String changedText = textChanges.get(source);
		String newText = changedText != null ? changedText : source.getText();
		int offset = result.append(newText);
		EObject grammar = source.getGrammarElement();
		StringSemanticRegion result = new StringSemanticRegion(this.result, region, grammar, offset, newText.length());
		region.addChild(result);
		hidden.setNext(result);
		result.setLeadingHiddenRegion(hidden);
		this.last = result;
		recordDiff(source, result);
		if (changedText != null && this.diffNesting == 0) {
			this.result.append(new SequentialRegionDiff(source, source, result, result));
		}
		return result;
	}

	public void copyAndAppend(ISemanticRegion substituteFirst, ISemanticRegion substituteLast) {
		if (!(this.last instanceof StringHiddenRegion)) {
			appendHiddenRegion(true);
		}
		ISequentialRegion current = substituteFirst;
		while (true) {
			if (current instanceof IHiddenRegion) {
				copyAndAppend((IHiddenRegion) current);
			} else if (current instanceof ISemanticRegion) {
				copyAndAppend((ISemanticRegion) current);
			}
			if (current == substituteLast) {
				break;
			}
			current = current.getNextSequentialRegion();
			if (current == null) {
				throw new IllegalStateException("last didn't match");
			}
		}
	}

	public void endDiff() {
		diffNesting--;
	}

	public StringBasedTextRegionAccessDiff finish() {
		if (this.last instanceof ISemanticRegion) {
			appendHiddenRegion(false);
		}
		updateEObjectRegions();
		if (diffFirstOriginal != null && diffFirstCopy != null) {
			IHiddenRegion orig = result.getOriginalTextRegionAccess().regionForRootEObject().getNextHiddenRegion();
			result.append(new SequentialRegionDiff(diffFirstOriginal, orig, diffFirstCopy, this.last));
			diffFirstCopy = null;
			diffFirstOriginal = null;
		}
		return result;
	}

	protected AbstractEObjectRegion getOrCreateEObjectRegion(EObject eobj, IEObjectRegion original,
			ITextRegionAccess access) {
		AbstractEObjectRegion eobjRegion = result.regionForEObject(eobj);
		if (eobjRegion == null) {
			if (access == null) {
				access = result.getOriginalTextRegionAccess();
			}
			if (original == null) {
				original = access.regionForEObject(eobj);
			}
			if (original != null) {
				eobjRegion = new StringEObjectRegion(result, original.getGrammarElement(), eobj);
				result.add(eobjRegion);
				AbstractEObjectRegion parent = getOrCreateEObjectRegion(eobj.eContainer(), null,
						original.getTextRegionAccess());
				if (parent != null) {
					parent.addChild(eobjRegion);
				}
			}
		}
		return eobjRegion;
	}

	protected void recordDiff(ITextSegment original, ITextSegment copy) {
		if (diffNesting == 0) {
			Preconditions.checkArgument(original.getTextRegionAccess() == result.getOriginalTextRegionAccess());
		}
		if (diffFirstOriginal != null && diffFirstCopy != null && diffNesting == 0) {
			result.append(new SequentialRegionDiff(diffFirstOriginal, original, diffFirstCopy, copy));
			diffFirstCopy = null;
			diffFirstOriginal = null;
		}
		diffLastOriginal = original;
		diffLastCopy = copy;
	}

	protected void updateEObjectRegions() {
		ISemanticRegion current = this.last.getPreviousSemanticRegion();
		while (true) {
			ISemanticRegion sem = (ISemanticRegion) current;
			EObject eobj = sem.getSemanticElement();
			IHiddenRegion nextHiddenRegion = sem.getNextHiddenRegion();
			while (eobj != null) {
				AbstractEObjectRegion eobjRegion = getOrCreateEObjectRegion(eobj, null, null);
				if (eobjRegion.getNextHiddenRegion() != null) {
					break;
				}
				eobjRegion.setTrailingHiddenRegion(nextHiddenRegion);
				eobj = eobj.eContainer();
			}
			ISemanticRegion prev = sem.getPreviousSemanticRegion();
			if (prev == null) {
				break;
			} else {
				current = prev;
			}
		}
		while (true) {
			ISemanticRegion sem = (ISemanticRegion) current;
			EObject eobj = sem.getSemanticElement();
			IHiddenRegion previousHiddenRegion = sem.getPreviousHiddenRegion();
			while (eobj != null) {
				AbstractEObjectRegion eobjRegion = result.regionForEObject(eobj);
				if (eobjRegion.getPreviousHiddenRegion() != null) {
					break;
				}
				eobjRegion.setLeadingHiddenRegion(previousHiddenRegion);
				eobj = eobj.eContainer();
			}
			ISemanticRegion next = sem.getNextSemanticRegion();
			if (next == null) {
				break;
			} else {
				current = next;
			}
		}
	}

}