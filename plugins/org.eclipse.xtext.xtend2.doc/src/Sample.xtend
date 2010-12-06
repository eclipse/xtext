package foo.bar;

import java.util.List;
import my.special.Service;
import extension java.util.Collections.(singleton, reverse);

inject extension @SpecialService Service.(myFunction);

class Foo {
	
	qualifiedName(Entity this) :
		package.name+"."+name;
	
}
	
	
	main(Entity this) """
		«IF foo»
			foo «name»
		«ELSEIF bar»
			bar «name»
		«ELSE»
			«FOREACH bazzs AS b ITERATOR iter»
				bazz«iter.counter» «name»
			«ENDFOREACH»
		«ENDIF»
	"""
}