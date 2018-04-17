package com.example.fooCodeClimate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService{

    private final Logger logger = LoggerFactory.getLogger(FooService.class);

    @Override
    public void blockerSonarBug() {
        int j = 0;
        while (true) { // Noncompliant; end condition omitted
            j++;
        }
    }

    @Override
    public void majorSonarBug() {
        boolean a = false;
        boolean b = true;
        if (a) { // Noncompliant
            logger.info("Noncompliant");
        }

        if (!a || b) { // Noncompliant; "!a" is always "true", "b" is never evaluated
            logger.info("Noncompliant");
        } else {
            logger.info("never executed"); // never executed
        }
    }

    public int bad(int n )
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
        logger.info( String.valueOf(n) );
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

    public int [ ][ ] multiply( int [ ][ ] a, int [ ][ ] b )
    {
        int n = a.length;
        int [ ][ ] c = new int[ n ][ n ];

        for( int i = 0; i < n; i++ )    // Initialization
            for( int j = 0; j < n; j++ )
                c[ i ][ j ] = 0;

        for( int i = 0; i < n; i++ )
            for( int j = 0; j < n; j++ )
                for( int k = 0; k < n; k++ )
                    c[ i ][ j ] += a[ i ][ k ] * b[ k ][ j ];

        return c;
    }

    public int fibonacci( int n )
    {
        if( n <= 1 )
            return 1;

        int last = 1;
        int nextToLast = 1;
        int answer = 1;
        for( int i = 2; i <= n; i++ )
        {
            answer = last + nextToLast;
            nextToLast = last;
            last = answer;
        }
        return answer;
    }

    public double eval( int n )
    {
        if( n == 0 )
            return 1.0;
        else
        {
            double sum = 0.0;
            for( int i = 0; i < n; i++ )
                sum += eval( i );
            return 2.0 * sum / n + n;
        }
    }

    public double eval2( int n )
    {
        double [ ] c = new double [ n + 1 ];

        c[ 0 ] = 1.0;
        for( int i = 1; i <= n; i++ )
        {
            double sum = 0.0;
            for( int j = 0; j < i; j++ )
                sum += c[ j ];
            c[ i ] =  2.0 * sum / i + i;
        }

        return c[ n ];
    }

    public void optMatrix( int [ ] c, long [ ][ ] m, int [ ][ ] lastChange )
    {
        int n = c.length - 1;

        for( int left = 1; left <= n; left++ )
            m[ left ][ left ] = 0;
        for( int k = 1; k < n; k++ )   // k is right - left
            for( int left = 1; left <= n - k; left++ )
            {
                // For each position
                int right = left + k;
                m[ left ][ right ] = Integer.MAX_VALUE;
                for( int i = left; i < right; i++ )
                {
                    long thisCost = m[ left ][  i ] + m[ i + 1 ][ right ]
                            + c[ left - 1 ] * c[ i ] * c[ right ];
                    if( thisCost < m[ left ][ right ] )  // Update min
                    {
                        m[ left ][ right ] = thisCost;
                        lastChange[ left ][ right ] = i;
                    }
                }
            }
    }
}
