package org.eclipse.xpect.tests.xjm;

import org.eclipse.xpect.tests.xjm.AbstractXjmTest;
import org.eclipse.xpect.tests.xjm.AnnotationType;
import org.eclipse.xpect.tests.xjm.MethodAnnotation;
import org.eclipse.xpect.tests.xjm.MethodType;
import org.eclipse.xpect.tests.xjm.Replacement1;
import org.eclipse.xpect.tests.xjm.Replacement2;
import org.eclipse.xpect.tests.xjm.Simple1;
import org.eclipse.xpect.tests.xjm.TransitiveImport;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XjmContributionsTest extends AbstractXjmTest {
  @Test
  public void simple() {
    this.assertXjm(Simple1.class);
  }
  
  @Test
  public void transitiveImport() {
    this.assertXjm(TransitiveImport.class);
  }
  
  @Test
  public void methodType() {
    this.assertXjm(MethodType.class);
  }
  
  @Test
  public void methodAnnotation() {
    this.assertXjm(MethodAnnotation.class);
  }
  
  @Ignore
  @Test
  public void annotationType() {
    this.assertXjm(AnnotationType.class);
  }
  
  @Test
  public void replace1() {
    this.assertXjm(Replacement1.class);
  }
  
  @Test
  public void replace2() {
    this.assertXjm(Replacement2.class);
  }
}
