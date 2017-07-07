/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPartMerger;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringBasedTextRegionAccessDiffAppender {
	private StringBasedTextRegionAccessDiff access;
	private IHiddenRegionPartMerger hiddenRegionMerger;
	private ISequentialRegion last;

	public StringBasedTextRegionAccessDiffAppender(StringBasedTextRegionAccessDiff access) {
		super();
		this.access = access;
		this.hiddenRegionMerger = access.getResource().getResourceServiceProvider().get(IHiddenRegionPartMerger.class);
	}

	protected StringHiddenRegion appendHiddenRegion(boolean undefined) {
		if (this.last instanceof StringHiddenRegion) {
			StringHiddenRegion result = (StringHiddenRegion) this.last;
			result.setUndefined(result.isUndefined() || undefined);
			return result;
		}
		StringSemanticRegion previous = (StringSemanticRegion) this.last;
		StringHiddenRegion region = new StringHiddenRegion(access);
		if (previous != null) {
			previous.setTrailingHiddenRegion(region);
			region.setPrevious(previous);
		}
		region.setUndefined(undefined);
		this.last = region;
		return region;
	}

	protected IHiddenRegion copyAndAppend(IHiddenRegion source) {
		ISequentialRegion last2 = this.last;
		StringHiddenRegion region = appendHiddenRegion(source.isUndefined());
		List<IHiddenRegionPart> parts;
		if (region == last2) {
			parts = hiddenRegionMerger.merge(access.getOriginalTextRegionAccess(), region, source, false);
		} else {
			parts = source.getParts();
		}
		copyHiddenRegionParts(region, parts);
		return region;
	}

	protected IHiddenRegion copyAndAppend(IHiddenRegion region1, IHiddenRegion region2) {
		StringHiddenRegion region = appendHiddenRegion(region1.isUndefined() || region2.isUndefined());
		ITextRegionAccess original = access.getOriginalTextRegionAccess();
		List<IHiddenRegionPart> merged = hiddenRegionMerger.merge(original, region1, region2, false);
		copyHiddenRegionParts(region, merged);
		return region;
	}

	public SequentialRegionDiff copyAndAppend(IHiddenRegion originalFirst, IHiddenRegion originalLast,
			IHiddenRegion substituteFirst, IHiddenRegion substituteLast) {
		if (substituteFirst == substituteLast) {
			return copySurroundingHidden(originalFirst, originalLast, true);
		}
		IHiddenRegion first = copyAndAppend(originalFirst, substituteFirst);
		ISemanticRegion firstSem = substituteFirst.getNextSemanticRegion();
		ISemanticRegion lastSem = substituteLast.getPreviousSemanticRegion();
		copyAndAppend(firstSem, lastSem);
		IHiddenRegion last = copyAndAppend(substituteLast, originalLast);
		return new SequentialRegionDiff(originalFirst, originalLast, first, last);
	}

	public ISemanticRegion copyAndAppend(ISemanticRegion source, String text) {
		if (this.last instanceof StringSemanticRegion) {
			appendHiddenRegion(true);
		}
		EObject semanticElement = source.getSemanticElement();
		AbstractEObjectRegion region = access.regionForEObject(semanticElement);
		if (region == null) {
			IEObjectRegion region2 = source.getEObjectRegion();
			region = new StringEObjectRegion(access, region2.getGrammarElement(), semanticElement);
			access.add(region);
		}
		int offset = access.append(text);
		AbstractElement grammar = (AbstractElement) source.getGrammarElement();
		StringHiddenRegion previous = (StringHiddenRegion) this.last;
		StringSemanticRegion result = new StringSemanticRegion(access, region, grammar, offset, text.length());
		region.getSemanticRegions().add(result);
		previous.setNext(result);
		result.setLeadingHiddenRegion(previous);
		this.last = result;
		return result;
	}

	protected ISequentialRegion copyAndAppend(ISequentialRegion first, ISequentialRegion last) {
		ISequentialRegion current = first;
		ISequentialRegion result = null;
		while (true) {
			if (current instanceof IHiddenRegion) {
				copyAndAppend((IHiddenRegion) current);
			} else if (current instanceof ISemanticRegion) {
				copyAndAppend((ISemanticRegion) current, current.getText());
			}
			if (result == null) {
				result = this.last;
			}
			if (current == last) {
				break;
			}
			current = current.getNextSequentialRegion();
			if (current == null) {
				throw new IllegalStateException("last didn't match");
			}
		}
		return result;
	}

	protected void copyHiddenRegionParts(StringHiddenRegion region, Iterable<IHiddenRegionPart> parts) {
		for (IHiddenRegionPart part : parts) {
			String text = part.getText();
			int offset = access.append(text);
			if (part instanceof IComment) {
				IComment comment = ((IComment) part);
				AbstractRule grammarElement = (AbstractRule) comment.getGrammarElement();
				StringComment newComment = new StringComment(region, grammarElement, offset, text.length());
				region.addPart(newComment);
			} else if (part instanceof IWhitespace) {
				IWhitespace ws = (IWhitespace) part;
				AbstractRule grammarElement = (AbstractRule) ws.getGrammarElement();
				StringWhitespace newWs = new StringWhitespace(region, grammarElement, offset, text.length());
				region.addPart(newWs);
			}
		}
	}

	public SequentialRegionDiff copySurroundingHidden(ISequentialRegion originalFirst, ISequentialRegion originalLast,
			boolean delete) {
		boolean firstHidden = originalFirst instanceof IHiddenRegion;
		boolean lastHidden = originalLast instanceof IHiddenRegion;
		if (firstHidden && lastHidden) {
			IHiddenRegion hiddenFirst = (IHiddenRegion) originalFirst;
			IHiddenRegion hiddenLast = (IHiddenRegion) originalLast;
			StringHiddenRegion merged = appendHiddenRegion(hiddenFirst.isUndefined() || hiddenLast.isUndefined());
			ITextRegionAccess original = access.getOriginalTextRegionAccess();
			List<IHiddenRegionPart> parts = hiddenRegionMerger.merge(original, hiddenFirst, hiddenLast, delete);
			copyHiddenRegionParts(merged, parts);
			return new SequentialRegionDiff(originalFirst, originalLast, merged, merged);
		}
		IHiddenRegion inserted = null;
		if (originalFirst == null) {
			if (!lastHidden) {
				inserted = appendHiddenRegion(true);
			}
		} else if (originalLast == null) {
			if (!firstHidden) {
				inserted = appendHiddenRegion(true);
			}
		} else if (!firstHidden && !lastHidden) {
			inserted = appendHiddenRegion(true);
		}
		return new SequentialRegionDiff(originalFirst, originalLast, inserted, inserted);
	}

	public IHiddenRegionPartMerger getHiddenRegionMerger() {
		return hiddenRegionMerger;
	}

	public StringBasedTextRegionAccessDiff getRectionAccessDiff() {
		return access;
	}

	protected void updateEObjectRegions() {
		ISemanticRegion current = this.last.getPreviousSemanticRegion();
		while (true) {
			ISemanticRegion sem = (ISemanticRegion) current;
			EObject eobj = sem.getSemanticElement();
			IHiddenRegion nextHiddenRegion = sem.getNextHiddenRegion();
			while (eobj != null) {
				AbstractEObjectRegion eobjRegion = access.regionForEObject(eobj);
				if (eobjRegion == null) {
					IEObjectRegion original = access.getOriginalTextRegionAccess().regionForEObject(eobj);
					if (original != null) {
						eobjRegion = new StringEObjectRegion(access, original.getGrammarElement(), eobj);
						access.add(eobjRegion);
					} else {
						throw new IllegalStateException();
					}
				}
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
				AbstractEObjectRegion eobjRegion = access.regionForEObject(eobj);
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