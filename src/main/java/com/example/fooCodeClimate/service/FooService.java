package com.example.fooCodeClimate.service;

public interface FooService {

    public int bad( int n );

    public int f( int x );

    public void printDigit( int n );

    public void printOut( int n );

    public <AnyType extends Comparable<? super AnyType>> int binarySearch( AnyType [ ] a, AnyType x );

    public int [ ][ ] multiply( int [ ][ ] a, int [ ][ ] b );

    public int fibonacci( int n );

    public double eval( int n );

    public double eval2( int n );

    public void optMatrix( int [ ] c, long [ ][ ] m, int [ ][ ] lastChange );
}
