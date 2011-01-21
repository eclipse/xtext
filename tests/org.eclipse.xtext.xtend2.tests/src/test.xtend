

inject JavaBindings javaBindings;

class Foo {

	case qualifiedName(Entity this) : ----; // Java -> _qualifiedName(Entity e)
	
	case qualifiedName(Datatype this) : ----;
	
	case qualifiedName(Enum this) : ----;
}

class Foo2 extends Foo {
	override #qualifiedName(Datatype this) : super._qualifiedName(this);
	#qualifiedName(Service this) : ----;
}
	
//	qualifiedName(Type this) : throw new Error();
	  
}



class NodePrinter {
	tree(Node this) "
		node «name» {
		..if (x) {
		....«FOREACH children AS c»
		....  «FOREACH children AS c»
		....    public String foo(«c.tree»)
		....    if (y) {
		....    ..«IF X»
		....    ..  «c.tree»
		....    ..«ENDIF»
		....    }
		....  «ENDFOREACH»
		....«ENDFOREACH»
		..}
		..«IF X»
		..  «c.tree»
	    ..«ENDIF»
	    }
	"
		
   treeImpl(Node this) "   «tree»"
}

class NodePrinter {
  tree(Node this) "..node «name»"
}