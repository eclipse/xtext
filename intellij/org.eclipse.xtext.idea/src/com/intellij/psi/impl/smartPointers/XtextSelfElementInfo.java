/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.intellij.psi.impl.smartPointers;

import java.util.List;

import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.lang.Language;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.impl.FrozenDocument;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.NullableComputable;
import com.intellij.openapi.util.ProperTextRange;
import com.intellij.openapi.util.Segment;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.SmartPointerManager;
import com.intellij.psi.impl.PsiDocumentManagerBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.util.PsiTreeUtil;

/**
 * @see SelfElementInfo An intitially copied class
 * 
 * @author kosyakov - Initial contribution and API
 */
public class XtextSelfElementInfo extends SmartPointerElementInfo {
  private static final FileDocumentManager ourFileDocManager = FileDocumentManager.getInstance();
  protected volatile IElementType myType;
  private final SmartPointerManagerImpl myManager;
  protected final Language myLanguage;
  private final MarkerCache myMarkerCache;
  private final boolean myForInjected;
  private boolean myHasRange;
  private int myStartOffset;
  private int myEndOffset;

  XtextSelfElementInfo(@NotNull Project project,
                  @NotNull ProperTextRange range,
                  @NotNull IElementType anchorClass,
                  @NotNull PsiFile containingFile,
                  @NotNull Language language,
                  boolean forInjected) {
    myLanguage = language;
    myForInjected = forInjected;
    myType = anchorClass;
    assert !(anchorClass instanceof IFileElementType) : "FileElementInfo must be used for files";

    myManager = (SmartPointerManagerImpl)SmartPointerManager.getInstance(project);
    myMarkerCache = myManager.getMarkerCache(containingFile.getViewProvider().getVirtualFile());
    setRange(range);
  }

  void setRange(@Nullable Segment range) {
    if (range != null) {
      myHasRange = true;
      myStartOffset = range.getStartOffset();
      myEndOffset = range.getEndOffset();
      myMarkerCache.rangeChanged(markerCacheKey());
    } else {
      myHasRange = false;
    }
  }

  long markerCacheKey() {
    if (!myHasRange) return 0;

    long start = myStartOffset;
    assert start >= 0;
    assert start < Integer.MAX_VALUE;

    long packed = (start + 1) | ((long)myEndOffset << 32);
    assert packed > 0;
    assert packed != Long.MIN_VALUE;

    long result = myForInjected ? -packed : packed;
    assert result != 0;
    return result;
  }


  boolean isForInjected() {
    return myForInjected;
  }

  @Override
  public Document getDocumentToSynchronize() {
    return ourFileDocManager.getCachedDocument(getVirtualFile());
  }

  @Override
  public PsiElement restoreElement() {
    Segment segment = getPsiRange();
    if (segment == null) return null;

    PsiFile file = restoreFile();
    if (file == null || !file.isValid()) return null;

    return findElementInside(file, segment.getStartOffset(), segment.getEndOffset(), myType, myLanguage);
  }

  @Nullable
  @Override
  public ProperTextRange getPsiRange() {
    return calcPsiRange();
  }

  @Nullable
  private ProperTextRange calcPsiRange() {
    return myHasRange ? ProperTextRange.create(myStartOffset, myEndOffset) : null;
  }

  @Override
  public PsiFile restoreFile() {
    return restoreFileFromVirtual(getVirtualFile(), getProject(), myLanguage);
  }

