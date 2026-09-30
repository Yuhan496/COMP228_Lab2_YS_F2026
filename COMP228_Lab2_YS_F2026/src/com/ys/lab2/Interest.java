package com.ys.lab2;

import java.math.BigDecimal;
import java.math.MathContext;

public class Interest {
	
	//Attributes
	private BigDecimal principal;
	private BigDecimal rate;
	private int time;
	
	//Constructor
	public Interest (BigDecimal principal, BigDecimal rate, int time) {
		
		//validation 
		if (principal == null || principal.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Invalid principal.");
		}
		
        if (rate == null || rate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid rate.");
        }

        if (time < 0) { 
            throw new IllegalArgumentException("Invalid time.");
        }
        
        this.principal = principal;
        this.rate = rate;
        this.time = time;
	}
	
	//method for calculating SI
	public BigDecimal calculateSimpleInterest(BigDecimal principal, BigDecimal rate, int time) 
	{
		return  principal.multiply(rate)
                .multiply(BigDecimal.valueOf(time))
                .divide(BigDecimal.valueOf(100));
	}
	
	//overloading method for calculating SI
	public Double calculateSimpleInterest(Double principal, Double rate, int time) {
		return (principal * rate * time) / 100;
	}
	
	//method for calculating compound interest
    public BigDecimal calculateCompoundInterest(BigDecimal principal, BigDecimal rate, int time)
    {
        BigDecimal hundred = BigDecimal.valueOf(100);

        BigDecimal rateDecimal =
                rate.divide(hundred, MathContext.DECIMAL64);

        BigDecimal factor =
                BigDecimal.ONE.add(rateDecimal);

        BigDecimal total =
                principal.multiply(factor.pow(time, MathContext.DECIMAL64));
        return total.subtract(principal);
    }
    
    //overloading method for calculating compound interest
    public Double calculateCompoundInterest(Double principal, Double rate, int time) {
        return principal * Math.pow(1 + rate / 100, time) - principal;
    }
	
    //getter methods
    public BigDecimal getPrincipal() {
        return principal;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public int getTime() {
        return time;
    }
}