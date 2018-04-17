package com.example.fooCodeClimate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService{

    private final Logger logger = LoggerFactory.getLogger(FooService.class);

    public int bad( int n )
    {
        if( n == 0 )
            return 0;
        else
            return bad( n / 3 + 1 ) + n - 1;
    }

    public int f( int x )
    {
        if( x == 0 )
            return 0;
        else
            return 2 * f( x - 1 ) + x * x;
    }

    public void printDigit( int n )
    {
        System.out.print( n );
    }

    public void printOut( int n )  /* Print nonnegative n */
    {
        if( n >= 10 )
            printOut( n / 10 );
        printDigit( n % 10 );
    }

    public <AnyType extends Comparable<? super AnyType>>
    int binarySearch( AnyType [ ] a, AnyType x )
    {
        int low = 0, high = a.length - 1;

        while( low <= high )
        {
            int mid = ( low + high ) / 2;

            if( a[ mid ].compareTo( x ) < 0 )
                low = mid + 1;
            else if( a[ mid ].compareTo( x ) > 0 )
                high = mid - 1;
            else
                return mid;   // Found
        }
        return -1;
    }
}
