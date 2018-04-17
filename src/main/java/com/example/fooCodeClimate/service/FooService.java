package com.example.fooCodeClimate.service;

public interface FooService {

    public int bad( int n );

    public int f( int x );

    public void printDigit( int n );

    public void printOut( int n );

    public <AnyType extends Comparable<? super AnyType>> int binarySearch( AnyType [ ] a, AnyType x );
}
