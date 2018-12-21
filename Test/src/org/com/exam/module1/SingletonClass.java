package org.com.exam.module1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonClass implements Serializable, Cloneable {

	private static volatile SingletonClass singletonClass = null;

	private SingletonClass() {
		if (singletonClass != null) {
		      throw new IllegalStateException("instance already created.");
		    }
		    System.out.println("Singleton instance is being created.");
	}

	public static SingletonClass getInstance() {
		if (singletonClass == null) {
			synchronized (SingletonClass.class) {
				if (singletonClass == null) {
					singletonClass = new SingletonClass();
					return singletonClass;
				}
			}
		}
		return singletonClass;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public Object readResolve() {
		return singletonClass;
	}

	public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException, IOException,
			ClassNotFoundException, SecurityException, NoSuchFieldException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		SingletonClass instanceReflection = new SingletonClass().getInstance();
		SingletonClass instanceReflection2 = null;
		
		// this is for immutability break through reflection
		instanceReflection.getClass().getDeclaredField("singletonClass").setAccessible(true);

		// this is for singleton pattern break through reflection
		Constructor<?>[] s = instanceReflection.getClass().getDeclaredConstructors();
		for (Constructor<?> s1 : s) {
			s1.setAccessible(true);
			instanceReflection2 = (SingletonClass) s1.newInstance();
		}
		System.out.println("instanceReflection.hashCode():- " + instanceReflection.hashCode());
		System.out.println("instanceReflection2.hashCode():- " + instanceReflection2.hashCode());

		SingletonClass instanceSerialization = new SingletonClass().getInstance();

		System.out.println("instanceSerial hashCode:- " + instanceSerialization.hashCode());

		// serialization
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
		out.writeObject(instanceSerialization);
		out.close();

		ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
		SingletonClass instanceSerial2 = (SingletonClass) in.readObject();
		in.close();

		System.out.println("instanceSerial2 hashCode:- " + instanceSerial2.hashCode());

		SingletonClass instanceClone = SingletonClass.getInstance();
		System.out.println("instanceClone hashCode:- " + instanceClone.hashCode());
		
		SingletonClass instanceClone2 = (SingletonClass) instanceClone.clone();
		System.out.println("instanceClone2 hashCode:- " + instanceClone2.hashCode());
	}

}
