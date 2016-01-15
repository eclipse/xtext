package org.eclipse.xpect.tests.xjm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.tests.xjm.Contribution1;

@Retention(RetentionPolicy.RUNTIME)
@XpectImport(Contribution1.class)
public @interface AnnotationWithImport {
}
