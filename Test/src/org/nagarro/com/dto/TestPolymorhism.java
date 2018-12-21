package org.nagarro.com.dto;

import java.io.IOException;

public class TestPolymorhism {

	public static void main(String[] args) throws Exception {
		Parent parent = new Child();
		parent.getSomething(); // the instance members get invoked on the basis of the runtime object
		parent.getStaticSomething(); // the static members get invoked on the basis of the reference type
		parent.eatPublicly();
		
		
		Child child = (Child) parent; // Down casting parent to child
		System.out.println(child.overloadFunction("chetan"));
		
		Parent newParent = new Parent();
		
		// Explicit down casting should be used with caution
		//because it will compile but throw ClassCastException 
		// because compiler can do is verify that the two types are in the same inheritance tree, 
		//so that depending on whatever code might have come before the downcast, 
		//it's possible that newParent is of type Child
		
		Child newChild = (Child) newParent;
		newChild.notPresentInParent();
		
		// the two types are in the same inheritance tree,then only down casting work
		// String s = (String) newParent;

		// Methods present in child wont be accessible from parent if we type cast to parent explicitly
		//((Parent)new Child()).presentOnlyInChild();
		
		// You can't cast parent to child, it will throw ClassCastException
		Child child2 = (Child) new Parent();
	}

}
