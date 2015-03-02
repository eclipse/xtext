package org.eclipse.xtext.parser.unorderedGroups;

import com.google.common.io.CharStreams;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.lang.XtextLanguage;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.unorderedGroups.MetamodelTransformationTest;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Ignore;

@Ignore
@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeaMetamodelTransformationTestDelegate extends MetamodelTransformationTest {
  private final ModelChecker modelChecker;
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    Injector _instance = XtextLanguage.INSTANCE.<Injector>getInstance(Injector.class);
    this.setInjector(_instance);
  }
  
  @Override
  protected XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
    InputStreamReader _inputStreamReader = new InputStreamReader(in);
    String _string = CharStreams.toString(_inputStreamReader);
    EObject _checkModel = this.modelChecker.<EObject>checkModel(_string, false);
    Resource _eResource = _checkModel.eResource();
    return ((XtextResource) _eResource);
  }
  
  public IdeaMetamodelTransformationTestDelegate(final ModelChecker modelChecker) {
    super();
    this.modelChecker = modelChecker;
  }
}
