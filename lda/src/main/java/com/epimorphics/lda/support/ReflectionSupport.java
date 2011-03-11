/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) Copyright 2011 Epimorphics Limited
    $Id$
*/
package com.epimorphics.lda.support;

import com.hp.hpl.jena.shared.NotFoundException;

/**
    Versions of Class.forName and Class.newInstance that turn checked
    exceptions into unchecked ones.

	@author eh
*/
public class ReflectionSupport {

	/**
	 	Answer the class with the given name, or throw a NotFoundException
	 	if there's no such class.
	*/
	public static Class<?> classForName( String className ) {
		try { return Class.forName( className ); } 
		catch (ClassNotFoundException e) { throw new NotFoundException( className ); }
	}

	/**
	    Answer a new instance of the given class.
	*/
	public static <T> T newInstanceOf( Class<T> c ) {
		try { return c.newInstance(); } 
		catch (Exception e) { throw new RuntimeException( e ); }
	}

}