/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.imports;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.intellij.lang.ImportOptimizer;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.EmptyRunnable;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import java.util.List;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.imports.ImportOrganizer;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XImportSectionOptimizer implements ImportOptimizer {
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageId;
  
  @Inject
  private ImportOrganizer importOrganizer;
  
  @Override
  public Runnable processFile(final PsiFile file) {
    if ((file instanceof BaseXtextFile)) {
      XtextResource _resource = ((BaseXtextFile)file).getResource();
      List<ReplaceRegion> _organizedImportChanges = this.importOrganizer.getOrganizedImportChanges(_resource);
      final Function1<ReplaceRegion, Integer> _function = new Function1<ReplaceRegion, Integer>() {
        @Override
        public Integer apply(final ReplaceRegion it) {
          int _offset = it.getOffset();
          return Integer.valueOf((_offset * (-1)));
        }
      };
      final List<ReplaceRegion> changes = IterableExtensions.<ReplaceRegion, Integer>sortBy(_organizedImportChanges, _function);
      final Runnable _function_1 = new Runnable() {
        @Override
        public void run() {
          Project _project = ((BaseXtextFile)file).getProject();
          PsiDocumentManager _instance = PsiDocumentManager.getInstance(_project);
          final Document document = _instance.getDocument(file);
          for (final ReplaceRegion change : changes) {
            int _offset = change.getOffset();
            int _endOffset = change.getEndOffset();
            String _text = change.getText();
            document.replaceString(_offset, _endOffset, _text);
          }
        }
      };
      return _function_1;
    } else {
      return EmptyRunnable.INSTANCE;
    }
  }
  
  @Override
  public boolean supports(final PsiFile file) {
    Language _language = file.getLanguage();
    String _iD = _language.getID();
    return Objects.equal(this.languageId, _iD);
  }
}