  public static PsiElement findElementInside(@NotNull PsiFile file,
                                      int syncStartOffset,
                                      int syncEndOffset,
                                      @NotNull IElementType type,
                                      @NotNull Language language) {
    PsiElement anchor = file.getViewProvider().findElementAt(syncStartOffset, language);
    if (anchor == null && syncStartOffset == file.getTextLength()) {
      PsiElement lastChild = file.getViewProvider().getPsi(language).getLastChild();
      if (lastChild != null) {
        anchor = PsiTreeUtil.getDeepestLast(lastChild);
      }
    }
    if (anchor == null) return null;

    PsiElement result = findParent(syncStartOffset, syncEndOffset, type, anchor);
    if (syncEndOffset == syncStartOffset) {
      while (result == null && anchor.getTextRange().getStartOffset() == syncEndOffset) {
        anchor = PsiTreeUtil.prevLeaf(anchor, false);
        if (anchor == null) break;

        result = findParent(syncStartOffset, syncEndOffset, type, anchor);
      }
    }
    return result;
  }

  @Nullable
  private static PsiElement findParent(int syncStartOffset, int syncEndOffset, @NotNull IElementType type, PsiElement anchor) {
    TextRange range = anchor.getTextRange();

    if (range.getStartOffset() != syncStartOffset) return null;
    while (range.getEndOffset() < syncEndOffset) {
      anchor = anchor.getParent();
      if (anchor == null || anchor.getTextRange() == null) break;
      range = anchor.getTextRange();
    }

    while (range.getEndOffset() == syncEndOffset && anchor != null && !type.equals(getElementType(anchor))) {
      anchor = anchor.getParent();
      if (anchor == null || anchor.getTextRange() == null) break;
      range = anchor.getTextRange();
    }

    return range.getEndOffset() == syncEndOffset ? anchor : null;
  }

	private static IElementType getElementType(PsiElement anchor) {
		if (anchor instanceof PsiEObjectImpl) {
			return ((PsiEObjectImpl) anchor).getElementType();
		}
		return null;
	}

  @Override
  public void cleanup() {
    myHasRange = false;
  }

  @Nullable
  public static PsiFile restoreFileFromVirtual(@NotNull final VirtualFile virtualFile, @NotNull final Project project, @Nullable final Language language) {
	  return SelfElementInfo.restoreFileFromVirtual(virtualFile, project, language);
  }

  @Nullable
  public static PsiDirectory restoreDirectoryFromVirtual(final VirtualFile virtualFile, @NotNull final Project project) {
	  return SelfElementInfo.restoreDirectoryFromVirtual(virtualFile, project);
  }

  @Override
  public int elementHashCode() {
    return getVirtualFile().hashCode();
  }

  @Override
  public boolean pointsToTheSameElementAs(@NotNull final SmartPointerElementInfo other) {
    if (other instanceof XtextSelfElementInfo) {
    XtextSelfElementInfo otherInfo = (XtextSelfElementInfo)other;
      Segment range1 = getPsiRange();
      Segment range2 = otherInfo.getPsiRange();
      return Comparing.equal(getVirtualFile(), otherInfo.getVirtualFile())
             && myType == otherInfo.myType
             && range1 != null
             && range2 != null
             && range1.getStartOffset() == range2.getStartOffset()
             && range1.getEndOffset() == range2.getEndOffset()
        ;
    }
    return ApplicationManager.getApplication().runReadAction(new Computable<Boolean>() {
      @Override
      public Boolean compute() {
        return Comparing.equal(restoreElement(), other.restoreElement());
      }
    });
  }

  @Override
  @NotNull
  public final VirtualFile getVirtualFile() {
    return myMarkerCache.getVirtualFile();
  }

  @Override
  @Nullable
  public Segment getRange() {
    if (myHasRange) {
      Document document = getDocumentToSynchronize();
      if (document != null) {
        PsiDocumentManagerBase documentManager = myManager.getPsiDocumentManager();
        List<DocumentEvent> events = documentManager.getEventsSinceCommit(document);
        if (!events.isEmpty()) {
          return myMarkerCache.getUpdatedRange(markerCacheKey(), (FrozenDocument)documentManager.getLastCommittedDocument(document), events);
        }
      }
    }
    return calcPsiRange();
  }

  @NotNull
  @Override
  public final Project getProject() {
    return myManager.getProject();
  }

}
